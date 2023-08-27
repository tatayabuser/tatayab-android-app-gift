package com.tatayab.model

import com.google.gson.annotations.SerializedName
import com.tatayab.model.responses.CurrencyResponse

data class CalculationObject(
    val total: Float,
    val subTotal: Float,
    val shipping: Float,
    val vat: Float,
    val customDuties: Float,
    val surcharge: Float,
    val currencyCode: String,
    val discount: Float

)