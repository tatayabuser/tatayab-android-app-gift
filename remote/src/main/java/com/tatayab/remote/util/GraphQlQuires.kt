package com.tatayab.remote.util

import android.util.Log
import com.tatayab.model.requests.AddressRequest
import com.tatayab.model.requests.LoginRequestBody
import com.tatayab.model.requests.RegisterRequestBody
import com.tatayab.model.requests.SocialLoginRequestBody
import com.tatayab.model.requests.graph_request.AddGraphProductReviewRequest
import com.tatayab.model.requests.graph_request.AddItemToCartGraphRequest
import com.tatayab.model.responses.graph_responses.ShippingAddressRequest

class GraphQlQuires {
    companion object {

        const val GET_ALL_COUNTRIES = "query {\n" +
                "    countries {\n" +
                "        id\n" +
                "        two_letter_abbreviation\n" +
                "        three_letter_abbreviation\n" +
                "        full_name_locale\n" +
                "        full_name_english\n" +
                "      phone_code\n" +
                "      phone_length\n" +
                "      phone_start_nums\n" +
                "      flag\n" +
                "      location\n" +
                "      show_custom_message \n" +
                "    }\n" +
                "}"


        const val GET_ALL_CATEGORIES = "query {\n" +
                "  categoryList{\n" +
                "    children_count\n" +
                "    children {\n" +
                "      name\n" +
                "      id\n" +
                "      uid\n" +
                "      image   \n" +
                "    }\n" +
                "  }\n" +
                "}"
  const val GET_ALL_CATEGORIES2 = "query getMainCategories{categoryList(filters:{parent_id:{in:[\"2\"]}}){children_count id uid cscart_id level name image path}}\n"


        const val GET_ALL_BRANDS = "{\n" +
                "  ambrandlist{\n" +
                "    items{\n" +
                "      brandId\n" +
                "      label\n" +
                "      url\n" +
                "      image\n" +
                "    }\n" +
                "  }\n" +
                "}"


        fun getSubCategory(categoryId: String) = "\n" +
                "query getSubCategories {\n" +
                "  categories(filters: { parent_category_uid: { in: \"$categoryId\" } }) {\n" +
                "    total_count\n" +
                "    items {\n" +
                "      children_count\n" +
                "\tid\n" +
                "\tuid\n" +
                "\t\t\tlevel\n" +
                "\t\t\tname\n" +
                "\t\t\tpath\n" +
                "\t\timage" +
                "\t\t\tmp_promo_banners{\n" +
                "\t\t\t\titems{\n" +
                "\t\t\t\t\turl\n" +
                "\t\t\t\t\ttype\n" +
                "\t\t\t\t\tslider_images\n" +
                "\t\t\t\t\tbanner_image\n" +
                "\t\t\t\t}\n" +
                "\t\t\t}\n" +
                "    children {\n" +
                "        id\n" +
                "        uid\n" +
                "        level\n" +
                "        name\n" +
                "        path\n" +
                "\t\t\timage\n" +
                "        children_count\n" +
                "      \n" +
                "      }\n" +
                "    }\n" +
                "    page_info {\n" +
                "      current_page\n" +
                "      page_size\n" +
                "      total_pages\n" +
                "    }\n" +
                "  }\n" +
                "}"

        fun getProductCategoryApi(
            key: String,
            categoryId: String,
            pageIndex: Int,
            pageSize: Int,
            filterData: String,
            fromPrice: String?,
            toPrice: String?,
            sortOrder: String?,
            sortBy: String?
        ): String {
            val filterQuery = StringBuilder()
            if (!filterData.contains("category_uid") && !filterData.contains("category_id")) {
                if (key.isNullOrBlank()) {
                    filterQuery.append("{manufacturer : {eq : \"${categoryId}\"}")
                } else {
                    filterQuery.append("{$key : {eq : \"${categoryId}\"}")
                }
            }

            addFilterDataToQuery(filterData, filterQuery)
            if (fromPrice != null && toPrice != null)
                filterQuery.append(",price: {from:\"$fromPrice\",to:\"$toPrice\"}")
            return "query {\n" +
                    "  products(filter:$filterQuery}\n" +
                    "    sort: {${sortOrder ?: "position"}: ${sortBy?.toUpperCase() ?: "DESC"} }\n" +
                    "    currentPage : $pageIndex\n" +
                    "    pageSize : $pageSize\n" +
                    "  )\n" +
                    "  {\n" +
                    "    total_count\n" +
                    "    items {\n" +
                    productRequired +
                    "    }\n" +
                    "     page_info {\n" +
                    "      page_size \n" +
                    "      current_page\n" +
                    "    }\n" +
                    "  }\n" +
                    "  \n" +
                    "}\n"
        }

        private fun addFilterDataToQuery(filterData: String, filterQuery: StringBuilder) {
            /// sample inputs
            // top_notes-1771-1773#any_notes-2312-2320

            val requiredFilters =
                filterData.takeIf { it.trim().isNotEmpty() }?.split("#") // split all filters
            requiredFilters?.map {
                val requiredFiltersValues = it.split("-")
                addFirstItemToFilter(requiredFiltersValues[0], filterQuery)
                if (requiredFiltersValues.size > 1)
                    requiredFiltersValues.subList(1, requiredFiltersValues.size)
                        .map { filterValue ->
                            filterQuery.append("\"$filterValue\"")
                            if (requiredFiltersValues.last() != filterData)
                                filterQuery.append(",")
                        }
                filterQuery.append("]}")
            }
        }

        private fun addFirstItemToFilter(str: String, filterQuery: StringBuilder) {
            if (filterQuery.isNotEmpty())
                filterQuery.append(",${str} : { in :[")
            else
                filterQuery.append("{ ${str} : { in :[")

        }

        fun getProductDetailsQuery(sku: String) = "{\n" +
                "  products(filter: { sku: { eq: \"$sku\" } }) {\n" +
                "    items {\nsource\n" +

                productRequired +
                " ... on BundleProduct {\n" +
                "      items {\n" +
                "          option_id\n" +
                "          title\n" +
                "          sku\n" +
                "        options{\n" +
                "            label\n" +
                "             id" +
                "            product{\n" +
                "              sku\n" +
                "            image{\n" +
                "                url\n" +
                "              }" +
                "              source\n" +
                "              shipping_details {\n" +
                "                shipping_title\n" +
                "                delivery_from\n" +
                "                delivery_from_str\n" +
                "                delivery_to\n" +
                "                delivery_to_str\n" +
                "              }\n" +
                "            }\n" +
                "          }\n" +
                "      }\n" +
                "      }" +
                "   shipping_details {\n" +
                "        shipping_title\n" +
                "        delivery_from\n" +
                "        delivery_from_str\n" +
                "        delivery_to_str\n" +
                "source_code" +
                "      }" +
                "      }\n" +
                "    }\n" +
                "}"


        fun getUsersAlsoBoughtProducts(uid: String) = "{\n" +
                "  amMostviewedGroups(uid: \"$uid\") {\n" +
                "  items {\n" +
                "    add_to_cart\n" +
                "    block_layout\n" +
                "    block_title" +
                "    items {\n" +
                productRequired +
                "      }\n" +
                "    }\n" +
                "    }\n" +
                "}"


        private const val getProductsForBlock = " items{name uid sku source dynamicAttributes(fields:[\"manufacturer\"])stock_status small_image{url}price_range{minimum_price{final_price{value currency}regular_price{value currency}discount{amount_off percent_off}}}... on BundleProduct{items{title options{label quantity position product{source}}}}}page_info{page_size current_page"
        private const val productRequired = "sku\n" +
                "      url_key   \n" +
                " url_suffix\n" +
                "source\n" +
                "      top_notes\n" +
                "      name\n" +
                "      id\n" +
                "      small_image{\n" +
                "        url\n" +
                "      }\n" +
                "      image{\n" +
                "        url\n" +
                "      }\n media_gallery {url}  \n" +
                "      manufacturer\n" +
                "      base_notes\n" +
                "      review_count\n" +
                " ... on BundleProduct {\n" +
                "      items {\n" +
                "          option_id\n" +
                "          title\n" +
                "}" +
                "}" +
                "    \n" +
                "      reviews{\n" +
                "        items{\n" +
                "          nickname\n" +
                "          summary\n" +
                "          average_rating\n" +
                "        }\n" +
                "      }\n" +

                "     dynamicAttributes(fields: [\"manufacturer\",\"gender\",\"color\",\"size\"])\n" +
                "\n" +
                "    description{\n" +
                "      html\n" +
                "    }\n" +
                "      stock_status      \n" +
                "      price_range {\n" +
                "        minimum_price {\n" +
                "          discount{\n" +
                "            amount_off\n" +
                "            percent_off\n" +
                "          }\n" +
                "          final_price{\n" +
                "            value\n" +
                "            currency\n" +
                "          }\n" +
                "          regular_price {\n" +
                "            value\n" +
                "            currency\n" +
                "  }\n" +
                "          }\n" +
                "        }\n"

        fun GET_REGISTER_QUERY(registerRequestBody: RegisterRequestBody) = "mutation {\n" +
                "  createCustomerV2(\n" +
                "    input: {\n" +
                "      firstname: \"${if(registerRequestBody.firstname.isNullOrBlank()) "Tatayab user" else registerRequestBody.firstname}\"\n" +
                "      lastname: \" \"\n" +
                "      email: \"${registerRequestBody.email}\"\n" +
                "      password: \"${registerRequestBody.password}\"\n" +
                "      is_subscribed: true\n" +
                "      phone_number: \"${registerRequestBody.phone}\"\n" +
                "    }\n" +
                "  ) {\n" +
                "    customer {\n" +
                "      id\n" +
                "      firstname\n" +
                "      lastname\n" +
                "      email\n" +
                "      is_subscribed\n" +
                "      phone_number\n" +
                "    }\n" +
                "  }\n" +
                "}"


        fun GET_TOKEN_QUERY(loginRequestBody: LoginRequestBody) =
            "mutation myGenerateCustomerToken {\n" +
                    "  generateCustomerToken(\n" +
                    "    email: \"${loginRequestBody?.email}\"\n" +
                    "    password: \"${loginRequestBody?.password}\"\n" +
                    "  ) {\n" +
                    "    token\n" +
                    "  }\n" +
                    "}"

        fun getLoginWithSocialMedia(mSocialLoginRequestBody: SocialLoginRequestBody):String {
            if(mSocialLoginRequestBody.email.isNullOrBlank().not()){
                return  "mutation {\n" +
                        "  authenticateCustomerWithSocialLogin(input: {\n" +
                        "    firstname: \"${if (mSocialLoginRequestBody.name.isNullOrBlank()) "Tatayab user" else mSocialLoginRequestBody.name}\"\n" +
                        "lastname: \"${mSocialLoginRequestBody.name}\"\n" +
                        "email:\"${mSocialLoginRequestBody.email}\"\n" +
                        "socialId:\"${mSocialLoginRequestBody.socialId}\"\n" +
                        "socialLoginType: \"${mSocialLoginRequestBody.regType}\"\n" +
                        "  }) {\n" +
                        "    token,\n" +
                        "  }\n" +
                        "}\n" +
                        "\n" +
                        "\n"
            }else{
                return  "mutation {\n" +
                        "  authenticateCustomerWithSocialLogin(input: {\n" +
                        "    firstname: \"${if (mSocialLoginRequestBody.name.isNullOrBlank()) "Tatayab user" else mSocialLoginRequestBody.name}\"\n" +
                        "lastname: \"${mSocialLoginRequestBody.name}\"\n" +
                        "socialId:\"${mSocialLoginRequestBody.socialId}\"\n" +
                        "socialLoginType: \"${mSocialLoginRequestBody.regType}\"\n" +
                        "  }) {\n" +
                        "    token,\n" +
                        "  }\n" +
                        "}\n" +
                        "\n" +
                        "\n"
            }

        }

        fun getSpecificProducts(pid: String): String {
            val list = StringBuilder()
            pid.split(",").map {
                list.append("\"$it\" ,")
            }
            val finalList = list.toString().substring(0, list.length - 1)
            Log.d("--list", finalList.toString())

            return "  {\n" +
                    "    \n" +
                    "  products(filter:{sku: {in : [$finalList]}}\n" +
                    "    sort:{position: DESC}\n" +
                    "    reserveSequence : true\n" +
                    "    pageSize : 100\n" +
                    "  )\n" +
                    "  {\n" +
                    "    total_count \n" +
                    "    items {\n" +
                    productRequired +
                    "}\n" +
                    "  }\n" +
                    "  }\n"
        }


        const val GET_GRAPH_BLOCKS = "{\n" +
                "  MobileLayoutGraphql{\n" +
                "    blocks{\n" +
                "      block_id\n" +
                "      position\n" +
                "      type\n" +
                "      title\n" +
                "      subtitle\n" +
                "      name\n" +
                "      template\n" +
                "      ob_ids\n" +
                "catId"+
                "    }\n" +
                "  }\n" +
                "}"

        fun createCartForLoggedInUser() =
            "{\n" +
                    "  customerCart{\n" +
                    "    id\n" +
                    "  }\n" +
                    "}"

        fun createCartForGuestUser() =
            "mutation {\n" +
                    "  createEmptyCart\n" +
                    "}"

        fun checkTokenExpiration(token:String) = "{ checkTokenAlive(token: \"$token\"){\n" +
                "                status     type   action }}"

        fun addProductWithOptionToCart(mAddItemToCartGraphRequest: AddItemToCartGraphRequest) =
            "mutation {\n" +
                    "  addBundleProductsToCart(\n" +
                    "    input: {\n" +
                    "      cart_id: \"${mAddItemToCartGraphRequest.CART_ID}\"\n" +
                    "      cart_items: [\n" +
                    "      {\n" +
                    "        data: {\n" +
                    "            sku: \"${mAddItemToCartGraphRequest.productId}\"\n" +
                    "            quantity: ${mAddItemToCartGraphRequest.quantity}\n" +
                    "            source: \"${mAddItemToCartGraphRequest.source}\"\n" +
                    "        }\n" +
                    "        bundle_options: ${mAddItemToCartGraphRequest.getOptionAsString()}\n" +
                    "  }]}) " +
                    "{\n" +
                    "    cart {\n" +
                    "      items {\n" +
                    "        id\n" +
                    "        product {\n" +
                    "          sku\n" +
                    "          stock_status\n" +
                    "        }\n" +
                    "        quantity\n" +
                    "      },\t\t" +
                    "prices{\n" +
                    "grand_total{\n" +
                    "currency\n" +
                    "value\n" +
                    "}\n" +
                    "}\n" +
                    "    }\n" +
                    "  }\n" +
                    "}"

        fun addProductToCart(mAddItemToCartGraphRequest: AddItemToCartGraphRequest) =
            "mutation {\n" +
                    "  addSimpleProductsToCart(\n" +
                    "    input: {\n" +
                    "      cart_id: \"${mAddItemToCartGraphRequest.CART_ID}\"\n" +
                    "      cart_items: [\n" +
                    "        {\n" +
                    "          data: {\n" +
                    "            quantity: ${mAddItemToCartGraphRequest.quantity}\n" +
                    "            sku: \"${mAddItemToCartGraphRequest.productId}\"\n" +
                    "            source: \"${mAddItemToCartGraphRequest.source}\"\n" +
                    "          }\n" +
                    "        }\n" +
                    "      ]\n" +
                    "    }\n" +
                    "  ) " +
                    "{\n" +
                    "    cart {\n" +
                    "      items {\n" +
                    "        id\n" +
                    "        product {\n" +
                    "          name\n" +
                    "          sku\n" +
                    "        }\n" +
                    "        quantity\n" +
                    "      },\t\t" +
                    "prices{\n" +
                    "grand_total{\n" +
                    "currency\n" +
                    "value\n" +
                    "}\n" +
                    "}\n" +
                    "    }\n" +
                    "  }\n" +
                    "}"

        fun getCartQuery(cartId: String) = "{cart(cart_id: \"$cartId\") {\n" +
                "    wrapping_items{\n" +
                "      entity_id\n" +
                "      wrap_id\n" +
                "      gift_message\n" +
                "receiver_name\n" +
                "sender_name\n" +
                "      wrap_name\n" +
                "      quote_item_ids{\n" +
                "        id\n" +
                "        Qty\n" +
                "      }\n" +
                "    }" +
                "    prices {\n" +
                "      grand_total {\n" +
                "        value\n" +
                "        currency\n" +
                "      }\n" +
                "      subtotal_excluding_tax {\n" +
                "        value\n" +
                "        currency\n" +
                "      }\n" +
                "      subtotal_including_tax {\n" +
                "        value\n" +
                "        currency\n" +
                "      }\n" +
                "    }" +
                "    items {\n" +
                "      id\n" +
                "      uid\n" +
                "      quantity\n" +
                "      product {\n" +
                "        name\n" +
                "        sku\n" +
                "... on BundleProduct{\n" +
                "                 items { option_id title\toptions{\n" +
                " uid\n" +
                "}}\n" +
                "}" +
                "        stock_status\n" +
                "source \n" +
                 "  shipping_details{\n" +
                "        delivery_from\n" +
                "        delivery_from_str\n" +
                "        delivery_to\n" +
                "        delivery_to_str\n" +
                "          shipping_method\n" +
                "          shipping_title\n" +
                "        }" +
                "        dynamicAttributes(fields: [\"manufacturer\"])\n" +
                "        small_image {\n" +
                "          url\n" +
                "          label\n" +
                "        }\n" +
                "        price_range {\n" +
                "          minimum_price {\n" +
                "            final_price {\n" +
                "              value\n" +
                "              currency\n" +
                "            }\n" +
                "            regular_price {\n" +
                "              value\n" +
                "              currency\n" +
                "            }\n" +
                "            discount {\n" +
                "              amount_off\n" +
                "              percent_off\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "        ... on BundleProduct {\n" +
                "          dynamic_price\n" +
                "          ship_bundle_items\n" +
                "          uid\n" +
                "          items {\n" +
                "            uid\n" +
                "            title\n" +
                "            type\n" +
                "            options {\n" +
                "              uid\n" +
                "            }\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "      prices {\n" +
                "        row_total {\n" +
                "          value\n" +
                "          formatted_price\n" +
                "        }\n" +
                "        total_item_discount {\n" +
                "          value\n" +
                "          currency\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "  }\n"

        fun getAddAddressQuery(addressRequest: AddressRequest): String {
            var request = ""
            if(addressRequest.areaId?.toInt() ?: 0 > 0 && addressRequest?.isAreaOneLevel==false){
                  request = "mutation {\n" +
                        "createCustomerAddress(input: {   country_code: ${addressRequest.o_country_code} \n" +
                        "telephone: \"${addressRequest.o_phone}\"   postcode: \"${addressRequest.o_zipcode}\"  " +
                        "city: \"${if (addressRequest.o_city.isNullOrBlank()) "-" else addressRequest.o_city}\"\n" +
                        "block: \"${addressRequest.o_block}\"  " +
                        "firstname: \"${if (addressRequest.first_name.isNullOrBlank()) "tatayab " else addressRequest.first_name}\" " +
                        " lastname: \"${if (addressRequest.last_name.isNullOrBlank()) "  user" else addressRequest.last_name}\"\n" +
                      //    "keep_secret: \"${addressRequest.keep_secret}\"  \n" +
                        "region: {\n" +
                        "region_id: ${if (addressRequest.areaId?.toInt() ?: 0 > 0) addressRequest.cityId else "0"}\n" +
                        "region: \"${if (addressRequest.o_area_code.isNullOrBlank()) " " else addressRequest.o_area_code}\" " +
                        "region_code: \"${if (addressRequest.o_area_code.isNullOrBlank()) " " else addressRequest.o_area_code}\" " +
                        "}\n" +
                        "city_id: \"${if (addressRequest.areaId?.toInt() ?: 0 > 0) addressRequest.areaId else addressRequest.cityId}\"  \n" +
                        "add_direction: \"${addressRequest.o_extra}\"  \n" +
                        "street_add: \"${addressRequest.o_address}\"  \n" +
                        "street: [\"${addressRequest.o_address_name}\"]\n" +
                        "default_shipping: ${if (addressRequest.is_primary == "Y") "true" else "false"}\n" +
                        "default_billing: ${if (addressRequest.is_primary == "Y") "true" else "false"}" +
                        //  "keep_secret: \"${addressRequest.keep_secret}\"  \n" +
                        " addr_type : \"${addressRequest.addr_type}\" \n" +
                        "house_building :\"${addressRequest.o_address}\" }) {  id    country_code }}\n"


            }
           else if(addressRequest.areaId?.toInt() ?: 0 > 0 && addressRequest?.isAreaOneLevel==true){
                request = "mutation {\n" +
                        "createCustomerAddress(input: {   country_code: ${addressRequest.o_country_code} \n" +
                        "telephone: \"${addressRequest.o_phone}\"   postcode: \"${addressRequest.o_zipcode}\"  " +
                        "city: \"${if (addressRequest.o_city.isNullOrBlank()) "-" else addressRequest.o_city}\"\n" +

                        "block: \"${addressRequest.o_block}\"  " +
                        "firstname: \"${if (addressRequest.first_name.isNullOrBlank()) "tatayab " else addressRequest.first_name}\" " +
                        " lastname: \"${if (addressRequest.last_name.isNullOrBlank()) "  user" else addressRequest.last_name}\"\n" +
                       // "keep_secret: \"${addressRequest.keep_secret}\"  \n" +
                        "region: {\n" +
                        "region_id: ${if (addressRequest.areaId?.toInt() ?: 0 > 0) addressRequest.areaId else "0"}\n" +
                        "region: \"${if (addressRequest.o_area_code.isNullOrBlank()) " " else addressRequest.o_area_code}\" " +
                        "region_code: \"${if (addressRequest.o_area_code.isNullOrBlank()) " " else addressRequest.o_area_code}\" " +
                        "}\n" +
                        "city_id: \"${addressRequest.cityId}\"  \n" +
                        "add_direction: \"${addressRequest.o_extra}\"  \n" +
                        "street_add: \"${addressRequest.o_address}\"  \n" +
                        "street: [\"${addressRequest.o_address_name}\"]\n" +
                        "default_shipping: ${if (addressRequest.is_primary == "Y") "true" else "false"}\n" +
                        "default_billing: ${if (addressRequest.is_primary == "Y") "true" else "false"}" +
                      //  "keep_secret: \"${addressRequest.keep_secret}\"  \n" +
                        " addr_type : \"${addressRequest.addr_type}\" \n" +
                        "house_building :\"${addressRequest.o_address}\" }) {  id    country_code }}\n"


            }
            else{
                  request = "mutation {\n" +
                        "createCustomerAddress(input: {   country_code: ${addressRequest.o_country_code} \n" +
                        "telephone: \"${addressRequest.o_phone}\"   postcode: \"${addressRequest.o_zipcode}\"  " +
                        "city: \"${if (addressRequest.o_city.isNullOrBlank()) "-" else addressRequest.o_city}\"\n" +
                        //  "keep_secret: \"${addressRequest.keep_secret}\"  \n" +
                        "block: \"${addressRequest.o_block}\"  " +
                        "firstname: \"${if (addressRequest.first_name.isNullOrBlank()) "tatayab " else addressRequest.first_name}\" " +
                        " lastname: \"${if (addressRequest.last_name.isNullOrBlank()) "  user" else addressRequest.last_name}\"\n" +
                        "city_id: \"${addressRequest.cityId}\"  \n" +
                        "add_direction: \"${addressRequest.o_extra}\"  \n" +
                        "street_add: \"${addressRequest.o_address}\"  \n" +
                        "street: [\"${addressRequest.o_address_name}\"]\n" +
                        "default_shipping: ${if (addressRequest.is_primary == "Y") "true" else "false"}\n" +
                        "default_billing: ${if (addressRequest.is_primary == "Y") "true" else "false"}" +
                         // "keep_secret: \"${addressRequest.keep_secret}\"  \n" +
                        " addr_type : \"${addressRequest.addr_type}\" \n" +
                        "house_building :\"${addressRequest.o_address}\" }) {  id    country_code }}\n"


            }

            if (addressRequest.update == "Y")
                request = request.replace(
                    "createCustomerAddress(",
                    "updateCustomerAddress(id: ${addressRequest.o_address_id} ,"
                )
            return request
        }

        const val GET_ALL_ADDRESSES_QUERY = "{\n" +
                "  customer {\n" +
                "    firstname\n" +
                "    lastname\n" +
                "    suffix\n" +
                "    email\n" +
                "    addresses {\n" +
                "    id\n" +
                "      firstname\n" +
                "      lastname\n" +
                "      street\n" +
                "      city\n" +
                "      city_id\n" +
                "      region {\n" +
                "      region_id\n" +
                "        region_code\n" +
                "        region\n" +
                "      }\n" +
                "      postcode\n" +
                "      street_add\n" +
                "      add_direction\n" +
                "       addr_type\n" +
                "       block\n" +
                "       house_building\n" +
                "       default_shipping\n" +
                "       default_billing" +
                "       \n" +
                "      country_code\n" +
                "      telephone\n" +
                "    }\n" +
                "  }\n" +
                "}"


        fun graphDeleteUserAddress(id: String) = "mutation {\n" +
                "  deleteCustomerAddress(id: ${id.toInt()})\n" +
                "}"

        fun placeOrderQuery(cartId: String) = "mutation {\n" +
                "  placeOrder(input: {cart_id: \"${cartId}\"}) {\n" +
                "order {\n" +
                "order_number\n" +
                "}\n" +
                "payment_redirect_url {\n" +
                "payment_url\n" +
                "error\n" +
                "method\n" +
                "}\n" +
                "}\n" +
                "}\n"


        fun getCheckoutQuery(cartId: String) = "{cart(cart_id:\"$cartId\") " +
                "{" +
                " id\n" +
                " email\n" +
                "  credit{\n" +
                "   is_applied\n" +
                "        amount {\n" +
                "          value\n" +
                "          currency\n" +
                "        }  \n" +
                "  }\n" +
                "  sources{\n" +
                "   code\n" +
                "   description \n" +
                "   logo\n" +
                "  }\n" +
                "    wrapping_items{\n" +
                "      entity_id\n" +
                "      wrap_id\n" +
                "      gift_message\n" +
                "   receiver_name\n" +
                "   sender_name\n" +
                "      wrap_name\n" +
                "base_price " +
                "price{\n" +
                "value\n" +
                "currency" +
                "}" +
                "      quote_item_ids{\n" +
                "        id\n" +
                "        Qty\n" +
                "      }\n" +
                "    }\n" +
                "    billing_address {\n" +
                "      city\n" +
                "      country {\n" +
                "        code\n" +
                "        label\n" +
                "      }\n" +
                "      firstname\n" +
                "      lastname\n" +
                "      postcode\n" +
                "      region {\n" +
                "        code\n" +
                "        label\n" +
                "      }\n" +
                "      street\n" +
                "   addr_type\n" +
                "      telephone\n" +
                "   city_id\n" +
                "   area\n" +
                "    }\n" +
                "    shipping_addresses {\n" +
                "      firstname\n" +
                "      lastname\n" +
                "      street\n" +
                "      street\n" +
                "      city\n" +
                "      street_add\n" +
                "      street\n" +
                "      add_direction\n" +
                "   addr_type\n" +
                "      region {\n" +
                "        code\n" +
                "        label\n" +
                "      }\n" +
                "      country {\n" +
                "        code\n" +
                "        label\n" +
                "      }\n" +
                "      telephone\n" +
                "   \n" +
                "   available_shipping_methods{\n" +
                "    method_code\n" +
                "    carrier_code\n" +
                "    source_code\n" +
                "delivery_to\n" +
                "delivery_to_str\n" +
                "delivery_from\n" +
                "delivery_from_str\n" +
                "source_code" +
                "   }\n" +
                "      selected_shipping_method {\n" +
                "        amount {\n" +
                "          value\n" +
                "          currency\n" +
                "        }\n" +
                "    base_amount{\n" +
                "     value\n" +
                "     currency\n" +
                "    }\n" +
                "        carrier_code\n" +
                "        carrier_title\n" +
                "        method_code\n" +
                "        method_title\n" +
                "      }\n" +
                "   city_id\n" +
                "    }\n" +
                "   wrapping_items{\n" +
                "      entity_id\n" +
                "      wrap_id\n" +
                "      gift_message\n" +
                "      wrap_name\n" +
                "      quote_item_ids{\n" +
                "        id\n" +
                "        Qty\n" +
                "      }\n" +
                "    }\n" +
                "\n" +
                "    items {\n" +
                "      id\n" +
                "      product {\n" +
                "        name\n" +
                "    source\n" +
                "        sku\n " +
                "shipping_details{\n" +
                "delivery_from\n" +
                "delivery_to\n" +
                "shipping_title\n" +
                "shipping_method\n" +
                "}" +
                "small_image {\n          url \n          label\n        }\n" +
                "    price_range{\n" +
                "     maximum_price{\n" +
                "      discount{\n" +
                "       amount_off\n" +
                "      }\n" +
                "      \n" +
                "      regular_price{\n" +
                "       value\n" +
                "       currency\n" +
                "      }\n" +
                "     }\n" +
                "     minimum_price{\n" +
                "      final_price{\n" +
                "       value\n" +
                "       currency\n" +
                "      }\n" +
                "      \n" +
                "      regular_price{\n" +
                "       value\n" +
                "       currency\n" +
                "      }\n" +
                "     }\n" +
                "    }\n" +
                "      }\n" +
                "      quantity\n " +
                "source_code" +
                "    }\n" +
                "    available_payment_methods {\n" +
                "      code\n" +
                "      title\n" +
                "   logo\n" +
                "   subtitle\n" +
                "    }\n" +
                "    selected_payment_method {\n" +
                "      code\n" +
                "      title\n" +
                "    }\n" +
                "    applied_coupons {\n" +
                "      code\n" +
                "    }\n" +
                "   prices {\n" +
                "  subtotal_excluding_tax{\n" +
                "   value\n" +
                "   currency\n" +
                "  }\n" +
                "  subtotal_including_tax{\n" +
                "   value\n" +
                "   currency\n" +
                "  }\n" +
                "  applied_taxes{\n" +
                "   amount{\n" +
                "    value\n" +
                "    currency\n" +
                "   }\n" +
                "  }\n" +
                "  subtotal_with_discount_excluding_tax{\n" +
                "   value\n" +
                "   currency\n" +
                "  }\n" +
                "  extra_fees{\n" +
                "   title\n" +
                "   amount{\n" +
                "    value\n" +
                "    currency\n" +
                "   }\n" +
                "  }\n" +
                "      discounts {\n" +
                "        amount {\n" +
                "          value\n" +
                "        }\n" +
                "        label\n" +
                "      }\n" +
                "      grand_total {\n" +
                "    \n" +
                "        value\n" +
                "    currency\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}"

        fun applyCouponQuery(cartId: String, coupon_code: String) =
            "mutation {\n" +
                    "  applyCouponToCart(input: {\n" +
                    "    cart_id: \"${cartId}\"\n" +
                    "    coupon_code: \"${coupon_code}\"\n" +
                    "  })  {\n" +
                    "    cart {\n" +
                    "      applied_coupons {\n" +
                    "        code\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}"

        fun removeCouponQuery(cartId: String) =
            "mutation {\n" +
                    "  removeCouponFromCart(input: {\n" +
                    "    cart_id: \"${cartId}\"\n" +
                    "  })  {\n" +
                    "    cart {\n" +
                    "      applied_coupons {\n" +
                    "        code\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}"


        fun setPaymentMethodQuery(cartId: String, methodCode: String) =
            "mutation {\n" +
                    "  setPaymentMethodOnCart(input: {\n" +
                    "      cart_id: \"$cartId\"\n" +
                    "      payment_method: {\n" +
                    "          code: \"$methodCode\"\n" +
                    "      }\n" +
                    "  })" +
                    "{\n" +
                    "    cart {\n" +
                    "      selected_payment_method {\n" +
                    "        code\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}"


        fun setShippingAddressOnCartQuery(mShippingAddressRequest: ShippingAddressRequest):String{
            return if (mShippingAddressRequest?.isAreaOneLevel == true) {
                "mutation {\n" +
                        "  setShippingAddressesOnCart(\n" +
                        "    input: {\n" +
                        "      cart_id: \"${mShippingAddressRequest?.cartId}\"\n" +
                        "      shipping_addresses: [\n" +
                        "        {\n" +
                        "          address: {\n" +
                        "            firstname: \"${if(mShippingAddressRequest.firstname.isNullOrBlank()) "Tatayab user" else mShippingAddressRequest.firstname}\"\n" +
                        "            lastname: \"${if(mShippingAddressRequest.lastname.isNullOrBlank()) "Tatayab user" else mShippingAddressRequest.lastname}\"\n" +
                        "            company: \"${mShippingAddressRequest.company}\"\n" +
                        "            city: \"${mShippingAddressRequest.city}\"\n" +
                        "           ${if(mShippingAddressRequest?.region.isNullOrBlank())"\n" else "region:\"${mShippingAddressRequest.region}\""}\n"+
                        "            postcode: \"${mShippingAddressRequest.postcode}\"\n" +
                        "            country_code: \"${mShippingAddressRequest.country_code}\"\n" +
                        "            telephone: \"${mShippingAddressRequest.telephone}\"\n" +
                        "            house_building:\"Test House/Building\" \n" +
                        "            addr_type:\"${mShippingAddressRequest.addr_type}\"\n" +
                        "${if(mShippingAddressRequest?.region_id.isNullOrBlank() || mShippingAddressRequest?.region_id.equals("-1") || mShippingAddressRequest?.region_id.equals("0"))"\n" else "region_id:" +mShippingAddressRequest?.city_id!!.toInt()} \n"+
                        "            city_id:\"${mShippingAddressRequest.city_id}\"\n" +
                        "           add_direction: \"${mShippingAddressRequest.extra}\"  \n" +
                        "           street_add: \"${mShippingAddressRequest.address}\"  \n" +
                        "           street: [\"${mShippingAddressRequest.address_name}\"]\n" +
                        "            save_in_address_book: ${mShippingAddressRequest.save_in_address_book}\n" +
                        "          }\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ) {\n" +
                        "     cart {\n" +
                        "      shipping_addresses {\n" +
                        "        firstname\n" +
                        "        lastname\n" +
                        "        company\n" +
                        "        street\n" +
                        "        city\n" +
                        "        region {\n" +
                        "          code\n" +
                        "          label\n" +
                        "        }\n" +
                        "        postcode\n" +
                        "        telephone\n" +
                        "        country {\n" +
                        "          code\n" +
                        "          label\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "}\n"
            }else{
                "mutation {\n" +
                        "  setShippingAddressesOnCart(\n" +
                        "    input: {\n" +
                        "      cart_id: \"${mShippingAddressRequest?.cartId}\"\n" +
                        "      shipping_addresses: [\n" +
                        "        {\n" +
                        "          address: {\n" +
                        "            firstname: \"${if(mShippingAddressRequest.firstname.isNullOrBlank()) "Tatayab user" else mShippingAddressRequest.firstname}\"\n" +
                        "            lastname: \"${if(mShippingAddressRequest.lastname.isNullOrBlank()) "Tatayab user" else mShippingAddressRequest.lastname}\"\n" +
                        "            company: \"${mShippingAddressRequest.company}\"\n" +
                        "            city: \"${mShippingAddressRequest.city}\"\n" +
                        "           ${if(mShippingAddressRequest?.region.isNullOrBlank())"\n" else "region:\"${mShippingAddressRequest.region}\""}\n"+
                        "            postcode: \"${mShippingAddressRequest.postcode}\"\n" +
                        "            country_code: \"${mShippingAddressRequest.country_code}\"\n" +
                        "            telephone: \"${mShippingAddressRequest.telephone}\"\n" +
                        "            house_building:\"Test House/Building\" \n" +
                        "            addr_type:\"${mShippingAddressRequest.addr_type}\"\n" +
                        "${if(mShippingAddressRequest?.region_id.isNullOrBlank() || mShippingAddressRequest?.region_id.equals("-1") || mShippingAddressRequest?.region_id.equals("0"))"\n" else "region_id:" +mShippingAddressRequest?.region_id!!.toInt()} \n"+
                        "            city_id:\"${mShippingAddressRequest.city_id}\"\n" +
                        "           add_direction: \"${mShippingAddressRequest.extra}\"  \n" +
                        "           street_add: \"${mShippingAddressRequest.address}\"  \n" +
                        "           street: [\"${mShippingAddressRequest.address_name}\"]\n" +
                        "            save_in_address_book: ${mShippingAddressRequest.save_in_address_book}\n" +
                        "          }\n" +
                        "        }\n" +
                        "      ]\n" +
                        "    }\n" +
                        "  ) {\n" +
                        "     cart {\n" +
                        "      shipping_addresses {\n" +
                        "        firstname\n" +
                        "        lastname\n" +
                        "        company\n" +
                        "        street\n" +
                        "        city\n" +
                        "        region {\n" +
                        "          code\n" +
                        "          label\n" +
                        "        }\n" +
                        "        postcode\n" +
                        "        telephone\n" +
                        "        country {\n" +
                        "          code\n" +
                        "          label\n" +
                        "        }\n" +
                        "      }\n" +
                        "    }\n" +
                        "  }\n" +
                        "}\n"
            }
            }


        fun setBillingAddressOnCartQuery(mShippingAddressRequest: ShippingAddressRequest?) :String {
           return if (mShippingAddressRequest?.isAreaOneLevel == true) {
               "mutation {\n" +
                       "  setBillingAddressOnCart(\n" +
                       "    input: {\n" +
                       "      cart_id: \"${mShippingAddressRequest?.cartId}\"\n" +
                       "      billing_address: {\n" +
                       "          address: {\n" +
                       "            firstname: \"${if (mShippingAddressRequest?.firstname.isNullOrBlank()) "tatayab" else mShippingAddressRequest?.firstname}\"\n" +
                       "            lastname: \"${if (mShippingAddressRequest?.lastname.isNullOrBlank()) " user" else mShippingAddressRequest?.lastname}\"\n" +
                       "            company: \"${mShippingAddressRequest?.company}\"\n" +
                       "            street: [\"${mShippingAddressRequest?.address_name}\"]\n" +
                       "            city: \"${mShippingAddressRequest?.city}\"\n" +
                       "           ${if(mShippingAddressRequest?.region.isNullOrBlank())"\n" else "region:\"${mShippingAddressRequest?.region}\""}\n"+
                        "            postcode: \"${mShippingAddressRequest?.postcode}\"\n" +
                       "            country_code: \"${mShippingAddressRequest?.country_code}\"\n" +
                       "            telephone: \"${mShippingAddressRequest?.telephone}\"\n" +
                       "            save_in_address_book: false\n " +
                       "            house_building:\"${if(mShippingAddressRequest?.addr_type.isNullOrBlank()) "House/Building" else mShippingAddressRequest?.addr_type}\" \n" +
                       "             addr_type:\"${mShippingAddressRequest?.addr_type}\"\n" +
                       "             city_id:\"${mShippingAddressRequest?.region_id}\"\n" +
                       "${if(mShippingAddressRequest?.region_id.isNullOrBlank() || mShippingAddressRequest?.region_id.equals("-1") || mShippingAddressRequest?.region_id.equals("0"))"\n" else "region_id:" +mShippingAddressRequest?.city_id!!.toInt()} \n"+
//                    "             region_id:${if(mShippingAddressRequest?.region_id.isNullOrBlank()) 0 else mShippingAddressRequest?.region_id?.toInt()}\n" +
                       "          }\n" +
                       "      }\n" +
                       "    }\n" +
                       "  ) {\n" +
                       "    cart {\n" +
                       "      billing_address {\n" +
                       "        firstname\n" +
                       "        lastname\n" +
                       "        company\n" +
                       "        street\n" +
                       "        city\n" +
                       "        region{\n" +
                       "          code\n" +
                       "          label\n" +
                       "        }\n" +
                       "        postcode\n" +
                       "        telephone\n" +
                       "        country {\n" +
                       "          code\n" +
                       "          label\n" +
                       "        }\n" +
                       "      }\n" +
                       "    }\n" +
                       "  }\n" +
                       "}\n"
            } else {
               "mutation {\n" +
                       "  setBillingAddressOnCart(\n" +
                       "    input: {\n" +
                       "      cart_id: \"${mShippingAddressRequest?.cartId}\"\n" +
                       "      billing_address: {\n" +
                       "          address: {\n" +
                       "            firstname: \"${if (mShippingAddressRequest?.firstname.isNullOrBlank()) "tatayab" else mShippingAddressRequest?.firstname}\"\n" +
                       "            lastname: \"${if (mShippingAddressRequest?.lastname.isNullOrBlank()) " user" else mShippingAddressRequest?.lastname}\"\n" +
                       "            company: \"${mShippingAddressRequest?.company}\"\n" +
                       "            street: [\"${mShippingAddressRequest?.address_name}\"]\n" +
                       "            city: \"${mShippingAddressRequest?.city}\"\n" +
                       "           ${if(mShippingAddressRequest?.region.isNullOrBlank())"\n" else "region:\"${mShippingAddressRequest?.region}\""}\n"+
