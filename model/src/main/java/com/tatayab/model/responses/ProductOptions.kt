package com.tatayab.model.responses

import android.os.Parcelable
import com.tatayab.model.Variant
import kotlinx.android.parcel.Parcelize
import com.google.gson.annotations.SerializedName

@Parcelize
data class ProductOptions(

    @SerializedName("option_id") val option_id: String?=null,
    @SerializedName("option_name") val option_name: String?,
    @SerializedName("product_id") val product_id: String?=null,
    @SerializedName("isSelected") var isSelected:Boolean = false,
    @SerializedName("selectedIndex") var selectedIndex:Int = 0,
    @SerializedName("variants") val variants: ArrayList<Variant>
):Parcelable

