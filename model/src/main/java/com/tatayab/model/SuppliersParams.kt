package com.tatayab.model

import com.google.gson.annotations.SerializedName

data class SuppliersParams(
    @SerializedName("ajax_custom") val ajax_custom: String,
    @SerializedName("items_per_page") val items_per_page: Int,
    @SerializedName("page") val page: Int,
    @SerializedName("sort_by") val sort_by: String,
    @SerializedName("sort_order") val sort_order: String,
    @SerializedName("sort_order_rev") val sort_order_rev: String,
    @SerializedName("status") val status: String,
    @SerializedName("total_items") val total_items: String
)