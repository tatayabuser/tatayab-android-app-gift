package com.tatayab.presentation.addconcierge

import com.tatayab.domain.interactor.addconcierge.AddConcierge
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState

import com.tatayab.model.requests.ConciergeRequestBody
import com.tatayab.model.responses.ConciergeResponse
import com.tatayab.presentation.base.BaseViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class ConciergeViewModel @Inject constructor(
    private val addConcierge:AddConcierge,
    private val repository: TatayabRepository
    ) : BaseViewModel(repository) {

    private val conciergeResponseLiveData: SingleLiveEvent<Resource<ConciergeResponse>> = SingleLiveEvent()

    override fun onCleared() {
        addConcierge.dispose()
        super.onCleared()
    }

    fun getconciergeResponseLiveData(): SingleLiveEvent<Resource<ConciergeResponse>> {
        return conciergeResponseLiveData
    }

    fun addConcierge(conciergeRequestBody: ConciergeRequestBody) {

        conciergeResponseLiveData.postValue(Resource(ResourceState.LOADING))
        addConcierge.execute(
            AddConciergeSubscriber(),
            AddConcierge.Params.forConcierge(
                conciergeRequestBody
            )
        )
    }


    inner class AddConciergeSubscriber : DisposableObserver<ConciergeResponse>() {
        override fun onNext(t: ConciergeResponse) {
                t.status.let { _->  conciergeResponseLiveData.postValue(Resource(ResourceState.SUCCESS, t))}
        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            conciergeResponseLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }
    }

}