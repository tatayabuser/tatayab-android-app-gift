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


class CreateOrderExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<CreateOrderResponse , CreateOrderExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<CreateOrderResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.createOrder(params.user_id,params.languageCode,params.country_code,params.action,params.device_id,params.is_gift,params.gift_sender_name,params.gift_receiver_name,params.gift_msg,params.cartId)
    }

    data class Params constructor( val  user_id: String, val languageCode: String,
                                   val country_code: String,
                                   val  action: String,
                                   val  device_id: String
                                   ,val is_gift: Int,
                                   val  gift_sender_name: String,
                                   val   gift_receiver_name: String,
                                   val  gift_msg: String,
                                   val  cartId: String
                                   ) {
        companion object {
            fun execute( user_id: String, languageCode: String,
                         country_code: String,
                         action: String,
                         device_id: String ,is_gift: Int,
                         gift_sender_name: String,
                         gift_receiver_name: String,
                         gift_msg: String,cartId: String): Params {
                return Params( user_id, languageCode,
                    country_code,
                    action,
                    device_id ,is_gift,
                    gift_sender_name,
                    gift_receiver_name,
                    gift_msg,cartId)
            }
        }
    }
}
