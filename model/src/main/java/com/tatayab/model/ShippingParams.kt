package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShippingParams(
    @SerializedName("box_height")
    val boxHeight: Int,
    @SerializedName("box_length")
    val boxLength: Int,
    @SerializedName("box_width")
    val boxWidth: Int,
    @SerializedName("max_items_in_box")
    val maxItemsInBox: Int,
    @SerializedName("min_items_in_box")
    val minItemsInBox: Int
) : Parcelable