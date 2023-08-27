package com.tatayab.tatayab.util

import android.text.Spannable
import android.text.SpannableString
import android.text.SpannableStringBuilder
import android.text.style.RelativeSizeSpan
import android.text.style.SuperscriptSpan
import java.util.regex.Pattern


object TextUtil {

    @JvmStatic
    fun formatString(price: String, currency: String): SpannableStringBuilder {
        val ssb = SpannableStringBuilder(price)
        val ssCurrency = SpannableString(currency)
        ssCurrency.setSpan(SuperscriptSpan(), 0, currency.length, 0)
        ssCurrency.setSpan(RelativeSizeSpan(.7f), 0, currency.length, 0)
        ssb.append(ssCurrency)
        return ssb
    }


    @JvmStatic
    fun splitTitle(originalTitle: String?): List<String>? {
        return originalTitle?.trim()?.split("///")?.map { it.trim() }
    }


    @JvmStatic
    fun validPassword(password: String?): Boolean {
        return password?.length!!>=6 && password.length<20 && !password.contains(" ")
    }

    @JvmStatic
    fun validName(name: String?): Boolean {
        name?.map {
            if (!it.isLetter()) {
                return false
            }
        }
        return  true
    }

}