package com.tatayab.model


import com.google.gson.annotations.SerializedName
import com.tatayab.model.MapValueXXXXXX

data class UserData(
    @SerializedName("am_subscribe")
    val amSubscribe: String,
    @SerializedName("app_device")
    val appDevice: String,
    @SerializedName("b_address")
    val bAddress: String,
    @SerializedName("b_address_2")
    val bAddress2: String,
    @SerializedName("b_city")
    val bCity: String,
    @SerializedName("b_country")
    val bCountry: String,
    @SerializedName("b_country_descr")
    val bCountryDescr: String,
    @SerializedName("b_county")
    val bCounty: String,
    @SerializedName("b_firstname")
    val bFirstname: String,
    @SerializedName("b_lastname")
    val bLastname: String,
    @SerializedName("b_phone")
    val bPhone: String,
    @SerializedName("b_state")
    val bState: String,
    @SerializedName("b_zipcode")
    val bZipcode: String,
    @SerializedName("birthday")
    val birthday: String,
    @SerializedName("company")
    val company: String,
    @SerializedName("company_id")
    val companyId: String,
    @SerializedName("email")
    val email: String,
    @SerializedName("fax")
    val fax: String,
    @SerializedName("fields")
    val fields: Map<Int,String>,
    @SerializedName("firstname")
    val firstname: String,
    @SerializedName("from_app")
    val fromApp: String,
    @SerializedName("is_root")
    val isRoot: String,
    @SerializedName("janrain_identifier")
    val janrainIdentifier: String,
    @SerializedName("lang_code")
    val langCode: String,
    @SerializedName("last_login")
    val lastLogin: String,
    @SerializedName("lastname")
    val lastname: String,
    @SerializedName("latitude")
    val latitude: String,
    @SerializedName("longitude")
    val longitude: String,
    @SerializedName("other_addresses")
    val otherAddresses: List<Any>,
    @SerializedName("partner_id")
    val partnerId: String,
    @SerializedName("phone")
    val phone: String,
    @SerializedName("profile_id")
    val profileId: String,
    @SerializedName("profile_name")
    val profileName: String,
    @SerializedName("profile_type")
    val profileType: String,
    @SerializedName("purchase_timestamp_from")
    val purchaseTimestampFrom: String,
    @SerializedName("purchase_timestamp_to")
    val purchaseTimestampTo: String,
    @SerializedName("referer")
    val referer: String,
    @SerializedName("responsible_email")
    val responsibleEmail: String,
    @SerializedName("s_address")
    val sAddress: String,
    @SerializedName("s_address_2")
    val sAddress2: String,
    @SerializedName("s_address_type")
    val sAddressType: String,
    @SerializedName("s_city")
    val sCity: String,
    @SerializedName("s_country")
    val sCountry: String,
    @SerializedName("s_country_descr")
    val sCountryDescr: String,
    @SerializedName("s_county")
    val sCounty: String,
    @SerializedName("s_firstname")
    val sFirstname: String,
    @SerializedName("s_lastname")
    val sLastname: String,
    @SerializedName("s_phone")
    val sPhone: String,
    @SerializedName("s_state")
    val sState: String,
    @SerializedName("s_zipcode")
    val sZipcode: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("tax_exempt")
    val taxExempt: String,
    @SerializedName("timestamp")
    val timestamp: String,
    @SerializedName("url")
    val url: String,
    @SerializedName("user_id")
    val userId: String,
    @SerializedName("user_login")
    val userLogin: String,
    @SerializedName("user_type")
    val userType: String,
    @SerializedName("usergroups")
    val usergroups: Map<Int, MapValueXXXXXX>
)