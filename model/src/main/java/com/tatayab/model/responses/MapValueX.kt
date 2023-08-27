package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName
import com.tatayab.model.*

data class MapValueX(
    @SerializedName("am_ages")
    val amAges: String,
    @SerializedName("amount")
    val amount: Int,
    @SerializedName("amount_total")
    val amountTotal: Int,
    @SerializedName("base_price")
    val basePrice: Double,
    @SerializedName("base_price_formatted")
    val basePriceFormatted: BasePriceFormatted,
    @SerializedName("category_ids")
    val categoryIds: List<Int>,
    @SerializedName("company_id")
    val companyId: String,
    @SerializedName("discount")
    val discount: Int,
    @SerializedName("discount_formatted")
    val discountFormatted: DiscountFormatted,
    @SerializedName("display_price")
    val displayPrice: Double,
    @SerializedName("display_price_formatted")
    val displayPriceFormatted: SubtotalDiscountFormatted,
    @SerializedName("edp_shipping")
    val edpShipping: String,
    @SerializedName("exceptions_type")
    val exceptionsType: String,
    @SerializedName("extra")
    val extra: Extra,
    @SerializedName("is_edp")
    val isEdp: String,
    @SerializedName("main_category")
    val mainCategory: Int,
    @SerializedName("main_pair")
    val mainPair: MainPair,
    @SerializedName("modifiers_price")
    val modifiersPrice: Int,
    @SerializedName("options_type")
    val optionsType: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("price_formatted")
    val priceFormatted: PriceFormatted,
    @SerializedName("product")
    val product: String,
    @SerializedName("product_code")
    val productCode: String,
    @SerializedName("product_id")
    val productId: Int,
    @SerializedName("product_options")
    val productOptions: Map<Int,Int>,
    @SerializedName("product_type")
    val productType: String,
    @SerializedName("promotions")
    val promotions: List<Any>,
    @SerializedName("return_period")
    val returnPeriod: String,
    @SerializedName("stored_discount")
    val storedDiscount: String,
    @SerializedName("stored_price")
    val storedPrice: String
)