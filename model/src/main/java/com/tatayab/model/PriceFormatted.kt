package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

@Parcelize
data class PriceFormatted(
    @SerializedName("price")val price: String,
    @SerializedName("symbol")val symbol: String
):Parcelable