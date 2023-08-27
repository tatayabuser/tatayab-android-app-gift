package com.tatayab.tatayab.profile

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.tatayab.model.requests.ProfileActionRequest
import com.tatayab.model.responses.UserProfile
import com.tatayab.presentation.profile.ProfileFragmentViewModel
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_edit_profile.*
import javax.inject.Inject


class EditProfileFragment : BaseFragment() {


    @Inject
    lateinit var viewModel: ProfileFragmentViewModel

    override fun layoutId(): Int {
        return R.layout.fragment_edit_profile
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(ProfileFragmentViewModel::class.java)

        viewModel.getEditProfileLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                    showCustomTopMessage(
                        getText(R.string.error_occure).toString(),
                        DialogUtil.MessageType.ERROR
                    )
                }
                ResourceState.SUCCESS -> {
                    if (it.data?.status == 1) {
                        it.data?.userProfile.let {
                            setProgress(View.GONE)
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
                            DialogUtil.MessageType.SUCCESS
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

        viewModel.getUserProfileLiveData.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                    showCustomTopMessage(
                        getText(R.string.error_occure).toString(),
                        DialogUtil.MessageType.ERROR
                    )
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    if (it.data?.status == 1) {
                        setupViews(it.data?.userProfile)
                    }
                    else
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

        change_password.setSafeOnClickListener {
            val action = EditProfileFragmentDirections.actionChangePassword()
            findNavController().navigate(action)
        }

        btn_save.setSafeOnClickListener {
            if (validaInputs()) {
                val editProfile = ProfileActionRequest(
                    fullname = input_fullname.text.toString(),
                    gender = getGender()
                )
                viewModel.editUserProfile(editProfile)
            }
        }
    }

    private fun getGender(): String {
        return when {
            rb_male.isChecked -> "male"
            rb_female.isChecked -> "female"
            else -> ""
        }
    }

    private fun validaInputs(): Boolean {
        if (input_fullname.text.toString().isEmpty()) {
            input_fullname.error = getText(R.string.filed_required)
            return false
        }
        return true
    }

    private fun setupViews(profile: UserProfile?) {
        input_fullname.setText(profile?.firstName.plus(" ").plus(profile?.lastName))
        phone_code.text = profile?.phone_country_code
        input_phone.text = profile?.phone
        input_email.setText(profile?.email)
        if (profile?.gender.equals("Male", true))
            rb_male.isChecked = true
        else if (profile?.gender.equals("Female", true))
            rb_female.isChecked = true
    }
}
