package com.tatayab.tatayab.util

import android.R.attr.bitmap
import android.graphics.Bitmap
import android.graphics.Bitmap.CompressFormat
import android.util.Base64
import com.tatayab.tatayab.R
import java.io.ByteArrayOutputStream


object ImageUtil {


    @JvmStatic
    fun getBase64FromBitmab(bitmap: Bitmap): String {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        val byteArray = outputStream.toByteArray()

        val encodedString = Base64.encodeToString(byteArray, Base64.DEFAULT)
        return encodedString

    }

    fun convertBitMapToBase64(bitmap: Bitmap): ByteArray? {
        try {
            val byteArrayOutputStream =
                ByteArrayOutputStream()
            bitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream)
            val byteArray = byteArrayOutputStream.toByteArray()
            return byteArray
        }catch (e:Exception){
            e.printStackTrace()
        }
        return null
    }
    @JvmStatic
    fun getCountryFlagByID(code: String?): Int {


        when (code) {
            "KW" -> {
                return R.drawable.ic_kuwait
            }
            "SA" -> {
                return R.drawable.saudi_arabia
            }
            "QA" -> {
                return R.drawable.ic_qatar
            }
            "BH" -> {
                return R.drawable.flag_bh
            }
            "OM" -> {
                return R.drawable.flag_om
            }
            "AE" -> {
                return R.drawable.flag_ae
            }
        }
        return R.drawable.ic_country_logo
    }
}