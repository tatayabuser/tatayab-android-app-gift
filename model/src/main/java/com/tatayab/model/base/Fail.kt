package com.tatayab.model.base


import com.google.gson.annotations.SerializedName

data class Fail(
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
)