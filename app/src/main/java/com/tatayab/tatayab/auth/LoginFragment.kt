package com.tatayab.tatayab.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.facebook.*
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.tatayab.model.responses.AuthenticationResponse
import com.tatayab.presentation.Utils.Companion.isInAppMessageShown
import com.tatayab.presentation.auth.UserLoginViewModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants.Companion.ENABLE_GRAPH_QUERIES_CALLS
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.adjust_tracking.AdjustTracker
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.refer.ReferFriendSuccessActivity
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.DialogUtil
import com.twitter.sdk.android.core.identity.TwitterAuthClient
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_login.input_email
import kotlinx.android.synthetic.main.fragment_login.input_password
import kotlinx.android.synthetic.main.fragment_login.pass_control
import java.util.*
import javax.inject.Inject


class LoginFragment : BaseFragment() {


    override fun layoutId(): Int = R.layout.fragment_login

    //private val PHONE = "user_mobile_phone"
    private val MOBILE_NUMBER = "verified_mobile_phone"
    private val EMAIL = "email"
    private val PUBLIC_PROFILE = "public_profile"
    private val USER_ID = "id"
    private val USER_FIRST_NAME = "first_name"
    private val USER_LAST_NAME = "last_name"
    private val FILEDS = "fields"
    private val GRAPH_PATH = "me/permissions"
    private val SUCCESS = "success"
    private var passHidden = true
    private lateinit var callbackManager: CallbackManager
    private lateinit var twitterAuthClient: TwitterAuthClient
    lateinit var mainViewModel: MainActivityViewModel

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory

