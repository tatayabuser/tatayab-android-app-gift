package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddItemToCartRequest
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.requests.DeleteItemFromCartRequest
import com.tatayab.model.responses.AddItemToCartResponse
import com.tatayab.model.responses.CategoryItem
import com.tatayab.model.responses.SupplierResponse
import io.reactivex.Observable
import javax.inject.Inject


class DeleteOrderFromCart @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AddItemToCartResponse , DeleteOrderFromCart.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<AddItemToCartResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.deleteOrderFromCart(params.mDeleteOrderFromCart)
    }

    data class Params constructor( val mDeleteOrderFromCart: DeleteItemFromCartRequest) {
        companion object {
            fun execute(mDeleteOrderFromCart: DeleteItemFromCartRequest): Params {
                return Params(mDeleteOrderFromCart)
            }
        }
    }
}
