package com.tatayab.presentation.main

import android.annotation.SuppressLint
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.addreview.AddReviewToProduct
import com.tatayab.domain.interactor.auth.Login
import com.tatayab.domain.interactor.auth.Logout
import com.tatayab.domain.interactor.auth.UpdateUserTokenWithLangaugAndCountryExecution
import com.tatayab.domain.interactor.cart.*
import com.tatayab.domain.interactor.countries.GetCountries
import com.tatayab.domain.interactor.main.CountryCurrencyExecution
import com.tatayab.domain.interactor.product.ProductGiftUserCase
import com.tatayab.domain.interactor.productotions.GetProductOptions
import com.tatayab.domain.interactor.user.*
import com.tatayab.domain.interactor.wallet.GetWalletExecution
import com.tatayab.domain.interactor.wishlist.WishListActions
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Product
import com.tatayab.model.ProductX
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.model.home.ViewTypeLayout
import com.tatayab.model.requests.*
import com.tatayab.model.requests.graph_request.AddItemToCartGraphRequest
import com.tatayab.model.responses.*
import com.tatayab.model.responses.graph_responses.*
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.Utils
import com.tatayab.presentation.Utils.Companion.ALLOWED_FOR_LOGIN_ERROR
import com.tatayab.presentation.Utils.Companion.CAN_NOT_ASSIGN_CART_ERROR
import com.tatayab.presentation.Utils.Companion.CART_NOT_ACTIVE_ERROR
import com.tatayab.presentation.Utils.Companion.CART_NOT_FIND_ERROR
import com.tatayab.presentation.Utils.Companion.CUSTOMER_NOT_AUTHORIZED_MESSAGE
import com.tatayab.presentation.Utils.Companion.DEVICE_UID
import com.tatayab.presentation.Utils.Companion.EXPIRE_SESSION_MESSAGE
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.product.Constants
import com.tatayab.presentation.product.Constants.RECENT_MAX_ITEMS_IN_HOME
import com.tatayab.presentation.product.Constants.RECENT_VIEW
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.Executors
import javax.inject.Inject


