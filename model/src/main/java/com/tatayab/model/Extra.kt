package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Extra(
    @SerializedName("product_options")
    val productOptions: Map<Int,Int>,
    @SerializedName("product_type")
    val productType: String,
    @SerializedName("return_period")
    val returnPeriod: String,
    @SerializedName("unlimited_download")
    val unlimitedDownload: String,
    @SerializedName("supplier_id")
    val supplier_id: String
):Parcelable