package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class GetOrdersFromCartResponse(
    @SerializedName("products")
    val products: List<CartOrderResponse>? = null,
    @SerializedName("total_cart_products")
    val totalCartProducts: Int = 0,
    @SerializedName("subtotal")
    val subTotal: Float? = 0f,
    @SerializedName("notes")
    val notes: String? = "",
    @SerializedName("cart_message")
    val cartMessage: String? = "",
    @SerializedName("recipient_name")
    val recipient_name: String? = "",
    @SerializedName("sender_name")
    val sender_name: String? = "",
    @SerializedName("gift_message")
    val gift_message: String? = "",
    @SerializedName("message")
    var errorMessage: String =" ",
    var giftItemId: Int? = 0,
    var currentSelectedWrapId: Int? = 0

){
}



/*
* {"products":[
* {"product_id":418,
* "title":"Tatera - 500ml",
* "supplier_id":"19",
* "supplier_name":"Tatera",
* "price":6,"image":"https:\/\/main.tatayab.com\/images\/detailed\/1\/TATERA.jpg",
* "product_options":[],
* "amount":1,
* "inWishlist":false},
* {"product_id":421,"title":"Oud - 500ml","supplier_id":"19","supplier_name":"Tatera","price":6,"image":"https:\/\/main.tatayab.com\/images\/detailed\/1\/OUD.jpg","product_options":[],"amount":1,"inWishlist":false}],
* "subtotal":12,"total_cart_products":2}


* */