    private val loginCode by lazy {
        arguments?.getInt(Constants.LOGIN)
    }
    private lateinit var viewModel: UserLoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        mainViewModel?.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS
        mainViewModel?.getCreateCartForUserLiveData!!.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    println("LOGIN ISSUE// createCartForUser/ERROR")
                     animationView.visibility = View.GONE
//                    loading.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    println("LOGIN ISSUE// createCartForUser/SUCCESS")
                     animationView.visibility = View.GONE
//                    loading.visibility = View.GONE
                    when (activity) {
                        is LoginActivity -> {
                            (activity as LoginActivity).apply {
                                finish()
                                overridePendingTransition(
                                    R.anim.no_animation,
                                    R.anim.slide_down
                                )
                            }
                        }
                    }
                }
                else -> {
                     animationView.visibility = View.VISIBLE
//                    loading.visibility = View.VISIBLE
                }
            }
        })
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = activity?.run {
            ViewModelProviders.of(this, viewModelFactory).get(UserLoginViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        viewModel?.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS

        viewModel.getLoginLiveData().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                     animationView.visibility = View.GONE
//                    loading.visibility = View.GONE
                    showCustomTopMessage(
                        getString(R.string.wrong_email_or_password),
                        DialogUtil.MessageType.ERROR
                    )
                }
                ResourceState.SUCCESS -> {
                     animationView.visibility = View.GONE
//                    loading.visibility = View.GONE
                    it.data?.let { loginResponse ->
                        if (!it.data?.token.isNullOrBlank()) {
                            FirebaseInstanceId.getInstance().instanceId
                                .addOnCompleteListener(OnCompleteListener { task ->
                                    if (!task.isSuccessful) {
                                        Log.w(
                                            "tokenFirebase",
                                            "getInstanceId failed",
                                            task.exception
                                        )
                                        return@OnCompleteListener
                                    }
                                    //   update the firebase logs
                                    addCustomLogToCrashlytics(
                                        viewModel.getCountryCode(),
                                        App.getPref().currentLanguage.toString(),
                                        loginResponse.user_id.toString(),
                                        loginResponse.email!!,
                                        loginResponse.firstname!!
                                    )
                                    try {
                                        AdjustTracker.userId = loginResponse.user_id.toString()
                                        AdjustTracker.userEmail = loginResponse.email.toString()
                                        InsiderManager.addUser(
                                            if (loginResponse.email.isNullOrEmpty()!!) "" else loginResponse.email!!,
                                            if (loginResponse.phone.isNullOrEmpty()) "" else loginResponse.phone,
                                            if (loginResponse.user_id == null) "" else loginResponse.user_id.toString()
                                        )
                                        var params = HashMap<String, Any>()
                                        InsiderManager.sendCustomEvent(
                                            InsiderManager.CustomEvent.login.toString(),
                                            params
                                        )

                                    } catch (e: java.lang.Exception) {
                                        e.printStackTrace()
                                    }

                                    if (ENABLE_GRAPH_QUERIES_CALLS) {
                                        moveAfterLoginStep(it?.data)
                                    } else {
                                        // Get new Instance ID token
                                        val token = task.result?.token
                                        token?.let { firebaseToken ->
                                            viewModel.setNotificationToken(
                                                firebaseToken,
                                                loginResponse
                                            )
                                        }
                                    }
                                })

                            MemoryCacheManager?.saveUserData(it?.data)
                        } else
                            showCustomTopMessage(
                                it.data?.message.toString(),
                                DialogUtil.MessageType.ERROR
                            )
                    }

                }
                else -> {
//                    loading.visibility = View.VISIBLE
                     animationView.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getTokenResponseLiveData().observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                     animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    it.data?.let {
                        hideKeyboard()
                        isInAppMessageShown = false
                        when (activity) {
                            is LoginActivity -> {
                                (activity as LoginActivity).apply {
                                    val returnIntent = Intent()
                                    returnIntent.putExtra(
                                        Constants.LOGIN,
                                        Constants.REQUEST_CODE_LOG_IN
                                    )
                                    returnIntent.putExtra(
                                        Constants.USER_PROFILE,
                                        it.second.userProfile
                                    )
                                    setResult(Activity.RESULT_OK, returnIntent)
                                    if (!this.invitationUrl.isNullOrEmpty()) {
                                        var deepLinkIntent =
                                            Intent(this, ReferFriendSuccessActivity::class.java)
                                        deepLinkIntent?.putExtra(
                                            ReferFriendSuccessActivity.INVITATION_URL_HOLDER,
                                            this.invitationUrl
                                        )
                                        deepLinkIntent?.let {
                                            startActivity(it)
                                        }
                                    }
                                    this.finish()
                                    overridePendingTransition(
                                        R.anim.no_animation,
                                        R.anim.slide_down
                                    )
                                }
                            }
                            is MainActivity -> {
                                (activity as MainActivity).apply {
                                    showCustomSuccessDialog(
                                        getString(R.string.review_card_after_login),
                                        DialogUtil.MessageType.ERROR
                                    )
                                    Handler().postDelayed({
                                        navigateBackWithResult(Bundle())
                                        loginSucceed()
                                    }, 1000)
                                }
                            }
                            else -> {
                                println(">>>> not main activity")
                            }
                        }
                    }
                }
                else -> {
                     animationView.visibility = View.VISIBLE
                }
            }
        })
    }


    private fun moveAfterLoginStep(userProfile: AuthenticationResponse?) {
        try {
            isInAppMessageShown = false
            MemoryCacheManager.setCartId("")
            when (activity) {
                is LoginActivity -> {
                    (activity as LoginActivity).apply {
                        println("LOGIN ISSUE// (activity as LoginActivity)")
                        val returnIntent = Intent()
                        returnIntent.putExtra(
                            Constants.LOGIN,
                            Constants.REQUEST_CODE_LOG_IN
                        )
                        returnIntent.putExtra(
                            Constants.USER_PROFILE,
                            userProfile
                        )
                        setResult(Activity.RESULT_OK, returnIntent)
                        if (!this.invitationUrl.isNullOrEmpty()) {
                            var deepLinkIntent =
                                Intent(this, ReferFriendSuccessActivity::class.java)
                            deepLinkIntent?.putExtra(
                                ReferFriendSuccessActivity.INVITATION_URL_HOLDER,
                                this.invitationUrl
                            )
                            deepLinkIntent?.let {
                                startActivity(it)
                            }
                        }
                        println("LOGIN ISSUE// finish")
                        if (ENABLE_GRAPH_QUERIES_CALLS) mainViewModel?.createCartForUser()

                    }
                }
                is MainActivity -> {
                    (activity as MainActivity).apply {
                        showCustomSuccessDialog(
                            getString(R.string.review_card_after_login),
                            DialogUtil.MessageType.ERROR
                        )
                        Handler().postDelayed({
                            navigateBackWithResult(Bundle())
                            loginSucceed()
                        }, 1000)
                    }
                }
                else -> {
                    println(">>>> not main activity")
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun validateData(): Boolean {

        if (TextUtils.isEmpty(input_email.text) || !Patterns.EMAIL_ADDRESS.matcher(input_email.text.toString())
                .matches()
        ) {
            input_email.error = getString(R.string.please_enter_valid_email)
            return false
        }

        if (TextUtils.isEmpty(input_password.text)) {
            input_password.error = getString(R.string.please_enter_password)
            return false
        }

        return true
    }

    private fun initComponent() {
        if (activity !is LoginActivity)
            tv_forget_password.visibility = View.GONE
        btn_login.text = getText(R.string.sign_in)

        btn_login.setSafeOnClickListener {
            if (validateData()) {
                hideKeyboard()
                viewModel.loginUser(
                    input_email.text.toString(),
                    input_password.text.toString(),
                    App.getPref().firstUserToken
                )
            }
        }

        tv_forget_password.setSafeOnClickListener {
            hideKeyboard()
            if (activity is LoginActivity)
                (activity as LoginActivity).goToForgettPass()
        }


        pass_control.setSafeOnClickListener {
            if (passHidden) {
                input_password.transformationMethod = null
                pass_control.setImageResource(R.drawable.show_password)
                passHidden = false
            } else {
                input_password.transformationMethod = PasswordTransformationMethod()
                pass_control.setImageResource(R.drawable.hide_password)
                passHidden = true
            }
        }
    }

    fun setProgressState(state: Int) {
        if (activity is LoginActivity) {
            (activity as LoginActivity).apply {
                setProgressState(state)
            }
        }
    }
}
