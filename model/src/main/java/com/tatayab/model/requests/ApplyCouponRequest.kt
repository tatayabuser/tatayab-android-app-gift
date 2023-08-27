package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName
import com.tatayab.model.ProductCoupon

data class ApplyCouponRequest(
    @SerializedName("country_code")
    val countryCode: String,
    @SerializedName("coupon_code")
    val couponCode: String,
    @SerializedName("coupon_data")
    val couponData: String,
    @SerializedName("currency_id")
    val currencyId: String,
    @SerializedName("Email")
    val email: String?,
    @SerializedName("products")
    val products: List<ProductCoupon>,
    @SerializedName("shipping_id")
    val shippingId: String
)