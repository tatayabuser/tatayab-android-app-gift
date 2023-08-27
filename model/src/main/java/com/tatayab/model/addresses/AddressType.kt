package com.tatayab.model.addresses

data class AddressType(val type: String, val id: String) {

    override fun toString(): String {
        return type
    }
}