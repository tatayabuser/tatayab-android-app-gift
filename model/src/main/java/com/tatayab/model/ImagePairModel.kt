package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ImagePairModel(
    @SerializedName("pair_id") val pair_id: String? = null,
    @SerializedName("detailed") val mDetailedModel: DetailedModel? = null
): Parcelable