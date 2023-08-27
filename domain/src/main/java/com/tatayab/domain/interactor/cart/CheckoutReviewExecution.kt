package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.ReviewCartRequest
import com.tatayab.model.responses.*
import io.reactivex.Observable
import javax.inject.Inject


class CheckoutReviewExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ReviewCartResponse , CheckoutReviewExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<ReviewCartResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.checkoutReview(params.mReviewCartRequest.lang_code,params.mReviewCartRequest)
    }

    data class Params constructor( val mReviewCartRequest: ReviewCartRequest) {
        companion object {
            fun execute(mReviewCartRequest: ReviewCartRequest): Params {
                return Params(mReviewCartRequest)
            }
        }
    }
}
