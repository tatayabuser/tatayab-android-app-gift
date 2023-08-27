package com.tatayab.domain.interactor.address

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.model.AddressModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.requests.DeleteAddressRequest
import com.tatayab.model.responses.AddressResponse
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class DeleteAddress @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AddressResponse,DeleteAddress.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<AddressResponse> {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.deleteUserAddress(
            DeleteAddressRequest(
               o_address_id =  params.addressId,
                user_id =  params.userId,
                delete = "Y"
            )
        )
    }

    data class Params constructor(val addressId: String,val userId:String) {

        companion object {
            fun forAddress(addressId: String,userId: String): Params {
                return Params(addressId,userId)
            }
        }
    }
}