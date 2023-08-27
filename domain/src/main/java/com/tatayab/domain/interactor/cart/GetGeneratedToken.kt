package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.interactor.address.DeleteAddress
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.CartValue
import com.tatayab.model.requests.AddToCartRequest
import com.tatayab.model.responses.AddToCartResponse
import com.tatayab.model.responses.DeviceTokenResponse
import com.tatayab.model.responses.TokenResponse
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject


class GetGeneratedToken @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<DeviceTokenResponse,GetGeneratedToken.Params>(postExecutionThread) {

    data class Params constructor(val token: String) {
        companion object {
            fun forUser(token :String): Params {
                return Params(token)
            }
        }
    }

    override fun buildUseCaseObservable(params: Params?): Observable<DeviceTokenResponse> {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return tatayabRepository.getGeneratedCode(  token = params.token )
    }
}
