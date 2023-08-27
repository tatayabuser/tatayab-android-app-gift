package com.tatayab.tatayab.util

import android.app.Activity
import android.util.Log
import androidx.lifecycle.LiveData
import com.google.android.gms.tasks.OnCompleteListener
import com.google.common.reflect.TypeToken
import com.google.firebase.remoteconfig.FirebaseRemoteConfig
import com.google.firebase.remoteconfig.FirebaseRemoteConfigSettings
import com.google.gson.Gson
import com.tatayab.model.responses.ContactNumberPerCountryModel
import com.tatayab.model.responses.TabbyCountryModel
import com.tatayab.presentation.SingleLiveEvent
import java.lang.reflect.Type
import java.util.*
import kotlin.collections.ArrayList


class FirebaseConfigUtil {

    companion object {
        var whatsAppContacts: String = "+96599991181/+96592222982"
        val WHATSAPP_NUMBERS_KEY = "whatsapp_numbers"
        val TABBY_AVAILABLE_COUNTRIES_KEY = "tabby_available_countries"
        val CONTACT_US_PHONE_NUMBERS_KEY = "contactUsPhoneNumbers"
        val CONCIERGE_KEY = "concierge_status"
        val RATE_APP_FROM_SUCCESS_SCREEN_KEY = "rate_app_from_success_screen"
        val share_cart_enabled_android_KEY = "share_cart_enabled_android"
        var CONCIERGE_VALUE = false
        var SHARE_CART_ENABLED = false
        var RATE_APP_FROM_SUCCESS_SCREEN_VALUE = true
        var ENABLE_GRAPH_QUERIES_KEY = "is_call_qraphQl_APIs_Android"
        var ENABLE_GRAPH_QUERIES_KEY_DUMMY = "AKL_is_call_qraphQl_APIs_Android"
        var tabbyCountriesList = ArrayList<TabbyCountryModel>()
        var mContactNumberPerCountryList = ArrayList<ContactNumberPerCountryModel>()
    }

    private var mFirebaseConfigListener: FirebaseConfigListener? = null

    open fun setListener(firebaseConfigListener: FirebaseConfigListener) {
        this.mFirebaseConfigListener = firebaseConfigListener
    }

    val conciergeLiveData = SingleLiveEvent<Boolean>()
    val getConciergeLiveData: LiveData<Boolean>
        get() = conciergeLiveData

    fun syncWithFirebaseCofig(activity: Activity) {
        try {
            var mFirebaseRemoteConfig: FirebaseRemoteConfig = FirebaseRemoteConfig.getInstance()
            val configSettings = FirebaseRemoteConfigSettings.Builder()
                .setMinimumFetchIntervalInSeconds(0)
                .build()
            mFirebaseRemoteConfig.setConfigSettingsAsync(configSettings)
            mFirebaseRemoteConfig.fetchAndActivate()
                .addOnCompleteListener(activity,
                    OnCompleteListener<Boolean> { task ->
                        if (task.isSuccessful) {
                            val updated = task.result!!
                            Log.d("Config params updated", updated.toString())
                        } else {
                            Log.d("Config params", "Fetch failed")

                        }
                        whatsAppContacts = mFirebaseRemoteConfig.getString(WHATSAPP_NUMBERS_KEY)
                        CONCIERGE_VALUE = mFirebaseRemoteConfig.getBoolean(CONCIERGE_KEY)
                        var ENABLE_GRAPH_QUERIES = mFirebaseRemoteConfig.getBoolean(ENABLE_GRAPH_QUERIES_KEY)
                        SHARE_CART_ENABLED =
                            mFirebaseRemoteConfig.getBoolean(share_cart_enabled_android_KEY)
                        RATE_APP_FROM_SUCCESS_SCREEN_VALUE =
                            mFirebaseRemoteConfig.getBoolean(RATE_APP_FROM_SUCCESS_SCREEN_KEY)
                        conciergeLiveData.value = CONCIERGE_VALUE
                        var tabbyCountriesListText =
                            mFirebaseRemoteConfig.getString(TABBY_AVAILABLE_COUNTRIES_KEY)
                        convertStringToCountriesList(tabbyCountriesListText)
                        var mContactNumberPerCountryList =
                            mFirebaseRemoteConfig.getString(CONTACT_US_PHONE_NUMBERS_KEY)
                        convertStringToContactNumbersList(mContactNumberPerCountryList)

                        if (ENABLE_GRAPH_QUERIES != null) mFirebaseConfigListener?.updateEnableGraphQlValue(true)
                        Log.d("Config/whatsAppContacts", whatsAppContacts)
                        Log.d("Config/SHARE_CART", SHARE_CART_ENABLED.toString())
                        Log.d("Config/tabbyCountries", tabbyCountriesListText)
                        Log.d("Config/CONCIERGE_VALUE", CONCIERGE_VALUE.toString())
                        Log.d("Config/ContactUsList", mContactNumberPerCountryList)
                        Log.d("Config/GRAPH_QL", ENABLE_GRAPH_QUERIES.toString())
                    })
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

    }

    private fun convertStringToCountriesList(tabbyCountriesListText: String) {
        try {
            if (!tabbyCountriesListText.isNullOrEmpty()) {
                val gson = Gson()
                val type: Type =
                    object : TypeToken<List<TabbyCountryModel?>?>() {}.getType()
                tabbyCountriesList = gson.fromJson(tabbyCountriesListText, type)
                for (tabbyCountry in tabbyCountriesList) {
                    println("Config/tabbyCountry: " + tabbyCountry.country)
                    for (content in tabbyCountry?.content!!) {
                        println("Config/title ar: " + content.title_ar)
                        println("Config/title ar: " + content.title_ar)
                        println("Config/sub title ar: " + content.subTitle_ar)
                        println("Config/sub title en: " + content.subTitle_en)
                        println("Config/image: " + content.image)
                        println("Config/numberOfPayments: " + content?.numberOfPayments)
                    }
                }
            }
        } catch (err: Exception) {
            println("Config/error: " + err.toString())
        }
    }

    private fun convertStringToContactNumbersList(contactNumbersList: String) {
        try {
            if (!contactNumbersList.isNullOrEmpty()) {
                val gson = Gson()
                val type: Type =
                    object : TypeToken<List<ContactNumberPerCountryModel?>?>() {}.getType()
                mContactNumberPerCountryList = gson.fromJson(contactNumbersList, type)
                for (tabbyCountry in mContactNumberPerCountryList) {
                    println("Config/tabbyCountry: " + tabbyCountry.country)
                    for (content in tabbyCountry?.phoneNumbers!!) {
                        content.map {
                            println("Config/contact unmber : " + it)
                        }
                    }
                }
            }
        } catch (err: Exception) {
            println("Config/error: " + err.toString())
        }
    }

    fun getRandomWhatsAppNumber(): String {
        if (!whatsAppContacts.isNullOrEmpty()) {
            val numberList =
                whatsAppContacts.replace(" ", "").split("/")
                    .toTypedArray()
            if (numberList.size > 0) {
                if (numberList.size == 1) {

                    return numberList[0]
                } else {
                    val randomIndex = Random().nextInt(numberList.size)
                    if (randomIndex >= 0 && randomIndex < numberList.size)
                        return numberList[randomIndex]
                    else {
                        getRandomWhatsAppNumber()
                    }
                }
            }
        }

        return ""
    }
}