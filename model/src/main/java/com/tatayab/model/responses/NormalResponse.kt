package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class NormalResponse(
    @SerializedName("msg")
    var msg: String,
    @SerializedName("success")
    var success: Int
)