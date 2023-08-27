package com.tatayab.tatayab

import android.app.Activity
import android.app.Application
import android.content.Context
import android.content.res.Configuration
import android.util.Log
import com.smartlook.sdk.smartlook.Smartlook
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.multidex.MultiDex
import androidx.multidex.MultiDexApplication
import com.facebook.FacebookSdk
import com.facebook.stetho.Stetho
import com.google.android.gms.security.ProviderInstaller
import com.tatayab.tatayab.injection.ApplicationComponent
import com.tatayab.tatayab.injection.DaggerApplicationComponent
import com.tatayab.tatayab.util.SharedPrefAppSettings
import com.twitter.sdk.android.core.DefaultLogger
import com.twitter.sdk.android.core.Twitter
import com.twitter.sdk.android.core.TwitterAuthConfig
import com.twitter.sdk.android.core.TwitterConfig
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject
import android.os.Build.VERSION.SDK_INT
import android.os.Bundle
import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustConfig
import com.adjust.sdk.LogLevel
import com.tatayab.presentation.Utils.Companion.DEEP_LINK_URI
import com.tatayab.remote.util.InternetConnectionListener
import com.tatayab.tatayab.adjust_tracking.AdjustAttributionModel
import com.tatayab.tatayab.adjust_tracking.AdjustTracker
 import timber.log.Timber
  import javax.net.ssl.SSLContext
import com.useinsider.insider.Insider

class App : MultiDexApplication(), HasActivityInjector, HasSupportFragmentInjector {

    val component: ApplicationComponent by lazy {
        DaggerApplicationComponent.builder()
            .application(this)
            .build()
    }

    companion object {
        private lateinit var prefAppSettings: SharedPrefAppSettings
        fun init(settings: SharedPrefAppSettings) {
            if (!Companion::prefAppSettings.isInitialized)
                prefAppSettings = settings
        }

        fun getPref(): SharedPrefAppSettings {
            return prefAppSettings
        }
    }

    @Inject
    lateinit var androidFragmentInjector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var appSettings: SharedPrefAppSettings


