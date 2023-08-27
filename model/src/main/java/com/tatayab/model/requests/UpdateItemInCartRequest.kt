package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class UpdateItemInCartRequest(
    @SerializedName("product_id")
    val product_id :String="",
    @SerializedName("product_options")
    val product_options: Map<String, String>? = null,
    @SerializedName("user_id")
    val userId :Int=-1,
    @SerializedName("device_id")
    val device_id :String="-1",
    @SerializedName("lang_code")
    val lang_code :String="",
    @SerializedName("country_code")
    val country_code :String="",
    @SerializedName("amount")
    val amount :Int?=0,
    var productUID: String? = "",
    var cartID: String? = ""

){
    @SerializedName("action")
    val action :String=Action.update.toString()

}


/*
* {

    "product_id":"2414",
    "product_options":[],
    "user_id":13770,
    "device_id":15,
    "lang_code":"en",
    "country_code": "KW",
    "amount": 2,
    "action": "add"
}
* */






