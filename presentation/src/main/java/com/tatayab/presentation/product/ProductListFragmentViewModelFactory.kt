package com.tatayab.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.filter.GetFilter
import com.tatayab.domain.interactor.product.GetSpecificProducts
import com.tatayab.domain.repository.TatayabRepository

@Suppress("UNCHECKED_CAST")
class ProductListFragmentViewModelFactory @AssistedInject constructor(
    private val repository: TatayabRepository,
    private val getFilter: GetFilter,
    private val getSpecificProducts: GetSpecificProducts,
    @Assisted  val argumentId: String,
    @Assisted  val type: String,
    @Assisted  val languageCode: String,
    @Assisted  val graphKey: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductListFragmentViewModel(
            repository,
            getFilter,
            getSpecificProducts,
            argumentId,
            type,
            languageCode,
            graphKey
        ) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(argumentId: String, type: String, languageCode: String, graphKey: String): ProductListFragmentViewModelFactory
    }
}