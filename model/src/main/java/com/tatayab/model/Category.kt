package com.tatayab.model

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("absolute_path") val absolute_path: String,
    @SerializedName("category") val category: String,
    @SerializedName("category_id") val category_id: String,
    @SerializedName("company_id") val company_id: String,
    @SerializedName("description") val description: String,
    @SerializedName("http_image_path")val http_image_path: String,
    @SerializedName("https_image_path") val https_image_path: String,
    @SerializedName("id_path") val id_path: String,
    @SerializedName("image_path") val image_path: String,
    @SerializedName("parent_id") val parent_id: String,
    @SerializedName("position") val position: String,
    @SerializedName("product_count")val product_count: String,
    @SerializedName("relative_path") val relative_path: String,
    @SerializedName("seo_name")val seo_name: String,
    @SerializedName("seo_path") val seo_path: String,
    @SerializedName("status") val status: String
)