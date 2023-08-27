package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class CheckOutAddressModel (
    @SerializedName("id")
     var id: Int? = 0,
    @SerializedName("name")
     var name: String? = null,
    @SerializedName("country")
     var country: String? = null,
    @SerializedName("city")
     var city: String? = null,
    @SerializedName("area")
     var area: String? = null,
    @SerializedName("block")
     var block: String? = null,
    @SerializedName("address")
     var address: String? = null,
    @SerializedName("paci")
     var paci: String? = null

)



/*
*  "id": 161,
        "name": "بيتي",
        "country": "Kuwait",
        "city": "",
        "area": "",
        "block": "١٥",
        "address": "مبارك الكبير ق ٦ ش ١٥ م١٧",
        "paci": ""*/