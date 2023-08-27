package com.tatayab.domain.interactor.wishlist

import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.WishListActionRequest
import com.tatayab.model.responses.AddToWishListResponse
import io.reactivex.Observable
import javax.inject.Inject


class WishListActions @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<AddToWishListResponse, WishListActions.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<AddToWishListResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.addToWishList(params.addToWishListRequest)
    }

    data class Params constructor(
        val addToWishListRequest: WishListActionRequest
    ) {
        companion object {
            fun forProduct(
                addToWishListRequest: WishListActionRequest
            ): Params {
                return Params(addToWishListRequest)
            }
        }
    }
}
