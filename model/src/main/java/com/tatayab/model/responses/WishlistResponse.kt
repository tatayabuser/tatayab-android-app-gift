package com.tatayab.model.responses

data class WishListResponse(
    val id: String?="",
    val products: List<WishListProduct>?=null
)

data class WishListProduct(
    val can_buy: Int?=0,
    val image: String?="",
    val currency: String?,
    val price: Float,
    val product_id: String="",
    val productWishListId: String?="",
    val product_sku: String="",
    val selected_options: Map<String, String>?=null,
    val supplier_id: String?="",
    val supplier_name: String?="",
    val title: String?="",
    val source:String?=""
)