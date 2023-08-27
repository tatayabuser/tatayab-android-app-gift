package com.tatayab.domain.interactor.user

import com.tatayab.domain.executor.PostExecutionThread

import com.tatayab.domain.interactor.ObservableUseCase

import com.tatayab.domain.interactor.cart.RemoveCouponExecution

import com.tatayab.domain.repository.TatayabRepository

import com.tatayab.model.requests.ExtractDeepLinkRequest

import com.tatayab.model.requests.PromotionRequestModel

import com.tatayab.model.requests.RemoveCouponRequest

import com.tatayab.model.responses.ExtractDeepLinkResponse

import com.tatayab.model.responses.InAppMessageModel

import com.tatayab.model.responses.OrderDetailsResponse

import com.tatayab.model.responses.ReviewCartResponse

import io.reactivex.Observable

import javax.inject.Inject



class PromotionExecution @Inject constructor(

    private val tatayabRepository: TatayabRepository,

    postExecutionThread: PostExecutionThread

) : ObservableUseCase<InAppMessageModel, PromotionExecution.Params?>(postExecutionThread) {



    override fun buildUseCaseObservable(params: Params?): Observable<InAppMessageModel> {

        requireNotNull(params) { "Params can't be null!" }

        return tatayabRepository.getPromotion(

            params.mPromotionRequestModel

        )

    }


    data class Params constructor(val mPromotionRequestModel: PromotionRequestModel) {

        companion object {

            fun execute(mPromotionRequestModel: PromotionRequestModel): Params {

                return Params(mPromotionRequestModel)

            }

        }

    }

}