package com.tatayab.tatayab.checkout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.text.TextUtils
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.facebook.*
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.tatayab.presentation.Utils
import com.tatayab.presentation.auth.UserSocialLoginViewModel
import com.tatayab.presentation.auth.UserSocialLoginViewModelFactory
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants.Companion.ENABLE_GRAPH_QUERIES_CALLS
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.auth.LoginActivity
import com.tatayab.tatayab.auth.LoginOptionActivity
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.Constants.EMAIL
import com.tatayab.tatayab.util.Constants.FILEDS
import com.tatayab.tatayab.util.Constants.PUBLIC_PROFILE
import com.tatayab.tatayab.util.Constants.USER_FIRST_NAME
import com.tatayab.tatayab.util.Constants.USER_ID
import com.tatayab.tatayab.util.Constants.USER_LAST_NAME
import com.tatayab.tatayab.util.DialogUtil
import com.tatayab.tatayab.util.NavigationResult
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.fragment_signin_options.*
import kotlinx.android.synthetic.main.toolbar_with_back.*
import org.json.JSONException
import org.json.JSONObject
import java.util.*
import javax.inject.Inject


class SignInOptionsFragment : BaseFragment(),
    FacebookCallback<LoginResult>, NavigationResult {

    private lateinit var mGoogleSignInClient: GoogleSignInClient
    private lateinit var callbackManager: CallbackManager
    private var socialToken: String = ""
    private var userName: String = ""
    private var registerType: String = ""
    lateinit var mainViewModel: MainActivityViewModel

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory

    @Inject
    lateinit var userSocialLoginViewModelFactory: UserSocialLoginViewModelFactory.Factory
    private lateinit var viewModel: UserSocialLoginViewModel


    private val fromCheckout by lazy {
        arguments?.let { SignInOptionsFragmentArgs.fromBundle(it).fromCheckout } ?: false
    }

    companion object {
        private const val RC_SIGN_IN = 9001
    }

    override fun layoutId(): Int {
        return R.layout.fragment_signin_options
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            //  .requestIdToken("jcbrnik7v11r22j44if025trapk8lu5o")
            .requestEmail()
            .build()

        Utils.CheckOutAction.openLoginOptions = true

        mGoogleSignInClient = GoogleSignIn.getClient(requireActivity(), gso)
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        viewModel =
            ViewModelProviders.of(this, userSocialLoginViewModelFactory.create())
                .get(UserSocialLoginViewModel::class.java)

        mainViewModel?.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS
        viewModel?.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS

        viewModel.getRegisterLiveData().observe(this, androidx.lifecycle.Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    it?.data?.let { response ->
                        if ((!TextUtils.isEmpty(response.email) && response.is_exist == 1) || ENABLE_GRAPH_QUERIES_CALLS) {
                            if (fromCheckout)
                                returnToCheckout()
                            else {
                                (activity as MainActivity).loginSucceed()
                                val returnIntent = Bundle()
                                returnIntent.putInt(
                                    Constants.LOGIN,
                                    Constants.REQUEST_CODE_LOG_IN
                                )
                                returnIntent.putParcelable(
                                    Constants.USER_PROFILE,
                                    response
                                )
                                (activity as MainActivity).navigateBackWithResult(returnIntent)
                                if (activity is LoginOptionActivity) {
                                    (activity as LoginOptionActivity).apply {
                                        if(!this.invitationUrl.isNullOrEmpty()){
                                            this.openReferFriendSuccess()
                                        }else{
                                            this.closeScreen()
                                        }
                                    }                                }
                            }
                        } else {
                            val action = SignInOptionsFragmentDirections.updateProfileAction()
                            findNavController().navigate(action)
                        }
                    }
                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })

    }
    private fun createCartForUser(){
        mainViewModel?.createCartForUser()
    }

    private fun returnToCheckout() {
        if (ENABLE_GRAPH_QUERIES_CALLS){
            createCartForUser()
            showCustomSuccessDialog(
                getString(R.string.review_card_after_login),
                DialogUtil.MessageType.SUCCESS
            )
            Handler().postDelayed({
                Utils.CheckOutAction.action = Utils.CheckActionType.NEW_LOGIN
                Utils.CheckOutAction.addressID = 0
                findNavController().popBackStack()
            }, 1000)
        }else{
            Utils.CheckOutAction.action = Utils.CheckActionType.NEW_LOGIN
            Utils.CheckOutAction.addressID = 0
            findNavController().popBackStack()
        }

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        callbackManager = CallbackManager.Factory.create()

        if (!fromCheckout)
            tv_guest_login.visibility = View.GONE

        tv_email.setSafeOnClickListener {
            hideKeyboard()
            loginWithEmail()
            val bundle = Bundle().apply {
                putInt(Constants.LOGIN, Constants.REQUEST_CODE_LOG_IN)
                putBoolean(Constants.FROM_CHECKOUT, fromCheckout)
            }
            val loginIntent = Intent(activity, LoginActivity::class.java)
            loginIntent.putExtras(bundle)
            startActivityForResult(loginIntent, Constants.REQUEST_CODE_LOGIN_ACTIVITY)

        }
        iv_back.setSafeOnClickListener {
            if (activity is LoginOptionActivity) {
                (activity as LoginOptionActivity).apply {
                    this?.finish()

                }
            } else if (activity is MainActivity) {
                (activity as MainActivity).apply {
                    this?.onBackPressed()

                }
            }
        }

        tv_guest_login.setSafeOnClickListener {
            hideKeyboard()
            val action = SignInOptionsFragmentDirections.actionAddAddress(null, true)
            findNavController().navigate(action)
        }

        tv_google_login.setSafeOnClickListener {
            try {
                hideKeyboard()
                val signInIntent = mGoogleSignInClient.signInIntent
                startActivityForResult(signInIntent, RC_SIGN_IN)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        tv_facebook_login.setSafeOnClickListener {
            hideKeyboard()
            LoginManager.getInstance()
                .registerCallback(callbackManager, this@SignInOptionsFragment)
            val accessToken = AccessToken.getCurrentAccessToken()
            val isLoggedIn = accessToken != null && !accessToken.isExpired

            if (isLoggedIn) {

                if (checkDeclinedPermissionAreEmpty()) {
                    getUserProfileWithGraphRequest(AccessToken.getCurrentAccessToken())
                } else {
                    // logout user and show toast
                    showCustomTopMessage(
                        getString(R.string.should_agree_on_permission),
                        DialogUtil.MessageType.ERROR
                    )
                    LoginManager.getInstance().logOut()

                }
            } else { // user should login with three permission
                // Set permissions
                loginWithParameters()
            }

        }


    }

    private fun loginWithParameters() {
        LoginManager.getInstance()
            .logInWithReadPermissions(
                this@SignInOptionsFragment,
                listOf(EMAIL, PUBLIC_PROFILE)
            )
    }

    private fun checkDeclinedPermissionAreEmpty(): Boolean {
        val declined = AccessToken.getCurrentAccessToken().declinedPermissions
        if (declined.isEmpty()) {
            return true
        }
        return false
    }

    private fun getUserProfileWithGraphRequest(accessToken: AccessToken) {
        val parameters = Bundle()
        parameters.putString(FILEDS, "$USER_ID,$USER_FIRST_NAME,$USER_LAST_NAME,$EMAIL")
        val request = GraphRequest.newMeRequest(
            accessToken
        ) { `object`: JSONObject?, response: GraphResponse? ->
            run {

                if (response?.error != null) {
                    // handle error
                    println("SOICAL MDIA/error facebook login${response?.error}")
                } else {
                    try {
                        val jsonResult = `object`
                        val fname = jsonResult?.optString(USER_FIRST_NAME)
                        val lname = jsonResult?.optString(USER_LAST_NAME)
                        val id = jsonResult?.optString(USER_ID)
                        val email = jsonResult?.optString(EMAIL)

                        loginWithSocial(
                            email,
                            "",
                            "$fname $lname",
                            "facebook",
                            id,
                            App.getPref().currentLanguage.toString()
                        )

                    } catch (e: JSONException) {
                        e.printStackTrace()
                        println("SOICAL MDIA/error facebook login2: ${e?.message}")

                    }
                }
            }

        }
        request.parameters = parameters
        request.executeAsync()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        callbackManager.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == RC_SIGN_IN) {
            val task = GoogleSignIn.getSignedInAccountFromIntent(data)
            handleSignInResult(task)
        } else if (requestCode == Constants.REQUEST_CODE_LOGIN_ACTIVITY && resultCode == Activity.RESULT_OK && data?.getIntExtra(
                Constants.LOGIN,
                Constants.REQUEST_CODE_LOG_IN
            ) == Constants.REQUEST_CODE_LOG_IN
        ) {
            (activity as MainActivity).loginSucceed()
            if (fromCheckout)
                returnToCheckout()
            else {
                val bundle = Bundle()
                bundle.putInt(Constants.LOGIN, Constants.REQUEST_CODE_LOG_IN)
                (activity as MainActivity).navigateBackWithResult(bundle)
            }
            if (activity is LoginOptionActivity) {
                (activity as LoginOptionActivity).apply {
                    if(!this.invitationUrl.isNullOrEmpty()){
                        this.openReferFriendSuccess()
                    }else{
                            this.closeScreen()
                    }
                 }
            }
        }

    }

    private fun handleSignInResult(completedTask: Task<GoogleSignInAccount>) {
        try {
            val account = completedTask.getResult(ApiException::class.java)
            loginWithSocial(
                account?.email,
                "",
                account?.displayName,
                "google",
                account?.id,
                App.getPref().currentLanguage.toString()
            )
        } catch (e: ApiException) {
            println("SOICAL MDIA/GOOGLE FAILD" + e.statusCode)
        }
    }


    override fun onSuccess(result: LoginResult?) {
        println("Success facebook login\n${result.toString()}")
        // make graph request
        if (checkDeclinedPermissionAreEmpty()) {
            getUserProfileWithGraphRequest(result!!.accessToken)
        } else {
            // logout user and show toast
            showCustomTopMessage(
                getString(R.string.should_agree_on_permission),
                DialogUtil.MessageType.ERROR
            )
            LoginManager.getInstance().logOut()

        }
    }

    override fun onCancel() {
        showCustomTopMessage(getText(R.string.you_cancel).toString(), DialogUtil.MessageType.ERROR)
        println("SOICAL MDIA/canceled facebook login")
    }

    override fun onError(error: FacebookException?) {
        showCustomTopMessage(error?.localizedMessage.toString(), DialogUtil.MessageType.ERROR)
        println("SOICAL MDIA/error facebook login${error?.localizedMessage}\n${error.toString()}")
    }


    private fun loginWithSocial(
        email: String?,
        phone: String?,
        firstname: String?,
        reg_type: String?,
        social_id: String?,
        langCode: String
    ) {
        viewModel.soicalRegister(
            Utils.DEVICE_UID,
            if (email.isNullOrEmpty()) "" else email!!,
            if (phone.isNullOrEmpty()) "" else phone!!,
            if (firstname.isNullOrEmpty()) "" else firstname!!,
            if (reg_type.isNullOrEmpty()) "" else reg_type!!,
            if (social_id.isNullOrEmpty()) "" else social_id!!, langCode
        )
        socialToken = if (social_id.isNullOrEmpty()) "" else social_id!!
        userName = if (firstname.isNullOrEmpty()) "" else firstname!!
        registerType = if (reg_type.isNullOrEmpty()) "" else reg_type!!
    }

    private fun loginWithEmail() {
        tv_title.text = getText(R.string.sign_in)
        rg_sign?.visibility = View.VISIBLE
        //frame_container?.visibility = View.GONE
    }

    override fun onNavigationResult(result: Bundle) {
        if (result.getBoolean(Constants.UPDATE_PROFILE)) {
            val email = result.getString(Constants.USER_EMAIL)
            loginWithSocial(
                email,
                "",
                userName,
                "gmail",
                socialToken,
                App.getPref().currentLanguage.toString()
            )
        }
//        else if (result.getInt(Constants.SELECTED_ADDRESS) == Constants.REQUEST_CODE_SELECT_ADDRESS) { // after change address
//            val returnIntent = Bundle()
//            returnIntent.putInt(
//                Constants.SELECTED_ADDRESS,
//                Constants.REQUEST_CODE_SELECT_ADDRESS
//            )
//            Utils.CheckOutAction.action = Utils.CheckActionType.NEW_LOGIN
//            (activity as MainActivity).navigateBackWithResult(returnIntent)
//
//        }
    }


}