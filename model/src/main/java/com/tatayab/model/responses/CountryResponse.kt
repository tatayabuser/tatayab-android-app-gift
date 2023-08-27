package com.tatayab.model.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import ir.mirrajabi.searchdialog.core.Searchable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CountryResponse(
    @SerializedName("code") val code: String? = "KW",
    @SerializedName("name") val name: String? = "Kuwait",
    @SerializedName("phone_code") val phone_code: String = "+965",
    @SerializedName("phone_lenght") val phone_lenght: String = "8",
    @SerializedName("phone_start") val phone_start: String = "5,6,9",
    @SerializedName("flag") val flag: String? = "",
    @SerializedName("location") val location: String? = "",
    @SerializedName("currency_code") val currency_code: String? = "",
    @SerializedName("decimals") val decimals: String? = "3",
    @SerializedName("currency_id") val currency_id: String? = "",
    @SerializedName("has_regions") val has_regions: Boolean? = false,
     var show_custom_message: Boolean? = false,
    var isChecked: Boolean = false
) : Parcelable

