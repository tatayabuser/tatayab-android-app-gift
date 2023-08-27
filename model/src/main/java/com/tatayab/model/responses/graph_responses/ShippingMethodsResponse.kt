package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class ShippingMethodsResponse (@SerializedName("data") val customerDataModel: ShippingMethodsOnCartModel):BaseGrapgQlResponse() {
    class ShippingMethodsOnCartModel(@SerializedName("cart") val cartModel: CartModel?)
    class CartModel(@SerializedName("shipping_addresses") val shippingAddressesList: ArrayList<ShippingAddressModel?>)
    class ShippingAddressModel(@SerializedName("available_shipping_methods") val mShippingMethodList: ArrayList<SelectedShippingMethodModel>)

    class SelectedShippingMethodModel(
        @SerializedName("carrier_code") val carrier_code: String? = "",
        @SerializedName("method_code") val method_code: String? = "",
        @SerializedName("source_code") val source_code: String? = ""
     )
}

/*{
	"data": {
		"cart": {
			"shipping_addresses": [
				{
					"available_shipping_methods": [
						{
							"method_code": "flatrate",
							"carrier_code": "flatrate",
							"source_code": "KW-WH"
						}
					]
				}
			]
		}
	}
}*/