//                    "            region: \"${mShippingAddressRequest?.region}\"\n" +
                       "            postcode: \"${mShippingAddressRequest?.postcode}\"\n" +
                       "            country_code: \"${mShippingAddressRequest?.country_code}\"\n" +
                       "            telephone: \"${mShippingAddressRequest?.telephone}\"\n" +
                       "            save_in_address_book: false\n " +
                       "            house_building:\"${if(mShippingAddressRequest?.addr_type.isNullOrBlank()) "House/Building" else mShippingAddressRequest?.addr_type}\" \n" +
                       "             addr_type:\"${mShippingAddressRequest?.addr_type}\"\n" +
                       "             city_id:\"${mShippingAddressRequest?.city_id}\"\n" +
                       "${if(mShippingAddressRequest?.region_id.isNullOrBlank() || mShippingAddressRequest?.region_id.equals("-1") || mShippingAddressRequest?.region_id.equals("0"))"\n" else "region_id:" +mShippingAddressRequest?.region_id!!.toInt()} \n"+
//                    "             region_id:${if(mShippingAddressRequest?.region_id.isNullOrBlank()) 0 else mShippingAddressRequest?.region_id?.toInt()}\n" +
                       "          }\n" +
                       "      }\n" +
                       "    }\n" +
                       "  ) {\n" +
                       "    cart {\n" +
                       "      billing_address {\n" +
                       "        firstname\n" +
                       "        lastname\n" +
                       "        company\n" +
                       "        street\n" +
                       "        city\n" +
                       "        region{\n" +
                       "          code\n" +
                       "          label\n" +
                       "        }\n" +
                       "        postcode\n" +
                       "        telephone\n" +
                       "        country {\n" +
                       "          code\n" +
                       "          label\n" +
                       "        }\n" +
                       "      }\n" +
                       "    }\n" +
                       "  }\n" +
                       "}\n"

           }
        }


        fun addProductReview(request: AddGraphProductReviewRequest): String =
            "mutation {\n" +
                    "  createProductReview(\n" +
                    "    input: {\n" +
                    "      sku: \"${request.sku}\",\n" +
                    "      nickname: \"${request.name}\",\n" +
                    "      summary: \"${request.text}\",\n" +
                    "      text: \"${request.text}\",\n" +
                    "      ratings: [\n" +
                    "        {\n" +
                    "          id: \"${request.ratingId}\",\n" +
                    "          value_id: \"${request.ratingIdValue}\"\n" +
                    "        } " +
                    "      ]\n" +
                    "    }\n" +
                    ") {\n" +
                    "    review {\n" +
                    "      nickname\n" +
                    "      summary\n" +
                    "      text\n" +
                    "      average_rating\n" +
                    "      ratings_breakdown {\n" +
                    "        name\n" +
                    "        value\n" +
                    "      }\n" +
                    "    }\n" +
                    "  }\n" +
                    "}"

        const val PRODUCT_REVIEW_META_DATE = "query {\n" +
                "  productReviewRatingsMetadata {\n" +
                "    items {\n" +
                "      id\n" +
                "      name\n" +
                "      values {\n" +
                "        value_id\n" +
                "        value\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}"

        fun getNotifyMeProductQuery(email: String, productId: String): String =
            "\n" +
                    "mutation {\n" +
                    "  AmxnotifStockSubscribe(input: {\n" +
                    "email: \"$email\",\n" +
                    "product_sku: \"$productId\"" +
                    "  }) {\n" +
                    "response_message\n" +
                    "  }\n" +
                    "}"


        const val GET_WISHLIST_ID = "{customer {\n" +
                "wishlists{\n" +
                "      id\n" +
                "      items_count\n" +
                "      items_v2 {\n" +
                "        items {\n" +
                "          id\n" +
                "          product {\n" +
                "            uid\n" +
                "            name\n" +
                "            sku}}}}}}"

        fun setGuestEmailOnCartQuery(cartId: String, email: String) = "mutation {\n" +
                "  setGuestEmailOnCart(input: {\n" +
                "    cart_id: \"$cartId\"\n" +
                "    email: \"$email\"\n" +
                "  }) {\n" +
                "    cart {\n" +
                "      email\n" +
                "    }\n" +
                "  }\n" +
                "}"

        fun userProfileQuery() = "{\n" +
                "  customer {\n" +
                "    firstname\n" +
                "    lastname\n" +
                "    suffix\n" +
                "    gender\n" +
                "    email\n" +
                "    wishlists{\n" +
                "      id\n" +
                "      }\n" +
                "id\n" +
                "  }\n" +
                "}"

        fun getAddToWishListQuery(wishlistId: String, sku: String) =
            "mutation {\n" +
                    "  addProductsToWishlist(\n" +
                    "    wishlistId: $wishlistId\n" +
                    "    wishlistItems: [\n" +
                    "      {\n" +
                    "        sku: \"$sku\"\n" +
                    "        quantity: 1\n" +
                    "      }\n" +
                    "    ]\n" +
                    "  ) {\n" +
                    "    wishlist {\n" +
                    "      id\n" +
                    "      items_count\n" +
                    "      items_v2 (currentPage: 1, pageSize: 8 ) {\n" +
                    "        items {\n" +
                    "          id\n" +
                    "          quantity\n" +
                    "          ... on BundleWishlistItem {\n" +
                    "            bundle_options {\n" +
                    "              values {\n" +
                    "                id\n" +
                    "                label\n" +
                    "                quantity\n" +
                    "              }\n" +
                    "            }\n" +
                    "          }\n" +
                    "          product {\n" +
                    "            uid\n" +
                    "            name\n" +
                    "            sku\n" +
                    "            price_range {\n" +
                    "              minimum_price {\n" +
                    "                regular_price {\n" +
                    "                  currency\n" +
                    "                  value\n" +
                    "                }\n" +
                    "              }\n" +
                    "              maximum_price {\n" +
                    "                regular_price {\n" +
                    "                  currency\n" +
                    "                  value\n" +
                    "                }\n" +
                    "              }\n" +
                    "            }\n" +
                    "          }\n" +
                    "        }\n" +
                    "      }\n" +
                    "    }\n" +
                    "    user_errors {\n" +
                    "      code\n" +
                    "      message\n" +
                    "    }\n" +
                    "  }\n" +
                    "}\n"


        const val GET_WISHLIST_PRODUCTS = "{customer {\n" +
                "wishlists{\n" +
                "      id\n" +
                "      items_count\n" +
                "      items_v2 {\n" +
                "        items {\n" +
                "          id\n" +
                "          product {\n" +
                productRequired +
                "}}}}}}"

        fun removeFromWishList(wishlistId: String, wishlistItemId: String?) =
            "mutation {\n" +
                    "  removeProductsFromWishlist(\n" +
                    "  wishlistId: $wishlistId\n," +
                    "  wishlistItemsIds: [\n" +
                    "    $wishlistItemId\n" +
                    "  ]" +
                    "){\n" +
                    "    wishlist {\n" +
                    "      id\n," +
                    "      items_count\n" +
                    "  \n" +
                    "    }\n" +
                    "    user_errors {\n" +
                    "      code\n," +
                    "      message\n" +
                    "    }\n" +
                    "  }}\n"


        fun getAreasForOneLevelCountry(countryCode: String) =
            "query {\n" +
                    "    country(id: \"$countryCode\") {\n" +
                    "        id\n" +
                    "        available_regions {\n" +
                    "            id\n" +
                    "            code\n" +
                    "            name\n" +
                    "        }\n" +
                    "    }\n" +
                    "}"

        // AKL AREA
        fun getAreasByCountry(countryCode: String) = "query {\n" +
                "    country(id: \"$countryCode\") {\n" +
                "        id\n" +
                "        two_letter_abbreviation\n" +
                "        three_letter_abbreviation\n" +
                "        full_name_locale\n" +
                "        full_name_english\n" +
                "        available_regions {\n" +
                "            id\n" +
                "            code\n" +
                "            name\n" +
                "\t\t\t\t\t  \n" +
                "        }\n" +
                "    }\n" +
                "}"

        fun getCitiesQuery(countryCode: String) = "query {country(id:\"$countryCode\"){available_regions{id code name }}}"
        fun getOneLevelCitiesByCountry(countryCode: String) =
            "{\n" +
                    "  getCities(country_code : \"$countryCode\"){\n" +
                    "    cities {\n" +
                    "      city_id\n" +
                    "      default_name\n" +
                    "      locale_name\n" +
                    "    }\n" +
                    "  }\n" +
                    "}"

        fun getAreasByCity(city_id: Int) =
            "{\n" +
                    "  getCities(region_id : $city_id){\n" +
                    "    cities {\n" +
                    "      city_id\n" +
                    "      default_name\n" +
                    "      locale_name\n" +
                    "    }\n" +
                    "  }\n" +
                    "}\n"




        fun getLastSupportedVersion(version: String) =
            "{CheckVersionGraphql(deviceType : \"android\", appVersion: \"$version\")\n" +
                    "}"


        fun getUserOrdersQuery(pageIndex: Int, pageSize: Int) = "query {\n" +
                "  customer {\n" +
                "    orders(\n" +
                "      pageSize: $pageSize\n" +
                "      currentPage: $pageIndex\n" +
                "    ) {\n" +
                "      items {\n" +
                "        id\n" +
                "        order_date\n" +
                "       number\n" +
                "       status\n" +
                "       items{\n" +
                "       product_sku\n" +
                "       product_image\n" +
                "       }\n" +
                "        total {\n" +
                "          grand_total {\n" +
                "            value\n" +
                "            currency\n" +
                "          }\n" +
                "        }\n" +
                "        status\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}"

        fun getShippingAvalMethodsQuery(cartId: String) = "{\n" +
                "  cart(cart_id: \"$cartId\") {\n" +
                "    shipping_addresses {\n" +
                "      available_shipping_methods {\n" +
                "        method_code\n" +
                "        carrier_code\n" +
                "        source_code\n" +
                "      }\n" +
                "    }\n" +
                "}\n" +
                "}\n"

        fun getWalletQuery() = "{\n" +
                "customer{\n" +
                "credit{\n" +
                "balance{\n" +
                "amount{\n" +
                "currency,\n" +
                "value\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "}"

        fun getWalletTransactionsQuery() =
            "{customer{credit{transactions{balance_amount{currency value}balance_delta{currency value}action message currency_code created_at transaction_id}}}}"

        fun setShippingMethodQuery(
            customer_cart: String,
            carrier_code: String,
            method_code: String
        ) = "mutation {\n" +
                "  setShippingMethodsOnCart(input: {\n" +
                "    cart_id: \"$customer_cart\"\n" +
                "    shipping_methods: [\n" +
                "      {\n" +
                "        carrier_code: \"$carrier_code\"\n" +
                "        method_code: \"$method_code\"\n" +
                "      }\n" +
                "    ]\n" +
                "  }) {\n" +
                "    cart {\n" +
                "      shipping_addresses {\n" +
                "        selected_shipping_method {\n" +
                "          carrier_code\n" +
                "          method_code\n" +
                "          carrier_title\n" +
                "          method_title\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}\n"


        fun getOrderDetails(orderId:String) = "" +
                "customer{orders(filter:{number:{eq:$orderId}})" +
                "{items{number order_date total{grand_total{value}" +
                " total_shipping{value}} payment_methods" +
                "{name}billing_address{firstname lastname telephone city street city country_code}" +
                "shipping_address{firstname lastname telephone city street city country_code}" +
                "items{product_sku product_name product_image product_url_key product_sale_price{value}quantity_ordered}" +
                "}}}"


        fun getOrderDetailsQuery(order: String) = "\n" +
                "  {\n" +
                "customer {\n" +
                "    orders(filter: {number: {eq: \"$order\"}}) {\n" +
                "      total_count\n" +
                "      items {\n" +
                "        id\n" +
                "        number\n" +
                "        order_date\n" +
                "        status\n" +
                "        items {\n" +
                "          product_name\n" +
                "          product_sku\n" +
                "          product_image\n" +
                "          product_url_key\n" +
                "          product_sale_price {\n" +
                "            value\n" +
                "            currency\n" +
                "          }\n" +
                "          quantity_ordered\n" +
                "          quantity_invoiced\n" +
                "          quantity_shipped\n" +
                "        }\n" +
                "shipping_address{\n" +
                "city\n" +
                "street\n" +
                "country_code\n" +
                "firstname\n" +
                "postcode\n" +
                "telephone\n" +
                " region\n" +
                "\n" +
                "}\n" +
                "payment_methods{\n" +
                "name\n" +
                "type\n" +
                "additional_data{\n" +
                "name\n" +
                "value\n" +
                "}\n" +
                "}\n" +
                "        carrier\n" +
                "        shipments {\n" +
                "          id\n" +
                "          number\n" +
                "          items {\n" +
                "            product_name\n" +
                "            quantity_shipped\n" +
                "          }\n" +
                "        }\n" +
                "        total {\n" +
                "          base_grand_total {\n" +
                "            value\n" +
                "            currency\n" +
                "          }\n" +
                "          grand_total {\n" +
                "            value\n" +
                "            currency\n" +
                "          }\n" +
                "          total_tax {\n" +
                "            value\n" +
                "          }\n" +
                "          subtotal {\n" +
                "            value\n" +
                "            currency\n" +
                "          }\n" +
                "          taxes {\n" +
                "            amount {\n" +
                "              value\n" +
                "              currency\n" +
                "            }\n" +
                "            title\n" +
                "            rate\n" +
                "          }\n" +
                "          total_shipping {\n" +
                "            value\n" +
                "currency\n" +
                "          }\n" +
                "          shipping_handling {\n" +
                "            amount_including_tax {\n" +
                "              value\n" +
                "            }\n" +
                "            amount_excluding_tax {\n" +
                "              value\n" +
                "            }\n" +
                "            total_amount {\n" +
                "              value\n" +
                "            }\n" +
                "            taxes {\n" +
                "              amount {\n" +
                "                value\n" +
                "              }\n" +
                "              title\n" +
                "              rate\n" +
                "            }\n" +
                "          }\n" +
                "          discounts {\n" +
                "            amount {\n" +
                "              value\n" +
                "              currency\n" +
                "            }\n" +
                "            label\n" +
                "          }\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  }\n" +
                "}"

        fun getFilterData(type: String, categoryId: String) = "{\n" +
                "products(\n" +
                "    filter: { $type: { eq: \"$categoryId\" }  }\n" +
                "    pageSize: 30\n" +
                "    sort: { name:  DESC }\n" +
                ") {\n" +
                "   aggregations (filter: {category: {includeDirectChildrenOnly: true}}){\n" +
                "   attribute_code\n" +
                "   count\n" +
                "   label\n" +
                "   options {\n" +
                "   label\n" +
                "   value\n" +
                "   count\n" +
                "       }\n" +
                "   }\n" +
                "   page_info {\n" +
                "   page_size\n" +
                "    }\n" +
                "}\n" +
                "}\n"


        fun getProductReviews(sku: String, pageIndex: Int, pageSize: Int) = "{\n" +
                "products(filter: { sku: { eq: \"$sku\" } } currentPage: $pageIndex , pageSize : $pageSize) {\n" +
                "items {\n" +
                "      reviews{\n" +
                "items{\n" +
                "nickname\n" +
                "average_rating\n" +
                "summary\n" +
                "created_at\n" +
                "}\n" +
                "\n" +
                "}\n" +
                "}\n" +
                "}\n" +
                "}\n"

        fun getSearchInProductsQuery(search: String) =

            "{products(search: \"$search\", pageSize: 100, currentPage: 1) {\n" +
                    "    items {\n" +
                    productRequired +
                    "      }\n" +
                    "    }\n" +
                    "}"

        fun getForgotPasswordQuery(email: String) = "mutation {\n" +
                "  requestPasswordResetEmail(email: \"$email\")\n" +
                "}"

        fun getRestoreCartQuery(customer_cart: String) = "mutation {\n" +
                "RestoreCart(input: { cart_id: \"$customer_cart\" }\n" +
                ") \n" +
                "}"

        //https://devdocs.magento.com/guides/v2.4/graphql/mutations/change-customer-password.html
        fun getChangePasswordQuery(currentPassword: String, newPassword: String) = "mutation {\n" +
                "  changeCustomerPassword(\n" +
                "    currentPassword: \"$currentPassword\"\n" +
                "    newPassword: \"$newPassword\"\n" +
                "  ) {\n" +
                "    id\n" +
                "    email\n" +
                "  }\n" +
                "}\n" +
                "\n"

        fun getBannerById(id: String) =
            "{\n" +
                    "mpPromoBannerById(banner_id: $id) {\n" +
                    "items {\n" +
                    "banner_id\n" +
                    "name\n" +
                    "status\n" +
                    "store_ids\n" +
                    "customer_group_ids\n" +
                    "category\n" +
                    "from_date\n" +
                    "to_date\n" +
                    "priority\n" +
                    "type\n" +
                    "banner_image\n" +
                    "slider_images\n" +
                    "cms_block_id\n" +
                    "content\n" +
                    "popup_image\n" +
                    "popup_responsive\n" +
                    "floating_image\n" +
                    "url\n" +
                    "\n" +
                    "}\n" +
                    "}\n" +
                    "}\n"

        fun getMergeCartsQuery(customerCart: String, guestCart: String) = "mutation {\n" +
                "  mergeCarts(\n" +
                "    source_cart_id: \"$guestCart\",\n" +
                "    destination_cart_id: \"$customerCart\"\n" +
                "  ) {\n" +
                "    items {\n" +
                "      id\n" +
                "      product {\n" +
                "        name\n" +
                "        sku\n" +
                "      }\n" +
                "      quantity\n" +
                "    }\n" +
                "  }\n" +
                "}"

        fun getSentFirebaseToken(token: String) = "mutation {\n" +
                "  subscribeToken(\n" +
                "token: \"$token\"\n" +
                "browser_name: \"Chrome\"\n" +
                "device_type:\"android\"\n" +
                "){\n" +
                "message\n" +
                "}\n" +
                "}"

    /*   fun getGiftItems() = "{\n" +
                "GiftWrapListing(perPage:100,pageNumber:1){\n" +
                "giftwraps{entity_id status name \n" +
                "price{\n" +
                "value\n" +
                "currency\n" +
                "}\n" +
                "image}\n" +
                "}\n" +
                "}"*/

        fun getGiftItems(countryCode:String,cityCode:String) = "{\n" +
               /* "GiftWrapListing(perPage:20,countryCode: ${countryCode},cityCode: ${cityCode}){\n" +
                "giftwraps{category \n" +
                "giftWrapsData{\n" +
                "entity_id\n" +
                "created_at\n" +
                "status\n" +
                "name\n" +
                "price{\n" +
                "value\n" +
                "currency\n" +
                "}\n" +
                "image}\n" +
                "}\n" +
                "}\n" +*/
                "GiftWrapListing(perPage:20,\n" +
                "countryCode: \"$countryCode\",\n" +
                "cityCode: \"$cityCode\"\n" +
                "){\n" +
                "giftwraps {category\n" +
                "giftWrapsData{\n" +
                "entity_id\n" +
                "created_at\n" +
                "status\n" +
                "name\n" +
                "price{\n" +
                "currency\n" +
                "value\n" +
                "}\n" +
                "image\n" +
                "}\n" +
                "}\n" +
                "giftcards {\n" +
                "entity_id\n" +
                "created_at\n" +
                "status\n" +
                "name\n" +
                "price{\n" +
                "currency\n" +
                "value\n" +
                "}\n" +
                "image\n" +
                "}\n" +
                "}\n" +
                 "}"

        fun addGiftToCartQuery(
            customer_cart: String,
            wrap_id: Int,
            card_id: Int,
            sender_name: String,
            receiver_name: String,
            gift_message: String,
            cart_item_id: String
        ) = "mutation {\n" +
                "  addGiftWrapToCart(\n" +
                "    cartId: \"$customer_cart\"\n" +
                "    wrapItems: {\n" +
                "wrap_id: $wrap_id\n" +
                "card_id: $card_id\n" +
                "sender_name:\"$sender_name\"\n" +
                "receiver_name:\"$receiver_name\"\n" +
                "      gift_message: \"$gift_message\"\n" +
                "      is_receipt_hidden: 1\n" +
                "      finish:1\n" +
                "      action: \"add\"\n" +
                "      existing_wrap_id: 0\n" +
                "      itemsIds: [\n" +
                "        {\n" +
                "          id: $cart_item_id\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ) {\n" +
                "    cart {\n" +
                "      wrapping_items{\n" +
                "      entity_id\n" +
                "      wrap_id\n" +
              //  "      card_id\n" +
                "      gift_message\n" +
                "receiver_name\n" +
                "sender_name\n" +
                "      wrap_name\n" +
                "      quote_item_ids{\n" +
                "        id\n" +
                "        Qty\n" +
                "      }\n" +
                "    }\n" +
                "      items {\n" +
                "      id\n" +
                "      product {\n" +
                "        name\n" +
                "        sku\n" +
                "      }\n" +
                "      quantity\n" +
                "    }\n" +
                "      prices {\n" +
                "      grand_total {\n" +
                "        value\n" +
                "        currency\n" +
                "      }\n" +
                "    }\n" +
                "    }\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "\n"

        fun removeGiftToCartQuery(
            customer_cart: String,
            wrap_id: Int,
           // card_id: Int,
            sender_name: String? = "",
            receiver_name: String? = "",
            gift_message: String? = "",
            cart_item_id: String? = "",
            existing_wrap_id: Int
        ) = "mutation {\n" +
                "  addGiftWrapToCart(\n" +
                "    cartId: \"$customer_cart\"\n" +
                "    wrapItems: {\n" +
                "wrap_id: $wrap_id\n" +
               // "card_id: $card_id\n" +
                "sender_name:\"$sender_name\"\n" +
                "receiver_name:\"$receiver_name\"\n" +
                "      gift_message: \"$gift_message\"\n" +
                "      is_receipt_hidden: 1\n" +
                "      finish:1\n" +
                "      action: \"remove\"\n" +
                "      existing_wrap_id: $existing_wrap_id\n" +
                "      itemsIds: [\n" +
                "        {\n" +
                "          id: $cart_item_id\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ) {\n" +
                "    cart {\n" +
                "      wrapping_items{\n" +
                "      entity_id\n" +
                "      wrap_id\n" +
              //  "      card_id\n" +
                "      gift_message\n" +
                "receiver_name\n" +
                "sender_name\n" +
                "      wrap_name\n" +
                "      quote_item_ids{\n" +
                "        id\n" +
                "        Qty\n" +
                "      }\n" +
                "    }\n" +
                "      items {\n" +
                "      id\n" +
                "      product {\n" +
                "        name\n" +
                "        sku\n" +
                "      }\n" +
                "      quantity\n" +
                "    }\n" +
                "      prices {\n" +
                "      grand_total {\n" +
                "        value\n" +
                "        currency\n" +
                "      }\n" +
                "    }\n" +
                "    }\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "\n"

        fun updateGiftToCartQuery(
            customer_cart: String,
            wrap_id: Int,
            card_id: Int,
            sender_name: String,
            receiver_name: String,
            gift_message: String,
            cart_item_id: String,
            old_wrap_id: Int
        ) = "mutation {\n" +
                "  addGiftWrapToCart(\n" +
                "    cartId: \"$customer_cart\"\n" +
                "    wrapItems: {\n" +
                "wrap_id: $wrap_id\n" +
                "card_id: $card_id\n" +
                "sender_name:\"$sender_name\"\n" +
                "receiver_name:\"$receiver_name\"\n" +
                "      gift_message: \"$gift_message\"\n" +
                "      is_receipt_hidden: 1\n" +
                "      finish:1\n" +
                "      action: \"update\"\n" +
                "      existing_wrap_id: $old_wrap_id\n" +
                "      itemsIds: [\n" +
                "        {\n" +
                "          id: $cart_item_id\n" +
                "        }\n" +
                "      ]\n" +
                "    }\n" +
                "  ) {\n" +
                "    cart {\n" +
                "      wrapping_items{\n" +
                "      entity_id\n" +
                "      wrap_id\n" +
               // "      card_id\n" +
                "      gift_message\n" +
                "receiver_name\n" +
                "sender_name\n" +
                "      wrap_name\n" +
                "      quote_item_ids{\n" +
                "        id\n" +
                "        Qty\n" +
                "      }\n" +
                "    }\n" +
                "      items {\n" +
                "      id\n" +
                "      product {\n" +
                "        name\n" +
                "        sku\n" +
                "      }\n" +
                "      quantity\n" +
                "    }\n" +
                "      prices {\n" +
                "      grand_total {\n" +
                "        value\n" +
                "        currency\n" +
                "      }\n" +
                "    }\n" +
                "    }\n" +
                "  }\n" +
                "}\n" +
                "\n" +
                "\n"

        fun getRemoveItemFromCartQuery(cartId: String, cart_item_uid: String) = "mutation {\n" +
                "  removeItemFromCart(\n" +
                "    input: {\n" +
                "      cart_id: \"$cartId\"\n" +
                "     cart_item_uid: \"$cart_item_uid\"\n" +
                "    }\n" +
                "  ) {\n" +
                "    cart {\n" +
                "      items {\n" +
                "        id\n" +
                "source_code\n" +
                "quantity\n" +
                "},\n" +
                "prices{\n" +
                "grand_total{\n" +
                "currency\n" +
                "formatted_price\n" +
                "}\n" +
                "}\n" +
                "    }\n" +
                "  }\n" +
                "}\n"

        fun getUpdateItemFromCartQuery(cartId: String, cart_item_uid: String, count: Int) =
            "mutation {\n" +
                    "  updateCartItems(\n" +
                    "    input: {\n" +
                    "      cart_id: \"$cartId\"\n" +
                    "cart_items:[{cart_item_uid:\"$cart_item_uid\",quantity:$count}]\n" +
                    "    }\n" +
                    "  ) {\n" +
                    "    cart {\n" +
                    "      items {\n" +
                    "        id\n" +
                    "source_code\n" +
                    "quantity\n" +
                    "},\n" +
                    "prices{\n" +
                    "grand_total{\n" +
                    "currency\n" +
                    "formatted_price\n" +
                    "}\n" +
                    "}\n" +
                    "    }\n" +
                    "  }\n" +
                    "}\n"

        fun getCountryCurrencyQuery() =
            "query getCurrency{currency{base_currency_code default_display_currency_code}}"
    }


}