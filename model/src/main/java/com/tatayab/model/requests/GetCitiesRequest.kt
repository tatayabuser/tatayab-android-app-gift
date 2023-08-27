package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class GetCitiesRequest(
    @SerializedName("lang_code")
    val lang_code: String,
    @SerializedName("country_code")
    val country_code: String
)


//"lang_code":"en",
//"country_code": "KW"
