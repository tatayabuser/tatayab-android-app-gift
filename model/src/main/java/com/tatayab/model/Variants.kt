package com.tatayab.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Parcelize
data class Variants(
    val image_pairs: Boolean,
    val value: String,
    val value_int:@RawValue Any,
    val variant: String,
    val variant_id: String
):Parcelable