package com.tatayab.presentation.suppliers

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.SupplierResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetSuppliers @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ArrayList<SupplierResponse>, GetSuppliers.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<ArrayList<SupplierResponse>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getNewSuppliers(params.page,params.itemPerPage,params.languageCode,params.sortedMap)
    }

    data class Params constructor( var page: Int,
                                  var  itemPerPage: Int,
                                   var languageCode: String,
                                   var sortedMap: HashMap<String, String>) {
        companion object {
            fun forCategory(  page: Int,
                               itemPerPage: Int,
                              languageCode: String,
                              sortedMap: HashMap<String, String>): Params {
                return Params(page,itemPerPage,languageCode,sortedMap)
            }
        }
    }
}
