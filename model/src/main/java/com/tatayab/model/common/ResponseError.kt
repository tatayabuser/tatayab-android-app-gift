package com.tatayab.model.common


import com.google.gson.annotations.SerializedName
import org.json.JSONObject

data class ResponseError(
    @SerializedName("message")
    val message: String?="",
    @SerializedName("status")
    val status: Int?=999
)