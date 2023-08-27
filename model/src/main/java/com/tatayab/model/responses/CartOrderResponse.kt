package com.tatayab.model.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import com.tatayab.model.responses.graph_responses.CartItemsResponse
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CartOrderResponse(
    @SerializedName("product_id")
    val product_id: String? = "",
    @SerializedName("title")
    val title: String? = "",
    @SerializedName("supplier_id")
    val supplier_id: String? = "",
    @SerializedName("supplier_name")
    val supplier_name: String? = "",
    @SerializedName("price")
    val price: Float? = null,
    @SerializedName("original_price")
    val original_price: Float? = null,
    @SerializedName("image")
    val image: String? = "",
    @SerializedName("disc_perc")
    val disc_perc: String? = null,
    @SerializedName("inWishlist")
    var inWishlist: Boolean? = false,
    @SerializedName("amount")
    var amount: Int? = 0,
    @SerializedName("is_gift")
    var isGift: Int? = 0,
    @SerializedName("product_options")
    val productOptions: Map<String, String>? = HashMap(),
) : Parcelable{
    var productGraphID: String? = ""
    var productUID: String? = ""
    var currencyId: String? = ""
    var countryId: String? = ""
    var mShippingDetailsModel: CartItemsResponse.ShippingDetailsModel?=null
    var isFirstItemPerCountry:Boolean? = false
}

/*
 *{"product_id":418,
* "title":"Tatera - 500ml",
* "supplier_id":"19",
* "supplier_name":"Tatera",
* "price":6,"image":"https:\/\/main.tatayab.com\/images\/detailed\/1\/TATERA.jpg",
* "product_options":[],
* "amount":1,
* "inWishlist":false}
* */