package com.tatayab.presentation.splash

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.address.GetCities
import com.tatayab.domain.interactor.auth.GetUserTokenExecution
import com.tatayab.domain.interactor.auth.Login
import com.tatayab.domain.interactor.auth.Logout
import com.tatayab.domain.interactor.countries.GetCountries
import com.tatayab.domain.interactor.curriencies.GetCurrencies
import com.tatayab.domain.interactor.user.*
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserSetting
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.requests.LoginRequestBody
import com.tatayab.model.responses.*
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.Utils
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver

class SplashActivityViewModel constructor(
    private val repository: TatayabRepository,
    private val getUserSetting: GetUserSetting,
    private val getCountries: GetCountries,
    private val mGetCities: GetCities,
    private val getCurrencies: GetCurrencies,
    private val getUpgradeChecker: GetUpgradeChecker,
    private val saveUserSetting: SaveUserSetting,
    private val getCurrentUser: GetCurrentUser,
    private val mGetUserTokenExecution: GetUserTokenExecution,
    private val login: Login,
    private val mSaveUserAuth: SaveUserAuth,
    private val logout: Logout,
    private val languageCode: String
) : BaseViewModel(repository) {


    var countriesList: ArrayList<CountryResponse>? = null
    var ENABLE_GRAPH_QUERIES_CALLS = false

    private val userTokenLiveData: SingleLiveEvent<Resource<UserTokenResponse>> = SingleLiveEvent()
    private val countriesLiveData: SingleLiveEvent<Resource<List<CountryResponse>?>> =
        SingleLiveEvent()
    private val citiesLiveData = MutableLiveData<Resource<List<CityModel>>>()

    fun getCountriesLiveData(): SingleLiveEvent<Resource<List<CountryResponse>?>> {
        return countriesLiveData
    }
    private val migrationLiveData: SingleLiveEvent<Boolean> = SingleLiveEvent()

    fun getMigrationLiveData(): SingleLiveEvent<Boolean> {
        return migrationLiveData
    }

    fun getUserTokenLiveData(): SingleLiveEvent<Resource<UserTokenResponse>> {
        return userTokenLiveData
    }

    fun logout() {
         logout.execute(LogoutSubscriber())
    }

    val getCitiesLiveData: LiveData<Resource<List<CityModel>>>
        get() = citiesLiveData

    inner class LogoutSubscriber : DisposableObserver<Boolean>() {
        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            migrationLiveData.postValue(false)
        }

        override fun onNext(t: Boolean) {
            migrationLiveData.postValue(true)
        }
    }
    private val saveUserSettingLiveData = MutableLiveData<Resource<Boolean>>()
    val getSaveUserSettingLiveData: LiveData<Resource<Boolean>>
        get() = saveUserSettingLiveData


    private val currentUserLiveData = MutableLiveData<Resource<UserSetting>>()
    val getUserSettingLiveData: LiveData<Resource<UserSetting>>
        get() = currentUserLiveData

    private val checkVersionLiveData = MutableLiveData<Resource<CheckVersionResponse>>()
    val getCheckVersionLiveData: LiveData<Resource<CheckVersionResponse>>
        get() = checkVersionLiveData


    private val userLoginLiveData: SingleLiveEvent<Resource<AuthenticationResponse>> =
        SingleLiveEvent()


    fun getUserToken() {
        userTokenLiveData.postValue(Resource(ResourceState.LOADING))
        mGetUserTokenExecution.execute(
            GetUsrTokenExecutionSubscriber(),
            GetUserTokenExecution.Params.execute("android", "", Utils.DEVICE_UID)
        )
    }


    private fun loginUser(token: String) {
        login.execute(
            LoginUserSubscriber(),
            Login.Params.forUser(
                getUserEmail(),
                getUserId(),
                LoginRequestBody.LoginType.confirm_login.toString(),ENABLE_GRAPH_QUERIES_CALLS
            )
        )
    }

    inner class LoginUserSubscriber : DisposableObserver<AuthenticationResponse>() {
        override fun onNext(t: AuthenticationResponse) {
            t.let { _ ->
                userLoginLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        t
                    )
                )
            }

        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            userLoginLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }
    }


    inner class GetUsrTokenExecutionSubscriber() :
        DisposableObserver<UserTokenResponse>() {
        override fun onError(e: Throwable) {
            userTokenLiveData.postValue(Resource(ResourceState.ERROR))
        }

        override fun onNext(t: UserTokenResponse) {
            try {
                userTokenLiveData.postValue(Resource(ResourceState.SUCCESS, t))
                saveUserAuthToCacheAndConfirmLoginWithLoggedUser(t.mFirstTokenModel)
            } catch (e: Exception) {
                e.printStackTrace()
            }

        }

        override fun onComplete() {
        }
    }

    private fun saveUserAuthToCacheAndConfirmLoginWithLoggedUser(mFirstTokenModel: FirstTokenModel) {
        try {
            mFirstTokenModel?.let {
                it?.token?.let {
                    saveUserAuth(it)
                    // Confirm Login
                    if (isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                        loginUser(it)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    fun saveUserAuth(it: String) {
        try {
            mSaveUserAuth.execute(
                SaveUserAuthSubscriber(it.isEmpty()),
                SaveUserAuth.Params.forUser(
                    it, "", Utils.DEVICE_UID
                )
            )
        } catch (e: Exception) {
            println("saveUserAuthToCach/SplashVM :" + e.message)
        }
    }

    fun getCheckUpgrade(version: String) {
        checkVersionLiveData.postValue(Resource(ResourceState.LOADING))
        getUpgradeChecker.execute(GetCheckVersionSubscriber(), GetUpgradeChecker.Params(version))
    }

     fun getCountriesNeededData() {
        getCountries.execute(CountriesSubscriber(), GetCountries.Params.forCountries(languageCode))
    }

    fun getCurrentUser() {
        currentUserLiveData.postValue(Resource(ResourceState.LOADING))
        getUserSetting.execute(GetUserSettingSubscriber())
    }

    fun saveUserSetting() {
        try {
            SelectedCountry.country = countriesList?.filter {
                it.code.equals(SelectedCountry.country?.code, ignoreCase = true)
            }?.get(0)

            SelectedCountry.country?.isChecked = true

            saveUserSetting.execute(
                SaveUserSettingSubscriber(),
                SaveUserSetting.Params.forUser(
                    countryResponse = SelectedCountry.country!!
                )
            )
        } catch (e: Exception) {
            Log.d("exp", e.toString())
            saveUserSettingLiveData.postValue(
                Resource(
                    status = ResourceState.ERROR,
                    data = false
                )
            )
        }

    }


    inner class GetUserSettingSubscriber : DisposableObserver<UserSetting?>() {
        override fun onError(e: Throwable) {
            Log.d("as", e.message.toString())
            currentUserLiveData.postValue(Resource(ResourceState.ERROR))
        }

        override fun onNext(t: UserSetting) {
            if (t.country?.isChecked!!) {
                currentUserLiveData.postValue(Resource(ResourceState.SUCCESS, t))
            } else {
                currentUserLiveData.postValue(Resource(ResourceState.ERROR))
            }
        }

        override fun onComplete() {
        }
    }


    inner class GetCheckVersionSubscriber() : DisposableObserver<CheckVersionResponse>() {
        override fun onError(e: Throwable) {
            Log.d("error in check out ", e.toString())
            e is NoConnectivityException
            checkVersionLiveData.postValue(Resource(ResourceState.ERROR, message = e.message))
            getCountriesNeededData()
        }

        override fun onNext(t: CheckVersionResponse) {
            getCountriesNeededData()
            checkVersionLiveData.postValue(Resource(ResourceState.SUCCESS, t))
        }

        override fun onComplete() {
        }
    }


    inner class CountriesSubscriber() :
        DisposableObserver<ArrayList<CountryResponse>>() {
        override fun onComplete() {
        }

        override fun onNext(t: ArrayList<CountryResponse>) {
            Log.e("countries", t.toString())
            t.let { countries ->
                countriesList = countries
                if(!countries?.isNullOrEmpty()!!){
                    MemoryCacheManager.countriesList = countriesList
                }
                countriesLiveData.postValue(
                    Resource(
                        status = ResourceState.SUCCESS,
                        data = countriesList
                    )
                )
            }
        }

        override fun onError(e: Throwable) {
e.printStackTrace()
        }
    }

    inner class SaveUserSettingSubscriber : DisposableCompletableObserver() {
        override fun onComplete() {
            saveUserSettingLiveData.postValue(Resource(status = ResourceState.SUCCESS, data = true))
        }

        override fun onError(e: Throwable) {
            saveUserSettingLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }
    }

    inner class SaveUserAuthSubscriber(var isDefault: Boolean) : DisposableCompletableObserver() {
        override fun onComplete() {
            println("saveUserAuthToCach/onComplete")
//            if (isDefault && !ENABLE_GRAPH_QUERIES_CALLS)
//                getUserToken()
        }

        override fun onError(e: Throwable) {
//            if (isDefault && !ENABLE_GRAPH_QUERIES_CALLS)
//                getUserToken()

            println("saveUserAuthToCach/onError :" + e.message)
        }


    }

    private val userLiveData = MutableLiveData<Resource<AuthenticationResponse?>>()


    val getUserLiveData: LiveData<Resource<AuthenticationResponse?>>
        get() = userLiveData

    fun getUser() {
        getCurrentUser.execute(GetUserSubscriber())
    }

    inner class GetUserSubscriber : DisposableObserver<AuthenticationResponse?>() {
        override fun onError(e: Throwable) {
            userLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(t: AuthenticationResponse) {
            if (t.user_id > 0) {
                userLiveData.postValue(Resource(status = ResourceState.SUCCESS, data = t))
            } else {

                userLiveData.postValue(Resource(status = ResourceState.ERROR))
            }
        }

        override fun onComplete() {
        }

    }

    fun getCities( langcode:String,countrycode:String) {
        citiesLiveData.postValue(Resource(ResourceState.LOADING))
        mGetCities.execute(
            CitiesSubscriber(citiesLiveData),
            GetCities.Params.forAddress(
                languageCode, getCountryCode()
                //langcode,countrycode
            )
        )
    }

    inner class CitiesSubscriber(
        val citiesLiveData: MutableLiveData<Resource<List<CityModel>>>
    ) : DisposableObserver<List<CityModel>>() {
        override fun onError(e: Throwable) {
            citiesLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }

        override fun onComplete() {
        }

        override fun onNext(t: List<CityModel>) {
            citiesLiveData.postValue(Resource(ResourceState.SUCCESS, t))
        }
    }



    override fun onCleared() {
        getCountries.dispose()
        getCurrencies.dispose()
        getUserSetting.dispose()
        saveUserSetting.dispose()
        super.onCleared()
    }


}
