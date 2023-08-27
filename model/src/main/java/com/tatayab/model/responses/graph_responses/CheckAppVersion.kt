package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

data class CheckAppVersion(@SerializedName("data") var data : CheckVersionGraphql) : BaseGrapgQlResponse()
data class CheckVersionGraphql(@SerializedName("CheckVersionGraphql") var CheckVersionGraphql: Boolean)


//{
//    "data": {
//    "CheckVersionGraphql": false
//}
//}