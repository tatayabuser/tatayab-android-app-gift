package com.tatayab.cache.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tatayab.cache.SingletonHolder
import com.tatayab.cache.dao.CachedAddressDao
import com.tatayab.cache.dao.CachedUserDao
import com.tatayab.cache.dao.CachedWishDao
import com.tatayab.cache.model.CachedAddress
import com.tatayab.cache.model.CachedUser
import com.tatayab.cache.model.CachedWishItem


@Database(
    entities = arrayOf(
        CachedAddress::class,
        CachedUser::class,
        CachedWishItem::class
    ),
    version = 7
)
abstract class TatayabRoomDatabase : RoomDatabase() {

    abstract fun cachedAddressesDao(): CachedAddressDao
    abstract fun cachedUserDao(): CachedUserDao
    abstract fun cachedWishDao(): CachedWishDao


    companion object : SingletonHolder<Context, TatayabRoomDatabase>({
        Room.databaseBuilder(
            it.applicationContext,
            TatayabRoomDatabase::class.java,
            "tatayab_DB.db"
        ).fallbackToDestructiveMigration().build()
    })
}
