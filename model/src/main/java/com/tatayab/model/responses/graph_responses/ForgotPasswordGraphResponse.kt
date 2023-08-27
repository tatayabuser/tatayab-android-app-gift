package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class ForgotPasswordGraphResponse(@SerializedName("data") val customerDataModel: CustomerDataModel? = null) :
    BaseGrapgQlResponse() {
    class CustomerDataModel(@SerializedName("requestPasswordResetEmail") val requestPasswordResetEmail: Boolean? = false)
}
/*{
	"data": {
		"requestPasswordResetEmail": true
	}
}*/