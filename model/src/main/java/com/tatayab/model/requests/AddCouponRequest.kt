package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class AddCouponRequest(
    @SerializedName("user_id")
    val userId :Int=0,
    @SerializedName("device_id")
    val device_id :String="0",
    @SerializedName("lang_code")
    val lang_code :String="",
    @SerializedName("country_code")
    val country_code :String="",
    @SerializedName("coupon_code")
    val coupon_code :String="",
    @SerializedName("cartId")
    val cartId :String=""
){
    @SerializedName("action")
    val action :String=Action.applied_coupon.toString()
}


/*
{
  "country_code": "KW",
  "action": "applied_coupon",
  "device_id": "C9DF3E22-95C7-4E4B-923A-987275440FA0",
  "lang_code": "en",
  "user_id": "30224",
  "coupon_code": "aaaaaaaaa"
}

ل
* */






