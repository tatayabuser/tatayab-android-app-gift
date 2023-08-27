package com.tatayab.presentation.auth

import android.os.Handler
import android.os.Looper
import android.util.Log
import com.tatayab.domain.interactor.auth.ForgetPassword
import com.tatayab.domain.interactor.auth.Login
import com.tatayab.domain.interactor.auth.Register
import com.tatayab.domain.interactor.user.SaveFirebaseTokenExecution
import com.tatayab.domain.interactor.user.SetFirebaseToken
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.RegisterRequestBody
import com.tatayab.model.requests.SaveFirebaseTokenRequestBody
import com.tatayab.model.requests.UserTokenRequestBody
import com.tatayab.model.responses.AuthenticationResponse
import com.tatayab.model.responses.NormalResponse
import com.tatayab.model.responses.TokenResponse
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableObserver
import javax.inject.Inject

class UserLoginViewModel @Inject constructor(
    private val login: Login,
    private val register: Register,
    private val forgetPassword: ForgetPassword,
    private val setFirebaseToken: SetFirebaseToken,
    private val mSaveFirebaseTokenExecution: SaveFirebaseTokenExecution,
    private val repository: TatayabRepository
) : BaseViewModel(repository) {

    private var mAuthenticationResponse: AuthenticationResponse? = null
    var ENABLE_GRAPH_QUERIES_CALLS = false
    private val userLoginLiveData: SingleLiveEvent<Resource<AuthenticationResponse>> =
        SingleLiveEvent()
    private val userRegisterLiveData: SingleLiveEvent<Resource<AuthenticationResponse>> =
        SingleLiveEvent()
    private val forgetPasswordLiveData: SingleLiveEvent<Resource<NormalResponse>> =
        SingleLiveEvent()
    private val tokenResponseLiveData: SingleLiveEvent<Resource<Pair<String, TokenResponse>>> =
        SingleLiveEvent()

    fun register(
        name: String,
        email: String,
        password: String,
        phone: String,
        languageCode: String,
        deviceId: String
    ) {
        userRegisterLiveData.postValue(Resource(ResourceState.LOADING))
        register.execute(
            RegisterUserSubscriber(email, password),
            Register.Params.forUser(
                RegisterRequestBody(
                    country_code = getCountryCode(),
                    lang_code = languageCode,
                    email = email,
                    phone = phone,
                    firstname = name , device_id = deviceId, password = password
                ), languageCode
            )
        )
    }


    fun loginUser(
        email: String,
        password: String,
        token: String,
        isComeFromSignUp: Boolean = false,
        name: String? = ""
    ) {
        userLoginLiveData.postValue(Resource(ResourceState.LOADING))
        login.execute(
            LoginUserSubscriber(isComeFromSignUp, name),
            Login.Params.forUser(
                email, password, "",
                ENABLE_GRAPH_QUERIES_CALLS
            )
        )
    }


    fun forgetPassword(email: String, languageCode: String) {
        forgetPasswordLiveData.postValue(Resource(ResourceState.LOADING))
        forgetPassword.execute(
            ForgetPasswordSubscriber(),
            ForgetPassword.Params.forUser(
                email, languageCode
            )
        )
    }

    fun setNotificationToken(token: String, user: AuthenticationResponse) {
        setFirebaseToken.execute(
            SetFirebaseTokenSubscriber(token, user),
            SetFirebaseToken.Params.forUser(
                UserTokenRequestBody(
                    userId = user.user_id.toString(),
                    token = token
                )
            )
        )
        mSaveFirebaseTokenExecution.execute(
            SaveFirebaseTokenSubscriber(token, user),
            SaveFirebaseTokenExecution.Params.forUser(
                SaveFirebaseTokenRequestBody(
                    userId = user.user_id,
                    token = token
                )
            )
        )
    }


    fun getLoginLiveData(): SingleLiveEvent<Resource<AuthenticationResponse>> {
        return userLoginLiveData
    }


    fun getRegisterLiveData(): SingleLiveEvent<Resource<AuthenticationResponse>> {
        return userRegisterLiveData
    }

    fun getForgetPasswordLiveData(): SingleLiveEvent<Resource<NormalResponse>> {
        return forgetPasswordLiveData
    }


    fun getTokenResponseLiveData(): SingleLiveEvent<Resource<Pair<String, TokenResponse>>> {
        return tokenResponseLiveData
    }

    inner class LoginUserSubscriber(var isComeFromSignUp: Boolean, var name: String? = "") :
        DisposableObserver<AuthenticationResponse>() {
        override fun onNext(t: AuthenticationResponse) {
            t.let { _ ->
                if (!t?.message.isNullOrBlank()) {
                    userRegisterLiveData.postValue(
                        Resource(
                            ResourceState.ERROR,
                            message = t?.message.toString(),
                            throwable = null
                        )
                    )
                    userLoginLiveData.postValue(
                        Resource(
                            ResourceState.ERROR,
                            message = t?.message.toString(),
                            throwable = null
                        )
                    )
                } else {
                    if (ENABLE_GRAPH_QUERIES_CALLS) {
                        mAuthenticationResponse = t
                        if (isComeFromSignUp) {
                            mAuthenticationResponse?.firstname = name.toString()
                            if (mAuthenticationResponse != null && !t.token.isNullOrBlank()) {
                                mAuthenticationResponse?.token = t.token
                            }
                            Handler(Looper.getMainLooper()).postDelayed(
                                {
                                    userRegisterLiveData.postValue(
                                        Resource(
                                            ResourceState.SUCCESS,
                                            mAuthenticationResponse
                                        )
                                    )
                                },
                                1000 // value in milliseconds
                            )

                        } else {
                            // call profile query to get the INFO of user
                            userLoginLiveData.postValue(
                                Resource(
                                    ResourceState.SUCCESS,
                                    t
                                )
                            )
                        }

                    } else {
                        userLoginLiveData.postValue(
                            Resource(
                                ResourceState.SUCCESS,
                                t
                            )
                        )
                    }

                }
            }
        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            if (isComeFromSignUp && ENABLE_GRAPH_QUERIES_CALLS) {
                userRegisterLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            } else {
                userLoginLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = e.localizedMessage
                    )
                )
            }

        }
    }

    inner class RegisterUserSubscriber(val email: String, val password: String) :
        DisposableObserver<AuthenticationResponse>() {
        override fun onNext(t: AuthenticationResponse) {
            if (!t.message.isNullOrBlank()) {
                userRegisterLiveData.postValue(
                    Resource(
                        ResourceState.ERROR,
                        message = t?.message.toString(),
                        throwable = null
                    )
                )
            } else {
                if (ENABLE_GRAPH_QUERIES_CALLS) {
                    loginUser(email, password, "", true, t?.firstname.toString())
                    mAuthenticationResponse = t
                } else {
                    userRegisterLiveData.postValue(Resource(ResourceState.SUCCESS, t))
                }
            }

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

    inner class ForgetPasswordSubscriber : DisposableObserver<NormalResponse>() {
        override fun onNext(t: NormalResponse) {
            if (t.success == 1)
                forgetPasswordLiveData.postValue(Resource(ResourceState.SUCCESS, t))
            else
                forgetPasswordLiveData.postValue(
                    Resource(
                        ResourceState.ERROR, message = t?.msg.toString()
                    )
                )
        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            forgetPasswordLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }
    }

    inner class SetFirebaseTokenSubscriber(
        val token: String,
        val user: AuthenticationResponse
    ) : DisposableObserver<TokenResponse>() {
        override fun onError(e: Throwable) {
            tokenResponseLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }

        override fun onNext(t: TokenResponse) {
            Log.d("response", t.toString())
            t.userProfile = user
            tokenResponseLiveData.postValue(
                Resource(
                    ResourceState.SUCCESS,
                    Pair(token, t)
                )
            )
        }

        override fun onComplete() {
        }

    }

    inner class SaveFirebaseTokenSubscriber(
        val token: String,
        val user: AuthenticationResponse
    ) : DisposableObserver<TokenResponse>() {
        override fun onError(e: Throwable) {

        }

        override fun onNext(t: TokenResponse) {
        }

        override fun onComplete() {
        }

    }

    override fun onCleared() {
        setFirebaseToken.dispose()
        forgetPassword.dispose()
        login.dispose()
        register.dispose()
        super.onCleared()
    }

}