package com.tatayab.presentation.countries

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.cart.CreateGuestCartExecution
import com.tatayab.domain.interactor.cart.CreateUserCartExecution
import com.tatayab.domain.interactor.cart.MergeCartsExecution
import com.tatayab.domain.interactor.countries.GetCountries
import com.tatayab.domain.interactor.curriencies.GetCurrencies
import com.tatayab.domain.interactor.user.GetUserSetting
import com.tatayab.domain.interactor.user.SaveUserSetting
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserSetting
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.responses.CurrencyResponse
import com.tatayab.model.responses.graph_responses.CreateCartResponse
import com.tatayab.model.responses.graph_responses.CreateGuestCartResponse
import com.tatayab.model.responses.graph_responses.MergeCartsResponse
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.base.MemoryCacheManager

import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import java.lang.Exception
import javax.inject.Inject


class CountriesFragmentViewModel constructor(
    private val getCountries: GetCountries,
    private val getCurrencies: GetCurrencies,
    private val repository: TatayabRepository,
    private val saveUserSetting: SaveUserSetting,
    private val getUserSetting: GetUserSetting,
    private val mMergeCartsExecution: MergeCartsExecution,
    private val mCreateUserCartExecution: CreateUserCartExecution,
    private val mCreateGuestCartExecution: CreateGuestCartExecution,
    private val langCode: String
) : BaseViewModel(repository) {

    private val countriesLiveData = MutableLiveData<Resource<List<CountryResponse>>>()
    private var SearchCountriesList = ArrayList<CountryResponse>()
    private val mergeCartLiveData = MutableLiveData<Resource<Boolean>>()

    val getCountriesLiveData: LiveData<Resource<List<CountryResponse>>>
        get() = countriesLiveData

    val getMergeCartLiveData: LiveData<Resource<Boolean>>
        get() = mergeCartLiveData


    private val saveUserSettingLiveData = MutableLiveData<Resource<Boolean>>()
    val getSaveUserSettingLiveData: LiveData<Resource<Boolean>>
        get() = saveUserSettingLiveData


    var allCurrencies: ArrayList<CurrencyResponse> = ArrayList<CurrencyResponse>()
    var ENABLE_GRAPH_QUERIES_CALLS = false

    init {
        getCountries()
//        getCurrencies()
    }

    fun getCartID(): String? {
        var cartId: String? = ""
        if (isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
            cartId = repository?.getUserCartIdFromCache()?.toObservable()?.map { t: String ->
                t
            }?.blockingSingle()
            return cartId
        } else {
            cartId = repository?.getGuestCartIdFromCache()?.toObservable()?.map { t: String ->
                t
            }?.blockingSingle()
            MemoryCacheManager.setCartId(cartId)
            return cartId
        }
    }

    fun mergeCarts(currentCartID: String) {
        removeCartIDsFromCache()
        createNewCart(currentCartID)
    }

    private fun isUserLogedin() =
        !repository.getUserFromCache().toObservable().map { t -> t.token }.blockingSingle()
            .isNullOrBlank()

    private fun createNewCart(oldCartId: String) {

        var isLoggedInUser = isUserLogedin()
        if (isLoggedInUser) {
            createCartForUser(oldCartId)
        } else {
            createCartForGuest(oldCartId)
        }
    }

    fun createCartForUser(
        oldCartId: String
    ) {
        mCreateUserCartExecution.execute(
            CreateCartForUserSubscriber(oldCartId),
            CreateUserCartExecution.Params.execute(
                langCode
            )
        )
    }

    inner class CreateCartForUserSubscriber(var oldCartId: String) :
        DisposableObserver<CreateCartResponse>() {
        override fun onComplete() {

        }

        override fun onNext(t: CreateCartResponse) {
            if (t?.errorsListModel.isNullOrEmpty() && t?.data?.customerCart?.id?.isNullOrBlank()
                    ?.not() == true
            ) {
                mergeCurrentCartWithNewCart(t?.data?.customerCart?.id.toString(), oldCartId)
            } else {
                mergeCartLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        true
                    )
                )
            }
        }

        override fun onError(e: Throwable) {
            mergeCartLiveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    true
                )
            )
        }
    }

    fun createCartForGuest(
        oldCartId: String
    ) {
        mCreateGuestCartExecution.execute(
            CreateCartForGuestSubscriber(oldCartId),
            CreateGuestCartExecution.Params.execute(
                langCode
            )
        )
    }

    inner class CreateCartForGuestSubscriber(
        var oldCartId: String
    ) :
        DisposableObserver<CreateGuestCartResponse>() {
        override fun onComplete() {

        }

        override fun onNext(t: CreateGuestCartResponse) {
            if (t?.errorsListModel.isNullOrEmpty() && t?.data?.createEmptyCartID.isNullOrBlank()
                    .not()
            ) {
                MemoryCacheManager.setCartId(t?.data?.createEmptyCartID)
                t?.data?.createEmptyCartID?.let { mergeCurrentCartWithNewCart(it, oldCartId) }
            } else {
                mergeCartLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        true
                    )
                )
            }

        }

        override fun onError(e: Throwable) {
            mergeCartLiveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    true
                )
            )
        }
    }

    private fun mergeCurrentCartWithNewCart(customerCartID: String, oldCartId: String) {
        try {
            mMergeCartsExecution.execute(
                MergeCartsSubscriber(),
                MergeCartsExecution.Params.execute(
                    customerCartID, oldCartId
                )
            )

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    inner class MergeCartsSubscriber() :
        DisposableObserver<MergeCartsResponse>() {
        override fun onNext(t: MergeCartsResponse) {
            mergeCartLiveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    true
                )
            )
        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            mergeCartLiveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    true
                )
            )
        }
    }

    fun removeCartIDsFromCache() {
        repository.removeGuestCartIdToCache()
        repository.removeUserCartIdToCache()
    }

    fun getCountries() {
        countriesLiveData.postValue(Resource(ResourceState.LOADING))
        getCountries.execute(CountriesSubscriber(), GetCountries.Params.forCountries(langCode))
    }

    fun getCurrencies() {
        countriesLiveData.postValue(Resource(ResourceState.LOADING))
        getCurrencies.execute(
            CurrenciesSubscriberInCountry(allCurrencies),
            GetCurrencies.Params.forCurrency(langCode)
        )
    }

    fun saveUserSetting(country: CountryResponse) {
        saveUserSettingLiveData.postValue(Resource(ResourceState.LOADING))
        country.let {
            it.isChecked = true
            saveUserSetting.execute(
                SaveUserSettingSubscriber(),
                SaveUserSetting.Params.forUser(
                    countryResponse = it
                )
            )
            MemoryCacheManager.AddCountryCode(it?.code!!)
        }
    }


    inner class CountriesSubscriber() :
        DisposableObserver<ArrayList<CountryResponse>>() {
        override fun onComplete() {
        }

        override fun onNext(t: ArrayList<CountryResponse>) {
            t.let {
                if (it.isNotEmpty())
                    getUserSetting.execute(GetUserSubscriber(it))
            }
        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("countriesserror", e?.localizedMessage + "");
            } else {
                countriesLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }


    inner class GetUserSubscriber(private val countries: ArrayList<CountryResponse>) :
        DisposableObserver<UserSetting?>() {
        override fun onError(e: Throwable) {
            Log.d("as", e.message.toString())
            countriesLiveData.postValue(Resource(ResourceState.SUCCESS, countries))
        }

        override fun onNext(t: UserSetting) {
            countries.map {
                if (it.code == t.country!!.code)
                    it.isChecked = true
            }
            countriesLiveData.postValue(Resource(ResourceState.SUCCESS, countries))
        }

        override fun onComplete() {
        }

    }

    inner class SaveUserSettingSubscriber() : DisposableCompletableObserver() {
        override fun onComplete() {
            repository.removeGuestAddressFromCache()
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


    override fun onCleared() {
        saveUserSetting.dispose()
        getCountries.dispose()
        getCurrencies.dispose()
        getUserSetting.dispose()
        super.onCleared()
    }

    fun sortTheCountriesBasedOnLocation(countriesList: ArrayList<CountryResponse>): ArrayList<CountryResponse> {
        var countriesListTemp = ArrayList<CountryResponse>()
        try {
            countriesList?.let {
                for (country in it) {
                    if (country.location.equals(LocationType.gcc.toString(), true)) {
                        countriesListTemp.add(country)
                    }
                }
                for (country in it) {
                    if (country.location.equals(LocationType.res.toString(), true)) {
                        countriesListTemp.add(country)
                    }
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return if (countriesListTemp.size == countriesList.size) setCurrentCountryInFirstPosition(
            countriesListTemp
        ) else setCurrentCountryInFirstPosition(countriesList)
    }

    private fun setCurrentCountryInFirstPosition(countriesList: java.util.ArrayList<CountryResponse>): java.util.ArrayList<CountryResponse> {
        var countriesListTemp = ArrayList<CountryResponse>()
        var currentCountryIndex = -1
        try {
            countriesList?.let {
                it.forEachIndexed { index, countryResponse ->
                    if (countryResponse.code.equals(getCountryCode(), true)) {
                        currentCountryIndex = index
                        countriesListTemp.add(countryResponse)
                    }
                }
                if (currentCountryIndex != -1) countriesList.removeAt(currentCountryIndex)
                countriesListTemp.addAll(countriesList)
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return countriesListTemp
    }

    fun searchOnCountryList(
        searchText: String,
        countriesList: List<CountryResponse>?
    ): List<CountryResponse> {
        try {
            SearchCountriesList.clear()
            countriesList?.let {
                if (searchText.isNullOrBlank()) {
                    SearchCountriesList.addAll(it)
                } else {
                    val searchResults = it.filter {
                        it.name!!.contains(searchText, true)
                    }
                    SearchCountriesList.addAll(searchResults)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
        return SearchCountriesList
    }


    enum class LocationType {
        gcc, res
    }
}
