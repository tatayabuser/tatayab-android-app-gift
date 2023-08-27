package com.tatayab.model

import com.google.gson.annotations.SerializedName

data class CountryCodes(
    @SerializedName("country_codes")
    val countryCodes: Map<String, String>
)
