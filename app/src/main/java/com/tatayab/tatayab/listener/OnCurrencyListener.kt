package com.tatayab.tatayab.listener

import com.tatayab.model.responses.CurrencyResponse


interface OnCurrencyListener {

    fun onCurrencySelected(currencyId: CurrencyResponse)
}