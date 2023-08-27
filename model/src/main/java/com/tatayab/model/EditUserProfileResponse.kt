package com.tatayab.model

import com.google.gson.annotations.SerializedName
import com.tatayab.model.responses.UserProfile

data class EditUserProfileResponse(
    @SerializedName("status") var status: Int,
    @SerializedName("msg") var msg: String,
    @SerializedName("data") var userProfile: EditUserProfile?=null
)

data class EditUserProfile(
    @SerializedName("profile_id")
    var profile_id: Int,
    @SerializedName("user_id")
    var user_id: Int
)


