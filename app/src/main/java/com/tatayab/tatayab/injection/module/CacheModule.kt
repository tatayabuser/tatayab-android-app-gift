package com.tatayab.tatayab.injection.module

import android.content.Context
import com.tatayab.cache.TatayabCacheImpl
import com.tatayab.cache.db.TatayabPrefrencesDatabase
import com.tatayab.cache.db.TatayabRoomDatabase
import com.tatayab.data.TatayabDataRepository
import com.tatayab.data.repository.TatayabCache
import com.tatayab.domain.repository.TatayabRepository
import dagger.Binds

import dagger.Module
import dagger.Provides


@Module
class CacheModule {

    @Provides
    fun providesTatayabPrefrencesDatabase(context: Context): TatayabPrefrencesDatabase {
        return TatayabPrefrencesDatabase.getInstance(context)
    }

    @Provides
    fun providesTatayabRoomDatabase(context: Context): TatayabRoomDatabase {
        return TatayabRoomDatabase.getInstance(context)
    }


    @Provides
    fun providesTatayabCache(tatayabCache: TatayabCacheImpl): TatayabCache = tatayabCache

}
