package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class MapValueXXXX(
    @SerializedName("condition")
    val condition: String,
    @SerializedName("operator")
    val `operator`: String,
    @SerializedName("value")
    val value: String
)