package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName

data class GetOrdersCountInCartRequest(
    @SerializedName("user_id")
    val userId :Int=0,
    @SerializedName("device_id")
    val device_id :String="0",
    @SerializedName("lang_code")
    val lang_code :String="",
    @SerializedName("country_code")
    val country_code :String="",
    var cartId :String?= ""
){
    @SerializedName("action")
    val action :String=Action.cart_total_products.toString()

}


/*
* {


    "user_id":13770,
    "device_id":15,
    "lang_code":"en",
    "country_code": "KW",
    "action": "cart_total_products"
}
* */






