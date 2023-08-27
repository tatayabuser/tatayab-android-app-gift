package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class MapValue(
    @SerializedName("description")
    val description: String,
    @SerializedName("display_on_catalog")
    val displayOnCatalog: String,
    @SerializedName("display_on_header")
    val displayOnHeader: String,
    @SerializedName("display_on_product")
    val displayOnProduct: String,
    @SerializedName("feature_id")
    val featureId: String,
    @SerializedName("feature_type")
    val featureType: String,
    @SerializedName("features_hash")
    val featuresHash: String,
    @SerializedName("parent_id")
    val parentId: String,
    @SerializedName("prefix")
    val prefix: String,
    @SerializedName("suffix")
    val suffix: String,
    @SerializedName("value")
    val value: String,
    @SerializedName("value_int")
    val valueInt: @RawValue Any,
    @SerializedName("variant")
    val variant: String,
    @SerializedName("variant_id")
    val variantId: String,
    @SerializedName("variants")
    val variants: Map<String,MapValueX>
):Parcelable