package com.tatayab.model.responses

import android.os.Parcelable
import com.tatayab.model.Detailed
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class ProductImage(
    @SerializedName("detailed") val detailed: Detailed,
    @SerializedName("detailed_id") val detailed_id: String,
    @SerializedName("image_id") val image_id: String,
    @SerializedName("pair_id") val pair_id: String,
    @SerializedName("position") val position: String
): Parcelable