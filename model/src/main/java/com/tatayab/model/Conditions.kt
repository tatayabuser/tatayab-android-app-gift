package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class Conditions(
    @SerializedName("condition")
    val condition: List<Any>
)