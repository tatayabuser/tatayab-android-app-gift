package com.tatayab.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SearchProductModel(
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("product_id")
    val product_id: Int = 0,
    @SerializedName("supplier_id")
    val supplier_id: Int? = 0,
    @SerializedName("supplier_name")
    val supplier_name: String?="",
    val product_sku: String?="",
    @SerializedName("price")
    val price: String?= "",
    val currency: String?= "",
    @SerializedName("old_price")
    val old_price:  String?= "",
    @SerializedName("discount_perc")
    val discount_perc: Float?=0f,
    @SerializedName("can_buy")
    val can_buy: Int? = 0,
    @SerializedName("image")
    val image: String? ="",
    @SerializedName("inWishlist")
    var inWishlist: Int = 0,
    @SerializedName("has_options")
    val has_options: Int = 0,
    @SerializedName("is_free_delivery")
    val is_free_delivery: Int = 0,
    @SerializedName("product_link") var productLink: String? = null,
    @SerializedName("notes") var notes: String? = null
) : Parcelable


/*{"product_id":3455,"title":"Private Collection (Women)-edp-50 ML","supplier_id":6744,"supplier_name":"Estee Lauder","price":"","old_price":"37.75 KWD",
    "discount_perc":0,"can_buy":1,"image":"","inWishlist":0,"has_options":0,"is_free_delivery":0,"notes":""}*/