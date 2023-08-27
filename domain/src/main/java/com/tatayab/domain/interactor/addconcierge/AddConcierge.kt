package com.tatayab.domain.interactor.addconcierge

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.ConciergeRequestBody
import com.tatayab.model.responses.ConciergeResponse
import io.reactivex.Observable
import javax.inject.Inject

class AddConcierge @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ConciergeResponse, AddConcierge.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<ConciergeResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.addConcierge(
          params.conciergeRequestBody
        )
    }

    data class Params constructor(val conciergeRequestBody: ConciergeRequestBody) {
        companion object {
            fun forConcierge(conciergeRequestBody: ConciergeRequestBody): Params {
                return Params(conciergeRequestBody)
            }
        }
    }
}
