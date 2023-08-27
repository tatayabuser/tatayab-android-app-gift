package com.tatayab.model

import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.responses.CurrencyResponse

data class UserSetting(
    val country: CountryResponse? = CountryResponse("KW", "Kuwait", "+965", "8", "5,6,9", "")
)
