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


class UpdateProductAmount @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<Pair<Int,ArrayList<CachProductCart>?>, UpdateProductAmount.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<Pair<Int, ArrayList<CachProductCart>?>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.updateProductAmountRemote(params.productIdRemote,params.productIdCache, params.updateProductAmount)

    }

    data class Params constructor(
        val productIdRemote: String,
        val productIdCache: String,
        val updateProductAmount: UpdateProductAmountRequest
    ) {
        companion object {
            fun forProduct(
                productIdRemote: String,
                productIdCache: String,
                updateProductAmount: UpdateProductAmountRequest

            ): Params {
                return Params(productIdRemote,productIdCache, updateProductAmount)
            }
        }
    }
}
