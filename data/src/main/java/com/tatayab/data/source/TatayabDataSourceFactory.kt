package com.tatayab.data.source

import com.tatayab.data.repository.TatayabDataSource
import javax.inject.Inject

open class TatayabDataSourceFactory @Inject constructor(
    private val tatayabCacheDataSource: TatayabCacheDataSource,
    private val tatayabRemoteDataSource: TatayabRemoteDataSource
) {
    open fun getRemoteDataSource(): TatayabDataSource {
        return tatayabRemoteDataSource
    }

    open fun getCacheDataSource(): TatayabDataSource {
        return tatayabCacheDataSource
    }
}
