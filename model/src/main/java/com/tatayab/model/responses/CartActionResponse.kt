package com.tatayab.model.responses

 data class CartActionResponse(
    val products: List<ProductAvailability>
)

data class ProductAvailability(
    val amount: Int,
    val amount_updated: Int,
    val product_id: String,
    val remove: Int
)