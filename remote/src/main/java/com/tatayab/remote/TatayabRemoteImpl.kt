package com.tatayab.remote


import com.tatayab.data.repository.TatayabRemote
import com.tatayab.data.source.WishListMemoryCacheManager
import com.tatayab.model.Banner
import com.tatayab.model.EditUserProfileResponse
import com.tatayab.model.PromotionValue
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.requests.*
import com.tatayab.model.requests.graph_request.AddGraphProductReviewRequest
import com.tatayab.model.requests.graph_request.AddItemToCartGraphRequest
import com.tatayab.model.requests.graph_request.GraphRequest
import com.tatayab.model.responses.*
import com.tatayab.model.responses.graph_responses.*
import com.tatayab.remote.service.QraphQlServiceEndPoint
import com.tatayab.remote.service.TatayabServiceEndPoint
import com.tatayab.remote.service.UserTatayabServiceEndPoint
import com.tatayab.remote.service.WalletTatayabServiceEndPoint
import com.tatayab.remote.util.Constants
import com.tatayab.remote.util.Constants.Companion.ACTION
import com.tatayab.remote.util.Constants.Companion.ALSO_BOUGHT_ACTION
import com.tatayab.remote.util.Constants.Companion.FEATURES_HASH
import com.tatayab.remote.util.Constants.Companion.LIST_GRAPH_ACTION
import com.tatayab.remote.util.Constants.Companion.LIST_GRAPH_ACTION_ID
import com.tatayab.remote.util.Constants.Companion.PRICE_FROM
import com.tatayab.remote.util.Constants.Companion.PRICE_TO
import com.tatayab.remote.util.Constants.Companion.sort_by
import com.tatayab.remote.util.Constants.Companion.sort_order
import com.tatayab.remote.util.GraphQlQuires
import com.tatayab.remote.util.GraphQlQuires.Companion.GET_GRAPH_BLOCKS
import com.tatayab.remote.util.GraphQlQuires.Companion.GET_ALL_ADDRESSES_QUERY
import com.tatayab.remote.util.GraphQlQuires.Companion.GET_ALL_BRANDS
import com.tatayab.remote.util.GraphQlQuires.Companion.GET_ALL_CATEGORIES
import com.tatayab.remote.util.GraphQlQuires.Companion.GET_ALL_CATEGORIES2
import com.tatayab.remote.util.GraphQlQuires.Companion.GET_ALL_COUNTRIES
import com.tatayab.remote.util.GraphQlQuires.Companion.GET_REGISTER_QUERY
import com.tatayab.remote.util.GraphQlQuires.Companion.GET_TOKEN_QUERY
import com.tatayab.remote.util.GraphQlQuires.Companion.GET_WISHLIST_PRODUCTS
import com.tatayab.remote.util.GraphQlQuires.Companion.PRODUCT_REVIEW_META_DATE
import com.tatayab.remote.util.GraphQlQuires.Companion.addGiftToCartQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.addProductReview
import com.tatayab.remote.util.GraphQlQuires.Companion.addProductToCart
import com.tatayab.remote.util.GraphQlQuires.Companion.addProductWithOptionToCart
import com.tatayab.remote.util.GraphQlQuires.Companion.applyCouponQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.checkTokenExpiration
import com.tatayab.remote.util.GraphQlQuires.Companion.createCartForGuestUser
import com.tatayab.remote.util.GraphQlQuires.Companion.getAddAddressQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getAddToWishListQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getAreasByCity
import com.tatayab.remote.util.GraphQlQuires.Companion.getAreasForOneLevelCountry
import com.tatayab.remote.util.GraphQlQuires.Companion.getBannerById
import com.tatayab.remote.util.GraphQlQuires.Companion.getCartQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getChangePasswordQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getCheckoutQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getCitiesQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getCountryCurrencyQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getFilterData
import com.tatayab.remote.util.GraphQlQuires.Companion.getForgotPasswordQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getGiftItems
import com.tatayab.remote.util.GraphQlQuires.Companion.getLastSupportedVersion
import com.tatayab.remote.util.GraphQlQuires.Companion.getLoginWithSocialMedia
import com.tatayab.remote.util.GraphQlQuires.Companion.getMergeCartsQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getNotifyMeProductQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getOneLevelCitiesByCountry
import com.tatayab.remote.util.GraphQlQuires.Companion.getOrderDetailsQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getProductCategoryApi
import com.tatayab.remote.util.GraphQlQuires.Companion.getProductDetailsQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getProductReviews
import com.tatayab.remote.util.GraphQlQuires.Companion.getRemoveItemFromCartQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getRestoreCartQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getSearchInProductsQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getSubCategory
import com.tatayab.remote.util.GraphQlQuires.Companion.getUserOrdersQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getUsersAlsoBoughtProducts
import com.tatayab.remote.util.GraphQlQuires.Companion.graphDeleteUserAddress
import com.tatayab.remote.util.GraphQlQuires.Companion.placeOrderQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.removeCouponQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.removeFromWishList
import com.tatayab.remote.util.GraphQlQuires.Companion.setBillingAddressOnCartQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.setGuestEmailOnCartQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.setPaymentMethodQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.setShippingAddressOnCartQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.setShippingMethodQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getShippingAvalMethodsQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getUpdateItemFromCartQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getWalletQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.getWalletTransactionsQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.removeGiftToCartQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.updateGiftToCartQuery
import com.tatayab.remote.util.GraphQlQuires.Companion.userProfileQuery
import io.reactivex.Completable
import io.reactivex.Flowable
import javax.inject.Inject


