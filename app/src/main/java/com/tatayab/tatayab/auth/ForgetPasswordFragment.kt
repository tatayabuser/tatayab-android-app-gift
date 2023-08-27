package com.tatayab.tatayab.auth

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tatayab.presentation.auth.UserLoginViewModel
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_forget_password.*


class ForgetPasswordFragment : BaseFragment() {

    private lateinit var viewModel: UserLoginViewModel


    override fun layoutId(): Int = R.layout.fragment_forget_password


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()
    }

    private fun initComponent() {
        btn_reset_password.setSafeOnClickListener {
            viewModel.forgetPassword(
                input_email.text.toString(),
                App.getPref().currentLanguage.toString()
            )
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(this, viewModelFactory).get(UserLoginViewModel::class.java)
        } ?: throw Exception("Invalid Activity")
        viewModel?.ENABLE_GRAPH_QUERIES_CALLS = Constants.ENABLE_GRAPH_QUERIES_CALLS
        viewModel.getForgetPasswordLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                    if(it?.data?.msg.isNullOrBlank()) {
                        showCustomTopMessage(
                            getString(R.string.error_occure),
                            DialogUtil.MessageType.ERROR
                        )
                    }else{
                        showCustomTopMessage(
                            it?.data?.msg.toString(),
                            DialogUtil.MessageType.ERROR
                        )
                    }
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    if (it?.data?.success == 1) {
                        showCustomTopMessage(
                            getString(R.string.reset_password_message),
                            DialogUtil.MessageType.SUCCESS
                        )
                    }else{
                        if(it?.data?.msg.isNullOrBlank()) {
                            showCustomTopMessage(
                                getString(R.string.error_occure),
                                DialogUtil.MessageType.ERROR
                            )
                        }else{
                            showCustomTopMessage(
                               it?.data?.msg.toString(),
                                DialogUtil.MessageType.ERROR
                            )
                        }
                    }
                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })
    }


    override fun onDestroy() {
        super.onDestroy()
        (activity as LoginActivity).afterReturnForgetPass()  // change title to signin and make tab as visible
    }
}
