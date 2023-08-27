package com.tatayab.tatayab.util

import com.tatayab.tatayab.R

object Constants {

     val HOME_FRAGMENTS = arrayOf(
        R.id.destination_categories,
        R.id.destination_cart,
        R.id.destination_wishlist,
        R.id.destination_account,
         R.id.countryFragment
     )

    val HOME_FRAGMENTS_BACK = arrayOf(
        R.id.destination_categories,
        R.id.destination_cart,
        R.id.destination_wishlist,
        R.id.destination_account,
        R.id.destination_home,
        R.id.destination_splash
    )
    val PAYMENT_FRAGMENTS_BACK = arrayOf(
        R.id.payment_fragment
    )

    val HIDE_BOTTOM_NAVIGATION_FRAGMENTS = arrayOf(
        R.id.destination_splash,
        R.id.checkout_fragment,
        R.id.destination_productdetails,
        R.id.destination_login,
        R.id.destination_register,
        R.id.destination_forgetpassword,
        R.id.wallet_destination
    )

     val CUSTOM_TOOLBAR_FRAGMENTS = arrayOf(
        R.id.destination_splash,
        R.id.destination_home,
        R.id.destination_login,
        R.id.destination_register,
        R.id.destination_forgetpassword
    )
    const val AUTOCOMPLETE_REQUEST_CODE = 3
    const val LOCATION_PERMISSION_REQUEST_CODE = 152
    const val PICK_LOCATION_ACTIVITY_REQUEST_CODE = 123
    const val ADD_ADDRESS_ACTIVITY_REQUEST_CODE = 122
    const val UPDATE_ACCOUNT_REQUEST_CODE = 121
    const val REQUEST_CODE_ASK_LOCATION_PERMISSIONS = 120
    const val REGISTRATION_ACTIVITY_REQUEST_CODE = 101
    const val ACCOUNT_KIT_REQUEST_CODE = 99

    const val FIRST_NAME = "first_name"
    const val LAST_NAME = "last_name"


    const val ARG_CATEGORY_ID = "category_id"
    const val IS_LOGGED_IN = "is_logged_in"


    const val LOGIN = "login"
    const val CARTITEMS = "cartItems"
    const val USER_PROFILE = "USER_PROFILE"
    const val UPDATE_PROFILE = "UPDATE_PROFILE"
    const val USER_EMAIL = "USER_EMAIL"
    const val FROM_REGISTER = "FROM_REGISTER"
    const val REQUEST_CODE_LOG_IN = 103
    const val ADDRESS_ID = "ADDRESS_ID"
    const val ADDRESS_SELECTED = 133

    const val REQUEST_CODE_LOGIN_ACTIVITY = 154

    const val REGISTER = "register"
    const val REQUEST_CODE_REGISTER = 104

    const val REQUEST_CODE_CART_LOGIN_RESULT: Int = 145


    const val EDIT_PROFILE = "edit_profile"
    const val REQUEST_CODE_EDIT_PROFILE = 125
    const val ADDRESS_RESULT = "address"

    const val REQUEST_CODE_SELECT_ADDRESS = 128
    const val ADD_NEW_ADDRESS_REQUEST = 888
    const val SELECT_ADDRESS = "select_address"

    const val SORT_FRAGMENT = "sort_fragment"
    const val REQUEST_CODE_SORT = 141

    const val FILTER_FRAGMENT = "filter_fragment"
    const val FILTER_PARENT_INDEX = "FILTER_PARENT_INDEX"
    const val FILTER_OPTIONS_VALUES = "FILTER_OPTIONS_VALUES"
    const val REQUEST_CODE_FILTER = 142
    const val REQUEST_CODE_FILTER_OPTIONS = 143

    const val SORT_BY = "sort_by"
    const val SORT_TYPE = "sort_type"
    const val PARAMETERS = "sort_parameters"
    const val SCROLL_UP_ACTION = "SCROLL_UP_ACTION"
    const val CHANGE_WISHLIST_CASE = "CHANGE_WISHLIST_CASE"
    const val CHANGE_RECENT_VIEW = "CHANGE_RECENT_VIEW"
    const val PRODUCT_ID = "PRODUCT_ID"
    const val CLEAR_RECENT_VIEW = "CLEAR_RECENT_VIEW"
    const val NEW_STATEUES = "NEW_STATEUES"
    const val PRODUCT = "product"
    const val GRAPH_CATEGORY_UID_KEY = "category_uid"
    const val GRAPH_CATEGORY_ID_KEY = "category_id"
    const val GRAPH_BRANDS_KEY = "manufacturer"
    const val LIST_GRAPH_ACTION = "list_graph_action"

    const val BASE_URL = "https://tatayab.com/"
    const val TERMES_CONDITION = "terms-and-conditions-mobile?sl="
    const val TERMES_CONDITION_NEW = "/terms"//total url : https://tatayab.com/KW-en/terms
    const val RETURN_POLICY = "return-policy-mobile?sl="
    const val RETURN_POLICY_NEW = "/delivery"
    const val PRIVACY_POLICY = "privacy-policy-mobile?sl="
    const val PRIVACY_POLICY_NEW = "/privacy-policy"// total url : https://tatayab.com/KW-ar/privacy


    const val ADD_TO_CART = "add_to_carts"
    const val PLACE_ORDER = "place_order"
    const val FROM_CHECKOUT = "fromCheckout"
    const val SELECTED_ADDRESS = "SELECTED_ADDRESS"
    const val ADD_NEW_ADDRESS = "ADD_NEW_ADDRESS"
    const val ADD_NEW_ADDRESS_VALUE = "ADD_NEW_ADDRESS"

    const val CANCEL = "I"
    const val FAILD = "F"
    const val RETURN = "G"
    const val PLACED = "P"

    const val REQUEST_CODE_LOG_OUT = 105

    const val EMAIL = "email"
    const  val PUBLIC_PROFILE = "public_profile"
    const val USER_ID = "id"
    const val USER_FIRST_NAME = "first_name"
    const val USER_LAST_NAME = "last_name"
    const val FILEDS = "fields"

    // Deeplinks
    const val DEEPLINK_SCHEME = "tatayabdlink"

    const val SHIPPING_COST_KEY = "shippingCost"
    const val TAXES_KEY = "Taxes"
    const val GIFT_COST_KEY = "GIFT_COST_KEY"
    const val CREDIT_KEY = "CREDIT"
    const val SUB_TOTAL_KEY = "Sub_Total"
    const val TOTAL_PRICE_KEY = "Total_Price"

}