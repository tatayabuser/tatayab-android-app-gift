package com.tatayab.presentation.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.auth.SocialLoginExecute
import com.tatayab.domain.interactor.user.SaveFirebaseTokenExecution
import com.tatayab.domain.repository.TatayabRepository

class UserSocialLoginViewModelFactory @AssistedInject constructor(
    private val mSocialLoginExecute: SocialLoginExecute,
    private val mSaveFirebaseTokenExecution: SaveFirebaseTokenExecution,
    private val repository: TatayabRepository) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return UserSocialLoginViewModel(mSocialLoginExecute,mSaveFirebaseTokenExecution, repository) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(): UserSocialLoginViewModelFactory
    }
}