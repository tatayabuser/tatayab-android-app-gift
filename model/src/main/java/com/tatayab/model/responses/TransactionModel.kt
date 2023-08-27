package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class TransactionModel(
    @SerializedName("id")
    var id: Int? = 0,
    @SerializedName("date")
    var date: String? = "",
    @SerializedName("operation")
    var operation: String? = "",
    @SerializedName("amount")
    var amount: String? = "",
    @SerializedName("title")
    var title: String? = "" ,
    @SerializedName("status")
    var status: String? = "",
    @SerializedName("expiry_date")
    var expiry_date: String? = ""
) {
}

/*{
     {
            "id": 81,
            "date": "Wed 10 Feb, 2021 02:44:00PM",
            "operation": "+",
            "amount": "3 KWD",
            "title": "Cashback from order #4197537",
            "expiry_date": "Will expire after 31 Days",
            "status": "a"
        },
   },*/