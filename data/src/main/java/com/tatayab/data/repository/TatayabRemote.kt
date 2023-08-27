package com.tatayab.data.repository


import com.tatayab.model.Banner
import com.tatayab.model.EditUserProfileResponse
import com.tatayab.model.PromotionValue
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
import io.reactivex.Completable
import io.reactivex.Flowable

interface TatayabRemote {

    fun getCategories2(categoryRequest: CategoryRequest): Flowable<ArrayList<CategoryItem>>
    fun getSubCategories(categoryRequest: CategoryRequest): Flowable<ArrayList<SubCategoriesResponse>>
    fun getGeneratedCode(token: String): Flowable<DeviceTokenResponse>
    fun getCartContent(userId: String, languageCode: String): Flowable<CartContentResponse>
    fun getProductsForCategory(
        options: Map<String, String>,
        page: Int,
        itemPerPage: Int
    ): Flowable<ProductsListResponse>


    fun getProductGift(countryCode:String,cityCode:String
    ): Flowable<ProductsListResponse>

    fun getProductsForSearch(
        action: String,
        lang_code: String
    ): Flowable<ProductsListResponse>

    fun addNotifyMeAction(productActionRequest: ProductActionRequest): Flowable<NormalResponse>

    fun getProductDetails(
        productId: String,
        languageCode: String,
        country_code: String
    ): Flowable<ProductDetailsResponse>

    fun customerAlsoBought(
        productId: String,
        languageCode: String
    ): Flowable<CustomerFeaturedProductsResponse>

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

    fun getOrdersCountInCart(mGetOrdersCountInCartRequest: GetOrdersCountInCartRequest): Flowable<GetOrdersCountInCartResponse>
    fun addOrderToCart(addToCartRequest: AddItemToCartRequest): Flowable<AddItemToCartResponse>
    fun deleteOrderFromCart(mDeleteItemFromCartRequest: DeleteItemFromCartRequest): Flowable<AddItemToCartResponse>
    fun getOrdersFromCart(
        languageCode: String,
        mGetOrdersFromCartRequest: GetOrdersFromCartRequest
    ): Flowable<GetOrdersFromCartResponse>

    fun updateOrderInCart(mUpdateItemInCartRequest: UpdateItemInCartRequest): Flowable<AddItemToCartResponse>
    fun getRemoteCartContent(userId: String, languageCode: String): Flowable<CartContentResponse>
    fun getProductsByIds(
        productsIds: String?,
        languageCode: String
    ): Flowable<ProductsListResponse>

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

    fun login(loginRequestBody: LoginRequestBody): Flowable<AuthenticationResponse>
    fun forgetPassword(email: String, languageCode: String): Flowable<NormalResponse>
    fun register(
        registerRequestBody: RegisterRequestBody,
        languageCode: String
    ): Flowable<AuthenticationResponse>

    fun editProfile(editProfileRequestBody: ProfileActionRequest): Flowable<EditUserProfileResponse>
    fun getUserProfile(userId: String): Flowable<GetUserProfileResponse>
    fun getCountries(languageCode: String): Flowable<ArrayList<CountryResponse>>
    fun addConcierge(conciergeRequestBody: ConciergeRequestBody): Flowable<ConciergeResponse>
    fun getCities(lang_code: String, mGetCitiesRequest: GetCitiesRequest): Flowable<List<CityModel>>
    fun getAreas(lang_code: String, mGetAreaRequest: GetAreaRequest): Flowable<List<AreaModel>>
    fun getProductReviewers(
        productId: String,
        options: Map<String, String>,
        page: Int,
        itemsPerPage: Int
    ): Flowable<ProductReviewsResponse>

    fun getCurrencies(languageCode: String): Flowable<ArrayList<CurrencyResponse>>

    fun removeItemFromCart(cartRemoveRequestBody: CartRemoveRequestBody): Completable
    fun clearCartRemote(cartRemoveRequestBody: CartRemoveRequestBody): Completable
    fun getCartConfig(
        languageCode: String,
        productIds: String
    ): Flowable<CartConfigResponse>

