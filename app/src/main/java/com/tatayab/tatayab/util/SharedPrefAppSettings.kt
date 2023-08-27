package com.tatayab.tatayab.util

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.preference.PreferenceManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentActivity
import com.squareup.inject.assisted.AssistedInject
import java.util.*
import javax.inject.Inject

class SharedPrefAppSettings @Inject constructor(
    val context: Context
) : AppSettings {

    var sharedPref: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(context)
    var androidConfiguration: Configuration = context.resources.configuration

    private var currentLanguageCache: Language? = null
    private var firstUserTokenCache: String? = null

    override var currentLanguage: Language
        get() {
            val cachedValue = currentLanguageCache

            return if (cachedValue == null) {
                val storedValue = sharedPref.getString(APP_LANGUAGE_KEY, null)
                val storedLanguage = try {
                    Language.getLocale(storedValue)
                } catch (ex: Exception) {
                    null
                }

                val language = storedLanguage ?: getDefaultLanguage()

                currentLanguage = language

                language
            } else cachedValue
        }
        set(value) {
            currentLanguageCache = value
            sharedPref.edit().putString(APP_LANGUAGE_KEY, value.toString()).commit()
        }
    override var firstUserToken: String
        get() {
            val cachedValue = firstUserTokenCache

            return if (cachedValue == null) {
                val storedValue = sharedPref.getString(FIRST_UER_TOKEN_KEY, null)
                val storedFirstUserToken = try {
                    storedValue
                } catch (ex: Exception) {
                    null
                }

                val firstToken = storedFirstUserToken ?: ""

                firstUserToken = firstToken

                firstUserToken
            } else cachedValue
        }
        set(value) {
            firstUserTokenCache = value
            sharedPref.edit().putString(FIRST_UER_TOKEN_KEY, value).commit()
        }

    private fun getDefaultLanguage(): Language {
        val locale = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            androidConfiguration.locales[0]
        } else {
            androidConfiguration.locale
        }
        return Language.fromLocale(locale)
    }
    /*fun getDefaultLanguage(): String? {
        return this.systemLocale.getLanguage()
    }*/

    companion object {
        private const val FIRST_UER_TOKEN_KEY = "FIRST_UER_TOKEN_KEY"
        private const val APP_LANGUAGE_KEY = "app_language"
        private const val LOCAL_LANG_AR = "ar"
        private const val LOCAL_LANG_EN = "en"
    }


    fun validateLanguage() {
        val savedLanguage: String = currentLanguage.toString()
        if (getCurrentLanguage() != savedLanguage) {
            setCurrentLanguage(savedLanguage)
        }
    }

    fun toggleLanguage() {
        if (isArabic()) {
            currentLanguage = Language.English
            setCurrentLanguage(LOCAL_LANG_EN)
        } else {
            currentLanguage = Language.Arabic
            setCurrentLanguage(LOCAL_LANG_AR)
        }
    }

    fun restartApp(activityToBeRestarted: FragmentActivity){
        try {
            Handler(Looper.getMainLooper()).postDelayed(
                {
                    val intent = activityToBeRestarted.intent
                    activityToBeRestarted.finish()
                    activityToBeRestarted.startActivity(intent)
                },
                5000 // value in milliseconds
            )
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }

    fun changeLanguage(activityToBeRestarted: FragmentActivity,selectedLang:String) {
        if (selectedLang.equals(LOCAL_LANG_EN,false)) {
            currentLanguage = Language.English
            setCurrentLanguage(LOCAL_LANG_EN)
        } else {
            currentLanguage = Language.Arabic
            setCurrentLanguage(LOCAL_LANG_AR)
        }
        val intent = activityToBeRestarted.intent
        activityToBeRestarted.finish()
        activityToBeRestarted.startActivity(intent)
    }

    fun isArabic(): Boolean {
        return currentLanguage.toString() == LOCAL_LANG_AR
    }

    private fun getCurrentLanguage(): String {
        val res: Resources = this.context.resources
        val conf = res.configuration
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            conf.locales[0].language
        } else {
            conf.locale.language
        }
    }

   private fun setCurrentLanguage(language: String) {
        val resources: Resources = this.context.resources
        val displayMetrics = resources.displayMetrics
        val configuration = resources.configuration
        configuration.setLocale(Locale(language, "US"))
        resources.updateConfiguration(configuration, displayMetrics)
    }


}
