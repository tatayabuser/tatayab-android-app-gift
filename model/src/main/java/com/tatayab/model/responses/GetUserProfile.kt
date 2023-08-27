package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class GetUserProfileResponse(
    @SerializedName("status") var status: Int,
    @SerializedName("data") var userProfile: UserProfile?,
    @SerializedName("msg") var msg: String?
)

data class UserProfile(
    @SerializedName("email") var email: String,
    @SerializedName("firstname") var firstName: String,
    @SerializedName("gender") var gender: String?,
    @SerializedName("lastname") var lastName: String,
    @SerializedName("phone") var phone: String,
    @SerializedName("phone_country_code") var phone_country_code: String?,
    @SerializedName("password") var password: String?=""
)