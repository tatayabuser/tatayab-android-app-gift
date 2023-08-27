package com.tatayab.model


import com.google.gson.annotations.SerializedName


data class Shipping(
    @SerializedName("delivery_time")
    val deliveryTime: String,
    @SerializedName("disable_payment_ids")
    val disablePaymentIds: List<String>,
    @SerializedName("name")
    val name: String,
    @SerializedName("per_unit")
    val perUnit: String,
    @SerializedName("rate_type")
    val rateType: String,
    @SerializedName("rate_value")
    val rateValue: String,
    @SerializedName("shipping_id")
    val shippingId: String
)