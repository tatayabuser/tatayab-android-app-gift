package com.tatayab.tatayab.util


import android.text.format.DateFormat
import java.util.*


object DateUtil {

    @JvmStatic
    fun formatDateFromString(timeStamp: String, lang: String): String {
        val cal = Calendar.getInstance(Locale(lang))
        cal.timeInMillis = timeStamp.toLong() * 1000

        return DateFormat.format("dd/MM/yyyy, hh:mm a", cal).toString()
    }
}