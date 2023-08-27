package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class DeleteItemFromCartRequest(
    @SerializedName("product_id")
    val product_id: String = "",
    @SerializedName("user_id")
    val userId: Int = -1,
    @SerializedName("device_id")
    val device_id: String = "-1",
    @SerializedName("lang_code")
    val lang_code: String = "",
    @SerializedName("country_code")
    val country_code: String = "",
    var cartID: String? = "",
    var sender_name: String? = "",
    var recipient_name: String? = "",
    var gift_message: String? = "",
    var productGraphID: String? = "",
    var localAction: String? ="",
    var existsWrapId: Int? = 0,
    var productUID: String? = "") {
    @SerializedName("action")
    var action: String = Action.delete.toString()
}


/*
* {


    "product_id":"2414",
    "user_id":13770,
    "device_id":15,
    "lang_code":"en",
    "country_code": "KW",
    "action": "delete"
}
*
* mutation {
  removeItemFromCart(
    input: {
      cart_id: "IeTUiU0oCXjm0uRqGCOuhQ2AuQatogjG",
      cart_item_id: 14
    }
  )
 {
  cart {
    items {
      id
      product {
        name
      }
      quantity
    }
    prices {
      grand_total{
        value
        currency
      }
    }
  }
 }
}
* */






