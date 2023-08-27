package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName

data class ReviewCartResponse(
    @SerializedName("totals")
    val totalsModel: TotalPricesModel? = null,
    @SerializedName("products")
    val productsList: List<CheckOutProductsModel>? = null,
    @SerializedName("payments")
    val paymentsModel: List<CheckOutPaymentModel>? = null,
    @SerializedName("address")
    val addressModel: CheckOutAddressModel? = null,
    @SerializedName("msg")
    val msg: String? = null,
    @SerializedName("coupon")
    val couponModel: CheckOutCouponModel? = null,
    @SerializedName("success")
    val success: Int = -1,
    @SerializedName("notes")
    val notes: String? = "",
    @SerializedName("shipment_msg")
    val shipment_msg: String? = "",
    @SerializedName("apple_pay")
    val apple_pay: Int = -1,
    var appliedCouponCode: String? = "",
    var subtotalWithDiscountExcludingTax:Float = 0f
)


/* {
    "totals": {
        "child_totals": [
            {
                "wh_country": "Kuwait",
                "wh_flag": "https://main.tatayab.com/flags/KW.png",
                "total_products": 4,
                "labels": [
                    {
                        "name": "Subtotal",
                        "value": 123
                    },
                    {
                        "name": "Shipping cost +",
                        "value": 1.5
                    }
                ]
            }
        ],
        "order_totals": {
            "labels": [
                {
                    "name": "Total",
                    "value": 124.5
                }
            ]
        },
        "order_subtotals": {
            "labels": []
        }
    },
    "products": [
        {
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
    ],
    "payments": [
        {
            "name": " K-net",
            "id": 12,
            "fees": 0,
            "is_selected": 0,
            "image": "https://main.tatayab.com/images/payment/3/lopp.png"
        },
        {
            "name": "Visa, Mastercard",
            "id": 13,
            "fees": 0,
            "is_selected": 0,
            "image": "https://main.tatayab.com/images/payment/3/vise.png"
        },
        {
            "name": "Cash on delivery",
            "id": 6,
            "fees": 3,
            "is_selected": 0,
            "image": "https://main.tatayab.com/images/payment/3/vise2.png"
        }
    ],
    "address": {
        "id": 161,
        "name": "بيتي",
        "country": "Kuwait",
        "city": "",
        "area": "",
        "block": "١٥",
        "address": "مبارك الكبير ق ٦ ش ١٥ م١٧",
        "paci": ""
    },
     "coupon": {
        "name": "tetgentoperc",
        "code": "tetgentoperc",
        "id": 363
    },
    "msg": "",
    *
}*/
