package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName
import com.tatayab.model.Banner
import com.tatayab.model.Content
import com.tatayab.model.ProductX
import com.tatayab.model.Properties

data class BlockLayoutResponse(
    var banners: List<Banner>? = null,
    @SerializedName("block_id")
    var blockId: String? = null,
    @SerializedName("catId")
    var catId: String? = "0",
    @SerializedName("company_id")
    val companyId: String? = null,
    //@SerializedName("content")
    //val content: Content? = null,
    @SerializedName("lang_code")
    val langCode: String? = null,
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("properties")
    val properties: Properties? = null,
    @SerializedName("type")
    var type: String? = null,
    @SerializedName("products")
    val products: List<ProductX>? = null,
    @SerializedName("fs_end_time")
    var fs_end_time: String? = null

)

