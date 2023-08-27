package com.tatayab.model.responses

data class ShippingAddress(
    val address1: String?=null,
    val address2: String?=null,
    val name: String,
    val city: String,
    val email: String?=null,
    val country: String,
    val phone: String,
    val state: String?=null,
    val street: String?=null
)