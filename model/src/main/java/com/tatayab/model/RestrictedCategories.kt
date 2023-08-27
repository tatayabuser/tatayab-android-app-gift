package com.tatayab.model


import com.google.gson.annotations.SerializedName

import kotlinx.serialization.*
import kotlinx.serialization.json.*

data class RestrictedCategories(
    @SerializedName("country_codes")
    val countryCodes: Map<String,CountryCodes>,
    @SerializedName("name")
    val name: String
)