package com.tatayab.model

import android.os.Parcel
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Parcelize
data class Detailed(
    @SerializedName("absolute_path") val absolute_path: String?,
    @SerializedName("alt") val alt: String?,
    @SerializedName("http_image_path") val http_image_path: String?,
    @SerializedName("https_image_path") val https_image_path: String?,
    @SerializedName("image_path") val image_path: String?,
    @SerializedName("image_x") val image_x: String?,
    @SerializedName("image_y") val image_y: String?,
    @SerializedName("object_id") val object_id: String?,
    @SerializedName("object_type") val object_type: String?,
    @SerializedName("relative_path") val relative_path: String?,
    @SerializedName("type") val type: String?
):Parcelable {
    constructor(image_path: String) : this("","","","",image_path,"","","","","","")
}