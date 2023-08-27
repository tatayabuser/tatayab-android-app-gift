package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class ChangePasswordGraphResponse(@SerializedName("data") val customerDataModel: CustomerDataModel? = null) :
    BaseGrapgQlResponse() {
    class CustomerDataModel(@SerializedName("changeCustomerPassword") val changeCustomerPassword: ChangeCustomerPasswordModel? = null)
    class ChangeCustomerPasswordModel(@SerializedName("id") val id: Int? = 0,@SerializedName("email") val email: String? = "")

}
/*{
  "data": {
    "changeCustomerPassword": {
      "id": 1,
      "email": "roni_cost@example.com"
    }
  }
}*/