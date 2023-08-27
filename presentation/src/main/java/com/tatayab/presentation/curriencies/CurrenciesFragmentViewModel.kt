package com.tatayab.presentation.curriencies

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.tatayab.domain.interactor.curriencies.GetCurrencies
import com.tatayab.domain.interactor.user.GetUserSetting
import com.tatayab.domain.interactor.user.SaveUserSetting
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserSetting
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.responses.CurrencyResponse
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class CurrenciesFragmentViewModel @Inject constructor(
    private val getCurrencies: GetCurrencies,
    private val getUserSetting: GetUserSetting,
    private val saveUserSetting: SaveUserSetting,
    private val languageCode: String
) : ViewModel() {

    private lateinit var selectedCountry: CountryResponse

    private val saveUserSettingLiveData = MutableLiveData<Resource<Boolean>>()
    val getSaveUserSettingLiveData: LiveData<Resource<Boolean>>
        get() = saveUserSettingLiveData

    private val currenciesLiveData = MutableLiveData<Resource<ArrayList<CurrencyResponse>>>()
    val getCurrenciesLiveData: LiveData<Resource<ArrayList<CurrencyResponse>>>
        get() = currenciesLiveData

    init {
        getCurrencies()
    }


    fun saveUserSetting(currency: CurrencyResponse) {
        currency.isChecked = true
        saveUserSetting.execute(
            SaveUserSettingSubscriber(),
            SaveUserSetting.Params.forUser(selectedCountry)
        )
    }

    private fun getCurrencies() {
        currenciesLiveData.postValue(Resource(ResourceState.LOADING))
        getCurrencies.execute(CurrenciesSubscriber(),GetCurrencies.Params.forCurrency(languageCode))
    }

    inner class GetUserSubscriber(private val curriencies: ArrayList<CurrencyResponse>) :
        DisposableObserver<UserSetting?>() {
        override fun onError(e: Throwable) {
            Log.d("as", e.message.toString())
        }

        override fun onNext(t: UserSetting) {
            selectedCountry = t.country!!
            curriencies.map {
                if (it.currency_code == t.country!!.currency_code)
                    it.isChecked = true
            }
            currenciesLiveData.postValue(Resource(ResourceState.SUCCESS, curriencies))
        }

        override fun onComplete() {
        }
    }


    inner class CurrenciesSubscriber() :
        DisposableObserver<ArrayList<CurrencyResponse>>() {
        override fun onComplete() {
        }

        override fun onNext(t: ArrayList<CurrencyResponse>) {
            Log.e("curriencies", "")
            t.let {
                if (it.isNotEmpty())
                    getUserSetting.execute(GetUserSubscriber(it))
            }
        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("curriencieserror", "222");
            } else {
                currenciesLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }

    inner class SaveUserSettingSubscriber() : DisposableCompletableObserver() {
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


    override fun onCleared() {
        saveUserSetting.dispose()
        getCurrencies.dispose()
        getUserSetting.dispose()
        super.onCleared()
    }

}