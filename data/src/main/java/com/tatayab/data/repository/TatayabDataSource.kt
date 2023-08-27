package com.tatayab.data.repository


import com.tatayab.model.*
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.requests.ConciergeRequestBody
import com.tatayab.model.requests.*
import com.tatayab.model.requests.graph_request.AddItemToCartGraphRequest
import com.tatayab.model.requests.graph_request.GraphRequest
import com.tatayab.model.responses.*
import com.tatayab.model.responses.graph_responses.*
import io.reactivex.*

interface TatayabDataSource {

    fun deleteUserFromCache(): Observable<Boolean>
    fun saveUserToCache(userDataObject: AuthenticationResponse): Completable
    fun getUserFromCache(): Maybe<AuthenticationResponse>
    fun getUserProfile(userId: String): Flowable<GetUserProfileResponse>
    fun editUserProfile(editProfileRequestBody: ProfileActionRequest): Flowable<EditUserProfileResponse>
    fun getUserSettingFromCache(): Maybe<UserSetting>
    fun saveUserAuthToCache(userAuth: UserAuth): Completable
    fun getUserAuthFromCache(): Maybe<UserAuth>
    fun saveUserSettingToCache(userSetting: UserSetting): Completable
    fun getcurrentLanguageFromCache(): Maybe<String>
    fun savecurrentLanguageToCache(lang: String): Completable
    fun login(
        loginRequestBody: LoginRequestBody
    ): Flowable<AuthenticationResponse>

    fun getGeneratedCode(token: String): Flowable<DeviceTokenResponse>
    fun getCategories2(categoryRequest: CategoryRequest): Flowable<ArrayList<CategoryItem>>
    fun getSubCategories(categoryRequest: CategoryRequest): Flowable<ArrayList<SubCategoriesResponse>>
    fun addNotifyMeAction(productActionRequest: ProductActionRequest): Flowable<NormalResponse>
    fun getProductsForSearch(
        action: String,
        lang_code: String
    ): Flowable<ProductsListResponse>

    fun getProductGift(countryCode:String,cityCode:String
    ): Flowable<ProductsListResponse>


    fun getProductForCategory(
        options: Map<String, String>,
        page: Int,
        itemPerPage: Int
    ): Flowable<ProductsListResponse>

    fun getWishListProducts(
        lang_code: String,
        addToWishListRequest: WishListActionRequest
    ): Flowable<WishListResponse>

    fun forgetPassword(email: String, languageCode: String): Flowable<NormalResponse>

    fun register(
        registerRequestBody: RegisterRequestBody,
        languageCode: String
    ): Flowable<AuthenticationResponse>


    fun getProductDetails(
        productId: String,
        languageCode: String,
        country_code: String
    ): Flowable<ProductDetailsResponse>

    fun customerAlsoBought(
        productId: String,
        languageCode: String
    ): Flowable<CustomerFeaturedProductsResponse>

    fun getProductsByIds(
        productsIds: String?,
        languageCode: String
    ): Flowable<ProductsListResponse>

    fun getSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Flowable<SuppliersResponse>

    fun getNewSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Flowable<ArrayList<SupplierResponse>>

    fun addOrderToCart(addToCartRequest: AddItemToCartRequest): Flowable<AddItemToCartResponse>
    fun getOrdersFromCart(
        languageCode: String,
        mGetOrdersFromCartRequest: GetOrdersFromCartRequest
    ): Flowable<GetOrdersFromCartResponse>

