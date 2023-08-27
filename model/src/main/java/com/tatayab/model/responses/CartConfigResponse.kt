package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName
import com.tatayab.model.PaymentMethod
import com.tatayab.model.Shipping
import com.tatayab.model.Tax

data class CartConfigResponse(
    @SerializedName("payment_methods")
    val paymentMethods: List<PaymentMethod>,
    @SerializedName("shipping")
    val shipping: Shipping,
    @SerializedName("tax")
    val tax: Tax
)