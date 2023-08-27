package com.tatayab.model.responses.graph_responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class GraphCategoryProductsResponse(@SerializedName("data") val data: Product) :
    Parcelable {


    @Parcelize
    class Product(@SerializedName("products") val products: Products) : Parcelable

    @Parcelize
    open class Products(@SerializedName("items") val items: List<ProductData>? = null, val total_count : Int = 0) : Parcelable

    @Parcelize
    class Image(
        val url: String
    ) : Parcelable
}
