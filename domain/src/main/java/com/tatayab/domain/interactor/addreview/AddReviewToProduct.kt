package com.tatayab.domain.interactor.addreview

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddReviewRequest
import com.tatayab.model.responses.AddReviewResponse
import io.reactivex.Observable
import javax.inject.Inject

class AddReviewToProduct @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AddReviewResponse, AddReviewToProduct.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<AddReviewResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.addReviewToProduct(
          params.addReviewRequest
        )
    }

    data class Params constructor(val addReviewRequest: AddReviewRequest) {
        companion object {
            fun forReview(addReviewRequest: AddReviewRequest): Params {
                return Params(addReviewRequest)
            }
        }
    }
}
