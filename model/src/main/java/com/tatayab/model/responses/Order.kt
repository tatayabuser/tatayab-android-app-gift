package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName


data class Order(
    @SerializedName("date") val date: String,
    @SerializedName("lastStatus") val lastStatus: OrderStatues,
    @SerializedName("order_id") val order_id: String,
    @SerializedName("products_image") val products_image: List<ProductsImage>,
    @SerializedName("total") var total: Float,
    var currency: String
)


data class ProductsImage(
    @SerializedName("image") val image: String,
    @SerializedName("product_id") val product_id: String


//{
//    "order_number": "000000001",
//    "id": 1,
//    "created_at": "2019-02-21 00:24:34",
//    "grand_total": 36.39,
//    "status": "processing"
//},
)