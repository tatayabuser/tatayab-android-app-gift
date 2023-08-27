package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class CustomDuties(
    @SerializedName("cart_total_threshold")
    val cartTotalThreshold: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String
)