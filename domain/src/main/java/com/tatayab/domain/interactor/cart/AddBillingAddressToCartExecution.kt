package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddItemToCartRequest
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.requests.graph_request.AddItemToCartGraphRequest
import com.tatayab.model.responses.AddItemToCartResponse
import com.tatayab.model.responses.CategoryItem
import com.tatayab.model.responses.SupplierResponse
import com.tatayab.model.responses.graph_responses.*
import io.reactivex.Observable
import javax.inject.Inject


class AddBillingAddressToCartExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ShippingAddressResponse, AddBillingAddressToCartExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<ShippingAddressResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.setBillingAddressOnCart(params?.mShippingAddressRequest)
    }

    data class Params constructor(val mShippingAddressRequest: ShippingAddressRequest) {
        companion object {
            fun execute(mShippingAddressRequest:ShippingAddressRequest): Params {
                return Params(mShippingAddressRequest)
            }
        }
    }
}
