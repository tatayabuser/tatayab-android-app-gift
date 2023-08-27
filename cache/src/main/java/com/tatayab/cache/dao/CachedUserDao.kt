package com.tatayab.cache.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import com.tatayab.cache.model.CachedUser

@Dao
abstract class CachedUserDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun saveUser(user: CachedUser)

}
