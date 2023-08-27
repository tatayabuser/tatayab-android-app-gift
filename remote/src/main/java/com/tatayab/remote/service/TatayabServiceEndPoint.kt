package com.tatayab.remote.service


import com.tatayab.model.Banner
import com.tatayab.model.EditUserProfileResponse
import com.tatayab.model.PromotionValue
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.requests.*
import com.tatayab.model.responses.*
import com.tatayab.remote.util.Constants
import com.tatayab.remote.util.Constants.Companion.SEARCH_URL
import com.tatayab.remote.util.Constants.Companion.SEARCH_URL_DEV
import com.tatayab.remote.util.Constants.Companion.searchEndPoint
import io.reactivex.Completable
import io.reactivex.Flowable
import retrofit2.http.*

interface TatayabServiceEndPoint {

    //////////////////////////region main ///////////////////////////////////////////

    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.TTTCATEGORIESACTIONS))
    fun getCategories2(@Body categoryRequest: CategoryRequest): Flowable<ArrayList<CategoryItem>>


    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.TTTCATEGORIESACTIONS))
    fun getSubCategories(@Body categoryRequest: CategoryRequest): Flowable<ArrayList<SubCategoriesResponse>>


    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.TOKENGENERATOR))
    fun generateCode(@Header("TOKEN-ID") token: String): Flowable<DeviceTokenResponse>

    // getProductsForCategory And Suppliers and AlsoBought
    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmProductsActions))
    fun getProductsForCategory(
        @QueryMap(encoded = true) options: Map<String, String>,
        @Query("page") page: Int = 1,
        @Query("items_per_page") itemsPerPage: Int = 10
    ): Flowable<ProductsListResponse>

    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmProductsActions))
    fun getProductGift(
        @Query("action") action: String = "list_gift"
    ): Flowable<ProductsListResponse>

    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmProductsActions))
    fun getProductsForSearch(
        @Query("action") action: String = "featuer_search_products",
        @Query("lang_code") lang_code: String
    ): Flowable<ProductsListResponse>

    ///addNotifyMeForProducts
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmProductsActions))
    fun addNotifyMeForProducts(@Body productActionRequest: ProductActionRequest): Flowable<NormalResponse>

    // Supplier
    @GET(Constants.API_VERSION_NUMBER.plus(Constants.SUPPLIERS))
    fun getSupplier(
        @Query("page") page: Int = 0,
        @Query("items_per_page") itemsPerPage: Int = 10,
        @Query("lang_code") lang_code: String,
        @QueryMap sort_options: Map<String, String>
    ): Flowable<SuppliersResponse>

    // new brands api
    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.SUPPLIERS))
    fun getNewSupplier(
        @Query("page") page: Int = 0,
        @Query("items_per_page") itemsPerPage: Int = 500,
        @Query("lang_code") lang_code: String,
        @QueryMap sort_options: Map<String, String>
    ): Flowable<ArrayList<SupplierResponse>>


    // getProductDetails
    @GET(Constants.API_VERSION_NUMBER.plus(Constants.PRODUCT_BY_ID))
    fun getProductById(
        @Path("id") id: String,
        @Query("lang_code") lang_code: String
    ): Flowable<ProductDetailsResponse>


    // getAlsoBought
    @GET(Constants.API_VERSION_NUMBER.plus(Constants.CUSTOMER_ALSO_BOUGHT))
    fun getCustomerAlsoBoughtById(
        @Query("also_bought_for_product_id") id: String,
        @Query("lang_code") lang_code: String
    ): Flowable<CustomerFeaturedProductsResponse>


    // login
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.LOGIN))
    fun login(
        @Body loginRequestBody: LoginRequestBody
    ): Flowable<AuthenticationResponse>


    // forgetPassword
    @GET(Constants.API_VERSION_NUMBER.plus(Constants.FORGET_PASSWORD))
    fun forgetPassword(
        @Query("email") email: String, @Query("lang_code") languageCode: String
    ): Flowable<NormalResponse>


    // register
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.USERS))
    fun register(
        @Body registerRequestBody: RegisterRequestBody,
        @Query("lang_code") languageCode: String
    ): Flowable<AuthenticationResponse>

    // editprofile
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.TTMUSERPROFILE))
    fun editProfile(@Body editProfileRequestBody: ProfileActionRequest): Flowable<EditUserProfileResponse>

    //// userProfile
    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.GetUserProfile))
    fun getUserProfile(@Path("userId") userId: String): Flowable<GetUserProfileResponse>


    // Countries
    @GET(Constants.API_VERSION_NUMBER.plus(Constants.COUNTRIES))
    fun getCountries(@Query("lang_code") lang_code: String): Flowable<ArrayList<CountryResponse>>


    //// Currencies
    @GET(Constants.API_VERSION_NUMBER.plus(Constants.CURRENCIES))
    fun getCurrencies(@Query("lang_code") lang_code: String): Flowable<ArrayList<CurrencyResponse>>


    // new API for add to cart
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun addOrderToCart(@Body addToCartRequest: AddItemToCartRequest): Flowable<AddItemToCartResponse>

    // delete order from cart
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun deleteOrderFromCart(@Body mDeleteItemFromCartRequest: DeleteItemFromCartRequest): Flowable<AddItemToCartResponse>


    // check out review
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun checkoutReview(
        @Query("lang_code") lang_code: String,
        @Body mReviewCartRequest: ReviewCartRequest
    ): Flowable<ReviewCartResponse>

    // Send payment method
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun sendPaymentMethod(
        @Query("lang_code") lang_code: String,
        @Body mPaymentMethodRequest: PaymentMethodRequest
    ): Flowable<ReviewCartResponse>

    // Apply Coupon
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun applyCoupon(
        @Query("lang_code") lang_code: String,
        @Body mAddCouponRequest: AddCouponRequest
    ): Flowable<ReviewCartResponse>

    // Remove Coupon
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun removeCoupon(
        @Query("lang_code") lang_code: String,
        @Body mRemoveCouponRequest: RemoveCouponRequest
    ): Flowable<ReviewCartResponse>

    // Create Order
    //user_id=30224&lang_code=en&country_code=KW&action=place_order&device_id=C9DF3E22-95C7-4E4B-923A-987275440FA0
    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.ORDER_STATUS))
    fun createOrder(
        @Query("user_id") user_id: String, @Query("lang_code") lang_code: String,
        @Query("country_code") country_code: String,
        @Query("action") action: String,
        @Query("device_id") device_id: String,
        @Query("is_gift") is_gift: Int,
        @Query("gift_sender_name") gift_sender_name: String,
        @Query("gift_receiver_name") gift_receiver_name: String,
        @Query("gift_msg") gift_msg: String

    ): Flowable<CreateOrderResponse>

    // get orders in cart
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun getOrdersFromCart(
        @Query("lang_code") lang_code: String,
        @Body mGetOrdersFromCartRequest: GetOrdersFromCartRequest
    ): Flowable<GetOrdersFromCartResponse>

    // get orders count in cart
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun getOrdersCountInCart(@Body mGetOrdersCountInCartRequest: GetOrdersCountInCartRequest): Flowable<GetOrdersCountInCartResponse>

    // update order amount in cart
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun updateOrderInCart(@Body mUpdateItemInCartRequest: UpdateItemInCartRequest): Flowable<AddItemToCartResponse>

    //get cities
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CITIES))
    fun getCities(
        @Query("lang_code") lang_code: String,
        @Body mGetCitiesRequest: GetCitiesRequest
    ): Flowable<List<CityModel>>

    //get area
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CITIES))
    fun getArea(
        @Query("lang_code") lang_code: String,
        @Body mGetAreaRequest: GetAreaRequest
    ): Flowable<List<AreaModel>>

    //get cart content
    @GET(Constants.API_VERSION_NUMBER.plus(Constants.CART))
    fun getCartContent(
        @Query("user_id") userId: String,
        @Query("lang_code") lang_code: String
    ): Flowable<CartContentResponse>

    //clear cart content
    @HTTP(
        method = "DELETE",
        path = Constants.API_VERSION_NUMBER.plus(Constants.CLEAR_CART),
        hasBody = true
    )
    fun clearCart(@Body cartRemoveRequestBody: CartRemoveRequestBody): Completable

    //delete cart item
    //@DELETE(Constants.API_VERSION_NUMBER.plus(Constants.CART))
    @HTTP(
        method = "DELETE",
        path = Constants.API_VERSION_NUMBER.plus(Constants.CART),
        hasBody = true
    )
    fun removeItemFromCart(@Body cartRemoveRequestBody: CartRemoveRequestBody): Completable

    // getProductDetails
    @GET(Constants.API_VERSION_NUMBER.plus(Constants.PRODUCTS_BY_IDS))
    fun getProductsByIds(
        @Query(value = "product_ids", encoded = true) productIds: String?,
        @Query("lang_code") lang_code: String
    ): Flowable<ProductsListResponse>

    // getCartConfig
    @GET(Constants.API_VERSION_NUMBER.plus(Constants.CART_CONFIG))
    fun getCartConfig(
        @Query("lang_code") lang_code: String, @Query(
            value = "product_ids",
            encoded = true
        ) productIds: String
    ): Flowable<CartConfigResponse>


    //// Add concierge
    @POST(Constants.API_VERSION_NUMBER.plus(Constants.CONCIERGE))
    fun addConcierge(@Body conciergeRequestBody: ConciergeRequestBody): Flowable<ConciergeResponse>

    //// product Reviewers
    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmProductsActions))
    fun getProductReviews(
        @Query("product_id") productId: String, @QueryMap options: Map<String, String>, @Query(
            "page"
        ) page: Int = 1, @Query("items_per_page") itemsPerPage: Int = 10,
        @Query("action") action: String = "reviews"
    ): Flowable<ProductReviewsResponse>

    //// Add review
    @POST(Constants.API_VERSION_NUMBER.plus(Constants.REVIEWS))
    fun addProductReview(@Body addReviewRequest: AddReviewRequest): Flowable<AddReviewResponse>


    //// Add Address
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.ADDRESS))
    fun addUserAddress(@Body addressRequest: AddressRequest): Flowable<AddressResponse>


    //// Get User Addresses
    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.ADDRESS))
    fun getUserAddresses(
        @Query("user_id") userId: String,
        @Query("lang_code") lang_code: String
    ): Flowable<ArrayList<AddressRequest>>


    //// Delete User Address
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.ADDRESS))
    fun deleteUserAddress(@Body deleteAddressRequest: DeleteAddressRequest): Flowable<AddressResponse>


    // upadate product
    @PUT(Constants.API_VERSION_NUMBER.plus(Constants.UPDATE_AMOUNT))
    fun updateProductAmountRemote(
        @Path("productId") productId: String,
        @Body updateProductAmountRequest: UpdateProductAmountRequest
    ): Flowable<AddToCartResponse>

    //// Apply coupon
    @POST(Constants.API_VERSION_NUMBER.plus(Constants.ORDERS_WITH_DASH))
    fun applyCoupon(@Body applyCouponRequest: ApplyCouponRequest): Flowable<CouponResponse>

    //// Create order
    @POST(Constants.API_VERSION_NUMBER.plus(Constants.CREATE_ORDER))
    fun createOrder(@Body createOrderRequest: CreateOrderRequest): Flowable<CreateOrderResponse>

    //add to wishList
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmWishlistActions))
    fun addToWishList(@Body addToWishListRequest: WishListActionRequest): Flowable<AddToWishListResponse>

    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.FILTER))
    fun getFilter(@QueryMap options: Map<String, String>): Flowable<FilterResponse>

    // getWishListProducts
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmWishlistActions))
    fun getWishListProducts(
        @Query("lang_code") lang_code: String,
        @Body addToWishListRequest: WishListActionRequest
    ): Flowable<WishListResponse>


    //// Search in  Products
