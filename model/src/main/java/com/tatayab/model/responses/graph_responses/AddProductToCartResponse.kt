package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class AddProductToCartResponse (@SerializedName("data") var data: AddProductToCartDataModel?=null):BaseGrapgQlResponse(){
    class AddProductToCartDataModel (@SerializedName("addSimpleProductsToCart") var addSimpleProductsToCartModel: AddSimpleProductsToCartModel)
    class AddSimpleProductsToCartModel (@SerializedName("cart") var cartModel: CartModel)
    class CartModel (@SerializedName("items") var productList: List<ProductItemModel>,
        @SerializedName("prices") val mPriceModel:PriceModel?)

    class PriceModel (
        @SerializedName("grand_total") val grandTotalModel: GrandTotalModel?
    )
    class GrandTotalModel (
        @SerializedName("currency") val currency: String?="",
        @SerializedName("value") val value: Float?=0f
    )
    class ProductResponseModel (@SerializedName("sku") var sku: String,@SerializedName("stock_status") var stock_status: String)
    class ProductItemModel (@SerializedName("id") var id: String ,@SerializedName("product") var productResponseModel: ProductResponseModel,
                            @SerializedName("quantity") var quantity: Int,@SerializedName("total_quantity") var total_quantity: Int)

}
/*{
  "data": {
    "addSimpleProductsToCart": {
      "cart": {
        "items": [
          {
            "id": "2545",
            "product": {
              "name": "Lavender - 100ml",
              "sku": "MUB-001-F050"
            },
            "quantity": 5
          },
          {
            "id": "2562",
            "product": {
              "name": "Sultanie Eau De Parfum - 100ML - Unisex",
              "sku": "ABJ-001-A028"
            },
            "quantity": 3
          },
          {
            "id": "2563",
            "product": {
              "name": "Athnen - 250ml",
              "sku": "ABJ-002-A002"
            },
            "quantity": 1
          }
        ]
      }
    }
  }
}*/