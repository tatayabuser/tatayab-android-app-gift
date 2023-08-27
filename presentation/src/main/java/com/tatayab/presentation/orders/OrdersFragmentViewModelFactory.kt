package com.tatayab.presentation.orders

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.product.GetCustomerAlsoBought
import com.tatayab.domain.interactor.product.GetProductDetails
import com.tatayab.domain.interactor.product.GetProductReviews
import com.tatayab.domain.repository.TatayabRepository
import org.intellij.lang.annotations.Language

@Suppress("UNCHECKED_CAST")
class OrdersFragmentViewModelFactory @AssistedInject constructor(
    private val repository: TatayabRepository,
    @Assisted val languageCode: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return OrdersFragmentViewModel(repository,languageCode) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): OrdersFragmentViewModelFactory
    }
}