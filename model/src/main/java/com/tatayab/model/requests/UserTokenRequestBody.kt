package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName

data class UserTokenRequestBody(
    @SerializedName("user_id")
    val userId: String? = null,
    @SerializedName("token")
    val token: String? = null
)