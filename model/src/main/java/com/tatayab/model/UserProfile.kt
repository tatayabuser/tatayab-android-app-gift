package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserProfile(
    @SerializedName("am_subscribe")
    val amSubscribe: String?=null,
    @SerializedName("api_key")
    val apiKey: String?=null,
    @SerializedName("app_device")
    val appDevice: String?=null,
    @SerializedName("b_address")
    val bAddress: String?=null,
    @SerializedName("b_address_2")
    val bAddress2: String?=null,
    @SerializedName("b_city")
    val bCity: String?=null,
    @SerializedName("b_country")
    val bCountry: String?=null,
    @SerializedName("b_country_descr")
    val bCountryDescr: String?=null,
    @SerializedName("b_county")
    val bCounty: String?=null,
    @SerializedName("b_firstname")
    var bFirstname: String?=null,
    @SerializedName("b_lastname")
    var bLastname: String?=null,
    @SerializedName("b_phone")
    val bPhone: String?=null,
    @SerializedName("b_state")
    val bState: String?=null,
    @SerializedName("b_zipcode")
    val bZipcode: String?=null,
    @SerializedName("birthday")
    val birthday: String?=null,
    @SerializedName("company")
    val company: String?=null,
    @SerializedName("company_id")
    val companyId: String?=null,
    @SerializedName("email")
    val email: String?=null,
    @SerializedName("fax")
    val fax: String?=null,
    @SerializedName("fields")
    val fields: Map<String,String>?=null,
    @SerializedName("firstname")
    var firstname: String?=null,
    @SerializedName("from_app")
    val fromApp: String?=null,
    @SerializedName("is_root")
    val isRoot: String?=null,
    @SerializedName("janrain_identifier")
    val janrainIdentifier: String?=null,
    @SerializedName("lang_code")
    val langCode: String?=null,
    @SerializedName("last_login")
    val lastLogin: String?=null,
    @SerializedName("last_passwords")
    val lastPasswords: String?=null,
    @SerializedName("lastname")
    var lastname: String?=null,
    @SerializedName("latitude")
    val latitude: String?=null,
    @SerializedName("longitude")
    val longitude: String?=null,
    @SerializedName("partner_id")
    val partnerId: String?=null,
    @SerializedName("password")
    val password: String?=null,
    @SerializedName("password_change_timestamp")
    val passwordChangeTimestamp: String?=null,
    @SerializedName("phone")
    val phone: String?=null,
    @SerializedName("profile_id")
    val profileId: String?=null,
    @SerializedName("profile_name")
    val profileName: String?=null,
    @SerializedName("profile_type")
    val profileType: String?=null,
    @SerializedName("purchase_timestamp_from")
    val purchaseTimestampFrom: String?=null,
    @SerializedName("purchase_timestamp_to")
    val purchaseTimestampTo: String?=null,
    @SerializedName("referer")
    val referer: String?=null,
    @SerializedName("responsible_email")
    val responsibleEmail: String?=null,
    @SerializedName("s_address")
    val sAddress: String?=null,
    @SerializedName("s_address_2")
    val sAddress2: String?=null,
    @SerializedName("s_address_type")
    val sAddressType: String?=null,
    @SerializedName("s_city")
    val sCity: String?=null,
    @SerializedName("s_country")
    val sCountry: String?=null,
    @SerializedName("s_country_descr")
    val sCountryDescr: String?=null,
    @SerializedName("s_county")
    val sCounty: String?=null,
    @SerializedName("s_firstname")
    val sFirstname: String?=null,
    @SerializedName("s_lastname")
    val sLastname: String?=null,
    @SerializedName("s_phone")
    val sPhone: String?=null,
    @SerializedName("s_state")
    val sState: String?=null,
    @SerializedName("s_zipcode")
    val sZipcode: String?=null,
    @SerializedName("salt")
    val salt: String?=null,
    @SerializedName("status")
    val status: String?=null,
    @SerializedName("tax_exempt")
    val taxExempt: String?=null,
    @SerializedName("timestamp")
    val timestamp: String?=null,
    @SerializedName("token")
    val token: String?=null,
    @SerializedName("url")
    val url: String?=null,
    @SerializedName("user_id")
    val userId: String="0",
    @SerializedName("user_login")
    val userLogin: String?=null,
    @SerializedName("user_type")
    val userType: String?=null
):Parcelable
