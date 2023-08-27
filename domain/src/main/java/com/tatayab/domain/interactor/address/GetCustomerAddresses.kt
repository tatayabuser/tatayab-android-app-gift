package com.tatayab.domain.interactor.address


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddressRequest
import io.reactivex.Observable
import javax.inject.Inject

class GetCustomerAddresses @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ArrayList<AddressRequest>, GetCustomerAddresses.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<ArrayList<AddressRequest>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getUserAddresses(userId = params.userId,languageCode = params.langCode)
    }

    data class Params constructor(val userId: String,val country: String,val langCode:String) {
        companion object {
            fun forUser(userId: String,country: String,langCode:String): Params {
                return Params(userId,country,langCode)
            }
        }
    }
}
