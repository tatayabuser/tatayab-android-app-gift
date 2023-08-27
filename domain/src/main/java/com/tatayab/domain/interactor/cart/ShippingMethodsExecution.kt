package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.graph_responses.SetShippingMethodResponse
import com.tatayab.model.responses.graph_responses.ShippingMethodsResponse
import io.reactivex.Observable
import javax.inject.Inject


class ShippingMethodsExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ShippingMethodsResponse, ShippingMethodsExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<ShippingMethodsResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getShippingMethods(
            params.customer_cart)
    }

    data class Params constructor(
        val customer_cart: String) {
        companion object {
            fun execute(customer_cart: String): Params {
                return Params(customer_cart)
            }
        }
    }
}
