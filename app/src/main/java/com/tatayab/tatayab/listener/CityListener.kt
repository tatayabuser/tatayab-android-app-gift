package com.tatayab.tatayab.listener

import com.tatayab.model.requests.AddressRequest
import com.tatayab.model.responses.SelectCityOrAreaModel


interface CityListener {
      fun onCitySelected(city: SelectCityOrAreaModel)
 }