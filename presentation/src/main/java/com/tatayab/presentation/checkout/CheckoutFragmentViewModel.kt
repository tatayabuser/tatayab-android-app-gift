package com.tatayab.presentation.checkout

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.cart.*
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject
import com.tatayab.model.requests.*
import com.tatayab.model.responses.*
import com.tatayab.model.responses.graph_responses.RestoreCartResponse
import com.tatayab.model.responses.graph_responses.SetShippingMethodResponse
import com.tatayab.model.responses.graph_responses.ShippingMethodsResponse
import com.tatayab.presentation.Utils
import com.tatayab.presentation.base.MemoryCacheManager


class CheckoutFragmentViewModel @Inject constructor(
    private val applyCoupon: AddCouponExecution,
    private val mRemoveCouponExecution: RemoveCouponExecution,
    private val mPaymentMethodExecution: PaymentMethodExecution,
    private val createOrder: CreateOrderExecution,
    private val repository: TatayabRepository,
    private val mCheckoutReviewExecution: CheckoutReviewExecution,
    private val mSetShippingMethodExecution: SetShippingMethodExecution,
    private val mShippingMethodsExecution: ShippingMethodsExecution,
    private val mRestoreCartExecution: RestoreCartExecution,
    private val languageCode: String
) : BaseViewModel(repository = repository) {
    var ENABLE_GRAPH_QUERIES_CALLS = false
    private val checkoutReviewLiveData = MutableLiveData<Resource<ReviewCartResponse>>()
    private val applayCouponLiveData = MutableLiveData<Resource<ReviewCartResponse>>()
    private val createOrderLiveData = MutableLiveData<Resource<CreateOrderResponse>>()
    private val isLoginLiveData = MutableLiveData<Boolean>()
    private val backToCartLiveData = MutableLiveData<Boolean>()

    val getCheckoutReviewLiveData: LiveData<Resource<ReviewCartResponse>>
        get() = checkoutReviewLiveData

    val getCreateOrderLiveData: LiveData<Resource<CreateOrderResponse>>
        get() = createOrderLiveData

    val getApplayCouponLiveData: LiveData<Resource<ReviewCartResponse>>
        get() = applayCouponLiveData

    val getIsLoginLiveData: LiveData<Boolean>
        get() = isLoginLiveData
    val getBackToCartLiveData: LiveData<Boolean>
        get() = backToCartLiveData


    fun getIsLogin() {
        val user = getUserId()
        isLoginLiveData.postValue(user.toInt() > 0)
    }

    var addressId: String = ""
    fun getReviewResponse(addressId: String) {
        checkoutReviewLiveData.postValue(Resource(status = ResourceState.LOADING))
        this.addressId = addressId
        if (ENABLE_GRAPH_QUERIES_CALLS) {
            if (MemoryCacheManager.getCartId().isNullOrBlank()) {
                if (isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                    var cartId =
                        repository?.getUserCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    println("callCheckoutAPI 1")
                    MemoryCacheManager.setCartId(cartId)
                    if (cartId != null) {
                        callCheckoutAPI(addressId, cartId)
                    }
                } else {
                    var cartId =
                        repository.getGuestCartIdFromCache().toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    println("callCheckoutAPI 2")
                    MemoryCacheManager.setCartId(cartId)
                    callCheckoutAPI(addressId, cartId)
                }
            } else {
                callCheckoutAPI(addressId, MemoryCacheManager.getCartId())
                println("callCheckoutAPI 3")
            }

        } else {
            callCheckoutAPI(addressId, "")
            println("callCheckoutAPI 4")
        }
    }

    init {
        mShippingMethodsExecution.execute(
            GetShippingMethodsSubscriber(), ShippingMethodsExecution.Params.execute(
                MemoryCacheManager.getCartId()
            )
        )
    }
    private fun callCheckoutAPIAfterCoupon() {
        mCheckoutReviewExecution.execute(
            ApplyCouponSubscriber(true), CheckoutReviewExecution.Params.execute(
                ReviewCartRequest(
                    getUserIdOrGuestUserID().toInt(), Utils.DEVICE_UID,
                    languageCode,
                    getCountryCode(),
                    "",
                    cartId = MemoryCacheManager.getCartId()
                )
            )
        )

    }

    private fun callCheckoutAPI(addressId: String, cartId: String?,isSetShippingAddressSucess:Boolean?=false) {
       if(isSetShippingAddressSucess == false) {
           mShippingMethodsExecution.execute(
               GetShippingMethodsSubscriber(), ShippingMethodsExecution.Params.execute(
                   MemoryCacheManager.getCartId()
               )
           )
       }
        mCheckoutReviewExecution.execute(
            ReviewSubscriber(), CheckoutReviewExecution.Params.execute(
                ReviewCartRequest(
                    getUserIdOrGuestUserID().toInt(), Utils.DEVICE_UID,
                    languageCode,
                    getCountryCode(),
                    addressId,
                    cartId = MemoryCacheManager.getCartId()
                )
            )
        )
    }


    fun changePaymentMethod(paymentId: Int, paymentCode: String? = "") {
        checkoutReviewLiveData.postValue(Resource(status = ResourceState.LOADING))
        if (ENABLE_GRAPH_QUERIES_CALLS) {
            if (MemoryCacheManager.getCartId().isNullOrBlank()) {
                if (isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                    var cartId =
                        repository?.getUserCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    MemoryCacheManager.setCartId(cartId)
                    if (cartId != null) {
                        setPaymentMethodCall(paymentId, cartId = cartId, paymentCode = paymentCode!!)
                    }
                } else {
                    var cartId =
                        repository?.getGuestCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    MemoryCacheManager.setCartId(cartId)
                    if (cartId != null) {
                        setPaymentMethodCall(paymentId, cartId = cartId, paymentCode = paymentCode!!)
                    }
                }
            } else {
                setPaymentMethodCall(
                    paymentId,
                    cartId = MemoryCacheManager.getCartId(),
                    paymentCode = paymentCode!!
                )
            }
        } else {
            setPaymentMethodCall(paymentId)
        }
    }

    private fun setPaymentMethodCall(
        paymentId: Int,
        cartId: String = "",
        paymentCode: String = ""
    ) {
        mPaymentMethodExecution.execute(
            PaymentMethodSubscriber(), PaymentMethodExecution.Params.execute(
                PaymentMethodRequest(
                    getUserIdOrGuestUserID().toInt(), Utils.DEVICE_UID,
                    languageCode,
                    getCountryCode(), paymentId, cartID = cartId, code = paymentCode
                )
            )
        )
    }

    fun applyCoupon(couponCode: String) {
        checkoutReviewLiveData.postValue(Resource(status = ResourceState.LOADING))
        if (ENABLE_GRAPH_QUERIES_CALLS) {
            if (MemoryCacheManager.getCartId().isNullOrBlank()) {
                if (isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                    var cartId =
                        repository?.getUserCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    MemoryCacheManager.setCartId(cartId)
                    applyCouponCall(couponCode, cartId = cartId)
                } else {
                    var cartId =
                        repository?.getGuestCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    MemoryCacheManager.setCartId(cartId)
                    applyCouponCall(couponCode, cartId = cartId)
                }
            } else {
                applyCouponCall(couponCode, cartId = MemoryCacheManager.getCartId())
            }
        } else {
            applyCouponCall(couponCode)
        }
    }

    private fun applyCouponCall(couponCode: String, cartId: String? = "") {
        applyCoupon.execute(
            ApplyCouponSubscriber(true), AddCouponExecution.Params.execute(
                AddCouponRequest(
                    getUserIdOrGuestUserID().toInt(), Utils.DEVICE_UID,
                    languageCode,
                    getCountryCode(), couponCode, cartId = cartId!!
                )
            )
        )
    }

    fun removeCoupon() {
        checkoutReviewLiveData.postValue(Resource(status = ResourceState.LOADING))
        if (ENABLE_GRAPH_QUERIES_CALLS) {
            if (MemoryCacheManager.getCartId().isNullOrBlank()) {
                if (isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                    var cartId =
                        repository?.getUserCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    MemoryCacheManager.setCartId(cartId)
                    if (cartId != null) {
                        removeCouponCall(cartId = cartId)
                    }
                } else {
                    var cartId =
                        repository?.getGuestCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    if (cartId != null) {
                        removeCouponCall(cartId = cartId)
                    }
                    MemoryCacheManager.setCartId(cartId)
                }
            } else {
                removeCouponCall(cartId = MemoryCacheManager.getCartId())
            }
        } else {
            removeCouponCall()
        }

    }

    private fun removeCouponCall(cartId: String = "") {
        mRemoveCouponExecution.execute(
            RemoveCouponSubscriber(), RemoveCouponExecution.Params.execute(
                RemoveCouponRequest(
                    getUserIdOrGuestUserID().toInt(), Utils.DEVICE_UID,
                    languageCode,
                    getCountryCode(),
                    cartId = cartId
                )
            )
        )
    }


    fun createOrder(
        is_gift: Int,
        gift_sender_name: String = "",
        gift_receiver_name: String = "",
        gift_msg: String = ""
    ) {
        createOrderLiveData.postValue(Resource(status = ResourceState.LOADING))
        if (ENABLE_GRAPH_QUERIES_CALLS) {
            if (MemoryCacheManager.getCartId().isNullOrBlank()) {
                if (isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                    var cartId =
                        repository?.getUserCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    MemoryCacheManager.setCartId(cartId)
                    placeOrderAPI(is_gift, gift_sender_name, gift_receiver_name, gift_msg)
                } else {
                    var cartId =
                        repository?.getGuestCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    MemoryCacheManager.setCartId(cartId)
                    placeOrderAPI(is_gift, gift_sender_name, gift_receiver_name, gift_msg)
                }
            } else {
                placeOrderAPI(is_gift, gift_sender_name, gift_receiver_name, gift_msg)
            }
        } else {
            placeOrderAPI(is_gift, gift_sender_name, gift_receiver_name, gift_msg)
        }
    }

    private fun placeOrderAPI(
        is_gift: Int,
        gift_sender_name: String = "",
        gift_receiver_name: String = "",
        gift_msg: String = ""
    ) {
        createOrder.execute(
            CreateOrderSubscriber(), CreateOrderExecution.Params.execute(
                getUserIdOrGuestUserID(),
                languageCode,
                getCountryCode(),
                Action.place_order.toString(),
                Utils.DEVICE_UID,
                is_gift,
                gift_sender_name,
                gift_receiver_name,
                gift_msg,
                MemoryCacheManager.getCartId()
            )
        )
    }

    inner class ReviewSubscriber : DisposableObserver<ReviewCartResponse>() {
        override fun onError(e: Throwable) {
            checkoutReviewLiveData.postValue(Resource(status = ResourceState.ERROR, throwable = e))
        }

        override fun onNext(t: ReviewCartResponse) {
            if (t?.msg.isNullOrBlank()) {
                checkoutReviewLiveData.postValue(
                    Resource(
                        status = ResourceState.SUCCESS,
                        data = t
                    )
                )
            } else {
                if (isTheCartNotActiveError(t?.msg.toString())) {
                    restoreCart()
                } else {
                    checkoutReviewLiveData.postValue(
                        Resource(
                            status = ResourceState.ERROR,
                            message = t?.msg.toString()
                        )
                    )
                }
            }
        }

        override fun onComplete() {
        }

    }

    fun restoreCart() {
        try {
            if (isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                var cartId = repository?.getUserCartIdFromCache()?.toObservable()?.map { t: String ->
                    t
                }?.blockingSingle()
                if (!cartId.isNullOrBlank()) {
                    callRestoreCartAPI(cartId)
                } else {
                    backToCartLiveData.postValue(true)
                }
            } else {
                var cartId = repository?.getGuestCartIdFromCache()?.toObservable()?.map { t: String ->
                    t
                }?.blockingSingle()
                if (!cartId.isNullOrBlank()) {
                    callRestoreCartAPI(cartId)
                } else {
                    backToCartLiveData.postValue(true)
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun callRestoreCartAPI(cartId: String) {
        mRestoreCartExecution.execute(
            RestoreCartSubscriber(),
            RestoreCartExecution.Params.execute(
                cartId
            )
        )
    }

    inner class RestoreCartSubscriber() : DisposableObserver<RestoreCartResponse>() {
        override fun onNext(t: RestoreCartResponse) {
            // get checkout again
            if (t?.data?.restoreCart?.isNullOrBlank() == true) {
                backToCartLiveData.postValue(true)

            } else {
                MemoryCacheManager.setCartId(t?.data?.restoreCart.toString())
                callCheckoutAPI(addressId, t?.data?.restoreCart.toString())
            }
        }

        override fun onError(e: Throwable) {
            // back to cart
            backToCartLiveData.postValue(true)
        }

        override fun onComplete() {
        }


    }

    inner class PaymentMethodSubscriber : DisposableObserver<ReviewCartResponse>() {
        override fun onError(e: Throwable) {
            if (isTheCartNotActiveError(e.message.toString())) {
                restoreCart()
            } else {
                checkoutReviewLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR,
                        throwable = e
                    )
                )
            }
        }

        override fun onNext(t: ReviewCartResponse) {
            if (t?.msg.isNullOrBlank()) getReviewResponse("")
            else {
                if (isTheCartNotActiveError(t?.msg.toString())) {
                    restoreCart()
                } else {
                checkoutReviewLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR,
                        message = t?.msg
                    )
                )
            }}
        }

        override fun onComplete() {
        }

    }

    inner class RemoveCouponSubscriber : DisposableObserver<ReviewCartResponse>() {
        override fun onError(e: Throwable) {
            if (isTheCartNotActiveError(e.message.toString())) {
                restoreCart()
            } else {
                checkoutReviewLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR,
                        throwable = e
                    )
                )
            }
        }

        override fun onNext(t: ReviewCartResponse) {
            getReviewResponse("")
        }

        override fun onComplete() {
        }

    }

    inner class SetShippingMethodSubscriber : DisposableObserver<SetShippingMethodResponse>() {
        override fun onError(e: Throwable) {
            e.printStackTrace()
        }

        override fun onNext(t: SetShippingMethodResponse) {
            if (t?.errorsListModel.isNullOrEmpty()) {
                  callCheckoutAPI(addressId,"",true)
            } else {

            }

        }

        override fun onComplete() {
        }

    }

    inner class GetShippingMethodsSubscriber : DisposableObserver<ShippingMethodsResponse>() {
        override fun onError(e: Throwable) {
            e.printStackTrace()
        }

        override fun onNext(t: ShippingMethodsResponse) {
            if (t?.errorsListModel.isNullOrEmpty()) {
                t?.customerDataModel?.cartModel?.shippingAddressesList?.let {
                    var carrierId = ""
                    var methodId = ""
                    if (it?.isEmpty()?.not() == true) {
                        it?.map {
                            it?.mShippingMethodList?.map {
                                if (carrierId.isNullOrBlank()) {
                                    // carrier_code: "KW-WH:flatrate|SA-WH:flatrate"
                                    //        method_code: "KW-WH:flatrate|SA-WH:flatrate"
                                    carrierId =
                                        it?.source_code.toString().plus(":").plus(it?.carrier_code)
                                    methodId =
                                        it?.source_code.toString().plus(":").plus(it?.method_code)
                                } else {
                                    carrierId = carrierId.plus("|").plus(
                                        it?.source_code.toString().plus(":").plus(it?.carrier_code)
                                    )
                                    methodId = methodId.plus("|").plus(
                                        it?.source_code.toString().plus(":").plus(it?.method_code)
                                    )
                                }
                            }
                        }
                    }
                    mSetShippingMethodExecution.execute(
                        SetShippingMethodSubscriber(), SetShippingMethodExecution.Params.execute(
                            MemoryCacheManager.getCartId(), carrierId, methodId
                        )
                    )
                }

            } else {
                if (isTheCartNotActiveError(t?.errorsListModel?.get(0)?.message.toString())) {
                    restoreCart()
                }
            }

        }

        override fun onComplete() {
        }

    }

    inner class ApplyCouponSubscriber(val updateUIAfterCall: Boolean) :
        DisposableObserver<ReviewCartResponse>() {
        override fun onError(e: Throwable) {
            applayCouponLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(t: ReviewCartResponse) {
                 if (t?.msg.isNullOrBlank()) {
                    applayCouponLiveData.postValue(
                        Resource(
                            status = ResourceState.SUCCESS,
                            data = t
                        )
                    )
                } else {
                    if (isTheCartNotActiveError(t?.msg!!)) {
                        restoreCart()
                    }else {
                        applayCouponLiveData.postValue(Resource(status = ResourceState.ERROR))
                    }
                }
        }

        override fun onComplete() {
        }

    }

    inner class CreateOrderSubscriber : DisposableObserver<CreateOrderResponse>() {
        override fun onError(e: Throwable) {
            createOrderLiveData.postValue(Resource(status = ResourceState.ERROR, throwable = e))
        }

        override fun onNext(t: CreateOrderResponse) {
            if (t?.orderId.isNullOrBlank().not()) {
                createOrderLiveData.postValue(
                    Resource(
                        status = ResourceState.SUCCESS,
                        data = t
                    )
                )
            } else {
                if (isTheCartNotActiveError(t?.errorMessage.toString())) {
                    restoreCart()
                } else {
                    createOrderLiveData.postValue(
                        Resource(
                            status = ResourceState.ERROR,
                            message = t?.errorMessage.toString()
                        )
                    )
                }
            }
        }

        override fun onComplete() {
        }

    }


    override fun onCleared() {
        mPaymentMethodExecution.dispose()
        mCheckoutReviewExecution.dispose()
        applyCoupon.dispose()
        mRemoveCouponExecution.dispose()
        createOrder.dispose()
        super.onCleared()
    }

    fun isTheCartNotActiveError(error: String): Boolean {
        return error.isNullOrBlank().not() && error.contains("The cart isn't active")
    }
}


