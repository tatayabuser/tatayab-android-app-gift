package com.tatayab.model.requests

import com.google.gson.annotations.SerializedName

data class AddReviewRequest(
    @SerializedName("message") val message: String,
    @SerializedName("product_id") val product_id: String,
    @SerializedName("rating_value") val rating_value: Float,
    @SerializedName("user_id") var user_id: String="",
    @SerializedName("user_id") var user_name: String=""
)
