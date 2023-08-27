package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class RedeemCodeModel(@SerializedName("msg") val message :String="", @SerializedName("new_bal") val new_bal:String="") {
}
/*"{
""status"": 1,
""data"": {
    ""msg"": ""coupon_applied"",
    ""new_bal"": ""115 KWD""
}
}"*/