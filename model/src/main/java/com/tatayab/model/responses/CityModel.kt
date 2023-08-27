package com.tatayab.model.responses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CityModel(
    val city_id: Int?,
    val area_count: Int?=0,
    var name_en: String?,
    var name_ar: String?,
    var code: String?,
    var isSelected:Boolean=false
) : Parcelable

//{
//    "city_id": 61,
//    "area_count": 33,
//name_en: <city or area name in English>
//name_ar: <city or area name in Arabic>//}