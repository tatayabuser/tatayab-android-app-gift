package com.tatayab.tatayab.listener

import android.widget.ImageView
import com.tatayab.model.Product
import com.tatayab.model.ProductX
import com.tatayab.tatayab.main.home.adapter.ProductsAdapter


interface OnProductListenerInHome {
    fun onProductSelected(productId: String, mProduct: ProductX?, productsAdapter: ProductsAdapter)
    fun onProductSelected(productId: String, productsAdapter: ProductsAdapter)
    fun onSeeMoreProduct(type: String, categoryId: String?, categoryName: String?)
    fun addToWishlist(position: Int, product: ProductX, productsAdapter: ProductsAdapter)
    fun removeFromWishlist(position: Int, product: ProductX, productsAdapter: ProductsAdapter)
    fun onAddToCart(product: ProductX, amount: Int = 1, maxQty: Int, image: ImageView?)

}