package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class
ImagePair(
    @SerializedName("detailed")
    val detailed: Detailed?=null,
    @SerializedName("detailed_id")
    val detailedId: String?=null,
    @SerializedName("image_id")
    val imageId: String?=null,
    @SerializedName("pair_id")
    val pairId: String?=null,
    @SerializedName("position")
    val position: String?=null,
    @SerializedName("icon") val icon: Icon?
):Parcelable