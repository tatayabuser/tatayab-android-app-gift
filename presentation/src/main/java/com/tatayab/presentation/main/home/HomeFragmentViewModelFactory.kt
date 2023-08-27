package com.tatayab.presentation.main.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.home.CompositeBlockItem

class HomeFragmentViewModelFactory @AssistedInject constructor(
    private val repository: TatayabRepository,
    @Assisted val blocksList : Array<CompositeBlockItem>?,
    @Assisted val languageCode:String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return HomeFragmentViewModel(repository, blocksList ,languageCode) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(blocksList : Array<CompositeBlockItem>?,languageCode: String): HomeFragmentViewModelFactory
    }
}