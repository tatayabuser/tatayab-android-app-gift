package com.tatayab.domain.interactor.product


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.responses.ProductReviewsResponse
import com.tatayab.model.responses.ProductsListResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetAlsoBoughtProducts @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ProductsListResponse, GetAlsoBoughtProducts.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<ProductsListResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getProductForCategory(params.map,0,5)
    }

    data class Params constructor(val map:Map<String, String>) {
        companion object {
            fun forProduct(map: Map<String, String>): Params {
                return Params(map)
            }
        }
    }
}
