package com.tatayab.domain.interactor.product


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.requests.ProductActionRequest
import com.tatayab.model.responses.NormalResponse
import com.tatayab.model.responses.ProductReviewsResponse
import com.tatayab.model.responses.ProductsListResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetAddNotifyMeAction @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<NormalResponse, GetAddNotifyMeAction.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<NormalResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.addNotifyMeAction(params.productActionRequest)
    }

    data class Params constructor(val productActionRequest: ProductActionRequest) {
        companion object {
            fun forProduct(productActionRequest: ProductActionRequest): Params {
                return Params(productActionRequest)
            }
        }
    }
}
