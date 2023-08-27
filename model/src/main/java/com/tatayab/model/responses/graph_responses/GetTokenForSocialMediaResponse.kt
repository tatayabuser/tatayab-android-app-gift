package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

class GetTokenForSocialMediaResponse (@SerializedName("data") val data: GetTokenModel):BaseGrapgQlResponse(){
    class GetTokenModel (@SerializedName("authenticateCustomerWithSocialLogin") val generateCustomerToken: GenerateCustomerTokenModel)
    class GenerateCustomerTokenModel (@SerializedName("token") val token: String)
    }


/*{
	"data": {
		"authenticateCustomerWithSocialLogin": {
			"token": "tl6mn7aiw3fzhjmrx043zly31tlszld1"
		}
	}
}*/