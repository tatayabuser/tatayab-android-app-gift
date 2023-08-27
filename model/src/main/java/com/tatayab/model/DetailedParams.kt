package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

import kotlinx.serialization.*
import kotlinx.serialization.json.*

@Parcelize
data class DetailedParams(
    @SerializedName("detailed_params")
    val detailedParams: Boolean,
    @SerializedName("features_display_on")
    val featuresDisplayOn: String,
    @SerializedName("get_additional")
    val getAdditional: Boolean,
    @SerializedName("get_detailed")
    val getDetailed: Boolean,
    @SerializedName("get_discounts")
    val getDiscounts: Boolean,
    @SerializedName("get_extra")
    val getExtra: Boolean,
    @SerializedName("get_features")
    val getFeatures: Boolean,
    @SerializedName("get_for_one_product")
    val getForOneProduct: Boolean,
    @SerializedName("get_icon")
    val getIcon: Boolean,
    @SerializedName("get_options")
    val getOptions: Boolean,
    @SerializedName("get_taxed_prices")
    val getTaxedPrices: Boolean,
    @SerializedName("info_type")
    val infoType: String
):Parcelable