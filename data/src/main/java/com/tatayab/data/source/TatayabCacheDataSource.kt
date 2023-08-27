package com.tatayab.data.source


import com.tatayab.data.repository.TatayabCache
import com.tatayab.data.repository.TatayabDataSource
import com.tatayab.model.*
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.requests.*
import com.tatayab.model.requests.graph_request.AddItemToCartGraphRequest
import com.tatayab.model.requests.graph_request.GraphRequest
import com.tatayab.model.responses.*
import com.tatayab.model.responses.graph_responses.*
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.Maybe
import io.reactivex.Observable
import javax.inject.Inject


class TatayabCacheDataSource @Inject constructor(
    private val tatayabCache: TatayabCache
) : TatayabDataSource {
    override fun socialMediaLogin(
        lang_code: String,
        mSocialLoginRequestBody: SocialLoginRequestBody
    ): Flowable<AuthenticationResponse> {
        throw UnsupportedOperationException("socialMediaLogin  isn't supported here...")
    }

    override fun getMyWallet(
    ): Flowable<WalletResponse> {
        throw UnsupportedOperationException("getMyWallet  isn't supported here...")
    }

    override fun getAllTransactions(
    ): Flowable<TransactionsHistoryResponse> {
        throw UnsupportedOperationException("getAllTransactions  isn't supported here...")
    }

    override fun getUserToken(
        finger: String,
        session: String,
        devid: String
    ): Flowable<UserTokenResponse> {
        throw UnsupportedOperationException("getUserToken  isn't supported here...")
    }

    override fun updateUserTokenWithCountryOrLanguage(
        country_code: String,
        lang_code: String
    ): Flowable<UserUpdateTokenResponse> {
        throw UnsupportedOperationException("getUserToken  isn't supported here...")
    }

    override fun addRedeemCode(
        mRedeemCodeRequest: RedeemCodeRequest
    ): Flowable<RedeemCodeResponse> {
        throw UnsupportedOperationException("addRedeemCode  isn't supported here...")
    }

    override fun logout(): Flowable<LogoutResponse> {
        throw UnsupportedOperationException("logout  isn't supported here...")
    }

    override fun changePassword(editProfileRequestBody: ChangePasswordRequest): Flowable<EditUserProfileResponse> {
        throw UnsupportedOperationException("changePassword  isn't supported here...")
    }

    override fun getCategoryBanners(
        lang_code: String,
        category_id: String
    ): Flowable<CategoryBannerResponse> {
        throw UnsupportedOperationException("getCategoryBanners  isn't supported here...")
    }

    override fun inviteFriend(mInviteFriendRequest: InviteFriendRequest): Flowable<InviteFriendResponse> {
        throw UnsupportedOperationException("getCategoryBanners  isn't supported here...")
    }

    override fun checkEarn(mInviteFriendRequest: InviteFriendRequest): Flowable<InviteFriendResponse> {
        throw UnsupportedOperationException("checkEarn  isn't supported here...")
    }

    override fun checkCashBack(orderId: String): Flowable<CheckCashBackResponse> {
        throw UnsupportedOperationException("checkCashBack  isn't supported here...")
    }

    override fun createCart(): Flowable<CreateCartResponse> {
        throw UnsupportedOperationException("createCart  isn't supported here...")
    }

    override fun createGuestCart(): Flowable<CreateGuestCartResponse> {
        throw UnsupportedOperationException("createGuestCart  isn't supported here...")
    }

    override fun restoreCart(cartId: String?): Flowable<RestoreCartResponse> {
        throw UnsupportedOperationException("Cart  isn't supported here...")
    }

    override fun AddProductToGraphCart(mAddItemToCartGraphRequest: AddItemToCartGraphRequest?): Flowable<AddProductToCartResponse> {
        throw UnsupportedOperationException("AddProductToGraphCart  isn't supported here...")
    }

    override fun setBillingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Flowable<ShippingAddressResponse> {
        throw UnsupportedOperationException("setBillingAddressOnCart  isn't supported here...")
    }

    override fun setShippingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Flowable<ShippingAddressResponse> {
        throw UnsupportedOperationException("")
    }

    override fun setGuestEmailOnCart(
        cartId: String?,
        email: String?
    ): Flowable<AddGuestEmailToCartResponse> {
        throw UnsupportedOperationException("setGuestEmailOnCart  isn't supported here...")
    }

    override fun mergeCarts(
        customerCartId: String?,
        guestCartId: String?
    ): Flowable<MergeCartsResponse> {
        throw UnsupportedOperationException("mergeCarts  isn't supported here...")
    }

    override fun getCountryCurrency(): Flowable<CountryCurrenceResponse> {
        throw UnsupportedOperationException("getCountryCurrency  isn't supported here...")
    }

    override fun checkTokenValidation(token: String): Flowable<CheckTokenValidationResponse> {
        throw UnsupportedOperationException("checkTokenValidation  isn't supported here...")
    }

    override fun getSpecificProducts(
        country_code: String,
        lang_code: String,
        action: String,
        items_per_page: Int,
        page: Int,
        pid: String
    ): Flowable<ProductsListResponse> {
        throw UnsupportedOperationException("getSpecificProducts  isn't supported here...")
    }

    override fun getPromotion(mPromotionRequestModel: PromotionRequestModel): Flowable<InAppMessageModel> {
        throw UnsupportedOperationException("getPromotion  isn't supported here...")
    }

    override fun getSelectAddress(AddressRequest: SelectedGuestAddressRequest): Flowable<SelectAddressResponse> {
        throw UnsupportedOperationException("getSelectAddress  isn't supported here...")
    }

    override fun getOptionsForProduct(
        lang_code: String,
        productId: String
    ): Flowable<ProductOptionsResponse> {
        throw UnsupportedOperationException("getOptionsForProduct  isn't supported here...")
    }

    override fun extrctDeepLinkUrl(mExtractDeepLinkRequest: ExtractDeepLinkRequest): Flowable<ExtractDeepLinkResponse> {
        throw UnsupportedOperationException("extrctDeepLinkUrl  isn't supported here...")
    }


    override fun sendPaymentMethod(
        languageCode: String,
        mPaymentMethodRequest: PaymentMethodRequest
    ): Flowable<ReviewCartResponse> {
        throw UnsupportedOperationException("sendPaymentMethod  isn't supported here...")
    }

    override fun applyCoupon(
        languageCode: String,
        mAddCouponRequest: AddCouponRequest
    ): Flowable<ReviewCartResponse> {
        throw UnsupportedOperationException("applyCoupon  isn't supported here...")
    }

    override fun removeCoupon(
        languageCode: String,
        mRemoveCouponRequest: RemoveCouponRequest
    ): Flowable<ReviewCartResponse> {
        throw UnsupportedOperationException("removeCoupon  isn't supported here...")
    }

    override fun createOrder(
        user_id: String,
        languageCode: String,
        country_code: String,
        action: String,
        device_id: String, is_gift: Int,
        gift_sender_name: String,
        gift_receiver_name: String,
        gift_msg: String,
        cartId: String
    ): Flowable<CreateOrderResponse> {
        throw UnsupportedOperationException("createOrder  isn't supported here...")
    }

    override fun checkoutReview(
        languageCode: String,
        mReviewCartRequest: ReviewCartRequest
    ): Flowable<ReviewCartResponse> {
        throw UnsupportedOperationException("checkoutReview  isn't supported here...")
    }

    override fun getOrdersCountInCart(mGetOrdersCountInCartRequest: GetOrdersCountInCartRequest): Flowable<GetOrdersCountInCartResponse> {
        throw UnsupportedOperationException("getOrdersCountInCart  isn't supported here...")
    }

    override fun updateOrderInCart(mUpdateItemInCartRequest: UpdateItemInCartRequest): Flowable<AddItemToCartResponse> {
        throw UnsupportedOperationException("updateOrderInCart  isn't supported here...")
    }

    override fun deleteOrderFromCart(mDeleteItemFromCartRequest: DeleteItemFromCartRequest): Flowable<AddItemToCartResponse> {
        throw UnsupportedOperationException("deleteOrderFromCart  isn't supported here...")
    }

    override fun getOrdersFromCart(
        lanf: String,
        mGetOrdersFromCartRequest: GetOrdersFromCartRequest
    ): Flowable<GetOrdersFromCartResponse> {
        throw UnsupportedOperationException("getOrdersFromCart  isn't supported here...")
    }

    override fun addOrderToCart(addToCartRequest: AddItemToCartRequest): Flowable<AddItemToCartResponse> {
        throw UnsupportedOperationException("addOrderToCart  isn't supported here...")
    }

    override fun getCities(
        languageCode: String,
        mGetCitiesRequest: GetCitiesRequest
    ): Observable<List<CityModel>> {
        throw UnsupportedOperationException("getCities  isn't supported here...")
    }

    override fun getAreas(
        languageCode: String,
        mGetAreaRequest: GetAreaRequest
    ): Observable<List<AreaModel>> {
        throw UnsupportedOperationException("getAreas  isn't supported here...")
    }

    override fun getUpgradeVersion(version: String): Flowable<CheckVersionResponse> {
        throw UnsupportedOperationException("getUpgradeVersion  isn't supported here...")
    }

    override fun applyPromotion(promotionRequest: PromotionRequest): Flowable<List<PromotionValue>> {
        throw UnsupportedOperationException("applyPromotion  isn't supported here...")
    }

    override fun layoutBlocks(languageCode: String): Flowable<HomeBlocksResponse> {
        throw UnsupportedOperationException("layoutBlocks  isn't supported here...")
    }

    override fun blockLayout(blockId: String, languageCode: String): Flowable<List<Banner>> {
        throw UnsupportedOperationException("blockLayout  isn't supported here...")
    }

    override fun getOrderStatues(
        userId: String,
        orderId: String,
        languageCode: String
    ): Flowable<OrderTrackingResponse> {
        throw UnsupportedOperationException("getOrderStatues  isn't supported here...")
    }

    override fun saveFirebaseToken(userTokenRequestBody: SaveFirebaseTokenRequestBody): Flowable<TokenResponse> {
        throw UnsupportedOperationException("saveFirebaseToken  isn't supported here...")
    }

    override fun getOrderDetails(
        userId: String,
        orderId: String,
        languageCode: String
    ): Flowable<OrderDetailsResponse> {
        throw UnsupportedOperationException("getOrderDetails  isn't supported here...")
    }

    override fun searchInProducts(key: String,page: Int, languageCode: String): Flowable<SearchProductListResponse> {
        throw UnsupportedOperationException("searchInProducts  isn't supported here...")
    }

    override fun getShippingMethods(customer_cart: String): Flowable<ShippingMethodsResponse> {
        throw UnsupportedOperationException("getShippingMethods  isn't supported here...")
    }

    override fun setShippingMethod(
        customer_cart: String,
        carrier_code: String,
        method_code: String
    ): Flowable<SetShippingMethodResponse> {
        throw UnsupportedOperationException("SetShippingMethodResponse  isn't supported here...")
    }

    override fun setFirebaseToken(userTokenRequestBody: UserTokenRequestBody): Flowable<TokenResponse> {
        throw UnsupportedOperationException("setting firebase token  isn't supported here...")
    }


    override fun addToWishList(addToWishListRequest: WishListActionRequest): Flowable<AddToWishListResponse> {
        throw UnsupportedOperationException("addToWishList  isn't supported here...")
    }


    override fun getUserOrders(
        userId: String,
        page: Int,
        itemPerPage: Int,
        languageCode: String
    ): Flowable<OrdersResponse> {
        throw UnsupportedOperationException("getUserOrders  isn't supported here...")
    }

    override fun deleteUserAddress(deleteAddressRequest: DeleteAddressRequest): Flowable<AddressResponse> {
        throw UnsupportedOperationException("deleteUserAddress  isn't supported here...")
    }

    override fun createOrder(createOrderRequest: CreateOrderRequest): Flowable<CreateOrderResponse> {
        throw UnsupportedOperationException("creatingOrder  isn't supported here...")
    }

    override fun getFilter(map: Map<String, String>): Flowable<FilterResponse> {
        throw UnsupportedOperationException("creatingOrder  isn't supported here...")
    }

    override fun getUserAddresses(
        userId: String, languageCode: String
    ): Flowable<ArrayList<AddressRequest>> {
        throw UnsupportedOperationException("getUserAddresses  isn't supported here...")
    }

    override fun addUserAddress(addressRequest: AddressRequest): Flowable<AddressResponse> {
        throw UnsupportedOperationException("addUserAddresses  isn't supported here...")
    }

    override fun getProductReviewers(
        productId: String,
        options: Map<String, String>,
        page: Int,
        itemsPerPage: Int
    ): Observable<ProductReviewsResponse> {
        throw UnsupportedOperationException("getProductReviwers  isn't supported here...")
    }

    override fun updateProductAmountRemote(
        productId: String,
        updateProductAmountRequest: UpdateProductAmountRequest
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>> {
        throw UnsupportedOperationException("updatingProductAmount  isn't supported here...")
    }

    override fun updateProductAmount(
        productId: String,
        amount: Int,
        options: Map<String, String>
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>> {
        return tatayabCache.updateProductAmount(productId, amount, options)
    }

    override fun addReviewToProduct(addReviewRequest: AddReviewRequest): Flowable<AddReviewResponse> {
        throw UnsupportedOperationException("addReviewToProduct  isn't supported here...")
    }


    override fun addConcierge(conciergeRequestBody: ConciergeRequestBody): Observable<ConciergeResponse> {
        throw UnsupportedOperationException("addConcierge  isn't supported here...")
    }


    override fun getCountries(languageCode: String): Flowable<ArrayList<CountryResponse>> {
        throw UnsupportedOperationException("getCountries  isn't supported here...")
    }

    override fun getCurrencies(languageCode: String): Flowable<ArrayList<CurrencyResponse>> {
        throw UnsupportedOperationException("getCurriencies  isn't supported here...")
    }

    override fun getSuppliers(
        page: Int, itemPerPage: Int, languageCode: String, sortedMap: HashMap<String, String>
    ): Flowable<SuppliersResponse> {
        throw UnsupportedOperationException("getSuppliers  isn't supported here...")
    }

    override fun getNewSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Flowable<ArrayList<SupplierResponse>> {
        throw UnsupportedOperationException("getNewSuppliers  isn't supported here...")
    }

    override fun editUserProfile(editProfileRequestBody: ProfileActionRequest): Flowable<EditUserProfileResponse> {
        throw UnsupportedOperationException("categories  isn't supported here...")
    }

    override fun getUserProfile(userId: String): Flowable<GetUserProfileResponse> {
        throw UnsupportedOperationException("categories  isn't supported here...")
    }

    override fun getUserProfile(): Flowable<UserProfileResponse> {
        throw UnsupportedOperationException("getUserProfile/graph ql  isn't supported here...")
    }

    override fun getCategories2(categoryRequest: CategoryRequest): Flowable<ArrayList<CategoryItem>> {
        throw UnsupportedOperationException("categories  isn't supported here...")

    }

    override fun getSubCategories(categoryRequest: CategoryRequest): Flowable<ArrayList<SubCategoriesResponse>> {
        throw UnsupportedOperationException("getSubCategories  isn't supported here...")
    }

    override fun addNotifyMeAction(productActionRequest: ProductActionRequest): Flowable<NormalResponse> {
        throw UnsupportedOperationException("addNotifyMeAction  isn't supported here...")
    }

    override fun getProductsForSearch(
        action: String,
        lang_code: String
    ): Flowable<ProductsListResponse> {
        throw UnsupportedOperationException("getProductsForSearch  isn't supported here...")
    }

    override fun getProductGift(country_code: String,city_code:String): Flowable<ProductsListResponse> {
        throw UnsupportedOperationException("getProductGift  isn't supported here...")
    }


    override fun getProductForCategory(
        options: Map<String, String>,
        page: Int,
        itemPerPage: Int
    ): Flowable<ProductsListResponse> {
        throw UnsupportedOperationException("category products  isn't supported here...")
    }

    override fun getWishListProducts(
        lang_code: String,
        addToWishListRequest: WishListActionRequest
    ): Flowable<WishListResponse> {
        throw UnsupportedOperationException("getWishListProducts  isn't supported here...")
    }


    override fun getGeneratedCode(token: String): Flowable<DeviceTokenResponse> {
        throw UnsupportedOperationException("getGeneratedCode  isn't supported here...")
    }

    override fun getProductDetails(
        productId: String,
        languageCode: String,
        country_code: String
    ): Flowable<ProductDetailsResponse> {
        throw UnsupportedOperationException("product details  isn't supported here...")
    }

    override fun customerAlsoBought(
        productId: String,
        languageCode: String
    ): Flowable<CustomerFeaturedProductsResponse> {
        throw UnsupportedOperationException("also bought products  isn't supported here...")
    }

    override fun forgetPassword(
        email: String,
        languageCode: String
    ): Flowable<NormalResponse> {
        throw UnsupportedOperationException("forget password  isn't supported here...")
    }

    override fun register(
        registerRequestBody: RegisterRequestBody,
        languageCode: String
    ): Flowable<AuthenticationResponse> {
        throw UnsupportedOperationException("register isn't supported here...")
    }

    override fun login(
        loginRequestBody: LoginRequestBody
    ): Flowable<AuthenticationResponse> {
        throw UnsupportedOperationException("login isn't supported here...")
    }


    override fun removeItemFromCartRemote(cartRemoveRequestBody: CartRemoveRequestBody): Completable {
        throw UnsupportedOperationException("remove from  cart remote isn't supported here...")
    }

    override fun clearCartRemote(cartRemoveRequestBody: CartRemoveRequestBody): Completable {
        throw UnsupportedOperationException("clearing  cart remote isn't supported here...")
    }

    override fun getProductsByIds(
        productsIds: String?,
        languageCode: String
    ): Flowable<ProductsListResponse> {
        throw UnsupportedOperationException("getting products by ids remote isn't supported here...")
    }


    override fun getRemoteCartContent(
        userId: String,
        languageCode: String
    ): Flowable<CartContentResponse> {
        throw UnsupportedOperationException("getting  cart remote isn't supported here...")
    }

    override fun getCartConfig(
        languageCode: String,
        productIds: String
    ): Flowable<CartConfigResponse> {
        throw UnsupportedOperationException("getting  cart config isn't supported here...")
    }

    override fun applyCoupon(applyCouponRequest: ApplyCouponRequest): Flowable<CouponResponse> {
        throw UnsupportedOperationException("applying  coupon isn't supported here...")
    }

    override fun deleteUserFromCache(): Observable<Boolean> {
        return tatayabCache.deleteUserFromCache()
    }

    override fun saveUserToCache(userDataObject: AuthenticationResponse): Completable {
        return tatayabCache.saveUserToCache(userDataObject);
    }

    override fun getUserFromCache(): Maybe<AuthenticationResponse> {
        return tatayabCache.getUserFromCache()
    }

    //Akl Done
    override fun saveUserAuthToCache(mUserAuth: UserAuth): Completable {
        println("saveUserAuthToCache6//")
        return tatayabCache.saveUserAuthToCache(mUserAuth)
    }


    override fun getUserAuthFromCache(): Maybe<UserAuth> {
        return tatayabCache.getUserAuthFromCache()
    }


    override fun saveUserSettingToCache(userSetting: UserSetting): Completable {
        return tatayabCache.saveUserSettingToCache(userSetting)
    }

  override fun getcurrentLanguageFromCache(): Maybe<String> {
        return tatayabCache.getcurrentLanguageFromCache()
    }


    override fun savecurrentLanguageToCache(lang: String): Completable {
        return tatayabCache.savecurrentLanguageToCache(lang)
    }


    override fun getUserSettingFromCache(): Maybe<UserSetting> {
        return tatayabCache.getUserSettingFromCache()
    }


    override fun canAddItemToCart(cartActionRequest: CartActionRequest): Flowable<CartActionResponse> {
        throw UnsupportedOperationException("canAddItemToCart isn't supported here...")
    }


    override fun getCachedCartContent(): Observable<ArrayList<CachProductCart>> {
        return tatayabCache.getCachedCartContent()
    }

    override fun removeItemFromCartCached(
        productId: String,
        options: Map<String, String>
    ): Observable<Int> {
        return tatayabCache.removeItemFromCartCached(productId, options)
    }

    override fun getCartItems(): Observable<MutableList<String>> {
        return tatayabCache.getCartItems()
    }

    override fun saveSearchSuggestionToCache(mSearchModel: SearchModel): Int {
        return tatayabCache.saveSearchSuggestionToCache(mSearchModel)
    }
    override fun getSearchSuggestionsFromCache(): Observable<MutableList<SearchModel>>{
        return tatayabCache.getSearchSuggestionsFromCache()
    }

    override fun clearCartCache(): Completable {

        return Completable.defer {
            tatayabCache.clearCartCache()
            Completable.complete()
        }
    }

    override fun getCartSize(): Observable<Int> {
        return tatayabCache.getCartSize()
    }


}