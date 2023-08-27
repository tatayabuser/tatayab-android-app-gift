package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class RegisterationResponse (@SerializedName("data") val data:RegisterModel):BaseGrapgQlResponse(){


    class RegisterModel(@SerializedName("createCustomerV2") val mCreateCustomerModel:CreateCustomerModel)
    class CreateCustomerModel(@SerializedName("customer") val mCustomerModel:CustomerModel)
    class CustomerModel(@SerializedName("email") val email:String,@SerializedName("firstname") val firstname:String
                        ,@SerializedName("lastname") val lastname:String,@SerializedName("is_subscribed") val isSubscribed:Boolean
                        ,@SerializedName("phone_number") val phoneNumber:String
                        ,@SerializedName("id") val id:Int)



    /*{
  "data": {
    "createCustomerV2": {
      "customer": {
        "firstname": "Bob",
        "lastname": "Loblaw",
        "email": "psoldev5555522@gmail.com",
        "is_subscribed": true,
        "phone_number": "456789321"
      }
    }
  }
}*/
}