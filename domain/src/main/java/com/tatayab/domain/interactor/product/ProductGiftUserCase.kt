package com.tatayab.domain.interactor.product


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.filter.FilterResponse
import com.tatayab.model.responses.ProductReviewsResponse
import com.tatayab.model.responses.ProductsListResponse
import io.reactivex.Observable
import javax.inject.Inject

class ProductGiftUserCase @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ProductsListResponse, ProductGiftUserCase.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<ProductsListResponse> {
        requireNotNull(params) { "Params can't be null!" }
        //return tatayabRepository.getProductGift(params.countryCode,params.cityCode )
       /* if(params.countryCode == "SA"){
            return tatayabRepository.getProductGift("Sa", "Abha")
        }else {
            return tatayabRepository.getProductGift(params.countryCode, "")
        }*/
        //return tatayabRepository.getProductGift("", "")
        //return tatayabRepository.getProductGift(params.countryCode, "")

        if(params.countryCode == "SA"){
            return tatayabRepository.getProductGift(params.countryCode, "Riyadh")
        }else {
            return tatayabRepository.getProductGift(params.countryCode, "")
        }

    }

    //data class Params constructor(val countryCode:String,val cityCode: String) {
    data class Params constructor(val countryCode:String) {
        companion object {
           /* fun forProduct(countryCode: String,cityCode: String): Params {
                return Params(countryCode,cityCode)
            }*/
           fun forProduct(countryCode: String): Params {
               return Params(countryCode)
           }
        }
    }
}
