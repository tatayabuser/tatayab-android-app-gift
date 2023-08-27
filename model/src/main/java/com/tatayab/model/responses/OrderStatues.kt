package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName


data class OrderStatues(
    @SerializedName("applied") val applied: Boolean?=null,
    @SerializedName("name") val name: String,
    @SerializedName("status") val status: String?=null,
    @SerializedName("timestamp") val timestamp: String?=null
)
