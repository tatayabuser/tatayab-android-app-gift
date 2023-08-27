package com.tatayab.domain.interactor.auth


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.LoginRequestBody
import com.tatayab.model.responses.AuthenticationResponse
import io.reactivex.Observable
import javax.inject.Inject

class Login @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AuthenticationResponse, Login.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<AuthenticationResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.login(
            LoginRequestBody(
                params.email,
                params.password,params.reg_type,params.isGraphEnable
            )
        )
    }

    data class Params constructor(val email: String, val password: String, val reg_type:String,val isGraphEnable:Boolean) {
        companion object {
            fun forUser(email: String, password: String,reg_type:String,isGraphEnable:Boolean): Params {
                return Params(email, password,reg_type,isGraphEnable)
            }
        }
    }
}
