package com.tatayab.model.requests

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class SelectedGuestAddressRequest(
    @SerializedName("action") val action: String = "selected_address",
    @SerializedName("address") var address: Address?=null,
    @SerializedName("country_code") var country_code: String="",
    @SerializedName("device_id") var device_id: String="",
    @SerializedName("lang_code") var lang_code: String=""
)

@Parcelize
data class Address(
    @SerializedName("o_address") var o_address: String="",
    @SerializedName("o_area") var o_area: String="",
    @SerializedName("o_area_id") var o_area_id: String="0",
    @SerializedName("o_area_code") var o_area_code: String="0",
    @SerializedName("o_block") var o_block: String="",
    @SerializedName("o_city") var o_city_id: String="",
    @SerializedName("o_city_id") var o_city: String="",
    @SerializedName("city_code") var city_code: String="",
    @SerializedName("o_email") var o_email: String="",
    @SerializedName("o_name") var o_name: String="",
    @SerializedName("o_phone") var o_phone: String="",
    @SerializedName("o_zipcode") var o_zipcode: String="",
    @SerializedName("o_user_name") var user_name: String="",
    @SerializedName("city_name") var city_name: String="",
    @SerializedName("o_street") val o_street: String="",
    @SerializedName("o_state") val o_state: String="",
    @SerializedName("o_extra") val o_extra: String="",
    @SerializedName("o_address_type") val o_address_type: String="",
    @SerializedName("o_address_address_name") val o_address_address_name: String="",
    @SerializedName("o_neighborhood") val o_neighborhood: String="",
    @SerializedName("keep_secret") val keep_secret:Boolean?=false
    ): Parcelable