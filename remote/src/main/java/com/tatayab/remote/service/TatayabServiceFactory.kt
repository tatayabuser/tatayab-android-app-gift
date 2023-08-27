package com.tatayab.remote.service

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.readystatesoftware.chuck.ChuckInterceptor
import com.tatayab.data.source.TatayabCacheDataSource
import com.tatayab.model.base.BaseResponseModel
import com.tatayab.model.common.OldSSlFactory
import com.tatayab.remote.interceptor.BasicAuthInterceptor
import com.tatayab.remote.interceptor.ConnectivityInterceptor
import com.tatayab.remote.interceptor.SettingInterceptor
import com.tatayab.remote.util.Constants
import com.tatayab.remote.util.ResponseDeserializer
import kotlinx.serialization.json.Json
import okhttp3.*
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Converter
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import java.util.*
import java.util.concurrent.TimeUnit
import javax.net.ssl.TrustManagerFactory
import javax.net.ssl.X509TrustManager


object TatayabServiceFactory {
    fun makeTatayabService(
        isDebug: Boolean,
        baseUrl: String,
        context: Context,
        repository: TatayabCacheDataSource
    ): TatayabServiceEndPoint {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug),
            BasicAuthInterceptor(
                if (isDebug) Constants.CURRENT_SERVER_USER else "android@tatayab.com",
                if (isDebug) Constants.CURRENT_SERVER_PASS else "5r53d11lJ594w0V1418z3J3JH71ow38T"

            ),
            ConnectivityInterceptor(context),
            SettingInterceptor(repository),
            context,
            isDebug
        )
        return makeService(okHttpClient, baseUrl)
    }

    fun makeQraphQlTatayabService(
        isDebug: Boolean,
         context: Context,
        repository: TatayabCacheDataSource
    ): QraphQlServiceEndPoint {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug),
            BasicAuthInterceptor(
                if (isDebug) Constants.CURRENT_SERVER_USER else "android@tatayab.com",
                if (isDebug) Constants.CURRENT_SERVER_PASS else "5r53d11lJ594w0V1418z3J3JH71ow38T"

            ),
            ConnectivityInterceptor(context),
            SettingInterceptor(repository),
            context,
            isDebug
        )
        return makeQraphQlService(okHttpClient)
    }


    fun makeWalletTatayabService(
        isDebug: Boolean,
        baseUrl: String,
        context: Context,
        repository: TatayabCacheDataSource
    ): WalletTatayabServiceEndPoint {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug),
            BasicAuthInterceptor(
                if (isDebug) Constants.CURRENT_SERVER_USER else "android@tatayab.com",
                if (isDebug) Constants.CURRENT_SERVER_PASS else "5r53d11lJ594w0V1418z3J3JH71ow38T"

            ),
            ConnectivityInterceptor(context),
            SettingInterceptor(repository),
            context,
            isDebug
        )
        return makeWalletService(okHttpClient, baseUrl)
    }

    fun makeUserTatayabService(
        isDebug: Boolean,
        baseUrl: String,
        context: Context,
        repository: TatayabCacheDataSource
    ): UserTatayabServiceEndPoint {
        val okHttpClient = makeOkHttpClient(
            makeLoggingInterceptor(isDebug),
            BasicAuthInterceptor(
                if (isDebug) Constants.CURRENT_SERVER_USER else "android@tatayab.com",
                if (isDebug) Constants.CURRENT_SERVER_PASS else "5r53d11lJ594w0V1418z3J3JH71ow38T"

            ),
            ConnectivityInterceptor(context),
            SettingInterceptor(repository),
            context,
            isDebug
        )
        return makeUserService(okHttpClient, baseUrl)
    }

    private fun makeWalletService(
        okHttpClient: OkHttpClient,
        baseUrl: String
    ): WalletTatayabServiceEndPoint {
        val contentType = MediaType.get("application/json")
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(createGsonConverter())
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(WalletTatayabServiceEndPoint::class.java)
    }

    private fun makeQraphQlService(
        okHttpClient: OkHttpClient): QraphQlServiceEndPoint {
        val contentType = MediaType.get("application/json")
        val retrofit = Retrofit.Builder()
                //https://magento-dev.tatayab.com/
                //https://tatayab.com/
            //.baseUrl("https://tatayab.com/")
           .baseUrl("https://magento-dev.tatayab.com/")
            .addConverterFactory(createGsonConverter())
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(QraphQlServiceEndPoint::class.java)
    }

    private fun makeUserService(
        okHttpClient: OkHttpClient,
        baseUrl: String
    ): UserTatayabServiceEndPoint {
        val contentType = MediaType.get("application/json")
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(createGsonConverter())
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(UserTatayabServiceEndPoint::class.java)
    }

    private fun makeService(okHttpClient: OkHttpClient, baseUrl: String): TatayabServiceEndPoint {
        val contentType = MediaType.get("application/json")
        val retrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(createGsonConverter())
            .addConverterFactory(Json.asConverterFactory(contentType))
            .client(okHttpClient)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
        return retrofit.create(TatayabServiceEndPoint::class.java)
    }

    private fun makeOkHttpClient(
        httpLoggingInterceptor: HttpLoggingInterceptor,
        authInterceptor: BasicAuthInterceptor,
        connectivityInterceptor: ConnectivityInterceptor,
        settingInterceptor: SettingInterceptor,
        context: Context,
        isDebug: Boolean
    ): OkHttpClient {
        val trustManagerFactory = TrustManagerFactory.getInstance(
            TrustManagerFactory.getDefaultAlgorithm()
        )
        trustManagerFactory.init(null as KeyStore?)
        val trustManagers = trustManagerFactory.trustManagers
        if (trustManagers.size != 1 || trustManagers[0] !is X509TrustManager) {
            throw IllegalStateException(
                "Unexpected default trust managers:" + Arrays.toString(
                    trustManagers
                )
            )
        }
        val trustManager = trustManagers[0] as X509TrustManager
        if (isDebug && context != null) {
            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(ChuckInterceptor(context))
                .addInterceptor(authInterceptor)
                .addInterceptor(settingInterceptor)
                .protocols(listOf(Protocol.HTTP_1_1))
                .addInterceptor(connectivityInterceptor)
                .connectionSpecs(listOf(provideConnectionSpecs(), ConnectionSpec.CLEARTEXT))
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .sslSocketFactory(OldSSlFactory(), trustManager)
                .readTimeout(2, TimeUnit.MINUTES)
                .build()
        }
        else {
            return OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(authInterceptor)
                .addInterceptor(settingInterceptor)
                .protocols(listOf(Protocol.HTTP_1_1))
                .addInterceptor(connectivityInterceptor)
                .connectionSpecs(listOf(provideConnectionSpecs(), ConnectionSpec.CLEARTEXT))
                .connectTimeout(2, TimeUnit.MINUTES)
                .writeTimeout(2, TimeUnit.MINUTES)
                .sslSocketFactory(OldSSlFactory(), trustManager)
                .readTimeout(2, TimeUnit.MINUTES)
                .build()
        }
    }

    private fun provideConnectionSpecs(): ConnectionSpec {
        val cipherSuites = arrayListOf<CipherSuite>()

        ConnectionSpec.MODERN_TLS.cipherSuites()?.let { cipherSuites.addAll(it) }
        //ConnectionSpec.COMPATIBLE_TLS.cipherSuites()?.let { cipherSuites.addAll(it) }
        cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA);
        cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);
        cipherSuites.add(CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384)
        cipherSuites.add(CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256)
        cipherSuites.add(CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256)
        cipherSuites.add(CipherSuite.TLS_CHACHA20_POLY1305_SHA256)
        cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256)
        cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256)
        cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA)
        cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA)

        val legacyTls = ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
            .tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1)
            .cipherSuites(*cipherSuites.toTypedArray())
            .build()

        return legacyTls
    }

    private fun createGsonConverter(): Converter.Factory {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.registerTypeAdapter(BaseResponseModel::class.java, ResponseDeserializer())
        val gson: Gson = gsonBuilder.create()
        return GsonConverterFactory.create(gson)
    }

    private fun makeLoggingInterceptor(isDebug: Boolean): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = if (isDebug) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }
    }

}