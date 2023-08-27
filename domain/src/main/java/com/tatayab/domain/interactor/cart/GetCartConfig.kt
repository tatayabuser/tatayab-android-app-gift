package com.tatayab.domain.interactor.cart

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.CartConfigResponse
import io.reactivex.Observable
import javax.inject.Inject


class GetCartConfig @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<CartConfigResponse, GetCartConfig.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<CartConfigResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getCartConfig(
            languageCode = params.languageCode
        )
    }

    data class Params constructor(val countryCode: String, val languageCode: String) {
        companion object {
            fun forCart(countryCode: String, languageCode: String): Params {
                return Params(countryCode, languageCode)
            }
        }
    }
}
