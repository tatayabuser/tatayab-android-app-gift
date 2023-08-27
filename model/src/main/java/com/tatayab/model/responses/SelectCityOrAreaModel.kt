package com.tatayab.model.responses

import android.os.Parcel
import android.os.Parcelable

data class SelectCityOrAreaModel(
    val id: Int?,
    val areaCount: Int=-1,
    val code: String?="",
    var name_en : String?,
    var name_ar : String?
):Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readValue(Int::class.java.classLoader) as? Int,
        parcel.readValue(Int::class.java.classLoader) as Int,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeValue(id)
        parcel.writeValue(areaCount)
        parcel.writeString(code)
        parcel.writeString(name_en)
        parcel.writeString(name_ar)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<SelectCityOrAreaModel> {
        override fun createFromParcel(parcel: Parcel): SelectCityOrAreaModel {
            return SelectCityOrAreaModel(parcel)
        }

        override fun newArray(size: Int): Array<SelectCityOrAreaModel?> {
            return arrayOfNulls(size)
        }
    }
}