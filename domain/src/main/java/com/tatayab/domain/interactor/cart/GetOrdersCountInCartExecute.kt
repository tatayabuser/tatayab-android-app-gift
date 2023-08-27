package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.*
import com.tatayab.model.responses.AddItemToCartResponse
import com.tatayab.model.responses.CategoryItem
import com.tatayab.model.responses.GetOrdersCountInCartResponse
import com.tatayab.model.responses.SupplierResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetOrdersCountInCartExecute @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<GetOrdersCountInCartResponse , GetOrdersCountInCartExecute.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<GetOrdersCountInCartResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getOrdersCountInCart(params.mGetOrdersCountInCartRequest)
    }

    data class Params constructor( val mGetOrdersCountInCartRequest: GetOrdersCountInCartRequest) {
        companion object {
            fun execute(mGetOrdersCountInCartRequest: GetOrdersCountInCartRequest): Params {
                return Params(mGetOrdersCountInCartRequest)
            }
        }
    }
}
