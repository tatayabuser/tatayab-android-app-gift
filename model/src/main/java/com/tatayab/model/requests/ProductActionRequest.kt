package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class ProductActionRequest(

    @SerializedName("country_code")
    val country_code: String? = null,
    @SerializedName("action")
    val action: String = "notify_me",
    @SerializedName("lang_code")
    val lang_code: String? = null,
    @SerializedName("user_id")
    val user_id: String? = null,
    @SerializedName("product_id")
    val product_id: String? = null,
    @SerializedName("device_id")
    val device_id: String? = null,
    @SerializedName("token")
    val token: String? = null,
    var email: String? = null
)