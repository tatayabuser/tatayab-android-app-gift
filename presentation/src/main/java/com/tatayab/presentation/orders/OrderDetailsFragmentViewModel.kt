package com.tatayab.presentation.orders

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.orders.GetOrderDetails
import com.tatayab.domain.interactor.orders.GetOrderTracking
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.responses.OrderDetailsResponse
import com.tatayab.model.responses.OrderTrackingResponse
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableObserver


class OrderDetailsFragmentViewModel constructor(
    private val tatayabRepository: TatayabRepository,
    private val getOrderDetails: GetOrderDetails,
    private val getOrderTracking: GetOrderTracking,
    private val orderId:String,
    private val languageCode:String
) : BaseViewModel(tatayabRepository) {

    private val compositeDisposable = CompositeDisposable()
    private val orderDetailsLiveData = MutableLiveData<Resource<OrderDetailsResponse>>()
    private val orderTrackLiveData = MutableLiveData<Resource<OrderTrackingResponse>>()


    fun getOrderDetailsLiveData(): MutableLiveData<Resource<OrderDetailsResponse>> {
        return orderDetailsLiveData
    }

    fun getOrderTrackLiveData(): MutableLiveData<Resource<OrderTrackingResponse>> {
        return orderTrackLiveData
    }


    fun getOrderDetails() {
        orderDetailsLiveData.postValue(Resource(status = ResourceState.LOADING))

        getOrderDetails.execute(
            GetOrderDetailsSubscriber(),
            GetOrderDetails.Params.forOrder(userId = getUserId(),orderId = orderId,languageCode = languageCode)
        )
    }

    fun getOrderTracking() {
        //Akl check with wael the order status
//        getOrderTracking.execute(
//            GetOrderTrackingSubscriber(),
//            GetOrderTracking.Params.forOrder(userId = getUserId(),orderId = orderId,languageCode = languageCode)
//        )
    }

    inner class GetOrderDetailsSubscriber() :
        DisposableObserver<OrderDetailsResponse>() {
        override fun onComplete() {

        }

        override fun onNext(t: OrderDetailsResponse) {
            Log.e("details", "")
            t.let {
                orderDetailsLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                       t
                    )
                )
            }
        }
        override fun onError(e: Throwable) {

            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                orderDetailsLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }




    inner class GetOrderTrackingSubscriber() :
        DisposableObserver<OrderTrackingResponse>() {
        override fun onComplete() {
        }
        override fun onNext(t: OrderTrackingResponse) {
            Log.e("details", "")
            t.let {
                orderTrackLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        t
                    )
                )
            }
        }
        override fun onError(e: Throwable) {

            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                orderDetailsLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

}
