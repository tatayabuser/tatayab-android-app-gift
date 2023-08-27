package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Review(
    val date: String,
    val message: String,
    val name: String,
    val post_id: String,
    val rating_value: String
):Parcelable



