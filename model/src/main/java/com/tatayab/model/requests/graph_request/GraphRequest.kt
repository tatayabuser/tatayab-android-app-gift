package com.tatayab.model.requests.graph_request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class GraphRequest (
    @SerializedName("query") val query : String
):Parcelable