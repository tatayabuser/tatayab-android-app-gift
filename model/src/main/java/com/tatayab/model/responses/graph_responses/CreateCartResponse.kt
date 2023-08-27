package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class CreateCartResponse (@SerializedName("data") val data: CreateCartModel):BaseGrapgQlResponse(){
    class CreateCartModel (@SerializedName("customerCart") val customerCart: CustomerCartModel)
    class CustomerCartModel (@SerializedName("id") val id: String)
}
/*{
  "data": {
    "customerCart": {
      "id": "pXVxnNg4PFcK1lD60O5evqF7f4SkiRR1"
    }
  }
}*/