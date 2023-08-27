package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName
import com.tatayab.model.ProductX
import com.tatayab.model.SearchProductModel

class SearchProductListResponse( @SerializedName("status") val status :Int=0,@SerializedName("products") var products: List<SearchProductModel?>?=null,
                                @SerializedName("total_products") val total_rows :Int=0,
                                @SerializedName("fs_end_time") val fs_end_time :String?=null) {
}