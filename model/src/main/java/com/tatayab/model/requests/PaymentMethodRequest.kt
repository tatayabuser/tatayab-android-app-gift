package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class PaymentMethodRequest(
    @SerializedName("user_id")
    val userId :Int=0,
    @SerializedName("device_id")
    val device_id :String="0",
    @SerializedName("lang_code")
    val lang_code :String="",
    @SerializedName("country_code")
    val country_code :String="",
    @SerializedName("payment_id")
    val payment_id :Int=0,
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("cartID")
    val cartID: String? = null
){
    @SerializedName("action")
    val action :String=Action.selected_payment.toString()
}


/*
{
  "country_code": "KW",
  "action": "selected_payment",
  "device_id": "C9DF3E22-95C7-4E4B-923A-987275440FA0",
  "lang_code": "en",
  "user_id": "30224",
  "payment_id": 6
}

ل
* */






