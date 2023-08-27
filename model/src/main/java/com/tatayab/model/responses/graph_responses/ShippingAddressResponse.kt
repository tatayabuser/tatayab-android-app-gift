package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class ShippingAddressResponse(
    @SerializedName("data") val data: DataModel):BaseGrapgQlResponse() {

    class DataModel(@SerializedName("setBillingAddressOnCart") val setBillingAddressOnCart: SetBillingAddressOnCartModel)
    class SetBillingAddressOnCartModel(@SerializedName("cart") val Model: CartModel)
    class CartModel()
}

/* {
	"data": {
		"setShippingAddressesOnCart": {
			"cart": {
				"shipping_addresses": [
					{
						"firstname": "Gabbar",
						"lastname": "Singh",
						"company": "Company Name",
						"street": [
							"3320 N Crescent Dr"
						],
						"city": "Los Angeles",
						"region": {
							"code": "Kuwait",
							"label": "Kuwait"
						},
						"postcode": "90210",
						"telephone": "123-456-0000",
						"country": {
							"code": "KW",
							"label": "KW"
						}
					}
				]
			}
		}
	}
}*/