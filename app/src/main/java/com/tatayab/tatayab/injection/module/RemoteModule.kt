package com.tatayab.tatayab.injection.module


import android.content.Context
import com.tatayab.data.repository.TatayabRemote
import com.tatayab.data.source.TatayabCacheDataSource
import com.tatayab.remote.TatayabRemoteImpl
import com.tatayab.remote.interceptor.ConnectivityInterceptor
import com.tatayab.remote.interceptor.SettingInterceptor
import com.tatayab.remote.service.*
import com.tatayab.remote.util.Constants.Companion.CURRENT_SERVER_URL
import com.tatayab.remote.util.Constants.Companion.CURRENT_USER_SERVER_URL
 import com.tatayab.remote.util.Constants.Companion.CURRENT_WALLET_SERVER_URL
import com.tatayab.remote.util.Constants.Companion.Debug_Server_Url
import com.tatayab.remote.util.Constants.Companion.USER_SERVER_URL_DEV
import com.tatayab.remote.util.Constants.Companion.WALLET_SERVER_URL_DEV
import com.tatayab.tatayab.BuildConfig
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RemoteModule {


    @Provides
    @Singleton
    fun provideConnectivityInterceptor(context: Context): ConnectivityInterceptor {
        return ConnectivityInterceptor(context)
    }

    @Provides
    @Singleton
    fun provideSettingInterceptor(repository: TatayabCacheDataSource): SettingInterceptor {
        return SettingInterceptor(repository)
    }


    @Provides
    fun provideQraphQlTatayabService(
        context: Context,
        repository: TatayabCacheDataSource
    ): QraphQlServiceEndPoint {
        return TatayabServiceFactory.makeQraphQlTatayabService(
            BuildConfig.DEBUG,
            context,
            repository
        )
    }

    @Provides
    fun provideTatayabService(
        context: Context,
        repository: TatayabCacheDataSource
    ): TatayabServiceEndPoint {
        var APIUrl = BuildConfig.API_URL
        if (BuildConfig.DEBUG) {
            //APIUrl = CURRENT_SERVER_URL
            APIUrl= Debug_Server_Url
        }
        return TatayabServiceFactory.makeTatayabService(
            BuildConfig.DEBUG,
            APIUrl,
            context,
            repository
        )
    }
    @Provides
    fun provideWalletTatayabService(
        context: Context,
        repository: TatayabCacheDataSource
    ): WalletTatayabServiceEndPoint {
        var APIUrl = CURRENT_WALLET_SERVER_URL

        if (BuildConfig.DEBUG) {
            //APIUrl = CURRENT_SERVER_URL
            APIUrl= WALLET_SERVER_URL_DEV
        }

        return TatayabServiceFactory.makeWalletTatayabService(
            BuildConfig.DEBUG,
            APIUrl,
            context,
            repository
        )
    }
    @Provides
    fun provideUserTatayabService(
        context: Context,
        repository: TatayabCacheDataSource
    ): UserTatayabServiceEndPoint {
        var APIUrl = CURRENT_USER_SERVER_URL

        if (BuildConfig.DEBUG) {
            //APIUrl = CURRENT_SERVER_URL
            APIUrl= USER_SERVER_URL_DEV
        }

        return TatayabServiceFactory.makeUserTatayabService(
            BuildConfig.DEBUG,
            APIUrl,
            context,
            repository
        )
    }

    @Provides
    fun bindTatayabRemote(tatayabRemote: TatayabRemoteImpl): TatayabRemote = tatayabRemote


}
