package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import kotlinx.serialization.Serializable

@Parcelize
data class ProductFeatures(
    val description: String,
    val display_on_catalog: String,
    val display_on_header: String,
    val display_on_product: String,
    val feature_id: String,
    val feature_type: String,
    val features_hash: String,
    val parent_id: String,
    val prefix: String,
    val suffix: String,
    val value: String,
     val value_int: @RawValue Any,
    val variant: String,
    val variant_id: String,
   // val variants: Variants,
    val variants: @RawValue Map<Int,MapValueX>
):Parcelable