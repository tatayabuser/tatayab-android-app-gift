package com.tatayab.domain.interactor.product


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.SearchModel
import com.tatayab.model.responses.ProductsListResponse
import io.reactivex.Observable
import javax.inject.Inject

class SearchSuggestionListExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<SearchModel>, SearchSuggestionListExecution.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<List<SearchModel>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getSearchSuggestionListFromCache() as  Observable<List<SearchModel>>
    }

    data class Params constructor(val languageCode:String) {
        companion object {
            fun forSuggestionList(languageCode:String): Params {
                return Params(languageCode)
            }
        }
    }
}
