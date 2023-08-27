
package com.tatayab.tatayab.auth

import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentManager
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseActivity2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.refer.ReferFriendSuccessActivity
import com.tatayab.tatayab.util.NavigationResult
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.toolbar_with_back.*
import kotlin.properties.Delegates


class LoginActivity : BaseActivity2() {

    var navController: NavController? = null
    var navGraph: NavGraph? = null
    var isCheckoutSignInFragmentVisible = true
    open var invitationUrl:String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        intent?.extras?.let {
            invitationUrl = it.getString(ReferFriendSuccessActivity.INVITATION_URL_HOLDER, "")
        }

        tv_title.text = getText(R.string.sign_in)
        navController = Navigation.findNavController(this, R.id.login_host_nav)
        navGraph = navController?.navInflater?.inflate(R.navigation.login_graph)
        navController?.graph = navGraph!!
        tv_title.text = getText(R.string.sign_in)
        iv_back.setSafeOnClickListener {
            onBackPressed()
        }

        rg_sign.setOnCheckedChangeListener { radioGroup, checkedId ->

            when (checkedId) {
                R.id.rb_login -> {
//                    navGraph?.setStartDestination( R.id.destination_login)
                    //                    navController?.graph = navGraph!!
                    navController?.navigate(R.id.destination_login)
                    tv_title.text = getText(R.string.sign_in)
                }
                R.id.rb_register -> {
//                    navGraph?.setStartDestination( R.id.destination_register)
                    navController?.navigate(R.id.destination_register)
//                    navController?.graph = navGraph!!
                    tv_title.text = getText(R.string.signup)
                }
            }
        }
    }

    fun afterReturnForgetPass() {
        tv_title.text = getText(R.string.sign_in)
        rg_sign.visibility = View.VISIBLE
    }

    fun goToForgettPass() {
        tv_title.text = getText(R.string.forgetten_password)
        navController?.navigate(R.id.destination_forgetpassword)
        rg_sign.visibility = View.GONE
    }


    override fun onBackPressed() {
        if (navController?.currentDestination?.id == R.id.destination_forgetpassword) {
            navController?.popBackStack()
            rg_sign.visibility = View.VISIBLE
            tv_title.text = getText(R.string.sign_in)
        } else if (!isCheckoutSignInFragmentVisible) {
            tv_title.text = getText(R.string.sign_in)
            rg_sign.visibility = View.GONE
            isCheckoutSignInFragmentVisible = true
        } else {
            this.finish()
        }
    }

    fun setProgressState(state:Int){
        login_loading.visibility = state
    }
    fun navigateBackWithResult(result: Bundle) {
        try {
            val childFragmentManager =
                supportFragmentManager.findFragmentById(R.id.nav_host_container)
                    ?.childFragmentManager
            var backStackListener: FragmentManager.OnBackStackChangedListener by Delegates.notNull()
            backStackListener = FragmentManager.OnBackStackChangedListener {
                if (childFragmentManager?.fragments?.get(0) is NavigationResult) {
                    (childFragmentManager.fragments[0] as NavigationResult).onNavigationResult(
                        result
                    )
                    childFragmentManager.removeOnBackStackChangedListener(backStackListener)
                }
            }
            childFragmentManager?.addOnBackStackChangedListener(backStackListener)
            onBackPressed()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}
