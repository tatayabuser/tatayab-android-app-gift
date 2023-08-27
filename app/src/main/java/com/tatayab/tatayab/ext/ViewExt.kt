@file:JvmName("ViewExt")

package com.tatayab.tatayab.ext

import android.app.Activity
import android.content.Context
import android.graphics.drawable.Drawable
import android.text.TextUtils
import android.view.View
import android.view.animation.AnimationUtils
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.constraintlayout.widget.Group
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.tatayab.tatayab.R
import com.tatayab.tatayab.util.SafeClickListener
import com.tatayab.tatayab.util.TatayabAnimationListener

fun View.setSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    setOnClickListener(safeClickListener)
}


fun Group.setAllSafeOnClickListener(onSafeClick: (View) -> Unit) {
    val safeClickListener = SafeClickListener {
        onSafeClick(it)
    }
    referencedIds.forEach { id ->
        rootView?.findViewById<View>(id)?.setOnClickListener(safeClickListener)
    }
}


fun Fragment.hideKeyboard() {
    view?.let { activity?.hideKeyboard(it) }
}


fun EditText.isValid(input: String): Boolean {
    val data = this.text.trim().toString()
    return if (data.length < 3) {
        this.error = input
        false
    } else
        true
}

fun EditText.isValidEmpty(input: String): Boolean {
    val data = this.text.trim().toString()
    return if (data.isNullOrBlank()) {
        this.error = input
        false
    } else
        true
}

fun EditText.isValid(context: Context): Boolean {
    val data = this.text.trim().toString()
    return when {
        data.isNullOrBlank() -> {
            this.error = context.getText(R.string.filed_required)
            false
        }
        data.length < 3 -> {
            this.error = context.getText(R.string.invalid_input)
            false
        }
        else -> true
    }
}


fun EditText.isValidFullName(): Boolean {
    val data = this.text.trim().toString()
    var isValid = false
    if (data != "")
        isValid = !TextUtils.isEmpty(data) && data.isEmpty()
    return if (!isValid) {
        if (data == "")
            this.error = context.getText(R.string.filed_required)
        else
            this.error = context.getText(R.string.please_enter_fullname)
        false
    } else {
        true
    }

}

fun EditText.isValidEmail(): Boolean {
    val data = this.text.trim().toString()
    var isValid = false
    if (data != "")
        isValid =
            !TextUtils.isEmpty(data) && android.util.Patterns.EMAIL_ADDRESS.matcher(data).matches()
    return if (!isValid) {
        if (data == "")
            this.error = context.getText(R.string.filed_required)
        else
            this.error = context.getText(R.string.wrong_email)
        false
    } else {
        true
    }

}

fun EditText.isPhoneValid(input: String): Boolean {
    val data = this.text.trim().toString()
    data.map {
        if (!it.isDigit()) {
            return false
        }
    }
    if (data.length < 6) {
        this.error = input
        return false
    } else
        return true
}

fun Activity.hideKeyboard() {
    hideKeyboard(currentFocus ?: View(this))
}

fun Context.hideKeyboard(view: View) {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.hideSoftInputFromWindow(view.windowToken, 0)
}


fun Context.showKeyboard() {
    val inputMethodManager = getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, 0)
}

/**
 * Transforms static java function Snackbar.make() to an extension function on View.
 */
fun View.showSnackbar(snackbarText: String, timeLength: Int) {
    Snackbar.make(this, snackbarText, timeLength).show()
}

fun View.showSnackbarWithAction(
    snackbarText: String,
    actionString: String,
    timeLength: Int,
    onActionClick: (View) -> Unit
) {
    Snackbar.make(this, snackbarText, timeLength)
        .setAction(actionString, onActionClick)
        .show()
}

fun ImageView.changeImageWithAnimationOut(context: Context, imgResource: Int) {
    val animOut = AnimationUtils.loadAnimation(context, R.anim.fade_out)
    animOut.setAnimationListener(TatayabAnimationListener(this, imgResource))
    this.startAnimation(animOut)
}

fun ImageView.changeImageWithAnimationIn(context: Context, imgResource: Int) {
    val animIn = AnimationUtils.loadAnimation(context, R.anim.fade_in)
    animIn.setAnimationListener(TatayabAnimationListener(this, imgResource))
    this.startAnimation(animIn)
}

fun TextView.setDrawables(
    start: Drawable? = null,
    top: Drawable? = null,
    end: Drawable? = null,
    bottom: Drawable? = null
) = setCompoundDrawablesRelativeWithIntrinsicBounds(start, top, end, bottom)

var TextView.drawableStart: Drawable?
    get() = null
    set(value) = setDrawables(start = value)

/**
 * Extension method to get the TAG name for all object
 */
fun <T : Any> T.TAG() = this::class.simpleName

