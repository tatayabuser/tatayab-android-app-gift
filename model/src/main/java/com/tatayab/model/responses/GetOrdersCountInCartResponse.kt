package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class GetOrdersCountInCartResponse(
    @SerializedName("total_cart_products")
    val totalCartProducts:Int = 0
)



/*
* {"total_cart_products":2}
* */