package com.tatayab.tatayab.auth

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.InputFilter
import android.text.TextUtils
import android.text.TextWatcher
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.util.Patterns
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.iid.FirebaseInstanceId
import com.tatayab.presentation.Utils.Companion.isInAppMessageShown
import com.tatayab.presentation.auth.UserLoginViewModel
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.adjust_tracking.AdjustTracker
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.errorHandling.ExceptionHandler
import com.tatayab.tatayab.ext.hideKeyboard

import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.refer.ReferFriendSuccessActivity
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.DialogUtil
import com.tatayab.tatayab.util.TextUtil
import kotlinx.android.synthetic.main.fragment_register.*
import kotlinx.android.synthetic.main.fragment_register.animationView
import kotlinx.android.synthetic.main.fragment_register.phone_code
import javax.inject.Inject


class RegisterFragment : BaseFragment() {


    private lateinit var viewModel: UserLoginViewModel
    private var passHidden = true


    override fun layoutId(): Int = R.layout.fragment_register
    lateinit var mainViewModel: MainActivityViewModel

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

        mainViewModel?.ENABLE_GRAPH_QUERIES_CALLS =
            com.tatayab.remote.util.Constants.ENABLE_GRAPH_QUERIES_CALLS

        mainViewModel?.getCreateCartForUserLiveData!!.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                      animationView.visibility = View.GONE
                 }
                ResourceState.SUCCESS -> {
                      animationView.visibility = View.GONE
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
                 }
            }
        })

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }


    private fun initComponent() {

        btn_signup.setSafeOnClickListener {
            hideKeyboard()
            if (validateData()) {
                viewModel.register(
                    input_fullname.text.toString(),
                    input_email.text.toString(),
                    input_password.text.toString(),
                    input_phone.text.toString(),
                    App.getPref().currentLanguage.toString(),
                    getUniqueDeviceID()
                )
            }
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

        input_fullname.addTextChangedListener(@SuppressLint("checkResult")
        object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                if (!s.toString().trim().isNullOrEmpty()) input_fullname.setError(null)
            }

            override fun beforeTextChanged(
                s: CharSequence?,
                start: Int,
                count: Int,
                after: Int
            ) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        }

        )
    }


    private fun validatePhoneNumber(phone: String): Boolean {
        val validateMessage = viewModel.validatePhone(phone)
        if (validateMessage != "1") {
            input_phone.error = formatePhoneErrorMessage(validateMessage)
            return false
        } else
            return true
    }


    private fun validateData(): Boolean {
        var fullName = input_fullname.text.toString()
        if (!TextUtil.validName(fullName.replace(" ", ""))) {
            input_fullname.error = getString(R.string.fullname_with_chars)
            return false
        }
        if (fullName.isNullOrEmpty() || !fullName.contains(" ") || fullName.trim()
                .isNullOrEmpty() || fullName.length < 3
        ) {
            if (!fullName.isNullOrEmpty() && !TextUtil.validName(fullName.replace(" ", ""))) {
                input_fullname.error = getString(R.string.fullname_with_chars)
            } else {
                input_fullname.error = getString(R.string.please_enter_fullname)
            }
            return false
        }
        if (fullName.contains(" ")) {
            var namesList = fullName.split(" ")
            if (namesList.isNullOrEmpty() || namesList.size < 2 || namesList[0].isNullOrEmpty() || namesList[1].isNullOrEmpty()) {
                input_fullname.error = getString(R.string.please_enter_fullname)
                return false
            }
        }

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

        if (!TextUtil.validPassword(input_password.text.toString())) {
            input_password.error = getString(R.string.please_enter_valid_password)
            return false
        }

        if (input_phone.text.isEmpty()) {
            input_phone.error = getString(R.string.filed_required)
            return false
        }
        return validatePhoneNumber(input_phone.text.toString())
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this, viewModelFactory).get(UserLoginViewModel::class.java)
        } ?: throw Exception("Invalid Activity")

        if(viewModel?.getPhoneLenght().isNullOrBlank().not()) {
            input_phone.filters = arrayOf(InputFilter.LengthFilter(viewModel?.getPhoneLenght().toInt()))
        }
        viewModel?.ENABLE_GRAPH_QUERIES_CALLS =
            com.tatayab.remote.util.Constants.ENABLE_GRAPH_QUERIES_CALLS

        phone_code.text = viewModel.getCountryPhoneCode()

        viewModel.getRegisterLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                     animationView.visibility = View.GONE
                    var message = ""
                    if (it?.message.isNullOrBlank()) {
                        message =
                            ExceptionHandler().getMessage(it.throwable!!, requireContext())
                                .toString()
                    } else {
                        message = it?.message.toString()
                    }
                    message?.let { it1 -> showErrorDialog(btn_signup, it1) }
                }
                ResourceState.SUCCESS -> {
                     animationView.visibility = View.GONE
                    if (!it.data?.token.isNullOrBlank()) {
                        FirebaseInstanceId.getInstance().instanceId.addOnCompleteListener(
                            OnCompleteListener { task ->
                                if (!task.isSuccessful) {
                                    Log.w(
                                        "tokenFirebase",
                                        "getInstanceId failed",
                                        task.exception
                                    )
                                    return@OnCompleteListener
                                }
                                if (com.tatayab.remote.util.Constants.ENABLE_GRAPH_QUERIES_CALLS) {
                                    mainViewModel?.createCartForUser()
                                } else {
                                    // Get new Instance ID token
                                    val token = task.result?.token
                                    token?.let { firebaseToken ->
                                        viewModel.setNotificationToken(
                                            firebaseToken, it.data!!
                                        )
                                    }
                                }
                            })

                        try {
                            AdjustTracker.userId = it.data?.user_id.toString()
                            AdjustTracker.userEmail = input_email.text.toString()
                            AdjustTracker.trackEvent(AdjustTracker.SIGNUP_EVENT, HashMap())

                            InsiderManager.addUser(
                                if (it.data?.email.isNullOrEmpty()) "" else it.data?.email!!,
                                if (it.data?.phone.isNullOrEmpty()) "" else it.data?.phone!!,
                                if (it.data?.user_id == null) "" else it.data?.user_id.toString()
                            )
                            val params = java.util.HashMap<String, Any>()
                            InsiderManager.sendCustomEvent(
                                InsiderManager.CustomEvent.register.toString(),
                                params
                            )

                        } catch (e: java.lang.Exception) {
                            e.printStackTrace()
                        }
                    } else {
                        showCustomTopMessage(
                            it.data?.message.toString(),
                            DialogUtil.MessageType.ERROR
                        )
                    }
                }
                else -> {
                     animationView.visibility = View.VISIBLE
                }

            }
        })

        viewModel.getTokenResponseLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                     animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    it.data?.let {
                        hideKeyboard()
                        isInAppMessageShown = false
                        if (activity is LoginActivity) {
                            (activity as LoginActivity).apply {
                                val returnIntent = Intent()
                                returnIntent.putExtra(
                                    Constants.LOGIN,
                                    Constants.REQUEST_CODE_LOG_IN
                                )
                                returnIntent.putExtra(Constants.USER_PROFILE, it.second.userProfile)
                                returnIntent.putExtra(Constants.FROM_REGISTER, true)
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
                                finish()
                                overridePendingTransition(
                                    R.anim.no_animation,
                                    R.anim.slide_down
                                )
                            }

                        } else if (activity is MainActivity) {
                            (activity as MainActivity).apply {
                                showCustomTopMessage(
                                    getString(R.string.register_success),
                                    DialogUtil.MessageType.ERROR
                                )
                                Handler().postDelayed({
                                    navigateBackWithResult(Bundle())
                                    loginSucceed()
                                }, 1000)

                            }
                        } else {
                            println(">>>> not main activity")
                        }
                    }
                }
                else -> {
                     animationView.visibility = View.VISIBLE
                }
            }
        })
    }


    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            RegisterFragment().apply {
                arguments = Bundle().apply {

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
