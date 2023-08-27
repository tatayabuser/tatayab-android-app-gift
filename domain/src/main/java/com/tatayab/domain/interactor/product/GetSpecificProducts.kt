package com.tatayab.domain.interactor.product


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.Action
 import com.tatayab.model.responses.ProductsListResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetSpecificProducts @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ProductsListResponse, GetSpecificProducts.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<ProductsListResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getSpecificProducts(params.countryCode,lang_code = params.languageCode,action =
            Action.list.toString(),
           items_per_page =  100,
          page =   0,
          pid =   params.producstIds)
    }

    data class Params constructor(val producstIds: String,val languageCode:String, val countryCode:String) {
        companion object {
            fun forProduct(productsIds: String,languageCode: String,countryCode:String): Params {
                return Params(productsIds,languageCode,countryCode)
            }
        }
    }
}