//    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmProductsActions))
    @GET(SEARCH_URL.plus(searchEndPoint))
    fun searchInProducts(
        @Query("word") query: String,
        @Query("action") action: String = "list",
        @Query("page") page: Int = 0,
        @Query("items_per_page") itemsPerPage: Int = 10,
        @Query("search") search: String = "Y",
        @Query("lang_code") lang_code: String
    ): Flowable<SearchProductListResponse>

    // fet User OrdersResponse
    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.ORDERS))
    fun getOrders(
        @Query("user_id") userId: String,
        @Query("page") page: Int = 1,
        @Query("items_per_page") itemsPerPage: Int = 10,
        @Query("lang_code") lang_code: String
    ): Flowable<OrdersResponse>


    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.ORDERS))
    fun getOrderDetails(
        @Query("user_id") userId: String,
        @Query("order_id") orderId: String, @Query("lang_code") lang_code: String
    ): Flowable<OrderDetailsResponse>


    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.ORDER_STATUS))
    fun getOrderStatues(
        @Query("user_id") userId: String,
        @Query("order_id") orderId: String,
        @Query("lang_code") lang_code: String,
        @Query("action") action: String = "get_tracking"
    ): Flowable<OrderTrackingResponse>


    @POST(Constants.API_VERSION_NUMBER.plus(Constants.SET_FIREBASE_TOKEN))
    fun setFirebaseUserToken(@Body userTokenRequestBody: UserTokenRequestBody): Flowable<TokenResponse>

    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.SAVE_FIREBASE_TOKEN_ENDPOINT))
    fun saveFirebaseToken(@Body userTokenRequestBody: SaveFirebaseTokenRequestBody): Flowable<TokenResponse>

    @GET(Constants.API_VERSION_NUMBER.plus(Constants.VERSION_CHECK))
    fun getUpgradeVersion(
        @Query("v") version: String, @Query("os") os: String = "android"
    ): Flowable<CheckVersionResponse>

    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.PROMOTION))
    fun applyPromotion(@Body promotionRequestBody: PromotionRequest): Flowable<List<PromotionValue>>

    @GET(Constants.API_VERSION_NUMBER.plus(Constants.LAYOUT_BLOCKS))
    fun layoutBlocks(
        @Query("lang_code") lang_code: String
    ): Flowable<HomeBlocksResponse>

    //https://tatayab.com/api/5.0/TtmProductsActions?action=list&country_code=sa&currency_id=5&items_per_page=20&lang_code=ar&page=0&pid=6349,6583,4931,5417,5681,6582,6581,5735,5415,6580,5226,6579,5709,5672,6578,4816,6585,5671,6577,4445,4981,6575,4646,6589
    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmProductsActions))
    fun getSpecificProducts(
        @Query("country_code") country_code: String,
        @Query("lang_code") lang_code: String,
        @Query("action") action: String,
        @Query("items_per_page") items_per_page: Int,
        @Query("page") page: Int,
        @Query("pid") pid: String
    ): Flowable<ProductsListResponse>

    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.TTMBANNERS))
    fun blockLayout(
        @Query("banners_ids") banners_ids: String,
        @Query("lang_code") lang_code: String
    ): Flowable<List<Banner>>

    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun checkCart(@Body cartActionRequestBody: CartActionRequest): Flowable<CartActionResponse>

    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.URL_ACTION_END_POINT))
    fun extrctDeepLinkUrl(@Body mExtractDeepLinkRequest: ExtractDeepLinkRequest): Flowable<ExtractDeepLinkResponse>


    // getOptions For selected Product
    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmProductsActions))
    fun getOptionsForProduct(
        @Query("lang_code") lang_code: String,
        @Query("product_id") product_id: String,
        @Query("action") action: String = "get_options"
    ): Flowable<ProductOptionsResponse>

    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.PROMOTION_END_PINT))
    fun getPromotion(
        @Body mPromotionRequestModel: PromotionRequestModel
    ): Flowable<InAppMessageModel>


    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.CARTACTION))
    fun selectAddress(
        @Body selectedGuestAddressRequest: SelectedGuestAddressRequest
    ): Flowable<SelectAddressResponse>

    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.SOCISL_MEDIA_LOGIN_END_POINT))
    fun socialMediaLogin(
        @Query("lang_code") lang_code: String,
        @Body mSocialLoginRequestBody: SocialLoginRequestBody
    ): Flowable<AuthenticationResponse>

    // change password
    @POST(Constants.API_New_VERSION_NUMBER.plus(Constants.TTMUSERPROFILE))
    fun changePassword(@Body editProfileRequestBody: ChangePasswordRequest): Flowable<EditUserProfileResponse>

    @GET(Constants.API_New_VERSION_NUMBER.plus(Constants.TtmCategoriesBanners))
    fun getCategoryBanners(
        @Query("lang_code") lang_code: String,
        @Query("category_id") category_id: String): Flowable<CategoryBannerResponse>
}