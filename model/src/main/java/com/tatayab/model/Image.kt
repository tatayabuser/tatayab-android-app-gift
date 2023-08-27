package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class Image(
    @SerializedName("detailed_id")
    val detailedId: String,
    @SerializedName("icon")
    val icon: Icon,
    @SerializedName("image_id")
    val imageId: String,
    @SerializedName("pair_id")
    val pairId: String,
    @SerializedName("position")
    val position: String
)