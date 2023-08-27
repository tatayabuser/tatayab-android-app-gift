package com.tatayab.presentation.countries

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.cart.CreateGuestCartExecution
import com.tatayab.domain.interactor.cart.CreateUserCartExecution
import com.tatayab.domain.interactor.cart.MergeCartsExecution
import com.tatayab.domain.interactor.countries.GetCountries
import com.tatayab.domain.interactor.curriencies.GetCurrencies
import com.tatayab.domain.interactor.user.GetUserSetting
import com.tatayab.domain.interactor.user.SaveUserSetting
import com.tatayab.domain.repository.TatayabRepository


class CountriesFragmentViewModelFactory @AssistedInject constructor(
    private val getCountries: GetCountries,
    private val getCurrencies: GetCurrencies,
    private val repository: TatayabRepository,
    private val saveUserSetting: SaveUserSetting,
    private val getUserSetting: GetUserSetting,
    private val mMergeCartsExecution: MergeCartsExecution,
    private val mCreateUserCartExecution: CreateUserCartExecution,
    private val mCreateGuestCartExecution: CreateGuestCartExecution,
    @Assisted val languageCode: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CountriesFragmentViewModel(
            getCountries,
            getCurrencies,
            repository,
            saveUserSetting,
            getUserSetting,mMergeCartsExecution,mCreateUserCartExecution,mCreateGuestCartExecution,
            languageCode
        ) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): CountriesFragmentViewModelFactory
    }
}