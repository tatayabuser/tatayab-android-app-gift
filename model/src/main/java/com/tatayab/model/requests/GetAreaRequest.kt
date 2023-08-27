package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class GetAreaRequest(
    @SerializedName("lang_code")
    val lang_code: String,
    @SerializedName("country_code")
    val country_code: String ,
    @SerializedName("city_id")
    val city_id: Int,
    @SerializedName("city_code")
    val city_code: String
)


//"lang_code":"en",
//"country_code": "KW"
//"city_id": 61
