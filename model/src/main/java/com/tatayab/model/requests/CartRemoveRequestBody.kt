package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName

data class CartRemoveRequestBody(
    @SerializedName("cart_id")
    val cartId: String? = "",
    @SerializedName("user_id")
    val userId: String
)