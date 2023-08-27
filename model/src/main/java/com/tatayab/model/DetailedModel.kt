package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DetailedModel(
    @SerializedName("image_path") val image_path: String? = null
): Parcelable