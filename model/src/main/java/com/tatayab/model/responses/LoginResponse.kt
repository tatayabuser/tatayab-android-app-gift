package com.tatayab.model.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.tatayab.model.UserProfile
import kotlinx.android.parcel.Parcelize
@Parcelize
data class AuthenticationResponse(
    @SerializedName("email") var email: String?="",
    @SerializedName("firstname") var firstname: String?="",
    @SerializedName("is_exist") var is_exist: Int=0,
    @SerializedName("phone") var phone: String="",
    @SerializedName("profile_id") var profile_id: Int=1,
    @SerializedName("token") var token: String="",
    @SerializedName("user_id") var user_id: Int=1,
    @SerializedName("withList_id") var withList_id: String? = "",
    @SerializedName("guestuser_id") var guestuser_id: Int=0, //// for save userId in case of guest
    @SerializedName("message") var message: String =" "
):Parcelable{
    var password:String = ""
    var isFirstUpdate:Boolean = true
}