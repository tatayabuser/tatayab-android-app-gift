package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class CheckTokenValidationResponse (@SerializedName("data") val data: TokenDataModel):BaseGrapgQlResponse(){
    class TokenDataModel (@SerializedName("checkTokenAlive") val checkTokenAliveModel: CheckTokenAliveModel)
    class CheckTokenAliveModel (
        @SerializedName("status") var status: Boolean? = true,
        @SerializedName("type") val type: String? = "",
        @SerializedName("action") val action: String? = "",

                                  )
}
/*{"data":{"checkTokenAlive":{"status":false,"type":"token_expired","action":"logout"}}}

*/