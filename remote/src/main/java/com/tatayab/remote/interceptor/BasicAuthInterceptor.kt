package com.tatayab.remote.interceptor

import android.util.Log
import okhttp3.Credentials
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException

class BasicAuthInterceptor(user: String, password: String) : Interceptor {

    private val credentials: String = Credentials.basic(user, password)

     override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val authenticatedRequest = request.newBuilder()
        authenticatedRequest.header("Authorization", credentials).build()
         Log.d("http: Authorization ==>", credentials.toString())
         return chain.proceed(authenticatedRequest.build())
    }

}