package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.PromotionValue

import com.tatayab.model.requests.PromotionRequest

import io.reactivex.Observable
import javax.inject.Inject


class ApplyPromotion @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<PromotionValue>, ApplyPromotion.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<List<PromotionValue>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.applyPromotion(params.applyPromotionRequest)

    }

    data class Params constructor(
        val applyPromotionRequest: PromotionRequest
    ) {
        companion object {
            fun forPromotion(
                applyPromotionRequest: PromotionRequest
            ): Params {
                return Params(applyPromotionRequest)
            }
        }
    }
}
