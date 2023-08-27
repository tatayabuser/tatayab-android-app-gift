package com.tatayab.domain.model


data class AddressModel(
    val addressId: Long = 0,
    var userId: String,
    var title: String,
    var shippingAddress: String,
    var billingAddress: String,
    var city: String,
    var country: String,
    var zipCode: String,
    var isPrimary: Boolean = false
)