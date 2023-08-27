package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class ReviewCartRequest(
    @SerializedName("user_id")
    val userId :Int=0,
    @SerializedName("device_id")
    val device_id :String="0",
    @SerializedName("lang_code")
    val lang_code :String="",
    @SerializedName("country_code")
    val country_code :String="",
    @SerializedName("address_id")
    val address_id :String="",
    @SerializedName("cartId")
    val cartId :String=""
){
    @SerializedName("action")
    val action :String=Action.review_pay.toString()
}


/*
{
  "device_id": "3E7FA553-F9BB-40E3-8C7A-F3885F09DDDB",
  "user_id": "",
  "action": "review_pay",
  "country_code": "KW",
  "lang_code": "en"
}
* */






