package com.tatayab.presentation.countries

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.responses.CurrencyResponse
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver


class CountriesSubscriber(private val countriesLiveData: MutableLiveData<Resource<ArrayList<CountryResponse>>>) :
    DisposableObserver<ArrayList<CountryResponse>>() {
    override fun onComplete() {
    }

    override fun onNext(t: ArrayList<CountryResponse>) {
        Log.e("countries", "")
        t.let {
            if (it.isNotEmpty())
                this.countriesLiveData.postValue(Resource(ResourceState.SUCCESS, it))
        }
    }

    override fun onError(e: Throwable) {
        Log.e("countriesserror", e.message.toString());
        if (e is NoConnectivityException) {
            Log.e("countriesserror", "222");
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


class CurrenciesSubscriberInCountry(private var courriencies: ArrayList<CurrencyResponse>) :

    DisposableObserver<ArrayList<CurrencyResponse>>() {
    override fun onComplete() {
    }

    override fun onNext(t: ArrayList<CurrencyResponse>) {
        Log.e("curriencies", "")
        t.let {
            if (!t.isNullOrEmpty()) {
                courriencies.clear()
                courriencies.addAll(it)
            }
        }
    }

    override fun onError(e: Throwable) {
        if (e is NoConnectivityException) {
            Log.e("curriencieserror", "222");
        } else {

        }
    }
}
