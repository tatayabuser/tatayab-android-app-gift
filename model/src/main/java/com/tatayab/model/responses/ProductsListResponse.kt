package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName
import com.tatayab.model.Product
import com.tatayab.model.ProductPaging
import com.tatayab.model.ProductX

data class ProductsListResponse(
    @SerializedName("products") var products: List<ProductX?>?=null,
    @SerializedName("total_products") var total_rows :Int=0,
    @SerializedName("fs_end_time") var fs_end_time :String?=null,
    @SerializedName("title") var title :String?=null,
    @SerializedName("seo_name") var seoName :String?=null
)
