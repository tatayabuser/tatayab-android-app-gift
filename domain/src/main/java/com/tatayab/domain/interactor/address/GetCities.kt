package com.tatayab.domain.interactor.address

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.GetCitiesRequest
import com.tatayab.model.responses.CityModel
import io.reactivex.Observable
import javax.inject.Inject

class GetCities @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<CityModel>,GetCities.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<List<CityModel>> {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.getCities(
            params.lang_code,
            GetCitiesRequest(
                lang_code = params.lang_code,
                country_code = params.country_code
            )
        )
    }

    data class Params constructor(
        val lang_code:String,
        val country_code:String
    ) {
        companion object {
            fun forAddress(
                  lang_code: String,
                   country_code: String
            ): Params {
                return Params(lang_code , country_code)
            }
        }


    }
}