package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class RegisterResponse(
    @SerializedName("profile_id")
    val profileId: String? = null,
    @SerializedName("user_id")
    val userId: Int? = null,
    @SerializedName("message")
    val message: String? = null,
    @SerializedName("token")
    val token: String? = null,
    @SerializedName("firstname")
    val firstname: String? = null,
    @SerializedName("email")
    val email: String? = null,
    @SerializedName("phone")
    val phone: String? = null,
    @SerializedName("is_exist")
    val isExist: Int? = null
)

/*
*
* {
    "user_id": 0,
    "profile_id": 0,
    "firstname": "",
    "email": "",
    "phone": "",
    "message": "",
    "is_exist": 0
}*/