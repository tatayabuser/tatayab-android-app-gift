package com.tatayab.tatayab.listener


interface OnProductListenerInOrder {

    fun onProductSelected(productId: String)
    fun onSupplierSelected(supplier_id:String?,supplier_name:String?)
    fun onTrackExternalOrder(url:String?)

}