package com.tatayab.model.requests

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AddressRequest(
    @SerializedName("update") val update: String? = null,
    @SerializedName("o_address") val o_address: String?,
    @SerializedName("o_address_name") val o_address_name: String?,
    @SerializedName("o_area") var o_area: String?=null,
    @SerializedName("o_area_code") var o_area_code: String?="",
    @SerializedName("o_area_id") var areaId: String?=null,
    @SerializedName("o_block") val o_block: String?=null,
    @SerializedName("o_city") var o_city: String?=null,
    @SerializedName("o_city_code") val o_city_code: String?=null,
    @SerializedName("o_city_id") var cityId: String?=null,
    @SerializedName("o_country_code") var o_country_code: String?,
    @SerializedName("o_paci") val o_paci: String?=null,
    @SerializedName("o_phone") val o_phone: String?=null,
    @SerializedName("o_province") val o_province: String?=null,
    @SerializedName("o_zipcode") val o_zipcode: String?=null,
    @SerializedName("user_id") var user_id: String?=null,
    @SerializedName("first_name") var first_name: String?=null,
    @SerializedName("last_name") var last_name: String?=null,
    @SerializedName("is_primary") var is_primary: String = "N",
    @SerializedName("o_address_id") val o_address_id: String = "",
    @SerializedName("o_street") val o_street: String?="",
    @SerializedName("o_extra") val o_extra: String?="",
    @SerializedName("o_neighborhood") val o_neighborhood: String="",
    @SerializedName("addr_type") val addr_type: String?=""//,
    //val keep_secret:Boolean?=false
) : Parcelable {
    var isAreaOneLevel:Boolean? = false


    fun getCityId(): Int {
        return if (!cityId.isNullOrBlank() && cityId!!.matches(Regex("[0-9]"))) cityId!!.toInt() else 0
    }

    fun getAreaId(): Int {
        return if (!areaId.isNullOrBlank() && areaId?.matches(Regex("[0-9]"))==true) areaId?.toInt()?:0 else 0
    }
}