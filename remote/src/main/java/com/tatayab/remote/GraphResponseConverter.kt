package com.tatayab.remote

import com.google.gson.Gson
import com.tatayab.model.*
import com.tatayab.model.filter.FilterMapValue
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.filter.Prices
import com.tatayab.model.filter.Variant
import com.tatayab.model.requests.AddressRequest
import com.tatayab.model.requests.LoginRequestBody
import com.tatayab.model.requests.SocialLoginRequestBody
import com.tatayab.model.responses.*
import com.tatayab.model.responses.UserProfile
import com.tatayab.model.responses.graph_responses.*
import com.tatayab.remote.util.Constants.Companion.GIFT_COST_KEY
import com.tatayab.remote.util.Constants.Companion.GRAPH_IN_STOCK
import com.tatayab.remote.util.Constants.Companion.SHIPPING_COST_KEY
import com.tatayab.remote.util.Constants.Companion.SUB_TOTAL_KEY
 import com.tatayab.remote.util.Constants.Companion.TOTAL_PRICE_KEY
import io.reactivex.Flowable
import org.json.JSONArray
import org.reactivestreams.Publisher


class GraphResponseConverter {


    fun convertToCountriesLists(countries: GraphCountriesResponse): Flowable<ArrayList<CountryResponse>> {
        return Flowable.fromArray(countries.mGraphCountryList.mCountriesList?.map {
            CountryResponse(
                name = it.full_name_locale,
                code = it.two_letter_abbreviation,
                flag = it.flag,
                phone_code = it.phone_code,
                phone_start = it.phone_start_nums,
                phone_lenght = it.phone_length,
                show_custom_message = it?.show_custom_message.isNullOrBlank()
                    .not() && it?.show_custom_message == "1",
                location = it?.location
            )
        } as ArrayList<CountryResponse>
        )
    }

    fun convertToCategoriesLists(countries: GraphMainCategoriesResponse): Flowable<ArrayList<CategoryItem>> {
        return if(countries?.errorsListModel.isNullOrEmpty()) {
            Flowable.fromArray(countries.data.categoryListItem?.map {
                CategoryItem(
                    name = it.name.toString(),
                    image = it.image,
                    category_uid = it.uid.toString(),
                    category_id = it.id.toString()
                )
            } as ArrayList<CategoryItem>
            )
        }else{
            Flowable.fromArray(ArrayList<CategoryItem>())
        }
    }

    fun convertToProductsLists(products: GraphCategoryProductsResponse): Flowable<ProductsListResponse> {
        return Flowable.just(ProductsListResponse(
            total_rows = products.data.products.total_count,
            products = products.data.products.items?.map {
                convertToProductX(it)
            } as List<ProductX>
        ))
    }

    fun convertToAlsoBoughtProductsLists(products: GraphAlsoBoughtProductsResponse): Flowable<ProductsListResponse> {
        return Flowable.just(ProductsListResponse(
            products = products.data.amMostviewedGroups.products[0].items?.map {
                convertToProductX(it)
            } as List<ProductX>
        ))
    }


    private fun convertToProductX(it: ProductData): ProductX {
        return ProductX(
            title = it.name, image = it.small_image.url,
            can_buy = if (it.stock_status == GRAPH_IN_STOCK) 1 else 0,
            supplier_id = it.manufacturer,
            price = it.price_range.minimum_price.final_price.value,
            old_price = it.price_range.minimum_price.regular_price.value,
            currency = it.price_range.minimum_price.final_price.currency,
            currencyCode = it.price_range.minimum_price.final_price.currency,
            discount_perc = it.price_range.minimum_price.discount.percent_off,
            supplier_name = getSupplierName(it.dynamicAttributes),
            product_id = it.sku,
            source = it?.source,
            uid = it?.id.toString(),
            has_options = if (it.options.isNullOrEmpty()) 0 else 1,
            percent_off = it?.price_range?.minimum_price?.discount?.percent_off
        )
    }

    fun convertToBrandsLists(brands: GraphSuppliersResponse): Flowable<ArrayList<SupplierResponse>> {
        return Flowable.fromArray(brands.mGraphCountryListGrapg.brandsList?.brands?.map {
            SupplierResponse(name = it.name, supplierId = it.id, image = it.image)
        } as ArrayList<SupplierResponse>
        )
    }


    fun convertToSubCategoriesLists(categories: GraphSubCategoriesResponse): Flowable<ArrayList<SubCategoriesResponse>> {

        val subCategories: ArrayList<SubCategoriesResponse> = arrayListOf()
        val subCategoriesBanners: ArrayList<ContentModel> = arrayListOf()
//        categories.data.categories.items?.get(0)?.mp_promo_banners?.items?.map {
//            subCategoriesBanners.addAll(
//                if (!it.banner_image.isNullOrEmpty()) parseItemsToBanners(
//                    it.banner_image,
//                    false
//                ) else parseItemsToBanners(it.slider_images, true)
//            )
//        }
        //// add banners as first item in subCategories

        categories.data.categories.items?.map {
            it.mp_promo_banners.items.map { banner ->
                subCategoriesBanners.addAll(
                    if (!banner.banner_image.isNullOrEmpty()) parseItemsToBanners(
                        banner.banner_image,
                        false
                    ) else parseItemsToBanners(banner.slider_images, true)
                )
            }

            subCategories.add(
                SubCategoriesResponse(
                    name = it.name,
                    image_path = it.image,
                    category_id = it.id,
                    category_uid = it.uid,
                    childs = getChild(it?.childrenList),
                    hasSubCat = getChild(it?.childrenList).isNullOrEmpty().not()
                )
            )
        }

//        subCategories.add(
//            0,
//            SubCategoriesResponse(
//                mCategoryBannerResponse = SliderBannersModel(
//                    "",
//                    subCategoriesBanners
//                ),
//                name = "",
//                category_id = "",
//                isBanner = true,
//                childs = arrayListOf()
//            )
//        )

        return Flowable.fromArray(subCategories)
    }

