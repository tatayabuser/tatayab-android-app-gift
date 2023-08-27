package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddCouponRequest
import com.tatayab.model.requests.PaymentMethodRequest
import com.tatayab.model.requests.RemoveCouponRequest
import com.tatayab.model.requests.ReviewCartRequest
import com.tatayab.model.responses.*
import io.reactivex.Observable
import javax.inject.Inject


class RemoveCouponExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ReviewCartResponse , RemoveCouponExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<ReviewCartResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.removeCoupon(params.mRemoveCouponRequest.lang_code,params.mRemoveCouponRequest)
    }

    data class Params constructor( val mRemoveCouponRequest: RemoveCouponRequest) {
        companion object {
            fun execute(mRemoveCouponRequest: RemoveCouponRequest): Params {
                return Params(mRemoveCouponRequest)
            }
        }
    }
}