class TatayabRemoteImpl @Inject constructor(
    private val service: TatayabServiceEndPoint,
    private val walletService: WalletTatayabServiceEndPoint,
    private val userService: UserTatayabServiceEndPoint,
    private val graphService: QraphQlServiceEndPoint
) : TatayabRemote {

    override fun getUpgradeVersion(version: String): Flowable<CheckVersionResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS)
           return  graphService.getUpgradeVersion(GraphRequest(getLastSupportedVersion(version))).flatMap {
                if (it?.data?.CheckVersionGraphql == true)
                    Flowable.just(CheckVersionResponse(status = "success"))
                else
                    Flowable.just(CheckVersionResponse(status = "failed"))
            }
//        else
//            return service.getUpgradeVersion(version)
    }

    // Stop this un till gte the new one from magento
    override fun getOrderStatues(
        userId: String,
        orderId: String,
        languageCode: String
    ): Flowable<OrderTrackingResponse> {
        return service.getOrderStatues(userId, orderId, languageCode)
    }

    override fun getOrderDetails(
        userId: String,
        orderId: String,
        languageCode: String
    ): Flowable<OrderDetailsResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getOrderDetails(GraphRequest(getOrderDetailsQuery(orderId))).flatMap {
            GraphResponseConverter().convertToOrderDetails(it)
        }
//        else service.getOrderDetails(userId, orderId, languageCode)
    }

    override fun searchInProducts(
        key: String,
        page: Int,
        languageCode: String
    ): Flowable<SearchProductListResponse> {
        //        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.searchInProducts(GraphRequest(getSearchInProductsQuery(key))).flatMap {
            GraphResponseConverter().convertToSearchProductsLists(it)
        }
//        else service.searchInProducts(query = key, page = page, lang_code = languageCode)
    }

    override fun setShippingMethod(
        customer_cart: String, carrier_code: String, method_code: String
    ): Flowable<SetShippingMethodResponse> {
        return graphService.setShippingMethod(
            GraphRequest(
                setShippingMethodQuery(
                    customer_cart,
                    carrier_code,
                    method_code
                )
            )
        )
    }

    override fun getShippingMethods(
        customer_cart: String
    ): Flowable<ShippingMethodsResponse> {
        return graphService.getShippingMethods(
            GraphRequest(
                getShippingAvalMethodsQuery(customer_cart)
            )
        )
    }

    override fun getWishlistProducts(
        lang_code: String,
        addToWishListRequest: WishListActionRequest
    ): Flowable<WishListResponse> {
//         return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getWishlistList(GraphRequest(GET_WISHLIST_PRODUCTS)).flatMap {
            GraphResponseConverter().convertToWishListProducts(it)
        }
//        else service.getWishListProducts(lang_code, addToWishListRequest)
    }

    override fun addToWishList(addToWishListRequest: WishListActionRequest): Flowable<AddToWishListResponse> {
        // Osama Done
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return if (addToWishListRequest.action == "add")
            graphService.addProductToWishlistList(
                GraphRequest(
                    getAddToWishListQuery(
                        if (!addToWishListRequest.wishListId.isNullOrEmpty()) addToWishListRequest.wishListId!!
                        else WishListMemoryCacheManager.getUserWishListId() ?: "",
                        addToWishListRequest.product_id
                    )
                )
            ).flatMap {
                GraphResponseConverter().convertToAddToWishList(
                    it,
                    addToWishListRequest.product_id
                )
            }
        else
            graphService.removeProductFromWishlistList(
                GraphRequest(
                    removeFromWishList(
                        if (addToWishListRequest.wishListId.isNullOrEmpty()) addToWishListRequest.wishListId!!
                        else WishListMemoryCacheManager.getUserWishListId() ?: "",
                        WishListMemoryCacheManager.getWishListItemId(addToWishListRequest.product_id)
                            .toString()
                    )
                )
            ).flatMap {
                GraphResponseConverter().convertToRemoveFromWishList(
                    it,
                    addToWishListRequest.product_id
                )
            }
//        } else service.addToWishList(addToWishListRequest)
    }

    override fun getUserOrders(
        userId: String,
        page: Int,
        itemPerPage: Int,
        languageCode: String
    ): Flowable<OrdersResponse> {
        //        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getUserOrders(GraphRequest(getUserOrdersQuery(page + 1, itemPerPage)))
            .flatMap {
                GraphResponseConverter().convertOrdersList(it)
            }
//        else
//            service.getOrders(userId, page, itemPerPage, languageCode)
    }

    override fun deleteUserAddress(deleteAddressRequest: DeleteAddressRequest): Flowable<AddressResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.deleteUserAddresses(
            GraphRequest(
                graphDeleteUserAddress(
                    deleteAddressRequest.o_address_id
                )
            )
        ).flatMap {
            Flowable.just(AddressResponse(o_address_id = if (it.data.deleteCustomerAddress) deleteAddressRequest.o_address_id.toInt() else -1))
        }
//        } else service.deleteUserAddress(deleteAddressRequest)
    }

    override fun getUserAddresses(
        userId: String,
        languageCode: String
    ): Flowable<ArrayList<AddressRequest>> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getUserAddresses(GraphRequest(GET_ALL_ADDRESSES_QUERY)).flatMap {
            GraphResponseConverter().convertToAddressesLists(it)
        }
