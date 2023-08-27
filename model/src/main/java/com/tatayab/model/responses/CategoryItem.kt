package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class CategoryItem(
    @SerializedName("name") val name: String,
    @SerializedName("image") val image: String?=null,
    @SerializedName("category_id") val category_id: String="",
    @SerializedName("category_uid") val category_uid: String?=null
)