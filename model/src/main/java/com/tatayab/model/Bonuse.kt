package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class Bonuse(
    @SerializedName("bonus")
    val bonus: String,
    @SerializedName("discount_bonus")
    val discountBonus: String,
    @SerializedName("discount_value")
    val discountValue: String,
    @SerializedName("value")
    val value: List<String>,
    @SerializedName("isManual")
    var isManual: Boolean=false
)


/*
*
*  {
"bonus": "free_taxes",
"value": [
  "vat",
  "custom_duties"
],
},
  {
"bonus": "free_payment_method",
"value": [
  "14"
],
}
*
* */