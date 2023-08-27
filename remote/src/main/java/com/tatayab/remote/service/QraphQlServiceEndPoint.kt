package com.tatayab.remote.service


import com.tatayab.model.requests.graph_request.AddGraphProductReviewRequest
import com.tatayab.model.requests.graph_request.GraphRequest
import com.tatayab.model.responses.graph_responses.*
import io.reactivex.Flowable
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface QraphQlServiceEndPoint {

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getCountries(@Body body: GraphRequest): Flowable<GraphCountriesResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getCategoryProducts(@Body body: GraphRequest): Flowable<GraphCategoryProductsResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getAlsoBoughtProducts(@Body body: GraphRequest): Flowable<GraphAlsoBoughtProductsResponse>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getMainCategories(@Body body: GraphRequest): Flowable<GraphMainCategoriesResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getSubCategories(@Body body: GraphRequest): Flowable<GraphSubCategoriesResponse>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getSuppliers(@Body body: GraphRequest): Flowable<GraphSuppliersResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getProductDetails(@Body body: GraphRequest): Flowable<GraphCategoryProductsResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun register(@Body body: GraphRequest): Flowable<RegisterationResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getToken(@Body body: GraphRequest): Flowable<GetTokenResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getLayoutBlocks(@Body body: GraphRequest): Flowable<GetLayoutBlocks>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getSpecificProducts(@Body body: GraphRequest): Flowable<GraphCategoryProductsResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getBannerById(@Body body: GraphRequest): Flowable<GraphGetBannerById>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun createCart(@Body body: GraphRequest): Flowable<CreateCartResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun createGuestCart(@Body body: GraphRequest): Flowable<CreateGuestCartResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun AddProductToGraphCart(@Body body: GraphRequest): Flowable<AddProductToCartResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun addProductWithOptionsToGraphCart(@Body body: GraphRequest): Flowable<AddProductWithOptionsToCartResponse>

    @Headers("Content-Type: application/json","City: null")
    @POST("graphql")
    fun getCart(@Body body: GraphRequest): Flowable<CartItemsResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getCheckout(@Body body: GraphRequest): Flowable<CheckoutResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun updatePaymentMethod(@Body body: GraphRequest): Flowable<PaymentUpdateInCheckoutResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun applyCoupon(@Body body: GraphRequest): Flowable<ApplyCouponCheckoutResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun removeCoupon(@Body body: GraphRequest): Flowable<RemoveCouponCheckoutResponse>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun addUserAddress(@Body body: GraphRequest): Flowable<GetAddUserAddress>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getUserAddresses(@Body body: GraphRequest): Flowable<GetUserAddressesGraphResponse>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun deleteUserAddresses(@Body body: GraphRequest): Flowable<GraphDeleteUserAddress>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun setBillingAddressOnCart(@Body body: GraphRequest): Flowable<ShippingAddressResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun placeOrder(@Body body: GraphRequest): Flowable<PlaceOrderResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun setGuestEmailOnCart(@Body body: GraphRequest): Flowable<AddGuestEmailToCartResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getUserProfile(@Body body: GraphRequest): Flowable<UserProfileResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun addProductReview(@Body body: GraphRequest): Flowable<AddGraphProductReviewRequest>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getProductReviewMetaData(@Body body: GraphRequest): Flowable<GetProductReviewsMetaData>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun addNotifyMeAction(@Body body: GraphRequest): Flowable<GetGraphNotifyMeActionResponse>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getWishlistList(@Body body: GraphRequest): Flowable<GetWishListResponse>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun addProductToWishlistList(@Body body: GraphRequest): Flowable<GraphAddProductToWishListResponse>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun removeProductFromWishlistList(@Body body: GraphRequest): Flowable<RemoveFromWishListResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getCities(@Body body: GraphRequest): Flowable<GraphGetRegionsResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getCitiesFoeOneLevel(@Body body: GraphRequest): Flowable<GraphGetCitiesResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getAreasViaCountry(@Body body: GraphRequest): Flowable<GraphRegionByCityIDResponse>

 @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getAreaForOneLevelViaCountry(@Body body: GraphRequest): Flowable<GraphGetRegionsResponse>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getUserOrders(@Body body: GraphRequest): Flowable<GetGraphUserOrdersResponse>

    @Headers("Content-Type: application/json")
     @POST("graphql")
    fun getUpgradeVersion(@Body body: GraphRequest): Flowable<CheckAppVersion>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getOrderDetails(@Body body: GraphRequest): Flowable<GetGraphUserOrdersResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun setShippingMethod(@Body body: GraphRequest): Flowable<SetShippingMethodResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getShippingMethods(@Body body: GraphRequest): Flowable<ShippingMethodsResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getFilterData(@Body body: GraphRequest): Flowable<GetGraphCategoriesFilterResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getProductReviews(@Body body: GraphRequest): Flowable<GetGraphProductReviewsResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun searchInProducts(@Body body: GraphRequest): Flowable<GraphCategoryProductsResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getWallet(@Body body: GraphRequest): Flowable<WalletGraphResponse>


    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getWalletTransactions(@Body body: GraphRequest): Flowable<WalletTransactionsGraphResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun forgotPassword(@Body body: GraphRequest): Flowable<ForgotPasswordGraphResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun changePassword(@Body body: GraphRequest): Flowable<ChangePasswordGraphResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun restoreCart(@Body body: GraphRequest): Flowable<RestoreCartResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun mergeCarts(@Body body: GraphRequest): Flowable<MergeCartsResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun saveFirebaseToken(@Body body: GraphRequest): Flowable<SaveFirebaseTokenResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getGiftItems(@Body body: GraphRequest): Flowable<GiftItemsResponse>

    @Headers("Content-Type: application/json","City: null")
    @POST("graphql")
    fun addGiftItemToCart(@Body body: GraphRequest): Flowable<AddGiftItemToCartResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun removeGiftItemFromCart(@Body body: GraphRequest): Flowable<AddGiftItemToCartResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun updateGiftItemFromCart(@Body body: GraphRequest): Flowable<AddGiftItemToCartResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun removeItemFromCart(@Body body: GraphRequest): Flowable<RemoveItemToCartResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun getCountryCurrency(@Body body: GraphRequest): Flowable<CountryCurrenceResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun loginWithSocialMedia(@Body body: GraphRequest): Flowable<GetTokenForSocialMediaResponse>

    @Headers("Content-Type: application/json")
    @POST("graphql")
    fun checkTokenExpiration(@Body body: GraphRequest): Flowable<CheckTokenValidationResponse>
}