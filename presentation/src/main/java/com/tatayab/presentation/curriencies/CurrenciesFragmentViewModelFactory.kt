package com.tatayab.presentation.curriencies

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.curriencies.GetCurrencies
import com.tatayab.domain.interactor.user.GetUserSetting
import com.tatayab.domain.interactor.user.SaveUserSetting


class CurrenciesFragmentViewModelFactory @AssistedInject constructor(
    private val getCurrencies: GetCurrencies,
    private val getUserSetting: GetUserSetting,
    private val saveUserSetting: SaveUserSetting,
    @Assisted val languageCode: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CurrenciesFragmentViewModel(
            getCurrencies,
            getUserSetting,
            saveUserSetting,
            languageCode
        ) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): CurrenciesFragmentViewModelFactory
    }
}