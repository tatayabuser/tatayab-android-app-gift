package com.tatayab.remote.service


import com.tatayab.model.responses.*
import com.tatayab.remote.util.Constants
import com.tatayab.remote.util.Constants.Companion.VERSION_1_0
import io.reactivex.Flowable
import retrofit2.http.*

interface UserTatayabServiceEndPoint {

    @POST(VERSION_1_0.plus(Constants.NEW_TOKEN_END_POINT))
    fun getUserToken(
        @Header("osused") osused: String,
        @Header("session") session: String,
        @Header("devid") devid: String
    ): Flowable<UserTokenResponse>

    @GET(VERSION_1_0.plus(Constants.NEW_TOKEN_END_POINT))
    fun updateUserTokenWithCountryOrLanguage(
        @Query("country") country_code: String,
        @Query("lang") lang_code: String
     ): Flowable<UserUpdateTokenResponse>


  @GET(VERSION_1_0.plus(Constants.LOGOUT_END_POINT))
    fun logout(): Flowable<LogoutResponse>

}