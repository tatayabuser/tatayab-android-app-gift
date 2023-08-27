package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class AddToCartRequest(
    @SerializedName("payment_id")
    val paymentId: String,
    @SerializedName("products")
    val products: Map<String, CartValue>,
    @SerializedName("user_id")
    val user_id: Int=-1
)