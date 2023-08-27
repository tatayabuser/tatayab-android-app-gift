package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class AddProductWithOptionsToCartResponse (@SerializedName("data") val data: AddProductToCartModel):BaseGrapgQlResponse(){
    class AddProductToCartModel (@SerializedName("addBundleProductsToCart") val addBundleProductsToCart: AddBundleProductsToCartModel)
    class AddBundleProductsToCartModel (@SerializedName("cart") val cartModel: AddProductToCartResponse.CartModel)
}
/*{"data":{"addBundleProductsToCart":
{"cart":{"items":[{"id":"4024","product":{"sku":"MUB-003-F078","stock_status":"OUT_OF_STOCK"},"quantity":1},{"id":"4025","product":{"sku":"ABJ-001-A019","stock_status":"IN_STOCK"},"quantity":1},{"id":"4026","product":{"sku":"ABJ-001-A028","stock_status":"IN_STOCK"},"quantity":1},{"id":"4032","product":{"sku":"MUB-002-F084","stock_status":"IN_STOCK"},"quantity":1},{"id":"4036","product":{"sku":"TTB-007-X066","stock_status":"IN_STOCK"},"quantity":1}]}}}}
*/