package com.tatayab.tatayab.listener

import com.tatayab.model.MapValueXXX
import com.tatayab.model.PaymentMethod
import com.tatayab.model.Product


interface OnPaymentListener {
    fun onPaymentChecked(paymentMethod: PaymentMethod)
}