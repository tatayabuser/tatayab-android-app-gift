package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Product
import com.tatayab.model.requests.CartRemoveRequestBody
import io.reactivex.Observable
import javax.inject.Inject


class RemoveFromCartRemote @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<Int, RemoveFromCartRemote.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<Int> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.removeItemFromCartRemote(
            cartRemoveRequestBody = params.removeRequestBody,
            productId = params.productId,
            options = params.options
        )
    }

    data class Params constructor(
        val removeRequestBody: CartRemoveRequestBody,
        val productId: String,
        val options: Map<String, String>
    ) {
        companion object {
            fun forProduct(
                removeRequestBody: CartRemoveRequestBody,
                productId: String,
                options: Map<String, String>
            ): Params {
                return Params(removeRequestBody, productId, options)
            }
        }
    }
}
