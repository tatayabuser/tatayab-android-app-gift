package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class FullDetailsModel(
    @SerializedName("product_id") val product_id: Int? = 0,
    @SerializedName("list_discount") val list_discount: Float? = 0f,
    @SerializedName("product_type") val product_type: String? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("list_price") val list_price: String? = null,
    @SerializedName("amount") val amount: String? = null,
    @SerializedName("shipping_freight") val shipping_freight: String? = null,
    @SerializedName("edp_shipping") val edp_shipping: String? = null,
    @SerializedName("tracking") val tracking: String? = null,
    @SerializedName("free_shipping") val free_shipping: String? = null,
    @SerializedName("out_of_stock_actions") val out_of_stock_actions: String? = null,
    @SerializedName("min_qty") val min_qty: String? = null,
    @SerializedName("max_qty") val max_qty: String? = null,
    @SerializedName("tax_ids") val tax_ids: List<String>? = null,
    @SerializedName("qty_step") val qty_step: String? = null,
    @SerializedName("shipping_params") val shipping_params: String? = null,
    @SerializedName("is_featured") val is_featured: String? = null,
    @SerializedName("enable_one_click_buy") val enable_one_click_buy: String? = null,
    @SerializedName("cost_price") val cost_price: String? = null,
    @SerializedName("is_free_delivery") val is_free_delivery: String? = null,
    @SerializedName("lang_code") val lang_code: String? = null,
    @SerializedName("product") val product: String? = null,
    @SerializedName("shortname") val shortname: String? = null,
    @SerializedName("short_description") val short_description: String? = null,
    @SerializedName("full_description") val full_description: String? = null,
    @SerializedName("meta_keywords") val meta_keywords: String? = null,
    @SerializedName("meta_description") val meta_description: String? = null,
    @SerializedName("page_title") val page_title: String? = null,
    @SerializedName("price") val price: String? = null,
    @SerializedName("category_ids") val category_ids: List<Int>? = null,
    @SerializedName("supplier_id") val supplier_id: String? = null,
    @SerializedName("supplier_name") val supplier_name: String? = null,
    @SerializedName("discussion_type") val discussion_type: String? = null,
    @SerializedName("base_price") val base_price: String? = null,
    @SerializedName("main_pair") val main_pair: MainPair? = null,
    @SerializedName("product_features") val product_features: Map<String, ProductFeatures>? = null,
    @SerializedName("detailed_params") val detailed_params: DetailedParams? = null,
    @SerializedName("ristrict_category_data") val ristrict_category_data: @RawValue Map<Int, MapValueXX>? = null,
    @SerializedName("sales_amount") val sales_amount: String? = null,
    @SerializedName("sd_collection_products") val sd_collection_products: @RawValue List<Any>? = null,
    @SerializedName("search_words") val search_words: String? = null,
    @SerializedName("seo_name") val seo_name: String? = null,
    @SerializedName("shared_between_companies") val shared_between_companies: List<String>? = null,
    @SerializedName("shared_product") val shared_product: String? = null,
    @SerializedName("cartId") var cartId: String? = null,
    @SerializedName("product_link") var productLink: String? = null,
    @SerializedName("is_In_WishList") var is_In_WishList: Boolean = false,
     @SerializedName("has_options") val has_options: Boolean? = false,
    @SerializedName("selected_options") val selected_options: Map<String, String>? = null
) : Parcelable
