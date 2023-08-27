package com.tatayab.model.filter


import com.google.gson.annotations.SerializedName

data class FilterMapValue(
    @SerializedName("feature_id")
    val featureId: String?="",
    @SerializedName("feature_name")
    val featureName: String?="",
    @SerializedName("variants")
    val variants: List<Variant>?=null,
    var isSelectedBefore : Boolean = false
)