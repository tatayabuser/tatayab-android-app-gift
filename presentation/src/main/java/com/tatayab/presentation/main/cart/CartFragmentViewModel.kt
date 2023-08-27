package com.tatayab.presentation.main.cart

import android.annotation.SuppressLint
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.gson.Gson
import com.tatayab.domain.interactor.cart.*
import com.tatayab.domain.interactor.user.GetCurrentUser
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.ShareCartListModel
import com.tatayab.model.requests.*
import com.tatayab.model.responses.*
import com.tatayab.presentation.OperationType
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.Utils.Companion.DEVICE_UID
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.Observable
import io.reactivex.observers.DisposableObserver
import java.util.concurrent.TimeUnit
import javax.inject.Inject


class CartFragmentViewModel @Inject constructor(
    private val mUpdateOrderInCart: UpdateCartItemAmount,
    private val mDeleteOrderFromCart: DeleteOrderFromCart,
    private val getCartContent: GetCartContent,
    private val getCurrentUser: GetCurrentUser,
    private val mCashBackExecution: CashBackExecution,
    private val addOrderToCart: AddOrderToCart,
    private val repository: TatayabRepository,
    private val languageCode: String
) : BaseViewModel(repository) {
    private var isGraphEnabled: Boolean = false
    private val cartCountLiveData = MutableLiveData<Resource<Int>>()
    private val cartLiveData = MutableLiveData<Resource<Pair<String, GetOrdersFromCartResponse>>>()
    private val cashBackLiveData = MutableLiveData<Resource<Pair<String, CheckCashBackResponse>>>()
    private val giftMessageData = SingleLiveEvent<String>()
    private val cartTotalLiveData = SingleLiveEvent<Resource<Pair<String, Pair<Int, Float>>>>()

    // remote id, position, cart count
    private val removeFromCartLiveData = MutableLiveData<Resource<Pair<Pair<String, Int>, Int>>>()
    private val removeGiftFromCartLiveData = MutableLiveData<Resource<Boolean>>()

    // (remote id, position), (cart count ,operationType)
    private val updateProductAmountLiveData =
        MutableLiveData<Resource<Pair<Pair<String, Int>, Pair<Int, OperationType>>>>()

    private val userLiveData = MutableLiveData<Resource<Boolean>>()
    private val createCartForUserLiveData = MutableLiveData<Resource<Boolean>>()

    val getUserLiveData: LiveData<Resource<Boolean>>
        get() = userLiveData
    val getCreateCartForUserLiveDataData: LiveData<Resource<Boolean>>
        get() = createCartForUserLiveData
    val getCashBackLiveData: LiveData<Resource<Pair<String, CheckCashBackResponse>>>
        get() = cashBackLiveData

    val getGiftMessageData: SingleLiveEvent<String>
        get() = giftMessageData


    val getCartCountLiveData: LiveData<Resource<Int>>
        get() = cartCountLiveData

    val getCartLiveData: LiveData<Resource<Pair<String, GetOrdersFromCartResponse>>>
        get() = cartLiveData

    val getCartTotalLiveData: SingleLiveEvent<Resource<Pair<String, Pair<Int, Float>>>>
        get() = cartTotalLiveData


    val getRemoveFromCartLiveData: LiveData<Resource<Pair<Pair<String, Int>, Int>>>
        get() = removeFromCartLiveData
    val getRemoveGiftFromCartLiveData: LiveData<Resource<Boolean>>
        get() = removeGiftFromCartLiveData

    val getUpdateProductLiveData: LiveData<Resource<Pair<Pair<String, Int>, Pair<Int, OperationType>>>>
        get() = updateProductAmountLiveData

    private val addGiftLiveData = MutableLiveData<Resource<AddItemToCartResponse>>()

    val getAddGiftLiveData: LiveData<Resource<AddItemToCartResponse>>
        get() = addGiftLiveData

    fun getCart(isGraphEnabled: Boolean) {
        println("LOGIN ISSUE// getCart")
        this.isGraphEnabled = isGraphEnabled
        cartLiveData.postValue(Resource(status = ResourceState.LOADING))
//        if (isGraphEnabled) {
             if (MemoryCacheManager.getCartId().isNullOrBlank()) {
                if (isUserLogin(isGraphEnabled)) {
                     var cartId =
                        repository?.getUserCartIdFromCache()!!.toObservable().map { t: String ->
                            t
                        }.blockingSingle()
                     if (cartId.isNullOrBlank()) {
                         createCartForUserLiveData.postValue(
                            Resource(
                                ResourceState.SUCCESS,
                                true
                            )
                        )
                    } else {
                        callCartAPI(cartId)
                    }
                } else {
                     var cartId =
                        repository?.getGuestCartIdFromCache()!!.toObservable().map { t: String ->
                            t
                        }.blockingSingle()
                    if (cartId.isNullOrBlank()) {
                        createCartForUserLiveData.postValue(
                            Resource(
                                ResourceState.SUCCESS,
                                true
                            )
                        )
                    } else {
                        callCartAPI(cartId)
                    }
                }
            } else {
                callCartAPI(MemoryCacheManager.getCartId())
            }
//        } else {
//            callCartAPI("")
//        }
    }

    var cartID = ""
    fun callCartAPI(cartId: String) {
        println("LOGIN ISSUE// callCartAPI")
        if (isGraphEnabled && cartId.isNullOrBlank()) return
                 this.cartID = cartId
                getCartContent.execute(
                    CartContentSubscriber(),
                    GetCartContent.Params.excute(
                        GetOrdersFromCartRequest(
                            getUserIdOrGuestUserID().toInt(),
                            DEVICE_UID,
                            languageCode,
                            getCountryCode(),
                            cartId
                        )
                    )
                )
                MemoryCacheManager.setCartId(cartId)
    }

    fun checkCashBack(orderID: String) {
        cashBackLiveData.postValue(Resource(status = ResourceState.LOADING))
        mCashBackExecution.execute(
            CashBackSubscriber(),
            CashBackExecution.Params.execute(
                orderID
            )
        )

    }

    fun continueToPayment() {
        getCurrentUser.execute(CurrentUserSubscriber())
    }

    fun deleteGiftItemFromCart(
        productId: String,
        senderName: String? = "",
        reciverName: String? = "",
        giftMessage: String? = "",
        productGraphID: String? = "",
        existWrapId: Int? = 0
    ) {
        removeGiftFromCartLiveData.postValue(Resource(status = ResourceState.LOADING))
/*mutation {
  removeGiftCardFromCart(
    input: {
      cart_id: "lOeLKsVkZ1PEvA8A7EaCvmEAk4JRBR7A"
      gift_card_code: "049XDMZ6L81X"
    }
  ) {
    cart {
      applied_gift_cards {
        code
      }
    }
  }
}*/
        mDeleteOrderFromCart.execute(
            CartRemoveGiftSubscriber(productId),
            DeleteOrderFromCart.Params.execute(
                DeleteItemFromCartRequest(
                    productId,
                    getUserIdOrGuestUserID().toInt(),
                    DEVICE_UID,
                    languageCode,
                    getCountryCode(),
                    cartID = cartID,
                    sender_name = senderName,
                    recipient_name = reciverName,
                    gift_message = giftMessage,
                    productGraphID = productGraphID,
                    existsWrapId = existWrapId,
                    localAction = Action.RemoveGift.toString()

                )
            )
        )
    }

    fun addGiftToCart(
        productID: String,
        productID2: String,
        senderName: String,
        reciverName: String,
        giftMessage: String,
        cartProductID: String,
        productUID:String
    ) {



        addGiftLiveData.postValue(Resource(status = ResourceState.LOADING))
        var addGiftRequest = AddItemToCartRequest(
            productID,
            productID2,
            //"5",
            null,
            getUserIdOrGuestUserID().toInt(),
            DEVICE_UID,
            languageCode,
            getCountryCode()
        )
        addGiftRequest.sl = languageCode
        addGiftRequest.is_gift = 1
        addGiftRequest.amount = 1
        addGiftRequest.sender_name = senderName
        addGiftRequest.recipient_name = reciverName
        addGiftRequest.gift_message = giftMessage
        addGiftRequest.action = Action.add_gift.toString()
        addGiftRequest.cartProductID = cartProductID
        addGiftRequest.cartID = cartID


        Log.d("TAG", "MaddGiftToCart: ${productID}${productID2}")


        addOrderToCart.execute(
            AddGiftToCartSubscriber(productUID
            ),
            AddOrderToCart.Params.execute(
                addGiftRequest
            )
        )
    }


    fun updateGiftToCart(
        giftId: String,
        cardId: String,
        senderName: String,
        reciverName: String,
        giftMessage: String,
        cartProductID: String,
        oldGiftId: Int? = 0,
        productUID:String

    ) {

        addGiftLiveData.postValue(Resource(status = ResourceState.LOADING))
        var addGiftRequest = AddItemToCartRequest(
            giftId,
            cardId,
            null,
            getUserIdOrGuestUserID().toInt(),
            DEVICE_UID,
            languageCode,
            getCountryCode()
        )
        addGiftRequest.sl = languageCode
        addGiftRequest.is_gift = 1
        addGiftRequest.amount = 1
        addGiftRequest.sender_name = senderName
        addGiftRequest.recipient_name = reciverName
        addGiftRequest.gift_message = giftMessage
        addGiftRequest.action = Action.update.toString()
        addGiftRequest.cartProductID = cartProductID
        addGiftRequest.cartID = cartID
        addGiftRequest.old_wrap_id = oldGiftId



        addOrderToCart.execute(
            AddGiftToCartSubscriber(productUID),
            AddOrderToCart.Params.execute(
                addGiftRequest
            )
        )
    }

    inner class AddGiftToCartSubscriber(var productUID: String) :
        DisposableObserver<AddItemToCartResponse>() {
        override fun onError(e: Throwable) {
            addGiftLiveData.postValue(Resource(status = ResourceState.ERROR))
            Log.d("TAG", "mGiftonError: ${e.message}")
        }

        override fun onNext(t: AddItemToCartResponse) {
            t?.cartProductID = productUID
            addGiftLiveData.postValue(Resource(status = ResourceState.SUCCESS, data = t))
        }

        override fun onComplete() {
        }
    }


    fun deleteCartItem(
        productId: String,
        productIdRemote: String,
        position: Int,
        product: CartOrderResponse?,
        senderName: String? = "",
        reciverName: String? = "",
        giftMessage: String? = "",
        productGraphID: String? = ""
    ) {
        removeFromCartLiveData.postValue(Resource(status = ResourceState.LOADING))

        mDeleteOrderFromCart.execute(
            CartRemoveSubscriber(position, productIdRemote),
            DeleteOrderFromCart.Params.execute(
                DeleteItemFromCartRequest(
                    productId,
                    getUserIdOrGuestUserID().toInt(),
                    DEVICE_UID,
                    languageCode,
                    getCountryCode(),
                    cartID = cartID,
                    gift_message = giftMessage,
                    sender_name = senderName,
                    recipient_name = reciverName,
                    productGraphID = productGraphID,
                    localAction = Action.RemoveProduct.toString(),
                    productUID = product?.productUID
                )
            )
        )
    }


    fun updateProductAmount(
        operationType: OperationType,
        productId: String,
        product: CartOrderResponse,
        newValue: Int,
        position: Int
    ) {
        mUpdateOrderInCart.execute(
            UpdateAmountCachedSubscriber(productId, position, operationType),
            UpdateCartItemAmount.Params.execute(
                UpdateItemInCartRequest(
                    productId,
                    product.productOptions,
                    getUserIdOrGuestUserID().toInt(),
                    DEVICE_UID,
                    languageCode,
                    getCountryCode(),
                    newValue,
                    productUID = product?.productUID.toString(),
                    cartID = cartID
                )
            )
        )

    }

    inner class CashBackSubscriber : DisposableObserver<CheckCashBackResponse>() {
        override fun onError(e: Throwable) {
            cashBackLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        @SuppressLint("CheckResult")
        override fun onNext(t: CheckCashBackResponse) {
            cashBackLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS,
                    data = Pair(getCurrencyCode(), t)
                )
            )
        }

        override fun onComplete() {
        }

    }

    fun isTheCartNotActiveError(error: String): Boolean {
        return error.isNullOrBlank().not() && error.contains("The cart isn't active")
    }

    inner class CartContentSubscriber : DisposableObserver<GetOrdersFromCartResponse>() {
        override fun onError(e: Throwable) {
            if (isTheCartNotActiveError(e.localizedMessage.toString())) {
                if (isUserLogin(isGraphEnabled)) {
                    createCartForUserLiveData.postValue(
                        Resource(
                            ResourceState.SUCCESS,
                            true
                        )
                    )
                } else {

                }
            } else {
                cartLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR,
                        message = e.localizedMessage.toString()
                    )
                )
            }

            println("LOGIN ISSUE// CartContentSubscriber/error")
        }

        @SuppressLint("CheckResult")
        override fun onNext(t: GetOrdersFromCartResponse) {
            println("LOGIN ISSUE// CartContentSubscriber/onNext")
            if (t.products != null) {
                if (!t.cartMessage.isNullOrEmpty())
                    Observable.timer(1, TimeUnit.SECONDS).subscribe {
                        giftMessageData.postValue(t.cartMessage)
                    }
//                else
//                    giftMessageData.postValue(false)

                cartLiveData.postValue(
                    Resource(
                        status = ResourceState.SUCCESS,
                        data = Pair(getCurrencyCode(), t)
                    )
                )

                getTotalItemsCountWithSubTotal(products = t.products!!)
            } else if (isTheCartNotActiveError(t?.errorMessage.toString())) {
                createCartForUserLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        true
                    )
                )
            } else {
                cartLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR,
                        message = t?.errorMessage
                    )
                )
            }
        }

        override fun onComplete() {
        }

    }

    inner class CurrentUserSubscriber : DisposableObserver<AuthenticationResponse?>() {
        override fun onError(e: Throwable) {
            userLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(user: AuthenticationResponse) {
            if (user.email.isNullOrBlank()) {
                userLiveData.postValue(Resource(ResourceState.SUCCESS, false))
            } else {
                userLiveData.postValue(Resource(ResourceState.SUCCESS, true))
            }
        }

        override fun onComplete() {
        }

    }


    fun getTotalItemsCountWithSubTotal(
        products: List<CartOrderResponse>
    ) {
        var currencyCode = ""
        currencyCode = repository.getUserSettingFromCache()
            .blockingGet().country?.currency_code.toString()
        var totalItemsCount = 0
        var subTotalPriceValue = 0.0

        products.forEach { item ->
            totalItemsCount += 1
            subTotalPriceValue += item.price!! * item.amount!!
            if (currencyCode.isNullOrBlank()) {
                currencyCode = item?.currencyId.toString()
            }
        }
        cartTotalLiveData.postValue(
            Resource(
                ResourceState.SUCCESS,
                Pair(
                    currencyCode,
                    Pair(totalItemsCount, subTotalPriceValue.toFloat())
                )
            )
        )

    }

    inner class CartRemoveSubscriber(private val position: Int, private val productId: String) :
        DisposableObserver<AddItemToCartResponse>() {
        override fun onError(e: Throwable) {
            removeFromCartLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(t: AddItemToCartResponse) {
            removeFromCartLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS,
                    data = Pair(Pair(productId, position), t?.totalCartProducts!!)
                )
            )
            getCart(isGraphEnabled)
        }

        override fun onComplete() {
        }

    }

    inner class CartRemoveGiftSubscriber(private val productId: String) :
        DisposableObserver<AddItemToCartResponse>() {
        override fun onError(e: Throwable) {
            removeGiftFromCartLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(t: AddItemToCartResponse) {
            removeGiftFromCartLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS
                )
            )
        }

        override fun onComplete() {
        }

    }


    inner class UpdateAmountCachedSubscriber(
        private val productId: String,
        private val position: Int,
        private val operationType: OperationType
    ) :
        DisposableObserver<AddItemToCartResponse>() {
        override fun onError(e: Throwable) {
            updateProductAmountLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(t: AddItemToCartResponse) {
            if (t.success == 1) {
                updateProductAmountLiveData.postValue(
                    Resource(
                        status = ResourceState.SUCCESS, data = Pair(
                            Pair(productId, position), Pair(t.totalCartProducts, operationType)
                        )
                    )
                )
            } else {
                updateProductAmountLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR,
                        message = t.msg
                    )
                )
            }
        }

        override fun onComplete() {
        }

    }


    override fun onCleared() {
        getCurrentUser.dispose()
        getCartContent.dispose()
        mUpdateOrderInCart.dispose()
        getCartContent.dispose()
        mDeleteOrderFromCart.dispose()
        super.onCleared()
    }

    fun convertCartListToModel(cartProducts: List<CartOrderResponse>): String? {
        var cartProducts: List<ShareCartProductModel> = convertShareCart(cartProducts)
        var cartProductAsString: String? = null
        try {
            val gson = Gson()
            cartProductAsString = gson.toJson(
                ShareCartListModel(
                    countryCode = getCountryCode(),
                    senderName = getUserName(),
                    senderId = getUserId(),
                    products = cartProducts
                )
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return cartProductAsString
    }

    private fun convertShareCart(cartProducts: List<CartOrderResponse>): List<ShareCartProductModel> {
        var shareCartProduct: ArrayList<ShareCartProductModel> = ArrayList()
        if (!cartProducts.isNullOrEmpty()) {
            try {
                cartProducts.map {
                    if (it?.isGift != 1) {
                        shareCartProduct.add(
                            ShareCartProductModel(
                                it.product_id,
                                amount = it.amount,
                                options = getSharedOptionsList(it.productOptions)
                            )
                        )
                    }
                }
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
        return shareCartProduct
    }

    private fun getSharedOptionsList(productOptions: Map<String, String>?): ArrayList<SelectedOptionModel> {
        var sharedOptionsList: ArrayList<SelectedOptionModel> = ArrayList()
        if (!productOptions.isNullOrEmpty()) {
            try {
                productOptions?.map {
                    sharedOptionsList.add(SelectedOptionModel(it.key, it.value))
                }

            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }
        return sharedOptionsList
    }


}