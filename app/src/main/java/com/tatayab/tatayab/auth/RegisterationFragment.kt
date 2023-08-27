package com.tatayab.tatayab.auth

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.tatayab.model.UserProfile
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseActivity
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.Constants
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.fragment_add_address.*
import kotlinx.android.synthetic.main.fragment_login.*
import kotlinx.android.synthetic.main.toolbar_with_back.*


class RegisterationFragment : BaseFragment() {





    var navController: NavController? = null
    var navGraph: NavGraph? = null

    override fun layoutId(): Int {
        return R.layout.activity_login
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        tv_title.text = getText(R.string.sign_in)
        toolbar.visibility = View.GONE

        navController = Navigation.findNavController(requireActivity(), R.id.login_host_nav)
        navGraph = navController?.navInflater?.inflate(R.navigation.login_graph)
        navController?.graph = navGraph!!

        rg_sign.setOnCheckedChangeListener { radioGroup, checkedId ->
            when (checkedId) {
                R.id.rb_login -> {
                    navController?.navigate(R.id.destination_login)
//                    navGraph?.setStartDestination( R.id.destination_login)
//                    navController?.graph = navGraph!!
                    tv_title.text = getText(R.string.sign_in)
                }
                R.id.rb_register -> {
                    navController?.navigate(R.id.destination_register)
//                    navGraph?.setStartDestination( R.id.destination_register)
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


}
