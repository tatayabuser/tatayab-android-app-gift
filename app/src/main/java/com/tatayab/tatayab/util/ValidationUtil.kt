package com.tatayab.tatayab.util

import android.content.Context
import android.text.TextUtils
import android.widget.EditText
import com.google.android.material.textfield.TextInputEditText

object ValidationUtil {


    @JvmStatic
    fun isValid(input: String): Boolean {
        var valid = true
        if (input.trim().isEmpty()) {
            valid = false
        }
        return valid;
    }

    @JvmStatic
    fun isValid(input: TextInputEditText): Boolean {
        var valid = true
        if (input.text.toString().trim().isEmpty()) {
            valid = false
        }
        return valid;
    }

    @JvmStatic
    fun emptyValidation(context: Context?, editText: TextInputEditText, message: Int): Boolean {
        return if (editText.text.toString().trim { it <= ' ' }.isEmpty()) {
            editText.error = context?.getString(message)
            false
        } else {
            editText.error = null
            true
        }
    }


    @JvmStatic
    fun isValidEmail(email: String,context: Context?,editText: TextInputEditText,message: Int): Boolean {

        val isValid= !TextUtils.isEmpty(email) && android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        return if(!isValid){
            editText.error = context?.getString(message)
            false
        }else{
            true
        }

    }
}