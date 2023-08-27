package com.tatayab.domain.interactor.main

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.responses.CategoryItem
import io.reactivex.Observable
import javax.inject.Inject


class GetCategory @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ArrayList<CategoryItem>, GetCategory.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<ArrayList<CategoryItem>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getCategories2(params.categoryRequest)
    }

    data class Params constructor(val categoryRequest: CategoryRequest) {
        companion object {
            fun forCategory(categoryRequest: CategoryRequest): Params {
                return Params(categoryRequest)
            }
        }
    }
}