//        } else
//            service.getUserAddresses(userId, languageCode)
    }

    // It not used
    override fun createOrder(createOrderRequest: CreateOrderRequest): Flowable<CreateOrderResponse> {
        //Ahmed  Done
        return service.createOrder(createOrderRequest)
    }

    override fun setBillingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Flowable<ShippingAddressResponse> {
        return graphService.setBillingAddressOnCart(
            GraphRequest(
                setBillingAddressOnCartQuery(
                    mShippingAddressRequest
                )
            )
        )
    }

    override fun setShippingAddressOnCart(mShippingAddressRequest: ShippingAddressRequest?): Flowable<ShippingAddressResponse> {
        return graphService.setBillingAddressOnCart(
            GraphRequest(
                setShippingAddressOnCartQuery(
                    mShippingAddressRequest!!
                )
            )
        )
    }

    override fun setGuestEmailOnCart(
        cartId: String?,
        email: String?
    ): Flowable<AddGuestEmailToCartResponse> {
        return graphService.setGuestEmailOnCart(
            GraphRequest(
                setGuestEmailOnCartQuery(
                    cartId!!, email!!
                )
            )
        )
    }

    override fun getUserProfile(): Flowable<UserProfileResponse> {
        return graphService.getUserProfile(
            GraphRequest(
                userProfileQuery()
            )
        )
    }

    override fun getFilter(map: Map<String, String>): Flowable<FilterResponse> {
//         return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getFilterData(
            GraphRequest(
                getFilterData(
                    map.entries.first().key,
                    map.entries.first().value
                )
            )
        ).flatMap {
            GraphResponseConverter().convertToFiltersData(it, map.entries.first().key)
        }
//        else service.getFilter(map)
    }

    override fun addUserAddress(addressRequest: AddressRequest): Flowable<AddressResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.addUserAddress(GraphRequest(getAddAddressQuery(addressRequest)))
            .flatMap {
                Flowable.just(
                    AddressResponse(
                        o_address_id = it?.data?.createCustomerAddress?.id,
                        itemIndex = 0,
                        message = it.errorsListModel?.get(0)?.message
                    )
                )
            }
//        } else {
//            service.addUserAddress(addressRequest)
//        }
    }

    override fun addReviewToProduct(addReviewRequest: AddReviewRequest): Flowable<AddReviewResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getProductReviewMetaData(GraphRequest(PRODUCT_REVIEW_META_DATE))
            .flatMap { metaResponse ->
                graphService.addProductReview(
                    getAddProductReviewRequest(
                        addReviewRequest,
                        metaResponse
                    )
                ).flatMap {
                    Flowable.just(
                        AddReviewResponse(
                            product_id = addReviewRequest.product_id,
                            message = ""
                        )
                    )
                }
            }
//        } else service.addProductReview(addReviewRequest)
    }

    private fun getAddProductReviewRequest(
        addReviewRequest: AddReviewRequest,
        metaResponse: GetProductReviewsMetaData
    ): GraphRequest {
        return GraphRequest(
            addProductReview(
                AddGraphProductReviewRequest(name = addReviewRequest.user_name,
                    sku = addReviewRequest.product_id,
                    ratingId = metaResponse.data.productReviewRatingsMetadata.items[0].id,
                    ratingIdValue = metaResponse.data.productReviewRatingsMetadata.items[0].values
                        .filter { it.value == addReviewRequest.rating_value.toInt() }
                        .takeIf { it.isNotEmpty() }?.get(0)?.value_id ?: "",
                    text = addReviewRequest.message
                )
            )
        )

    }

    override fun getProductReviewers(
        productId: String,
        options: Map<String, String>,
        page: Int,
        itemsPerPage: Int
    ): Flowable<ProductReviewsResponse> {
//         return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getProductReviews(
            GraphRequest(
                getProductReviews(
                    productId,
                    page + 1,
                    itemsPerPage
                )
            )
        ).flatMap {
            GraphResponseConverter().convertToReviewsList(it)
        }
//        else service.getProductReviews(productId, options, page, itemsPerPage)
    }

    override fun getCities(
        lang_code: String,
        mGetCitiesRequest: GetCitiesRequest
    ): Flowable<List<CityModel>> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return getCities(mGetCitiesRequest.country_code)

//        graphService.getCities(GraphRequest(getOneLevelCitiesByCountry(mGetCitiesRequest.country_code)))
//            .flatMap {
////                if (isOneLevel(it, mGetCitiesRequest.country_code))
//                    getOneLevelCities(mGetCitiesRequest.country_code)
////                else
////                    GraphResponseConverter().convertToCities(it)
//            }
//        else service.getCities(lang_code, mGetCitiesRequest)
    }

    private fun isOneLevel(regionsResponse: GraphGetRegionsResponse, countryCode: String): Boolean {
        return regionsResponse.data.mGraphRegionsResponse.available_regions.size == 1 && regionsResponse.data.mGraphRegionsResponse.available_regions[0].code == countryCode
    }

    override fun getAreas(
        lang_code: String,
        mGetAreaRequest: GetAreaRequest
    ): Flowable<List<AreaModel>> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getAreasViaCountry(GraphRequest(getAreasByCity(mGetAreaRequest.city_id)))
            .flatMap {
                if(it?.data?.mCitiesModel?.citiesList?.isNullOrEmpty()){
                    getAreasForOneLevel(mGetAreaRequest?.country_code)
                }else {
                    GraphResponseConverter().convertToAreasResponse(it, mGetAreaRequest.city_code)
                }
            }
