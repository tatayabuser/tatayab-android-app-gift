package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue
import com.tatayab.model.WishListValue

data class WishListActionRequest(
    @SerializedName("product_options")
    val product_options: Map<String, String>? = null,
    @SerializedName("user_id")
    val userId: String = "-1",
    @SerializedName("product_id")
    val product_id: String = "",
    @SerializedName("action")
    val action: String = "",
    @SerializedName("country_code")
    val country_code: String = "",
    @SerializedName("lang_code")
    val lang_code: String = "",
    var wishListId: String? = "",
    val productWishListId: String? = "",
    val sku: String = "",
    var isGraphEnable: Boolean? = false

)