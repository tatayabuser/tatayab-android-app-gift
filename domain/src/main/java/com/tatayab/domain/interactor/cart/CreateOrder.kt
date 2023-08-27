package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Product
import com.tatayab.model.requests.AddToCartRequest
import com.tatayab.model.requests.CreateOrderRequest
import com.tatayab.model.responses.AddToCartResponse
import com.tatayab.model.responses.CreateOrderResponse
import io.reactivex.Observable
import javax.inject.Inject


class CreateOrder @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<CreateOrderResponse, CreateOrder.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<CreateOrderResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.createOrder(params.createOrderRequest)

    }

    data class Params constructor(val createOrderRequest: CreateOrderRequest) {
        companion object {
            fun forOrder(
                createOrderRequest: CreateOrderRequest
            ): Params {
                return Params(createOrderRequest)
            }
        }
    }
}
