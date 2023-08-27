package com.tatayab.domain.interactor.wishlist


import com.tatayab.domain.executor.PostExecutionThread
import com.tatayab.domain.interactor.ObservableUseCase
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.WishListActionRequest
import com.tatayab.model.responses.WishListResponse
import io.reactivex.Observable
import javax.inject.Inject

class GetUserWishList @Inject constructor(
    private val tatayabRepository: TatayabRepository,
    postExecutionThread: PostExecutionThread
) : ObservableUseCase<WishListResponse, GetUserWishList.Params>(postExecutionThread) {
    override fun buildUseCaseObservable(params: Params?): Observable<WishListResponse> {
        requireNotNull(params) { "Params can't be null!" }
        return tatayabRepository.getWishListProducts(addToWishListRequest = params.wishListRequest)
    }

    data class Params constructor(val wishListRequest: WishListActionRequest) {
        companion object {
            fun forUser(wishListRequest: WishListActionRequest): Params {
                return Params(wishListRequest)
            }
        }
    }
}
