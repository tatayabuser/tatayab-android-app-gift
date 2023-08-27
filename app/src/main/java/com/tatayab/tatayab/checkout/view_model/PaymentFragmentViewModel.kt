package com.tatayab.tatayab.checkout.view_model

import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.cart.*
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.graph_responses.RestoreCartResponse
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject


class PaymentFragmentViewModel @Inject constructor(
    private val repository: TatayabRepository,
    private val mRestoreCartExecution: RestoreCartExecution,
    private val languageCode: String
) : BaseViewModel(repository) {

    private val restoreCartLiveData = MutableLiveData<Resource<Boolean>>()

    val getRestoreCartLiveData: MutableLiveData<Resource<Boolean>>
        get() = restoreCartLiveData


    fun restoreCart() {
        try {
            if (isUserLogin(Constants.ENABLE_GRAPH_QUERIES_CALLS)) {
                var cartId = repository?.getUserCartIdFromCache()!!.toObservable().map { t: String ->
                    t
                }.blockingSingle()
                if (!cartId.isNullOrBlank()) {
                    callRestoreCartAPI(cartId)
                } else {
                    restoreCartLiveData.postValue(
                        Resource(
                            ResourceState.ERROR
                        )
                    )
                }
            } else {
                var cartId = repository?.getGuestCartIdFromCache()!!.toObservable().map { t: String ->
                    t
                }.blockingSingle()
                if (!cartId.isNullOrBlank()) {
                    callRestoreCartAPI(cartId)
                } else {
                    restoreCartLiveData.postValue(
                        Resource(
                            ResourceState.ERROR
                        )
                    )
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun callRestoreCartAPI(cartId: String) {
        restoreCartLiveData.postValue(
            Resource(
                ResourceState.LOADING
            )
        )
        mRestoreCartExecution.execute(
            RestoreCartSubscriber(),
            RestoreCartExecution.Params.execute(
                cartId
            )
        )
    }

    inner class RestoreCartSubscriber() : DisposableObserver<RestoreCartResponse>() {
        override fun onNext(t: RestoreCartResponse) {
            restoreCartLiveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    true
                )
            )
            if (t?.data?.restoreCart?.isNullOrBlank() == false) {
                MemoryCacheManager.setCartId(t?.data?.restoreCart.toString())
            }

        }

        override fun onError(e: Throwable) {
            restoreCartLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    true
                )
            )
        }

        override fun onComplete() {
        }


    }

}