package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class GiftItemCartRequest(
    @SerializedName("product_id")
    val product_id: String = "",
    var cartID: String? = "",
    var sender_name: String? = "",
    var recipient_name: String? = "",
    var gift_message: String? = "",
    var productGraphID: String? = "",
    var localAction: String? ="",
    var productUID: String? = "",
    var oldWrapId: Int? = 0,
    var wrap_id: Int? = 0
) {
    var action: String = Action.update.toString()
}


/*   customer_cart: String,
            wrap_id: Int,
            old_wrap_id: Int,
            sender_name: String? = "",
            receiver_name: String? = "",
            gift_message: String? = "",
            cart_item_id: String? = ""*/






