package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class SaveFirebaseTokenResponse (@SerializedName("data") val data: DataModel):BaseGrapgQlResponse(){
    class DataModel (@SerializedName("subscribeToken") val subscribeTokenModel: SubscribeTokenModel?)
    class SubscribeTokenModel (@SerializedName("message") val messageString: String?="")
}
/*{
	"data": {
		"subscribeToken": {
			"message": "Successfully Subscribe Token"
		}
	}
}*/