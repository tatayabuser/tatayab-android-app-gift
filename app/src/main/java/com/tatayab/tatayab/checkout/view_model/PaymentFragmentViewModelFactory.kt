package com.tatayab.tatayab.checkout.view_model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.cart.*
import com.tatayab.domain.interactor.user.GetCurrentUser
import com.tatayab.domain.repository.TatayabRepository

class PaymentFragmentViewModelFactory @AssistedInject constructor(
    private val repository: TatayabRepository,
    private val mRestoreCartExecution: RestoreCartExecution,
    @Assisted val languageCode:String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return PaymentFragmentViewModel(
            repository,mRestoreCartExecution, languageCode) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(languageCode: String): PaymentFragmentViewModelFactory
    }
}