    fun updateOrderInCart(mUpdateItemInCartRequest: UpdateItemInCartRequest): Flowable<AddItemToCartResponse>
    fun deleteOrderFromCart(mDeleteItemFromCartRequest: DeleteItemFromCartRequest): Flowable<AddItemToCartResponse>
    fun getOrdersCountInCart(mGetOrdersCountInCartRequest: GetOrdersCountInCartRequest): Flowable<GetOrdersCountInCartResponse>
    fun getCountries(languageCode: String): Flowable<ArrayList<CountryResponse>>
    fun getCurrencies(languageCode: String): Flowable<ArrayList<CurrencyResponse>>
    fun removeItemFromCartRemote(cartRemoveRequestBody: CartRemoveRequestBody): Completable
    fun clearCartRemote(cartRemoveRequestBody: CartRemoveRequestBody): Completable
    fun getRemoteCartContent(userId: String, languageCode: String): Flowable<CartContentResponse>
    fun canAddItemToCart(cartActionRequest: CartActionRequest): Flowable<CartActionResponse>
    fun getCachedCartContent(): Observable<ArrayList<CachProductCart>>
    fun removeItemFromCartCached(productId: String, options: Map<String, String>): Observable<Int>
    fun checkoutReview(
        languageCode: String,
        mReviewCartRequest: ReviewCartRequest
    ): Flowable<ReviewCartResponse>


    fun sendPaymentMethod(
        languageCode: String,
        mPaymentMethodRequest: PaymentMethodRequest
    ): Flowable<ReviewCartResponse>

    fun applyCoupon(
        languageCode: String,
        mAddCouponRequest: AddCouponRequest
    ): Flowable<ReviewCartResponse>

    fun removeCoupon(
        languageCode: String,
        mRemoveCouponRequest: RemoveCouponRequest
    ): Flowable<ReviewCartResponse>

    fun createOrder(
        user_id: String, languageCode: String,
        country_code: String,
        action: String,
        device_id: String, is_gift: Int,
        gift_sender_name: String,
        gift_receiver_name: String,
        gift_msg: String,
        cartId: String
    ): Flowable<CreateOrderResponse>

    fun getCartItems(): Observable<MutableList<String>>
    fun saveSearchSuggestionToCache(mSearchModel: SearchModel): Int
    fun getSearchSuggestionsFromCache(): Observable<MutableList<SearchModel>>
    fun clearCartCache(): Completable
    fun getCartSize(): Observable<Int>
    fun getCartConfig(
        languageCode: String,
        productIds: String
    ): Flowable<CartConfigResponse>

    fun addConcierge(conciergeRequestBody: ConciergeRequestBody): Observable<ConciergeResponse>
    fun addReviewToProduct(addReviewRequest: AddReviewRequest): Flowable<AddReviewResponse>
    fun addUserAddress(addressRequest: AddressRequest): Flowable<AddressResponse>
    fun getCities(
        lang_code: String,
        mGetCitiesRequest: GetCitiesRequest
    ): Observable<List<CityModel>>

    fun getAreas(lang_code: String, mGetAreaRequest: GetAreaRequest): Observable<List<AreaModel>>
    fun getProductReviewers(
        productId: String,
        options: Map<String, String>,
        page: Int,
        itemsPerPage: Int
    ): Observable<ProductReviewsResponse>

