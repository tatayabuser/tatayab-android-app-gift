package com.tatayab.presentation.product

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.product.*
import com.tatayab.domain.repository.TatayabRepository

@Suppress("UNCHECKED_CAST")
class ProductDetailsFragmentViewModelFactory @AssistedInject constructor(
    private val getProductDetails: GetProductDetails,
    private val customerAlsoBought: GetAlsoBoughtProducts,
    private val getProductReviews: GetProductReviews,
    private val repository: TatayabRepository,
    private val getAddNotifyMeAction: GetAddNotifyMeAction,
    @Assisted val argument: String,
    @Assisted val languageCode: String

) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ProductDetailsFragmentViewModel(getProductDetails,
            customerAlsoBought,getProductReviews,repository, getAddNotifyMeAction,argument,languageCode) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(argument: String,languageCode: String): ProductDetailsFragmentViewModelFactory
    }
}