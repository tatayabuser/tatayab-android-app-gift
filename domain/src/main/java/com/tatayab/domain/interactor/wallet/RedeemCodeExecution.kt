package com.tatayab.domain.interactor.wallet


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.RedeemCodeRequest
import com.tatayab.model.responses.RedeemCodeResponse
import com.tatayab.model.responses.TransactionsHistoryResponse
import com.tatayab.model.responses.WalletResponse
import io.reactivex.Observable
import javax.inject.Inject

class RedeemCodeExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<RedeemCodeResponse, RedeemCodeExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<RedeemCodeResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.addRedeemCode(RedeemCodeRequest(params.coupon))
    }

    data class Params constructor(
        val coupon:String
    ) {
        companion object {
            fun execute(
                coupon:String
            ): Params {
                return Params(coupon)
            }
        }
    }
}