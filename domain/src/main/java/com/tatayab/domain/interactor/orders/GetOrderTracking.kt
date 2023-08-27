package com.tatayab.domain.interactor.orders

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.OrderStatues
import com.tatayab.model.responses.OrderTrackingResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetOrderTracking @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<OrderTrackingResponse, GetOrderTracking.Params?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<OrderTrackingResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getOrderStatues(params.userId,params.orderId,params.languageCode)
    }

    data class Params constructor(val userId: String,val orderId: String,val languageCode:String) {
        companion object {
            fun forOrder(userId: String,orderId: String, languageCode:String): Params {
                return Params(userId,orderId,languageCode)
            }
        }
    }
}

