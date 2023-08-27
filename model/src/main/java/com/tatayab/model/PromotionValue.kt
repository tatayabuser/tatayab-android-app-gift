package com.tatayab.model


import com.google.gson.annotations.SerializedName
import com.tatayab.model.responses.ConditionsX

data class PromotionValue(
    @SerializedName("ab__dotd_active")
    val abDotdActive: Boolean,
    @SerializedName("bonuses")
    val bonuses: List<Bonuse>,
    @SerializedName("company_id")
    val companyId: String,
    @SerializedName("conditions")
    val conditions: ConditionsX,
    @SerializedName("conditions_hash")
    val conditionsHash: String,
    @SerializedName("detailed_description")
    val detailedDescription: String,
    @SerializedName("discount_from")
    val discountFrom: String,
    @SerializedName("from_date")
    val fromDate: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("number_of_usages")
    val numberOfUsages: String,
    @SerializedName("priority")
    val priority: String,
    @SerializedName("promotion_id")
    val promotionId: String,
    @SerializedName("short_description")
    val shortDescription: String,
    @SerializedName("status")
    val status: String,
    @SerializedName("stop")
    val stop: String,
    @SerializedName("to_date")
    val toDate: String,
    @SerializedName("users_conditions_hash")
    val usersConditionsHash: String,
    @SerializedName("zone")
    val zone: String
)
/*
*  {
"promotion_id": "372",
"company_id": "1",
"bonuses": [
  {
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
],
"to_date": "0",
"from_date": "0",
"priority": "0",
"stop": "N",
"zone": "cart",
"conditions_hash": "",
"status": "A",
"number_of_usages": "2",
"users_conditions_hash": "",
"discount_from": "A",
"name": "auto free vat",
"detailed_description": "",
"short_description": ""
}
* */