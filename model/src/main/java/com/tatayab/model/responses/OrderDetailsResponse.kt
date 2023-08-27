package com.tatayab.model.responses

data class OrderDetailsResponse(
    val date: String,
    val delivery_charges: Double,
    val order_id: String,
    val payment: String,
    val products: List<ProductInOrderDetails>,
    val shipping_address: ShippingAddress,
    val total: Double,
    val currency : String
)
