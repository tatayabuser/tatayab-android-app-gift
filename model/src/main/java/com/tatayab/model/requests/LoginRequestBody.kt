package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName

data class LoginRequestBody(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String,
    @SerializedName("reg_type")
    val regType: String,
    val isGraphEnable:Boolean?=false
){
    enum class LoginType{
        confirm_login
    }
}
