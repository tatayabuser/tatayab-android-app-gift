package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class MapValueXXXXXX(
    @SerializedName("link_id")
    val linkId: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("usergroup_id")
    val usergroupId: String
)