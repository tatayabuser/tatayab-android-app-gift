package com.tatayab.model.requests

data class DeleteAddressRequest(
    val delete: String,
    val o_address_id: String,
    val user_id: String
)