//        else service.getArea(lang_code, mGetAreaRequest)
    }

    fun getAreasForOneLevel(
        countryCode: String): Flowable<List<AreaModel>> {
         return graphService.getAreaForOneLevelViaCountry(GraphRequest(getAreasForOneLevelCountry(countryCode)))
            .flatMap {
                GraphResponseConverter().convertToAreasForOneLevelResponse(it)
            }
     }

    fun getCities(
        country_code: String
    ): Flowable<List<CityModel>> {
        return graphService.getCities(GraphRequest(getCitiesQuery(country_code)))
            .flatMap {
                var mGraphRegionResponse = it
                it?.data?.mGraphRegionsResponse?.available_regions?.let {
                    if (it.isNullOrEmpty().not() && it.size == 1 && it.get(0).code.equals(
                            country_code,
                            true
                        )
                    ) {
                        getOneLevelCities(country_code)
                    }else{
                        GraphResponseConverter().convertToCitiesList(mGraphRegionResponse)
                    }
                }

            }
    }

    fun getOneLevelCities(
        country_code: String
    ): Flowable<List<CityModel>> {
        return graphService.getCitiesFoeOneLevel(GraphRequest(getOneLevelCitiesByCountry(country_code)))
            .flatMap {
                        GraphResponseConverter().convertToOneLevelCitiesList(it)
            }
    }

    override fun addConcierge(conciergeRequestBody: ConciergeRequestBody): Flowable<ConciergeResponse> {
        //Stop this while get it from Magentoh
        return service.addConcierge(conciergeRequestBody)
    }


    override fun getCountries(languageCode: String): Flowable<ArrayList<CountryResponse>> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getCountries(GraphRequest(GET_ALL_COUNTRIES)).flatMap {
            GraphResponseConverter().convertToCountriesLists(it)
        }
//        } else {
//            service.getCountries(languageCode)
//        }
    }


    // Stoped this
    override fun getCurrencies(languageCode: String): Flowable<ArrayList<CurrencyResponse>> {
        return service.getCurrencies(languageCode)
    }


    //No one used this any more
    override fun getRemoteCartContent(
        userId: String,
        languageCode: String
    ): Flowable<CartContentResponse> {
        return service.getCartContent(userId, languageCode)
    }

    //No one used this any more
    override fun removeItemFromCart(cartRemoveRequestBody: CartRemoveRequestBody): Completable {
        return service.removeItemFromCart(cartRemoveRequestBody)
    }

    //No one used this any more
    override fun clearCartRemote(cartRemoveRequestBody: CartRemoveRequestBody): Completable {
        return service.clearCart(cartRemoveRequestBody)
    }

    //No one used this any more
    override fun getProductsByIds(
        productsIds: String?,
        languageCode: String
    ): Flowable<ProductsListResponse> {
        return service.getProductsByIds(productsIds, languageCode)
    }

    //No one used this any more
    override fun getCartConfig(
        languageCode: String,
        productIds: String
    ): Flowable<CartConfigResponse> {
        return service.getCartConfig(languageCode, productIds)
    }

    override fun getProductDetails(
        productId: String,
        languageCode: String,
        country_code: String
    ): Flowable<ProductDetailsResponse> {

//        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getProductDetails(GraphRequest(getProductDetailsQuery(productId)))
            .flatMap {
                GraphResponseConverter().convertToProductDetails(
                    it.data.products.items!![0],
                    country_code,
                    languageCode
                )
            }
//        else
//            return service.getProductById(productId, languageCode)
    }

    //No one used this any more
    override fun customerAlsoBought(
        productId: String,
        languageCode: String
    ): Flowable<CustomerFeaturedProductsResponse> {
        return service.getCustomerAlsoBoughtById(productId, languageCode)
    }

    override fun getSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Flowable<SuppliersResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getSuppliers(GraphRequest(GET_ALL_BRANDS)).flatMap {
            GraphResponseConverter().convertToSuppliersResponse(it)
        }
//        else service.getSupplier(page, itemPerPage, languageCode, sortedMap)
    }

    override fun getNewSuppliers(
        page: Int,
        itemPerPage: Int,
        languageCode: String,
        sortedMap: HashMap<String, String>
    ): Flowable<ArrayList<SupplierResponse>> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getSuppliers(GraphRequest(GET_ALL_BRANDS)).flatMap {
            GraphResponseConverter().convertToBrandsLists(it)
        }
//        else
//            service.getNewSupplier(page, itemPerPage, languageCode, sortedMap)
    }

    override fun addOrderToCart(addToCartRequest: AddItemToCartRequest): Flowable<AddItemToCartResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        var product_id = 0
        var product_id2 =0
        if (addToCartRequest?.product_id.isNullOrBlank().not() && addToCartRequest?.product_id2.isNullOrBlank().not() ) {
            product_id = addToCartRequest?.product_id?.toInt()!!
            product_id2= addToCartRequest?.product_id2?.toInt()
        }
        return if (addToCartRequest?.action.equals(Action.add_gift.toString(), true)) {
            graphService.addGiftItemToCart(
                GraphRequest(
                    addGiftToCartQuery(
                        addToCartRequest?.cartID!!,
                        product_id,
                        product_id2,
                        addToCartRequest?.sender_name!!,
                        addToCartRequest?.recipient_name!!,
                        addToCartRequest?.gift_message!!,
                        addToCartRequest?.cartProductID!!
                    )
                )
            )
                .flatMap {
                    GraphResponseConverter().convertToAddGiftToCart(it)
                }
        } else if (addToCartRequest?.action.equals(Action.update.toString())) {
            graphService.updateGiftItemFromCart(
                GraphRequest(
                    updateGiftToCartQuery(
                        addToCartRequest?.cartID!!,
                        product_id,
                        product_id2,
                        addToCartRequest?.sender_name!!,
                        addToCartRequest?.recipient_name!!,
                        addToCartRequest?.gift_message!!,
                        addToCartRequest?.cartProductID!!, addToCartRequest.old_wrap_id!!
                    )
                )
            )
                .flatMap {
                    GraphResponseConverter().convertToAddGiftToCart(it)
                }
        } else {
            return service.addOrderToCart(addToCartRequest)
        }
