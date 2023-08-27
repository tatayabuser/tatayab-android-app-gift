package com.tatayab.domain.repository


import com.tatayab.model.*
import com.tatayab.model.EditUserProfileResponse
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.db.WishItem
import com.tatayab.model.requests.*
import com.tatayab.model.requests.ConciergeRequestBody
import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.responses.CurrencyResponse
import com.tatayab.model.requests.LoginRequestBody
import com.tatayab.model.requests.RegisterRequestBody
import com.tatayab.model.requests.graph_request.AddItemToCartGraphRequest
import com.tatayab.model.responses.*
import com.tatayab.model.responses.graph_responses.*
import io.reactivex.*
import io.reactivex.disposables.Disposable

interface TatayabRepository {


    fun saveUserSettingToCache(userSetting: UserSetting): Completable
    fun saveUserAuthToCache(userSetting: UserAuth): Completable
    fun saveCurrentLanguageToCache(lang: String): Completable
    fun getCurrentLanguageFromCache(): Maybe<String>
    fun getUserSettingFromCache(): Maybe<UserSetting>
    fun getUserAuthFromCache(): Maybe<UserAuth>
    fun getGuestAddressFromCache(): Maybe<Address>
    fun setGuestAddressFromCache(address: Address?): Completable
    fun getGeneratedCode(token: String): Observable<DeviceTokenResponse>
    fun addNotifyMeAction(productActionRequest: ProductActionRequest): Observable<NormalResponse>
    fun getProductsForSearch(
        action: String,
        lang_code: String
    ): Observable<ProductsListResponse>

    fun getSubCategories(categoryRequest: CategoryRequest): Observable<ArrayList<SubCategoriesResponse>>
    fun getUserCartIdFromCache(): Maybe<String>
    fun getGuestCartIdFromCache(): Maybe<String>
    fun removeUserCartIdToCache()
    fun removeGuestCartIdToCache()
    fun deleteUserFromCache(): Observable<Boolean>
    fun saveUserToCache(userDataObject: AuthenticationResponse): Completable
    fun getUserFromCache(): Maybe<AuthenticationResponse>

    fun removeGuestAddressFromCache(): Boolean
    fun getCartItems(): Observable<MutableList<String>>
    fun getSearchSuggestionListFromCache(): Observable<MutableList<SearchModel>>
    fun saveSearchSuggestionToCache(searchModel: SearchModel): Int
    fun saveSearchSuggestionListToCache(suggestionList: List<SearchModel>): Int
    fun clearCartCache(): Completable
    fun clearRecentViewProducts(): Completable
    fun clearCartCachedAndRemote(userId: String): Completable

    fun getCartSize(): Observable<Int>

    fun getRemoteCartContent(userId: String, languageCode: String): Observable<CartContentResponse>

    fun setShippingMethod(
        customer_cart: String, carrier_code: String, method_code: String
    ): Observable<SetShippingMethodResponse>

    fun getShippingMethods(
        customer_cart: String
    ): Observable<ShippingMethodsResponse>

    fun getProductsByKey(
        query: String,
        page: Int,
        languageCode: String
    ): Observable<SearchProductListResponse>


    fun getUserProfile(userId: String): Observable<GetUserProfileResponse>
    fun getCategories2(categoryRequest: CategoryRequest): Observable<ArrayList<CategoryItem>>

    fun getProductForCategory(
        options: Map<String, String>,
        page: Int = 0,
        itemPerPage: Int = 10
    ): Observable<ProductsListResponse>

    fun getProductGift(countryCode:String,cityCode:String
    ): Observable<ProductsListResponse>

    fun login(loginRequestBody: LoginRequestBody): Observable<AuthenticationResponse>
    fun forgetPassword(email: String, languageCode: String): Observable<NormalResponse>
    fun register(
        registerRequestBody: RegisterRequestBody,
        languageCode: String
    ): Observable<AuthenticationResponse>

    fun editProfile(editProfileRequestBody: ProfileActionRequest): Observable<EditUserProfileResponse>

    fun customerAlsoBought(
        productId: String,
        languageCode: String
    ): Observable<CustomerFeaturedProductsResponse>


    fun getProductDetails(
        productId: String,
        languageCode: String,
        country_code: String
    ): Observable<ProductDetailsResponse>


