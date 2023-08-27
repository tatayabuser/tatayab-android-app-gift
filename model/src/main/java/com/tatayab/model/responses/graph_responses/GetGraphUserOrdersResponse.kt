package com.tatayab.model.responses.graph_responses

data class GetGraphUserOrdersResponse(val data: CustomerOrdersResponse)
data class CustomerOrdersResponse(val customer: GraphOrdersResponse)
data class GraphOrdersResponse(val orders: GraphItemsOrdersResponse)
data class GraphItemsOrdersResponse(val items: List<GraphOrderResponse>)
data class GraphOrderResponse(
    val number: String,
    val status: String,
    val order_date: String,
    val total: OrderTotalResponse,
    val items: List<GraphProductItemResponse>,
    val shipping_address: GetOrderShippingAddress,
    val payment_methods: List<GraphPaymentMethod>
)

data class OrderTotalResponse(
    val grand_total: OrderGrandTotal,
    val subtotal: OrderGrandTotal,
    val total_shipping: OrderGrandTotal
)

data class OrderGrandTotal(val value: Float, val currency: String)
data class GraphProductItemResponse(
    val product_sku: String,
    val product_image: String,
    val product_name: String,
    val quantity_ordered: Int,
    val product_sale_price: OrderGrandTotal
)

data class GetOrderShippingAddress(
    val city: String,
    val street: List<String>,
    val country_code: String,
    val telephone: String,
    val postcode: String,
    val firstname: String,
    val region: String
)

data class GraphPaymentMethod(val name: String, val type: String)
