package com.tatayab.presentation.account

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.auth.Logout
import com.tatayab.domain.interactor.user.GetCurrentUser
import com.tatayab.domain.interactor.user.GetUserSetting
import com.tatayab.domain.interactor.user.LogoutExecution
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.UserSetting
import com.tatayab.model.responses.AuthenticationResponse
import com.tatayab.model.responses.LogoutResponse
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class AccountFragmentViewModel @Inject constructor(
    private val logout: Logout,
    private val getCurrentUser: GetCurrentUser,
    private val getUserSetting: GetUserSetting,
    private val mLogoutExecution: LogoutExecution,
    private val repository: TatayabRepository
    ) : BaseViewModel(repository) {

    var isLoggedIn = false;
    private val logoutLiveData = MutableLiveData<Resource<LogoutResponse>>()

    val getLogoutLiveData: LiveData<Resource<LogoutResponse>>
        get() = logoutLiveData


    private val userLiveData = MutableLiveData<Resource<AuthenticationResponse?>>()
    private val userSetting = MutableLiveData<Resource<Pair<UserSetting, Boolean>>>()


    val getUserLiveData: LiveData<Resource<AuthenticationResponse?>>
        get() = userLiveData


    val getUserSetingLiveData: MutableLiveData<Resource<Pair<UserSetting, Boolean>>>
        get() = userSetting


    fun logout(lang: String) {
        logoutLiveData.postValue(Resource(ResourceState.LOADING))
        logout.execute(LogoutSubscriber())
        logoutLiveData.postValue(Resource(ResourceState.SUCCESS, null))

//        mLogoutExecution.execute(
//            LogoutFromServerSubscriber(),
//            LogoutExecution.Params.execute(lang)
//        )
    }

    fun getUserSetting(isLogin: Boolean) {
        getUserSettings(isLogin)
    }

    private fun getUserSettings(isLogin: Boolean) {
        userSetting.postValue(Resource(ResourceState.LOADING))
        getUserSetting.execute(GetUserSettingSubscriber(isLogin))
    }

    inner class GetUserSettingSubscriber(val login: Boolean) :
        DisposableObserver<UserSetting?>() {
        override fun onError(e: Throwable) {
            Log.d("GetUserError", e.toString())
        }

        override fun onNext(t: UserSetting) {
            userSetting.postValue(Resource(ResourceState.SUCCESS, Pair(first = t, second = login)))
        }

        override fun onComplete() {
        }
    }

    inner class LogoutSubscriber : DisposableObserver<Boolean>() {
        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
        }

        override fun onNext(t: Boolean) {
        }
    }

    inner class LogoutFromServerSubscriber : DisposableObserver<LogoutResponse>() {
        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            logoutLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }

        override fun onNext(t: LogoutResponse) {
            t?.let {
                logoutLiveData.postValue(Resource(ResourceState.SUCCESS, it))
            }
        }
    }


    fun getUser() {
        getCurrentUser.execute(GetUserSubscriber())
    }

    inner class GetUserSubscriber : DisposableObserver<AuthenticationResponse?>() {
        override fun onError(e: Throwable) {
            userLiveData.postValue(Resource(status = ResourceState.ERROR))
            isLoggedIn = false
        }

        override fun onNext(t: AuthenticationResponse) {
            isLoggedIn = if (t.token.isNullOrBlank()) {
                userLiveData.postValue(Resource(status = ResourceState.ERROR))
                false
            } else {
                userLiveData.postValue(Resource(status = ResourceState.SUCCESS, data = t))
                true
            }
        }

        override fun onComplete() {
        }

    }

    override fun onCleared() {
        getCurrentUser.dispose()
        logout.dispose()
        super.onCleared()
    }


}
