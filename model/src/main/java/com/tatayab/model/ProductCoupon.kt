package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class ProductCoupon(
    @SerializedName("product_id")
    val product_id: String
)