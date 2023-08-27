package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class ShippingAddressRequest(
    @SerializedName("firstname") val firstname: String,
    @SerializedName("lastname") val lastname: String,
    @SerializedName("company") val company: String?="Tatayab",
    @SerializedName("street") val street: String="0",
    @SerializedName("city") val city: String,
    @SerializedName("region") val region: String?="0",
    @SerializedName("postcode") val postcode: String,
    @SerializedName("country_code") val country_code: String,
    @SerializedName("telephone") val telephone: String,
    @SerializedName("address_name") val address_name: String,
    @SerializedName("address") val address: String,
    @SerializedName("extra") val extra: String,
    @SerializedName("save_in_address_book") val save_in_address_book: Boolean?=false,
    @SerializedName("house_building") val house_building: String? ="house_building",
    @SerializedName("addr_type") val addr_type: String?="",
    @SerializedName("city_id") val city_id: String="0",
    @SerializedName("region_id") val region_id: String="0",
    var isAreaOneLevel:Boolean? = false
    )
{
    @SerializedName("cartId")
    var cartId: String = ""

}

/* address: {
            firstname: "Gabbar"
            lastname: "Singh"
            company: "Company Name"
            street: ["3320 N Crescent Dr"]
            city: "Los Angeles"
            region: "Kuwait"
            postcode: "90210"
            country_code: "KW"
            telephone: "123-456-0000"
            save_in_address_book: false
						house_building:"Test House/Building"
						addr_type:"House"
						city_id:"Addan"
          }*/