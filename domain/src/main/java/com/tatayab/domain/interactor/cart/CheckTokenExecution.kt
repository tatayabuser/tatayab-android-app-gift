package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddItemToCartRequest
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.responses.AddItemToCartResponse
import com.tatayab.model.responses.CategoryItem
import com.tatayab.model.responses.SupplierResponse
import com.tatayab.model.responses.graph_responses.*
import io.reactivex.Observable
import javax.inject.Inject


class CheckTokenExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<CheckTokenValidationResponse, CheckTokenExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<CheckTokenValidationResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.checkTokenValidation(params?.token)
    }

    data class Params constructor(val token:String) {
        companion object {
            fun execute(token:String): Params {
                return Params(token)
            }
        }
    }
}
