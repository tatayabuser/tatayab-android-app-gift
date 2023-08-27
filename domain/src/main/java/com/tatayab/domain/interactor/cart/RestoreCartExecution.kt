package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddItemToCartRequest
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.responses.AddItemToCartResponse
import com.tatayab.model.responses.CategoryItem
import com.tatayab.model.responses.SupplierResponse
import com.tatayab.model.responses.graph_responses.CreateCartResponse
import com.tatayab.model.responses.graph_responses.CreateGuestCartResponse
import com.tatayab.model.responses.graph_responses.RestoreCartResponse
import io.reactivex.Observable
import javax.inject.Inject


class RestoreCartExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<RestoreCartResponse, RestoreCartExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<RestoreCartResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.restoreCart(params?.cartId)
    }

    data class Params constructor(val cartId:String) {
        companion object {
            fun execute(cartId:String): Params {
                return Params(cartId)
            }
        }
    }
}
