package com.tatayab.domain.interactor.auth


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
 import com.tatayab.model.responses.UserUpdateTokenResponse
import io.reactivex.Observable
import javax.inject.Inject

class UpdateUserTokenWithLangaugAndCountryExecution @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<UserUpdateTokenResponse, UpdateUserTokenWithLangaugAndCountryExecution.Params?>(postExecutionThread) {


    override fun buildUseCaseObservable(params: Params?): Observable<UserUpdateTokenResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.updateUserTokenWithCountryOrLanguage(params.country_code,params.lang_code)
    }

    data class Params constructor(
        val country_code: String,
        val lang_code: String) {
        companion object {
            fun execute(
                country_code: String,
                lang_code: String): Params {
                return Params(country_code,lang_code)
            }
        }
    }
}