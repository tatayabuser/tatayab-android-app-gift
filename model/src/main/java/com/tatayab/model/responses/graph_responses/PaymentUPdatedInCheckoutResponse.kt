package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class PaymentUpdateInCheckoutResponse (@SerializedName("data") val dataModel: DataModel):BaseGrapgQlResponse() {

    class DataModel(@SerializedName("setPaymentMethodOnCart") val setPaymentMethodOnCart: PaymentMethodOnCartModel?)
    class PaymentMethodOnCartModel(@SerializedName("cart") val cartModel: CartModel?)
    class CartModel(@SerializedName("selected_payment_method") val selectedPaymentMethodModel: SelectedPaymentMethodModel?)
    class SelectedPaymentMethodModel(@SerializedName("code") val code: String?)
}
/*{
	"data": {
		"setPaymentMethodOnCart": {
			"cart": {
				"selected_payment_method": {
					"code": "knet"
				}
			}
		}
	}
}*/