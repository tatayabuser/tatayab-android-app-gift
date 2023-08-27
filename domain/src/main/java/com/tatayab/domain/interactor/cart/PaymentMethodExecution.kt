package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.PaymentMethodRequest
import com.tatayab.model.requests.ReviewCartRequest
import com.tatayab.model.responses.*
import io.reactivex.Observable
import javax.inject.Inject


class PaymentMethodExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ReviewCartResponse , PaymentMethodExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<ReviewCartResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.sendPaymentMethod(params.mPaymentMethodRequest.lang_code,params.mPaymentMethodRequest)
    }

    data class Params constructor( val mPaymentMethodRequest: PaymentMethodRequest) {
        companion object {
            fun execute(mPaymentMethodRequest: PaymentMethodRequest): Params {
                return Params(mPaymentMethodRequest)
            }
        }
    }
}
