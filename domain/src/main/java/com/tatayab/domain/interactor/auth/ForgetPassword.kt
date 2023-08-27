package com.tatayab.domain.interactor.auth


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.NormalResponse
import io.reactivex.Observable
import javax.inject.Inject

class ForgetPassword @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<NormalResponse, ForgetPassword.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<NormalResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.forgetPassword(
           params.email,params.languageCode
        )
    }

    data class Params constructor(val email: String,val languageCode: String) {
        companion object {
            fun forUser(email: String,languageCode: String): Params {
                return Params(email,languageCode)
            }
        }
    }
}
