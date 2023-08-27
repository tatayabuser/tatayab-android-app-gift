package com.tatayab.domain.interactor.product


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.ProductsListResponse
import com.tatayab.model.responses.SearchProductListResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetProductsWithSearch @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<SearchProductListResponse, GetProductsWithSearch.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<SearchProductListResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getProductsByKey(
            query = params.query,
            page = params.page,
            languageCode = params.language
        )
    }

    data class Params constructor(val query: String, val page: Int, val language: String) {
        companion object {
            fun forProduct(query: String, page: Int, language: String): Params {
                return Params(query, page, language)
            }
        }
    }
}
