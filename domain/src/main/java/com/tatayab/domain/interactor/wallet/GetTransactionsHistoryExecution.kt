package com.tatayab.domain.interactor.wallet


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.TransactionsHistoryResponse
import com.tatayab.model.responses.WalletResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetTransactionsHistoryExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<TransactionsHistoryResponse, GetTransactionsHistoryExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<TransactionsHistoryResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getAllTransactions()
    }

    data class Params constructor(
        val lang_code: String
    ) {
        companion object {
            fun execute(
                lang_code: String
            ): Params {
                return Params(lang_code)
            }
        }
    }
}