package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.interactor.address.AddAddress
import com.tatayab.domain.model.AddressModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.requests.DeleteAddressRequest
import com.tatayab.model.responses.AddressResponse
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class ClearCachedAndRemoteCart @Inject constructor(
    private val repository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : CompletableUseCase<ClearCachedAndRemoteCart.Params>(postExecutionThread) {


    override fun buildUseCaseCompletable(params: Params?): Completable {
        requireNotNull(params) { "Params can't be null!" }
        return repository.clearCartCachedAndRemote(userId = params.userId)
    }

    data class Params constructor(val userId: String) {
        companion object {
            fun forUser(
                userId: String
            ): Params {
                return Params(userId)
            }
        }
    }
}