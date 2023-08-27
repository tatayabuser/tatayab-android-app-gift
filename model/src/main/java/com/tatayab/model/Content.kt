package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class Content(
    @SerializedName("items")
    val items: Items
)