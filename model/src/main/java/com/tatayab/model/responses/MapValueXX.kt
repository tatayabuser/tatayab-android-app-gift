package com.tatayab.model.responses


import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName
import com.tatayab.model.Image
import com.tatayab.model.SubtotalDiscountFormatted
import com.tatayab.model.common.ImageSerializer

data class MapValueXX(
    @SerializedName("delivery_time")
    val deliveryTime: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("destination")
    val destination: String,
    @SerializedName("disable_payment_ids")
    val disablePaymentIds: List<String>,
    @SerializedName("free_shipping")
    val freeShipping: Boolean,
    @SerializedName("group_key")
    val groupKey: Int,
    @JsonAdapter(ImageSerializer::class)
    val image: Image? = null,
    @SerializedName("max_weight")
    val maxWeight: String,
    @SerializedName("min_weight")
    val minWeight: String,
    @SerializedName("module")
    val module: Any,
    @SerializedName("rate")
    val rate: Double,
    @SerializedName("rate_calculation")
    val rateCalculation: String,
    @SerializedName("rate_formatted")
    val rateFormatted: SubtotalDiscountFormatted,
    @SerializedName("service_code")
    val serviceCode: Any,
    @SerializedName("service_id")
    val serviceId: String,
    @SerializedName("shipping")
    val shipping: String,
    @SerializedName("shipping_id")
    val shippingId: String,
    @SerializedName("taxed_price")
    val taxedPrice: Int
)