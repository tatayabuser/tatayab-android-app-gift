package com.tatayab.model

import com.google.gson.annotations.SerializedName

data class Params(
    @SerializedName("ajax_custom") val ajax_custom: String,
    @SerializedName("category_delimiter") val category_delimiter: String,
    @SerializedName("category_id") val category_id: Int,
    @SerializedName("current_category_id") val current_category_id: Int,
    @SerializedName("get_company_name") val get_company_name: Boolean,
    @SerializedName("get_frontend_urls") val get_frontend_urls: Boolean,
    @SerializedName("get_images") val get_images: Boolean,
    @SerializedName("group_by_level") val group_by_level: Boolean,
    @SerializedName("item_ids") val item_ids: String,
    @SerializedName("items_per_page") val items_per_page: Int,
    @SerializedName("limit")val limit: Int,
    @SerializedName("max_nesting_level")val max_nesting_level: Any,
    @SerializedName("page") val page: Int,
    @SerializedName("plain") val plain: Boolean,
    @SerializedName("simple") val simple: Boolean,
    @SerializedName("sort_by") val sort_by: String,
    @SerializedName("sort_order") val sort_order: String,
    @SerializedName("sort_order_rev") val sort_order_rev: String,
    @SerializedName("status")val status: String,
    @SerializedName("visible") val visible: Boolean,
    @SerializedName("total_items") val total_items: String

)