//        } else
//            return service.addOrderToCart(addToCartRequest)
    }

    override fun deleteOrderFromCart(mDeleteItemFromCartRequest: DeleteItemFromCartRequest): Flowable<AddItemToCartResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return if (mDeleteItemFromCartRequest?.localAction.equals(Action.RemoveGift.toString())) {
            graphService.removeGiftItemFromCart(
                GraphRequest(
                    removeGiftToCartQuery(
                        customer_cart = mDeleteItemFromCartRequest?.cartID!!,
                        cart_item_id = mDeleteItemFromCartRequest?.productGraphID,
                        wrap_id = mDeleteItemFromCartRequest?.product_id!!.toInt(),
                        //card_id=mDeleteItemFromCartRequest?.product_id2.toInt(),
                        existing_wrap_id = mDeleteItemFromCartRequest?.existsWrapId!!
                    )
                )
            )
                .flatMap {
                    GraphResponseConverter().convertToAddGiftToCart(it)
                }
        } else {
            graphService.removeItemFromCart(
                GraphRequest(
                    getRemoveItemFromCartQuery(
                        cartId = mDeleteItemFromCartRequest?.cartID!!,
                        cart_item_uid = mDeleteItemFromCartRequest?.productUID.toString()
                    )
                )
            )
                .flatMap {
                    GraphResponseConverter().convertToRemoveItemFromCart(it)
                }
        }
//        } else
//            return service.deleteOrderFromCart(mDeleteItemFromCartRequest)
    }

    override fun updateOrderInCart(mUpdateItemInCartRequest: UpdateItemInCartRequest): Flowable<AddItemToCartResponse> {
        return graphService.removeItemFromCart(
            GraphRequest(
                getUpdateItemFromCartQuery(
                    cartId = mUpdateItemInCartRequest?.cartID!!,
                    cart_item_uid = mUpdateItemInCartRequest?.productUID.toString(),
                    count = mUpdateItemInCartRequest?.amount!!
                )
            )
        )
            .flatMap {
                GraphResponseConverter().convertToRemoveItemFromCart(it)
            }
//        }
//        else
//            return service.updateOrderInCart(mUpdateItemInCartRequest)
    }

    override fun getOrdersFromCart(
        languageCode: String,
        mGetOrdersFromCartRequest: GetOrdersFromCartRequest
    ): Flowable<GetOrdersFromCartResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getCart(GraphRequest(getCartQuery(mGetOrdersFromCartRequest?.cartId!!)))
            .flatMap {
                GraphResponseConverter().convertToCartResponse(it)
            }
//        } else {
//            service.getOrdersFromCart(languageCode, mGetOrdersFromCartRequest)
//        }
    }

    override fun checkoutReview(
        languageCode: String,
        mReviewCartRequest: ReviewCartRequest
    ): Flowable<ReviewCartResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getCheckout(GraphRequest(getCheckoutQuery(mReviewCartRequest.cartId)))
            .flatMap {
                GraphResponseConverter().convertToCheckoutResponse(it)
            }
//        } else {
//            service.checkoutReview(languageCode, mReviewCartRequest)
//        }
    }

    override fun sendPaymentMethod(
        languageCode: String,
        mPaymentMethodRequest: PaymentMethodRequest
    ): Flowable<ReviewCartResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS && mPaymentMethodRequest?.cartID.isNullOrBlank()
//                .not() && mPaymentMethodRequest?.code.isNullOrBlank().not()
//        ) {
        return graphService.updatePaymentMethod(
            GraphRequest(
                setPaymentMethodQuery(
                    mPaymentMethodRequest.cartID!!,
                    mPaymentMethodRequest.code!!
                )
            )
        )
            .flatMap {
                GraphResponseConverter().convertPaymentMethodResponseToCheckoutResponse(it)
            }
//        } else {
//            service.sendPaymentMethod(languageCode, mPaymentMethodRequest)
//        }


    }

    override fun applyCoupon(
        languageCode: String,
        mAddCouponRequest: AddCouponRequest
    ): Flowable<ReviewCartResponse> {

//        return if (ENABLE_GRAPH_QUERIES_CALLS && mAddCouponRequest?.cartId.isNullOrBlank().not()) {
        return graphService.applyCoupon(
            GraphRequest(
                applyCouponQuery(
                    mAddCouponRequest?.cartId!!,
                    mAddCouponRequest?.coupon_code!!
                )
            )
        )
            .flatMap {
                GraphResponseConverter().convertApplyCouponResponseToCheckoutResponse(it)
            }
//        } else {
//            service.applyCoupon(languageCode, mAddCouponRequest)
//        }
    }

    override fun removeCoupon(
        languageCode: String,
        mRemoveCouponRequest: RemoveCouponRequest
    ): Flowable<ReviewCartResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS && mRemoveCouponRequest.cartId.isBlank()
