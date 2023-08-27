package com.tatayab.tatayab.utils

import android.content.Context

object Constants {

    const val MyPREFERENCES = "PREF2"


    fun getCityID(context: Context): String? {
        val prefs = context.getSharedPreferences(
            MyPREFERENCES,
            Context.MODE_PRIVATE
        )
        return prefs.getString("cityId", "0")
    }

    fun updateCityId(cityId: String, context: Context) {
        val editor = context.getSharedPreferences(
            MyPREFERENCES,
            Context.MODE_PRIVATE
        ).edit()
        editor.putString("cityId", cityId)
        editor.apply()
    }

    fun getCityCode(context: Context): String? {
        val prefs = context.getSharedPreferences(
            MyPREFERENCES,
            Context.MODE_PRIVATE
        )
        return prefs.getString("CityCode", "0")
    }

    fun updateCityCode(CityCode: String, context: Context) {
        val editor = context.getSharedPreferences(
            MyPREFERENCES,
            Context.MODE_PRIVATE
        ).edit()
        editor.putString("CityCode", CityCode)
        editor.apply()
    }
}