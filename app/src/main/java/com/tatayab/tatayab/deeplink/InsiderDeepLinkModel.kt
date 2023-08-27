package com.tatayab.tatayab.deeplink

import com.google.gson.annotations.SerializedName

class InsiderDeepLinkModel(
    @SerializedName("type") val type: Int = 0,
    @SerializedName("data") val dataModel: DataModel? = null
) {
}

class DataModel(@SerializedName("url") val url: String = "") {

}

//{"type":1,"data":{"url":"https:\/\/tatayab.com\/kw-ar\/tatayab-offers\/offers\/"}}
