package com.tatayab.tatayab.listener


interface OnOrderListener {
    fun onOrderSelected(orderId: String)
    fun onOrderTracking(orderId: String,orderDate:String)
}