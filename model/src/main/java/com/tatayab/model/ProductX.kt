package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ProductX(
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("product_id")
    val product_id: String = "",
    @SerializedName("product_id")
    val product_id2: String = "",
    val product_sku: String = "",
    @SerializedName("supplier_id")
    val supplier_id: String? = "",
    @SerializedName("supplier_name")
    val supplier_name: String? = "",
    @SerializedName("price")
    val price: Float = 0f,
    @SerializedName("old_price")
    val old_price: Float? = 0f,
    @SerializedName("discount_perc")
    val discount_perc: Float? = 0f,
    @SerializedName("can_buy")
    val can_buy: Int? = 0,
    @SerializedName("image")
    val image: String? = "",
    val currency: String? = null,
    @SerializedName("notes")
    val notes: String? = "",
    @SerializedName("seo_name")
    val seoName: String? = "",
    @SerializedName("inWishlist")
    var inWishlist: Int = 0,
    var productWishlistId: Int? = 0,
    @SerializedName("has_options")
    val has_options: Int = 0,
    @SerializedName("is_free_delivery")
    val is_free_delivery: Int = 0,
    @SerializedName("product_link") var productLink: String? = null,
    var currencyCode: String? = "",
    var source: String? = "",
    var uid: String? = "",
    var percent_off: Float? = 0f,
    var category:String?=""
) : Parcelable {
    var productSelectedAsGift: Boolean = false
    var amount: Int? = 0
    var isGift: Int? = 0
    var productOptionsSelected: Map<String, String>? = HashMap()
    var isMerged: Boolean = false
    var mergingError: String? = null
}


//"product_id": "4517",
//"category_id": 2,
//"title": "Alien (Women ) - Edp - 90Ml",
//"supplier_id": "173",
//"supplier_name": "Thierry Mugler",
//"price": 36,
//"old_price": 0,
//"discount_perc": 0,
//"can_buy": 1,
//"image": "https://alpha.tatayab.com/images/detailed/16/TRM-001-R896_vlny-w6.jpg",
//"inWishlist": 0,
//"has_options": 0,
//"is_free_delivery": 0,
//"notes": "",
//"seo_name": "alien-women-edp-90ml"