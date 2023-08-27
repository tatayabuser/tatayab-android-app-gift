package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName

data class UpdateProductAmountRequest(
    @SerializedName("amount")
    val amount: String,
    @SerializedName("product_options")
    val productOptions: Map<String,String>?=null,
    @SerializedName("user_id")
    val userId: String
)