package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class ConditionsX(
    @SerializedName("conditions")
    val conditions: Map<Int,MapValueXXXX>,
    @SerializedName("set")
    val `set`: String,
    @SerializedName("set_value")
    val setValue: String
)