package com.tatayab.domain.interactor.user


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.CheckVersionResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetUpgradeChecker @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<CheckVersionResponse, GetUpgradeChecker.Params>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<CheckVersionResponse> {
        if (params == null) throw IllegalArgumentException("Params can't be null!")
        return tatayabRepository.getUpgradeVersion(params.currentVersion)
    }


    data class Params constructor(
        val currentVersion: String
    ) {
        companion object {
            fun forProduct(
                currentVersion: String
            ): Params {
                return Params(currentVersion)
            }
        }
    }
}
