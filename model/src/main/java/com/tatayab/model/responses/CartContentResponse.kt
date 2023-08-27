package com.tatayab.model.responses


import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.tatayab.model.*
import com.tatayab.model.common.UserAdapterFactory

data class CartContentResponse(
    @SerializedName("amount")
    val amount: Int = 0,
    @SerializedName("calculate_shipping")
    val calculateShipping: Boolean? = null,
    @SerializedName("chosen_shipping")
    val chosenShipping: List<Any>? = null,
    @SerializedName("company_shipping_failed")
    val companyShippingFailed: Boolean? = null,
    @SerializedName("coupons")
    val coupons: List<Any>? = null,
    @SerializedName("default_location")
    val defaultLocation: DefaultLocation? = null,
    @SerializedName("discount")
    val discount: Int? = null,
    @SerializedName("discount_formatted")
    val discountFormatted: DiscountFormatted? = null,
    @SerializedName("display_shipping_cost")
    val displayShippingCost: Int? = null,
    @SerializedName("display_shipping_cost_formatted")
    val displayShippingCostFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("display_subtotal")
    val displaySubtotal: Double? = null,
    @SerializedName("product_options_detailed")
    val productOptionsDetailed: Map<String, ProductOptionsDetailed>? = null,
    @SerializedName("display_subtotal_formatted")
    val displaySubtotalFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("free_shipping")
    val freeShipping: List<Any>? = null,
    @SerializedName("has_coupons")
    val hasCoupons: Boolean? = null,
    @SerializedName("no_promotions")
    val noPromotions: Boolean? = null,
    @SerializedName("options_style")
    val optionsStyle: String? = null,
    @SerializedName("original_subtotal")
    val originalSubtotal: Double? = null,
    @SerializedName("payments")
    val payments: Map<String, MapValue>? = null,
    @SerializedName("product_groups")
    val productGroups: List<ProductGroup>? = null,
    @SerializedName("products")
    val products: List<MapValueXXX> ? = null,
    //@SerializedName("promotions")
    //val promotions: List<Any>? = null,
    @SerializedName("recalculate")
    val recalculate: Boolean? = null,
    @SerializedName("shipping")
    val shipping: List<Any>? = null,
    @SerializedName("shipping_cost")
    val shippingCost: Int? = null,
    @SerializedName("shipping_cost_formatted")
    val shippingCostFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("shipping_failed")
    val shippingFailed: Boolean? = null,
    @SerializedName("shipping_required")
    val shippingRequired: Boolean? = null,
    @SerializedName("stored_taxes")
    val storedTaxes: String? = null,
    @SerializedName("subtotal")
    val subtotal: Double? = null,
    @SerializedName("subtotal_discount")
    val subtotalDiscount: Int? = null,
    @SerializedName("subtotal_discount_formatted")
    val subtotalDiscountFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("subtotal_formatted")
    val subtotalFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("tax_subtotal")
    val taxSubtotal: Float? = null,
    @SerializedName("tax_subtotal_formatted")
    val taxSubtotalFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("total")
    val total: Double? = null,
    @SerializedName("total_formatted")
    val totalFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("use_discount")
    val useDiscount: Boolean? = null,
    //@SerializedName("user_data")
    @JsonAdapter(UserAdapterFactory::class)
    val userData: Any? = null
)