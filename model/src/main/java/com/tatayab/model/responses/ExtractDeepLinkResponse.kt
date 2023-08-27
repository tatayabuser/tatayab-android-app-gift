package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class ExtractDeepLinkResponse(
    @SerializedName("object_id")
    val object_id: String? = null,
    @SerializedName("type")
    val type: String? = null)


//{
//    "object_id": "40",
//    "type": "product"
//}
