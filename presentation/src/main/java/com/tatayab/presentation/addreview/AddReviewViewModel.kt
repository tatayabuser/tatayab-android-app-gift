package com.tatayab.presentation.addreview

import androidx.lifecycle.ViewModel
import com.tatayab.domain.interactor.addreview.AddReviewToProduct
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState

import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.AddReviewRequest
import com.tatayab.model.responses.AddReviewResponse
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class AddReviewViewModel @Inject constructor(
    private val addReview: AddReviewToProduct,
    private val repository: TatayabRepository
) : ViewModel() {

    private val addReviewResponseLiveData: SingleLiveEvent<Resource<AddReviewResponse>> =
        SingleLiveEvent()

    override fun onCleared() {
        addReview.dispose()
        super.onCleared()
    }

    fun getaddReviewResponseLiveData(): SingleLiveEvent<Resource<AddReviewResponse>> {
        return addReviewResponseLiveData
    }

    fun addReview(addReviewRequest: AddReviewRequest) {

        addReviewRequest.user_id=
            repository.getUserFromCache().toObservable().map { t -> t.user_id }.blockingSingle().toString()
        addReviewResponseLiveData.postValue(Resource(ResourceState.LOADING))
        addReview.execute(
            AddReviewSubscriber(),
            AddReviewToProduct.Params.forReview(
                addReviewRequest
            )
        )
    }


    inner class AddReviewSubscriber : DisposableObserver<AddReviewResponse>() {
        override fun onError(e: Throwable) {
            addReviewResponseLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }

        override fun onComplete() {
        }

        override fun onNext(t: AddReviewResponse) {
            addReviewResponseLiveData.postValue(Resource(ResourceState.SUCCESS, t))
        }
    }


}