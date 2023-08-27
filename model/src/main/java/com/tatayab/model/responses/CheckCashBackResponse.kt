package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class CheckCashBackResponse(@SerializedName("status") val status :Int, @SerializedName("msg") val errorMessage:String="", @SerializedName("data") val mCashBackModel: CashBackModel ) {
 class CashBackModel(@SerializedName("amount") val amount :Double,@SerializedName("expired_date") val expiredDate :String,  @SerializedName("msg") val message:String="",  @SerializedName("status") val status:String="")


    enum class CashBackStatusEnum{
        completed,pending
    }
}


