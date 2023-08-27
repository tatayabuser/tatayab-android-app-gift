package com.tatayab.cache.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.ForeignKey.NO_ACTION
import androidx.room.PrimaryKey
import com.tatayab.cache.constants.AddressConstants.COLUMN_ADDRESS_ID
import com.tatayab.cache.constants.AddressConstants.COLUMN_IS_PRIMARY_ADDRESS
import com.tatayab.cache.constants.AddressConstants.COLUMN_USER_ID
import com.tatayab.cache.constants.AddressConstants.TABLE_NAME


//@Entity(tableName = TABLE_NAME)
//@Entity(foreignKeys = arrayOf(ForeignKey(entity = CachedAddress::class, parentColumns = "id", childColumns = "userId", onDelete = CASCADE)))

@Entity(
    tableName = TABLE_NAME
    ,
    foreignKeys = arrayOf(
        ForeignKey(
            entity = CachedUser::class,
            parentColumns = arrayOf("id"),
            childColumns = arrayOf("userId"),
            onDelete = NO_ACTION
        )
    )
)
data class CachedAddress(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = COLUMN_ADDRESS_ID)
    var addressId: Long,
    @ColumnInfo(name = COLUMN_USER_ID)
    var userId: String,
    var title: String,
    var shippingAddress: String,
    var billingAddress: String,
    var city: String,
    var country: String,
    var zipCode: String,
    @ColumnInfo(name = COLUMN_IS_PRIMARY_ADDRESS)
    var isPrimary: Boolean
)