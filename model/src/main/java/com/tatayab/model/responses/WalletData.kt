package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class WalletData (
    @SerializedName("aval_amount")
    var avalAmount: String?="",
    @SerializedName("pen_amount")
    var penAmount: String?="",
    var currencyCode: String? = ""
)


/*"data": {
     "aval_amount": <available_balance>, (string)
     "pen_amount": <pending_balance> (string)
  },*/