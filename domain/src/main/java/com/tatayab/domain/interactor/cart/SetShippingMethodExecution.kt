package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.graph_responses.SetShippingMethodResponse
import io.reactivex.Observable
import javax.inject.Inject


class SetShippingMethodExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<SetShippingMethodResponse, SetShippingMethodExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<SetShippingMethodResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.setShippingMethod(
            params.customer_cart,
            params.carrier_code,
            params.method_code
        )
    }

    data class Params constructor(
        val customer_cart: String,
        val carrier_code: String,
        val method_code: String
    ) {
        companion object {
            fun execute(customer_cart: String, carrier_code: String, method_code: String): Params {
                return Params(customer_cart,carrier_code,method_code)
            }
        }
    }
}
