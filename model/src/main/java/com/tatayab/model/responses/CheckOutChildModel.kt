package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class CheckOutChildModel(
    @SerializedName("wh_country")
    val wh_country: String?= null,
    @SerializedName("wh_flag")
    val wh_flag: String?= null,
    @SerializedName("total_products")
    val total_products: Int?= 0,
    @SerializedName("labels")
    val labels: List<CheckoutLabelModel>?= null
)


/*
* {
                "wh_counstry": "Kuwait",
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
*
* */