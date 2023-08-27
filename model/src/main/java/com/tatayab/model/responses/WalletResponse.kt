package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.RawValue

class WalletResponse(
    @SerializedName("data")
    var mWalletData: WalletData? = null,
    @SerializedName("status")
    var status: Int,
    @SerializedName("msg")
    var message: String = "") {
}

/*{
  "data": {
     "aval_amount": <available_balance>, (string)
     "pen_amount": <pending_balance> (string)
  },
  "status": <request_status> (1 for success 0 for error)
}*/