package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import kotlinx.android.parcel.RawValue

@Parcelize
data class MapValueXXX(
    @SerializedName("am_ages")
    val amAges: String? = null,
    @SerializedName("amount")
    val amount: Int = 0,
    var availableAmount: Int? = null,
    @SerializedName("amount_total")
    val amountTotal: Int? = null,
    @SerializedName("base_price")
    val basePrice: Double? = null,
    @SerializedName("base_price_formatted")
    val basePriceFormatted: BasePriceFormatted? = null,
    @SerializedName("calculation")
    val calculation: List<@RawValue Any>? = null,
    @SerializedName("category_ids")
    val categoryIds: List<Int>? = null,
    @SerializedName("company_id")
    val companyId: String? = null,
    @SerializedName("company_name")
    val companyName: String? = null,
    @SerializedName("company_status")
    val companyStatus: String? = null,
    @SerializedName("discount")
    val discount: Int? = null,
    @SerializedName("discount_formatted")
    val discountFormatted: DiscountFormatted? = null,
    @SerializedName("display_price")
    val displayPrice: Double? = null,
    @SerializedName("list_price")
    val list_price: Double? = null,
    @SerializedName("display_price_formatted")
    val displayPriceFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("display_subtotal")
    val displaySubtotal: Double? = null,
    @SerializedName("display_subtotal_formatted")
    val displaySubtotalFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("edp_shipping")
    val edpShipping: String? = null,
    @SerializedName("exceptions_type")
    val exceptionsType: String? = null,
    @SerializedName("extra")
    val extra: Extra? = null,
    @SerializedName("free_shipping")
    val freeShipping: String? = null,
    @SerializedName("in_stock")
    val inStock: Int = 0,
    @SerializedName("is_edp")
    val isEdp: String? = null,
    @SerializedName("list_qty_count")
    val listQtyCount: String? = null,
    @SerializedName("main_category")
    val mainCategory: Int? = null,
    @SerializedName("main_pair")
    val mainPair: MainPair,
    @SerializedName("max_qty")
    val maxQty: Int? = 0,
    @SerializedName("min_qty")
    val minQty: Int? = 0,
    @SerializedName("modifiers_price")
    val modifiersPrice: Int? = null,
    @SerializedName("options_count")
    val optionsCount: String? = null,
    @SerializedName("options_type")
    val optionsType: String? = null,
    @SerializedName("original_price")
    val originalPrice: Double? = null,
    @SerializedName("original_price_formatted")
    val originalPriceFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("price")
    var price: Float = 0f,
    @SerializedName("price_formatted")
    val priceFormatted: PriceFormatted? = null,
    @SerializedName("product")
    val product: String? = null,
    @SerializedName("product_code")
    val productCode: String? = null,
    @SerializedName("product_id")
    val productId: String? = null,
    @SerializedName("product_options")
    val productOptions: Map<String, String>? = null,
    @SerializedName("product_options_detailed")
    var productOptionsDetailed: Map<String, ProductOptionsDetailed>? = null,
    @SerializedName("product_type")
    val productType: String? = null,
    @SerializedName("promotions")
    val promotions: List<@RawValue Any>? = null,
    @SerializedName("qty_step")
    val qtyStep: String? = null,
    @SerializedName("return_period")
    val returnPeriod: String? = null,
    @SerializedName("shipping_freight")
    val shippingFreight: String? = null,
    @SerializedName("shipping_params")
    val shippingParams: ShippingParams? = null,
    @SerializedName("short_description")
    val shortDescription: String? = null,
    @SerializedName("stored_discount")
    val storedDiscount: String? = null,
    @SerializedName("stored_price")
    val storedPrice: String? = null,
    @SerializedName("subtotal")
    val subtotal: Double? = null,
    @SerializedName("subtotal_formatted")
    val subtotalFormatted: SubtotalDiscountFormatted? = null,
    @SerializedName("tax_ids")
    val taxIds: String? = null,
    @SerializedName("tracking")
    val tracking: String? = null,
    @SerializedName("variation_options")
    val variationOptions: @RawValue Any? = null,
    @SerializedName("weight")
    val weight: Double? = null,
    @SerializedName("zero_price_action")
    val zeroPriceAction: String? = null,
    @SerializedName("is_In_WishList")
    var isInWishList: Boolean? = false,
    @SerializedName("productInCart")
    val productInCart: String? = null,
    @SerializedName("supplier_name")
    val supplierName: String? = null,
    @SerializedName("supplier_id")
    val supplierId: String? = null,
    val itemCount: Int? = null
) : Parcelable