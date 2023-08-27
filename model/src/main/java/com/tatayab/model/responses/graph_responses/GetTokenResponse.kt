package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class GetTokenResponse (@SerializedName("data") val data: GetTokenModel):BaseGrapgQlResponse(){
    class GetTokenModel (@SerializedName("generateCustomerToken") val generateCustomerToken: GenerateCustomerTokenModel)
    class GenerateCustomerTokenModel (@SerializedName("token") val token: String)
    }


/*{
  "data": {
    "generateCustomerToken": {
      "token": "6g3zzdi3lb8cxyt8i6lhv8l8oohxmnlk"
    }
  }
}*/