package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName
import com.tatayab.model.Supplier
import com.tatayab.model.SuppliersParams
import com.tatayab.model.UserProfile

data class TokenResponse(
    @SerializedName("message") var message: String? = "",
    var userProfile: AuthenticationResponse?=null,
    var status:Int?= 0
    )
