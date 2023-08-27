package com.tatayab.domain.interactor.product


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.ProductDetailsResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetProductDetails @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ProductDetailsResponse, GetProductDetails.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<ProductDetailsResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getProductDetails(productId = params.productId,languageCode = params.languageCode,country_code = params.countryCode)
    }

    data class Params constructor(val productId: String,val currencyId:String,val languageCode:String,val countryCode: String) {
        companion object {
            fun forProduct(productId: String,currencyId: String,languageCode: String,countryCode: String): Params {
                return Params(productId,currencyId,languageCode,countryCode)
            }
        }
    }
}
