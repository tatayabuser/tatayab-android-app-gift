package com.tatayab.tatayab.profile

import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.tatayab.model.requests.ChangePasswordRequest
import com.tatayab.presentation.profile.ProfileFragmentViewModel
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_change_password.*
import kotlinx.android.synthetic.main.fragment_change_password.input_password
import kotlinx.android.synthetic.main.fragment_change_password.pass_control
import javax.inject.Inject


class ChangePasswordFragment : BaseFragment() {


    @Inject
    lateinit var viewModel: ProfileFragmentViewModel
    private var passHidden = true
    private var newPassHidden = true


    override fun layoutId(): Int {
        return R.layout.fragment_change_password
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(requireActivity(), viewModelFactory)
            .get(ProfileFragmentViewModel::class.java)

        viewModel.getChangePasswordLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                    if (it.throwable?.message != null)
                        showCustomTopMessage(it.throwable?.message!!, DialogUtil.MessageType.ERROR)
                    else
                        showCustomTopMessage(
                            getText(R.string.error_occure).toString(),
                            DialogUtil.MessageType.ERROR
                        )
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    if (it.data?.status == 1) {
                        it.data?.userProfile?.user_id.let { userId ->
                            hideKeyboard()
                            showCustomTopMessage(
                                getString(R.string.edit_success),
                                DialogUtil.MessageType.SUCCESS
                            )
                        }
                        findNavController().popBackStack()
                    } else
                        showCustomTopMessage(
                            it.data?.msg.toString(),
                            DialogUtil.MessageType.ERROR
                        )
                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        btn_change.setSafeOnClickListener {
            if (validatePasswordInputs())
                viewModel.changePassword(
                    ChangePasswordRequest(
                        old_password = input_password.text.toString(),
                        new_password = input_new_password.text.toString()
                    )
                )
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

        new_pass_control.setSafeOnClickListener {
            if (newPassHidden) {
                input_new_password.transformationMethod = null
                new_pass_control.setImageResource(R.drawable.show_password)
                newPassHidden = false
            } else {
                input_new_password.transformationMethod = PasswordTransformationMethod()
                new_pass_control.setImageResource(R.drawable.hide_password)
                newPassHidden = true
            }
        }

    }

    private fun validatePasswordInputs(): Boolean {
        return if (input_password.text.toString().isNotEmpty()) {
            if (input_new_password.text.toString().isNotEmpty())
                true
            else {
                input_new_password.error = getText(R.string.filed_required)
                false
            }
        } else {
            input_password.error = getText(R.string.filed_required)
            false
        }
    }

}
