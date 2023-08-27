package com.tatayab.model.responses.graph_responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
open class GraphSuppliersResponse(@SerializedName("data") val mGraphCountryListGrapg: GrapgSuppliersList) :
    Parcelable {

    @Parcelize
    open class GrapgSuppliersList(@SerializedName("ambrandlist") val brandsList: Ambrandlist? = null) : Parcelable

    @Parcelize
    open class Ambrandlist(@SerializedName("items") val brands: List<GraphSupplierResponse>? = null) : Parcelable

    @Parcelize
    open class GraphSupplierResponse(
        @SerializedName("brandId") val id: String,
        @SerializedName("label") val name: String,
        @SerializedName("image") val image: String
    ) : Parcelable
}
