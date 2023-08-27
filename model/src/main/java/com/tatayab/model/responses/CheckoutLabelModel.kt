package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class CheckoutLabelModel(
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("value")
    val value: Float? = 0f,
    @SerializedName("notes")
    val notes: String? = null,
    @SerializedName("sign")
    var sign: String? = "+",
    var currencyCode: String? = "",
    var hasTaxes:Boolean? = false

)
