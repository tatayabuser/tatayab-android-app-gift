package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class CheckOutOrderSubTotalsModel(
    @SerializedName("labels")
    var labels: ArrayList<CheckoutLabelModel>?= null
)


/*
 "labels": [
                {
                    "name": "Total",
                    "value": 124.5
                }
            ]
*
* */