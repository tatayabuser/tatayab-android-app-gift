package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class StatuesHistory(
    @SerializedName("color") val color: String,
    @SerializedName("date") val date: String,
    @SerializedName("desc") val desc: String,
    @SerializedName("icon") val icon: String,
    @SerializedName("title") val title: String,
    @SerializedName("s_key") val skey: String
)