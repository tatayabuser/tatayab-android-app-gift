package com.tatayab.model.responses.graph_responses

data class GetGraphCategoriesFilterResponse(val data: GetGraphCategoriesFilterData) :
    BaseGrapgQlResponse()

data class GetGraphCategoriesFilterData(val products: GraphProductsAggregation?=null)
data class GraphProductsAggregation(val aggregations: List<GraphProductAggregationItem>?=null)
data class GraphProductAggregationItem(
    val attribute_code: String?="",
    val label: String?="",
    val count: Int,
    val options: List<GraphAggregationOptionItem>
)

data class GraphAggregationOptionItem(val label: String?="", val value: String?="", val count: Int)
