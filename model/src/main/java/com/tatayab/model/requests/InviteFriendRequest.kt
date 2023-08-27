package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.CartValue

data class InviteFriendRequest(
    @SerializedName("sender_id")
    val sender_id: Int,
    @SerializedName("dev_id")
    val dev_id: String,
    @SerializedName("sender_country")
    val sender_country: String
)