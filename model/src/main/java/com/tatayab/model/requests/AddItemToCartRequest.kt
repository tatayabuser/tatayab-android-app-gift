package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class AddItemToCartRequest(
    @SerializedName("product_id")
    val product_id: String = "",
    @SerializedName("product_id")
    val product_id2: String = "",
    @SerializedName("product_options")
    val product_options: Map<String, String>? = null,
    @SerializedName("user_id")
    val userId: Int = -1,
    @SerializedName("device_id")
    val device_id: String = "-1",
    @SerializedName("lang_code")
    val lang_code: String = "",
    @SerializedName("country_code")
    val country_code: String = ""
) {
    @SerializedName("action")
    var action: String = Action.add.toString()

    @SerializedName("is_gift")
    var is_gift = 0

    @SerializedName("amount")
    var amount = 0

    @SerializedName("sl")
    var sl: String = ""

    @SerializedName("sender_name")
    var sender_name: String = ""

    @SerializedName("recipient_name")
    var recipient_name: String = ""

    @SerializedName("gift_message")
    var gift_message: String = ""
    var cartID: String = ""
    var cartProductID: String = ""
    var old_wrap_id: Int? = 0

}


/*
* {

    "product_id":"2414",
    "product_options":[],
    "user_id":13770,
    "device_id":15,
    "lang_code":"en",
    "country_code": "KW",
    "action": "add"
}
* */






