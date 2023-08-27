package com.tatayab.model.responses

data class ProductOptionsResponse(
    val options: List<Option>
)

data class Option(
    val id: Int,
    val name: String,
    val variants: List<OptionVariant>,
    var isSelected : Boolean = false
)

data class OptionVariant(
    val id: Int,
    val image: String,
    val name: String
)