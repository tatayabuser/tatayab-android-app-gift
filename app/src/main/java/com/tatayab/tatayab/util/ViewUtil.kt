package com.tatayab.tatayab.util

import android.content.Context
import android.content.res.Resources
import android.text.Selection
import android.text.Spannable
import android.text.SpannableString
import android.text.Spanned
import android.text.method.LinkMovementMethod
import android.text.style.ClickableSpan
import android.util.TypedValue
import android.view.View
import android.view.animation.CycleInterpolator
import android.view.animation.TranslateAnimation
import android.widget.TextView
import androidx.annotation.NonNull


object ViewUtil {


    @JvmStatic
    fun shakeError(): TranslateAnimation {
        val shake = TranslateAnimation(0f, 10f, 0f, 0f)
        shake.duration = 700
        shake.interpolator = CycleInterpolator(7f)
        return shake
    }

    fun getScreenWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    @SafeVarargs
    @JvmStatic
    fun addLinksClickEvent(
        text: String,
        textView: TextView,
        vararg links: Pair<String, View.OnClickListener>
    ) {
        val spannableString = SpannableString(text)
        for ((textString, clickListener) in links) {
            val clickableSpan: ClickableSpan = object : ClickableSpan() {
                override fun onClick(@NonNull view: View) {
                    Selection.setSelection(
                        (view as TextView).text as Spannable,
                        0
                    )
                    view.invalidate()
                    clickListener.onClick(view)
                }
            }
            val startIndexOfLink = text.indexOf(textString)
            spannableString.setSpan(
                clickableSpan, startIndexOfLink, startIndexOfLink + textString.length,
                Spanned.SPAN_EXCLUSIVE_EXCLUSIVE
            )
        }
        textView.movementMethod = LinkMovementMethod.getInstance()
        textView.setText(spannableString, TextView.BufferType.SPANNABLE)
    }

    @JvmStatic
    fun convertDip2Pixels(context: Context, dip: Int): Int {
        return TypedValue.applyDimension(
            TypedValue.COMPLEX_UNIT_DIP,
            dip.toFloat(),
            context.resources.displayMetrics
        ).toInt()
    }
}