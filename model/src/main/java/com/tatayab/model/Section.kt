package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class Section(
    @SerializedName("block_id")
    val blockId: String,
    @SerializedName("name")
    val name: String,
     val subTitle: String?="",
    @SerializedName("template")
    val template: String,
    @SerializedName("type")
    val type: String,
    @SerializedName("catId")
    val catId: Int,
    @SerializedName("ob_ids")
    val obIds: String?,
    @SerializedName("fs_end_time")
    val fs_end_time: String?=null
)