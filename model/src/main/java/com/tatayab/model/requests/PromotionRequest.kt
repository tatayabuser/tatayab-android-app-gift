package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName

data class PromotionRequest(
    @SerializedName("shipping_id")
    val shippingId: List<Int>? = null,
    @SerializedName("type")
    val type: String? = null,
    @SerializedName("user_id")
    val userId: Int? = null
)