    fun updateProductAmountRemote(
        productId: String,
        updateProductAmountRequest: UpdateProductAmountRequest
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>>

    fun updateProductAmount(
        productId: String,
        amount: Int,
        options: Map<String, String>
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>>

    fun applyCoupon(applyCouponRequest: ApplyCouponRequest): Flowable<CouponResponse>

    fun getUserAddresses(userId: String, languageCode: String): Flowable<ArrayList<AddressRequest>>
    fun deleteUserAddress(deleteAddressRequest: DeleteAddressRequest): Flowable<AddressResponse>
    fun createOrder(createOrderRequest: CreateOrderRequest): Flowable<CreateOrderResponse>
    fun getFilter(map: Map<String, String>): Flowable<FilterResponse>
    fun addToWishList(addToWishListRequest: WishListActionRequest): Flowable<AddToWishListResponse>
    fun searchInProducts(
        key: String,
        page: Int,
        languageCode: String
    ): Flowable<SearchProductListResponse>

    fun getShippingMethods(
        customer_cart: String
    ): Flowable<ShippingMethodsResponse>

    fun setShippingMethod(
        customer_cart: String, carrier_code: String, method_code: String
    ): Flowable<SetShippingMethodResponse>

    fun getUserOrders(
        userId: String,
        page: Int,
        itemPerPage: Int = 10,
        languageCode: String
    ): Flowable<OrdersResponse>

    fun getOrderDetails(
        userId: String,
        orderId: String,
        languageCode: String
    ): Flowable<OrderDetailsResponse>

    fun getOrderStatues(
        userId: String,
        orderId: String,
        languageCode: String
    ): Flowable<OrderTrackingResponse>

    fun saveFirebaseToken(userTokenRequestBody: SaveFirebaseTokenRequestBody): Flowable<TokenResponse>
    fun setFirebaseToken(userTokenRequestBody: UserTokenRequestBody): Flowable<TokenResponse>
    fun getUpgradeVersion(version: String): Flowable<CheckVersionResponse>
    fun applyPromotion(promotionRequest: PromotionRequest): Flowable<List<PromotionValue>>
    fun layoutBlocks(languageCode: String): Flowable<HomeBlocksResponse>
    fun blockLayout(blockId: String, languageCode: String): Flowable<List<Banner>>
    fun extrctDeepLinkUrl(mExtractDeepLinkRequest: ExtractDeepLinkRequest): Flowable<ExtractDeepLinkResponse>
    fun getSpecificProducts(
        country_code: String,
        lang_code: String,
        action: String,
        items_per_page: Int,
        page: Int,
        pid: String
    ): Flowable<ProductsListResponse>

    fun getOptionsForProduct(lang_code: String, productId: String): Flowable<ProductOptionsResponse>
    fun getPromotion(
        mPromotionRequestModel: PromotionRequestModel
    ): Flowable<InAppMessageModel>

    fun getSelectAddress(AddressRequest: SelectedGuestAddressRequest): Flowable<SelectAddressResponse>
    fun socialMediaLogin(
        lang_code: String,
        mSocialLoginRequestBody: SocialLoginRequestBody
    ): Flowable<AuthenticationResponse>

    fun getMyWallet(
    ): Flowable<WalletResponse>

    fun getAllTransactions(
    ): Flowable<TransactionsHistoryResponse>

    fun getUserToken(
        osused: String,
        session: String,
        devid: String
    ): Flowable<UserTokenResponse>

    fun updateUserTokenWithCountryOrLanguage(
        country_code: String,
        lang_code: String
    ): Flowable<UserUpdateTokenResponse>

    fun addRedeemCode(
        mRedeemCodeRequest: RedeemCodeRequest
    ): Flowable<RedeemCodeResponse>

    fun logout(): Flowable<LogoutResponse>

    fun changePassword(editProfileRequestBody: ChangePasswordRequest): Flowable<EditUserProfileResponse>
    fun getCategoryBanners(
        lang_code: String,
        category_id: String
    ): Flowable<CategoryBannerResponse>

    fun inviteFriend(
        mInviteFriendRequest: InviteFriendRequest
    ): Flowable<InviteFriendResponse>

    fun checkEarn(
        mInviteFriendRequest: InviteFriendRequest
    ): Flowable<InviteFriendResponse>

    fun checkCashBack(orderId: String): Flowable<CheckCashBackResponse>

    fun createCart(): Flowable<CreateCartResponse>

    fun createGuestCart(): Flowable<CreateGuestCartResponse>
    fun restoreCart(cartId: String?): Flowable<RestoreCartResponse>
    fun AddProductToGraphCart(mAddItemToCartGraphRequest: AddItemToCartGraphRequest?): Flowable<AddProductToCartResponse>
    fun setBillingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Flowable<ShippingAddressResponse>
    fun setShippingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Flowable<ShippingAddressResponse>
    fun setGuestEmailOnCart(cartId: String?, email: String?): Flowable<AddGuestEmailToCartResponse>
    fun getUserProfile(): Flowable<UserProfileResponse>
    fun mergeCarts(customerCartId: String?, guestCartId: String?): Flowable<MergeCartsResponse>
    fun getCountryCurrency(
    ): Flowable<CountryCurrenceResponse>

    fun checkTokenValidation(token: String): Flowable<CheckTokenValidationResponse>
}