    override fun activityInjector(): AndroidInjector<Activity> {
        return androidInjector
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment> {
        return androidFragmentInjector
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    @Override
    override fun onConfigurationChanged(newConfig: Configuration) {
        super.onConfigurationChanged(newConfig);
        getPref().validateLanguage()
    }

    override fun onCreate() {
        super.onCreate()
        setUpFacebookIntegration()
        setupTwitterIntegration()
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
        Stetho.initializeWithDefaults(this);
        //set suuport for old version ssl
        enableTls12()
        setupTimber()
        initAdjust()
        setupDagger()
        init (component.sharedPrefAppSettings)
        initInSiderSDK()
        initializeSmartLook()
    }

    private fun initializeSmartLook() {
        //          -->> debug key    35d09121a485101b837bdc279b7e3ed5a2759728
        val builder = Smartlook.SetupOptionsBuilder("213b6ffa9c2b492d4d6d3305c738f81096c5547a")
            .startNewSessionAndUser()
        Smartlook.setupAndStartRecording(builder.build())
    }

    private fun initInSiderSDK() {
        try {
            Insider.Instance.init(this, "tatayab")
            Insider.Instance.setSplashActivity(MainActivity::class.java)
//            var vendors = arrayOfNulls<Vendor>(2)
//            vendors[0] = Vendor.OPPO;
//            vendors[1] = Vendor.XIAOMI;
//            Insider.Instance.getAutoStartPermission(vendors)
            initInsiderCallBacks()
        } catch (e: Exception) {
            println("INSIDER SDK:callbacks/insiderCallbackType:error :"+e?.message)
            e.printStackTrace()
        }
    }
    private fun initInsiderCallBacks() {
        try {
//            Insider.Instance.registerInsiderCallback { data, callbackType ->
//                when (callbackType) {
//                    InsiderCallbackType.NOTIFICATION_OPEN -> {
//                        Log.d(
//                            "[INSIDER]",
//                            "[NOTIFICATION_OPEN]: $data"
//                        )
//                        if (!data.toString().isNullOrEmpty()) {
//                            val mInsiderDeepLinkModel: InsiderDeepLinkModel =
//                                Gson().fromJson(
//                                    data.toString(),
//                                    InsiderDeepLinkModel::class.java
//                                )
//                            mInsiderDeepLinkModel?.let {
//                                it?.dataModel?.let {
//                                    it.url?.let {
//                                        var mBundle = Bundle()
//                                        mBundle.putString(
//                                            "url",
//                                            it
//                                        )
//                                        MemoryCacheManager.addMainBundel(mBundle)
//                                    }
//                                }
//                            }
//                        }
//                        //{"type":0,"data":{"source":"Insider","url":"akl akl akla akl"}}
//                    }
//                    InsiderCallbackType.INAPP_BUTTON_CLICK -> {
//                        try {
//                            Log.d(
//                                "[INSIDER]",
//                                "[INAPP_BUTTON_CLICK]: $data"
//                            )
//                            if (!data.toString().isNullOrEmpty()) {
//                                val mInsiderDeepLinkModel: InsiderDeepLinkModel =
//                                    Gson().fromJson(
//                                        data.toString(),
//                                        InsiderDeepLinkModel::class.java
//                                    )
//                                mInsiderDeepLinkModel?.let {
//                                    it?.dataModel?.let {
//                                        it.url?.let {
//                                            var mBundle = Bundle()
//                                            mBundle.putString(
//                                                "url",
//                                                it
//                                            )
//                                            MemoryCacheManager.addMainBundel(mBundle)
//                                        }
//                                    }
//                                }
//                            }
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                        }
//                    }
//                    InsiderCallbackType.TEMP_STORE_PURCHASE -> Log.d(
//                        "[INSIDER]",
//                        "[TEMP_STORE_PURCHASE]: $data"
//                    )
//                    InsiderCallbackType.TEMP_STORE_ADDED_TO_CART -> Log.d(
//                        "[INSIDER]",
//                        "[TEMP_STORE_ADDED_TO_CART]: $data"
//                    )
//                    InsiderCallbackType.TEMP_STORE_CUSTOM_ACTION -> {
//                        try {
//                            Log.d(
//                                "[INSIDER]",
//                                "[TEMP_STORE_CUSTOM_ACTION]: $data"
//                            )
//                            if (!data.toString().isNullOrEmpty()) {
//                                val mInsiderDeepLinkModel: InsiderDeepLinkModel =
//                                    Gson().fromJson(
//                                        data.toString(),
//                                        InsiderDeepLinkModel::class.java
//                                    )
//                                mInsiderDeepLinkModel?.let {
//                                    it?.dataModel?.let {
//                                        it.url?.let {
//                                            var mBundle = Bundle()
//                                            mBundle.putString(
//                                                "url",
//                                                it
//                                            )
//                                            MemoryCacheManager.addMainBundel(mBundle)
//                                        }
//                                    }
//                                }
//                            }
//                        } catch (e: Exception) {
//                            e.printStackTrace()
//                        }
//                    }
//                }
//            }

        } catch (e: Exception) {
            println("INSIDER SDK:callbacks/insiderCallbackType:error :" + e?.message)
            e.printStackTrace()
        }
    }

    private fun initAdjust() {
        var environmentSandBox = AdjustConfig.ENVIRONMENT_SANDBOX
        var environment = AdjustConfig.ENVIRONMENT_PRODUCTION
        var appToken = "t5bx4il8gmww"
        var config = AdjustConfig(this, appToken, environment)
        // Change the log level.
        config.setLogLevel(LogLevel.VERBOSE)
        Adjust.setEnabled(true)
        // Set attribution delegate.
        config.setOnAttributionChangedListener { attribution ->
            AdjustTracker.mAdjustAttributionModel = AdjustAttributionModel(
                attribution.trackerToken,
                attribution.trackerName,
                attribution.network,
                attribution.campaign,
                attribution.adgroup,
                attribution.creative,
                attribution.clickLabel,
                attribution.adid
            )
        }

        // Set event success tracking delegate.
        config.setOnEventTrackingSucceededListener { eventSuccessResponseData ->
            println("... Adjust tracking / Event success callback called!")
            println("... Adjust tracking / Event success data: $eventSuccessResponseData")
        }

        // Set event failure tracking delegate.
        config.setOnEventTrackingFailedListener { eventFailureResponseData ->
            println("... Adjust tracking / Event failure callback called!")
            println("... Adjust tracking / Event failure data: $eventFailureResponseData")
        }

        // Set session success tracking delegate.
        config.setOnSessionTrackingSucceededListener { sessionSuccessResponseData ->
            println("... Adjust tracking / Session success callback called!")
            println("... Adjust tracking / Session success data: $sessionSuccessResponseData")
        }

        // Set session failure tracking delegate.
        config.setOnSessionTrackingFailedListener { sessionFailureResponseData ->
            println("... Adjust tracking / Session failure callback called!")
            println("... Adjust tracking / Session failure data: $sessionFailureResponseData")
        }

        // Evaluate deferred deep link to be launched.
        config.setOnDeeplinkResponseListener { deeplink ->
            println("++... Adjust tracking / Deferred deep link callback called!")
            println("... Adjust tracking / Deep link URL: $deeplink")
            try {
                if (!deeplink?.toString().isNullOrEmpty()) {
                    DEEP_LINK_URI = deeplink
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            true
        }

        // Set default tracker.
        // config.setDefaultTracker("{YourDefaultTracker}");

        // Set process name.
        // config.setProcessName("com.adjust.examples");

        // Allow to send in the background.
        config.setSendInBackground(true)

        // Enable event buffering.
        // config.setEventBufferingEnabled(true);

        // Delay first session.
        // config.setDelayStart(7);

        // Add session callback parameters.
        Adjust.addSessionCallbackParameter("sc_foo", "sc_bar")
        Adjust.addSessionCallbackParameter("sc_key", "sc_value")

        // Add session partner parameters.
        Adjust.addSessionPartnerParameter("sp_foo", "sp_bar")
        Adjust.addSessionPartnerParameter("sp_key", "sp_value")

        // Remove session callback parameters.
        Adjust.removeSessionCallbackParameter("sc_foo")

        // Remove session partner parameters.
        Adjust.removeSessionPartnerParameter("sp_key")

        // Remove all session callback parameters.
        Adjust.resetSessionCallbackParameters()

        // Remove all session partner parameters.
        Adjust.resetSessionPartnerParameters()

        // Enable IMEI reading ONLY IF:
        // - IMEI plugin is added to your app.
        // - Your app is NOT distributed in Google Play Store.
        // AdjustImei.readImei()

        // Enable OAID reading ONLY IF:
        // - OAID plugin is added to your app.
        // - Your app is NOT distributed in Google Play Store & supports OAID.
        // AdjustOaid.readOaid()

        // Initialise the adjust SDK.

        Adjust.onCreate(config)

        // Abort delay for the first session introduced with setDelayStart method.
        // Adjust.sendFirstPackages();

        // Register onResume and onPause events of all activities
        // for applications with minSdkVersion >= 14.
        registerActivityLifecycleCallbacks(AdjustLifecycleCallbacks())

        // Put the SDK in offline mode.
        // Adjust.setOfflineMode(true);

        // Disable the SDK
        // Adjust.setEnabled(false);

        // Send push notification token.
        // Adjust.setPushToken("token");


    }

    private class AdjustLifecycleCallbacks : Application.ActivityLifecycleCallbacks {
        override fun onActivityResumed(activity: Activity) {
            println("... Adjust tracking/onActivityResumed")
            Adjust.onResume()
        }

        override fun onActivityPaused(activity: Activity) {
            println("... Adjust tracking/onActivityPaused")
            Adjust.onPause()
        }

        override fun onActivityStopped(activity: Activity) {}

//        override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle?) {}
        override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle):Unit{

        }

        override fun onActivityDestroyed(activity: Activity) {}

        override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {}

        override fun onActivityStarted(activity: Activity) {}
    }

    private fun enableTls12() {
        try {
            // Google Play will install latest OpenSSL
            ProviderInstaller.installIfNeeded(this);
            val sslContext = SSLContext.getInstance("TLSv1.2");
            sslContext.init(null, null, null);
            sslContext.createSSLEngine();
        } catch (e: Exception) {
        }
    }

    /*private fun configureLeakCanary(isEnabled: Boolean) {
        AppWatcher.config = AppWatcher.config.copy(enabled = isEnabled)
        LeakCanary.config = LeakCanary.config.copy(dumpHeap = isEnabled)
        LeakCanary.showLeakDisplayActivityLauncherIcon(isEnabled)
    }*/

    private fun setUpFacebookIntegration() {
        @Suppress("DEPRECATION")
        FacebookSdk.sdkInitialize(applicationContext);
    }

    private fun setupTwitterIntegration() {
        val config = TwitterConfig.Builder(this)
            .logger(DefaultLogger(Log.DEBUG))
            .twitterAuthConfig(
                TwitterAuthConfig(
                    getString(R.string.twitter_consumer_key),
                    getString(R.string.twitter_consumer_secret)
                )
            )
            .debug(true)
            .build()
        Twitter.initialize(config)
        //Twitter.initialize(this);
    }


    private fun setupDagger() {
        DaggerApplicationComponent
            .builder()
            .application(this)
            .build()
            .inject(this)
    }

    private fun setupTimber() {
        Timber.plant(Timber.DebugTree())
    }


}

/*
@GlideModule
class MyAppGlideModule : AppGlideModule()
*/
val Activity.injector get() = (application as App).component
val Fragment.injector get() = (context as App).component
val FragmentActivity.injector get() = (application as App).component

