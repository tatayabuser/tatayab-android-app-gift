package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName
import com.tatayab.model.Banner
import com.tatayab.model.Content
import com.tatayab.model.Properties

data class TrendsResponse(
    @SerializedName("banners")
    val banners: List<Banner>,
    @SerializedName("block_id")
    val blockId: String,
    @SerializedName("company_id")
    val companyId: String,
    @SerializedName("content")
    val content: Content,
    @SerializedName("lang_code")
    val langCode: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("properties")
    val properties: Properties,
    @SerializedName("type")
    val type: String
)