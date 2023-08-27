package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Product
import com.tatayab.model.requests.AddToCartRequest
import com.tatayab.model.requests.ApplyCouponRequest
import com.tatayab.model.responses.AddToCartResponse
import com.tatayab.model.responses.CouponResponse
import io.reactivex.Observable
import javax.inject.Inject


class ApplyCoupon @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<CouponResponse, ApplyCoupon.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<CouponResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.applyCoupon(params.applyCouponRequest)

    }

    data class Params constructor(
        val applyCouponRequest: ApplyCouponRequest
    ) {
        companion object {
            fun forCart(
                applyCouponRequest: ApplyCouponRequest
            ): Params {
                return Params(applyCouponRequest)
            }
        }
    }
}
