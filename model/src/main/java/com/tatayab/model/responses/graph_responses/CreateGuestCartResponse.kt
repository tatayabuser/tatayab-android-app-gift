package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class CreateGuestCartResponse (@SerializedName("data") val data: CreateCartModel):BaseGrapgQlResponse(){
    class CreateCartModel (@SerializedName("createEmptyCart") val createEmptyCartID: String)
}
/*{
  "data": {
    "createEmptyCart": "vwELd4bR9wJBE7qGsbce6q7TIgQxtHuS"
  }
}*/