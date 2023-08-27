package com.tatayab.domain.interactor.user


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.RedeemCodeRequest
import com.tatayab.model.responses.LogoutResponse
import com.tatayab.model.responses.RedeemCodeResponse
import com.tatayab.model.responses.TransactionsHistoryResponse
import com.tatayab.model.responses.WalletResponse
import io.reactivex.Observable
import javax.inject.Inject

class LogoutExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<LogoutResponse, LogoutExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<LogoutResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.logout()
    }

    data class Params constructor(
        val lang:String
    ) {
        companion object {
            fun execute(
                lang:String
            ): Params {
                return Params(lang)
            }
        }
    }
}