package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.GetOrdersFromCartRequest
import com.tatayab.model.responses.GetOrdersFromCartResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetCartContent @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<GetOrdersFromCartResponse , GetCartContent.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<GetOrdersFromCartResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getOrdersFromCart(params.mGetOrdersFromCartRequest.lang_code,params.mGetOrdersFromCartRequest)
    }

    data class Params constructor( val mGetOrdersFromCartRequest: GetOrdersFromCartRequest) {
        companion object {
            fun excute(mGetOrdersFromCartRequest: GetOrdersFromCartRequest): Params {
                return Params(mGetOrdersFromCartRequest)
            }
        }
    }
}
