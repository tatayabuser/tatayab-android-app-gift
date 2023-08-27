package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.UpdateItemInCartRequest
import com.tatayab.model.responses.AddItemToCartResponse
import io.reactivex.Observable
import javax.inject.Inject


class UpdateCartItemAmount @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AddItemToCartResponse , UpdateCartItemAmount.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<AddItemToCartResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.updateCartItemAmount(params.addItemToCartRequest)
    }

    data class Params constructor( val addItemToCartRequest: UpdateItemInCartRequest) {
        companion object {
            fun execute(addItemToCartRequest: UpdateItemInCartRequest): Params {
                return Params(addItemToCartRequest)
            }
        }
    }
}
