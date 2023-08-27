package com.tatayab.model.responses

import android.os.Parcel
import android.os.Parcelable

data class AreaModel(
    val area_id: Int?,
    var name_en : String?,
    var name_ar : String?,
    var code : String?="",
    var isOneLevel:Boolean? =  false
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readString(),
        parcel.readString(),parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(area_id)
        parcel.writeString(name_en)
        parcel.writeString(name_ar)
        parcel.writeString(code)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AreaModel> {
        override fun createFromParcel(parcel: Parcel): AreaModel {
            return AreaModel(parcel)
        }

        override fun newArray(size: Int): Array<AreaModel?> {
            return arrayOfNulls(size)
        }
    }
}
//{
//    "area_id": 810,
//name_en: <city or area name in English>
//name_ar: <city or area name in Arabic>