package com.tatayab.domain.interactor.main

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.CategoryResponse
import com.tatayab.model.base.BaseResponseModel
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.responses.CategoriesResponse
import com.tatayab.model.responses.CategoryItem
import com.tatayab.model.responses.SubCategoriesResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetSubCategory @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<ArrayList<SubCategoriesResponse>, GetSubCategory.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<ArrayList<SubCategoriesResponse>> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getSubCategories(params.categoryRequest)
    }

    data class Params constructor(val categoryRequest: CategoryRequest) {
        companion object {
            fun forCategory(categoryRequest: CategoryRequest): Params {
                return Params(categoryRequest)
            }
        }
    }
}
