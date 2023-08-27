package com.tatayab.domain.interactor.product


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.ProductsListResponse
import io.reactivex.Observable
import javax.inject.Inject

class SearchRecommanededProductsListExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ProductsListResponse, SearchRecommanededProductsListExecution.Params>(
    postExecutionThread
) {
    override fun buildUseCaseObservable(params: SearchRecommanededProductsListExecution.Params?): Observable<ProductsListResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getProductsForSearch(
            "featuer_search_products",
            params.languageCode
        )
    }

    data class Params constructor(val languageCode: String) {
        companion object {
            fun forSuggestionList(languageCode: String): Params {
                return Params(languageCode)
            }
        }
    }
}
