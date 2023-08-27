package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName

data class SocialLoginRequestBody(
    @SerializedName("email")
    val email: String,
    @SerializedName("device_id")
    val deviceId: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("firstname")
    val name: String,
    @SerializedName("reg_type")
    val regType: String,
    @SerializedName("social_id")
    val socialId: String,
    val isGraphEnable: Boolean? = false
) {

    enum class RegisterType {
        fb, gmail
    }
}


/*
* {
    "device_id":"wertyuihgfdsasdfvb",
"email":"",
"phone":"9876543212345678",
"firstname":"Akl ahmed",
"reg_type":"gmail",
"social_id":"102948371421412108757"
}
* */