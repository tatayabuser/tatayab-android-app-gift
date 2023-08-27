package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class TransactionsHistoryResponse(
    @SerializedName("status")
    var status: Int ,
    @SerializedName("msg")
    var message: String? = "",
    @SerializedName("data")
    var mTransactionList: ArrayList<TransactionModel>? = null
) {
}


/*
* {
   "data": [ (Array of objects)
   {
     "id": <trans_id>, (int)
     "date": <trans_date>, (string)
     "operation": <operation>, (string) (+ or -)
     "amount": <amount>, (string)
     "title": <operation_title> (string)
   },
   {
     "id": <trans_id>, (int)
     "date": <trans_date>, (string)
     "operation": <operation>, (string) (+ or -)
     "amount": <amount>, (string)
     "title": <operation_title> (string)
   }
 ],
  "status": <request_status> (1 for success 0 for error)
}
* */