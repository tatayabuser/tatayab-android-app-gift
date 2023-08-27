package com.tatayab.domain.interactor.main

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.base.BaseResponseModel
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.responses.*
import io.reactivex.Observable
import javax.inject.Inject


class GetCategoryBanner @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<CategoryBannerResponse, GetCategoryBanner.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<CategoryBannerResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getCategoryBanners(params.lang,params.catId)
    }

    data class Params constructor(val lang: String , val catId :String) {
        companion object {
            fun forBanner(  lang: String ,   catId :String): Params {
                return Params(lang,catId)
            }
        }
    }
}
