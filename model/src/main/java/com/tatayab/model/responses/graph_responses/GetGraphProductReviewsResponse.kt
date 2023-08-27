package com.tatayab.model.responses.graph_responses

class GetGraphProductReviewsResponse(val data: GraphProductReviewsResponse)
data class GraphProductReviewsResponse(val products: ProductItems)
data class ProductItems(val items: List<ReviewProduct>)
data class ReviewProduct(val reviews: ProductReviewItems,val sku : String)
data class ProductReviewItems(val items: List<ProductReviewItem>)
data class ProductReviewItem(
    val nickname: String,
    val average_rating: Int,
    val summary: String,
    val created_at: String
)

