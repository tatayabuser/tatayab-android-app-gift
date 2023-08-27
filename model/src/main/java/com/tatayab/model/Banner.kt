package com.tatayab.model


import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.tatayab.model.common.BgImageAdapterFactory
import com.tatayab.model.common.MainPairAdapterFactory

data class Banner(
    @SerializedName("adv_text") val adv_text: String? = null,
    @SerializedName("banner") val banner: String? = null,
    @SerializedName("banner_id") val banner_id: String? = null,
    @SerializedName("button_text") val button_text: String? = null,
    @SerializedName("image") val image: String? = null,
    @SerializedName("target") val target: String? = null,
    @SerializedName("title") val title: String? = null,
    @SerializedName("url") val url: String? = null
)