package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class TotalPricesModel(
    @SerializedName("child_totals")
    var childTotals: List<CheckOutChildModel>? = null,
    @SerializedName("order_totals")
    var orderTotals: CheckOutOrderTotalsModel? = null,
    @SerializedName("order_subtotals")
    var orderSubtotals: CheckOutOrderSubTotalsModel? = null
)




/*
   "prices": {
        "grand_total": {
          "value": 10,
          "currency": "KWD"
        },
        "subtotal_excluding_tax": {
          "value": 10,
          "currency": "KWD"
        },
        "subtotal_including_tax": {
          "value": 10,
          "currency": "KWD"
        },
        "subtotal_with_discount_excluding_tax": {
          "formatted_price": "KWD10.00",
          "value": 10,
          "currency": "KWD"
        },
        "applied_taxes": []
      },

*{
    "totals": {
        "child_totals": [
            {
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

* */