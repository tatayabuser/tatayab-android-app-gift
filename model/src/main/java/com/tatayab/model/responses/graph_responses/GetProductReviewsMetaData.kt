package com.tatayab.model.responses.graph_responses

class GetProductReviewsMetaData(val data: ReviewsMetaData) : BaseGrapgQlResponse()

class ReviewsMetaData(val productReviewRatingsMetadata: ProductReviewRatingsMetadata)

class ProductReviewRatingsMetadata(val items: List<RatingsMetadata>)

class RatingsMetadata(
    val id: String,
    val name: String,
    val values: List<RatingsMetadataValue>
)

class RatingsMetadataValue(val value_id: String, val value: Int)
