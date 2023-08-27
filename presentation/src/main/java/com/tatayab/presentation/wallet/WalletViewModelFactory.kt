package com.tatayab.presentation.wallet

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.AssistedInject
import com.tatayab.domain.interactor.wallet.GetTransactionsHistoryExecution
import com.tatayab.domain.interactor.wallet.GetWalletExecution
import com.tatayab.domain.interactor.wallet.RedeemCodeExecution
import com.tatayab.domain.repository.TatayabRepository


@Suppress("UNCHECKED_CAST")
class WalletViewModelFactory @AssistedInject constructor(
    private val mGetWalletExecution: GetWalletExecution,
    private val mGetTransactionsHistoryExecution: GetTransactionsHistoryExecution,
    private val mRedeemCodeExecution: RedeemCodeExecution,
    private val repository: TatayabRepository
 ) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WalletViewModel(mGetWalletExecution,mGetTransactionsHistoryExecution ,mRedeemCodeExecution,repository) as T
    }

    @AssistedInject.Factory
    interface Factory {
        fun create(): WalletViewModelFactory
    }
}