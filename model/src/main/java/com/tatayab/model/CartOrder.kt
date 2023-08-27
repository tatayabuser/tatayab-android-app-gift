package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class CartOrder(
    @SerializedName("amount")
    val amount: String,
    @SerializedName("product_id")
    val productId: String,
    @SerializedName("product_options")
    val productOptions: Map<String, String>? = null
)