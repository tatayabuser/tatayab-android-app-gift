package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Parcelize
public data class MainPair(
    @SerializedName("detailed") val detailed: Detailed?
):Parcelable