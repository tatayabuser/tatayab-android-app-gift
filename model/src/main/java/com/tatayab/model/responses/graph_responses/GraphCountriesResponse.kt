package com.tatayab.model.responses.graph_responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
open class GraphCountriesResponse(@SerializedName("data") val mGraphCountryList: CountriesList) :
    Parcelable {

    @Parcelize
    open class CountriesList(@SerializedName("countries") val mCountriesList: List<GraphCountryResponse>? = null) :
        Parcelable

    @Parcelize
    open class GraphCountryResponse(
        @SerializedName("id") val id: String,
        @SerializedName("two_letter_abbreviation") val two_letter_abbreviation: String,
        @SerializedName("full_name_locale") val full_name_locale: String,
        @SerializedName("full_name_english") val name: String,
        @SerializedName("flag") val flag: String,
        @SerializedName("phone_length") val phone_length: String,
        @SerializedName("phone_start_nums") val phone_start_nums: String,
        @SerializedName("phone_code") val phone_code: String,
        @SerializedName("show_custom_message") val show_custom_message: String,
        @SerializedName("location") val location: String?=""
    ) : Parcelable
}
