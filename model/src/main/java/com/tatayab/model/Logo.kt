package com.tatayab.model

import com.google.gson.annotations.SerializedName

data class Logo(
    @SerializedName("detailed_id") val detailed_id: String,
    @SerializedName("icon") val icon: SuppliersIcon,
    @SerializedName("image_id") val image_id: String,
    @SerializedName("pair_id") val pair_id: String,
    @SerializedName("position") val position: String
)
