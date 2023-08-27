package com.tatayab.model.responses.graph_responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

open class BaseGrapgQlResponse {
    @SerializedName("errors")
    var errorsListModel:List<ErrorListModel>? = null
}
class ErrorListModel (@SerializedName("message") var message:String,@SerializedName("debugMessage") var debugMessage:String)

/*{
  "errors": [
    {
      "message": "A customer with the same email address already exists in an associated website.",
      "extensions": {
        "category": "graphql-input"
      },
      "locations": [
        {
          "line": 2,
          "column": 3
        }
      ],
      "path": [
        "createCustomerV2"
      ]
    }
  ],
  "data": {
    "createCustomerV2": null
  }
}*/