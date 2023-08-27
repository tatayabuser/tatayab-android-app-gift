package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddItemToCartRequest
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.requests.graph_request.AddItemToCartGraphRequest
import com.tatayab.model.responses.AddItemToCartResponse
import com.tatayab.model.responses.CategoryItem
import com.tatayab.model.responses.SupplierResponse
import com.tatayab.model.responses.graph_responses.AddProductToCartResponse
import com.tatayab.model.responses.graph_responses.CreateCartResponse
import com.tatayab.model.responses.graph_responses.CreateGuestCartResponse
import io.reactivex.Observable
import javax.inject.Inject


class AddItemToCartQueryCartExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AddProductToCartResponse, AddItemToCartQueryCartExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<AddProductToCartResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.AddProductToGraphCart(params?.mAddItemToCartGraphRequest)
    }

    data class Params constructor(val mAddItemToCartGraphRequest: AddItemToCartGraphRequest) {
        companion object {
            fun execute(mAddItemToCartGraphRequest:AddItemToCartGraphRequest): Params {
                return Params(mAddItemToCartGraphRequest)
            }
        }
    }
}
