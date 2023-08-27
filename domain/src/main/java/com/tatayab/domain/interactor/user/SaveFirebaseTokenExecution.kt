package com.tatayab.domain.interactor.user

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.model.AddressModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserSetting
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.requests.SaveFirebaseTokenRequestBody
import com.tatayab.model.requests.UserTokenRequestBody
import com.tatayab.model.responses.CountryResponse
import com.tatayab.model.responses.CurrencyResponse
import com.tatayab.model.responses.TokenResponse
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class SaveFirebaseTokenExecution @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<TokenResponse, SaveFirebaseTokenExecution.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<TokenResponse> {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.saveFirebaseToken(params.userTokenRequestBody)
    }

    data class Params constructor(
        val userTokenRequestBody: SaveFirebaseTokenRequestBody
    ) {

        companion object {
            fun forUser(
                userTokenRequestBody: SaveFirebaseTokenRequestBody
            ): Params {
                return Params(userTokenRequestBody)
            }
        }
    }
}