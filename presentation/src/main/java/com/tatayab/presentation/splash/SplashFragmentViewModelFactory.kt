package com.tatayab.presentation.splash

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.address.GetCities
import com.tatayab.domain.interactor.auth.GetUserTokenExecution
import com.tatayab.domain.interactor.auth.Login
import com.tatayab.domain.interactor.auth.Logout
import com.tatayab.domain.interactor.countries.GetCountries
import com.tatayab.domain.interactor.curriencies.GetCurrencies
import com.tatayab.domain.interactor.user.*
import com.tatayab.domain.repository.TatayabRepository


class SplashFragmentViewModelFactory @AssistedInject constructor(
    private val repository: TatayabRepository,
    private val getUserSetting: GetUserSetting,
    private val getCountries: GetCountries,
    private val mGetCities: GetCities,
    private val getCurrencies: GetCurrencies,
    private val getUpgradeChecker: GetUpgradeChecker,
    private val saveUserSetting: SaveUserSetting,
    private val getCurrentUser: GetCurrentUser,
    private val mGetUserTokenExecution: GetUserTokenExecution,
    private val login: Login,
    private val mSaveUserAuth: SaveUserAuth,
    private val logout: Logout,
    @Assisted val languageCode: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return SplashActivityViewModel(
            repository,
            getUserSetting,
            getCountries,
            mGetCities,
            getCurrencies,
            getUpgradeChecker,
            saveUserSetting,
            getCurrentUser,
            mGetUserTokenExecution, login, mSaveUserAuth,logout,
            languageCode
        ) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): SplashFragmentViewModelFactory
    }
}