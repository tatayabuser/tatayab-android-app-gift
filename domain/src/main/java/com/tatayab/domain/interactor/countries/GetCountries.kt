package com.tatayab.domain.interactor.countries

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.CountryResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetCountries @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ArrayList<CountryResponse>, GetCountries.Params?>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<ArrayList<CountryResponse>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getCountries(params.languageCode)
    }

    data class Params constructor(val languageCode:String) {
        companion object {
            fun forCountries(languageCode:String): Params {
                return Params(languageCode)
            }
        }
    }

}
