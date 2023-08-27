package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartOrder

data class CreateOrderRequest(
    @SerializedName("user_id")
    val userId: String? = null,
    @SerializedName("payment_id")
    val paymentId: String? = null,
    @SerializedName("shipping_id")
    val shippingId: String? = null,
    @SerializedName("coupon_code")
    val couponCode: String? = null,
    @SerializedName("o_address_id")
    val oAddressId: String? = null,
    @SerializedName("notes")
    val notes: String? = "",
    @SerializedName("country_code")
    val countryCode: String? = "",
    @SerializedName("products")
    val products: Map<String, CartOrder>? = null
)