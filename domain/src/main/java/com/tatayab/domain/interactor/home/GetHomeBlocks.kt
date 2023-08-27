package com.tatayab.domain.interactor.home

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.HomeBlocksResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetHomeBlocks @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<HomeBlocksResponse, GetHomeBlocks.Params?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<HomeBlocksResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.layoutBlocks(params.countryCode, false)
    }

    data class Params constructor(val countryCode:String,val languageCode:String) {
        companion object {
            fun forLayout(countryCode: String,languageCode: String): Params {
                return Params(countryCode,languageCode)
            }
        }
    }
}
