package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class WalletGraphResponse(@SerializedName("data") val customerDataModel: CustomerDataModel? = null) :
    BaseGrapgQlResponse() {
    class CustomerDataModel(@SerializedName("customer") val mCustomerModel: CustomerModel? = null)
    class CustomerModel(@SerializedName("credit") val mCreditModel: CreditModel? = null)
    class CreditModel(@SerializedName("balance") val balanceModel: BalanceModel? = null)
    class BalanceModel(@SerializedName("amount") val amountModel: AmountModel? = null)
    class AmountModel(
        @SerializedName("currency") val currency: String? = "",
        @SerializedName("value") val value: Float? = 0f
    )

}
/*{
	"data": {
		"customer": {
			"credit": {
				"balance": {
					"amount": {
						"currency": null,
						"value": 0
					}
				}
			}
		}
	}
}*/