package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class RestoreCartResponse (@SerializedName("data") val data: DatatModel):BaseGrapgQlResponse(){
    class DatatModel (@SerializedName("RestoreCart") val restoreCart: String?="")
}
/*{
	"data": {
		"RestoreCart": "nNjH01YOf6DlGRTnI3TNde3qPRoR7WeL"
	}
}*/