package com.tatayab.tatayab.checkout

import com.tatayab.model.responses.CheckOutPaymentModel

interface PaymentListener {
    fun onPaymentMethodSelected( model: CheckOutPaymentModel)
    fun onPaymentMethodDefaultSelected( model: CheckOutPaymentModel)
}