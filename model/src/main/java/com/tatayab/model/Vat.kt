package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class Vat(
    @SerializedName("type")
    val type: String,
    @SerializedName("value")
    val value: String
)