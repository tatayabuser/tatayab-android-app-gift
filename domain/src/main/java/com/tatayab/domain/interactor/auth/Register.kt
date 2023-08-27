package com.tatayab.domain.interactor.auth


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.RegisterRequestBody
import com.tatayab.model.responses.AuthenticationResponse
import com.tatayab.model.responses.RegisterResponse
import io.reactivex.Observable
import javax.inject.Inject

class Register @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AuthenticationResponse, Register.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<AuthenticationResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.register(
           params.registerRequestBody, params.langCode
        )
    }

    data class Params constructor(
        val registerRequestBody: RegisterRequestBody,val langCode:String
    ) {
        companion object {
            fun forUser(registerRequestBody: RegisterRequestBody,langCode:String): Params {
                return Params(registerRequestBody,langCode)
            }
        }
    }
}