    fun addReviewToProduct(addReviewRequest: AddReviewRequest): Flowable<AddReviewResponse>
    fun addUserAddress(addressRequest: AddressRequest): Flowable<AddressResponse>
    fun deleteUserAddress(deleteAddressRequest: DeleteAddressRequest): Flowable<AddressResponse>
    fun updateProductAmountRemote(
        productId: String,
        updateProductAmountRequest: UpdateProductAmountRequest
    ): Flowable<AddToCartResponse>

    fun applyCoupon(applyCouponRequest: ApplyCouponRequest): Flowable<CouponResponse>
    fun getUserAddresses(userId: String, languageCode: String): Flowable<ArrayList<AddressRequest>>
    fun createOrder(createOrderRequest: CreateOrderRequest): Flowable<CreateOrderResponse>
    fun getFilter(map: Map<String, String>): Flowable<FilterResponse>
    fun addToWishList(addToWishListRequest: WishListActionRequest): Flowable<AddToWishListResponse>
    fun getWishlistProducts(
        lang_code: String,
        addToWishListRequest: WishListActionRequest
    ): Flowable<WishListResponse>
    fun getShippingMethods(
        customer_cart: String
    ): Flowable<ShippingMethodsResponse>

    fun setShippingMethod(
        customer_cart:String,carrier_code:String,method_code:String
    ): Flowable<SetShippingMethodResponse>


    fun searchInProducts(
        key: String, page: Int,
        languageCode: String
    ): Flowable<SearchProductListResponse>

    fun setFirebaseToken(userTokenRequestBody: UserTokenRequestBody): Flowable<TokenResponse>
    fun saveFirebaseToken(userTokenRequestBody: SaveFirebaseTokenRequestBody): Flowable<TokenResponse>
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

    fun getUpgradeVersion(version: String): Flowable<CheckVersionResponse>

    fun applyPromotion(promotionRequest: PromotionRequest): Flowable<List<PromotionValue>>
    fun layoutBlocks(languageCode: String): Flowable<HomeBlocksResponse>
    fun blockLayout(blockId: String, languageCode: String): Flowable<List<Banner>>
    fun checkCartAvailability(cartActionRequest: CartActionRequest): Flowable<CartActionResponse>
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

    fun getSelectAddress(AddressRequest: SelectedGuestAddressRequest): Flowable<SelectAddressResponse>

    fun getPromotion(
        mPromotionRequestModel: PromotionRequestModel
    ): Flowable<InAppMessageModel>

    fun socialMediaLogin(
        lang_code: String,
        mSocialLoginRequestBody: SocialLoginRequestBody
    ): Flowable<AuthenticationResponse>

    fun getMyWallet(
    ): Flowable<WalletResponse>

    fun getAllTransactions(

    ): Flowable<TransactionsHistoryResponse>

    fun updateUserTokenWithCountryOrLanguage(
        country_code: String, lang_code: String
    ): Flowable<UserUpdateTokenResponse>

    fun getUserToken(
        osused: String,
        session: String,
        devid: String
    ): Flowable<UserTokenResponse>

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
    fun restoreCart(cartId: String?): Flowable<RestoreCartResponse>
    fun createGuestCart(): Flowable<CreateGuestCartResponse>
    fun AddProductToGraphCart(mAddItemToCartGraphRequest: AddItemToCartGraphRequest?): Flowable<AddProductToCartResponse>
    fun setBillingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Flowable<ShippingAddressResponse>
    fun setShippingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Flowable<ShippingAddressResponse>
    fun setGuestEmailOnCart(cartId: String?, email: String?): Flowable<AddGuestEmailToCartResponse>
    fun getUserProfile(): Flowable<UserProfileResponse>
    fun mergeCarts(customerCartId: String?,guestCartId:String?): Flowable<MergeCartsResponse>
     fun getCountryCurrency(): Flowable<CountryCurrenceResponse>
     fun checkTokenValidation(token: String): Flowable<CheckTokenValidationResponse>
}


