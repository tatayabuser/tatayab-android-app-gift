package com.tatayab.domain.interactor.address

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.CompletableUseCase
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.model.AddressModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.requests.AddressRequest
import com.tatayab.model.requests.GetAreaRequest
import com.tatayab.model.requests.GetCitiesRequest
import com.tatayab.model.responses.*
import io.reactivex.Completable
import io.reactivex.Observable
import javax.inject.Inject

class GetArea @Inject constructor(
    private val projectsRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<List<AreaModel>,GetArea.Params>(postExecutionThread) {

    override fun buildUseCaseObservable(params: Params?): Observable<List<AreaModel>> {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return projectsRepository.getAreas(
            params.lang_code,
            GetAreaRequest(
                lang_code = params.lang_code,
                country_code = params.country_code,
                city_id = params.city_id,
                city_code = params.cityCode
            )
        )
    }

    data class Params constructor(
        val lang_code:String,
        val country_code:String,
        val city_id:Int,
        val cityCode:String
    ) {
        companion object {
            fun forAddress(
                  lang_code: String,
                   country_code: String,
                  city_id: Int,
                  cityCode: String
            ): Params {
                return Params(lang_code , country_code , city_id,cityCode)
            }
        }


    }
}