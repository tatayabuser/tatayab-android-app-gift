package com.tatayab.tatayab.base

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.res.Configuration
import android.os.Build
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.inappmessaging.FirebaseInAppMessaging
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.errorHandling.ErrorHandlingAct
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.firebase.InAppMessageListener
import com.tatayab.tatayab.firebase.NotificationHandler
import com.tatayab.tatayab.injection.ViewModelFactory
import com.tatayab.tatayab.util.*
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.fragment_login.progress
import kotlinx.android.synthetic.main.notification_deep_link_dialog.*
import java.util.*
import javax.inject.Inject
import com.adjust.sdk.Adjust


@SuppressLint("Registered")
open class BaseActivity @Inject constructor() : AppCompatActivity(),
    NotificationHandler.NotificationListener {
    private var dataBundle: Bundle? = null

    @Inject
    lateinit var viewModelFactory: ViewModelFactory


    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        }
        NotificationHandler.mNotificationListener = this
        //Add InAppMessaging listener
        var inAppMessageClick = InAppMessageListener(this)
        FirebaseInAppMessaging.getInstance().setMessageDisplayComponent(inAppMessageClick)
        FirebaseInAppMessaging.getInstance().addClickListener(inAppMessageClick)
        FirebaseInAppMessaging.getInstance().addImpressionListener(inAppMessageClick)
        super.onCreate(savedInstanceState)
    }

    override fun setContentView(layoutResID: Int) {
        super.setContentView(R.layout.activity_base)
        val mainContainerFrameLayout = findViewById<FrameLayout>(R.id.mainContainer)
        LayoutInflater.from(this).inflate(layoutResID, mainContainerFrameLayout, true)
        initNotificationDialog()

    }

    private fun initNotificationDialog() {
        runOnUiThread {
            hideDialogButton.setSafeOnClickListener {
                notificationContainer.visibility = View.GONE
            }
            showNotificationButton.setSafeOnClickListener {
                notificationContainer.visibility = View.GONE
                handelNotificationDeepLink()
            }
        }
    }

    private fun handelNotificationDeepLink() {
        if (dataBundle != null && !dataBundle!!.isEmpty) {
            val bundle = dataBundle
            if (bundle != null) {
                openMainActivityDeepLink(bundle)
            }

        }
    }

    private fun openMainActivityDeepLink(bundle: Bundle) {
        val intent = Intent(this, MainActivity::class.java)
        intent.putExtras(bundle)
        startActivity(intent)

    }

    override fun attachBaseContext(newBase: Context) {
        var newBase = newBase
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val config: Configuration = newBase.resources.configuration
            val locale = Locale(getCurrentLang())
            Locale.setDefault(locale)
            config.setLocale(locale)
            newBase = newBase.createConfigurationContext(config)
        }
        super.attachBaseContext(newBase)
    }

    private fun getCurrentLang(): String {
        return App.getPref().currentLanguage.toString()//getCurrentLocale()
    }

    protected fun progressStatus(viewStatus: Int) =
        with(this) { this.progress?.visibility = viewStatus }

    protected fun showErrorDialog(view: View, message: String) {
        try {
            val intent = Intent(this, ErrorHandlingAct::class.java)
            intent.putExtra(ErrorHandlingAct.MESSAGE_HOLDER, message)
            startActivity(intent)
        } catch (e: Exception) {
            println("Error in showErrorDialog : " + e.message)
        }
    }

    protected fun showCustomTopMessage(message: String, mMessageType: DialogUtil.MessageType) {
        DialogUtil().showCustomDialog(this, true, message, mMessageType)
    }

    protected fun showCustomSuccessDialog(message: String, mMessageType: DialogUtil.MessageType) {
        DialogUtil().showCustomSuccessDialog(this, true, message, mMessageType)
    }

    override fun showNotificationDialog(title: String, message: String, dataBundle: Bundle) {
        runOnUiThread {
            notificationContainer.visibility = View.VISIBLE
            AnimationUtil.springAnimateAddToCart(notificationContainer)
            SoundUtil.getInstance(this).playNotificationSound()
            this.dataBundle = dataBundle
            notificationTitleTextView.text = title
            notificationDescTextView.text = message
        }
    }

    @SuppressLint("HardwareIds")
    fun getUniqueDeviceID(): String {
        println(
            ".....act1/getUniqueDeviceID() :  " + Settings.Secure.getString(
                contentResolver,
                Settings.Secure.ANDROID_ID
            )
        )
        return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
    }

    override fun onResume() {
        super.onResume()
        Adjust.onResume()
    }

    override fun onPause() {
        super.onPause()
        Adjust.onPause()
    }
    fun isInteger(str: String?) = str?.toIntOrNull()?.let { true } ?: false

}