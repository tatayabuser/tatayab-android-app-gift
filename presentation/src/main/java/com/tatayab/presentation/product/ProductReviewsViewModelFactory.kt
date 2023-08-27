package com.tatayab.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.repository.TatayabRepository

@Suppress("UNCHECKED_CAST")
class ProductReviewsViewModelFactory @AssistedInject constructor(
private val repository: TatayabRepository,
@Assisted  val argument: String
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductReviewsFragmentViewModel(
            repository,
            argument
        ) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(argument: String): ProductReviewsViewModelFactory
    }
}