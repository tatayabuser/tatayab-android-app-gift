package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class CheckVersionResponse(
    @SerializedName("error") val error: String?=null,
    @SerializedName("status") val status: String?=null
)