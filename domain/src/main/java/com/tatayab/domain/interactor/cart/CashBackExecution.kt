package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.base.BaseResponseModel
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.requests.InviteFriendRequest
import com.tatayab.model.responses.*
import io.reactivex.Observable
import javax.inject.Inject


class CashBackExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<CheckCashBackResponse, CashBackExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<CheckCashBackResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.checkCashBack(params.orderID)
    }

    data class Params constructor(val orderID: String) {
        companion object {
            fun execute(  orderID:String): Params {
                return Params(orderID)
            }
        }
    }
}
