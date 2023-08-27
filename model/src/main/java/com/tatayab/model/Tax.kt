package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class Tax(
    @SerializedName("custom_duties")
    val customDuties: CustomDuties,
    @SerializedName("vat")
    val vat: Vat
)