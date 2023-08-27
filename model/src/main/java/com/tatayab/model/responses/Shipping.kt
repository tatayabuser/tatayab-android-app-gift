package com.tatayab.model.responses

data class Shipping(
    val delivery_time: String,
    val description: String,
    val destination: String,
    val disable_payment_ids: List<String>,
    val free_shipping: Boolean,
    val group_key: Int,
    val group_name: String,
    val image: List<Any>,
    val max_weight: String,
    val min_weight: String,
    val module: Any,
    val need_shipment: Boolean,
    val rate: Double,
    val rate_calculation: String,
    val service_code: Any,
    val service_id: String,
    val service_params: List<Any>,
    val shipping: String,
    val shipping_id: String
)
