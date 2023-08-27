package com.tatayab.presentation.product

object Constants {
    const val SORT_BY_TIME = "timestamp"
    const val SORT_BY_RATE = "rating_value"
    const val ASC = "ASC"
    const val DESC = "DESC"
    const val POPULARITY = "popularity"
    const val SORT_BY = "sort_by"
    const val SORT_ORDER = "sort_order"
    const val CURRENCY_ID = "currency_id"
    const val PRODUCT_ID = "product_id"
    const val USER_ID = "user_id"
    const val ACTION = "action"
    const val LIST_GRAPH_ACTION = "list_graph_action"
    const val LIST_GRAPH_ACTION_ID = "LIST_GRAPH_ACTION_ID"
    const val LIST_ACTION = "list"
    const val LASO_BOUGHT_ACTION = "calb"
    const val LANG_CODE = "lang_code"
    const val COUNTRY_CODE = "country_code"
    const val RECENT_VIEW = "recent_view"
    const val FLASH_SALE = "flash_sale"
    const val CATEGORY = "cid"
    const val RECENT_MAX_ITEMS_IN_HOME = 15

    enum class RecentAction {
        add,
        remove
    }

}