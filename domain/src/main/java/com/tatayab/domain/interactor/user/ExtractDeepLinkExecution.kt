package com.tatayab.domain.interactor.user


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.interactor.cart.RemoveCouponExecution
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.ExtractDeepLinkRequest
import com.tatayab.model.requests.RemoveCouponRequest
import com.tatayab.model.responses.ExtractDeepLinkResponse
import com.tatayab.model.responses.OrderDetailsResponse
import com.tatayab.model.responses.ReviewCartResponse
import io.reactivex.Observable
import javax.inject.Inject


class ExtractDeepLinkExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ExtractDeepLinkResponse, ExtractDeepLinkExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<ExtractDeepLinkResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.extrctDeepLinkUrl(params.mExtractDeepLinkRequest)
    }

    data class Params constructor( val mExtractDeepLinkRequest: ExtractDeepLinkRequest) {
        companion object {
            fun execute(mExtractDeepLinkRequest: ExtractDeepLinkRequest): Params {
                return Params(mExtractDeepLinkRequest)
            }
        }
    }
}
