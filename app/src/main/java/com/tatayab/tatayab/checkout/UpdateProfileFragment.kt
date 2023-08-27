package com.tatayab.tatayab.checkout

import android.os.Bundle
import android.view.View
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_update_profile.*

class UpdateProfileFragment() : BaseFragment() {

    override fun layoutId(): Int {
        return R.layout.fragment_update_profile
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btn_complete.setSafeOnClickListener {
            val email = input_email.text.toString()
            if (email.isEmpty()) {
                showCustomTopMessage(getString(R.string.please_enter_valid_email), DialogUtil.MessageType.ERROR)
            } else {
                val bundle = Bundle()
                bundle.putBoolean(Constants.UPDATE_PROFILE, true)
                bundle.putString(Constants.USER_EMAIL, email)
                (activity as MainActivity).navigateBackWithResult(bundle)
            }
        }
    }

}