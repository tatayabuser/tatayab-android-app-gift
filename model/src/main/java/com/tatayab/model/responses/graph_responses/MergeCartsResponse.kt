package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class MergeCartsResponse (@SerializedName("data") val data: DataModel):BaseGrapgQlResponse(){
    class DataModel (@SerializedName("mergeCarts") val mergeCartsModel: MergeCartsModel?)
    class MergeCartsModel (@SerializedName("items") val itemsList: ArrayList<ItemModel>?)
    class ItemModel (@SerializedName("id") val id:String?="",@SerializedName("product") val productModel:ProductModel?)
    class ProductModel (@SerializedName("name") val name:String?="",@SerializedName("sku") val sku:String?="")
}
/*{
  "data": {
    "mergeCarts": {
      "items": [
        {
          "id": "14",
          "product": {
            "name": "Overnight Duffle",
            "sku": "24-WB07"
          },
          "quantity": 2
        },
        {
          "id": "17",
          "product": {
            "name": "Radiant Tee",
            "sku": "WS12"
          },
          "quantity": 1
        }
      ]
    }
  }
}*/