package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddCouponRequest
import com.tatayab.model.requests.PaymentMethodRequest
import com.tatayab.model.requests.ReviewCartRequest
import com.tatayab.model.responses.*
import io.reactivex.Observable
import javax.inject.Inject


class AddCouponExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ReviewCartResponse , AddCouponExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<ReviewCartResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.applyCoupon(params.mAddCouponRequest.lang_code,params.mAddCouponRequest)
    }

    data class Params constructor( val mAddCouponRequest: AddCouponRequest) {
        companion object {
            fun execute(mAddCouponRequest: AddCouponRequest): Params {
                return Params(mAddCouponRequest)
            }
        }
    }
}
