package com.tatayab.tatayab.listener

import android.widget.ImageView
import com.tatayab.model.Product
import com.tatayab.model.ProductPaging
import com.tatayab.model.ProductX
import com.tatayab.model.responses.ProductOptions
import kotlinx.android.parcel.RawValue


interface OnWishListListener {
    fun onProductDelete(
        options: Map<String, String>?,
        index: Int,
        productID: String,
        productWishListId: String?
    )
    fun onProductClicked(productId: String, options: Map<String, String>?)
    fun moveToCart(
        product: ProductX,
        options:Map<String,String>?,
        index: Int,
        image: ImageView?)

    fun onSupplierSelected(supplier_id:String?,supplier_name:String?)

}