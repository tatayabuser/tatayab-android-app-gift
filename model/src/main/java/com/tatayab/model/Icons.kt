package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class Icons(
    @SerializedName("1000x1000")
    val icon1000: Icon,
    @SerializedName("500x500")
    val icon500: Icon
)