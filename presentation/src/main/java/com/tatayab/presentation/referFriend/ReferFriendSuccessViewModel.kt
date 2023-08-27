package com.tatayab.presentation.referFriend

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.wallet.CheckEarnExecution
import com.tatayab.domain.interactor.wallet.InviteFriendExecution
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.InviteFriendRequest
import com.tatayab.model.responses.InviteFriendResponse
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

open class ReferFriendSuccessViewModel @Inject constructor(
    private val mCheckEarnExecution: CheckEarnExecution,
    private val mInviteFriendExecution: InviteFriendExecution,
    private val repository: TatayabRepository,
    private val languageCode: String
) : BaseViewModel(repository) {


    private val invitationFriendLiveData = MutableLiveData<Resource<InviteFriendResponse>>()
    private val checkEarnLiveData = MutableLiveData<Resource<InviteFriendResponse>>()
    val getInvitationFriendLiveData: LiveData<Resource<InviteFriendResponse>>
        get() = invitationFriendLiveData
    val getCheckEarnLiveData: LiveData<Resource<InviteFriendResponse>>
        get() = checkEarnLiveData

    fun getInvitationData(senderId: Int, senderCountry: String) {
        invitationFriendLiveData.postValue(
            Resource(
                status = ResourceState.LOADING
            )
        )
        repository?.getUserAuthFromCache()?.blockingGet()?.let {
            mInviteFriendExecution.execute(
                InvitationDataExecutionSubscriber(),
                InviteFriendExecution.Params.invite(
                    InviteFriendRequest(senderId,it.devid.toString(),senderCountry)
                )
            )
        }

    }
    fun checkEarn( senderId:Int ) {
        checkEarnLiveData.postValue(
            Resource(
                status = ResourceState.LOADING
            )
        )
        repository?.getUserAuthFromCache()?.blockingGet()?.let {
            mCheckEarnExecution.execute(
                CheckEarnExecutionSubscriber(),
                CheckEarnExecution.Params.checkEarn(
                    InviteFriendRequest(senderId,it.devid.toString(),getCountryCode())
                )
            )
        }

    }

    inner class InvitationDataExecutionSubscriber() :
        DisposableObserver<InviteFriendResponse>() {
        override fun onError(e: Throwable) {
             invitationFriendLiveData.postValue(
                Resource(
                    status = ResourceState.ERROR
                )
            )
        }

        override fun onNext(t: InviteFriendResponse) {
             invitationFriendLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS, data = t
                )
            )
        }

        override fun onComplete() {
        }
    }
    inner class CheckEarnExecutionSubscriber() :
        DisposableObserver<InviteFriendResponse>() {
        override fun onError(e: Throwable) {
             checkEarnLiveData.postValue(
                Resource(
                    status = ResourceState.ERROR
                )
            )
        }

        override fun onNext(t: InviteFriendResponse) {
            checkEarnLiveData.postValue(
                Resource(
                    status = ResourceState.SUCCESS, data = t
                )
            )
        }

        override fun onComplete() {
        }
    }

}