package com.tatayab.domain.interactor.account.profile

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.EditUserProfileResponse
import com.tatayab.model.requests.ChangePasswordRequest
import io.reactivex.Observable
import javax.inject.Inject


class ChangePassword @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<EditUserProfileResponse, ChangePassword.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<EditUserProfileResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.changePassword(params.changePassword)
    }

    data class Params constructor(val changePassword: ChangePasswordRequest) {
        companion object {
            fun forUser(changePassword: ChangePasswordRequest): Params {
                return Params(
                    changePassword
                )
            }
        }
    }
}