    fun getSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Observable<SuppliersResponse>

    fun getNewSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Observable<ArrayList<SupplierResponse>>

    fun checkoutReview(
        languageCode: String,
        mReviewCartRequest: ReviewCartRequest
    ): Observable<ReviewCartResponse>

    fun addOrderToCart(addToCartRequest: AddItemToCartRequest): Observable<AddItemToCartResponse>
    fun getOrdersFromCart(
        languageCode: String,
        mGetOrdersFromCartRequest: GetOrdersFromCartRequest
    ): Observable<GetOrdersFromCartResponse>

    fun updateCartItemAmount(mUpdateItemInCartRequest: UpdateItemInCartRequest): Observable<AddItemToCartResponse>
    fun deleteOrderFromCart(mDeleteItemFromCartRequest: DeleteItemFromCartRequest): Observable<AddItemToCartResponse>
    fun getOrdersCountInCart(mGetOrdersCountInCartRequest: GetOrdersCountInCartRequest): Observable<GetOrdersCountInCartResponse>
    fun getCurriencies(languageCode: String): Observable<ArrayList<CurrencyResponse>>
    fun getCountries(languageCode: String): Observable<ArrayList<CountryResponse>>
    fun removeItemFromCartRemote(
        cartRemoveRequestBody: CartRemoveRequestBody,
        productId: String,
        options: Map<String, String>
    ): Observable<Int>


    fun sendPaymentMethod(
        languageCode: String,
        mPaymentMethodRequest: PaymentMethodRequest
    ): Observable<ReviewCartResponse>

    fun applyCoupon(
        languageCode: String,
        mAddCouponRequest: AddCouponRequest
    ): Observable<ReviewCartResponse>

    fun removeCoupon(
        languageCode: String,
        mRemoveCouponRequest: RemoveCouponRequest
    ): Observable<ReviewCartResponse>

    fun createOrder(
        user_id: String, languageCode: String,
        country_code: String,
        action: String,
        device_id: String, is_gift: Int,
        gift_sender_name: String,
        gift_receiver_name: String,
        gift_msg: String,
        cartId: String
    ): Observable<CreateOrderResponse>

    fun clearCartRemote(cartRemoveRequestBody: CartRemoveRequestBody): Completable
    fun getCartConfig(languageCode: String): Observable<CartConfigResponse>

    fun addConcierge(conciergeRequestBody: ConciergeRequestBody): Observable<ConciergeResponse>
    fun getProductReviwers(
        productId: String,
        options: Map<String, String>,
        page: Int,
        itemPerPage: Int
    ): Observable<ProductReviewsResponse>

