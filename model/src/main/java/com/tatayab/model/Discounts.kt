package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Parcelize
data class Discounts(
    @SerializedName("A") val A: Int,
    @SerializedName("P") val P: Int
):Parcelable