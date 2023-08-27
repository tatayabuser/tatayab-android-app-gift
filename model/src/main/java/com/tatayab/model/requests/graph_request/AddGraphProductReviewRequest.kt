package com.tatayab.model.requests.graph_request

import com.tatayab.model.responses.graph_responses.BaseGrapgQlResponse

class AddGraphProductReviewRequest(
    val name: String,
    val sku: String,
    val text: String,
    val ratingId: String,
    val ratingIdValue: String
):BaseGrapgQlResponse()
