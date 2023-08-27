package com.tatayab.domain.interactor.curriencies

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.CurrencyResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetCurrencies @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ArrayList<CurrencyResponse>, GetCurrencies.Params?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<ArrayList<CurrencyResponse>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getCurriencies(params.languageCode)
    }

    data class Params constructor(val languageCode:String) {
        companion object {
            fun forCurrency(languageCode:String): Params {
                return Params(languageCode)
            }
        }
    }

}

