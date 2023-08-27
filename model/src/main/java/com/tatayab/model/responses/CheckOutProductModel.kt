package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class CheckOutProductModel (
    @SerializedName("name")
    val name: String? = null,
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("price")
    val price: Float? = 0f,
    @SerializedName("amount")
    val amount: Int? = 0,
    @SerializedName("is_gift")
    val isGift: Int? = 0,
    @SerializedName("ref")
    val ref: Int? = 0,
    @SerializedName("image")
    val image: String? = null,
    @SerializedName("brand")
    val brand: String? = null,
    val productSku: String? = null,
    val currencyCode: String? = "",
    var isInWishList: Boolean = false,
    var originalPrice: Float? = 0f
)


/*
*  {
                    "name": "Thameen - Red Royal Sapphire Eau De Parfum  - Unisex",
                    "code": "THA-001-T090",
                    "price": 85,
                    "amount": 1,
                    "image": "https://main.tatayab.com/images/detailed/12/THA-001-T090.jpg",
                    "brand": "Thameen "
                },
* */