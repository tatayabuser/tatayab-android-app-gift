package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class OrderTrackingResponse(
    @SerializedName("history") val history: List<StatuesHistory>,
    @SerializedName("ext_shipping") val externalShipping: ExternalShipping
)

data class ExternalShipping(
    val company: String,
    val tracking_number: String,
    val url: String
)

