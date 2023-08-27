package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class AddReviewResponse(
    @SerializedName("message") val message: String,
    @SerializedName("product_id") val product_id: String
)