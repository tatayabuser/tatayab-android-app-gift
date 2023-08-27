package com.tatayab.data


import android.annotation.SuppressLint
import android.os.Build
import android.util.Log
import androidx.annotation.RequiresApi
import com.tatayab.data.repository.TatayabCache
import com.tatayab.data.source.TatayabDataSourceFactory
import com.tatayab.data.source.WishListMemoryCacheManager
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.*
import com.tatayab.model.db.WishItem
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.requests.*
import com.tatayab.model.requests.graph_request.AddItemToCartGraphRequest
import com.tatayab.model.responses.*
import com.tatayab.model.responses.graph_responses.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TatayabDataRepository @Inject constructor(
    private val cache: TatayabCache,
    private val factory: TatayabDataSourceFactory
) : TatayabRepository {

    val countryId = cache.getUserSettingFromCache().blockingGet().country?.code
    val userId = cache.getUserFromCache().blockingGet().user_id
    val token = cache.getUserFromCache().blockingGet().token
    override fun insertWishItemToChace(wishItem: WishItem): Completable {
        return cache.insertWishItem(wishItem)
    }


    override fun deleteAllWishListForCountryFromCache(countryId: String): Completable {
         return cache.deleteAllWishListForCountryFromCache(countryId)
    }

    override fun getOptionsForProduct(
        lang_code: String,
        productId: String
    ): Observable<ProductOptionsResponse> {
        return factory.getRemoteDataSource().getOptionsForProduct(lang_code, productId)
            .toObservable()
    }

    override fun deleteWishItemFromCache(productId: String, countryId: String): Completable {
        return cache.deleteWishItemFromCache(productId, countryId)
    }

    override fun getUpgradeVersion(version: String): Observable<CheckVersionResponse> {
        return factory.getRemoteDataSource().getUpgradeVersion(version).toObservable()
    }

    override fun getOrderStatues(
        userId: String,
        orderId: String,
        languageCode: String
    ): Observable<OrderTrackingResponse> {
        return factory.getRemoteDataSource().getOrderStatues(userId, orderId, languageCode)
            .toObservable()
    }

    override fun saveFirebaseToken(userTokenRequestBody: SaveFirebaseTokenRequestBody): Observable<TokenResponse> {
        return factory.getRemoteDataSource().saveFirebaseToken(userTokenRequestBody).toObservable()
    }

    override fun getOrderDetails(
        userId: String,
        orderId: String,
        languageCode: String
    ): Observable<OrderDetailsResponse> {
        return factory.getRemoteDataSource().getOrderDetails(userId, orderId, languageCode)
            .toObservable()
    }

    override fun getProductsByKey(
        query: String,
        page: Int,
        languageCode: String
    ): Observable<SearchProductListResponse> {
        return factory.getRemoteDataSource().searchInProducts(query, page, languageCode)
            .toObservable()
    }

    override fun setShippingMethod(
        customer_cart: String, carrier_code: String, method_code: String
    ): Observable<SetShippingMethodResponse> {
        return factory.getRemoteDataSource()
            .setShippingMethod(customer_cart, carrier_code, method_code).toObservable()
    }

    override fun getShippingMethods(
        customer_cart: String
    ): Observable<ShippingMethodsResponse> {
        return factory.getRemoteDataSource().getShippingMethods(customer_cart).toObservable()
    }

    override fun getWishListProducts(
        addToWishListRequest: WishListActionRequest
    ): Observable<WishListResponse> {
        if (addToWishListRequest?.isGraphEnable!!) {
            return factory.getRemoteDataSource()
                .getWishListProducts(addToWishListRequest.lang_code, addToWishListRequest)
                .doOnNext {
                    if (it?.id.isNullOrBlank()
                            .not()
                    ) WishListMemoryCacheManager.saveUserWishListId(it.id!!)
                    val WishlistItems = CacheWishListItems(it.products?.map {
                        CacheWishListItem(
                            it.productWishListId?.toInt(),
                            it.product_sku,
                            addToWishListRequest?.product_options
                        )
                    })
                    WishListMemoryCacheManager.clearWishListItems()
                    WishListMemoryCacheManager.saveWishListItems(WishlistItems)
                }
                .toObservable()
        } else {
            return factory.getRemoteDataSource()
                .getWishListProducts(addToWishListRequest.lang_code, addToWishListRequest)
                .toObservable()
        }
    }


    @RequiresApi(Build.VERSION_CODES.N)
    override fun addToWishList(addToWishListRequest: WishListActionRequest): Observable<AddToWishListResponse> {
        if (addToWishListRequest?.isGraphEnable!!) {
            addToWishListRequest.wishListId = WishListMemoryCacheManager.getUserWishListId()
            return factory.getRemoteDataSource().addToWishList(addToWishListRequest).toObservable()
                .doAfterNext {
                    if (addToWishListRequest.action == "add")
                        WishListMemoryCacheManager.addToWishListItems(
                            Pair(
                                it.productWishListId.toString(),
                                addToWishListRequest.product_id
                            )
                        )
                    else
                        WishListMemoryCacheManager.removeFromWishList(addToWishListRequest.product_id)
                }
        } else {
            return factory.getRemoteDataSource().addToWishList(addToWishListRequest).toObservable()
        }
    }

    override fun getUserOrders(
        userId: String,
        page: Int,
        itemPerPage: Int,
        languageCode: String
    ): Observable<OrdersResponse> {
        return factory.getRemoteDataSource().getUserOrders(userId, page, itemPerPage, languageCode)
            .toObservable()
    }

    override fun deleteUserAddress(deleteAddressRequest: DeleteAddressRequest): Observable<AddressResponse> {
        return factory.getRemoteDataSource().deleteUserAddress(deleteAddressRequest).toObservable()

    }

    override fun createOrder(createOrderRequest: CreateOrderRequest): Observable<CreateOrderResponse> {
        return factory.getRemoteDataSource().createOrder(createOrderRequest).toObservable()
    }

    override fun getFilter(map: Map<String, String>): Observable<FilterResponse> {
        return factory.getRemoteDataSource().getFilter(map).toObservable()
    }

    override fun setFirebaseToken(userTokenRequestBody: UserTokenRequestBody): Observable<TokenResponse> {
        return factory.getRemoteDataSource().setFirebaseToken(userTokenRequestBody).toObservable()
    }

    override fun getUserAddresses(
        userId: String, languageCode: String
    ): Observable<ArrayList<AddressRequest>> {
        return factory.getRemoteDataSource().getUserAddresses(userId, languageCode).toObservable()
    }

    override fun getCities(
        lang_code: String,
        mGetCitiesRequest: GetCitiesRequest
    ): Observable<List<CityModel>> {
        return factory.getRemoteDataSource().getCities(lang_code, mGetCitiesRequest)
    }

    override fun getAreas(
        lang_code: String,
        mGetAreaRequest: GetAreaRequest
    ): Observable<List<AreaModel>> {
        return factory.getRemoteDataSource().getAreas(lang_code, mGetAreaRequest)
    }

    override fun addUserAddress(addressRequest: AddressRequest): Observable<AddressResponse> {
        return factory.getRemoteDataSource().addUserAddress(addressRequest).toObservable()
    }

    override fun addReviewToProduct(addReviewRequest: AddReviewRequest): Observable<AddReviewResponse> {
        return factory.getRemoteDataSource().addReviewToProduct(addReviewRequest).toObservable()
    }

    override fun updateProductAmountRemote(
        productIdRemote: String,
        productIdCache: String,
        updateProductAmount: UpdateProductAmountRequest
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>> {
        return factory.getRemoteDataSource()
            .updateProductAmountRemote(productIdRemote, updateProductAmount)
            .concatMap {
                cache.updateProductAmount(
                    productIdCache,
                    updateProductAmount.amount.toInt(),
                    updateProductAmount.productOptions!!
                )
            }.onErrorResumeNext(Observable.empty())
    }

    override fun updateProductAmountCache(
        productId: String,
        amount: Int,
        options: Map<String, String>
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>> {
        return cache.updateProductAmount(productId, amount, options)
    }

    override fun applyCoupon(applyCouponRequest: ApplyCouponRequest): Observable<CouponResponse> {
        return factory.getRemoteDataSource().applyCoupon(applyCouponRequest).toObservable()
    }

    override fun getProductReviwers(
        productId: String,
        options: Map<String, String>,
        page: Int,
        itemPerPage: Int
    ): Observable<ProductReviewsResponse> {
        return factory.getRemoteDataSource()
            .getProductReviewers(productId, options, page, itemPerPage)
    }

    override fun addConcierge(conciergeRequestBody: ConciergeRequestBody): Observable<ConciergeResponse> {
        return factory.getRemoteDataSource().addConcierge(conciergeRequestBody)
    }


    override fun saveUserSettingToCache(userSetting: UserSetting): Completable {
        return cache.saveUserSettingToCache(userSetting)
    }

    override fun getUserSettingFromCache(): Maybe<UserSetting> {
        return cache.getUserSettingFromCache()
    }

    override fun saveUserAuthToCache(userSetting: UserAuth): Completable {
        return cache.saveUserAuthToCache(userSetting)
    }

    override fun saveCurrentLanguageToCache(lang: String): Completable {
        return cache.savecurrentLanguageToCache(lang)
    }

    override fun getCurrentLanguageFromCache(): Maybe<String> {
        return cache.getcurrentLanguageFromCache()
    }

    override fun getUserAuthFromCache(): Maybe<UserAuth> {
        return cache.getUserAuthFromCache()
    }

    override fun getGuestAddressFromCache(): Maybe<Address> {
        return cache.getGuestAddressFromCache()
    }


    override fun setGuestAddressFromCache(address: Address?): Completable {
        return cache.setGuestAddressFromCache(address)
    }

    override fun getGeneratedCode(token: String): Observable<DeviceTokenResponse> {
        return factory.getRemoteDataSource().getGeneratedCode(token).toObservable()
    }

    override fun addNotifyMeAction(productActionRequest: ProductActionRequest): Observable<NormalResponse> {
        return factory.getRemoteDataSource().addNotifyMeAction(productActionRequest).toObservable()
    }

    override fun getProductsForSearch(
        action: String,
        lang_code: String
    ): Observable<ProductsListResponse> {
        return factory.getRemoteDataSource().getProductsForSearch(action, lang_code).toObservable()
    }

    override fun getSubCategories(categoryRequest: CategoryRequest): Observable<ArrayList<SubCategoriesResponse>> {
        return factory.getRemoteDataSource().getSubCategories(categoryRequest).toObservable()
    }

    override fun getCurriencies(languageCode: String): Observable<ArrayList<CurrencyResponse>> {
        return factory.getRemoteDataSource().getCurrencies(languageCode).toObservable()
    }

    override fun getCountries(languageCode: String): Observable<ArrayList<CountryResponse>> {
        return factory.getRemoteDataSource().getCountries(languageCode).toObservable()
    }

    override fun removeItemFromCartRemote(
        cartRemoveRequestBody: CartRemoveRequestBody,
        productId: String,
        options: Map<String, String>
    ): Observable<Int> {
        return factory.getRemoteDataSource().removeItemFromCartRemote(cartRemoveRequestBody)
            .andThen(
                cache.removeItemFromCartCached(productId, options)
            )

    }

    override fun clearCartRemote(cartRemoveRequestBody: CartRemoveRequestBody): Completable {
        return factory.getRemoteDataSource().clearCartRemote(cartRemoveRequestBody).doOnComplete {
            cache.clearCartCache()
        }
    }

    override fun getCartConfig(
        languageCode: String
    ): Observable<CartConfigResponse> {

        return cache.getCartItems().flatMap { items ->
            if (items.isNotEmpty()) {
                val ids = items.joinToString(separator = ",")
                factory.getRemoteDataSource().getCartConfig(languageCode, ids)
                    .toObservable()
            } else {
                Observable.empty()
            }
        }
    }

    override fun getSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Observable<SuppliersResponse> {
        return factory.getRemoteDataSource()
            .getSuppliers(page, itemPerPage, languageCode, sortedMap)
            .toObservable()
    }

    override fun getNewSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Observable<ArrayList<SupplierResponse>> {
        return factory.getRemoteDataSource()
            .getNewSuppliers(page, itemPerPage, languageCode, sortedMap)
            .toObservable()
    }

    override fun addOrderToCart(addToCartRequest: AddItemToCartRequest): Observable<AddItemToCartResponse> {
        return factory.getRemoteDataSource().addOrderToCart(addToCartRequest).toObservable()
    }

    override fun checkoutReview(
        languageCode: String,
        mReviewCartRequest: ReviewCartRequest
    ): Observable<ReviewCartResponse> {
        return factory.getRemoteDataSource().checkoutReview(languageCode, mReviewCartRequest)
            .toObservable().doOnNext {
                it?.productsList?.let {
                    if (!it.isNullOrEmpty()) {
                        it[0].products?.forEach { product ->
                            product.isInWishList = WishListMemoryCacheManager.isProductInWishList(
                                product.productSku ?: ""
                            )!!

//                            cache.checkIfExists(
//                                product.ref.toString(),
//                                countryId!!,
//                                userId.toString()
//                            ).blockingGet() > 0
                        }
                    }
                }

            }
    }


    override fun sendPaymentMethod(
        languageCode: String,
        mPaymentMethodRequest: PaymentMethodRequest
    ): Observable<ReviewCartResponse> {
        return factory.getRemoteDataSource()
            .sendPaymentMethod(languageCode, mPaymentMethodRequest)
            .toObservable()
    }

    override fun applyCoupon(
        languageCode: String,
        mAddCouponRequest: AddCouponRequest
    ): Observable<ReviewCartResponse> {
        return factory.getRemoteDataSource().applyCoupon(languageCode, mAddCouponRequest)
            .toObservable()
    }

    override fun removeCoupon(
        languageCode: String,
        mRemoveCouponRequest: RemoveCouponRequest
    ): Observable<ReviewCartResponse> {
        return factory.getRemoteDataSource().removeCoupon(languageCode, mRemoveCouponRequest)
            .toObservable()
    }

    override fun createOrder(
        user_id: String, languageCode: String,
        country_code: String,
        action: String,
        device_id: String, is_gift: Int,
        gift_sender_name: String,
        gift_receiver_name: String,
        gift_msg: String,
        cartId: String
    ): Observable<CreateOrderResponse> {
        return factory.getRemoteDataSource()
            .createOrder(
                user_id,
                languageCode,
                country_code,
                action,
                device_id,
                is_gift,
                gift_sender_name,
                gift_receiver_name,
                gift_msg,
                cartId
            )
            .toObservable()
    }


    override fun deleteOrderFromCart(mDeleteItemFromCartRequest: DeleteItemFromCartRequest): Observable<AddItemToCartResponse> {
        return factory.getRemoteDataSource().deleteOrderFromCart(mDeleteItemFromCartRequest)
            .toObservable()
    }

    override fun getOrdersCountInCart(mGetOrdersCountInCartRequest: GetOrdersCountInCartRequest): Observable<GetOrdersCountInCartResponse> {
        return factory.getRemoteDataSource().getOrdersCountInCart(mGetOrdersCountInCartRequest)
            .toObservable()
    }

    override fun updateCartItemAmount(mUpdateItemInCartRequest: UpdateItemInCartRequest): Observable<AddItemToCartResponse> {
        return factory.getRemoteDataSource().updateOrderInCart(mUpdateItemInCartRequest)
            .toObservable()
    }

    override fun getOrdersFromCart(
        languageCode: String,
        mGetOrdersFromCartRequest: GetOrdersFromCartRequest
    ): Observable<GetOrdersFromCartResponse> {
        return factory.getRemoteDataSource()
            .getOrdersFromCart(languageCode, mGetOrdersFromCartRequest).toObservable()

    }


    override fun getRemoteCartContent(
        userId: String,
        languageCode: String
    ): Observable<CartContentResponse> {
        return factory.getRemoteDataSource().getRemoteCartContent(userId, languageCode)
            .toObservable().doOnNext { cartResponse ->
                cartResponse.products?.forEach {
                    it.productOptionsDetailed =
                        getSavedVariant(it.productOptions, it.productOptionsDetailed)
                    if (userId != "-1")
                        it.isInWishList =
                            WishListMemoryCacheManager.isProductInWishList(it.productId ?: "")

//                    cache.checkIfExists(
//                                it.productId!!,
//                                countryId!!,
//                                userId
//                            ).blockingGet() > 0
                }
            }

    }

    override fun customerAlsoBought(
        productId: String,
        languageCode: String
    ): Observable<CustomerFeaturedProductsResponse> {
        return factory.getRemoteDataSource().customerAlsoBought(productId, languageCode)
            .toObservable().doOnNext {
                if (userId != -1)
                    it.products.map {
                        it.mFullDetailsModel?.is_In_WishList = cache.checkIfExists(
                            it.mFullDetailsModel?.product_id!!.toString(),
                            countryId!!, userId.toString()
                        ).blockingGet() > 0
                    }
            }
    }


    @SuppressLint("CheckResult")
    override fun login(
        loginRequestBody: LoginRequestBody
    ): Observable<AuthenticationResponse> {
        if (loginRequestBody?.isGraphEnable == true) {
            return factory.getRemoteDataSource().login(loginRequestBody).toObservable().flatMap {

                saveUserDataToCache(it).blockingFirst() // save to get profile with token
                getUserProfile(it.token, it.password)
            }
        } else {
            return factory.getRemoteDataSource().login(loginRequestBody).toObservable().doOnNext {
                it.let { user ->
                    it.let { user ->
                        cache.saveUserToCache(user).subscribeOn(Schedulers.io())
                            .observeOn(Schedulers.computation())
                            .subscribe({}, { error -> Log.e("login/remove*/", error.toString()) })
                    }
                }
            }
        }

        //. {
//                it.let { user ->


//                    if (it?.message.isNullOrBlank()) {
//                        user.password = loginRequestBody.password
//                        getWishListProducts(WishListActionRequest()).subscribeOn(Schedulers.io())
//                            .observeOn(Schedulers.computation()).subscribe({}, {})
//                        cache.saveUserToCache(user).subscribeOn(Schedulers.io())
//                            .observeOn(Schedulers.computation())
//                            .subscribe({}, { error -> Log.e("login/remove*/", error.toString()) })
//                    }
        //     }
        //    }
    }


    override fun socialMediaLogin(
        lang_code: String,
        mSocialLoginRequestBody: SocialLoginRequestBody
    ): Observable<AuthenticationResponse> {
//        if (mSocialLoginRequestBody?.isGraphEnable == true) {
            return factory.getRemoteDataSource()
                .socialMediaLogin(lang_code, mSocialLoginRequestBody)
                .toObservable().flatMap {
                    it?.firstname = mSocialLoginRequestBody?.name
                    it?.email = mSocialLoginRequestBody?.email
                    saveUserDataToCache(it).blockingFirst() // save to get profile with token
                    getUserProfile(it.token, it.password)
                }
//        } else {
//            return factory.getRemoteDataSource()
//                .socialMediaLogin(lang_code, mSocialLoginRequestBody).toObservable().doOnNext {
//                    it.let { user ->
//                        it.let { user ->
//                            cache.saveUserToCache(user).subscribeOn(Schedulers.io())
//                                .observeOn(Schedulers.computation())
//                                .subscribe(
//                                    {},
//                                    { error -> Log.e("social login/", error.toString()) })
//                        }
//                    }
//                }
//        }
    }

    override fun addProductToRecentView(productId: String): Completable {
        return Completable.defer {
            cache.addProductToRecentView(productId)
            Completable.complete()
        }
    }

    override fun getRecentViewProducts(): Observable<String> {
        return cache.getRecentViewProducts().toObservable()
    }


    private fun reportNetworkError(tag: String, throwable: Throwable) {
        println("$tag - ${throwable.toString()}")
    }

    override fun getProductForCategory(
        options: Map<String, String>,
        page: Int,
        itemPerPage: Int
    ): Observable<ProductsListResponse> {
        return factory.getRemoteDataSource()
            .getProductForCategory(options, page, itemPerPage).toObservable()
    }

    override fun getProductGift(countryCode:String,cityCode:String
    ): Observable<ProductsListResponse> {
        return factory.getRemoteDataSource().getProductGift(countryCode,cityCode).toObservable()
    }

    override fun getMyWallet(
    ): Observable<WalletResponse> {
        return factory.getRemoteDataSource().getMyWallet()
            .toObservable()
    }

    override fun getAllTransactions(
    ): Observable<TransactionsHistoryResponse> {
        return factory.getRemoteDataSource()
            .getAllTransactions().toObservable()
    }

    override fun getUserToken(
        osused: String,
        session: String,
        devid: String
    ): Observable<UserTokenResponse> {
        return factory.getRemoteDataSource().getUserToken(osused, session, devid).toObservable()
    }

    override fun addRedeemCode(
        mRedeemCodeRequest: RedeemCodeRequest
    ): Observable<RedeemCodeResponse> {
        return factory.getRemoteDataSource()
            .addRedeemCode(mRedeemCodeRequest).toObservable()
    }

    override fun logout(): Observable<LogoutResponse> {
        return factory.getRemoteDataSource()
            .logout().toObservable()
    }

    override fun changePassword(editProfileRequestBody: ChangePasswordRequest): Observable<EditUserProfileResponse> {
        return factory.getRemoteDataSource().changePassword(editProfileRequestBody).toObservable()
    }

    override fun inviteFriend(
        mInviteFriendRequest: InviteFriendRequest
    ): Observable<InviteFriendResponse> {
        return factory.getRemoteDataSource().inviteFriend(mInviteFriendRequest).toObservable()
    }

    override fun checkEarn(
        mInviteFriendRequest: InviteFriendRequest
    ): Observable<InviteFriendResponse> {
        return factory.getRemoteDataSource().checkEarn(mInviteFriendRequest).toObservable()
    }

    override fun checkCashBack(orderId: String): Observable<CheckCashBackResponse> {
        return factory.getRemoteDataSource().checkCashBack(orderId).toObservable()
    }

    override fun getCategoryBanners(
        lang_code: String,
        category_id: String
    ): Observable<CategoryBannerResponse> {
        return factory.getRemoteDataSource().getCategoryBanners(lang_code, category_id)
            .toObservable()
    }

    override fun updateUserTokenWithCountryOrLanguage(
        country_code: String,
        lang_code: String
    ): Observable<UserUpdateTokenResponse> {
        return factory.getRemoteDataSource().updateUserTokenWithCountryOrLanguage(
            country_code,
            lang_code
        ).toObservable()
    }

    override fun forgetPassword(
        email: String,
        languageCode: String
    ): Observable<NormalResponse> {
        return factory.getRemoteDataSource().forgetPassword(email, languageCode).toObservable()
    }

    override fun register(
        registerRequestBody: RegisterRequestBody,
        languageCode: String
    ): Observable<AuthenticationResponse> {
        return factory.getRemoteDataSource()
            .register(registerRequestBody, languageCode)
            .toObservable().doOnNext {
                it.let { user ->
                    if (user.user_id > 0) {
                        if (registerRequestBody.reg_type.equals("guest", true)) {
                            user.guestuser_id = user.user_id
                            user.user_id = 0
                        }
                        getWishListProducts(WishListActionRequest()).subscribeOn(Schedulers.io())
                            .observeOn(Schedulers.computation()).subscribe({}, {})
                        cache.saveUserToCache(user).subscribeOn(Schedulers.io())
                            .observeOn(Schedulers.computation())
                            .subscribe({}, { error -> Log.e("register", error.toString()) })
                    }
                }
            }
    }


    override fun getUserProfile(userId: String): Observable<GetUserProfileResponse> {
        return factory.getRemoteDataSource().getUserProfile(userId).toObservable()
    }

    override fun editProfile(editProfileRequestBody: ProfileActionRequest): Observable<EditUserProfileResponse> {
        return factory.getRemoteDataSource().editUserProfile(editProfileRequestBody).toObservable()
            .doOnNext {
                it.let {
                    val userProfile = cache.getUserFromCache().blockingGet()
                    userProfile.firstname = editProfileRequestBody.fullname
                    cache.saveUserToCache(userProfile).subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.computation())
                        .subscribe({}, { error -> Log.e("edit profile", error.toString()) })
                }
            }
    }


    override fun getCategories2(categoryRequest: CategoryRequest): Observable<ArrayList<CategoryItem>> {
        return factory.getRemoteDataSource().getCategories2(categoryRequest).toObservable()
    }

    private fun getOptions(cachedProductOptions: Map<String, ProductOptionsDetailed>?): Map<String, String>? {
        val map: MutableMap<String, String> = mutableMapOf<String, String>()
        cachedProductOptions?.forEach {
            map[it.key] = it.value.variants?.values?.first()?.variant_id!!
        }

        return map
    }


    override fun getCartItems(): Observable<MutableList<String>> {
        return cache.getCartItems()
    }

    override fun getSearchSuggestionListFromCache(): Observable<MutableList<SearchModel>> {
        return cache.getSearchSuggestionsFromCache()
    }

    override fun saveSearchSuggestionToCache(searchModel: SearchModel): Int {
        return cache.saveSearchSuggestionToCache(searchModel)
    }

    override fun saveSearchSuggestionListToCache(suggestionList: List<SearchModel>): Int {
        return cache.saveSearchSuggestionListToCache(suggestionList)
    }


    override fun clearCartCache(): Completable {
        return Completable.defer {
            cache.clearCartCache()
            Completable.complete()
        }
    }

    override fun clearRecentViewProducts(): Completable {
        return Completable.defer {
            cache.clearRcentViewProducts()
            Completable.complete()
        }
    }

    override fun clearCartCachedAndRemote(userId: String): Completable {
        return Completable.defer {
            cache.clearCartCache()
            Completable.complete()
        }
            .andThen(
                factory.getRemoteDataSource()
                    .clearCartRemote(CartRemoveRequestBody(userId = userId))
            )
    }


    override fun getCartSize(): Observable<Int> {
        return cache.getCartSize()
    }


    override fun deleteUserFromCache(): Observable<Boolean> {
        return cache.deleteUserFromCache().doOnNext {
            cache.clearCartCache()
        }
    }

    override fun saveUserToCache(userDataObject: AuthenticationResponse): Completable {
        return cache.saveUserToCache(userDataObject)
    }

    override fun getUserFromCache(): Maybe<AuthenticationResponse> {
        return cache.getUserFromCache()
    }

    override fun getUserCartIdFromCache(): Maybe<String> {
        return cache.getUserCartIdFromCache()
    }

    override fun getGuestCartIdFromCache(): Maybe<String> {
        return cache.getGuestCartIdFromCache()
    }

    override fun removeUserCartIdToCache() {
        cache.removeUserCartIdToCache().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({}, { error -> Log.e("remove cart id ", error.toString()) })
    }

    override fun removeGuestCartIdToCache() {
        cache.removeGuestCartIdToCache().subscribeOn(Schedulers.io())
            .observeOn(Schedulers.computation())
            .subscribe({}, { error -> Log.e("remove guest cart id ", error.toString()) })
    }

    override fun removeGuestAddressFromCache(): Boolean {
        return cache.removeGuestAddressFromCache()
    }


    override fun getProductDetails(
        productId: String,
        languageCode: String, country_code: String
    ): Observable<ProductDetailsResponse> {
        return factory.getRemoteDataSource().getProductDetails(productId, languageCode,country_code = country_code)
            .toObservable().doOnNext {
                cache.addProductToRecentView(productId).blockingAwait()
                if (token.isBlank().not())
                    it.is_In_WishList =
                        WishListMemoryCacheManager.isProductInWishList(it.productSku ?: "")!!
                it.productOptions
//                        cache.checkIfExists(
//                            it?.productId.toString(),
//                            countryId!!,
//                            userId.toString()
//                        ).blockingGet() > 0
            }
    }

    override fun applyPromotion(promotionRequest: PromotionRequest): Observable<List<PromotionValue>> {
        return factory.getRemoteDataSource().applyPromotion(promotionRequest).toObservable()
    }

    @SuppressLint("CheckResult")
    override fun layoutBlocks(
        languageCode: String,
        enableGraph: Boolean
    ): Observable<HomeBlocksResponse> {
        return factory.getRemoteDataSource().layoutBlocks(languageCode)
            .doAfterNext { getWishListProducts(WishListActionRequest(isGraphEnable = enableGraph)).blockingFirst() }
            .toObservable()
    }

    override fun blockLayout(
        catId: String,
        blockId: String,
        languageCode: String

    ): Observable<List<Banner>> {
        return factory.getRemoteDataSource().blockLayout(blockId, languageCode).toObservable()
    }

    override fun extrctDeepLinkUrl(mExtractDeepLinkRequest: ExtractDeepLinkRequest): Observable<ExtractDeepLinkResponse> {
        return factory.getRemoteDataSource().extrctDeepLinkUrl(mExtractDeepLinkRequest)
            .toObservable()
    }

    override fun getSpecificProducts(
        country_code: String,
        lang_code: String,
        action: String,
        items_per_page: Int,
        page: Int,
        pid: String
    ): Observable<ProductsListResponse> {
        return factory.getRemoteDataSource()
            .getSpecificProducts(country_code, lang_code, action, items_per_page, page, pid)
            .toObservable()
            .doOnNext {
                it.products?.forEach {
                    it?.inWishlist = if (WishListMemoryCacheManager.isProductInWishList(
                            it?.product_id ?: ""
                        )!!
                    ) 1 else 0

//                    cache.checkIfExists(
//                        it?.product_id.toString(),
//                        countryId.toString(),
//                        userId.toString()
//                    ).blockingGet()
                }
            }
    }


    override fun getPromotion(
        mPromotionRequestModel: PromotionRequestModel
    ): Observable<InAppMessageModel> {
        return factory.getRemoteDataSource().getPromotion(mPromotionRequestModel).toObservable()
    }

    override fun getSelectAddress(AddressRequest: SelectedGuestAddressRequest): Observable<SelectAddressResponse> {
        return factory.getRemoteDataSource().getSelectAddress(AddressRequest).toObservable()
    }

    override fun createCart(): Observable<CreateCartResponse> {
        return factory.getRemoteDataSource().createCart().toObservable().doOnNext {
            it.let { cartResponse ->
                cache.saveUserCartIdToCache(cartResponse?.data?.customerCart?.id.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .subscribe({}, { error -> Log.e("create new cart*/", error.toString()) })
            }
        }
    }

    override fun createGuestCart(): Observable<CreateGuestCartResponse> {
        return factory.getRemoteDataSource().createGuestCart().toObservable().doOnNext {
            it.let { cartResponse ->
                cache.saveGuestCartIdToCache(cartResponse?.data?.createEmptyCartID.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .subscribe({}, { error -> Log.e("create new cart/guest", error.toString()) })
            }
        }
    }

    override fun restoreCart(cartId: String?): Observable<RestoreCartResponse> {
        return factory.getRemoteDataSource().restoreCart(cartId).toObservable().doOnNext {
            it.let { cartResponse ->
                cache.saveGuestCartIdToCache(it?.data?.restoreCart.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .subscribe({}, { error -> Log.e("restore/guest", error.toString()) })
                cache.saveUserCartIdToCache(it?.data?.restoreCart.toString())
                    .subscribeOn(Schedulers.io())
                    .observeOn(Schedulers.computation())
                    .subscribe({}, { error -> Log.e("restore/user", error.toString()) })

            }
        }
    }

    override fun mergeCarts(
        customerCartId: String?,
        guestCartId: String?
    ): Observable<MergeCartsResponse> {
        return factory.getRemoteDataSource().mergeCarts(customerCartId, guestCartId).toObservable()
            .doOnNext {
                it?.let {
                    cache.removeGuestCartIdToCache().subscribeOn(Schedulers.io())
                        .observeOn(Schedulers.computation()).subscribe({}, {})
                }
            }
    }

    override fun getCountryCurrency(
    ): Observable<CountryCurrenceResponse> {
        return factory.getRemoteDataSource().getCountryCurrency().toObservable()
    }

    override fun checkTokenValidation(token: String): Observable<CheckTokenValidationResponse> {
        return factory.getRemoteDataSource().checkTokenValidation(token).toObservable()
    }
    override fun AddProductToGraphCart(mAddItemToCartGraphRequest: AddItemToCartGraphRequest?): Observable<AddProductToCartResponse> {
        return factory.getRemoteDataSource().AddProductToGraphCart(mAddItemToCartGraphRequest)
            .toObservable()
    }

    override fun setShippingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Observable<ShippingAddressResponse> {
        return factory.getRemoteDataSource().setShippingAddressOnCart(mShippingAddressRequest)
            .toObservable()
    }

    override fun setBillingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Observable<ShippingAddressResponse> {
        return factory.getRemoteDataSource().setBillingAddressOnCart(mShippingAddressRequest)
            .toObservable()
    }

    override fun setGuestEmailOnCart(
        cartId: String?,
        email: String?
    ): Observable<AddGuestEmailToCartResponse> {
        return factory.getRemoteDataSource().setGuestEmailOnCart(cartId, email).toObservable()
    }

    fun getUserProfile(token: String, password: String): Observable<AuthenticationResponse> {
        return factory.getRemoteDataSource().getUserProfile().toObservable().flatMap {
            it.let { user ->
                it.customerDataModel.customerModel?.let {
                    //    var userProfileFromCache = cache.getUserFromCache().blockingGet()
                    it.wishlists?.takeIf { !it.isNullOrEmpty() }?.get(0)?.id?.let { it1 ->
                        WishListMemoryCacheManager.saveUserWishListId(
                            it1
                        )
                    }
                    val userProfileFromCache = AuthenticationResponse(
                        email = it.email.toString(),
                        firstname = it.firstname.plus(" ").plus(it.lastname.toString()),
                        token = token,
                        message = "",
                        is_exist = 0,
                        phone = it.phone_number.toString(),
                        profile_id = 0,
                        user_id = 0,
                        guestuser_id = 0,
                        withList_id = it.wishlists?.takeIf { !it.isNullOrEmpty() }?.get(0)?.id
                    )
                    userProfileFromCache.password = password
                    saveUserDataToCache(userProfileFromCache)  /// save again with username and other profile data
                }

            }

        }
    }


    private fun saveUserDataToCache(userProfileFromCache: AuthenticationResponse): Observable<AuthenticationResponse> {
        cache.saveUserToCache(userProfileFromCache).blockingGet()
        return Observable.just(
            AuthenticationResponse(
                firstname = userProfileFromCache.firstname,
                token = userProfileFromCache.token
            )
        )
    }

    private fun getSavedVariant(
        options: Map<String, String>?,
        productOptionsDetailed: Map<String, ProductOptionsDetailed>?
    ): Map<String, ProductOptionsDetailed> {
        val map: MutableMap<String, ProductOptionsDetailed> = mutableMapOf()

        options?.forEach {
            val detailed = productOptionsDetailed?.get(it.key)
            map[it.key] = ProductOptionsDetailed(
                optionName = detailed?.optionName,
                variants = mapOf<Int, Variant>(
                    detailed?.optionId!!.toInt() to detailed.variants!!.getValue(
                        it.value.toInt()
                    )
                )
            )
        }
        return map
    }


}
