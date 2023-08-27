package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName

data class SaveFirebaseTokenRequestBody(
    @SerializedName("user_id")
    val userId: Int? = 0,
    @SerializedName("firebase_token")
    val token: String? = ""
)

