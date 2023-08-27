package com.tatayab.domain.interactor.account.profile

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.GetUserProfileResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetUserProfile @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<GetUserProfileResponse, GetUserProfile.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<GetUserProfileResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getUserProfile(userId = params.userId)
    }

    data class Params constructor(val userId: String) {
        companion object {
            fun forUser(UserId: String): Params {
                return Params(
                    UserId
                )
            }
        }
    }
}
