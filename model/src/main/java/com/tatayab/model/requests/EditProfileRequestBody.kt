package com.tatayab.model.requests

import com.google.gson.annotations.SerializedName

data class EditProfileRequestBody(
    @SerializedName("update")
    val update: String = "Y",
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("user_id")
    val user_id: String
)