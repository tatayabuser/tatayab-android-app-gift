package com.tatayab.domain.interactor.home

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.Banner
import com.tatayab.model.responses.BlockLayoutResponse
import com.tatayab.model.responses.HomeBlocksResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetBlockLayout @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<Banner>, GetBlockLayout.Params?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<List<Banner>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.blockLayout(params.catId,params.blockId,params.languageCode)
    }

    data class Params constructor(val catId: String,val blockId:String,val languageCode:String,val currencyId: String) {
        companion object {
            fun forBlock(catId: String, blockId:String, languageCode:String,currencyId: String): Params {
                return Params(catId,blockId, languageCode,currencyId)
            }
        }
    }
}
