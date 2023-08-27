package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName


data class CurrencyResponse(
    @SerializedName("after") val after: String? = null,
    @SerializedName("coefficient") val coefficient: String? ="1",
    @SerializedName("countries_list") val countries_list: String? = null,
    @SerializedName("currency_code") val currency_code: String? = "",
    @SerializedName("currency_id") val currency_id: String? = "",
    @SerializedName("decimals") val decimals: Int? = 3,
    @SerializedName("decimals_separator") val decimals_separator: String? = null,
    @SerializedName("description") val description: String? = null,
    @SerializedName("is_primary") val is_primary: String? = null,
    @SerializedName("position") val position: String? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("symbol") val symbol: String? = null,
    @SerializedName("thousands_separator") val thousands_separator: String? = null,
    var isChecked: Boolean? = false


)