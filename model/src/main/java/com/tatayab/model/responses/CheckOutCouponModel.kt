package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class CheckOutCouponModel (
    @SerializedName("name")
    var name: String? = null,
    @SerializedName("code")
    var code: String? = null,
    @SerializedName("id")
    val id: Int? = null
    )


/*
* "coupon": {
        "name": "tetgentoperc",
        "code": "tetgentoperc",
        "id": 363
    },
* */