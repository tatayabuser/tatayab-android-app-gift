package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class SelectAddressResponse(
    @SerializedName("msg") val msg: String,
    @SerializedName("success") val success: Int
)