    fun addReviewToProduct(addReviewRequest: AddReviewRequest): Observable<AddReviewResponse>
    fun updateProductAmountRemote(
        productIdRemote: String,
        productIdCache: String,
        updateProductAmount: UpdateProductAmountRequest
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>>

    fun updateProductAmountCache(
        productId: String,
        amount: Int,
        options: Map<String, String>
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>>

    fun applyCoupon(
        applyCouponRequest: ApplyCouponRequest
    ): Observable<CouponResponse>

    fun addUserAddress(addressRequest: AddressRequest): Observable<AddressResponse>
    fun getCities(
        lang_code: String,
        mGetCitiesRequest: GetCitiesRequest
    ): Observable<List<CityModel>>

    fun getAreas(lang_code: String, mGetAreaRequest: GetAreaRequest): Observable<List<AreaModel>>
    fun getUserAddresses(
        userId: String,
        languageCode: String
    ): Observable<ArrayList<AddressRequest>>

    fun deleteUserAddress(deleteAddressRequest: DeleteAddressRequest): Observable<AddressResponse>
    fun createOrder(createOrderRequest: CreateOrderRequest): Observable<CreateOrderResponse>
    fun addToWishList(addToWishListRequest: WishListActionRequest): Observable<AddToWishListResponse>
    fun getWishListProducts(
        addToWishListRequest: WishListActionRequest
    ): Observable<WishListResponse>

    fun getUserOrders(
        userId: String,
        page: Int,
        itemPerPage: Int = 10,
        languageCode: String
    ): Observable<OrdersResponse>

    fun getOrderDetails(
        userId: String,
        orderId: String,
        languageCode: String
    ): Observable<OrderDetailsResponse>

    fun saveFirebaseToken(userTokenRequestBody: SaveFirebaseTokenRequestBody): Observable<TokenResponse>
    fun getOrderStatues(
        userId: String,
        orderId: String,
        languageCode: String
    ): Observable<OrderTrackingResponse>

    fun getFilter(map: Map<String, String>): Observable<FilterResponse>
    fun setFirebaseToken(userTokenRequestBody: UserTokenRequestBody): Observable<TokenResponse>
    fun getUpgradeVersion(version: String): Observable<CheckVersionResponse>
    fun applyPromotion(promotionRequest: PromotionRequest): Observable<List<PromotionValue>>
    fun layoutBlocks(languageCode: String, enableGraph: Boolean): Observable<HomeBlocksResponse>
    fun blockLayout(
        catId: String,
        blockId: String,
        languageCode: String
    ): Observable<List<Banner>>
    //fun layoutBlocksCombined(countryCode: String,languageCode: String): Observable<CompositeBlockItem>

    fun extrctDeepLinkUrl(mExtractDeepLinkRequest: ExtractDeepLinkRequest): Observable<ExtractDeepLinkResponse>
    fun getSpecificProducts(
        country_code: String,
        lang_code: String,
        action: String,
        items_per_page: Int,
        page: Int,
        pid: String
    ): Observable<ProductsListResponse>

    fun insertWishItemToChace(wishItem: WishItem): Completable

    fun deleteWishItemFromCache(productId: String, countryId: String): Completable
    fun deleteAllWishListForCountryFromCache(countryId: String): Completable

    fun getOptionsForProduct(
        lang_code: String,
        productId: String
    ): Observable<ProductOptionsResponse>

    fun getPromotion(
        mPromotionRequestModel: PromotionRequestModel
    ): Observable<InAppMessageModel>

    fun getSelectAddress(AddressRequest: SelectedGuestAddressRequest): Observable<SelectAddressResponse>
    fun socialMediaLogin(
        lang_code: String,
        mSocialLoginRequestBody: SocialLoginRequestBody
    ): Observable<AuthenticationResponse>

    fun getMyWallet(
    ): Observable<WalletResponse>

    fun getAllTransactions(
    ): Observable<TransactionsHistoryResponse>

    fun getUserToken(
        osused: String,
        session: String,
        devid: String
    ): Observable<UserTokenResponse>

    fun updateUserTokenWithCountryOrLanguage(
        country_code: String,
        lang_code: String
    ): Observable<UserUpdateTokenResponse>

    fun addRedeemCode(
        mRedeemCodeRequest: RedeemCodeRequest
    ): Observable<RedeemCodeResponse>

    fun addProductToRecentView(productId: String): Completable
    fun getRecentViewProducts(): Observable<String>
    fun logout(): Observable<LogoutResponse>
    fun changePassword(editProfileRequestBody: ChangePasswordRequest): Observable<EditUserProfileResponse>
    fun getCategoryBanners(
        lang_code: String,
        category_id: String
    ): Observable<CategoryBannerResponse>

    fun inviteFriend(
        mInviteFriendRequest: InviteFriendRequest
    ): Observable<InviteFriendResponse>

    fun checkEarn(
        mInviteFriendRequest: InviteFriendRequest
    ): Observable<InviteFriendResponse>

    fun checkCashBack(orderId: String): Observable<CheckCashBackResponse>
    fun createCart(): Observable<CreateCartResponse>

    fun createGuestCart(): Observable<CreateGuestCartResponse>
    fun restoreCart(cartId: String?): Observable<RestoreCartResponse>
    fun AddProductToGraphCart(mAddItemToCartGraphRequest: AddItemToCartGraphRequest?): Observable<AddProductToCartResponse>
    fun setShippingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Observable<ShippingAddressResponse>
    fun setBillingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Observable<ShippingAddressResponse>
    fun setGuestEmailOnCart(cartId: String?, email: String?): Observable<AddGuestEmailToCartResponse>
    fun mergeCarts(customerCartId: String?,guestCartId:String?): Observable<MergeCartsResponse>
    fun getCountryCurrency(
    ): Observable<CountryCurrenceResponse>
    fun checkTokenValidation(token: String): Observable<CheckTokenValidationResponse>
    }