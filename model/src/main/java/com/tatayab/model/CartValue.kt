package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class CartValue(
    @SerializedName("amount")
    var amount: String?=null,
    @SerializedName("product_id")
    val productId: String,
    @SerializedName("product_options")
    var productOptions: Map<String, String>? = null
)