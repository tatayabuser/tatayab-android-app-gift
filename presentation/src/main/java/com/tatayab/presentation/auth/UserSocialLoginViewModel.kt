package com.tatayab.presentation.auth

import androidx.lifecycle.LiveData
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState

import com.tatayab.domain.interactor.auth.SocialLoginExecute
import com.tatayab.domain.interactor.user.SaveFirebaseTokenExecution
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.SaveFirebaseTokenRequestBody
import com.tatayab.model.responses.*
import com.tatayab.presentation.base.BaseViewModel
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class UserSocialLoginViewModel @Inject constructor(
    private val mSocialLoginExecute: SocialLoginExecute,
    private val mSaveFirebaseTokenExecution: SaveFirebaseTokenExecution,
    private val repository: TatayabRepository) : BaseViewModel(repository) {


    private val userRegisterLiveData: SingleLiveEvent<Resource<AuthenticationResponse>> =
        SingleLiveEvent()
    private val isLoginLiveData = SingleLiveEvent<Boolean>()
    var ENABLE_GRAPH_QUERIES_CALLS = false

    fun getRegisterLiveData(): SingleLiveEvent<Resource<AuthenticationResponse>> {
        return userRegisterLiveData
    }

    val getIsLoginLiveData: LiveData<Boolean>
        get() = isLoginLiveData


    fun soicalRegister(
        device_id: String,
        email: String,
        phone: String,
        firstname: String,
        reg_type: String,
        social_id: String,
        languageCode: String
    ) {
        userRegisterLiveData.postValue(Resource(ResourceState.LOADING))
        mSocialLoginExecute.execute(
            RegisterSocialUserSubscriber(),
            SocialLoginExecute.Params.forUser(
                device_id, email, phone, firstname, reg_type, social_id,languageCode,ENABLE_GRAPH_QUERIES_CALLS
            )
        )
    }


    inner class RegisterSocialUserSubscriber : DisposableObserver<AuthenticationResponse>() {
        override fun onNext(mRegisterResponse: AuthenticationResponse) {
            userRegisterLiveData.postValue(Resource(ResourceState.SUCCESS, mRegisterResponse))

        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            userRegisterLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage,
                    throwable = e
                )
            )
        }
    }
    fun saveNotificationToken(token: String, userId: Int) {
             if (userId >0) {
                mSaveFirebaseTokenExecution.execute(
                    SaveFirebaseTokenSubscriber(token, userId),
                    SaveFirebaseTokenExecution.Params.forUser(
                        SaveFirebaseTokenRequestBody(
                            userId = userId,
                            token = token
                        )
                    )
                )
            }

    }

    inner class SaveFirebaseTokenSubscriber(
        val token: String,
        val userId: Int
    ) : DisposableObserver<TokenResponse>() {
        override fun onError(e: Throwable) {

        }

        override fun onNext(t: TokenResponse) {
        }

        override fun onComplete() {
        }

    }
    override fun onCleared() {
        mSocialLoginExecute.dispose()
        super.onCleared()
    }

}