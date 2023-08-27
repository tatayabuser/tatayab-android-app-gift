package com.tatayab.domain.interactor.wallet


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.WalletResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetWalletExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<WalletResponse, GetWalletExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<WalletResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getMyWallet()
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