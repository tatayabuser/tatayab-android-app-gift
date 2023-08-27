package com.tatayab.model.filter


import com.google.gson.annotations.SerializedName

data class Variant(
    @SerializedName("variant_id")
    val variantId: String?="",
    @SerializedName("variant_name")
    val variantName: String?="",
    var isChecked: Boolean = false
)