package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName


data class RegisterRequestBody(
    @SerializedName("country_code") var country_code: String= "",
    @SerializedName("device_id") var device_id: String="",
    @SerializedName("email") val email: String,
    @SerializedName("firstname") val firstname: String,
    @SerializedName("lastname") val lastname: String?="",
    @SerializedName("phone") val phone: String,
    @SerializedName("lang_code") var lang_code: String="",
    @SerializedName("password") val password: String="",
    @SerializedName("reg_type") var reg_type: String = "normal", // default for type
    @SerializedName("social_id") val social_id: String = "",
    @SerializedName("o_zipcode") val o_zipcode: String = "",
    @SerializedName("o_address") val o_address: String = "",
    @SerializedName("o_city") val o_city: String = "",
    @SerializedName("o_city_id") val o_city_id: String="",
    @SerializedName("o_area") val o_area: String = "",
    @SerializedName("o_area_code") val o_area_code: String = "",
    @SerializedName("o_areaId") val o_areaId: String = "",
    @SerializedName("o_block") val o_block: String = "",
    @SerializedName("o_address_name") val o_address_name: String = "",
    @SerializedName("o_street") val o_street: String = "",
    @SerializedName("o_extra") val o_extra: String = "",
    @SerializedName("addr_type") val addr_type: String? = "",
    @SerializedName("o_neighborhood") val o_neighborhood: String = "",
    val o_state: String = "",
    val cityName: String = ""//,
    //val keep_secret:Boolean=false

){
    var isAreaOneLevel:Boolean? = false
}