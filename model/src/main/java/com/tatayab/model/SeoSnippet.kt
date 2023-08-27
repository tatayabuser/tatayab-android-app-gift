package com.tatayab.model


import com.google.gson.annotations.SerializedName

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Serializable
data class SeoSnippet(
    @SerializedName("availability")
    val availability: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Float,
    @SerializedName("price_currency")
    val priceCurrency: String,
    @SerializedName("show_price")
    val showPrice: Boolean,
    @SerializedName("sku")
    val sku: String
)