package com.tatayab.model.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.tatayab.model.Review
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductReviewsResponse(
    val average_rating: String? = null,
    val average_rating_percentage: Int? = null,
    val reviews: List<Review>,
    val total_reviews: Int?=null
) : Parcelable





