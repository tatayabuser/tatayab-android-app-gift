package com.tatayab.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Variant(
    val image_pair: ImagePair?=null,
    val option_id: String?=null,
    val variant_id: String?=null,
    val variant_image: String?=null,
    val variant_name: String
):Parcelable