//                .not()
//        ) {
        return graphService.removeCoupon(
            GraphRequest(
                removeCouponQuery(
                    mRemoveCouponRequest.cartId
                )
            )
        )
            .flatMap {
                GraphResponseConverter().convertRemoveCouponResponseToCheckoutResponse(it)
            }
//        } else {
//            service.removeCoupon(languageCode, mRemoveCouponRequest)
//        }
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
//        return if (ENABLE_GRAPH_QUERIES_CALLS && cartId.isNullOrBlank().not()) {
        return graphService.placeOrder(
            GraphRequest(
                placeOrderQuery(
                    cartId
                )
            )
        ).flatMap {
            GraphResponseConverter().convertToPlaceOrderResponse(it)
        }
//        } else {
//            return service.createOrder(
//                user_id,
//                languageCode,
//                country_code,
//                action,
//                device_id,
//                is_gift,
//                gift_sender_name,
//                gift_receiver_name,
//                gift_msg
//            )
//        }
    }


    override fun getOrdersCountInCart(mGetOrdersCountInCartRequest: GetOrdersCountInCartRequest): Flowable<GetOrdersCountInCartResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getCart(GraphRequest(getCartQuery(mGetOrdersCountInCartRequest?.cartId!!)))
            .flatMap {
                GraphResponseConverter().convertToCartCountResponse(it)
            }
//        } else {
//            return service.getOrdersCountInCart(mGetOrdersCountInCartRequest)
//        }
    }


    // Still not work with magentoh
    override fun editProfile(editProfileRequestBody: ProfileActionRequest): Flowable<EditUserProfileResponse> {
        return service.editProfile(editProfileRequestBody)
    }

    override fun getUserProfile(userId: String): Flowable<GetUserProfileResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getUserProfile(GraphRequest(userProfileQuery())).flatMap {
            GraphResponseConverter().convertToGetUserProfileResponse(it)
        }
//        } else {
//            return service.getUserProfile(userId)
//        }
    }

    override fun getCategories2(categoryRequest: CategoryRequest): Flowable<ArrayList<CategoryItem>> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getMainCategories(GraphRequest(GET_ALL_CATEGORIES2)).flatMap {
            GraphResponseConverter().convertToCategoriesLists(it)
        }
//        } else {
//            return service.getCategories2(categoryRequest)
//        }
    }


    // No one use it
    override fun getCartContent(
        userId: String,
        languageCode: String
    ): Flowable<CartContentResponse> {
        return service.getCartContent(userId, languageCode)
    }


    override fun login(loginRequestBody: LoginRequestBody): Flowable<AuthenticationResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getToken(GraphRequest(GET_TOKEN_QUERY(loginRequestBody))).flatMap {
            GraphResponseConverter().convertToTokenResponse(it, loginRequestBody)
        }
//        } else {
//            return service.login(loginRequestBody)
//        }


    }

    override fun getProductsForCategory(
        options: Map<String, String>,
        page: Int,
        itemPerPage: Int
    ): Flowable<ProductsListResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return if (options[ACTION] == ALSO_BOUGHT_ACTION) {
            graphService.getAlsoBoughtProducts(
                GraphRequest(
                    getUsersAlsoBoughtProducts(
                        options[Constants.PRODUCT_ID] ?: ""
                    )
                )
            )
                .flatMap {
                    GraphResponseConverter().convertToAlsoBoughtProductsLists(it)
                }
        } else {
            graphService.getCategoryProducts(
                GraphRequest(
                    getProductCategoryApi(
                        options[LIST_GRAPH_ACTION] ?: "",
                        options[LIST_GRAPH_ACTION_ID] ?: "",
                        page + 1,
                        itemPerPage,
                        options[FEATURES_HASH] ?: "",
                        options[PRICE_FROM],
                        options[PRICE_TO],
                        options[sort_by],
                        options[sort_order]
                    )
                )
            )
                .flatMap {
                    GraphResponseConverter().convertToProductsLists(it)
                }
        }
//        } else
//            service.getProductsForCategory(options, page, itemPerPage)
    }

    override fun getProductGift(countryCode:String,cityCode:String
    ): Flowable<ProductsListResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getGiftItems(GraphRequest(getGiftItems(countryCode,cityCode  )))
            .flatMap {
                GraphResponseConverter().convertToGiftItemsList(it)
            }
//        } else {
//            return service.getProductGift()
//        }
    }

    /// recommended products
    // Stop it for csCart
    override fun getProductsForSearch(
        action: String,
        lang_code: String
    ): Flowable<ProductsListResponse> {
        return service.getProductsForSearch(action, lang_code)

    }

    override fun addNotifyMeAction(productActionRequest: ProductActionRequest): Flowable<NormalResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.addNotifyMeAction(
            GraphRequest(
                getNotifyMeProductQuery(
                    productActionRequest.email ?: "",
                    productActionRequest.product_id ?: ""
                )
            )
        ).flatMap {
            GraphResponseConverter().convertToNotifyMeResponse(it)
        }
//        else
//            service.addNotifyMeForProducts(productActionRequest)
    }


    override fun getSubCategories(categoryRequest: CategoryRequest): Flowable<ArrayList<SubCategoriesResponse>> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getSubCategories(GraphRequest(getSubCategory(categoryRequest.category_id)))
            .flatMap {
                GraphResponseConverter().convertToSubCategoriesLists(it)
            }
