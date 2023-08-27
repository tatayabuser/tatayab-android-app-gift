package com.tatayab.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.product.GetProductsWithSearch
import com.tatayab.domain.interactor.product.SearchRecommanededProductsListExecution
import com.tatayab.domain.interactor.product.SearchSuggestionListExecution
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.presentation.search.SearchFragmentViewModel

@Suppress("UNCHECKED_CAST")
class SearchFragmentViewModelFactory @AssistedInject constructor(
    private val repository: TatayabRepository,
    private val getSearch: GetProductsWithSearch,
    @Assisted  val languageCode: String,
    private val mSearchSuggestionListExecution: SearchSuggestionListExecution,
    private val mSearchRecommanededProductsListExecution: SearchRecommanededProductsListExecution
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SearchFragmentViewModel(
            getSearch,
            languageCode,
            repository,
            mSearchSuggestionListExecution,
            mSearchRecommanededProductsListExecution
        ) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): SearchFragmentViewModelFactory
    }
}