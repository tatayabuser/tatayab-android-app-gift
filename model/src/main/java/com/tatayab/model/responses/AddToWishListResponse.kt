package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class AddToWishListResponse(
    @SerializedName("msg") val msg: String = "",
    @SerializedName("success") val success: Int,
    var productPosition: Int = 0,
    var productWishListId: Int = 0,
    var productID: String = "0",
    var newStatues: Int = 0
) {
    var productName: String = ""
    var categoryId: String = ""
    var categoryName: String = ""
}
