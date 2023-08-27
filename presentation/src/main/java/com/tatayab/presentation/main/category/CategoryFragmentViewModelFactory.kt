package com.tatayab.presentation.main.category

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.main.GetCategory
import com.tatayab.domain.interactor.main.GetCategoryBanner
import com.tatayab.domain.interactor.main.GetSubCategory
import com.tatayab.domain.repository.TatayabRepository


class CategoryFragmentViewModelFactory @AssistedInject constructor(
    private val tatayabRepository: TatayabRepository,
    private var getCategory2: GetCategory,
    private var getSubCategory: GetSubCategory,
    private var mGetCategoryBanner: GetCategoryBanner,
    @Assisted val languageCode:String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CategoryFragmentViewModel(tatayabRepository, getCategory2,getSubCategory,mGetCategoryBanner, languageCode) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): CategoryFragmentViewModelFactory
    }
}