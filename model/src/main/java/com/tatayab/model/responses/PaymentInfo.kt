package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName


data class PaymentInfo(
    @SerializedName("order_status") val order_status: String
)
