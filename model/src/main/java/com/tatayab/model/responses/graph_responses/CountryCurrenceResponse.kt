package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class CountryCurrenceResponse (@SerializedName("data") val data: DataModel):BaseGrapgQlResponse(){
    class DataModel (@SerializedName("currency") val currencyModel:CurrencyModel)
    class CurrencyModel (
        @SerializedName("base_currency_code") val currencyCode:String?="",
        @SerializedName("default_display_currency_code") val default_display_currency_code:String?=""
    )
     }


/*{
	"data": {
		"currency": {
			"base_currency_code": "KWD",
			"default_display_currency_code": "USD"
		}
	}
}*/