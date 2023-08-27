package com.tatayab.cache.constants

object WishItemConstants {

    const val TABLE_NAME = "WishListTable"
    const val COLUMN_ID = "Id"
    const val COLUMN_USER_ID = "userId"
    const val COLUMN_PRODUCT_ID = "productId"
    const val COLUMN_COUNTRY_ID = "countryId"
    const val COLUMN_CART_ID = "cartId"

    const val QUERY_ALL_WISH_LIST = "SELECT * FROM $TABLE_NAME"
    const val QUERY_ALL_WISH_LIST_PER_COUNTRY = "SELECT * FROM $TABLE_NAME " +
            "WHERE  $COLUMN_COUNTRY_ID LIKE :countryId"

    const val QUERY_GET_WISH_ITEM_PER_PRODUCT_ID_AND_COUNRY_ID = "SELECT * FROM $TABLE_NAME " +
            "WHERE  $COLUMN_COUNTRY_ID LIKE :countryId AND $COLUMN_PRODUCT_ID LIKE :productId"

    const val QUERY_EXISTS = "SELECT EXISTS(SELECT 1 FROM $TABLE_NAME)"

    const val DELETE_WISH_LIST_TABLE = "DELETE FROM $TABLE_NAME"


    const val DELETE_WISH_ITEM_BY_PRODUCT_ID_AND_COUNTRY_ID = "DELETE FROM $TABLE_NAME WHERE " +
            "$COLUMN_PRODUCT_ID = :productId AND $COLUMN_COUNTRY_ID = :countryId"

    const val DELETE_ALL_WISH_LIST_BY_COUNTRY_ID = "DELETE FROM $TABLE_NAME WHERE " +
            "$COLUMN_COUNTRY_ID = :countryId"

    const val CHECK_IF_EXISTS = "select COUNT($COLUMN_PRODUCT_ID) FROM $TABLE_NAME WHERE " +
            "$COLUMN_PRODUCT_ID = :productID AND $COLUMN_COUNTRY_ID = :countryId AND $COLUMN_USER_ID = :userId"

    const val INSERT_WISH_ITEM_ =
        "INSERT INTO $TABLE_NAME ($COLUMN_USER_ID,$COLUMN_PRODUCT_ID ,$COLUMN_COUNTRY_ID, $COLUMN_CART_ID)"

}
