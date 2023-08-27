package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class AddToCartResponse(
    @SerializedName("cart_ids")
    val cartIds: Map<String,Int>?=null
)