package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class ProductInOrderDetails(
    @SerializedName("image") val image: String?,
    @SerializedName("name") val name: String?,
    @SerializedName("amount") val amount: Int,
    @SerializedName("supplier") val supplier: String,
     val currency : String = "",
    @SerializedName("price") var price: Float,
    @SerializedName("product_id") val product_id: String
)