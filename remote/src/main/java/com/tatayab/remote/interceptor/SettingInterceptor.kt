package com.tatayab.remote.interceptor

import android.util.Log
import com.tatayab.data.source.TatayabCacheDataSource
import com.tatayab.model.responses.CountryResponse
import com.tatayab.remote.util.Constants.Companion.API_New_VERSION_NUMBER
import com.tatayab.utiles.CountryMemoryCacheManager
import okhttp3.Interceptor
import okhttp3.Response
import java.util.*
import javax.inject.Inject

class SettingInterceptor @Inject constructor(
    private val tatayabCacheDataSource: TatayabCacheDataSource
) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val originalHttpUrl = request.url()
        val urlBuilder = originalHttpUrl.newBuilder()

        // if (CountryMemoryCacheManager.getCountryCode().isNullOrEmpty())
        val countryCode = CountryMemoryCacheManager.getCountryCode()
        val currencyId = CountryMemoryCacheManager.getCurrencyId()
        val mCountryFromCache =
            tatayabCacheDataSource.getUserSettingFromCache().blockingGet().country
        if (!originalHttpUrl.toString().contains(API_New_VERSION_NUMBER)) {
            urlBuilder.addQueryParameter(
                "currency_id",
                if (currencyId.isNullOrEmpty()) mCountryFromCache?.currency_id else currencyId
            )
        }
        urlBuilder.addQueryParameter(
            "country_code",
            if (countryCode.isNullOrEmpty()) mCountryFromCache?.code else countryCode
        )
        tatayabCacheDataSource.getcurrentLanguageFromCache().blockingGet()?.let {
            urlBuilder.addQueryParameter(
                "sl", it
            )
            urlBuilder.addQueryParameter(
                "lang_code", it
            )
            Log.d("https: ", "sl Query: $it")
        }

        val url = urlBuilder.build()
        val requestBuilder = request.newBuilder().url(url)
        Log.d("http: ", "Header")
        requestBuilder.addHeader("osused", "android")
        requestBuilder.addHeader("Store", getStoreInfo(mCountryFromCache))

        tatayabCacheDataSource.getUserFromCache().blockingGet().token.let {
            requestBuilder.addHeader("Api-Key", it)
            if (originalHttpUrl.toString().contains("magento") || originalHttpUrl.toString().contains("graphql")) {
                requestBuilder.header("Authorization", "Bearer $it")
                Log.d("http: Authorization ==>", "Bearer $it")
            }
            Log.d("http: Api-Key ==> ", it + "")
        }
        tatayabCacheDataSource.getUserAuthFromCache().blockingGet()?.let {
            requestBuilder.addHeader("token", it.token.toString())
            requestBuilder.addHeader("session", it.session.toString())
            requestBuilder.addHeader("devid", it.devid.toString())
            Log.d("http: token ==> ", it.token + "")
            Log.d("http: session ==> ", it.session + "")
            Log.d("http: devid ==> ", it.devid + "")
        }
        val finalRequest = requestBuilder.build()
        return chain.proceed(finalRequest)
    }

    private val gccCountries = listOf("SA", "KW", "AE", "BH", "OM", "QA")
    private fun getStoreInfo(mCountryFromCache: CountryResponse?): String {

        return if (gccCountries.contains(mCountryFromCache?.code?.toUpperCase(Locale.ROOT)))
        mCountryFromCache?.code?.toLowerCase(Locale.ROOT) + "-" + tatayabCacheDataSource.getcurrentLanguageFromCache()
                .blockingGet()
        else tatayabCacheDataSource.getcurrentLanguageFromCache().blockingGet()
    }

}

