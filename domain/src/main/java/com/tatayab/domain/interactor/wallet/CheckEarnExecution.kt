package com.tatayab.domain.interactor.wallet

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.base.BaseResponseModel
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.requests.InviteFriendRequest
import com.tatayab.model.responses.*
import io.reactivex.Observable
import javax.inject.Inject


class CheckEarnExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<InviteFriendResponse, CheckEarnExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<InviteFriendResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.checkEarn(params.mInviteFriendRequest)
    }

    data class Params constructor(val mInviteFriendRequest: InviteFriendRequest) {
        companion object {
            fun checkEarn(  mInviteFriendRequest:InviteFriendRequest): Params {
                return Params(mInviteFriendRequest)
            }
        }
    }
}
