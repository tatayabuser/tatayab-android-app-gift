package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class AddGuestEmailToCartResponse (@SerializedName("data") val data: DataModel):BaseGrapgQlResponse(){
    class DataModel (@SerializedName("setGuestEmailOnCart") val setGuestEmailOnCart:SetGuestEmailOnCartModel)
    class SetGuestEmailOnCartModel (@SerializedName("cart") val cartModel:CartModel)
    class CartModel (@SerializedName("email") val email:String)
    }


/*{
  "data": {
    "setGuestEmailOnCart": {
      "cart": {
        "email": "guest@example.com"
      }
    }
  }
}*/