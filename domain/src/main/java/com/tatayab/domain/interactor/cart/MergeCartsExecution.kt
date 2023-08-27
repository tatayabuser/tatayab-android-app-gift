package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddItemToCartRequest
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.responses.AddItemToCartResponse
import com.tatayab.model.responses.CategoryItem
import com.tatayab.model.responses.SupplierResponse
import com.tatayab.model.responses.graph_responses.CreateCartResponse
import com.tatayab.model.responses.graph_responses.CreateGuestCartResponse
import com.tatayab.model.responses.graph_responses.MergeCartsResponse
import com.tatayab.model.responses.graph_responses.RestoreCartResponse
import io.reactivex.Observable
import javax.inject.Inject


class MergeCartsExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<MergeCartsResponse, MergeCartsExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<MergeCartsResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.mergeCarts(params?.customerCartId,params?.guestCartId)
    }

    data class Params constructor(val customerCartId:String,val guestCartId:String) {
        companion object {
            fun execute(customerCartId:String, guestCartId: String): Params {
                return Params(customerCartId,guestCartId)
            }
        }
    }
}
