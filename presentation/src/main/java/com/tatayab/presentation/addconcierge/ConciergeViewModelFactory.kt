package com.tatayab.presentation.addconcierge

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.addconcierge.AddConcierge
import com.tatayab.domain.repository.TatayabRepository

class ConciergeViewModelFactory  @AssistedInject constructor(
    private val addConcierge: AddConcierge,
    private val repository: TatayabRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ConciergeViewModel(
            addConcierge,
             repository) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(): ConciergeViewModelFactory
    }
}