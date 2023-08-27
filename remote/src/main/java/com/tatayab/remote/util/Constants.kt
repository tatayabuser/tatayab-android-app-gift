package com.tatayab.remote.util

open class Constants {
    companion object {
        const val API_VERSION_NUMBER = "api/4.0/"
        const val API_New_VERSION_NUMBER = "api/5.0/"
        const val CATEGORIES = "TtmCategories"
        const val TTTCATEGORIESACTIONS = "TtmCategoryActions"
        const val TOKENGENERATOR = "TtmTokenGenerator"
        const val USERNAME = "android@tatayab.com"
        const val PASSWORD = "5r53d11lJ594w0V1418z3J3JH71ow38T"
        const val PRODUCTS = "TtmProducts"
        const val PRODUCT_BY_ID = "TtmProducts/{id}"
        const val PRODUCTS_BY_IDS = "TtmProducts/"
        const val LOGIN = "TtmAuth"
        const val CUSTOMER_ALSO_BOUGHT = "TtmBlocks/77"
        const val FORGET_PASSWORD = "TtmForgetPass"
        const val USERS = "TtmUsers"
        const val GET_PROFILE = "$USERS/{userId}"
        const val TRENDS_BLOCK_ID = "313"
        const val FEATURES_PRODUCTS_BLOCK_ID = "314"
        const val SLIDER_BLOCK_ID = "312"
        const val HOME_FRAGRANCES_BLOCK_ID = "270"
        const val FRENCH_PERFUM_BLOCK_ID = "316"
        const val MINI_WORLD_BLOCK_ID = "317"
        const val MUBKHARS_BLOCK_ID = "265"
        const val PERSONAL_CARE_BLOCK_ID = "272"
        const val BUKHAR_BLOCK_ID = "270"
        const val SUPPLIERS = "TtmSuppliers"
        const val BLOCKS = "TtmBlocks/"
        const val COUNTRIES = "TtmCountries"
        const val CURRENCIES = "TtmCurrencies"
        const val CART = "TtmCartContent/"
        const val CITIES = "TtmCityArea/"
        const val CLEAR_CART = "TtmCartContent"
        const val CART_CONFIG = "ttm_cart_config_data"
        const val CONCIERGE = "TtmConcierge"
        const val REVIEWS_BY_PRODUCT_ID = "TtmReviews/{productId}"
        const val REVIEWS = "TtmReviews"
        const val UPDATE_AMOUNT = "$CART{productId}"
        const val ORDERS_WITH_DASH = "TtmOrders/"
        const val ORDERS_BY_ID = "TtmOrders"
        const val ORDER_STATUS = "TtmOrderActions"
        const val ADDRESS = "TtmAddress"
        const val ORDERS = "TtmUserOrders"
        const val WISHLIST = "TtmWishList"
        const val TtmWishlistActions = "TtmWishlistActions"
        const val CREATE_ORDER = "stores/1/TtmOrders/"
        const val FILTER = "TtmProductsFilters"
        const val SET_FIREBASE_TOKEN = "TtmUsersToken"
        const val SAVE_FIREBASE_TOKEN_ENDPOINT = "TtmFirebaseTokens"
        const val VERSION_CHECK = "TtmMobileUpgradeChecker"
        const val PROMOTION = "TtmPromotions/"
        const val CARTACTION = "TtmCartActions/"
        const val TtmProductsActions = "TtmProductsActions"
        const val TtmCategoriesBanners = "TtmCategoriesBanners"
        const val LAYOUT_BLOCKS = "TtmLayoutBlocks"
        const val BLOCK_LAYOUT = "TtmBlocks/{blockId}"
        const val LOG_COUNTRY_HOLDER = "country"
        const val TTMBANNERS = "TtmBanners"
        const val LOG_CURRENCY_HOLDER = "currency"
        const val LOG_LANG_CODE_HOLDER = "lang_code"
        const val USER_ID_HOLDER = "User ID"
        const val EMAIL_HOLDER = "EMAIL"
        const val USER_NAME_HOLDER = "UserName"
        const val SUPPORT_EMAIL = "Info@tatayab.com"
        const val SUPPORT_NUMBER = "+96522250074"

        // Server Data
        const val PROMOTION_END_PINT = "TtmPromotions"
        var CURRENT_SERVER_URL =  "https://tatayab.com/"   // "https://alpha.tatayab.com/"
        var CURRENT_SERVER_USER = "android@tatayab.com"
        var Debug_Server_Url="https://magento-dev.tatayab.com/"

        const val GRAPH_QL_SERVER = "https://magento-dev.tatayab.com/graphql/"
        var ENABLE_GRAPH_QUERIES_CALLS = true
        const val LIST_GRAPH_ACTION = "list_graph_action"
        const val LIST_GRAPH_ACTION_ID = "LIST_GRAPH_ACTION_ID"
        const val FEATURES_HASH = "features_hash"
        const val PRICE_FROM = "price_from"
        const val PRICE_TO = "price_to"
        const val sort_by = "sort_by"
        const val sort_order = "sort_order"

        const val WALLET_SERVER_URL_DEV = "https://wallet-dev.tatayab.com/"
        const val WALLET_SERVER_URL = "https://walletapi.tatayab.com/"
        var CURRENT_WALLET_SERVER_URL = WALLET_SERVER_URL

        const val SEARCH_URL = "https://productapi.tatayab.com/v1.0/"
        const val SEARCH_URL_DEV = "https://products-dev.tatayab.com/v1.0/"
        var CURRENT_SEARCH_URL = SEARCH_URL

        var USER_SERVER_URL_DEV = "https://users-dev.tatayab.com/"
        const val USER_SERVER_URL = "https://usersapi.tatayab.com/"
        var CURRENT_USER_SERVER_URL = USER_SERVER_URL

        const val VERSION_1_0 = "v1.0/"
        var CURRENT_SERVER_PASS = "5r53d11lJ594w0V1418z3J3JH71ow38T"
        const val URL_ACTION_END_POINT = "TtmURLActions"
        const val SOCISL_MEDIA_LOGIN_END_POINT = "TtmSocialAuth"
        const val MY_WALLET_END_POINT = "my_wallet"
        const val TRANSACTIONS_HISTORY_END_POINT = "history"
        const val NEW_TOKEN_END_POINT = "token"
        const val REDEEM_CODE_END_POINT = "coupons/static/redeem"
        const val LOGOUT_END_POINT = "auth/logout"
        const val TTMUSERPROFILE = "TtmUsersProfile"
        const val GetUserProfile = "TtmUsersProfile/{userId}"
        const val searchEndPoint = "search?"
        const val INVITE_FRIEND_ENDPOINT = "invite"
        const val CHECK_EARN_ENDPOINT = "check_earn"
        const val CHECK_CASH_BACK_ENDPOINT = "my_wallet/check-cash-back?"
        const val PRODUCT_ID = "product_id"
        const val ACTION = "action"
        const val ALSO_BOUGHT_ACTION = "calb"
        const val GRAPH_IN_STOCK = "IN_STOCK"

        const val SHIPPING_COST_KEY = "shippingCost"
        const val GIFT_COST_KEY = "GIFT_COST_KEY"
        const val TAXES_KEY = "Taxes"
        const val SUB_TOTAL_KEY = "Sub_Total"
        const val TOTAL_PRICE_KEY = "Total_Price"
    }


}