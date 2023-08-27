package com.tatayab.cache.constants

object UserConstants {

    const val TABLE_NAME = "user"

    const val COLUMN_USER_ID = "id"

    const val QUERY_USERS = "SELECT * FROM $TABLE_NAME +" +
            "WHERE  $COLUMN_USER_ID = :userId"

    const val QUERY_EXISTS = "SELECT EXISTS(SELECT 1 FROM $TABLE_NAME)"

    const val DELETE_USER = "DELETE FROM $TABLE_NAME"

    const val DELETE_ADDRESSES_BY_ID = "DELETE FROM $TABLE_NAME WHERE " +
            "$COLUMN_USER_ID = :userId"

}
