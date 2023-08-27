package com.tatayab.tatayab.listener

import com.tatayab.model.Product


interface OnCheckoutProductSelected {
    fun addToWishList(position: Int, product: Product)
}