package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Icon(
    @SerializedName("absolute_path")
    val absolutePath: String?=null,
    @SerializedName("alt")
    val alt: String?=null,
    @SerializedName("http_image_path")
    val httpImagePath: String?=null,
    @SerializedName("https_image_path")
    val httpsImagePath: String?=null,
    @SerializedName("image_path")
    val imagePath: String?=null,
    @SerializedName("image_x")
    val imageX: String?=null,
    @SerializedName("image_y")
    val imageY: String?=null,
    @SerializedName("relative_path")
    val relativePath: String?=null
):Parcelable