//        } else {
//            return service.getSubCategories(categoryRequest)
//        }

    }


    //No one use it
    override fun getGeneratedCode(token: String): Flowable<DeviceTokenResponse> {
        return service.generateCode(token)
    }

    override fun forgetPassword(
        email: String,
        languageCode: String
    ): Flowable<NormalResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.forgotPassword(GraphRequest(getForgotPasswordQuery(email))).flatMap {
            GraphResponseConverter().convertToForgotPasswordResponse(it)
        }
//        } else {
//            return service.forgetPassword(email, languageCode)
//        }
    }

    override fun register(
        registerRequestBody: RegisterRequestBody,
        languageCode: String
    ): Flowable<AuthenticationResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.register(GraphRequest(GET_REGISTER_QUERY(registerRequestBody)))
            .flatMap {
                GraphResponseConverter().convertToRegisterResponse(it)
            }
//        } else {
//            return service.register(registerRequestBody, languageCode)
//        }
    }


    // No one use it
    override fun updateProductAmountRemote(
        productId: String,
        updateProductAmountRequest: UpdateProductAmountRequest
    ): Flowable<AddToCartResponse> {
        return service.updateProductAmountRemote(productId, updateProductAmountRequest)
    }

    // There is no usage
    override fun applyCoupon(applyCouponRequest: ApplyCouponRequest): Flowable<CouponResponse> {
        return service.applyCoupon(applyCouponRequest)
    }

    override fun setFirebaseToken(userTokenRequestBody: UserTokenRequestBody): Flowable<TokenResponse> {
        //        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.saveFirebaseToken(
            GraphRequest(
                GraphQlQuires.getSentFirebaseToken(
                    userTokenRequestBody?.token.toString()
                )
            )
        ).flatMap {
            GraphResponseConverter().convertToFirebaseTokenResponse(
                it
            )
        }
//        } else {
//            return service.setFirebaseUserToken(userTokenRequestBody)
//        }

    }

    override fun saveFirebaseToken(userTokenRequestBody: SaveFirebaseTokenRequestBody): Flowable<TokenResponse> {
        //Ahmed Done Check DOC
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.saveFirebaseToken(
            GraphRequest(
                GraphQlQuires.getSentFirebaseToken(
                    userTokenRequestBody?.token.toString()
                )
            )
        ).flatMap {
            GraphResponseConverter().convertToFirebaseTokenResponse(
                it
            )
        }
//        } else {
//            return service.saveFirebaseToken(userTokenRequestBody)
//        }
    }


    //No one use it
    override fun applyPromotion(promotionRequest: PromotionRequest): Flowable<List<PromotionValue>> {
        //Ahmed Done, Check DOC
        return service.applyPromotion(promotionRequest)
    }

    override fun layoutBlocks(languageCode: String): Flowable<HomeBlocksResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getLayoutBlocks(GraphRequest(GET_GRAPH_BLOCKS)).flatMap {
            GraphResponseConverter().convertToMainBlocks(it)
        }
//        else
//            service.layoutBlocks(languageCode)
    }

    override fun getSpecificProducts(
        country_code: String,
        lang_code: String,
        action: String,
        items_per_page: Int,
        page: Int,
        pid: String
    ): Flowable<ProductsListResponse> {

//        return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getSpecificProducts(
            GraphRequest(GraphQlQuires.getSpecificProducts(pid))
        ).flatMap {
            GraphResponseConverter().convertToProductsLists(it)
        }
//        else
//            service.getSpecificProducts(
//                country_code,
//                lang_code,
//                action,
//                items_per_page,
//                page,
//                pid
//            )
    }


    // this API stoped
    override fun getOptionsForProduct(
        lang_code: String,
        productId: String
    ): Flowable<ProductOptionsResponse> {
        return service.getOptionsForProduct(lang_code, productId)
    }

    // No one use it
    override fun getSelectAddress(AddressRequest: SelectedGuestAddressRequest): Flowable<SelectAddressResponse> {
        return service.selectAddress(AddressRequest)
    }

    override fun blockLayout(blockId: String, languageCode: String): Flowable<List<Banner>> {
//         return if (ENABLE_GRAPH_QUERIES_CALLS)
        return graphService.getBannerById(
            GraphRequest(
                getBannerById(if (blockId.trim().isNullOrEmpty()) "0" else blockId)
            )
        ).flatMap {
            GraphResponseConverter().convertToBannerList(it)
        }
//        else
//            service.blockLayout(blockId, languageCode)
    }

    // no one use it
    override fun checkCartAvailability(cartActionRequest: CartActionRequest): Flowable<CartActionResponse> {
        return service.checkCart(cartActionRequest)
    }

    // Stop it for csCart
    override fun extrctDeepLinkUrl(mExtractDeepLinkRequest: ExtractDeepLinkRequest): Flowable<ExtractDeepLinkResponse> {
        return service.extrctDeepLinkUrl(mExtractDeepLinkRequest)
    }


    //Stop it for csCart
    override fun getPromotion(

        mPromotionRequestModel: PromotionRequestModel

    ): Flowable<InAppMessageModel> {
        return service.getPromotion(mPromotionRequestModel)

    }

    override fun socialMediaLogin(
        lang_code: String,
        mSocialLoginRequestBody: SocialLoginRequestBody
    ): Flowable<AuthenticationResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.loginWithSocialMedia(
            GraphRequest(
                getLoginWithSocialMedia(mSocialLoginRequestBody)
            )
        ).flatMap {
            GraphResponseConverter().convertToTokenForSocialMediaResponse(
                it,
                mSocialLoginRequestBody
            )
        }
