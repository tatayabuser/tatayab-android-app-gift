package com.tatayab.model.responses.graph_responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class GraphAlsoBoughtProductsResponse(@SerializedName("data") val data: AlsoBoughtProductsData) :
    Parcelable {

    @Parcelize
    class AlsoBoughtProductsData(@SerializedName("amMostviewedGroups") val amMostviewedGroups: AmMostviewedGroups) : Parcelable

    @Parcelize
    class AmMostviewedGroups(@SerializedName("items") val products: List<Products>) : Parcelable

    @Parcelize
    open class Products(@SerializedName("items") val items: List<ProductData>? = null) : Parcelable

    @Parcelize
    class Image(
        val url: String
    ) : Parcelable
}
