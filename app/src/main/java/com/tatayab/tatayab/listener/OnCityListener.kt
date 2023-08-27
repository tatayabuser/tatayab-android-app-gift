package com.tatayab.tatayab.listener

import com.tatayab.model.responses.CityModel
import com.tatayab.model.responses.CountryResponse

interface OnCityListener {

    fun onCitySelected(city: CityModel)
}