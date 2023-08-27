package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class AddItemToCartResponse(
    @SerializedName("success")
    var success:Int?=0,
    @SerializedName("msg")
    var msg:String?="",
    @SerializedName("total_cart_products")
    var totalCartProducts:Int = 0,
    @SerializedName("subtotal")
    var subTotal: Float?=0f
){
    var cartProductID:String?= ""
}



/*
* {"success":1,"msg":"_data_added_successfully","subtotal":30.5,"total_cart_products":1}
* */