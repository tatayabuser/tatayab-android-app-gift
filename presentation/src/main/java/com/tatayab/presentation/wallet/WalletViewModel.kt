package com.tatayab.presentation.wallet

import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.wallet.GetTransactionsHistoryExecution
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import com.tatayab.domain.interactor.wallet.GetWalletExecution
import com.tatayab.domain.interactor.wallet.RedeemCodeExecution
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.*
import com.tatayab.presentation.base.BaseViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class WalletViewModel @Inject constructor(
    private val mGetWalletExecution: GetWalletExecution,
    private val mGetTransactionsHistoryExecution: GetTransactionsHistoryExecution,
    private val mRedeemCodeExecution: RedeemCodeExecution,
    private val repository: TatayabRepository
) : BaseViewModel(repository) {


    private val walletLiveData = MutableLiveData<Resource<WalletResponse>>()
    private val redeemCodeLiveData = MutableLiveData<Resource<RedeemCodeResponse>>()
    private val transactionsHistoryLiveData =
        MutableLiveData<Resource<TransactionsHistoryResponse>>()


    val getWalletLiveData: MutableLiveData<Resource<WalletResponse>>
        get() = walletLiveData
    val getRedeemCodeLiveData: MutableLiveData<Resource<RedeemCodeResponse>>
        get() = redeemCodeLiveData
    val getTransactionsHistoryLiveData: MutableLiveData<Resource<TransactionsHistoryResponse>>
        get() = transactionsHistoryLiveData

    fun getMyWallet(langCode: String) {
        walletLiveData.postValue(Resource(ResourceState.LOADING))
        mGetWalletExecution.execute(
            GetWalletExecutionSubscriber(),
            GetWalletExecution.Params.execute( langCode)
        )
    }

    fun addRedeemCode(redeemCode: String) {
        redeemCodeLiveData.postValue(Resource(ResourceState.LOADING))
        mRedeemCodeExecution.execute(
            AddRedeemCodeExecutionSubscriber(),
            RedeemCodeExecution.Params.execute(redeemCode)
        )
    }

    fun getTransActionsHistory(langCode: String) {
        transactionsHistoryLiveData.postValue(Resource(ResourceState.LOADING))
        mGetTransactionsHistoryExecution.execute(
            GetTransactionsHistoryExecutionSubscriber(),
            GetTransactionsHistoryExecution.Params.execute(
                langCode
            )
        )
    }

    inner class GetWalletExecutionSubscriber() :
        DisposableObserver<WalletResponse>() {
        override fun onError(e: Throwable) {
             walletLiveData.postValue( Resource(
                 ResourceState.ERROR,
                 message = e.localizedMessage
             )
             )
        }

        override fun onNext(t: WalletResponse) {
            walletLiveData.postValue(Resource(ResourceState.SUCCESS, t))
        }

        override fun onComplete() {
        }
    }

    inner class AddRedeemCodeExecutionSubscriber() :
        DisposableObserver<RedeemCodeResponse>() {
        override fun onError(e: Throwable) {
            redeemCodeLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )

        }

        override fun onNext(t: RedeemCodeResponse) {
            redeemCodeLiveData.postValue(Resource(ResourceState.SUCCESS, t))
        }

        override fun onComplete() {
        }
    }

    inner class GetTransactionsHistoryExecutionSubscriber() :
        DisposableObserver<TransactionsHistoryResponse>() {
        override fun onError(e: Throwable) {
             transactionsHistoryLiveData.postValue( Resource(
                 ResourceState.ERROR,
                 message = e.localizedMessage
             )
             )
        }

        override fun onNext(t: TransactionsHistoryResponse) {
            transactionsHistoryLiveData.postValue(Resource(ResourceState.SUCCESS, t))
        }

        override fun onComplete() {
        }
    }


    override fun onCleared() {
        mGetWalletExecution.dispose()
        super.onCleared()
    }

}
