package com.tatayab.model.requests

import com.google.gson.annotations.SerializedName

class RedeemCodeRequest(@SerializedName("coupon") var coupon:String = "")

/*    "{
    ""coupon"": <coupon_code>
}"*/