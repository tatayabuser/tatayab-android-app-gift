package com.tatayab.model.requests

import com.google.gson.annotations.SerializedName


data class ExtractDeepLinkRequest(
    @SerializedName("url")
    val url: String? = null){
    @SerializedName("action")
    val action: String = Action.get_details.toString()
}
