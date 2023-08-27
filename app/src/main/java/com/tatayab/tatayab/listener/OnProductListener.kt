package com.tatayab.tatayab.listener

import android.widget.ImageView
import com.tatayab.model.Product
import com.tatayab.model.ProductX


interface OnProductListener {
    fun onProductSelected(productId: String)
    fun addToWishlist(position: Int, product: Product)
    fun onAddToCart(product: ProductX)

}