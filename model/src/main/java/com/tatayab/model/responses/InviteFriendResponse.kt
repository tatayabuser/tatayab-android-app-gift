package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class InviteFriendResponse(@SerializedName("status") val status :Int, @SerializedName("msg") val errorMessage:String="", @SerializedName("data") val mInviteFriendModel: InviteFriendModel ) {
}
class InviteFriendModel(@SerializedName("credit") val credit:Double=0.0,@SerializedName("currancy") val currancy:String="",@SerializedName("min_order_subtotal") val min_order_subtotal:Double=0.0)
/*{
    "data": {
        "credit": "5",
        "min_order_subtotal": 40,
        "currancy": "USD"
    },
    "status": 1
}

{"data":{"credit":20,"min_order_subtotal":100,"currancy":"SAR"},"status":1}
*/