package com.tatayab.tatayab.errorHandling

import android.app.Activity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
 import com.tatayab.tatayab.R
 import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.AnimationUtil
import kotlinx.android.synthetic.main.activity_error_handling.*

class ErrorHandlingAct : Activity() {

    companion object {
        val MESSAGE_HOLDER = "MESSAGE_HOLDER"
    }
    var message: String? = null


    override fun onCreate(savedInstanceState: Bundle?) {
         super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error_handling)

        if (intent != null && intent.extras != null) {
            if (intent.extras!!.containsKey(MESSAGE_HOLDER)) {
                this.message = intent.extras!!.getString(MESSAGE_HOLDER)
            }
        }

        initView()
        dismissButton.setSafeOnClickListener {
             finish()
        }
    }

    private fun initView() {
        if (!TextUtils.isEmpty(message))
            errorMessageTextView.text = message

        errorLayout.visibility = View.VISIBLE
        AnimationUtil.showErrorDialogAnimation(errorLayout)

    }




    override fun onBackPressed() {
    }
}