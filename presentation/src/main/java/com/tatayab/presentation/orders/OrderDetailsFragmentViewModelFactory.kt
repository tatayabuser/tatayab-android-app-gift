package com.tatayab.presentation.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.orders.GetOrderDetails
import com.tatayab.domain.interactor.orders.GetOrderTracking
import com.tatayab.domain.repository.TatayabRepository

@Suppress("UNCHECKED_CAST")
class OrderDetailsFragmentViewModelFactory @AssistedInject constructor(
    private val getOrderDetails: GetOrderDetails,
    private val getOrderTracking: GetOrderTracking,
    private val repository: TatayabRepository,
    @Assisted val orderId: String,
    @Assisted val languageCode: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OrderDetailsFragmentViewModel(repository,getOrderDetails,getOrderTracking,orderId = orderId,languageCode = languageCode) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(orderId: String,languageCode: String): OrderDetailsFragmentViewModelFactory
    }
}