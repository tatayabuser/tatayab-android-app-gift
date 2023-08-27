package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class CartActionRequest(

    @SerializedName("country_code")
    val country_code: String? = null,
    @SerializedName("action")
    val action: String = "check_avail",
    @SerializedName("products")
    val products: Map<String, CartValue>
)