package com.tatayab.domain.interactor.productotions


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.WishListActionRequest
import com.tatayab.model.responses.ProductOptionsResponse
import com.tatayab.model.responses.WishListResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetProductOptions @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ProductOptionsResponse, GetProductOptions.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<ProductOptionsResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getOptionsForProduct(params.langCode,params.productId)
    }

    data class Params constructor(val productId: String,val langCode : String) {
        companion object {
            fun forProduct(productId: String,langCode : String): Params {
                return Params(productId,langCode)
            }
        }
    }
}
