package com.tatayab.model.requests

data class CategoryRequest(
    val category_id: String = "",
    val country_code: String,
    val lang_code: String,
    val with_images: String = "0",
    val homepage: String = "0"
)