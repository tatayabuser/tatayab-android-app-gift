package com.tatayab.domain.interactor.address

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.model.AddressModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.requests.AddressRequest
import com.tatayab.model.responses.AddressResponse
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class AddAddress @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AddressResponse, AddAddress.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<AddressResponse> {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.addUserAddress(
            params.addressRequest
        )
    }

    data class Params constructor(
        val addressRequest: AddressRequest
    ) {
        companion object {
            fun forAddress(
                addressRequest: AddressRequest
            ): Params {
                return Params(addressRequest)
            }
        }


    }
}