package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class MapValueXX(
    @SerializedName("country_codes")
    val countryCodes: Map<String,CountryCodes>,
    @SerializedName("name")
    val name: String
)