class MainActivityViewModel @Inject constructor(
    private val addOrderToCart: AddOrderToCart,
    private val wishListActions: WishListActions,
    private val mGetOrdersCountInCartExecute: GetOrdersCountInCartExecute,
    private val clearCachedAndRemoteCart: ClearCachedAndRemoteCart,
    private val repository: TatayabRepository,
    private val setFirebaseToken: SetFirebaseToken,
    private val getGeneratedToken: GetGeneratedToken,
    private val mExtractDeepLinkExecution: ExtractDeepLinkExecution,
    private val addReview: AddReviewToProduct,
    private val getProductOptions: GetProductOptions,
    private val mPromotionExecution: PromotionExecution,
    private val mCountryExecution: GetCountries,
    private val mSaveCountryExecution: SaveCountryExecution,
    private val mUpdateUserTokenWithLangaugAndCountryExecution: UpdateUserTokenWithLangaugAndCountryExecution,
    private val mProductGiftUserCase: ProductGiftUserCase,
    private val mSaveCurrentLangauge: SaveCurrentLangauge,
    private val mCreateUserCartExecution: CreateUserCartExecution,
    private val mCreateGuestCartExecution: CreateGuestCartExecution,
    private val mAddItemToCartQueryCartExecution: AddItemToCartQueryCartExecution,
    private val login: Login,
    private val mRestoreCartExecution: RestoreCartExecution,
    private val mMergeCartsExecution: MergeCartsExecution,
    private val mCountryCurrencyExecution: CountryCurrencyExecution,
    private val mGetWalletExecution: GetWalletExecution,
    private val logout: Logout,
    private val languageCode: String,
    private val mCheckTokenExecution: CheckTokenExecution
    ) : BaseViewModel(repository) {


    private val cartLiveData = MutableLiveData<Resource<Pair<ImageView?, Int>>>()
    private val updateTokenLiveData = MutableLiveData<Resource<UserUpdateTokenResponse>>()
    private val checkTokenLiveData = MutableLiveData<Resource<Boolean>>()
    private val promotionLiveData = SingleLiveEvent<Resource<InAppMessageModel>>()
    private val productAddeddTocartLiveData =
        SingleLiveEvent<Resource<Pair<Boolean, Pair<Product, Float>>>>()
    private val walletLiveData = MutableLiveData<Resource<WalletResponse>>()
    private val isTokenExpiredLiveData = MutableLiveData<Resource<String?>>()

    private var conciergeValue = true
    private var isConciergeValueFired = false
    private val addtoWishListresult = SingleLiveEvent<Resource<AddToWishListResponse>>()
    private val addToRecentView = SingleLiveEvent<ProductX>()
    private val removeFromWishListLiveData = SingleLiveEvent<Resource<AddToWishListResponse>>()
    private val addTrackingActionLiveData = SingleLiveEvent<Boolean>()
    private val restoreCartLiveData = MutableLiveData<Resource<Boolean>>()
    private val createCartForUserLiveData = MutableLiveData<Resource<Boolean>>()
    private val createCartForGuestLiveData = MutableLiveData<Resource<Boolean>>()
    private val deviceTokenResponseLiveData = MutableLiveData<Resource<DeviceTokenResponse>>()
    private val productsListResponseLiveData = MutableLiveData<Resource<ProductsListResponse>>()
    val addProductToAdjustLiveData = SingleLiveEvent<Resource<Product>>()
    private val flashTimeLiveData = MutableLiveData<Pair<Boolean, String>>()
    var ENABLE_GRAPH_QUERIES_CALLS = true

    private var timer: CountDownTimer? = null

    private val updateUserTokenLiveData: SingleLiveEvent<Resource<AuthenticationResponse>> =
        SingleLiveEvent()

    fun getUpdateUserTokenLiveData(): SingleLiveEvent<Resource<AuthenticationResponse>> {
        return updateUserTokenLiveData
    }
    fun getIsTokenExpiredLiveData(): MutableLiveData<Resource<String?>> {
        return isTokenExpiredLiveData
    }

    val getWalletLiveData: MutableLiveData<Resource<WalletResponse>>
        get() = walletLiveData

    private val clearCartLiveData = MutableLiveData<Resource<Boolean>>()
    private val goToLoginActivity = MutableLiveData<Boolean>()

    private val goToChoiceOptionsDialog = MutableLiveData<ProductX>()

    private val blocksItemsLiveData = MutableLiveData<Resource<Boolean>>()
    private val ProductOptionsLiveData = MutableLiveData<Resource<ProductOptionsResponse>>()

    private val productAddedToCartFromSheet = SingleLiveEvent<Resource<Boolean>>()
    private val updateCountryLiveData = MutableLiveData<Resource<Boolean>>()
    val getUpdateCountryLiveData: LiveData<Resource<Boolean>>
        get() = updateCountryLiveData
    val getCreateCartForUserLiveData: MutableLiveData<Resource<Boolean>>
        get() = createCartForUserLiveData
    val getCreateCartForGuestLiveData: MutableLiveData<Resource<Boolean>>
        get() = createCartForGuestLiveData

    private val countriesLiveData = MutableLiveData<Resource<List<CountryResponse>>>()
    val getCountriesLiveData: LiveData<Resource<List<CountryResponse>>>
        get() = countriesLiveData

    val getBlocksItemsLiveData: LiveData<Resource<Boolean>>
        get() = blocksItemsLiveData

    val getRestoreCartLiveData: MutableLiveData<Resource<Boolean>>
        get() = restoreCartLiveData


    val getPromotionLiveData: LiveData<Resource<InAppMessageModel>>
        get() = promotionLiveData
    val getUpdateTokenLiveData: LiveData<Resource<UserUpdateTokenResponse>>
        get() = updateTokenLiveData
 val getCheckTokenLiveData: LiveData<Resource<Boolean>>
        get() = checkTokenLiveData


    val getFlashTimeLiveData: LiveData<Pair<Boolean, String>>
        get() = flashTimeLiveData


    val getProductAddedToCartFromSheet: SingleLiveEvent<Resource<Boolean>>
        get() = productAddedToCartFromSheet


    val getDeviceTokenResponseLiveData: MutableLiveData<Resource<DeviceTokenResponse>>
        get() = deviceTokenResponseLiveData

    val getProductsListResponseLiveData: MutableLiveData<Resource<ProductsListResponse>>
        get() = productsListResponseLiveData

    val getCartLiveData: LiveData<Resource<Pair<ImageView?, Int>>>
        get() = cartLiveData

    val getAddToRecentView: SingleLiveEvent<ProductX>
        get() = addToRecentView
    private val migrationLiveData: SingleLiveEvent<Boolean> = SingleLiveEvent()
    private val logoutLiveData: SingleLiveEvent<Boolean> = SingleLiveEvent()

    fun getLogoutLiveData(): SingleLiveEvent<Boolean> {
        return logoutLiveData
    }
    fun getMigrationLiveData(): SingleLiveEvent<Boolean> {
        return migrationLiveData
    }
    private val addReviewResponseLiveData: SingleLiveEvent<Resource<Pair<AddReviewResponse, View>>> =
        SingleLiveEvent()


    private val productGiftstLiveData =
        MutableLiveData<Resource<Pair<String, ProductsListResponse>>>()

    fun getProductGiftsLiveData(): MutableLiveData<Resource<Pair<String, ProductsListResponse>>> {
        return productGiftstLiveData
    }
    fun logout( isMigrateCart : Boolean? = true) {
        logout.execute(LogoutSubscriber(isMigrateCart))
    }

    inner class LogoutSubscriber(var isMigrateCart: Boolean? = true) : DisposableObserver<Boolean>() {
        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
           if(isMigrateCart == true) migrationLiveData.postValue(false)
            else{
               logoutLiveData.postValue(false)
           }
        }

        override fun onNext(t: Boolean) {
            if(isMigrateCart == true) migrationLiveData.postValue(true)
            else{
                logoutLiveData.postValue(true)
            }
        }
    }


    fun getProductGiftsList() {
        getCountryCode()
        Log.d("TAG", "getProductGiftsList: ${getCountryCode()}")


        mProductGiftUserCase.execute(
            GetProductGiftsSubscriber(),
            ProductGiftUserCase.Params.forProduct(
                getCountryCode()
            )
        )
    }

    fun addProductToCartForGraph(
        product: ProductX,
        selectedOptions: Map<String, String>? = null,
        addedFromSheet: Boolean = false,
        cartId: String
    ) {
        var mAddItemToCartGraphRequest = AddItemToCartGraphRequest(
            CART_ID = cartId,
            quantity = 1,
            productId = product?.product_id!!,
            source = if (product?.source.isNullOrBlank()) getCountryCode() + "-WH" else product?.source!!,
            selectedOptions = selectedOptions
        )
        productAddeddTocartLiveData.postValue(Resource(status = ResourceState.LOADING))
        mAddItemToCartQueryCartExecution.execute(
            addItemToCartSubscriber(product, addedFromSheet),
            AddItemToCartQueryCartExecution.Params.execute(
                mAddItemToCartGraphRequest
            )
        )
    }

    inner class addItemToCartSubscriber(var productx: ProductX, var addedFromSheet: Boolean) :
        DisposableObserver<AddProductToCartResponse>() {
        override fun onComplete() {

        }

        override fun onNext(t: AddProductToCartResponse) {
            if (t?.errorsListModel.isNullOrEmpty()) {
                t?.data?.addSimpleProductsToCartModel?.cartModel?.productList?.let {
                    var cartCount = it?.size
                    val product =
                        Product(
                            product = productx?.title,
                            price = productx?.price?:0f,
                            product_id = productx?.product_id,
                            percent_off = productx?.percent_off
                        )
                    addProductToAdjustLiveData.postValue(
                        Resource(
                            status = ResourceState.SUCCESS,
                            data = product
                        )
                    )
                    if (addedFromSheet) {
                        productAddedToCartFromSheet.postValue(Resource(status = ResourceState.SUCCESS))
                    } else {
                        var totalPrice: Float? = 0f
                        t?.data?.addSimpleProductsToCartModel?.cartModel?.mPriceModel?.let {
                            it?.grandTotalModel?.let {
                                totalPrice = it?.value
                            }
                        }
                        productAddeddTocartLiveData.postValue(
                            Resource(
                                status = ResourceState.SUCCESS,
                                data = Pair(
                                    first = true,
                                    second = Pair(
                                        first = product,
                                        second = totalPrice!!
                                    )
                                )
                            )
                        )

                    }

                    cartLiveData.postValue(
                        Resource(
                            status = ResourceState.SUCCESS,
                            data = Pair(null, cartCount!!)
                        )
                    )
                }

            }
//            else if (isCartNotActive(
//                    product = productx,
//                    message = t?.errorsListModel?.get(0)?.message.toString()
//                )
//            ) {
//
//            }
            else if (isExpiredMessage(
                    message = t?.errorsListModel?.get(0)?.message.toString()
                )
            ) {
                isTokenExpiredLiveData.postValue(Resource(
                    ResourceState.ERROR,
                    message = t?.errorsListModel?.get(0)?.message.toString()
                ))
                logoutFun()
            }
            else {
                isUserSessionExpired(t?.errorsListModel?.get(0)?.message.toString())
                productAddeddTocartLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = t?.errorsListModel?.get(0)?.message.toString()
                    )
                )
                cartLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR,
                        message = t?.errorsListModel?.get(0)?.message.toString()
                    )
                )

            }

        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                productAddeddTocartLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }

    fun createCartForUser(
        product: ProductX? = null,
        selectedOptions: Map<String, String>? = null,
        addedFromSheet: Boolean = false
    ) {
        if (ENABLE_GRAPH_QUERIES_CALLS) {
            println("LOGIN ISSUE// createCartForUser 2")
            createCartForUserLiveData.postValue(
                Resource(
                    ResourceState.LOADING,
                    true
                )
            )
            mCreateUserCartExecution.execute(
                CreateCartForUserSubscriber(product, selectedOptions, addedFromSheet),
                CreateUserCartExecution.Params.execute(
                    languageCode
                )
            )
        }
    }

    inner class CreateCartForUserSubscriber(
        var product: ProductX? = null,
        var selectedOptions: Map<String, String>?,
        var addedFromSheet: Boolean
    ) :
        DisposableObserver<CreateCartResponse>() {
        override fun onComplete() {

        }

        override fun onNext(t: CreateCartResponse) {
            if (t?.errorsListModel.isNullOrEmpty()) {
                MemoryCacheManager?.setCartId(t?.data?.customerCart.toString())
                println(" LOGIN ISSUE// createCartForUser/onNext:" + t?.data?.customerCart.toString())
                if (t?.data?.customerCart?.id.isNullOrBlank()
                        .not()
                ) MemoryCacheManager.setCartId(t?.data?.customerCart?.id)
                if (product != null) {
                    addToCart(product!!, selectedOptions, addedFromSheet, t?.data?.customerCart?.id)
                } else {
                    createCartForUserLiveData.postValue(
                        Resource(
                            ResourceState.SUCCESS,
                            true
                        )
                    )
                }
                mergeCarts(t?.data?.customerCart?.id.toString())
//                getCartContentFirstTime()
            } else {
                productAddeddTocartLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = t?.errorsListModel?.get(0)?.message.toString()
                    )
                )
                createCartForUserLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = t?.errorsListModel?.get(0)?.message.toString()
                    )
                )
                getCartContentFirstTime()
            }
        }

        override fun onError(e: Throwable) {
            println(" LOGIN ISSUE// createCartForUser/onError:" + e.localizedMessage.toString())
            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                productAddeddTocartLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
                createCartForUserLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
            getCartContentFirstTime()
        }
    }

    fun createCartForGuest(
        product: ProductX?,
        selectedOptions: Map<String, String>? = null,
        addedFromSheet: Boolean = false
    ) {
        mCreateGuestCartExecution.execute(
            CreateCartForGuestSubscriber(product, selectedOptions, addedFromSheet),
            CreateGuestCartExecution.Params.execute(
                languageCode
            )
        )
    }

    inner class CreateCartForGuestSubscriber(
        var product: ProductX?,
        var selectedOptions: Map<String, String>?,
        var addedFromSheet: Boolean
    ) :
        DisposableObserver<CreateGuestCartResponse>() {
        override fun onComplete() {

        }

        override fun onNext(t: CreateGuestCartResponse) {
            if (t?.errorsListModel.isNullOrEmpty()) {
                if (t?.data?.createEmptyCartID?.isNullOrBlank()?.not() == true) MemoryCacheManager.setCartId(
                    t?.data?.createEmptyCartID
                )

                if (product != null) {
                    addToCart(
                        product!!,
                        selectedOptions,
                        addedFromSheet,
                        t?.data?.createEmptyCartID
                    )
                }
                createCartForGuestLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS
                    )
                )
                getCartContentFirstTime()
            } else {
                productAddeddTocartLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = t?.errorsListModel?.get(0)?.message.toString()
                    )
                )
            }

        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                productAddeddTocartLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }

    fun getAddReviewResponseLiveData(): SingleLiveEvent<Resource<Pair<AddReviewResponse, View>>> {
        return addReviewResponseLiveData
    }

    fun getCountries(langCode: String) {
        countriesLiveData.postValue(Resource(ResourceState.LOADING))
        mCountryExecution.execute(CountriesSubscriber(), GetCountries.Params.forCountries(langCode))
    }

    fun updateUserTokenWithLangaugAndCountry(
        token: String,
        country: String? = getCountryCode(),
        langCode: String
    ) {
        updateTokenLiveData.postValue(
            Resource(
                status = ResourceState.LOADING
            )
        )
        mUpdateUserTokenWithLangaugAndCountryExecution.execute(
            updateTokenExecutionSubscriber(),
            UpdateUserTokenWithLangaugAndCountryExecution.Params.execute(
                country!!,
                langCode
            )
        )
    }

    fun checkTokenValidation(
    ) {
        if(isUserLogedin()) {
            checkTokenLiveData.postValue(
                Resource(
                    status = ResourceState.LOADING
                )
            )
            mCheckTokenExecution.execute(
                checkTokenSubscriber(),
                CheckTokenExecution.Params.execute(
                    getUserTokenFromCache()
                )
            )
        }
    }

    inner class checkTokenSubscriber() :
        DisposableObserver<CheckTokenValidationResponse>() {
        override fun onError(e: Throwable) {
             checkTokenLiveData.postValue(
                Resource(
                    status = ResourceState.ERROR
                )
            )
        }

        override fun onNext(t: CheckTokenValidationResponse) {
            if(t?.errorsListModel.isNullOrEmpty()) {
                checkTokenLiveData.postValue(
                    Resource(
                        status = ResourceState.SUCCESS,
                        data = t?.data?.checkTokenAliveModel?.status
                    )
                )
            }else{
                checkTokenLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR
                    )
                )
            }
        }

        override fun onComplete() {
        }
    }
    inner class updateTokenExecutionSubscriber() :
        DisposableObserver<UserUpdateTokenResponse>() {
        override fun onError(e: Throwable) {
            println("Akl_Log/updateTokenExecutionSubscriber/error: : " + e.message)
            updateTokenLiveData.postValue(
                Resource(
                    status = ResourceState.ERROR
                )
            )
        }

        override fun onNext(t: UserUpdateTokenResponse) {
            println("Akl_Log/updateTokenExecutionSubscriber/Next/status : " + t.status)
            updateTokenLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS, data = t
                )
            )
        }

        override fun onComplete() {
        }
    }

    val getRemoveFromWishListLiveData: SingleLiveEvent<Resource<AddToWishListResponse>>
        get() = removeFromWishListLiveData
    val getProductAddeddTocartLiveDataa: SingleLiveEvent<Resource<Pair<Boolean, Pair<Product, Float>>>>
        get() = productAddeddTocartLiveData


    val getClearCartLiveData: LiveData<Resource<Boolean>>
        get() = clearCartLiveData

    val getProductOptionsLiveData: MutableLiveData<Resource<ProductOptionsResponse>>
        get() = ProductOptionsLiveData

    val getGoToLoginActivity: LiveData<Boolean>
        get() = goToLoginActivity

    val getAddTrackingAction: LiveData<Boolean>
        get() = addTrackingActionLiveData


    val getGoToChoiceOptionsDialog: LiveData<ProductX>
        get() = goToChoiceOptionsDialog


    val getaddtoWishListresult: SingleLiveEvent<Resource<AddToWishListResponse>>
        get() = addtoWishListresult

    var blocksItems: ArrayList<CompositeBlockItem>? = null

    private val extractDeepLinkLiveData = MutableLiveData<Resource<ExtractDeepLinkResponse>>()
    val getExtractDeepLinkLiveData: LiveData<Resource<ExtractDeepLinkResponse>>
        get() = extractDeepLinkLiveData


    init {
        getCartContentFirstTime()
        getCountryCurrency()
    }

    fun addToRecentViewList(product: ProductX) {
        addToRecentView.postValue(product)
    }

    fun getCartContentFirstTime() {
        var cartID = getCartID()
        if(cartID.isNullOrBlank()){
            if (isUserLogedin())
                createCartForUser(null, null)
            else
                createCartForGuest(null, null, addedFromSheet = false)
        }else {
            mGetOrdersCountInCartExecute.execute(
                CartContentFirstTimeSubscriber(),
                GetOrdersCountInCartExecute.Params(
                    GetOrdersCountInCartRequest(
                        if (getUserIdOrGuestUserID().isEmpty()) 0 else getUserIdOrGuestUserID().toInt(),
                        DEVICE_UID,
                        languageCode,
                        getCountryCode(), cartId = getCartID()
                    )
                )
            )
        }
    }

    fun getCartID(): String? {
        var cartId = MemoryCacheManager.getCartId()
        if(cartId.isNullOrBlank()) {
            return if (isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                repository?.getUserCartIdFromCache()?.toObservable()?.map { t: String ->
                    t
                }?.blockingSingle()
            } else {
                repository?.getGuestCartIdFromCache()?.toObservable()?.map { t: String ->
                    t
                }?.blockingSingle()
            }
        }else{
            return cartId
        }
    }

    fun getPromotion() {

        mPromotionExecution.execute(

            PromotionSubscriber(),

            PromotionExecution.Params(

                PromotionRequestModel(

                    getUserId().toInt(),

                    DEVICE_UID,

                    languageCode

                )

            )

        )
    }

    inner class GetProductGiftsSubscriber() :
        DisposableObserver<ProductsListResponse>() {
        override fun onComplete() {

        }

        override fun onNext(t: ProductsListResponse) {
            Log.e("es", "")
            t.let {
                productGiftstLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        Pair(getCurrencyCode(), t)
                    )
                )
            }
        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                productGiftstLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }


    inner class PromotionSubscriber :

        DisposableObserver<InAppMessageModel>() {

        override fun onError(e: Throwable) {
            e.printStackTrace()
        }


        override fun onNext(t: InAppMessageModel) {

            promotionLiveData.postValue(

                Resource(

                    status = ResourceState.SUCCESS, data = t

                )

            )

        }


        override fun onComplete() {

        }

    }


    fun clearCart() {
        val userId = repository.getUserFromCache().toObservable().map { t -> t.user_id }
            .blockingSingle()
        clearCachedAndRemoteCart.execute(
            ClearCartSubscriber(),
            ClearCachedAndRemoteCart.Params.forUser(userId = userId.toString())
        )
    }

    fun loadAllHomeBlocksAgain() {
        blocksItems?.let {
            it?.map {
                it.isLoaded = false
                it.isLoadedNow = false
            }
        }
    }

    @SuppressLint("CheckResult")
    fun getHomeBlocks() {
        blocksItemsLiveData.postValue(Resource(ResourceState.LOADING))
        val blocks: ArrayList<CompositeBlockItem> = ArrayList()
        repository.layoutBlocks(languageCode, ENABLE_GRAPH_QUERIES_CALLS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io()).subscribe({
                it.sections?.map { section ->
                    val compositeBlockItem = CompositeBlockItem()
                    compositeBlockItem.viewTypeLayout =
                        compositeBlockItem.setType(section.template, section.obIds)
                    compositeBlockItem.pid = section.obIds
                    compositeBlockItem.obIds = section.obIds
                    compositeBlockItem.catId = section.catId
                    compositeBlockItem.sectionName = section.name
                    compositeBlockItem.subTitle = section.subTitle
                    blocks.add(compositeBlockItem)
                }

                val productsIds = getRecentViewProductIds()
                if (productsIds != "") {
                    val compositeBlockItem = CompositeBlockItem()
                    compositeBlockItem.obIds = productsIds
                    compositeBlockItem.viewTypeLayout = ViewTypeLayout.SLIDE_TWO
                    if (productsIds.split(",").size > RECENT_MAX_ITEMS_IN_HOME) {
                        compositeBlockItem.catId = 1
                        val firstSection =
                            productsIds.split(",").subList(0, RECENT_MAX_ITEMS_IN_HOME + 1)
                                .toString()
                        compositeBlockItem.pid = firstSection

                    } else
                        compositeBlockItem.pid = productsIds

                    compositeBlockItem.sectionName = RECENT_VIEW
                    blocks.add(compositeBlockItem)
                }
                if (isConciergeValueFired && conciergeValue) {
                    blocks.add(getConsiergeItem())
                }
                blocksItems = blocks
                blocksItemsLiveData.postValue(Resource(data = true, status = ResourceState.SUCCESS))
            }, { error -> Log.e("get home blocks/", error.toString()) })
    }


     fun updateRecentViewItem(){
        try{
            if(blocksItems.isNullOrEmpty()) return
            val productsIds = getRecentViewProductIds()
            if (productsIds != "") {
                val compositeBlockItem = CompositeBlockItem()
                compositeBlockItem.obIds = productsIds
                compositeBlockItem.viewTypeLayout = ViewTypeLayout.SLIDE_TWO
                if (productsIds.split(",").size > RECENT_MAX_ITEMS_IN_HOME) {
                    compositeBlockItem.catId = 1
                    val firstSection =
                        productsIds.split(",").subList(0, RECENT_MAX_ITEMS_IN_HOME + 1)
                            .toString()
                    compositeBlockItem.pid = firstSection

                } else
                    compositeBlockItem.pid = productsIds

                compositeBlockItem.sectionName = RECENT_VIEW
                var lastBlock =  blocksItems?.get(blocksItems!!.size-1)
                if(lastBlock?.sectionName.equals(RECENT_VIEW)){
                    blocksItems?.removeAt(blocksItems!!.size-1)
                    blocksItems?.add(compositeBlockItem)
                }else{
                    blocksItems?.add(compositeBlockItem)
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    private fun getConsiergeItem(): CompositeBlockItem {
        var conciergeItem = CompositeBlockItem()
        conciergeItem.viewTypeLayout = ViewTypeLayout.CONCIERGE
        return conciergeItem
    }

    fun addReview(
        addReviewRequest: AddReviewRequest,
        sheetView: View
    ) {

        addReviewRequest.user_id =
            repository.getUserFromCache().toObservable().map { t -> t.user_id.toString() }
                .blockingSingle()
        addReviewResponseLiveData.postValue(Resource(ResourceState.LOADING))
        addReview.execute(
            AddReviewSubscriber(sheetView),
            AddReviewToProduct.Params.forReview(
                addReviewRequest
            )
        )
    }

    fun generateTokenByDeviceID(uID: String) {
        getGeneratedToken.execute(
            GeneratedTokenSubscriber(),
            GetGeneratedToken.Params.forUser(token = uID)
        )
    }


    fun setNotificationToken(token: String) {
        val userId = repository.getUserFromCache().toObservable().map { t -> t.user_id }
            .blockingSingle()
        userId.let { id ->
            setFirebaseToken.execute(
                SetFirebaseTokenSubscriber(),
                SetFirebaseToken.Params.forUser(
                    UserTokenRequestBody(
                        userId = id.toString(),
                        token = token
                    )
                )
            )
        }

    }

    fun addToWishList(
        product_id: String,
        options: Map<String, String>? = null,
        position: Int,
        productName: String
    ) {
        addtoWishListresult.postValue(Resource(status = ResourceState.LOADING))
        val request = WishListActionRequest(
            product_id = product_id,
            product_options = options,
            userId = repository.getUserFromCache().toObservable().map { t -> t.user_id.toString() }
                .blockingSingle(),
            country_code = getCountryCode(),
            lang_code = languageCode,
            action = "add", isGraphEnable = ENABLE_GRAPH_QUERIES_CALLS,
            wishListId = if (MemoryCacheManager.getUserData()?.withList_id.isNullOrBlank()) getWishListID() else MemoryCacheManager.getUserData()?.withList_id
        )
        isUserLogedin()
        wishListActions.execute(
            AddToWishListSubscriber(
                position,
                product_id,
                "add",
                addtoWishListresult,
                productName
            ),
            WishListActions.Params.forProduct(request)
        )
    }


    fun getProductOptions(
        product_id: String
    ) {
        ProductOptionsLiveData.postValue(Resource(status = ResourceState.LOADING))

        getProductOptions.execute(
            getProductOptionsSubscriber(),
            GetProductOptions.Params.forProduct(product_id, languageCode)
        )
    }


    fun deleteWishListItem(
        options: Map<String, String>?, index: Int, productID: String, productName: String
    ) {
        removeFromWishListLiveData.postValue(Resource(status = ResourceState.LOADING))
        val userId =
            repository.getUserFromCache().toObservable().map { t -> t.user_id }.blockingSingle()
        val request = WishListActionRequest(
            product_id = productID,
            product_options = options,
            userId = userId.toString(),
            country_code = getCountryCode(),
            lang_code = languageCode,
            action = "delete",
            wishListId = if (MemoryCacheManager.getUserData()?.withList_id.isNullOrBlank()) getWishListID() else MemoryCacheManager.getUserData()?.withList_id,
            sku = productID, isGraphEnable = ENABLE_GRAPH_QUERIES_CALLS
        )

        wishListActions.execute(
            AddToWishListSubscriber(
                index,
                productID,
                "delete",
                removeFromWishListLiveData,
                productName
            ),
            WishListActions.Params.forProduct(request)
        )
    }

    fun addToCart(
        product: ProductX,
        selectedOptions: Map<String, String>? = null,
        addedFromSheet: Boolean = false,
        cartId: String? = ""
    ) {
        createCartForUserLiveData.postValue(
            Resource(
                ResourceState.LOADING,
                true
            )
        )
        if (ENABLE_GRAPH_QUERIES_CALLS) {
            // check on the cart id
            if (MemoryCacheManager.getCartId().isNullOrBlank()) {
                var isLoggedInUser = isUserLogedin()
                if (isLoggedInUser) {
                    var cartIdFromCache =
                        repository?.getUserCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    if (cartIdFromCache?.isNullOrBlank()!!) {
                        createCartForUser(product, selectedOptions, addedFromSheet)
                    } else {
                        addProductToCartForGraph(
                            product,
                            selectedOptions,
                            addedFromSheet,
                            cartIdFromCache
                        )
                    }
                } else {
                    var cartIdFromCache =
                        repository?.getGuestCartIdFromCache()?.toObservable()?.map { t: String ->
                            t
                        }?.blockingSingle()
                    if (cartIdFromCache?.isNullOrBlank()!!) {
                        createCartForGuest(product, selectedOptions, addedFromSheet)
                    } else {
                        addProductToCartForGraph(
                            product,
                            selectedOptions,
                            addedFromSheet,
                            cartIdFromCache
                        )
                    }
                }
            } else {
                addProductToCartForGraph(
                    product,
                    selectedOptions,
                    addedFromSheet,
                    MemoryCacheManager.getCartId()
                )
            }
        } else {
            // addTrackingActionLiveData.postValue(true)
            if (product.has_options > 0 && selectedOptions?.size == null)
                goToChoiceOptionsDialog.postValue(product)
            else {
                if (!addedFromSheet) {
                    productAddeddTocartLiveData.postValue(Resource(status = ResourceState.LOADING))
                }
                var mAddCartRequest = AddItemToCartRequest(
                    product.product_id,
                    product.product_id2,
                    selectedOptions,
                    getUserIdOrGuestUserID().toInt(),
                    DEVICE_UID,
                    languageCode,
                    getCountryCode()
                )
                mAddCartRequest.amount = product.amount!!
                addOrderToCart.execute(
                    AddToCartSubscriber(
                        product.title,
                        product.product_id,
                        product.price,
                        product.image,
                        addedFromSheet
                    ),
                    AddOrderToCart.Params.execute(
                        mAddCartRequest
                    )
                )

            }
        }
    }


    fun isUserLoginWithOpenLogin(): Boolean {

        return if (!isUserLogedin()) {
            goToLoginActivity.postValue(true)
            false
        } else
            true
    }

    private fun isUserLogedin() =
        !repository.getUserFromCache().toObservable().map { t -> t.token }.blockingSingle()
            .isNullOrBlank()

    private fun getWishListID() =
        repository.getUserFromCache().toObservable().map { t -> t.withList_id }.blockingSingle()


    fun loginSucceed() {
        if (ENABLE_GRAPH_QUERIES_CALLS) createCartForUser()
        Log.d("MAinDevelopViewMOdel", "loginSucceed()/ addLocaleCacheToCart")
    }

    private fun mergeCarts(customerCartID: String) {
        try {
            if (customerCartID.isNullOrBlank().not()) {
                repository?.getGuestCartIdFromCache()?.toObservable()
                    ?.map { guestCartId: String ->
                        if (guestCartId.isNullOrBlank().not()) {
                            mMergeCartsExecution.execute(
                                MergeCartsSubscriber(),
                                MergeCartsExecution.Params.execute(
                                    customerCartID, guestCartId
                                )
                            )
                        } else {
                            getCartContentFirstTime()
                        }
                    }?.blockingSingle()
            } else {
                getCartContentFirstTime()
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    fun getCountryCurrency() {
        if (ENABLE_GRAPH_QUERIES_CALLS) {
            mCountryCurrencyExecution.execute(
                CountryCurrencySubscriber(),
                CountryCurrencyExecution.Params.execute(
                    ""
                )
            )
        }
    }


    inner class AddToCartSubscriber(
        private val product: String? = null,
        private val product_id: String? = null,
        private val price: Float = 0f,
        private val image: String? = null,
        private val addedFromSheet: Boolean
    ) : DisposableObserver<AddItemToCartResponse>() {
        override fun onError(e: Throwable) {
            cartLiveData.postValue(Resource(status = ResourceState.ERROR))
            productAddeddTocartLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(t: AddItemToCartResponse) {
            t.let {
                if (it.success == 1) {
                    val product =
                        Product(product = product, price = price, product_id = product_id, percent_off = 0f)
                    addProductToAdjustLiveData.postValue(
                        Resource(
                            status = ResourceState.SUCCESS,
                            data = product
                        )
                    )
                    if (addedFromSheet)
                        productAddedToCartFromSheet.postValue(Resource(status = ResourceState.SUCCESS))
                    else {
                        product.imageLocalForInsider = image
                        productAddeddTocartLiveData.postValue(
                            Resource(
                                status = ResourceState.SUCCESS,
                                data = Pair(
                                    first = true,
                                    second = Pair(
                                        first = product,
                                        second = it.subTotal!!
                                    )
                                )
                            )
                        )

                    }

                    cartLiveData.postValue(
                        Resource(
                            status = ResourceState.SUCCESS,
                            data = Pair(null, t.totalCartProducts)
                        )
                    )
                } else {
                    if (addedFromSheet)
                        productAddedToCartFromSheet.postValue(
                            Resource(
                                status = ResourceState.ERROR,
                                message = it.msg
                            )
                        )
                    else
                        productAddeddTocartLiveData.postValue(
                            Resource(
                                status = ResourceState.ERROR,
                                message = it.msg
                            )
                        )

                    cartLiveData.postValue(Resource(status = ResourceState.ERROR, message = it.msg))
                }
            }
        }

        override fun onComplete() {
            Log.d("ff00", "complete")
        }


    }


    inner class CartContentFirstTimeSubscriber :
        DisposableObserver<GetOrdersCountInCartResponse>() {
        override fun onError(e: Throwable) {
        }

        override fun onNext(t: GetOrdersCountInCartResponse) {
            cartLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS,
                    data = Pair(null, t.totalCartProducts)
                )
            )
        }

        override fun onComplete() {
        }
    }


    inner class GeneratedTokenSubscriber : DisposableObserver<DeviceTokenResponse>() {
        override fun onError(e: Throwable) {
            getDeviceTokenResponseLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(t: DeviceTokenResponse) {
            getDeviceTokenResponseLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS,
                    data = t
                )
            )
        }

        override fun onComplete() {
        }
    }

    inner class ClearCartSubscriber : DisposableCompletableObserver() {
        override fun onComplete() {
            clearCartLiveData.postValue(
                Resource(
                    ResourceState.SUCCESS, data = true
                )
            )
            cartLiveData.postValue(Resource(status = ResourceState.SUCCESS, data = Pair(null, 0)))

        }

        override fun onError(e: Throwable) {
            clearCartLiveData.postValue(Resource(ResourceState.ERROR, message = e.localizedMessage))
        }
    }


    inner class AddToWishListSubscriber(
        private val position: Int,
        private val productId: String,
        private val action: String,
        private val wishListactionLiveData: SingleLiveEvent<Resource<AddToWishListResponse>>,
        private val productName: String
    ) :
        DisposableObserver<AddToWishListResponse>() {
        override fun onError(e: Throwable) {
            wishListactionLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        @SuppressLint("CheckResult")
        override fun onNext(t: AddToWishListResponse) {

//            val cacheAction: Completable = if (action == "delete")
//                repository.deleteWishItemFromCache(productId, countryId = getCountryCode())
//            else
//                repository.insertWishItemToChace(
//                    WishItem(
//                        userId = getUserId(),
//                        produectId = productId,
//                        countryId = getCountryCode()
//                    )
//                )
//            cacheAction.subscribeOn(
//                Schedulers.io()
//            )
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe({
            t.productID = productId
            t.productPosition = position
            wishListactionLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS,
                    data = t
                )
            )
//                }, { error -> Log.e("WishAction/insert/", error.toString()) })

        }

        override fun onComplete() {
        }

    }

    inner class SetFirebaseTokenSubscriber() : DisposableObserver<TokenResponse>() {
        override fun onError(e: Throwable) {
        }

        override fun onNext(t: TokenResponse) {
            Log.d("response", t.toString())
        }

        override fun onComplete() {
        }

    }


    inner class getProductOptionsSubscriber() : DisposableObserver<ProductOptionsResponse>() {
        override fun onError(e: Throwable) {
            ProductOptionsLiveData.postValue(Resource(status = ResourceState.ERROR))
        }

        override fun onNext(t: ProductOptionsResponse) {
            ProductOptionsLiveData.postValue(Resource(status = ResourceState.SUCCESS, data = t))
            Log.d("response", t.toString())
        }

        override fun onComplete() {
        }

    }


    inner class AddReviewSubscriber(val sheetView: View) : DisposableObserver<AddReviewResponse>() {
        override fun onError(e: Throwable) {
            addReviewResponseLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }

        override fun onComplete() {
        }

        override fun onNext(t: AddReviewResponse) {
            addReviewResponseLiveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    Pair(first = t, second = sheetView)
                )
            )
        }
    }


    fun extractDeepLinkUrl(fragment: String?) {
        extractDeepLinkLiveData.postValue(Resource(status = ResourceState.LOADING))
        mExtractDeepLinkExecution.execute(
            GetExtractDeepLinkUrlSubscriber(), ExtractDeepLinkExecution.Params.execute(
                ExtractDeepLinkRequest(
                    fragment
                )
            )
        )
    }

    inner class GetExtractDeepLinkUrlSubscriber() : DisposableObserver<ExtractDeepLinkResponse>() {
        override fun onError(e: Throwable) {
            extractDeepLinkLiveData.postValue(Resource(ResourceState.ERROR))
        }

        override fun onNext(t: ExtractDeepLinkResponse) {
            extractDeepLinkLiveData.postValue(Resource(ResourceState.SUCCESS, t))
        }

        override fun onComplete() {
        }

    }

    inner class CountriesSubscriber() :
        DisposableObserver<ArrayList<CountryResponse>>() {
        override fun onComplete() {
        }

        override fun onNext(t: ArrayList<CountryResponse>) {
            t.let {
                if (it.isNotEmpty())
                    countriesLiveData.postValue(Resource(ResourceState.SUCCESS, it))
            }
        }

        override fun onError(e: Throwable) {
            Log.e("Countries Error", e?.localizedMessage + "")
        }
    }

    inner class updateCurrentCountrySubscriber() : DisposableCompletableObserver() {
        override fun onComplete() {
            updateCountryLiveData.postValue(Resource(status = ResourceState.SUCCESS, data = true))
        }

        override fun onError(e: Throwable) {
            updateCountryLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }
    }

    fun updateCurrentCountry(countiresList: ArrayList<CountryResponse>) {
        var count = 0
        countiresList.forEach {
            if (it.code!!.equals(getCountryCode(), true)) {
                it.isChecked = true
                mSaveCountryExecution.execute(
                    updateCurrentCountrySubscriber(),
                    SaveCountryExecution.Params.forUser(
                        countryResponse = it
                    )
                )
            } else {
                count++
            }
        }
        if (count == countiresList.size) {
            updateCountryLiveData.postValue(
                Resource(
                    status = ResourceState.ERROR,
                    data = false
                )
            )
        }

    }

    fun clearRecentViewProduct() {
        repository.clearRecentViewProducts().blockingAwait()
    }

    fun getRecentViewProductIds(): String {
        return repository.getRecentViewProducts().blockingFirst()
    }

    override fun onCleared() {
        setFirebaseToken.dispose()
        mGetOrdersCountInCartExecute.dispose()
        clearCachedAndRemoteCart.dispose()
        addOrderToCart.dispose()
        setFirebaseToken.dispose()
        getGeneratedToken.dispose()
        mExtractDeepLinkExecution.dispose()
        timer?.cancel()
        super.onCleared()
    }

    fun startFlashTime(startTime: Long) {
        timer = object : CountDownTimer(startTime * 1000, 1000) {
            override fun onFinish() {
                flashTimeLiveData.postValue(Pair(first = true, second = ""))
            }

            override fun onTick(p0: Long) {
                flashTimeLiveData.postValue(
                    Pair(
                        first = false,
                        second = Utils.FormatTime.formatTime(p0)
                    )
                )

            }
        }.start()
    }

    fun updateCurrentLanguageToCache(lang: String) {
        try {
            mSaveCurrentLangauge.execute(
                SaveCurrentLangaugeSubscriber(),
                SaveCurrentLangauge.Params.forUser(
                    lang
                )
            )
        } catch (e: Exception) {
            println("saveUserAuthToCach/SplashVM :" + e.message)
        }
    }

    fun removeAllWishListFromCachedForCurrentCountry() {
        val executor = Executors.newSingleThreadExecutor()
        executor.execute(Runnable {
            repository.deleteAllWishListForCountryFromCache(getCountryCode())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({}, { error -> Log.e("WishAction/remove*/", error.toString()) })
        })
    }

    fun updateConciergeValue(conciergeValue: Boolean) {
        this.conciergeValue = conciergeValue
        this.isConciergeValueFired = true
        var isConciergeAdded = isConciergeItemAddedToBlockList()
        if (!blocksItems.isNullOrEmpty()) {
            if (conciergeValue && !isConciergeAdded) {
                blocksItems?.add(getConsiergeItem())
            } else if (!conciergeValue && isConciergeAdded) {
                for (item in blocksItems!!) {
                    if (item.viewTypeLayout == ViewTypeLayout.CONCIERGE) {
                        blocksItems?.remove(item)
                    }
                }
            }
        }
    }

    private fun isConciergeItemAddedToBlockList(): Boolean {
        try {
            if (!blocksItems.isNullOrEmpty()) {
                for (blockItem in blocksItems!!) {
                    if (blockItem.viewTypeLayout == ViewTypeLayout.CONCIERGE) {
                        return true
                    }
                }
                return false
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return false
    }

    fun removeGiftFromCache() {
        MemoryCacheManager.addGiftModel(null)
    }

    fun removeCartIDsFromCache() {
        println("AKl://removeCartIDsFromCache in MainViewMOdel ")
        MemoryCacheManager?.setCartId("")
        repository.removeGuestCartIdToCache()
        repository.removeUserCartIdToCache()
    }

    inner class SaveCurrentLangaugeSubscriber() : DisposableCompletableObserver() {
        override fun onComplete() {
            println("SaveCurrentLangaugeSubscriber/onComplete")
        }

        override fun onError(e: Throwable) {
            println("SaveCurrentLangaugeSubscriber/onError :" + e.message)
        }
    }

    fun getProdcutsByIDs(productsIDs: String) {
        productsListResponseLiveData.postValue(Resource(status = ResourceState.LOADING))

        repository.getSpecificProducts(
            getCountryCode(),
            languageCode,
            Action.list.toString(),
            100,
            0,
            productsIDs
        )
            .observeOn(AndroidSchedulers.mainThread())?.subscribeOn(Schedulers.io())
            ?.subscribe({
                productsListResponseLiveData.postValue(
                    Resource(
                        status = ResourceState.SUCCESS,
                        data = it
                    )
                )
            }, {
                productsListResponseLiveData.postValue(Resource(status = ResourceState.ERROR))
            })
    }

    fun isUserSessionExpired(message: String): Boolean {
        if (message.isNullOrBlank().not() && message.contains(EXPIRE_SESSION_MESSAGE)) {
            var userModel = getUserInfo()
            if (userModel.email.isNullOrBlank().not() && userModel.password.isNullOrBlank().not()) {
                updateUserTokenLiveData.postValue(
                    Resource(
                        ResourceState.LOADING
                    )
                )
                login.execute(
                    LoginUserSubscriber(false),
                    Login.Params.forUser(
                        userModel.email!!, userModel.password, "", ENABLE_GRAPH_QUERIES_CALLS
                    )
                )
            }
            return true
        }
        return false
    }

    fun isCartNotActive(
        message: String, product: ProductX? = null,
        selectedOptions: Map<String, String>? = null
    ): Boolean {
        if (message.isNullOrBlank().not() && (message.contains(
                CART_NOT_ACTIVE_ERROR,
                true
            ) || message.contains(CART_NOT_FIND_ERROR, true))
        ) {
            if (isUserLogedin()) createCartForUser(
                product = product,
                selectedOptions = selectedOptions
            )
            else createCartForGuest(product, selectedOptions, addedFromSheet = false)
            return true
        }
        return false
    }

    fun isExpiredMessage(
        message: String
    ): Boolean {
        if(isCartNotActive(message)){
            return false
        }else
        if (message.isNullOrBlank().not() && (
                       message.contains(EXPIRE_SESSION_MESSAGE, true)
                    || message.contains(CART_NOT_ACTIVE_ERROR, true)
                    || message.contains(CART_NOT_FIND_ERROR, true)
                    || message.contains(CAN_NOT_ASSIGN_CART_ERROR, true)
                    || message.contains(ALLOWED_FOR_LOGIN_ERROR, true)
                    || message.contains(CUSTOMER_NOT_AUTHORIZED_MESSAGE, true)
                    )
        ) {
            return true
        }
        return false
    }

    fun updateTokenIfUserLoggedIn() {
        try {
            var userModel = getUserInfo()
            if (userModel != null && userModel.email.isNullOrBlank()
                    .not() && userModel?.password.isNullOrBlank().not()
            ) {
                login.execute(
                    LoginUserSubscriber(true),
                    Login.Params.forUser(
                        userModel.email!!, userModel.password, "", ENABLE_GRAPH_QUERIES_CALLS
                    )
                )
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
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
                    restoreCartLiveData.postValue(
                        Resource(
                            ResourceState.ERROR
                        )
                    )
                }
            } else {
                var cartId = repository?.getGuestCartIdFromCache()?.toObservable()?.map { t: String ->
                    t
                }?.blockingSingle()
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

    inner class LoginUserSubscriber(val isFirstUpdate: Boolean) :
        DisposableObserver<AuthenticationResponse>() {
        override fun onNext(t: AuthenticationResponse) {
            t.let { _ ->
                t.isFirstUpdate = isFirstUpdate
                updateUserTokenLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        t
                    )
                )
                createCartForUser()
            }
        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            updateUserTokenLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }
    }

    inner class MergeCartsSubscriber() :
        DisposableObserver<MergeCartsResponse>() {
        override fun onNext(t: MergeCartsResponse) {
            repository.removeGuestCartIdToCache()
            getCartContentFirstTime()
        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            getCartContentFirstTime()
        }
    }

    inner class CountryCurrencySubscriber() :
        DisposableObserver<CountryCurrenceResponse>() {
        override fun onNext(t: CountryCurrenceResponse) {
            if (t?.errorsListModel.isNullOrEmpty()) {
                t?.data?.currencyModel?.default_display_currency_code?.let {
                    setCurrencyCode(it)
                }
            }

        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
        }
    }

    fun getMyWallet() {
        walletLiveData.postValue(Resource(ResourceState.LOADING))
        mGetWalletExecution.execute(
            GetWalletExecutionSubscriber(),
            GetWalletExecution.Params.execute(languageCode)
        )
    }

    fun logoutFun() {
        removeGiftFromCache()
        removeCartIDsFromCache()
        MemoryCacheManager?.setCartId("")
        logout(false)
    }

    inner class GetWalletExecutionSubscriber() :
        DisposableObserver<WalletResponse>() {
        override fun onError(e: Throwable) {
            walletLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }

        override fun onNext(t: WalletResponse) {
            walletLiveData.postValue(Resource(ResourceState.SUCCESS, t))
        }

        override fun onComplete() {
        }
    }

}