    private fun getChild(childrenList: List<GraphSubCategoriesResponse.GraphSubCategoryItemResponse>): java.util.ArrayList<Child> {
        var childList = ArrayList<Child>()
        try {
            if(childrenList.isNullOrEmpty().not()){
                childrenList.map {
                    childList.add(
                        Child(
                            name = it.name,
                            image_path = it.image,
                            category_id = it.id,
                            category_uid = it.uid
                        )
                    )
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }

        return childList
    }

    private fun parseItemsToBanners(data: String?, isSlider: Boolean): ArrayList<ContentModel> {
        return if (isSlider) getSliderAsSubCategory(data ?: "")
        else
            arrayListOf(ContentModel(banner = data))
    }

    fun convertToProductDetails(
        product: ProductData,
        country_code: String,
        languageCode: String
    ): Flowable<ProductDetailsResponse>? {
        return Flowable.just(
            ProductDetailsResponse(
                source = product?.getProductSource(product),
                supplierId = product.manufacturer,
                fullDescription = product.description.html,
                amount = -1,
                hasOptions = false,
                images = getImagesList(product.media_gallery, product.image),
                is_In_WishList = false,
                isFreeDelivery = "N",
                listPrice = product.price_range.minimum_price.regular_price.value.toString(),
                mainPair = MainPair(detailed = Detailed(image_path = product.image.url)),
                maxQty = -1,
                minQty = 1,
                outOfStockActions = if (product.stock_status == GRAPH_IN_STOCK) "B" else "N",
                price = product.price_range.minimum_price.final_price.value.toString(),
                currency = product.price_range.minimum_price.final_price.currency,
                product = product.name,
                product_specs = product.getSpecifications(product.dynamicAttributes),
                productId = product.sku,
                productSku = product.sku,
                productLink = getProductLink(
                    country_code,
                    languageCode,
                    product?.url_key,
                    product?.url_suffix,
                    product?.sku!!,
                    product?.name!!
                ),
                productOptions = product.getProductOptions(product.options),
                warehouse = getWareHouse(product),
                supplierName = getSupplierName(product.dynamicAttributes),
                percent_off = product?.price_range?.minimum_price?.discount?.percent_off
            )
        )
    }

    private fun getImagesList(
        mediaGallery: List<GraphCategoryProductsResponse.Image>,
        image: GraphCategoryProductsResponse.Image
    ): List<String> {
        var imagesList  = ArrayList<String>()
        try {
            mediaGallery?.let {
                it?.map {
                if(it?.url.isNullOrBlank().not())
                    imagesList.add(it?.url)
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }

        if(imagesList.isNullOrEmpty() && image?.url.isNullOrBlank().not()){
            imagesList.add(image.url)
        }

        return imagesList
    }

    private fun getProductLink(
        country_code: String? = "",
        languageCode: String? = "",
        urlKey: String? = "",
        urlSuffix: String? = "",
        sku: String,
        name: String
    ): String? {
        var productLink = "https://tatayab.com/"
        var productMobileLink = "https://tatayab.com/products/"
        try {
            if (country_code.isNullOrBlank().not() && urlKey.isNullOrBlank()
                    .not() && urlSuffix.isNullOrBlank().not()
            ) {
                //tatayab.com/[store-code]/[url-key]/url_suffix]    https://tatayab.com/kw-ar/
                productLink = productLink.plus(country_code!!.toLowerCase()).plus("-")
                    .plus(if (languageCode.isNullOrBlank()) "en" else languageCode.toLowerCase())
                    .plus("/").plus(urlKey).plus(urlSuffix)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        try {
            if (sku.isNullOrBlank().not() && name.isNullOrBlank()
                    .not()
            ) {
                //tatayab.com/[store-code]/[url-key]/url_suffix]    https://tatayab.com/kw-ar/
                productMobileLink = productMobileLink.plus(sku).plus("/").plus(name)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        var lastLink =
            productMobileLink.plus(",\nYou can see it on website via this link ").plus(productLink)
        println("TAYAB/productLink: " + lastLink)
        return lastLink
    }

    private fun getWareHouse(mProductData: ProductData): ProductDetailsResponse.WareHouseModel? {
        if (mProductData == null || mProductData?.shipping_details?.isNullOrEmpty() == true) return null
        var mWareHouseModel: ProductDetailsResponse.WareHouseModel? = null
        var productSource: String = mProductData?.source!!
        mProductData?.shipping_details?.map {
            if (productSource.equals(it?.source_code, true)) {
                mWareHouseModel = ProductDetailsResponse.WareHouseModel(
                    country = it.shipping_title,
                    deli_from = it.delivery_from_str,
                    deli_to = it.delivery_to_str,
                    country_code = it?.source_code!!
                )
            }
        }
        if (mWareHouseModel == null && mProductData?.shipping_details.isNullOrEmpty().not()) {
            var model = mProductData?.shipping_details?.get(0)!!
            mWareHouseModel = ProductDetailsResponse.WareHouseModel(
                country = model.shipping_title,
                deli_from = model.delivery_from_str,
                deli_to = model.delivery_to_str
            )
        }

        return mWareHouseModel
    }

    fun convertToRegisterResponse(mRegisterationResponse: RegisterationResponse): Flowable<AuthenticationResponse> {
        return Flowable.just(
            if (mRegisterationResponse?.errorsListModel.isNullOrEmpty()) {
                mRegisterationResponse?.data?.mCreateCustomerModel?.mCustomerModel?.let {
                    AuthenticationResponse(
                        email = it?.email,
                        firstname = it?.firstname,
                        phone = it?.phoneNumber!!,
                        user_id = 1
                    )
                }
            } else {
                AuthenticationResponse(message = mRegisterationResponse.errorsListModel?.get(0)?.message.toString())
            }

        )
    }

    fun convertToGetUserProfileResponse(it: UserProfileResponse): Flowable<GetUserProfileResponse>? {
        return Flowable.just(
            if (it?.errorsListModel.isNullOrEmpty()) {
                it?.customerDataModel?.customerModel?.let {
                    val mUserProfile = UserProfile(
                        firstName = it?.firstname.toString(),
                        lastName = it?.lastname.toString(),
                        email = it?.email.toString(),
                        phone = it?.phone_number.toString(),
                        gender = it?.gender,
                        phone_country_code = ""
                    )
                    GetUserProfileResponse(userProfile = mUserProfile, status = 1, msg = "")
                }
            } else {
                GetUserProfileResponse(
                    msg = it?.errorsListModel?.get(0)?.message.toString(),
                    status = 0,
                    userProfile = null
                )
            }
        )
    }

    fun convertToTokenForSocialMediaResponse(
        mGetTokenResponse: GetTokenForSocialMediaResponse,
        loginRequestBody: SocialLoginRequestBody
    ): Flowable<AuthenticationResponse> {
        return Flowable.just(
            if (mGetTokenResponse?.errorsListModel.isNullOrEmpty()) {
                mGetTokenResponse?.data?.generateCustomerToken?.let {
                    AuthenticationResponse(
                        token = it?.token!!,
                        email = loginRequestBody.email,
                        firstname = loginRequestBody?.name
                    )
                }
            } else {
                AuthenticationResponse(message = mGetTokenResponse?.errorsListModel?.get(0)?.message.toString())
            }
        )
    }

    fun convertToTokenResponse(
        mGetTokenResponse: GetTokenResponse,
        loginRequestBody: LoginRequestBody
    ): Flowable<AuthenticationResponse> {
        return Flowable.just(
            if (mGetTokenResponse?.errorsListModel.isNullOrEmpty()) {
                mGetTokenResponse?.data?.generateCustomerToken?.let {
                    AuthenticationResponse(token = it?.token!!, email = loginRequestBody.email)
                }
            } else {
                AuthenticationResponse(message = mGetTokenResponse?.errorsListModel?.get(0)?.message.toString())
            }
        )
    }

    fun convertToMainBlocks(graphBlocks: GetLayoutBlocks): Flowable<HomeBlocksResponse>? {
        return Flowable.just(
            if (graphBlocks.errorsListModel.isNullOrEmpty()) {
                HomeBlocksResponse(graphBlocks.blocksData.mobileLayoutGraphql.graphBlocks.map {
                    Section(
                        blockId = it.block_id,
                        name = it.title,
                        subTitle = it.subtitle,
                        obIds = it.ob_ids,
                        template = it.template,
                        type = it.type,
                        catId = if (it.catId == null) 0 else try {
                            it.catId
                        } catch (ex: java.lang.Exception) {
                            0
                        }!!
                    )
                }
                )
            } else {
                HomeBlocksResponse()
            }
        )
    }


    fun convertToCartResponse(mCartItemsResponse: CartItemsResponse): Publisher<out GetOrdersFromCartResponse>? {
        return Flowable.just(
            if (mCartItemsResponse.errorsListModel.isNullOrEmpty()) {
                var senderName = ""
                var receiverName = ""
                var giftMSG = ""
                var giftItemID = 0
                var currentSelectedWrapId = 0
                mCartItemsResponse.dataModel.cartModel?.wrappingItemsModel?.let {
                    it?.map {
                        senderName = it?.sender_name.toString()
                        receiverName = it?.receiver_name.toString()
                        giftMSG = it?.gift_message.toString()
                        giftItemID = it?.wrap_id!!
                        currentSelectedWrapId = it?.entity_id!!
                    }
                }
                mCartItemsResponse.dataModel.cartModel.itemsModelList.let {
                    val products: ArrayList<CartOrderResponse> = ArrayList()
                    it?.map {
                        val item = it.productModel
                        val mCartOrderResponse = CartOrderResponse(
                            product_id = item?.sku,
                            title = item?.name,
                            supplier_id = it?.uid,
                            price = item?.priceRangeModel?.minimumPriceModel?.finalPriceModel?.value,
                            original_price = item?.priceRangeModel?.minimumPriceModel?.regularPriceModel?.value,
                            amount = it?.quantity,
                            image = item?.smallImageModel?.url
                        )
                        mCartOrderResponse.productGraphID = it?.id

                        if(it?.productModel?.source.isNullOrBlank().not()) {
                            var source = it?.productModel?.source
                            var whList = source?.split("-")
                            if(!whList.isNullOrEmpty() && whList.size == 2){
                                mCartOrderResponse.countryId  = whList.get(0)
                            }
                        }
                        mCartOrderResponse.mShippingDetailsModel = if(it?.productModel?.shippingDetailsModel.isNullOrEmpty()) null else it?.productModel?.shippingDetailsModel.get(0)
                        mCartOrderResponse.currencyId =
                            it?.productModel?.priceRangeModel?.minimumPriceModel?.finalPriceModel?.currency.toString()
                        mCartOrderResponse.productUID = it?.uid.toString()
                        products.add(mCartOrderResponse)
                    }

                    GetOrdersFromCartResponse(
                        totalCartProducts = if (it.isNullOrEmpty() == true) 0 else it?.size!!,
                        products = products,
                        sender_name = senderName,
                        recipient_name = receiverName,
                        gift_message = giftMSG,
                        giftItemId = giftItemID,
                        currentSelectedWrapId = currentSelectedWrapId
                    )
                }
            } else if (!mCartItemsResponse.errorsListModel.isNullOrEmpty() && mCartItemsResponse?.dataModel?.cartModel != null) {
                var senderName = ""
                var receiverName = ""
                var giftMSG = ""
                var giftItemID = 0
                var currentSelectedWrapId = 0
                mCartItemsResponse.dataModel.cartModel?.wrappingItemsModel?.let {
                    it?.map {
                        senderName = it?.sender_name.toString()
                        receiverName = it?.receiver_name.toString()
                        giftMSG = it?.gift_message.toString()
                        giftItemID = it?.wrap_id!!
                        currentSelectedWrapId = it?.entity_id!!
                    }
                }
                mCartItemsResponse.dataModel.cartModel.itemsModelList.let {
                    val products: ArrayList<CartOrderResponse> = ArrayList()
                    it?.map {
                        val item = it.productModel
                        val mCartOrderResponse = CartOrderResponse(
                            product_id = item?.sku,
                            title = item?.name,
                            supplier_id = it?.uid,
                            price = item?.priceRangeModel?.minimumPriceModel?.finalPriceModel?.value,
                            original_price = item?.priceRangeModel?.minimumPriceModel?.regularPriceModel?.value,
                            amount = it?.quantity,
                            image = item?.smallImageModel?.url
                        )
                        mCartOrderResponse.productGraphID = it?.id
                        mCartOrderResponse.currencyId =
                            it?.productModel?.priceRangeModel?.minimumPriceModel?.finalPriceModel?.currency.toString()
                        mCartOrderResponse.productUID = it?.uid.toString()
                        products.add(mCartOrderResponse)
                    }

                    GetOrdersFromCartResponse(
                        errorMessage = mCartItemsResponse?.errorsListModel?.get(0)?.message.toString(),
                        totalCartProducts = if (it.isNullOrEmpty() == true) 0 else it?.size!!,
                        products = products,
                        sender_name = senderName,
                        recipient_name = receiverName,
                        gift_message = giftMSG,
                        giftItemId = giftItemID,
                        currentSelectedWrapId = currentSelectedWrapId
                    )
                }
            } else {
                GetOrdersFromCartResponse(errorMessage = mCartItemsResponse?.errorsListModel?.get(0)?.message.toString())
            }
        )
    }

    fun convertToCartCountResponse(it: CartItemsResponse): Publisher<out GetOrdersCountInCartResponse>? {
        return Flowable.just(
            if (it.errorsListModel.isNullOrEmpty()) {
                it.dataModel.cartModel.itemsModelList.let {
                    GetOrdersCountInCartResponse(if (it.isNullOrEmpty()) 0 else it?.size!!)
                }
            } else {
                GetOrdersCountInCartResponse(0)
            }
        )
    }

    fun convertToCheckoutResponse(it: CheckoutResponse): Publisher<out ReviewCartResponse?>? {
        return Flowable.just(
            try {
                if (it.errorsListModel.isNullOrEmpty()) {
                    it?.dataModel?.cartModel?.let { it ->
                        var subtotalWithDiscountExcludingTax = 0f
                        var availableShippingMethodsList: Array<CheckoutResponse.AvailablePaymentMethodModel?>? =
                            null
                        // Expected delivery time
                        it?.shippingAddressesList?.map {
                            availableShippingMethodsList = it?.availableShippingMethodsList
                        }
                        //Items
                        val mCheckOutProductsModelList = ArrayList<CheckOutProductsModel>()
                        val selectedPaymentMethodCode = it.mSelectedPaymentMethodModel?.code
                        it.productsList.mapIndexed { index, product ->
                            val productsList = ArrayList<CheckOutProductModel>()
                            productsList.add(
                                CheckOutProductModel(
                                    name = product?.productResponseModel?.name,
                                    code = product?.productResponseModel?.sku,
                                    price = product?.productResponseModel?.priceRangeModel?.minimumPriceModel?.finalPriceModel?.value,
                                    originalPrice = product?.productResponseModel?.priceRangeModel?.minimumPriceModel?.regularPriceModel?.value,
                                    currencyCode = product?.productResponseModel?.priceRangeModel?.minimumPriceModel?.finalPriceModel?.currency,
                                    amount = product?.quantity,
                                    image = product?.productResponseModel?.smallImageModel?.url
                                )
                            )
                            //From: Thu. 13 Aug., 2020 - To: Sun. 16 Aug., 2020

                            val mCheckOutProductsModel = CheckOutProductsModel(
                                products = productsList,
                                // check the options before
                                wh_country = product?.source_code.toString()
                            )

                            var productSourceCode = product?.source_code
                            availableShippingMethodsList?.map {
                                if (it?.source_code.equals(productSourceCode, true)) {
                                    mCheckOutProductsModel.deliveryTo = it?.delivery_to_str
                                    mCheckOutProductsModel.deliveryFrom = it?.delivery_from_str
                                    mCheckOutProductsModel.countryCourseCode =
                                        productSourceCode.toString()
                                }
                            }

                            try {
                                if (mCheckOutProductsModelList?.isNullOrEmpty()!!) {
                                    mCheckOutProductsModelList.add(mCheckOutProductsModel)
                                } else {
                                    var isAdded = false
                                    mCheckOutProductsModelList?.map {
                                        if (it?.wh_country.equals(product?.source_code, true)) {
                                            it?.products?.addAll(productsList)
                                            isAdded = true
                                        }
                                    }
                                    if (isAdded.not()) {
                                        mCheckOutProductsModelList.add(mCheckOutProductsModel)
                                    } else {
                                        //do no thing
                                    }
                                }

//                                if (mCheckOutProductsModelList.isNullOrEmpty().not() &&
//                                    mCheckOutProductsModelList.size > (index - 1) &&
//                                    mCheckOutProductsModelList[index - 1].wh_country.equals(product?.source_code, true)) {
//                                    val lastItem = mCheckOutProductsModelList[index - 1]
//                                    lastItem.products?.addAll(productsList)
//                                } else {
//                                    mCheckOutProductsModelList.add(mCheckOutProductsModel)
//                                }

                            } catch (e: java.lang.Exception) {
                                mCheckOutProductsModelList.add(mCheckOutProductsModel)
                            }
                        }
                        //address
                        val mCheckOutAddressModel = CheckOutAddressModel()
                        it?.shippingAddressesList?.map {
                            mCheckOutAddressModel.city = it?.regionModel?.code
                            mCheckOutAddressModel.area = it?.area
                            mCheckOutAddressModel.country = it?.countryModel?.code
                            //  mCheckOutAddressModel.address = it?.firstname?.plus(it?.lastname)
                            var street = ""
                            it?.street?.map {
                                if (it.isNullOrBlank().not()) {
                                    if (street.isNullOrBlank().not()) street =
                                        street.plus("-").plus(it)
                                } else street = it.toString()
                            }
                            mCheckOutAddressModel.block = street
                            if (mCheckOutAddressModel?.address.isNullOrBlank()) {
                                mCheckOutAddressModel?.address =
                                    it?.street?.get(0).plus(",").plus(it?.street_add)
                            }
                        }
                        // Prices
                        val mTotalPricesModel = TotalPricesModel()
                        val mCheckOutOrderTotalsModel = CheckOutOrderTotalsModel()
                        val mCheckOutOrderSubTotalsModel = CheckOutOrderSubTotalsModel()
                        val subTotalsLabels = ArrayList<CheckoutLabelModel>()
                        val pricesTotalList = ArrayList<CheckoutLabelModel>()

                        //GIFT PRICE
                        var totalGiftPrice = 0f
                        try {
                            it?.wrappingList?.map {
                                if (!it?.quoteItemIDS?.isNullOrEmpty()!!) {
                                    if (it?.priceModel?.value != null && it?.priceModel?.value!! > 0) totalGiftPrice += it?.priceModel?.value!! * it?.quoteItemIDS?.get(
                                        0
                                    )?.Qty!!
                                }
                            }
                        } catch (e: java.lang.Exception) {
                        }

                        if (totalGiftPrice > 0) {
                            subTotalsLabels.add(
                                CheckoutLabelModel(
                                    GIFT_COST_KEY,
                                    totalGiftPrice,
                                    "",
                                    "+"
                                )
                            )
                        }
                        var taxes = 0.0f

                        it?.pricesModel?.let {
                            it?.appliedTaxesList?.map {
                                if(it?.amount?.value > 0) {
                                    taxes += it?.amount?.value
                                }
                            }
                        }
                        it?.pricesModel?.grandTotal?.let {
                            pricesTotalList.add(
                                CheckoutLabelModel(
                                    TOTAL_PRICE_KEY,
                                    it?.value,
                                    "",
                                    "+", it?.currency,taxes > 0
                                )
                            )
                        }
                        var shippingCost: Float = 0f
                        it?.shippingAddressesList.map {
                            it?.SelectedShippingMethod?.amountModel?.let {
                                if(it.value != null){
                                    shippingCost += it?.value
                                }
                            }
                        }


                        it?.pricesModel?.let {
//                            it?.appliedTaxesList?.map {
//                                if(it?.amount?.value > 0) {
//                                    taxes += it?.amount?.value
//                                }
//                            }
//                            it?.appliedTaxesList?.map {
//                                subTotalsLabels?.add(
//                                    CheckoutLabelModel(
//                                        TAXES_KEY,
//                                        it.amount.value,
//                                        "",
//                                        "+",
//                                        it.amount.currency
//                                    )
//                                )
//                            }

//                            it?.subtotalWithDiscountExcludingTax?.let {
//                                subTotalsLabels.add(
//                                    CheckoutLabelModel(
//                                        SUB_TOTAL_KEY,
//                                        (it?.value),
//                                        "",
//                                        "+",
//                                        it?.currency,taxes > 0
//                                    )
//                                )
//                                subtotalWithDiscountExcludingTax = it?.value!!
//                            }
                            it?.subtotalIncludingTax?.let {
                                subTotalsLabels.add(
                                    CheckoutLabelModel(
                                        SUB_TOTAL_KEY,
                                        (it?.value),
                                        "",
                                        "+",
                                        it?.currency,taxes > 0
                                    )
                                )
                                subtotalWithDiscountExcludingTax = it?.value!!
                            }

                            it?.extraFeesList?.map {
                                subTotalsLabels.add(
                                    CheckoutLabelModel(
                                        it.title,
                                        it.amount.value,
                                        "",
                                        "+",
                                        it.amount.currency
                                    )
                                )
                            }

                            it?.discountsList?.map {
                                subTotalsLabels.add(
                                    CheckoutLabelModel(
                                        it?.title,
                                        it.amount.value,
                                        "",
                                        "-",
                                        it.amount.currency
                                    )
                                )
                            }

                        }
                        subTotalsLabels.add(
                            CheckoutLabelModel(
                                SHIPPING_COST_KEY,
                                shippingCost,
                                "",
                                "+"
                            )
                        )
                        mCheckOutOrderTotalsModel?.labels = pricesTotalList
                        mTotalPricesModel?.orderTotals = mCheckOutOrderTotalsModel
                        // Sub Totals
                        mCheckOutOrderSubTotalsModel?.labels = subTotalsLabels
                        mTotalPricesModel?.orderSubtotals = mCheckOutOrderSubTotalsModel

                        ///////////////////////////
                        // payment methods
                        val paymentsModelList = ArrayList<CheckOutPaymentModel>()
                        it?.availablePaymentMethodsList?.map {
                            //{"code":"applepaymastercard","title":"Apple Pay","logo":"https:\/\/magento-dev.tatayab.com\/media\/paymentmethods\/applepaymastercard_logo.png","subtitle":null}
                            if(it?.code.equals("applepaymastercard",true).not() && it?.title?.contains("Apple",true) == false) {
                                paymentsModelList.add(
                                    CheckOutPaymentModel(
                                        name = it?.title,
                                        code = it?.code,
                                        is_selected = if (it?.code.equals(selectedPaymentMethodCode)) 1 else 0,
                                        image = it?.logo
                                    )
                                )
                            }
                        }

                        // coupon
                        val mCheckOutCouponModel = CheckOutCouponModel()
                        it?.appliedCoupons?.let {
                            if (it.isNullOrEmpty().not()) {
                                it?.map {
                                    if (it?.code.isNullOrBlank().not()) {
                                        mCheckOutCouponModel.name = it?.code
                                        mCheckOutCouponModel.code = it?.code
                                    }
                                }
                            }
                        }
                        ReviewCartResponse(
                            productsList = mCheckOutProductsModelList,
                            paymentsModel = paymentsModelList,
                            couponModel = mCheckOutCouponModel,
                            addressModel = mCheckOutAddressModel,
                            totalsModel = mTotalPricesModel,
                            subtotalWithDiscountExcludingTax = subtotalWithDiscountExcludingTax
                        )
                    }

                } else {
                    ReviewCartResponse(msg = it?.errorsListModel?.get(0)?.message.toString())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                ReviewCartResponse(msg = e?.message.toString())
            })
    }

    fun convertPaymentMethodResponseToCheckoutResponse(it: PaymentUpdateInCheckoutResponse): Publisher<out ReviewCartResponse>? {
        return Flowable.just(
            try {
                if (it.errorsListModel.isNullOrEmpty()) {
                    ReviewCartResponse()
                } else {
                    ReviewCartResponse(msg = it.errorsListModel?.get(0)?.message.toString())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                ReviewCartResponse(msg = e.message.toString())
            }
        )
    }

    fun convertApplyCouponResponseToCheckoutResponse(it: ApplyCouponCheckoutResponse): Publisher<out ReviewCartResponse>? {
        return Flowable.just(
            try {
                if (it.errorsListModel.isNullOrEmpty()) {
                    var appliedCoupon =
                        if (it?.dataModel?.applyCouponToCart?.cartModel?.appliedCoupons?.isNullOrEmpty()!!) "" else it?.dataModel?.applyCouponToCart?.cartModel?.appliedCoupons?.get(
                            0
                        )?.code.toString()
                    ReviewCartResponse(appliedCouponCode = appliedCoupon)
                } else {
                    ReviewCartResponse(msg = it?.errorsListModel?.get(0)?.message.toString())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                ReviewCartResponse(msg = e?.message.toString())
            }
        )
    }

    fun convertRemoveCouponResponseToCheckoutResponse(it: RemoveCouponCheckoutResponse): Publisher<out ReviewCartResponse>? {
        return Flowable.just(
            try {
                if (it.errorsListModel.isNullOrEmpty()) {
                    ReviewCartResponse()
                } else {
                    ReviewCartResponse(msg = it?.errorsListModel?.get(0)?.message.toString())
                }
            } catch (e: Exception) {
                e.printStackTrace()
                ReviewCartResponse(msg = e?.message.toString())
            }
        )
    }

    fun convertToAddressesLists(response: GetUserAddressesGraphResponse): Flowable<ArrayList<AddressRequest>> {
        if (response.errorsListModel.isNullOrEmpty()) {
            return Flowable.fromArray(response.data.customer?.addresses?.map {
                AddressRequest(
                    first_name = it.firstname,
                    last_name = it.lastname,
                    o_address_id = it.id.toString(),
                    o_address = it.street_add,
                    o_address_name = it.street?.get(0) ?: "",
                    o_area = it.region?.region,
                     o_block = it.block,
                    o_city = it.city,
                    cityId = it.city_id.toString(),
                    o_phone = it.telephone,
                    o_street = it.street?.get(0) ?: "",
                    o_zipcode = it.postcode,
                    areaId = it.region?.region_id.toString(),
                    o_area_code = it.region?.region_code.toString(),
                    o_country_code = it.country_code,
                    addr_type = it.addr_type ?: "",
                    o_extra = it.add_direction ?: "",
                    is_primary = if (it.default_billing || it.default_shipping) "Y" else "N"//,
                    //keep_secret = it.keep_secret
                )
            } as ArrayList<AddressRequest>
            )
        } else {
            val addressList = ArrayList<AddressRequest>()
            return Flowable.fromArray(addressList)
        }
    }

    fun convertToPlaceOrderResponse(response: PlaceOrderResponse): Flowable<CreateOrderResponse> {
        return Flowable.just(
            if (response.errorsListModel.isNullOrEmpty()) {
                response?.dataModel?.mPlaceOrderModel?.let {
                    var orderID = ""
                    if (it.orderListIDs.isNullOrEmpty().not()) {
                        orderID = it.orderListIDs.get(0).order_number.toString()
                    }
                    CreateOrderResponse(
                        orderID,
                        0,
                        it?.paymentRedirectUrlModel?.paymentUrl.toString(),
                        it?.paymentRedirectUrlModel?.error
                    )
                }
            } else {
                CreateOrderResponse(
                    "",
                    0,
                    "",
                    response?.errorsListModel?.get(0)?.message.toString()
                )
            }
        )
    }

    fun convertToNotifyMeResponse(response: GetGraphNotifyMeActionResponse): Flowable<NormalResponse> {
        return Flowable.just(
            NormalResponse(
                success = if (response.errorsListModel.isNullOrEmpty()) 1 else 0,
                msg = if (response.errorsListModel.isNullOrEmpty()) response.data.AmxnotifStockSubscribe.response_message
                else response.errorsListModel!![0].message
            )
        )
    }

    fun convertToAddToWishList(
        response: GraphAddProductToWishListResponse,
        sku: String
    ): Flowable<AddToWishListResponse>? {
        var productWishlistId = getProductWishList(
            sku,
            response?.data?.addProductsToWishlist?.wishlist?.items?.wishListItemsList!!
        )
        return Flowable.just(
            AddToWishListResponse(
                productWishListId = productWishlistId,
                productID = sku,
                success = if (productWishlistId > 0) 1 else 0,
                msg = response.errorsListModel.takeIf { !it.isNullOrEmpty() }?.first()?.message
                    ?: ""
            )
        )
    }

    private fun getProductWishList(
        sku: String,
        wishListItemsList1: ArrayList<WishListItem>
    ): Int {
        try {

            if(wishListItemsList1.isNullOrEmpty().not()){
                return wishListItemsList1.get(wishListItemsList1.size-1)?.id.toInt()
            }else{
                return 0
            }
//            wishListItemsList1?.map {
//                if (it?.product?.sku.equals(sku, true))
//                    return it?.id?.toInt()!!
//            }

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

        return 0
    }

    fun convertToWishListProducts(response: GetWishListResponse): Flowable<WishListResponse>? {
        return Flowable.just(WishListResponse(
            id = response.data.customer.wishlists[0].id.toString(),
            products = response.data.customer.wishlists[0].items_v2.items.map {
                WishListProduct(
                    product_id = it.product.id.toString(),
                    product_sku = it.product.sku,
                    supplier_name = getSupplierName(it.product.dynamicAttributes),
                    title = it.product.name, image = it.product.small_image.url,
                    can_buy = if (it.product.stock_status == GRAPH_IN_STOCK) 1 else 0,
                    supplier_id = it.product.manufacturer,
                    price = it.product.price_range.minimum_price.final_price.value,
                    currency = it.product.price_range.minimum_price.final_price.currency,
                    selected_options = emptyMap(),
                    productWishListId = it.id,
                    source = it?.product?.source.toString()
                )
            }
        ))
    }

    private fun getSupplierName(dynamicAttributes: String): String {
        val gson = Gson()
        val gsonObject =
            gson.fromJson<ProductData.DynamicAttributes>(
                dynamicAttributes,
                ProductData.DynamicAttributes::class.java
            )
        return gsonObject.manufacturer_label
    }

    private fun getSliderData(data: String): ArrayList<SliderImageItem> {
        val list = ArrayList<SliderImageItem>()
        val response = String(data.toByteArray(), charset("UTF-8"))
        val jsonArray = JSONArray(response)
        for (i in 0 until jsonArray.length()) {
            val obj = Gson().fromJson<SliderImageItem>(
                jsonArray.get(i).toString(),
                SliderImageItem::class.java
            )
            list.add(obj)
        }
        return list
    }

    private fun getSliderAsSubCategory(data: String): ArrayList<ContentModel> {
        val list = ArrayList<ContentModel>()
        val response = String(data.toByteArray(), charset("UTF-8"))
        val jsonArray = JSONArray(response)
        for (i in 0 until jsonArray.length()) {
            val obj = Gson().fromJson<SliderImageItem>(
                jsonArray.get(i).toString(),
                SliderImageItem::class.java
            )
            list.add(ContentModel(banner = obj.image))
        }
        return list
    }


    fun convertToRemoveFromWishList(
        response: RemoveFromWishListResponse,
        sku: String
    ): Flowable<AddToWishListResponse>? {
        return Flowable.just(
            AddToWishListResponse(
                productID = sku,
                success = if (response.data.removeProductsFromWishlist.user_errors.isEmpty()) 1 else 0,
                msg = response.data.removeProductsFromWishlist.user_errors.takeIf { !it.isNullOrEmpty() }
                    ?.first()?.message
                    ?: ""
            )
        )
    }

    fun convertToCities(response: GraphGetRegionsResponse): Flowable<List<CityModel>>? {
        return Flowable.fromArray(response.data.mGraphRegionsResponse.available_regions.map {
            CityModel(
                name_ar = it.name,
                name_en = it.name,
                city_id = it.id,
                code = it.code,
                area_count = response.data.mGraphRegionsResponse.available_regions.size
            )
        }
        )
    }

    fun convertOrdersList(response: GetGraphUserOrdersResponse): Flowable<OrdersResponse>? {
        return Flowable.just(response).map {
            OrdersResponse(orders = it.data.customer.orders.items.map { response ->
                Order(
                    date = response.order_date,
                    order_id = response.number,
                    lastStatus = OrderStatues(name = response.status),
                    products_image = response.items.map { product ->
                        ProductsImage(
                            image = product.product_image,
                            product_id = product.product_sku
                        )
                    },
                    total = response.total.grand_total.value,
                    currency = response.total.grand_total.currency
                )
            })
        }
    }

    fun convertToOrderDetails(response: GetGraphUserOrdersResponse): Flowable<OrderDetailsResponse> {
        val order = response.data.customer.orders.items[0]
        return Flowable.just(
            OrderDetailsResponse(
                date = order.order_date,
                total = order.total.subtotal.value.toDouble(),
                currency = order.total.subtotal.currency,
                order_id = order.number,
                payment = order.payment_methods[0].name,
                delivery_charges = order.total.total_shipping.value.toDouble(),
                shipping_address = ShippingAddress(
                    city = order.shipping_address.city,
                    phone = order.shipping_address.telephone,
                    name = order.shipping_address.firstname,
                    country = order.shipping_address.country_code,
                    street = order.shipping_address.street[0],
                    state = order.shipping_address.region
                ),
                products = order.items.map { product ->
                    ProductInOrderDetails(
                        image = product.product_image,
                        name = product.product_name,
                        product_id = product.product_sku,
                        amount = product.quantity_ordered,
                        price = product.product_sale_price.value,
                        currency = product.product_sale_price.currency,
                        supplier = ""
                    )
                }
            )
        )
    }

    fun convertToAreas(response: GraphGetCitiesResponse): Flowable<List<AreaModel>>? {
        return Flowable.fromArray(response.data.getCities.cities.map {
            AreaModel(
                name_ar = it.default_name,
                name_en = it.locale_name,
                area_id = it.city_id
            )
        }
        )
    }

    fun convertToFiltersData(
        response: GetGraphCategoriesFilterResponse,
        key: String
    ): Flowable<FilterResponse>? {
        val priceList =
            response.data.products?.aggregations?.filter { it.attribute_code == "price" }
        var filterData = response.data.products?.aggregations
        if (key == "manufacturer")
            filterData = filterData?.filter { it.attribute_code != "manufacturer" }

        if (filterData != null) {
            return Flowable.just(
                FilterResponse(
                    features = filterData.map {
                        FilterMapValue(
                            featureId = it?.attribute_code,
                            featureName = it?.label,
                            variants = it.options.map { option ->
                                Variant(variantId = option?.value, variantName = option?.label)
                            })
                    },
                    prices = if (!priceList.isNullOrEmpty())
                        Prices(
                            min = priceList[0].options[0].value?.trim()!!.split("_")[0],
                            max = priceList[0].options.last().value?.trim()!!.split("_")[1]
                        )
                    else
                        Prices(min = "0", max = "0")
                )
            )
        } else {
            return null
        }
    }

    fun convertToReviewsList(response: GetGraphProductReviewsResponse): Flowable<ProductReviewsResponse>? {
        return Flowable.just(
            ProductReviewsResponse(
                reviews = response.data.products.items[0].reviews.items.map {
                    Review(
                        name = it.nickname,
                        date = it.created_at,
                        message = it.summary,
                        rating_value = ((it.average_rating.div(100)).times(5)).toString(),
                        post_id = it.created_at
                    )
                }
            )
        )
    }

    fun convertToSearchProductsLists(response: GraphCategoryProductsResponse): Flowable<SearchProductListResponse>? {
        return Flowable.just(
            SearchProductListResponse(
                status = response.data.products.items?.size ?: 0,
                products = response.data.products.items?.map {
                    SearchProductModel(
                        product_id = it.id.toInt(),
                        product_sku = it.sku,
                        supplier_name = getSupplierName(it.dynamicAttributes),
                        title = it.name, image = it.small_image.url,
                        can_buy = if (it.stock_status == GRAPH_IN_STOCK) 1 else 0,
                        price = it.price_range.minimum_price.final_price.value.toString(),
                        currency = it.price_range.minimum_price.final_price.currency
                    )
                }
            )
        )
    }

    fun convertWalletGraphResponseToWalletResponse(response: WalletGraphResponse): Publisher<WalletResponse>? {
        return Flowable.just(
            if (response.errorsListModel.isNullOrEmpty()) {
                var currencyCode =
                    response?.customerDataModel?.mCustomerModel?.mCreditModel?.balanceModel?.amountModel?.currency.toString()
                response?.customerDataModel?.mCustomerModel?.mCreditModel?.balanceModel?.amountModel?.let {

                    WalletResponse(
                        status = 1,
                        mWalletData = WalletData(
                            it?.value.toString(),
                            "0",
                            currencyCode = currencyCode
                        )
                    )
                } ?: WalletResponse(
                    status = 1, mWalletData = WalletData("0", "0", currencyCode = currencyCode)
                )
            } else {
                WalletResponse(
                    message = response?.errorsListModel?.get(0)?.message.toString(),
                    status = 0, mWalletData = null
                )
            })
    }

    fun convertWalletTransactionGraphResponseToWalletResponse(response: WalletTransactionsGraphResponse): Publisher<TransactionsHistoryResponse>? {
        return Flowable.just(
            if (response.errorsListModel.isNullOrEmpty()) {
                var mTransactionList = ArrayList<TransactionModel>()
                response?.customerDataModel?.mCustomerModel?.mCreditModel?.let {
                    if (it?.transactionsList.isNullOrEmpty()) {
                        TransactionsHistoryResponse(status = 1, mTransactionList = mTransactionList)
                    } else {
                        it?.transactionsList?.map {
                            var operation =
                                if (it?.balanceDeltaModel?.value.toString().contains("-")) {
                                    "-"
                                } else "+"
                            mTransactionList.add(
                                TransactionModel(
                                    id = it?.transaction_id,
                                    date = it?.created_at,
                                    operation = operation,
                                    amount = it?.balanceDeltaModel?.value.toString()
                                        .plus(it?.currency_code),
                                    status = it?.action,
                                    title = it?.message.toString()
                                )
                            )
                        }
                        TransactionsHistoryResponse(status = 1, mTransactionList = mTransactionList)
                    }
                } ?: TransactionsHistoryResponse(status = 1, mTransactionList = mTransactionList)
            } else {
                TransactionsHistoryResponse(
                    message = response?.errorsListModel?.get(0)?.message.toString(),
                    status = 0,
                    mTransactionList = null
                )
            }
        )
    }

    fun convertToBannerList(response: GraphGetBannerById): Publisher<List<Banner>>? {
        return if (!response.data.mpPromoBannerById.items[0].banner_image.isNullOrBlank())
            Flowable.fromArray(response.data.mpPromoBannerById.items.map {
                Banner(image = it.banner_image, url = it.url, banner = it.banner)
            })
        else
            Flowable.fromArray(getSliderData(response.data.mpPromoBannerById.items[0].slider_images!!).map {
                Banner(image = it.image, url = it.url)
            })
    }

    fun convertToForgotPasswordResponse(response: ForgotPasswordGraphResponse): Flowable<NormalResponse>? {
        return Flowable.just(
            if (response.errorsListModel.isNullOrEmpty()) {
                if (response?.customerDataModel?.requestPasswordResetEmail == true)
                    NormalResponse("", 1)
                else {
                    NormalResponse("", 0)
                }
            } else {
                NormalResponse(response?.errorsListModel?.get(0)?.message.toString(), 0)
            }
        )
    }

    fun convertChangePasswordGraphResponseToEditProfileResponse(response: ChangePasswordGraphResponse): Flowable<EditUserProfileResponse>? {
        return Flowable.just(
            if (response.errorsListModel.isNullOrEmpty()) {
                EditUserProfileResponse(1, "")
            } else {
                EditUserProfileResponse(
                    msg = response?.errorsListModel?.get(0)?.message.toString(),
                    status = 0
                )
            }
        )
    }

    fun convertToFirebaseTokenResponse(response: SaveFirebaseTokenResponse): Flowable<TokenResponse>? {
        return Flowable.just(
            if (response.errorsListModel.isNullOrEmpty()) {
                TokenResponse(
                    message = response?.data?.subscribeTokenModel?.messageString.toString(),
                    userProfile = null,
                    status = 1
                )
            } else {
                TokenResponse(
                    message = response?.errorsListModel?.get(0)?.message.toString(),
                    userProfile = null,
                    status = 0
                )
            }
        )
    }

    fun convertToGiftItemsList(response: GiftItemsResponse): Flowable<ProductsListResponse>? {
        return Flowable.just(
            if (response.errorsListModel.isNullOrEmpty()) {
                var productList = ArrayList<ProductX>()

                response?.data?.giftWrapListing?.giftcards?.map {
                    if (it?.status != null && it?.status == 1) {
                        /*var price =
                            if (it?.price == null || it?.price?.value == null || it?.price?.value!! <= 0) 0f else it?.price?.value*/
                        productList.add(
                            ProductX(
                                product_id = it?.entityId.toString(),
                                title = it?.name.toString(),
                                price = it?.price?.value?.toFloat()!!,
                                image = it?.image?.toString(),
                                currencyCode = it?.price?.currency,
                                category = "giftcards"
                            )
                        )
                    }
                }

                for(item in response?.data?.giftWrapListing?.giftwraps!!){
                    item?.giftWrapsData?.map {
                        if (it?.status != null && it?.status == 1) {
                            var price =
                                if (it?.price == null || it?.price?.value == null || it?.price?.value!! <= 0) 0f else it?.price?.value
                            productList.add(
                                ProductX(
                                    product_id = it?.entityId.toString(),
                                    title = it?.name.toString(),
                                    price = it?.price?.value?.toFloat()!!,
                                    image = it?.image?.toString(),
                                    currencyCode = it?.price?.currency,
                                category = item.category )
                            )
                        }
                    }
                }





               /*response?.data?.mGiftWrapListingModel?.GiftItemsList?.map {
                    if (it?.status != null && it?.status == 1) {
                        var price =
                            if (it?.price == null || it?.price?.value == null || it?.price?.value!! <= 0) 0f else it?.price?.value
                        productList.add(
                            ProductX(
                                product_id = it?.entityId.toString(),
                                title = it?.name.toString(),
                                price = price!!,
                                image = it?.image?.toString(),
                                currencyCode = it?.price?.currency)
                        )
                    }
                }*/
                ProductsListResponse(
                    products = productList,
                    total_rows = productList?.size!!
                )
            } else {
                ProductsListResponse(
                )
            }
        )
    }

    fun convertToAddGiftToCart(response: AddGiftItemToCartResponse): Flowable<AddItemToCartResponse>? {
        return Flowable.just(
            if (response.errorsListModel.isNullOrEmpty()) {
                AddItemToCartResponse(
                    success = 1,
                    subTotal = response?.data?.addGiftWrapToCartModel?.cartModel?.mPriceModel?.grandTotalModel?.value
                )
            } else {
                AddItemToCartResponse(
                    success = 0,
                    msg = response?.errorsListModel?.get(0)?.message.toString()
                )
            }
        )
    }

    fun convertToRemoveItemFromCart(response: RemoveItemToCartResponse): Flowable<AddItemToCartResponse>? {
        return Flowable.just(
            if (response.errorsListModel.isNullOrEmpty()) {
                var itemCount = 0
                response?.data?.removeItemFromCartModel?.cartModel?.let {
                    if (it?.cartModelItems.isNullOrEmpty().not())
                        itemCount = it?.cartModelItems!!.size
                }
                AddItemToCartResponse(
                    success = 1,
                    totalCartProducts = itemCount
                )
            } else {
                AddItemToCartResponse(
                    success = 0,
                    msg = response?.errorsListModel?.get(0)?.message.toString()
                )
            }
        )
    }

    fun convertToAddProductToCartResponse(it: AddProductWithOptionsToCartResponse): Flowable<AddProductToCartResponse>? {
        return Flowable.just(
            if (it.errorsListModel.isNullOrEmpty()) {
                var dataModel = it.data.addBundleProductsToCart.cartModel
                AddProductToCartResponse(
                    data = AddProductToCartResponse.AddProductToCartDataModel(
                        AddProductToCartResponse.AddSimpleProductsToCartModel(dataModel)
                    )
                )
            } else {
                var mAddProductToCartResponse = AddProductToCartResponse()
                    var list = ArrayList<ErrorListModel>()
                list.add(ErrorListModel(message = it?.errorsListModel?.get(0)?.message.toString(), debugMessage = ""))
                mAddProductToCartResponse.errorsListModel =list

                mAddProductToCartResponse
            }

        )
    }

    fun convertToCitiesList(response: GraphGetRegionsResponse): Flowable<List<CityModel>>? {
        return Flowable.fromArray(response.data?.mGraphRegionsResponse?.available_regions?.map {
            CityModel(
                name_ar = it.name,
                name_en = it.name,
                city_id = it.id,
                code = it.code)
        }
        )
    }

    fun convertToSuppliersResponse(response: GraphSuppliersResponse): Publisher<out SuppliersResponse>? {
        return Flowable.just(
            SuppliersResponse(
                suppliers = response.mGraphCountryListGrapg.brandsList?.brands?.map {
                    Supplier(
                        supplier_id = it.id,
                        name = it.name
                    )
                },
                params = null
            )
        )
    }

    fun convertToAreasForOneLevelResponse(
        it: GraphGetRegionsResponse): Publisher<List<AreaModel>>? {
        var list = it?.data?.mGraphRegionsResponse?.available_regions

            return Flowable.fromArray(
                list?.map {
                    AreaModel(
                        name_ar = it.name,
                        name_en = it.name,
                        area_id = it.id,
                        code = it?.code, isOneLevel = true
                    )
                }

            )
    }

    fun convertToAreasResponse(
        it: GraphRegionByCityIDResponse,
        cityCode: String?=""
    ): Publisher<List<AreaModel>>? {
        var list = it?.data?.mCitiesModel?.citiesList
            return Flowable.fromArray(
                list?.map {
                    AreaModel(
                        name_ar = it.locale_name,
                        name_en = it.locale_name,
                        area_id = it.city_id,
                        code = cityCode
                    )
                }

            )
    }

    fun convertToOneLevelCitiesList(response: GraphGetCitiesResponse): Flowable<List<CityModel>>? {
        return Flowable.fromArray(response.data?.getCities?.cities?.map {
            CityModel(
                name_ar = it.locale_name,
                name_en = it.locale_name,
                city_id = it.city_id,
                code = "")
        }
        )
    }

    fun isExpiredMessage(
        message: String
    ): Boolean {
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



    var EXPIRE_SESSION_MESSAGE = "The current user cannot perform operation"
    var CUSTOMER_NOT_AUTHORIZED_MESSAGE = "customer isn't authorized"
    var CART_NOT_ACTIVE_ERROR = "cart isn't active"
    var CART_NOT_FIND_ERROR = "Could not find a cart with"
    var CAN_NOT_ASSIGN_CART_ERROR = "Can't assign cart to store"
    var ALLOWED_FOR_LOGIN_ERROR = "request is allowed for logged in"

}