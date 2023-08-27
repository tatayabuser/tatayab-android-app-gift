package com.tatayab.model.base

import com.google.gson.annotations.SerializedName


data class BaseResponseModel<out T : Any>(
    val data: T? = null,
    @SerializedName("message")
    val message: String?,
    @SerializedName("status")
    val status: Int?
)