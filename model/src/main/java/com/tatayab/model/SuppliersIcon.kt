package com.tatayab.model

import com.google.gson.annotations.SerializedName

data class SuppliersIcon(
    @SerializedName("absolute_path") val absolute_path: String,
    @SerializedName("alt") val alt: String,
    @SerializedName("http_image_path") val http_image_path: String,
    @SerializedName("https_image_path") val https_image_path: String,
    @SerializedName("image_path") val image_path: String,
    @SerializedName("image_x") val image_x: String,
    @SerializedName("image_y") val image_y: String,
    @SerializedName("relative_path") val relative_path: String,
    @SerializedName("url") val url: String
)