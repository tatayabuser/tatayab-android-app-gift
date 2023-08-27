package com.tatayab.model

data class CachProductCart (
    val productID: String,
    var amount: Int,
    val productOptions : Map<String,ProductOptionsDetailed>?=null
)