//        }else service.socialMediaLogin(lang_code, mSocialLoginRequestBody)
    }

    override fun getMyWallet(): Flowable<WalletResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getWallet(
            GraphRequest(
                getWalletQuery()
            )
        )
            .flatMap {
                GraphResponseConverter().convertWalletGraphResponseToWalletResponse(it)
            }
//        } else {
//            return walletService.getMyWallet()
//        }
    }

    override fun getAllTransactions(
    ): Flowable<TransactionsHistoryResponse> {

//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.getWalletTransactions(
            GraphRequest(
                getWalletTransactionsQuery()
            )
        )
            .flatMap {
                GraphResponseConverter().convertWalletTransactionGraphResponseToWalletResponse(
                    it
                )
            }
//        } else {
//            return walletService.getAllTransactions()
//        }
    }

    //Stop it for csCart
    override fun getUserToken(
        osused: String,
        session: String,
        devid: String
    ): Flowable<UserTokenResponse> {
        return userService.getUserToken(osused, session, devid)
    }

    // Check with wael
    override fun addRedeemCode(
        mRedeemCodeRequest: RedeemCodeRequest
    ): Flowable<RedeemCodeResponse> {
        return walletService.addRedeemCode(mRedeemCodeRequest)
    }

    // Check with wael
    override fun inviteFriend(
        mInviteFriendRequest: InviteFriendRequest
    ): Flowable<InviteFriendResponse> {
        return walletService.inviteFriend(mInviteFriendRequest)
    }

    // Check with wael
    override fun checkEarn(
        mInviteFriendRequest: InviteFriendRequest
    ): Flowable<InviteFriendResponse> {
        return walletService.checkEarn(mInviteFriendRequest)
    }

    // Check with wael
    override fun checkCashBack(orderId: String): Flowable<CheckCashBackResponse> {
        return walletService.checkCashBack(orderId)
    }

    //Stop it
    override fun updateUserTokenWithCountryOrLanguage(
        country_code: String, lang_code: String
    ): Flowable<UserUpdateTokenResponse> {
        return userService.updateUserTokenWithCountryOrLanguage(
            country_code,
            lang_code
        )
    }

    // Check with wael
    override fun logout(): Flowable<LogoutResponse> {
        return userService.logout()
    }

    override fun changePassword(editProfileRequestBody: ChangePasswordRequest): Flowable<EditUserProfileResponse> {
//        return if (ENABLE_GRAPH_QUERIES_CALLS) {
        return graphService.changePassword(
            GraphRequest(
                getChangePasswordQuery(
                    editProfileRequestBody?.old_password!!,
                    editProfileRequestBody?.new_password!!
                )
            )
        )
            .flatMap {
                GraphResponseConverter().convertChangePasswordGraphResponseToEditProfileResponse(
                    it
                )
            }
//        } else {
//            return service.changePassword(editProfileRequestBody)
//        }
    }

    //Stop it
    override fun getCategoryBanners(
        lang_code: String,
        category_id: String
    ): Flowable<CategoryBannerResponse> {
        return service.getCategoryBanners(lang_code, category_id)
    }

    override fun createCart(): Flowable<CreateCartResponse> {
        return graphService.createCart(GraphRequest(GraphQlQuires.createCartForLoggedInUser()))
    }

    override fun createGuestCart(): Flowable<CreateGuestCartResponse> {
        return graphService.createGuestCart(GraphRequest(createCartForGuestUser()))
    }

    override fun checkTokenValidation(token: String): Flowable<CheckTokenValidationResponse> {
        return graphService.checkTokenExpiration(GraphRequest(checkTokenExpiration(token)))
    }

    override fun restoreCart(cartId: String?): Flowable<RestoreCartResponse> {
        return graphService.restoreCart(GraphRequest(getRestoreCartQuery(cartId!!)))
    }

    override fun mergeCarts(
        customerCartId: String?,
        guestCartId: String?
    ): Flowable<MergeCartsResponse> {
        return graphService.mergeCarts(
            GraphRequest(
                getMergeCartsQuery(
                    customerCartId!!,
                    guestCartId!!
                )
            )
        )
    }

    override fun getCountryCurrency(
    ): Flowable<CountryCurrenceResponse> {
        return graphService.getCountryCurrency(
            GraphRequest(
                getCountryCurrencyQuery(
                )
            )
        )
    }

    override fun AddProductToGraphCart(mAddItemToCartGraphRequest: AddItemToCartGraphRequest?): Flowable<AddProductToCartResponse> {
        return if (mAddItemToCartGraphRequest?.selectedOptions.isNullOrEmpty()) {
            graphService.AddProductToGraphCart(
                GraphRequest(
                    addProductToCart(
                        mAddItemToCartGraphRequest!!
                    )
                )
            )
        } else {
            addProductWithOptions(mAddItemToCartGraphRequest!!)
        }
    }

    fun addProductWithOptions(mAddItemToCartGraphRequest: AddItemToCartGraphRequest): Flowable<AddProductToCartResponse> {
        return graphService.addProductWithOptionsToGraphCart(
            GraphRequest(
                addProductWithOptionToCart(
                    mAddItemToCartGraphRequest
                )
            )
        ).flatMap {
            GraphResponseConverter().convertToAddProductToCartResponse(
                it
            )
        }
    }

}

