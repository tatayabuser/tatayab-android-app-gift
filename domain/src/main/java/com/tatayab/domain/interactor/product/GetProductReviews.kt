package com.tatayab.domain.interactor.product


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.ProductReviewsResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetProductReviews @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ProductReviewsResponse, GetProductReviews.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<ProductReviewsResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getProductReviwers(productId = params.productId,page = 0,
            itemPerPage = 3,options = params.options
        )
    }

    data class Params constructor(val productId: String,val  options : HashMap<String,String>) {
        companion object {
            fun forProduct(productId: String, options : HashMap<String,String>): Params {
                return Params(productId,options = options)
            }
        }
    }
}
