package com.tatayab.tatayab.listener

import com.tatayab.model.MapValueXXX
import com.tatayab.model.PaymentMethod
import com.tatayab.model.Product
import com.tatayab.model.filter.SortItem


interface OnSortListener {
    fun onSortOptionChecked(sortItem: SortItem)
}