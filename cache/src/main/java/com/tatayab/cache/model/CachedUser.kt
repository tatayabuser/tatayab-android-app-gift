package com.tatayab.cache.model

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.tatayab.cache.constants.UserConstants.COLUMN_USER_ID
import com.tatayab.cache.constants.UserConstants.TABLE_NAME


@Entity(tableName = TABLE_NAME)
data class CachedUser(
    @PrimaryKey(autoGenerate = false)
    @ColumnInfo(name = COLUMN_USER_ID)
    @NonNull
    var id: String,
    var fname: String,
    var lname: String
)