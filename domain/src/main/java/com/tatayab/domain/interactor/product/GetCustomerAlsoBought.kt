package com.tatayab.domain.interactor.product


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.CustomerFeaturedProductsResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetCustomerAlsoBought @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<CustomerFeaturedProductsResponse, GetCustomerAlsoBought.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<CustomerFeaturedProductsResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.customerAlsoBought(productId = params.productId,languageCode = params.languageCode)
    }

    data class Params constructor(val productId: String,val currencyId: String,val languageCode:String) {
        companion object {
            fun forProduct(productId: String,currencyId:String,languageCode:String): Params {
                return Params(productId,currencyId,languageCode)
            }
        }
    }
}
