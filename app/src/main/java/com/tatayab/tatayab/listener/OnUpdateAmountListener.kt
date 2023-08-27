package com.tatayab.tatayab.listener

import com.tatayab.model.responses.CartOrderResponse
import com.tatayab.presentation.OperationType


interface OnUpdateAmountListener {
    fun onUpdateAmount(operationType: OperationType, productId: String, product: CartOrderResponse, value: Int, position: Int)
    fun getGiftOptions()


}