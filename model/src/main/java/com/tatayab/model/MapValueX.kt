package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class MapValueX(
    @SerializedName("image_pairs")
    val imagePairs: Boolean,
    @SerializedName("value")
    val value: String,
    @SerializedName("value_int")
    val valueInt: @RawValue Any,
    @SerializedName("variant")
    val variant: String,
    @SerializedName("variant_id")
    val variantId: String
):Parcelable