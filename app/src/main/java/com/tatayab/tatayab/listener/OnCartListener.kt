package com.tatayab.tatayab.listener

import com.tatayab.model.MapValueXXX
import com.tatayab.model.Product
import com.tatayab.model.responses.CartOrderResponse


interface OnCartListener {
    fun onProductDelete(productId: String, product: CartOrderResponse, index: Int)
    fun onProductClicked(cartId: String, productId: String, options: Map<String, String>?)
    fun onOptionsClicked(product: MapValueXXX?)
    fun addToWishlist(position: Int, product: Product)
    fun removeFromWishlist(index: Int, product: Product)
    fun updateGiftId(productId: String)
    fun openGiftView()
}