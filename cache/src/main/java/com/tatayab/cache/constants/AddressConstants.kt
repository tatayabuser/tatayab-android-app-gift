package com.tatayab.cache.constants

object AddressConstants {

    const val TABLE_NAME = "address"

    const val COLUMN_USER_ID = "userId"

    const val COLUMN_ADDRESS_ID = "addressId"

    const val COLUMN_IS_PRIMARY_ADDRESS = "is_primary_address"

    //const val QUERY_ADDRESSES = "SELECT * FROM $TABLE_NAME "+
    /*
   "WHERE  $COLUMN_USER_ID = :userId"

     */

    const val QUERY_EXISTS = "SELECT EXISTS(SELECT 1 FROM $TABLE_NAME)"

    const val DELETE_ADDRESSES = "DELETE FROM $TABLE_NAME"

    const val DELETE_ADDRESSES_FOR_USER = "DELETE FROM $TABLE_NAME WHERE " +
            "$COLUMN_ADDRESS_ID = :addressId"

    const val QUERY_IS_PRIMARY_ADDRESS = "SELECT * FROM $TABLE_NAME " +
            "WHERE $COLUMN_IS_PRIMARY_ADDRESS = 1"

    const val QUERY_UPDATE_PRIMARY_ADDRESS_STATUS = "UPDATE $TABLE_NAME " +
            "SET $COLUMN_IS_PRIMARY_ADDRESS = :isPrimary WHERE " +
            "$COLUMN_ADDRESS_ID = :addressId"

    const val SELECT_ADDRESSES_FOR_USER = "SELECT * FROM $TABLE_NAME " +
            "WHERE $COLUMN_USER_ID=:userId"

    const val SELECT_ADDRESS_BY_ID = "SELECT * FROM $TABLE_NAME " +
            "WHERE $COLUMN_ADDRESS_ID = :addressId"

    const val QUERY_SET_PRIMARY_ADDRESSES_FOR_USER = "UPDATE $TABLE_NAME " +
            "SET $COLUMN_IS_PRIMARY_ADDRESS = 1 WHERE ( " +
            "$COLUMN_ADDRESS_ID = :addressId AND $COLUMN_USER_ID =:userId )"


    const val QUERY_SET_NOT_PRIMARY_ADDRESSES_FOR_USER = "UPDATE $TABLE_NAME " +
            "SET $COLUMN_IS_PRIMARY_ADDRESS = 0 WHERE ( " +
            "$COLUMN_ADDRESS_ID = :addressId AND $COLUMN_USER_ID =:userId )"


}
