package com.tatayab.data.source


import com.tatayab.data.repository.TatayabDataSource
import com.tatayab.data.repository.TatayabRemote
import com.tatayab.model.*
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.requests.*
import com.tatayab.model.requests.ConciergeRequestBody
import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.requests.LoginRequestBody
import com.tatayab.model.requests.RegisterRequestBody
import com.tatayab.model.requests.graph_request.AddItemToCartGraphRequest
import com.tatayab.model.requests.graph_request.GraphRequest
import com.tatayab.model.responses.*
import com.tatayab.model.responses.graph_responses.*
import io.reactivex.*
import javax.inject.Inject

class TatayabRemoteDataSource @Inject constructor(
    private val tatayabRemote: TatayabRemote
) : TatayabDataSource {
    override fun getUpgradeVersion(version: String): Flowable<CheckVersionResponse> {
        return tatayabRemote.getUpgradeVersion(version)
    }

    override fun applyPromotion(promotionRequest: PromotionRequest): Flowable<List<PromotionValue>> {
        return tatayabRemote.applyPromotion(promotionRequest)
    }

    override fun layoutBlocks(languageCode: String): Flowable<HomeBlocksResponse> {
        return tatayabRemote.layoutBlocks(languageCode)
    }

    override fun blockLayout(blockId: String, languageCode: String): Flowable<List<Banner>> {
        return tatayabRemote.blockLayout(blockId, languageCode)
    }

    override fun getOrderStatues(
        userId: String,
        orderId: String,
        languageCode: String
    ): Flowable<OrderTrackingResponse> {
        return tatayabRemote.getOrderStatues(userId, orderId, languageCode)
    }

    override fun getOrderDetails(
        userId: String,
        orderId: String,
        languageCode: String
    ): Flowable<OrderDetailsResponse> {
        return tatayabRemote.getOrderDetails(userId, orderId, languageCode)
    }

    override fun searchInProducts(
        key: String,
        page: Int,
        languageCode: String
    ): Flowable<SearchProductListResponse> {
        return tatayabRemote.searchInProducts(key, page, languageCode)
    }

    override fun setShippingMethod(
        customer_cart:String,carrier_code:String,method_code:String
    ): Flowable<SetShippingMethodResponse>{
        return tatayabRemote.setShippingMethod(customer_cart,carrier_code,method_code)
    }

    override fun getShippingMethods(
        customer_cart: String
    ): Flowable<ShippingMethodsResponse> {
        return tatayabRemote.getShippingMethods(customer_cart)
    }
    override fun getWishListProducts(
        lang_code: String,
        addToWishListRequest: WishListActionRequest
    ): Flowable<WishListResponse> {
        return tatayabRemote.getWishlistProducts(lang_code, addToWishListRequest)
    }

    override fun addToWishList(addToWishListRequest: WishListActionRequest): Flowable<AddToWishListResponse> {
        return tatayabRemote.addToWishList(addToWishListRequest)
    }

    override fun getUserOrders(
        userId: String,
        page: Int,
        itemPerPage: Int,
        languageCode: String
    ): Flowable<OrdersResponse> {
        return tatayabRemote.getUserOrders(userId, page, itemPerPage, languageCode)
    }

    override fun deleteUserAddress(deleteAddressRequest: DeleteAddressRequest): Flowable<AddressResponse> {
        return tatayabRemote.deleteUserAddress(deleteAddressRequest)
    }

    override fun createOrder(createOrderRequest: CreateOrderRequest): Flowable<CreateOrderResponse> {
        return tatayabRemote.createOrder(createOrderRequest)
    }

    override fun getFilter(map: Map<String, String>): Flowable<FilterResponse> {
        return tatayabRemote.getFilter(map)
    }

    override fun getUserAddresses(
        userId: String, languageCode: String
    ): Flowable<ArrayList<AddressRequest>> {
        return tatayabRemote.getUserAddresses(userId, languageCode)
    }

    override fun addUserAddress(addressRequest: AddressRequest): Flowable<AddressResponse> {
        return tatayabRemote.addUserAddress(addressRequest)
    }


    override fun addReviewToProduct(addReviewRequest: AddReviewRequest): Flowable<AddReviewResponse> {
        return tatayabRemote.addReviewToProduct(addReviewRequest)
    }

    override fun addConcierge(conciergeRequestBody: ConciergeRequestBody): Observable<ConciergeResponse> {
        return tatayabRemote.addConcierge(conciergeRequestBody).toObservable()
    }

    override fun getCities(
        lang_code: String,
        mGetCitiesRequest: GetCitiesRequest
    ): Observable<List<CityModel>> {
        return tatayabRemote.getCities(lang_code, mGetCitiesRequest).toObservable()
    }

    override fun getAreas(
        lang_code: String,
        mGetAreaRequest: GetAreaRequest
    ): Observable<List<AreaModel>> {
        return tatayabRemote.getAreas(lang_code, mGetAreaRequest).toObservable()
    }

    override fun getProductReviewers(
        productId: String,
        options: Map<String, String>,
        page: Int,
        itemsPerPage: Int
    ): Observable<ProductReviewsResponse> {
        return tatayabRemote.getProductReviewers(productId, options, page, itemsPerPage)
            .toObservable()
    }

    override fun getCountries(languageCode: String): Flowable<ArrayList<CountryResponse>> {
        return tatayabRemote.getCountries(languageCode)
    }

    override fun getCurrencies(languageCode: String): Flowable<ArrayList<CurrencyResponse>> {
        return tatayabRemote.getCurrencies(languageCode)
    }

    override fun getSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Flowable<SuppliersResponse> {
        return tatayabRemote.getSuppliers(page, itemPerPage, languageCode, sortedMap)
    }

    override fun getNewSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Flowable<ArrayList<SupplierResponse>> {
        return tatayabRemote.getNewSuppliers(page, itemPerPage, languageCode, sortedMap)
    }

    override fun addOrderToCart(addToCartRequest: AddItemToCartRequest): Flowable<AddItemToCartResponse> {
        return tatayabRemote.addOrderToCart(addToCartRequest)
    }

    override fun getOrdersCountInCart(mGetOrdersCountInCartRequest: GetOrdersCountInCartRequest): Flowable<GetOrdersCountInCartResponse> {
        return tatayabRemote.getOrdersCountInCart(mGetOrdersCountInCartRequest)
    }

    override fun deleteOrderFromCart(mDeleteItemFromCartRequest: DeleteItemFromCartRequest): Flowable<AddItemToCartResponse> {
        return tatayabRemote.deleteOrderFromCart(mDeleteItemFromCartRequest)
    }

    override fun checkoutReview(
        languageCode: String,
        mReviewCartRequest: ReviewCartRequest
    ): Flowable<ReviewCartResponse> {
        return tatayabRemote.checkoutReview(languageCode, mReviewCartRequest)
    }


    override fun sendPaymentMethod(
        languageCode: String,
        mPaymentMethodRequest: PaymentMethodRequest
    ): Flowable<ReviewCartResponse> {
        return tatayabRemote.sendPaymentMethod(languageCode, mPaymentMethodRequest)

    }

    override fun applyCoupon(
        languageCode: String,
        mAddCouponRequest: AddCouponRequest
    ): Flowable<ReviewCartResponse> {
        return tatayabRemote.applyCoupon(languageCode, mAddCouponRequest)

    }

    override fun removeCoupon(
        languageCode: String,
        mRemoveCouponRequest: RemoveCouponRequest
    ): Flowable<ReviewCartResponse> {
        return tatayabRemote.removeCoupon(languageCode, mRemoveCouponRequest)

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
    ): Flowable<CreateOrderResponse> {
        return tatayabRemote.createOrder(
            user_id, languageCode,
            country_code,
            action,
            device_id, is_gift, gift_sender_name, gift_receiver_name, gift_msg,cartId
        )
    }


    override fun updateOrderInCart(mUpdateItemInCartRequest: UpdateItemInCartRequest): Flowable<AddItemToCartResponse> {
        return tatayabRemote.updateOrderInCart(mUpdateItemInCartRequest)
    }

    override fun getOrdersFromCart(
        languageCode: String,
        mGetOrdersFromCartRequest: GetOrdersFromCartRequest
    ): Flowable<GetOrdersFromCartResponse> {
        return tatayabRemote.getOrdersFromCart(languageCode, mGetOrdersFromCartRequest)

    }


    override fun updateProductAmountRemote(
        productId: String,
        updateProductAmountRequest: UpdateProductAmountRequest
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>> {
        return tatayabRemote.updateProductAmountRemote(productId, updateProductAmountRequest)
            .toObservable().map { t: AddToCartResponse ->
                Pair(1, ArrayList<CachProductCart>())
            }
    }


    override fun removeItemFromCartRemote(cartRemoveRequestBody: CartRemoveRequestBody): Completable {
        return tatayabRemote.removeItemFromCart(cartRemoveRequestBody)
    }

    override fun clearCartRemote(cartRemoveRequestBody: CartRemoveRequestBody): Completable {
        return tatayabRemote.clearCartRemote(cartRemoveRequestBody)
    }

    override fun getProductsByIds(
        productsIds: String?,
        languageCode: String
    ): Flowable<ProductsListResponse> {
        return tatayabRemote.getProductsByIds(productsIds, languageCode)
    }

    override fun getRemoteCartContent(
        userId: String,
        languageCode: String
    ): Flowable<CartContentResponse> {
        return tatayabRemote.getRemoteCartContent(userId, languageCode)
    }

    override fun getCartConfig(
        languageCode: String,
        productIds: String
    ): Flowable<CartConfigResponse> {
        return tatayabRemote.getCartConfig(languageCode, productIds)
    }

    override fun getCategories2(categoryRequest: CategoryRequest): Flowable<ArrayList<CategoryItem>> {
        return tatayabRemote.getCategories2(categoryRequest)
    }

    override fun getSubCategories(categoryRequest: CategoryRequest): Flowable<ArrayList<SubCategoriesResponse>> {
        return tatayabRemote.getSubCategories(categoryRequest)
    }

    override fun addNotifyMeAction(productActionRequest: ProductActionRequest): Flowable<NormalResponse> {
        return tatayabRemote.addNotifyMeAction(productActionRequest)
    }

    override fun login(loginRequestBody: LoginRequestBody): Flowable<AuthenticationResponse> {
        return tatayabRemote.login(loginRequestBody)
    }


    override fun getProductForCategory(
        options: Map<String, String>,
        page: Int,
        itemPerPage: Int
    ): Flowable<ProductsListResponse> {
        return tatayabRemote.getProductsForCategory(options, page, itemPerPage)
    }

    override fun getProductGift(countryCode:String,cityCode:String

    ): Flowable<ProductsListResponse> {
        return tatayabRemote.getProductGift(countryCode,cityCode)
    }

    override fun getProductsForSearch(
        action: String,
        lang_code: String
    ): Flowable<ProductsListResponse> {
        return tatayabRemote.getProductsForSearch(action, lang_code)
    }

    override fun getGeneratedCode(token: String): Flowable<DeviceTokenResponse> {
        return tatayabRemote.getGeneratedCode(token)
    }

    override fun getProductDetails(
        productId: String,
        languageCode: String,
        country_code: String
    ): Flowable<ProductDetailsResponse> {
        return tatayabRemote.getProductDetails(productId, languageCode,country_code)
    }

    override fun customerAlsoBought(
        productId: String,
        languageCode: String
    ): Flowable<CustomerFeaturedProductsResponse> {
        return tatayabRemote.customerAlsoBought(productId, languageCode)
    }


    override fun forgetPassword(email: String, languageCode: String): Flowable<NormalResponse> {
        return tatayabRemote.forgetPassword(email, languageCode)
    }

    override fun register(
        registerRequestBody: RegisterRequestBody,
        languageCode: String
    ): Flowable<AuthenticationResponse> {
        return tatayabRemote.register(registerRequestBody, languageCode)
    }


    override fun getUserProfile(userId: String): Flowable<GetUserProfileResponse> {
        return tatayabRemote.getUserProfile(userId)
    }


    override fun editUserProfile(editProfileRequestBody: ProfileActionRequest): Flowable<EditUserProfileResponse> {
        return tatayabRemote.editProfile(editProfileRequestBody)
    }

    override fun applyCoupon(applyCouponRequest: ApplyCouponRequest): Flowable<CouponResponse> {
        return tatayabRemote.applyCoupon(applyCouponRequest)
    }

    override fun setFirebaseToken(userTokenRequestBody: UserTokenRequestBody): Flowable<TokenResponse> {
        return tatayabRemote.setFirebaseToken(userTokenRequestBody)
    }

    override fun saveFirebaseToken(userTokenRequestBody: SaveFirebaseTokenRequestBody): Flowable<TokenResponse> {
        return tatayabRemote.saveFirebaseToken(userTokenRequestBody)
    }


    override fun updateProductAmount(
        productId: String,
        amount: Int,
        options: Map<String, String>
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>> {
        throw UnsupportedOperationException("updating product amount cache user isn't supported here...")
    }


    override fun saveUserSettingToCache(userSetting: UserSetting): Completable {
        throw UnsupportedOperationException("saving user isn't supported here...")
    }

    override fun getcurrentLanguageFromCache(): Maybe<String> {
        throw UnsupportedOperationException("getcurrentLanguageFromCache isn't supported here...")
    }

    override fun savecurrentLanguageToCache(lang: String): Completable {
        throw UnsupportedOperationException("savecurrentLanguageToCache  isn't supported here...")
    }

    override fun getUserSettingFromCache(): Maybe<UserSetting> {
        throw UnsupportedOperationException("getUserSettingFromCache isn't supported here...")
    }

    override fun saveUserAuthToCache(userAuth: UserAuth): Completable {
        println("saveUserAuthToCache55")
        throw UnsupportedOperationException("saveUserAuthToCache isn't supported here...")
    }

    override fun getUserAuthFromCache(): Maybe<UserAuth> {
        throw UnsupportedOperationException("getUserAuthFromCache isn't supported here...")
    }

    override fun deleteUserFromCache(): Observable<Boolean> {
        throw UnsupportedOperationException("deleting user  isn't supported here...")
    }

    override fun saveUserToCache(userDataObject: AuthenticationResponse): Completable {
        throw UnsupportedOperationException("saving user isn't supported here...")
    }

    override fun getUserFromCache(): Maybe<AuthenticationResponse> {
        throw UnsupportedOperationException("retrieving user  isn't supported here...")
    }


    override fun getCachedCartContent(): Observable<ArrayList<CachProductCart>> {
        throw UnsupportedOperationException("get cached  cart  isn't supported here...")
    }

    override fun canAddItemToCart(cartActionRequest: CartActionRequest): Flowable<CartActionResponse> {
        return tatayabRemote.checkCartAvailability(cartActionRequest)
    }

    override fun extrctDeepLinkUrl(mExtractDeepLinkRequest: ExtractDeepLinkRequest): Flowable<ExtractDeepLinkResponse> {
        return tatayabRemote.extrctDeepLinkUrl(mExtractDeepLinkRequest)
    }

    override fun getSpecificProducts(
        country_code: String,
        lang_code: String,
        action: String,
        items_per_page: Int,
        page: Int,
        pid: String
    ): Flowable<ProductsListResponse> {
        return tatayabRemote.getSpecificProducts(
            country_code,
            lang_code,
            action,
            items_per_page,
            page,
            pid
        )
    }

    override fun getOptionsForProduct(
        lang_code: String,
        productId: String
    ): Flowable<ProductOptionsResponse> {
        return tatayabRemote.getOptionsForProduct(lang_code, productId)
    }

    override fun removeItemFromCartCached(
        productId: String,
        options: Map<String, String>
    ): Observable<Int> {
        throw UnsupportedOperationException("removing from cart  isn't supported here...")
    }


    override fun getCartItems(): Observable<MutableList<String>> {
        throw UnsupportedOperationException("get cart  isn't supported here...")
    }

    override fun saveSearchSuggestionToCache(mSearchModel: SearchModel): Int {
        throw UnsupportedOperationException(" saveSearchSuggestionToCache  isn't supported here...")
    }

    override fun getSearchSuggestionsFromCache(): Observable<MutableList<SearchModel>> {
        throw UnsupportedOperationException("getSearchSuggestionsFromCache  isn't supported here...")
    }

    override fun clearCartCache(): Completable {
        throw UnsupportedOperationException("clear cart  isn't supported here...")
    }

    override fun getCartSize(): Observable<Int> {
        throw UnsupportedOperationException("cart size  isn't supported here...")
    }

    override fun getPromotion(

        mPromotionRequestModel: PromotionRequestModel

    ): Flowable<InAppMessageModel> {
        return tatayabRemote.getPromotion(mPromotionRequestModel)
    }

    override fun getSelectAddress(AddressRequest: SelectedGuestAddressRequest): Flowable<SelectAddressResponse> {
        return tatayabRemote.getSelectAddress(AddressRequest)
    }

    override fun socialMediaLogin(
        lang_code: String,
        mSocialLoginRequestBody: SocialLoginRequestBody
    ): Flowable<AuthenticationResponse> {
        return tatayabRemote.socialMediaLogin(lang_code, mSocialLoginRequestBody)

    }

    override fun getMyWallet(
    ): Flowable<WalletResponse> {
        return tatayabRemote.getMyWallet()
    }

    override fun getAllTransactions(
    ): Flowable<TransactionsHistoryResponse> {
        return tatayabRemote.getAllTransactions()
    }

    override fun getUserToken(
        osused: String,
        session: String,
        devid: String
    ): Flowable<UserTokenResponse> {
        return tatayabRemote.getUserToken(osused, session, devid)
    }

    override fun updateUserTokenWithCountryOrLanguage(
        country_code: String,
        lang_code: String
    ): Flowable<UserUpdateTokenResponse> {
        return tatayabRemote.updateUserTokenWithCountryOrLanguage(country_code, lang_code)
    }

    override fun addRedeemCode(
        mRedeemCodeRequest: RedeemCodeRequest
    ): Flowable<RedeemCodeResponse> {
        return tatayabRemote.addRedeemCode(mRedeemCodeRequest)
    }

    override fun logout(): Flowable<LogoutResponse> {
        return tatayabRemote.logout()
    }

    override fun changePassword(editProfileRequestBody: ChangePasswordRequest): Flowable<EditUserProfileResponse> {
        return tatayabRemote.changePassword(editProfileRequestBody)
    }

    override fun getCategoryBanners(
        lang_code: String,
        category_id: String
    ): Flowable<CategoryBannerResponse> {
        return tatayabRemote.getCategoryBanners(lang_code, category_id)
    }

    override fun inviteFriend(
        mInviteFriendRequest: InviteFriendRequest
    ): Flowable<InviteFriendResponse> {
        return tatayabRemote.inviteFriend(mInviteFriendRequest)
    }

    override fun checkEarn(
        mInviteFriendRequest: InviteFriendRequest
    ): Flowable<InviteFriendResponse> {
        return tatayabRemote.checkEarn(mInviteFriendRequest)
    }

    override fun checkCashBack(orderId: String): Flowable<CheckCashBackResponse> {
        return tatayabRemote.checkCashBack(orderId)
    }

    override fun createCart(): Flowable<CreateCartResponse> {
        return tatayabRemote.createCart()
    }

    override fun createGuestCart(): Flowable<CreateGuestCartResponse> {
        return tatayabRemote.createGuestCart()
    }
    override fun restoreCart(cartId: String?): Flowable<RestoreCartResponse> {
        return tatayabRemote.restoreCart(cartId)
    }
    override fun mergeCarts(customerCartId: String?,guestCartId:String?): Flowable<MergeCartsResponse> {
        return tatayabRemote.mergeCarts(customerCartId,guestCartId)
    }
    override fun getCountryCurrency(
    ): Flowable<CountryCurrenceResponse>{
        return tatayabRemote.getCountryCurrency()
    }
    override fun checkTokenValidation(token: String): Flowable<CheckTokenValidationResponse> {
        return tatayabRemote.checkTokenValidation(token)
    }
    override fun AddProductToGraphCart(mAddItemToCartGraphRequest: AddItemToCartGraphRequest?): Flowable<AddProductToCartResponse> {
        return tatayabRemote.AddProductToGraphCart(mAddItemToCartGraphRequest)
    }

    override fun setBillingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Flowable<ShippingAddressResponse> {
        return  tatayabRemote.setBillingAddressOnCart(mShippingAddressRequest)
    }
    override fun setShippingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Flowable<ShippingAddressResponse> {
        return  tatayabRemote.setShippingAddressOnCart(mShippingAddressRequest)
    }
    override fun setGuestEmailOnCart(cartId:String?,email:String?): Flowable<AddGuestEmailToCartResponse>{
        return  tatayabRemote.setGuestEmailOnCart(cartId, email)
    }
    override fun getUserProfile(): Flowable<UserProfileResponse> {
        return tatayabRemote.getUserProfile()
    }
}