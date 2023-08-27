package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class RemoveItemToCartResponse (@SerializedName("data") val data: DataModel):BaseGrapgQlResponse(){
    class DataModel (@SerializedName("removeItemFromCart") val removeItemFromCartModel: RemoveItemFromCartModel?)
    class RemoveItemFromCartModel (@SerializedName("cart") val cartModel: CartModel?)
    class CartModel (@SerializedName("items") val cartModelItems: ArrayList<ItemModel>?)


    class ItemModel (
        @SerializedName("id") val id: String?="",
        @SerializedName("source_code") val source_code: String?="",
        @SerializedName("quantity") val quantity: Int?=0
     )
}
/*{"data":{"removeItemFromCart":{"cart":{"items":[{"id":"31469","source_code":"KW-WH","quantity":2},{"id":"31470","source_code":"KW-WH","quantity":1}],"prices":{"grand_total":{"currency":"KWD","formatted_price":"KWD78.05"}}}}}}
*/