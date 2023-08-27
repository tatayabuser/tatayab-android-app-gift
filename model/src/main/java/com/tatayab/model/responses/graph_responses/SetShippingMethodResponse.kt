package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class SetShippingMethodResponse (@SerializedName("data") val customerDataModel: CustomerDataModel):BaseGrapgQlResponse() {
    class CustomerDataModel(@SerializedName("setShippingMethodsOnCart") val setShippingMethodsOnCartModel: SetShippingMethodsOnCartModel?)
    class SetShippingMethodsOnCartModel(@SerializedName("cart") val mShippingMethodsOnCartModel: ShippingMethodsOnCartModel?)
    class ShippingMethodsOnCartModel(@SerializedName("shipping_addresses") val shippingAddressesList: ArrayList<ShippingAddressModel?>)
    class ShippingAddressModel(@SerializedName("selected_shipping_method") val mSelectedShippingMethodModel: SelectedShippingMethodModel)

    class SelectedShippingMethodModel(
        @SerializedName("carrier_code") val carrier_code: String? = "",
        @SerializedName("method_code") val method_code: String? = "",
        @SerializedName("carrier_title") val carrier_title: String? = "",
        @SerializedName("method_title") val method_title: String? = ""
    )
}

/*{
	"data": {
		"setShippingMethodsOnCart": {
			"cart": {
				"shipping_addresses": [
					{
						"selected_shipping_method": {
							"carrier_code": "KW-WH:flatrate",
							"method_code": "KW-WH:flatrate",
							"carrier_title": "KW-WH:Tatayab Shipments",
							"method_title": "KW-WH:Tatayab Shipments"
						}
					}
				]
			}
		}
	}
}*/