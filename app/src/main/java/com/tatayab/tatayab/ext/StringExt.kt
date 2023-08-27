package com.tatayab.tatayab.ext

import android.content.Context
import android.content.res.Resources
import androidx.annotation.PluralsRes
import androidx.annotation.StringRes
import androidx.fragment.app.Fragment
import java.util.*

fun CharSequence.splitIgnoreEmpty(vararg delimiters: String): List<String> {
    return this.split(*delimiters).filter {
        it.isNotEmpty()
    }
}

fun Resources.formatString(resId: Int, vararg args: Any?)
        = String.format(Locale.US, this.getString(resId), *args)

@Throws(Resources.NotFoundException::class)
fun Resources.getQuantityStringWithLocale(@PluralsRes id:Int, quantity:Int, vararg formatArgs:Any?):String
{
    val raw = getQuantityText(id, quantity).toString();
    return String.format(Locale.US, raw, *formatArgs)
}

@Throws(Resources.NotFoundException::class)
fun Context.getStringLocale(@StringRes id:Int, vararg formatArgs:Any?):String
{
    val raw = getString(id)
    return String.format(Locale.US, raw, * formatArgs)
}

@Throws(Resources.NotFoundException::class)
fun Fragment.getStringLocale(@StringRes id:Int, vararg formatArgs:Any?):String
{
    val raw = getString(id)
    return String.format(Locale.US, raw, *formatArgs)
}
