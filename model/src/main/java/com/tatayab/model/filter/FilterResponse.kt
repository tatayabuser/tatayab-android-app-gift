package com.tatayab.model.filter


import com.google.gson.annotations.SerializedName

data class FilterResponse(
    @SerializedName("features")
    val features: List<FilterMapValue>,
    @SerializedName("prices") val prices :Prices

)

data class Prices(
    @SerializedName("min") val min : String,
    @SerializedName("max") val max :String
)

