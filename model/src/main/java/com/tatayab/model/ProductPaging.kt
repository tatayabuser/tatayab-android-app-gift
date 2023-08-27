package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.tatayab.model.common.AvailableCountriesAdapterFactory
import com.tatayab.model.common.TaxIdsAdapterFactory
import com.tatayab.model.responses.ProductOptions
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue
import kotlinx.serialization.Contextual

@Parcelize
data class ProductPaging(

    @SerializedName("ab__vg_videos") val ab__vg_videos: Boolean? = null,
    @SerializedName("age_limit") val age_limit: String? = null,
    @SerializedName("age_verification") val age_verification: String? = null,
    @SerializedName("amount") var amount: Int = 0,
    @SerializedName("availableAmount") var availableAmount: Int? = amount?.toInt(),
    @SerializedName("avail_since") val avail_since: String? = null,
    //@SerializedName("available_countries")
    @SerializedName("available_countries") @JsonAdapter(AvailableCountriesAdapterFactory::class)
    val available_countries: @RawValue Any? = null,
    @SerializedName("average_rating") val average_rating: String? = null,
    @SerializedName("base_price") val base_price: String? = null,
    @SerializedName("base_price_formatted") val base_price_formatted: BasePriceFormatted? = null,
    @SerializedName("buy_now_url") val buy_now_url: String? = null,
    @SerializedName("category_ids") val category_ids: List<Int>? = null,
    @SerializedName("collection_type") val collection_type: String? = null,
    @SerializedName("company_id") val company_id: String? = null,
    @SerializedName("cost_price") val cost_price: String? = null,
    @SerializedName("details_layout") val details_layout: String? = null,
    @SerializedName("discounts") val discounts: Discounts? = null,
    @SerializedName("discussion_thread_id") val discussion_thread_id: String? = null,
    @SerializedName("discussion_type") val discussion_type: String? = null,
    @SerializedName("edp_shipping") val edp_shipping: String? = null,
    @SerializedName("enable_one_click_buy") val enable_one_click_buy: String? = null,
    @SerializedName("exceptions_type") val exceptions_type: String? = null,
    @SerializedName("facebook_obj_type") val facebook_obj_type: String? = null,
    @SerializedName("featured_position") val featured_position: String? = null,
    @SerializedName("free_shipping") val free_shipping: String? = null,
    @SerializedName("has_options") val has_options: Boolean? = null,
    @SerializedName("height") val height: String? = null,
    @SerializedName("is_default_variation") val is_default_variation: String? = null,
    @SerializedName("is_edp") val is_edp: String? = null,
    @SerializedName("is_featured") val is_featured: String? = null,
    @SerializedName("is_free_delivery") val is_free_delivery: String? = null,
    @SerializedName("is_op") val is_op: String? = null,
    @SerializedName("is_oper") val is_oper: String? = null,
    @SerializedName("is_pbp") val is_pbp: String? = null,
    @SerializedName("is_returnable") val is_returnable: String? = null,
    @SerializedName("length") val length: String? = null,
    @SerializedName("list_discount") val list_discount: Float? = null,
    @SerializedName("list_discount_prc") val list_discount_prc: String? = null,
    @SerializedName("list_price") val list_price: String? = null,
    @SerializedName("list_price_formatted") val list_price_formatted: ListPriceFormatted? = null,
    @SerializedName("list_qty_count") val list_qty_count: String? = null,
    @SerializedName("localization") val localization: String? = null,
    @SerializedName("location") val location: String? = null,
    @SerializedName("low_avail_limit") val low_avail_limit: String? = null,
    @SerializedName("main_category") val main_category: Int? = null,
    @SerializedName("main_pair") val main_pair: MainPair? = null,
    @SerializedName("max_qty") val max_qty: Int = 0,
    @SerializedName("min_qty") val min_qty: Int = 0,
    @SerializedName("options_type") val options_type: String? = null,
    @SerializedName("out_of_stock_actions") val out_of_stock_actions: String? = null,
    @SerializedName("parent_product_id") val parent_product_id: String? = null,
    @SerializedName("position") val position: String? = null,
    @SerializedName("price") var price: Float = 0f,
    @SerializedName("price_formatted") val price_formatted: PriceFormatted? = null,
    @SerializedName("product") val product: String? = null,
    @SerializedName("product_code") val product_code: String? = null,
    @SerializedName("product_id") val product_id: String? = null,
    //@SerializedName("product_features") val productFeatures: Map<String, MapValue>,
    @SerializedName("product_features") val product_features: Map<String, ProductFeatures>? = null,
    //@SerializedName("free_available_countries")
    @SerializedName("free_available_countries") @JsonAdapter(AvailableCountriesAdapterFactory::class)
    val free_available_countries: @RawValue Any? = null,
    @SerializedName("product_options")
    val product_options: List<@RawValue ProductOptions>? = null,
    @SerializedName("product_type") val product_type: String? = null,
    @SerializedName("qty_content")
    @Contextual val qty_content: List<@RawValue Any>? = null,
    @SerializedName("qty_step") val qty_step: String? = null,
    @SerializedName("return_period") val return_period: String? = null,
    @SerializedName("selected_options")
    val selected_options: Map<String, String>? = null,
    @SerializedName("seo_path") val seo_path: String? = null,
    @SerializedName("shipping_freight") val shipping_freight: String? = null,
    @SerializedName("shipping_params") val shipping_params: String? = null,
    @SerializedName("show_featured_label") val show_featured_label: String? = null,
    @SerializedName("status") val status: String? = null,
    @SerializedName("supplier_commission") val supplier_commission: String? = null,
    @SerializedName("supplier_id") val supplier_id: String? = null,
    @SerializedName("supplier_name") val supplier_name: String? = null,
    //@SerializedName("tax_ids")
    @SerializedName("tax_ids") @JsonAdapter(TaxIdsAdapterFactory::class)
    val tax_ids: @RawValue Any? = null,
    @SerializedName("timestamp") val timestamp: String? = null,
    @SerializedName("tracking") val tracking: String? = null,
    @SerializedName("unlimited_download") val unlimited_download: String? = null,
    @SerializedName("updated_timestamp") val updated_timestamp: String? = null,
    @SerializedName("usergroup_ids") val usergroup_ids: String? = null,
    @SerializedName("variation_code")
    val variation_code: @RawValue Any? = null,
    @SerializedName("variation_options")
    val variation_options: @RawValue Any? = null,
    @SerializedName("weight") val weight: String? = null,
    @SerializedName("width") val width: String? = null,
    @SerializedName("zero_price_action") val zero_price_action: String? = null,
    @SerializedName("age_warning_message") val ageWarning_message: @RawValue Any? = null,
    @SerializedName("amp_description") val amp_description: String? = null,
    @SerializedName("box_height") val box_height: Int? = null,
    @SerializedName("box_length") val box_length: Int? = null,
    @SerializedName("box_width") val box_width: Int? = null,
    @SerializedName("detailed_params") val detailed_params: DetailedParams? = null,
    @SerializedName("full_description") val full_description: String? = null,
    @SerializedName("have_required") val have_required: String? = null,
    @SerializedName("lang_code") val lang_code: String? = null,
    @SerializedName("max_items_in_box") val max_items_in_box: Int? = null,
    @SerializedName("meta_description") val meta_description: String? = null,
    @SerializedName("meta_keywords") val meta_keywords: String? = null,
    @SerializedName("min_items_in_box") val min_items_in_box: Int? = null,
    @SerializedName("page_title") val page_title: String? = null,
    @SerializedName("popularity") val popularity: String? = null,
    @SerializedName("promo_text") val promo_text: String? = null,
    @SerializedName("ristrict_category_data") val ristrict_category_data: @RawValue Map<Int, MapValueXX>? = null,
    @SerializedName("sales_amount") val sales_amount: String? = null,
    @SerializedName("sd_collection_products") val sd_collection_products: @RawValue List<Any>? = null,
    @SerializedName("search_words") val search_words: String? = null,
    @SerializedName("seo_name") val seo_name: String? = null,
    @SerializedName("shared_between_companies") val shared_between_companies: List<String>? = null,
    @SerializedName("shared_product") val shared_product: String? = null,
    @SerializedName("short_description") val short_description: String? = null,
    @SerializedName("shortname") val shortname: String? = null,
    @SerializedName("cart_id") val cartId: String? = null,
    @SerializedName("is_In_WishList") var isInWishList: Boolean = false,
    @SerializedName("isDeleted") var isDeleted: Boolean? = false,
    @SerializedName("cached_product_options") var cached_product_options: Map<String, ProductOptionsDetailed>? = null
) : Parcelable