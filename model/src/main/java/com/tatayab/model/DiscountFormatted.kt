package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DiscountFormatted(
    @SerializedName("price")
    val price: String,
    @SerializedName("symbol")
    val symbol: String
):Parcelable