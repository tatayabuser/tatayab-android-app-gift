package com.tatayab.domain.interactor.user

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.model.AddressModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserSetting
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.requests.UserTokenRequestBody
import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.responses.CurrencyResponse
import com.tatayab.model.responses.TokenResponse
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class SetFirebaseToken @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<TokenResponse, SetFirebaseToken.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<TokenResponse> {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.setFirebaseToken(params.userTokenRequestBody)
    }

    data class Params constructor(
        val userTokenRequestBody: UserTokenRequestBody
    ) {

        companion object {
            fun forUser(
                userTokenRequestBody: UserTokenRequestBody
            ): Params {
                return Params(userTokenRequestBody)
            }
        }
    }
}