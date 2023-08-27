package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.CachProductCart
import com.tatayab.model.Product
import com.tatayab.model.requests.AddToCartRequest
import com.tatayab.model.requests.UpdateProductAmountRequest
import com.tatayab.model.responses.AddToCartResponse
import io.reactivex.Observable
import javax.inject.Inject


class UpdateProductAmountCache @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<Pair<Int,ArrayList<CachProductCart>?>, UpdateProductAmountCache.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<Pair<Int, ArrayList<CachProductCart>?>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.updateProductAmountCache(
            params.productId,
            params.amount,
            params.options
        )

    }

    data class Params constructor(
        val productId: String,
        val amount: Int,
        val options: Map<String, String>
    ) {
        companion object {
            fun forProduct(
                productId: String,
                amount: Int,
                options: Map<String, String>
            ): Params {
                return Params(productId, amount,options)
            }
        }
    }
}
