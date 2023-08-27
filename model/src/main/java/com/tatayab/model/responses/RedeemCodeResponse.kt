package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class RedeemCodeResponse(@SerializedName("status") val status :Int, @SerializedName("msg") val errorMessage:String="", @SerializedName("data") val mRedeemCodeModel: RedeemCodeModel ) {
}
/*"{
""status"": 1,
""data"": {
    ""msg"": ""coupon_applied"",
    ""new_bal"": ""115 KWD""
}
}"*/