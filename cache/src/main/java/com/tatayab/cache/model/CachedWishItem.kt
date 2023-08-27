package com.tatayab.cache.model

 import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
 import com.google.gson.annotations.SerializedName
 import com.tatayab.cache.constants.WishItemConstants.COLUMN_CART_ID
 import com.tatayab.cache.constants.WishItemConstants.COLUMN_COUNTRY_ID
import com.tatayab.cache.constants.WishItemConstants.COLUMN_ID
import com.tatayab.cache.constants.WishItemConstants.COLUMN_PRODUCT_ID
import com.tatayab.cache.constants.WishItemConstants.COLUMN_USER_ID
import com.tatayab.cache.constants.WishItemConstants.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class CachedWishItem(

    @PrimaryKey
    @ColumnInfo(name = COLUMN_ID)
    val id: String = (Math.random()*5).toString(),
    @SerializedName(COLUMN_USER_ID)
    @ColumnInfo(name = COLUMN_USER_ID)
    val userId: String,
    @ColumnInfo(name =COLUMN_PRODUCT_ID )
    val produectId: String,
    @ColumnInfo(name =COLUMN_COUNTRY_ID )
    val countryId: String
    )