package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class CheckOutProductsModel (
    @SerializedName("wh_country")
    var wh_country: String? = null,
    @SerializedName("wh_flag")
    var wh_flag: String? = null,
    @SerializedName("delivery_msg")
    var delivery_msg: String? = null,
    @SerializedName("total_products")
    var total_products: Int? = 0,
    @SerializedName("products")
    var products: ArrayList<CheckOutProductModel>? = null
){
    var deliveryFrom:String? = ""
    var deliveryTo:String? = ""
    var countryCourseCode:String = ""
}


/*
*  {
            "wh_country": "Kuwait",
            "wh_flag": "https://main.tatayab.com/flags/KW.png",
            "delivery_msg": "From: Thu. 13 Aug., 2020 - To: Sun. 16 Aug., 2020",
            "total_products": 4,
            "products": [
                {
                    "name": "Thameen - Red Royal Sapphire Eau De Parfum  - Unisex",
                    "code": "THA-001-T090",
                    "price": 85,
                    "amount": 1,
                    "image": "https://main.tatayab.com/images/detailed/12/THA-001-T090.jpg",
                    "brand": "Thameen "
                },
                {
                    "name": "مجموعة مخصصة - 2",
                    "code": "TTB-007-X085",
                    "price": 10,
                    "amount": 1,
                    "image": "https://main.tatayab.com/images/detailed/12/TTB-007-X085.jpg",
                    "brand": "Tatera"
                },
                {
                    "name": "Al Jessar Mubhkar Large - Gold",
                    "code": "AJR-006-G195",
                    "price": 12,
                    "amount": 1,
                    "image": "https://main.tatayab.com/images/detailed/15/AJR-006-G195.jpg",
                    "brand": "Al Jassar"
                },
                {
                    "name": "Oud Junaid - 3 ML (1/4 Tola)",
                    "code": "JND-009-I041",
                    "price": 16,
                    "amount": 1,
                    "image": "https://main.tatayab.com/images/detailed/14/JND-009-I041.jpg",
                    "brand": "Junaid"
                }
            ]
        }
* */