package com.tatayab.presentation.suppliers

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.repository.TatayabRepository

@Suppress("UNCHECKED_CAST")
class SuppliersFragmentViewModelFactory @AssistedInject constructor(
    private val repository: TatayabRepository,
    @Assisted val languageCode: String,
    private val  mGetSuppliers : GetSuppliers

) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SuppliersFragmentViewModel(repository, languageCode, mGetSuppliers) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): SuppliersFragmentViewModelFactory
    }
}