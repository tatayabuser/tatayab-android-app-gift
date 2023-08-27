package com.tatayab.presentation.profile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.account.profile.ChangePassword
import com.tatayab.domain.interactor.account.profile.EditProfile
import com.tatayab.domain.interactor.account.profile.GetUserProfile
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.EditUserProfileResponse
import com.tatayab.model.common.NoConnectivityException
import com.tatayab.model.requests.ChangePasswordRequest
import com.tatayab.model.requests.ProfileActionRequest
import com.tatayab.model.responses.GetUserProfileResponse
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class ProfileFragmentViewModel @Inject constructor(
    private val getUserProfile: GetUserProfile,
    private val editProfile: EditProfile,
    private val changePassword: ChangePassword,
    private val repository: TatayabRepository
) : BaseViewModel(repository) {

    private val userProfile = MutableLiveData<Resource<GetUserProfileResponse>>()
    private val editUserProfile = SingleLiveEvent<Resource<EditUserProfileResponse>>()
    private val changePasswordLiveData = SingleLiveEvent<Resource<EditUserProfileResponse>>()

    val getUserProfileLiveData: LiveData<Resource<GetUserProfileResponse>>
        get() = userProfile

    val getEditProfileLiveData: SingleLiveEvent<Resource<EditUserProfileResponse>>
        get() = editUserProfile

    val getChangePasswordLiveData: SingleLiveEvent<Resource<EditUserProfileResponse>>
        get() = changePasswordLiveData


    init {
        getUserProfile()
    }

    fun editUserProfile(profileActionRequest: ProfileActionRequest) {
        editUserProfile.postValue(Resource(ResourceState.LOADING))
        profileActionRequest.userId = getUserId()
        editProfile.execute(
            GetEditUserProfileSubscriber(), EditProfile.Params.forUserEdit(
                profileActionRequest
            )
        )
    }


    fun changePassword(changePasswordRequest: ChangePasswordRequest) {
        changePasswordLiveData.postValue(Resource(ResourceState.LOADING))
        changePasswordRequest.userId = getUserId()
        changePassword.execute(
            ChangePasswordSubscriber(), ChangePassword.Params.forUser(
                changePasswordRequest
            )
        )
    }


    private fun getUserProfile() {
        userProfile.postValue(Resource(ResourceState.LOADING))
        getUserProfile.execute(
            GetUserProfileSubscriber(),
            GetUserProfile.Params.forUser(getUserId())
        )
    }


    inner class GetUserProfileSubscriber() :
        DisposableObserver<GetUserProfileResponse>() {
        override fun onComplete() {
        }

        override fun onNext(t: GetUserProfileResponse) {
            Log.e("es", "")
            t.let {
                var userInfo = getUserInfo()
                if(userInfo!= null){
                    t.userProfile?.phone = userInfo?.phone!!
                    t?.userProfile?.password = userInfo?.password
                    t?.userProfile?.phone_country_code=getCountryPhoneCode()
                    userProfile.postValue(Resource(ResourceState.SUCCESS, t))
                }else{
                    userProfile.postValue(Resource(ResourceState.SUCCESS, t))
                }
            }
        }

        override fun onError(e: Throwable) {

            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                editUserProfile.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }

    inner class GetEditUserProfileSubscriber() :
        DisposableObserver<EditUserProfileResponse>() {
        override fun onComplete() {
        }

        override fun onNext(t: EditUserProfileResponse) {
            Log.e("es", "")
            t.let {
                editUserProfile.postValue(Resource(ResourceState.SUCCESS, t))
            }
        }

        override fun onError(e: Throwable) {

            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                editUserProfile.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }
        }
    }


    inner class ChangePasswordSubscriber() :
        DisposableObserver<EditUserProfileResponse>() {
        override fun onComplete() {
        }

        override fun onNext(t: EditUserProfileResponse) {
            Log.e("es", "")
            t.let {
                changePasswordLiveData.postValue(Resource(ResourceState.SUCCESS, t))
            }
        }

        override fun onError(e: Throwable) {
            if (e is NoConnectivityException) {
                Log.e("", "222");
            } else {
                changePasswordLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.message
                    )
                )
            }
        }
    }

    override fun onCleared() {
        getUserProfile.dispose()
        super.onCleared()
    }


}
