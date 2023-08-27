package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class DefaultLocation(
    @SerializedName("address")
    val address: String,
    @SerializedName("city")
    val city: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("country_descr")
    val countryDescr: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("state")
    val state: String,
    @SerializedName("zipcode")
    val zipcode: String
)