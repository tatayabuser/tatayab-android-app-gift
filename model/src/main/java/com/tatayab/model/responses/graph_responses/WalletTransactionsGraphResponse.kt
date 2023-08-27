package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class WalletTransactionsGraphResponse(@SerializedName("data") val customerDataModel: CustomerDataModel? = null) :
    BaseGrapgQlResponse() {
    class CustomerDataModel(@SerializedName("customer") val mCustomerModel: CustomerModel? = null)
    class CustomerModel(@SerializedName("credit") val mCreditModel: CreditModel? = null)
    class CreditModel(@SerializedName("transactions") val transactionsList: ArrayList<TransactionModel>? = null)
    class TransactionModel(
        @SerializedName("balance_amount") val balanceAmountModel: BalanceAmountModel? = null,
        @SerializedName("balance_delta") val balanceDeltaModel: BalanceDeltaModel? = null,
        @SerializedName("action") val action: String? = "",
        @SerializedName("message") val message: String? = "",
        @SerializedName("currency_code") val currency_code: String? = "",
        @SerializedName("created_at") val created_at: String? = "",
        @SerializedName("transaction_id") val transaction_id: Int? = 0

    )
    class BalanceAmountModel(
        @SerializedName("currency") val currency: String? = "",
        @SerializedName("value") val value: Float? = 0f
    )
    class BalanceDeltaModel(
        @SerializedName("currency") val currency: String? = "",
        @SerializedName("value") val value: Float? = 0f
    )

}
/*{
	"data": {
		"customer": {
			"credit": {
				"transactions": [
					{
						"balance_amount": {
							"currency": null,
							"value": 1
						},
						"balance_delta": {
							"currency": null,
							"value": 1
						},
						"action": "manual",
						"message": "1",
						"currency_code": "KWD",
						"created_at": "2022-06-08 00:29:11",
						"transaction_id": 154
					},
					{
						"balance_amount": {
							"currency": null,
							"value": 0.5
						},
						"balance_delta": {
							"currency": null,
							"value": -0.5
						},
						"action": "used",
						"message": "Order #o|5000000352",
						"currency_code": "KWD",
						"created_at": "2022-06-08 01:11:48",
						"transaction_id": 155
					},
					{
						"balance_amount": {
							"currency": null,
							"value": 0
						},
						"balance_delta": {
							"currency": null,
							"value": -0.5
						},
						"action": "used",
						"message": "Order #o|5000000353",
						"currency_code": "KWD",
						"created_at": "2022-06-08 01:11:51",
						"transaction_id": 156
					}
				]
			}
		}
	}
}*/