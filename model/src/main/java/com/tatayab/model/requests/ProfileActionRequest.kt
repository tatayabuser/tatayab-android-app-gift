package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName

data class ProfileActionRequest(
    @SerializedName("user_id")
    var userId: String = "0",
    @SerializedName("fullname")
    val fullname: String = "0",
    @SerializedName("gender")
    val gender: String = ""
) {
    @SerializedName("action")
    val action: String = Action.edit_profile.toString()
}


data class ChangePasswordRequest(
    @SerializedName("user_id")
    var userId: String = "0",
    @SerializedName("old_password")
    val old_password: String = "0",
    @SerializedName("new_password")
    val new_password: String = ""
) {
    @SerializedName("action")
    val action: String = Action.change_password.toString()
}



