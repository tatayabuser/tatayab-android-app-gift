package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class MapValue(
    @SerializedName("a_surcharge")
    val aSurcharge: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("instructions")
    val instructions: String,
    @SerializedName("p_surcharge")
    val pSurcharge: String,
    @SerializedName("payment")
    val payment: String,
    @SerializedName("script")
    val script: String,
    @SerializedName("surcharge_title")
    val surchargeTitle: String,
    @SerializedName("template")
    val template: String
)