package com.tatayab.tatayab.listener

import com.tatayab.model.requests.AddressRequest


interface OnHomeNavigationListener {
    fun navigatedToHomeFragment()
    fun navigatedToCategoryFragment()
}