package com.tatayab.tatayab.listener

import com.tatayab.model.responses.CountryResponse


interface OnCountryListener {

    fun onCountrySelected(country: CountryResponse)
}