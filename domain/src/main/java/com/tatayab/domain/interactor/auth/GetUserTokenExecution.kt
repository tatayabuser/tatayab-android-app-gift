package com.tatayab.domain.interactor.auth


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserAuth
import com.tatayab.model.responses.UserTokenResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetUserTokenExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<UserTokenResponse, GetUserTokenExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<UserTokenResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getUserToken(params.osUsed,params.session,params.devid)
    }

    data class Params constructor(
        val osUsed: String,
        val session: String,
        val devid: String) {
        companion object {
            fun execute(
                osUsed: String,
                session: String,
                devid: String): Params {
                return Params(osUsed, session, devid)
            }
        }
    }

}