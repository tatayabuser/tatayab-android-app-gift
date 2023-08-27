package com.tatayab.domain.interactor.filter


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.responses.ProductReviewsResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetFilter @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<FilterResponse, GetFilter.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<FilterResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getFilter(map = params.map)
    }

    data class Params constructor(val map:Map<String, String>) {
        companion object {
            fun forFilter(map: Map<String, String>): Params {
                return Params(map)
            }
        }
    }
}
