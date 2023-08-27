package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("cid")
    val cid: String,
    @SerializedName("filling")
    val filling: String,
    @SerializedName("item_ids")
    val itemIds: String,
    @SerializedName("limit")
    val limit: String
)

//"items": {
//    "filling": "also_bought",
//    "limit": "5",
//    "cid": ""
//}