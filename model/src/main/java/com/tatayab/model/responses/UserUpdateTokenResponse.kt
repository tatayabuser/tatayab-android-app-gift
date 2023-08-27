package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class UserUpdateTokenResponse(@SerializedName("status") val status :Int, @SerializedName("msg") val errorMessage:String="") {
}
/*{
    "status": 1,
    "data": []

}*/