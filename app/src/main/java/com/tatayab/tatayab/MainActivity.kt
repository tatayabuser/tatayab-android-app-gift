package com.tatayab.tatayab

import com.smartlook.sdk.smartlook.Smartlook
import android.content.DialogInterface
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.RelativeLayout
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
 import com.facebook.FacebookSdk
import com.facebook.FacebookSdk.setAdvertiserIDCollectionEnabled
import com.facebook.FacebookSdk.setAutoLogAppEventsEnabled
import com.facebook.appevents.AppEventsConstants
import com.facebook.appevents.AppEventsLogger
import com.google.android.material.badge.BadgeDrawable
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.android.play.core.review.ReviewInfo
import com.google.android.play.core.review.ReviewManagerFactory
import com.google.android.play.core.tasks.Task
import com.google.firebase.dynamiclinks.FirebaseDynamicLinks.getInstance
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import com.tatayab.model.ShareCartListModel
import com.tatayab.model.requests.AddReviewRequest
import com.tatayab.model.responses.InAppMessageModel
import com.tatayab.presentation.Utils
import com.tatayab.presentation.Utils.Companion.DEVICE_UID
import com.tatayab.presentation.Utils.Companion.isInAppMessageShown
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.base.MemoryCacheManager.Companion.COMES_FROM_SHARED_CART
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.presentation.wishlist.WishlistFragmentViewModel
import com.tatayab.remote.util.Constants.Companion.ENABLE_GRAPH_QUERIES_CALLS
import com.tatayab.tatayab.adjust_tracking.AdjustTracker
import com.tatayab.tatayab.auth.LoginActivity
import com.tatayab.tatayab.auth.LoginFragment
import com.tatayab.tatayab.auth.LoginOptionActivity
import com.tatayab.tatayab.base.BaseActivity2
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.botomsheets.addtocart.AddToCartWithOptionsDialogFragment
import com.tatayab.tatayab.deeplink.DeeplinkConstants
import com.tatayab.tatayab.deeplink.DeeplinkConstants.Companion.DEEPLINK_TYPE_HOLDER
import com.tatayab.tatayab.deeplink.DeeplinkConstants.Companion.ORDER_ID_HOLDER
import com.tatayab.tatayab.deeplink.DeeplinkConstants.Companion.ORDER_TYPE_HOLDER
import com.tatayab.tatayab.deeplink.DeeplinkConstants.Companion.WALLET_TYPE_HOLDER
import com.tatayab.tatayab.deeplink.DeeplinkEnum
import com.tatayab.tatayab.deeplink.InsiderDeepLinkModel
import com.tatayab.tatayab.ext.getPlaceholder
import com.tatayab.tatayab.ext.hideKeyboard
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.filter.FilterFragment
import com.tatayab.tatayab.filter.SortFragment
import com.tatayab.tatayab.firebase.FirebaseTrackingManager
import com.tatayab.tatayab.firebase.NotificationHandler
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnCategoryNavigationListener
import com.tatayab.tatayab.listener.OnHomeNavigationListener
import com.tatayab.tatayab.util.*
import com.tatayab.tatayab.util.Constants.DEEPLINK_SCHEME
import com.tatayab.tatayab.util.Constants.HOME_FRAGMENTS_BACK
import com.tatayab.tatayab.util.Constants.PAYMENT_FRAGMENTS_BACK
import com.tatayab.tatayab.util.deskCache.DeskCacheConstants.ENABLE_GRAPH_QUERIES_KEY
import com.tatayab.tatayab.util.deskCache.SharedPrefManager
import com.useinsider.insider.Insider
import com.useinsider.insider.InsiderCallbackType
import kotlinx.android.synthetic.main.activity_base.*
import kotlinx.android.synthetic.main.add_review_sheet.view.*
import kotlinx.android.synthetic.main.content_main.*
import kotlinx.android.synthetic.main.in_app_message_view.*
import timber.log.Timber
import java.net.URL
import java.security.MessageDigest
import javax.inject.Inject
import kotlin.properties.Delegates


open class MainActivity : BaseActivity2(), OnHomeNavigationListener, SearchView.OnQueryTextListener,
    OnCategoryNavigationListener, FirebaseConfigListener {
    private val TAG = MainActivity::class.java.simpleName

    private var categoryName = ""
    private lateinit var viewModel: MainActivityViewModel
    var mFirebaseConfigUtil = FirebaseConfigUtil()
    var mSharedPrefManager: SharedPrefManager? = null
    lateinit var wishlistViewModel: WishlistFragmentViewModel

    @Inject
    lateinit var viewModelFactory: MainActivityViewModelFactory.Factory
    private lateinit var currentNavController: LiveData<NavController>

    private lateinit var itemCount: View

    protected fun syncWithFirebaseCofig() {
        mFirebaseConfigUtil.syncWithFirebaseCofig(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.NoActionBarMaterialTheme)
        super.onCreate(savedInstanceState)

        Insider.Instance.setSplashActivity(MainActivity::class.java)
        mFirebaseConfigUtil.setListener(this)
        syncWithFirebaseCofig()
        setContentView(R.layout.activity_main)
        mSharedPrefManager = SharedPrefManager(this)
        ENABLE_GRAPH_QUERIES_CALLS =
            mSharedPrefManager?.getBooleanFromSharedPrederances(
                ENABLE_GRAPH_QUERIES_KEY,
                true
            ) == true
        DEVICE_UID = getUniqueDeviceID()
        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactory.create(App.getPref().currentLanguage.toString())
            ).get(MainActivityViewModel::class.java)

//        wishlistViewModel =
//            ViewModelProviders.of(
//                this,
//                viewModelFactory.create(App.getPref().currentLanguage.toString())
//            ).get(WishlistFragmentViewModel::class.java)

        initFacebookAnalytics()
        if (savedInstanceState == null) {
            setupBottomNavigationBar()
        }

        mFirebaseConfigUtil.getConciergeLiveData.observe(this, Observer {
            viewModel.updateConciergeValue(it)
        })

        viewModel?.updateTokenIfUserLoggedIn()

        viewModel?.getMigrationLiveData()!!.observe(this, Observer {
            updateCartCount(0)
            App.getPref().restartApp(activityToBeRestarted = this)
        })

//        viewModel?.getIsTokenExpiredLiveData().observe(this, Observer {
//            viewModel?.logoutFun()
//        })

        viewModel.getCartLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    progressStatus(View.VISIBLE)
                }
                ResourceState.SUCCESS -> {
                    progressStatus(View.GONE)
                    it.data?.let { count ->
                        count.first?.let {
                            updateCartCount(count.second)
                        } ?: updateCartCount(count.second)

                    }
                }
                ResourceState.ERROR -> {
                    progressStatus(View.GONE)
                }
                else -> {
                }

            }
        })
        viewModel.getUpdateUserTokenLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.SUCCESS -> {
                    progressStatus(View.GONE)
                    if (it?.data?.isFirstUpdate == false)
                        showCustomTopMessage(
                            getString(R.string.do_lat_action_again),
                            DialogUtil.MessageType.ERROR
                        )
                }
                ResourceState.ERROR -> {
                    progressStatus(View.GONE)
                }
                else -> {
                    progressStatus(View.VISIBLE)
                }

            }
        })

        viewModel.getPromotionLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.SUCCESS -> {
                    it?.data?.let {
                        if (it.in_app_message!! && !isInAppMessageShown)
                            showInAppMessage(it)
                    }
                }
                ResourceState.ERROR -> {
                }
                else -> {
                }
            }
        })

        viewModel.getGoToChoiceOptionsDialog.observe(this, Observer {
            AddToCartWithOptionsDialogFragment.newInstance(it, mainViewModel = viewModel)
                .show(supportFragmentManager, "")
        })

        viewModel.getGoToLoginActivity.observe(this, Observer {
            openLogin(true)
        })

        viewModel.getAddTrackingAction.observe(this, Observer {
            // add CustomEvent For Add To Cart
              Smartlook.trackCustomEvent(Constants.ADD_TO_CART)
        })

        viewModel.addProductToAdjustLiveData.observe(this, Observer {
            if (it.status == ResourceState.SUCCESS) {
                Timber.d(it.data?.price.toString())
                val params = HashMap<String, String>()
                params[AdjustTracker.product_ID] = it.data?.product_id.toString()
                params[AdjustTracker.Product_Price] =
                    it.data?.price.toString().plus(" ").plus(viewModel.getCurrencyCode())
                params[AdjustTracker.Currency] = viewModel.getCurrencyCode()
                AdjustTracker.trackEvent(AdjustTracker.ADD_TO_CART_EVENT, params)
                FirebaseTrackingManager.addProductToCar(this, it.data?.product_id.toString())

            }
        })

        NotificationHandler.token.observe(this, Observer { token ->
            token.let {
                viewModel.setNotificationToken(it)
            }
        })

        viewModel.getExtractDeepLinkLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    base_progress.visibility = View.GONE
                }
                ResourceState.LOADING -> {
                    base_progress.visibility = View.VISIBLE

                }
                ResourceState.SUCCESS -> {
                    base_progress.visibility = View.GONE
                    it?.let {
                        it.data?.let {
                            handelExtractUrl(it.type, it.object_id)
                        }
                    }
                }
            }

        })
//        initInsiderCallBack()
        initAction()
        printHashKey()
        initInsiderCallBacks()
        checkIntent(intent)
        viewModel.updateCurrentLanguageToCache(App.getPref().currentLanguage.toString())
    }


    private fun checkIntent(intent: Intent?) {
        try {
            intent?.let {
                var uri = it?.data.toString()
                if (!uri.isNullOrEmpty() && !uri.equals("null", true)) {
                    if (uri.contains(DEEPLINK_SCHEME, true) || isDeeplinkContainsLocalLogic(uri)) {
                        handelCustomDeeplink(uri)
                    } else {
                        initDynamicLink(intent)
                    }
                } else {
                    initDynamicLink(it)
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun handelCustomDeeplink(uri: String) {
        try {
            //    http://tatayabdlink://categories/9/Offers
            //    tatayabDlink://supplier/72/French
            //    tatayabDlink://products/5892/chanel-paris-riviera-eau-de-toilette-125ml-unisex
            val url = uri?.trim()
            val bundle = Bundle()
            if (url != null) {
                val list = url.split("/")
                /* Request code */when {
                    url.contains(DeeplinkEnum.products.toString(), true) -> {
                        bundle.putString("productId", list[3])
                    }
                    url.contains(DeeplinkEnum.Categories.toString(), true) || url.contains(
                        DeeplinkEnum.category.toString(),
                        true
                    ) -> {
                        bundle.putString("categoryType", "cid")
                        bundle.putString("categoryId", list[3])
                        bundle.putString("categoryName", list[4])
                    }
                    url.contains(DeeplinkEnum.supplier.toString(), true) || url.contains(
                        DeeplinkEnum.suppliers.toString(),
                        true
                    ) -> {
                        bundle.putString("categoryType", "supplier_ids")
                        bundle.putString("categoryId", list[3])
                        bundle.putString("categoryName", list[4])
                    }
                    url.contains(DeeplinkEnum.myorder.toString(), true) -> {
                        bundle.putString(ORDER_ID_HOLDER, list[3])
                        bundle.putString(DEEPLINK_TYPE_HOLDER, ORDER_TYPE_HOLDER)
                    }
                    url.contains(DeeplinkEnum.myWallet.toString(), true) || url.contains(
                        DeeplinkEnum.credit.toString(),
                        true
                    ) -> {
                        bundle.putString(DEEPLINK_TYPE_HOLDER, WALLET_TYPE_HOLDER)
                    }
                    url.contains(DeeplinkEnum.mycart.toString(), true) -> {
                        bundle.putString(
                            DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                            DeeplinkConstants.CART_TYPE_HOLDER
                        )
                    }
                }
                MemoryCacheManager.addMainBundel(bundle)

//                handelIntent(bundle)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun initDynamicLink(intent: Intent) {
        try {
            getInstance().getDynamicLink(getIntent())
                .addOnSuccessListener(this) { pendingDynamicLinkData ->
                    // Get deep link from result (may be null if no link is found)
                    var deepLink: Uri? = null
                    if (pendingDynamicLinkData != null) {
                        deepLink = pendingDynamicLinkData.link
                    }
                    Log.d("Akl main/firebase ", "onSuccess: $deepLink")
                    if (deepLink != null) {
                        if (deepLink.toString().contains("share_cart", true)) {
                            handleShareCartDeeplink(deepLink)
                        } else if (deepLink.toString().contains("invite", true)) {
                            var deepLinkPath = deepLink?.path
                            Log.d("Akl main/deepLinkPath", "onSuccess: $deepLinkPath")
                            if (!deepLinkPath.isNullOrEmpty()) {
                                MemoryCacheManager.addReferFriendUrl(deepLinkPath)
                            }
                            intent.setData(null)
                            setIntent(intent)
                        }
                    }
                }
                .addOnFailureListener(this) { e ->
                    Log.w(
                        "Akl dynamic/error",
                        "getDynamicLink:onFailure",
                        e
                    )
                }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
            Log.d("Akl main/firebase ", "catch${e.localizedMessage}")

        }
    }

    private fun handleShareCartDeeplink(deepLink: Uri) {
        try {
            var decodeURI = Uri.decode(deepLink.toString())
            var deepLinkURI = Uri.parse(decodeURI)
            var cartQueryParam = deepLinkURI.getQueryParameter("params")
            if (!cartQueryParam.isNullOrEmpty()) {
                var mShareCartListModel = Gson().fromJson<ShareCartListModel>(
                    cartQueryParam,
                    ShareCartListModel::class.java
                )
                if (mShareCartListModel != null && !mShareCartListModel.products.isNullOrEmpty()) {
                    MemoryCacheManager.addShareCartModel(mShareCartListModel)
                }
                intent.setData(null)
                setIntent(intent)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun initInsiderCallBacks() {
        try {
            Insider.Instance.registerInsiderCallback { data, callbackType ->
                when (callbackType) {
                    InsiderCallbackType.NOTIFICATION_OPEN -> {
                        Log.d(
                            "[INSIDER]",
                            "[NOTIFICATION_OPEN]: $data"
                        )
                        if (!data.toString().isNullOrEmpty()) {
                            val mInsiderDeepLinkModel: InsiderDeepLinkModel =
                                Gson().fromJson(
                                    data.toString(),
                                    InsiderDeepLinkModel::class.java
                                )
                            mInsiderDeepLinkModel?.let {
                                it?.dataModel?.let {
                                    it.url?.let {
                                        var mBundle = Bundle()
                                        mBundle.putString(
                                            "url",
                                            it
                                        )
                                        handelIntent(mBundle)
                                    }
                                }
                            }
                        }
                    }
                    InsiderCallbackType.INAPP_BUTTON_CLICK -> {
                        try {
                            Log.d(
                                "[INSIDER]",
                                "[INAPP_BUTTON_CLICK]: $data"
                            )
                            if (!data.toString().isNullOrEmpty()) {
                                val mInsiderDeepLinkModel: InsiderDeepLinkModel =
                                    Gson().fromJson(
                                        data.toString(),
                                        InsiderDeepLinkModel::class.java
                                    )
                                mInsiderDeepLinkModel?.let {
                                    it?.dataModel?.let {
                                        it.url?.let {
                                            var mBundle = Bundle()
                                            mBundle.putString(
                                                "url",
                                                it
                                            )
                                            handelIntent(mBundle)
                                        }
                                    }
                                }
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                    InsiderCallbackType.TEMP_STORE_PURCHASE -> Log.d(
                        "[INSIDER]",
                        "[TEMP_STORE_PURCHASE]: $data"
                    )
                    InsiderCallbackType.TEMP_STORE_ADDED_TO_CART -> Log.d(
                        "[INSIDER]",
                        "[TEMP_STORE_ADDED_TO_CART]: $data"
                    )
                    InsiderCallbackType.TEMP_STORE_CUSTOM_ACTION -> {
                        try {
                            Log.d(
                                "[INSIDER]",
                                "[TEMP_STORE_CUSTOM_ACTION]: $data"
                            )
                            if (!data.toString().isNullOrEmpty()) {
                                val mInsiderDeepLinkModel: InsiderDeepLinkModel =
                                    Gson().fromJson(
                                        data.toString(),
                                        InsiderDeepLinkModel::class.java
                                    )
                                mInsiderDeepLinkModel?.let {
                                    it?.dataModel?.let {
                                        it.url?.let {
                                            var mBundle = Bundle()
                                            mBundle.putString(
                                                "url",
                                                it
                                            )
                                            handelIntent(mBundle)
                                        }
                                    }
                                }
                            }
                        } catch (e: Exception) {
                            e.printStackTrace()
                        }
                    }
                }
            }

        } catch (e: Exception) {
            println("INSIDER SDK:callbacks/insiderCallbackType:error :" + e?.message)
            e.printStackTrace()
        }
    }

    fun printHashKey() {
        try {

            var info = getPackageManager().getPackageInfo(
                "com.tatayab.tatayab",
                PackageManager.GET_SIGNATURES
            )

            for (signature in info.signatures) {

                var md = MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())

                println(
                    "SOICAL MDIA/KeyHash : " + Base64.encodeToString(
                        md.digest(),
                        Base64.DEFAULT
                    )
                )

            }
        } catch (e: Exception) {
        }
    }


    private fun initAction() {

        if (promoCloseImageView != null)
            promoCloseImageView.setOnClickListener {
                inAppMessageParent.visibility = View.GONE
            }

    }

    private fun setupBottomNavigationBar() {
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)

        val navGraphIds = listOf(
            R.navigation.home,
            R.navigation.category,
            R.navigation.cart,
            R.navigation.wishlist,
            R.navigation.account
        )

        // Setup the bottom navigation view with a list of navigation graphs
        val controller = bottomNavigationView?.setupWithNavController(
            navGraphIds = navGraphIds,
            fragmentManager = supportFragmentManager,
            containerId = R.id.nav_host_container,
            intent = intent
        )

        currentNavController = controller!!

        bottomNavigationView?.setupDeepLinks(
            navGraphIds,
            supportFragmentManager,
            R.id.nav_host_container,
            intent
        )

        setupCartIcon()
        if (intent != null) handelIntent(intent.extras)


    }

    private fun initFacebookAnalytics() {
        //FaceBook logs automatic
        setAutoLogAppEventsEnabled(true)
        FacebookSdk.setAutoInitEnabled(true)
        FacebookSdk.fullyInitialize()
        setAdvertiserIDCollectionEnabled(true);
        val logger = AppEventsLogger.newLogger(this)
        logger.logEvent(AppEventsConstants.EVENT_PARAM_PRODUCT_APPLINK_ANDROID_APP_NAME);
    }


    override fun onRestoreInstanceState(savedInstanceState: Bundle) {
        super.onRestoreInstanceState(savedInstanceState)
        setupBottomNavigationBar()
    }


    private fun setupBackNavIcon(navController: NavController) {
        /*iv_hamburger.setSafeOnClickListener {
            if (navController.currentDestination?.id !in HOME_FRAGMENTS)
                navController.popBackStack()
        }*/
    }


    fun loginSucceed() {
        viewModel.loginSucceed()
    }

    fun clearCart() {
//        viewModel.clearCart()
    }

    fun logout() {
        removeCartCount()
//        viewModel.removeAllWishListFromCachedForCurrentCountry()
    }

    fun updateCartCount(count: Int) {
        println("AKl://updateCartCount in mainAct //  "+count)
        if (count > 0) {
            showCartCount(count)
        } else {
            removeCartCount()
        }
        MemoryCacheManager.addCartCount(count)

    }

    private fun openLogin(login: Boolean) {
        if (login) {
            val bundle = Bundle().apply {
                putInt(Constants.LOGIN, Constants.REQUEST_CODE_LOG_IN)
            }
            val loginIntent = Intent(this@MainActivity, LoginOptionActivity::class.java)
            loginIntent.putExtras(bundle)
            startActivityForResult(loginIntent, Constants.REQUEST_CODE_LOGIN_ACTIVITY)
        } else {
            val bundle = Bundle().apply {
                putInt(Constants.REGISTER, Constants.REQUEST_CODE_REGISTER)
            }

            val loginIntent = Intent(this@MainActivity, LoginActivity::class.java)
            loginIntent.putExtras(bundle)
            startActivityForResult(loginIntent, Constants.REQUEST_CODE_LOGIN_ACTIVITY)
        }
    }


    private fun showCartCount(count: Int) {
        bottomNavigation.getOrCreateBadge(R.id.cart).apply {
            number = count
        }
    }

    private fun removeCartCount() {
        bottomNavigation.getBadge(R.id.cart)?.let { badgeDrawable: BadgeDrawable ->
            if (badgeDrawable.isVisible)  // check whether the item showing badge
                bottomNavigation.removeBadge(R.id.cart)  //  remove badge notification
        }
    }

    private fun setupCartIcon() {
        itemCount = bottomNavigation.findViewById(R.id.cart)
    }

    /**
     * Called on first creation and when restoring state.
     */
//    private fun setupBottomNavigationBar() {
//        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigation)
//        val navGraphIds = listOf(
//            R.navigation.home,
//            R.navigation.category,
//            R.navigation.wishlist,
//            R.navigation.account,
//            R.navigation.cart
//        )
//
//        bottomNavigationView.setupWithNavController(this.findNavController(R.id.nav_host_container))
//        setupActionBar(findNavController(R.id.nav_host_container))
//        currentNavController = findNavController(R.id.nav_host_container)
//        bottomNavigation.setupWithNavController(currentNavController)
//        val myNavHostFragment: NavHostFragment = nav_host_container as NavHostFragment
//        val inflater = myNavHostFragment.navController.navInflater
//        val graph = inflater.inflate(R.navigation.home)
//        myNavHostFragment.navController.graph = graph
//
//        bottomNavigationView.setupDeepLinks(
////            navGraphIds,
////            supportFragmentManager,
////            R.id.nav_host_container,
////            intent
////        )
////
////        setupCartIcon()
//        if (intent != null) handelIntent(intent.extras)
//
//    }

    fun handelIntent(bundle: Bundle?) {
        try {
            if (bundle != null) {
                if (bundle.containsKey("url")) {
                    try {
                        var url = bundle.getString("url")
                        if (isDeeplinkContainsLocalLogic(url.toString())) {
                            handleDeeplinkLocal(url.toString())
                        } else {
                            base_progress.visibility = View.VISIBLE
                            var deepLink = URL(url).getPath()
                            // Remove the / from the start and End of URL
                            if (deepLink.get(0).equals('/')) {
                                deepLink = deepLink.substring(1)
                            }
                            if (deepLink.get(deepLink.length - 1).equals('/')) {
                                deepLink = deepLink.substring(0, deepLink.length - 1)
                            }
                            getCategoryName(deepLink)
//                            viewModel.extractDeepLinkUrl(deepLink)

                        }

                    } catch (e: java.lang.Exception) {
                        base_progress.visibility = View.GONE
                    }
                } else if (bundle.containsKey("categoryId") || bundle.containsKey("productId") || bundle.containsKey(
                        DEEPLINK_TYPE_HOLDER
                    )
                ) {
                    MemoryCacheManager.addMainBundel(bundle)
                }
            }

        } catch (e: Exception) {
            base_progress.visibility = View.GONE
            e.printStackTrace()
        }
    }

    private fun handleDeeplinkLocal(url: String) {

        val url = url?.trim()
        val bundle = Bundle()
        if (url != null) {
            val list = url.split("/")
            /* Request code */when {
                url.contains(DeeplinkEnum.products.toString()) -> {
                    bundle.putString("productId", list[4])
                }
                url.contains(
                    DeeplinkEnum.Categories.toString(),
                    true
                ) || url.contains(DeeplinkEnum.category.toString(), true) -> {
                    bundle.putString("categoryType", "cid")
                    bundle.putString("categoryId", list[4])
                    bundle.putString("categoryName", list[5])
                }
                url.contains(DeeplinkEnum.supplier.toString()) || url.contains(DeeplinkEnum.suppliers.toString()) -> {
                    bundle.putString("categoryType", "supplier_ids")
                    bundle.putString("categoryId", list[4])
                    bundle.putString("categoryName", list[5])
                }
                url.contains(DeeplinkEnum.myorder.toString()) -> {
                    bundle.putString(ORDER_ID_HOLDER, list[4])
                    bundle.putString(DEEPLINK_TYPE_HOLDER, ORDER_TYPE_HOLDER)
                }
                url.contains(DeeplinkEnum.myWallet.toString()) || url.contains(
                    DeeplinkEnum.credit.toString(),
                    true
                ) -> {
                    bundle.putString(DEEPLINK_TYPE_HOLDER, WALLET_TYPE_HOLDER)
                }
                url.contains(DeeplinkEnum.mycart.toString(), true) -> {
                    navigatedToCartFragment()
                }
            }
            MemoryCacheManager.addMainBundel(bundle)
//            handelIntent(bundle)
        }

    }

    fun handelLocalNavigation(bundle: Bundle?) {
        try {
            if (bundle != null) {
                if (bundle.containsKey("categoryId")) {
                    val categoryId = bundle.getString("categoryId")
                    val categoryType = bundle.getString("categoryType")
                    val categoryName = bundle.getString("categoryName")

                    if (categoryId != null && categoryType != null && categoryName != null) {
                        openProductList(categoryType, categoryId, categoryName)
                    }
                } else if (bundle.containsKey("productId")) {
                    val productId = bundle.getString("productId")
                    if (productId != null) {
                        openProductDetails(productId)
                    }
                } else if (bundle.containsKey(DeeplinkConstants.DEEPLINK_TYPE_HOLDER)) {
                    if (!viewModel.isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) return
                    val deeplinkType = bundle.getString(DeeplinkConstants.DEEPLINK_TYPE_HOLDER)
                    if (deeplinkType.equals(DeeplinkConstants.ORDER_TYPE_HOLDER)) {
                        var orderID = bundle.getString(DeeplinkConstants.ORDER_ID_HOLDER)
                        openMyOrder(orderID)
                    } else if (deeplinkType.equals(DeeplinkConstants.WALLET_TYPE_HOLDER)) {
                        openMyWallet()
                    } else if (deeplinkType.equals(DeeplinkConstants.CART_TYPE_HOLDER)) {
                        navigatedToCartFragment()
                    }
                }

                MemoryCacheManager.addMainBundel(Bundle())
            }

        } catch (e: Exception) {
            base_progress.visibility = View.GONE
            e.printStackTrace()
        }
    }

    private fun openMyWallet() {
        val uri = Uri.parse("android-app://www.tatayab.com/wallet")
        currentNavController.value?.navigate(uri)
    }

    private fun openMyOrder(orderID: String?) {
        val uri = Uri.parse("android-app://www.tatayab.com/order_details/$orderID")
        currentNavController.value?.navigate(uri)
    }

    private fun openProductDetails(productId: String) {
        try {
            val uri = Uri.parse("android-app://www.tatayab.com/products/$productId")
            currentNavController.value?.navigate(uri)
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }

    }

    private fun openProductList(
        categoryType: String,
        categoryId: String,
        categoryName: String
    ) {
        val uri =
            Uri.parse("android-app://www.tatayab.com/product_list/$categoryType/$categoryId/$categoryName")
        currentNavController.value?.navigate(uri)
    }

    fun navigateBackWithResult(result: Bundle) {
        try {
            val childFragmentManager =
                supportFragmentManager.findFragmentById(R.id.nav_host_container)
                    ?.childFragmentManager
            var backStackListener: FragmentManager.OnBackStackChangedListener by Delegates.notNull()
            backStackListener = FragmentManager.OnBackStackChangedListener {
                if (childFragmentManager?.fragments?.get(0) is NavigationResult) {
                    (childFragmentManager.fragments[0] as NavigationResult).onNavigationResult(
                        result
                    )
                    childFragmentManager.removeOnBackStackChangedListener(backStackListener)
                }
            }
            childFragmentManager?.addOnBackStackChangedListener(backStackListener)
            currentNavController.value?.popBackStack()
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun onResume() {
        super.onResume()
        if (COMES_FROM_SHARED_CART) {
            // update the cart count
            viewModel?.getCartContentFirstTime()
            navigatedToCartFragment()
            COMES_FROM_SHARED_CART = false
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return currentNavController.value?.navigateUp() ?: false
    }


    override fun onActivityResult(
        requestCode: Int,
        resultCode: Int,
        data: Intent?
    ) {
        super.onActivityResult(requestCode, resultCode, data)
        // Pass the activity result to the fragment, which will then pass the result to the login
        // button for twitter.
        val navHostFragment = supportFragmentManager.fragments.first() as? NavHostFragment
        if (navHostFragment != null) {
            val childFragments = navHostFragment.childFragmentManager.fragments
            childFragments.forEach { fragment ->
                if (fragment is LoginFragment) {
                    fragment.onActivityResult(requestCode, resultCode, data)
                } else if (fragment is SortFragment && (data?.getIntExtra(
                        Constants.SORT_FRAGMENT,
                        0
                    ) == Constants.REQUEST_CODE_SORT)
                ) {
                    fragment.onActivityResult(requestCode, resultCode, data)
                } else if (fragment is FilterFragment && (data?.getIntExtra(
                        Constants.FILTER_FRAGMENT,
                        0
                    ) == Constants.REQUEST_CODE_FILTER)
                ) {
                    fragment.onActivityResult(requestCode, resultCode, data)
                }

            }
            if (viewModel.isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                viewModel.getCartContentFirstTime()
            }
        }

    }

    override fun onBackPressed() {
        if (currentNavController.value?.currentDestination?.id in HOME_FRAGMENTS_BACK) {
            super.onBackPressed()
        } else if (currentNavController.value?.currentDestination?.id in PAYMENT_FRAGMENTS_BACK) {
            currentNavController.value?.popBackStack()
        } else if (currentNavController.value?.currentDestination?.label?.equals(getString(R.string.select_country)) == true) {
            BaseFragment.isChooseCountry = true
            val bundle = Bundle()
            bundle.putParcelable("selected_country", null)
            navigateBackWithResult(bundle)
        } else {
            currentNavController.value?.popBackStack()
        }

    }

    //    if (currentNavController.currentDestination?.id != R.id.fragment_filter)
    fun showAddProductReview(productId: String?, productName: String?) {
        val mBottomSheetDialog = BottomSheetDialog(this)

        val sheetView =
            layoutInflater.inflate(R.layout.add_review_sheet, null)

        sheetView.product_name.text = productName
        sheetView.ratecomment.imeOptions = EditorInfo.IME_ACTION_SEND
        sheetView.ratesend.setSafeOnClickListener {

            if (sheetView.ratecomment.text.trim().isNotEmpty()) {
                if (sheetView.ratingBar.rating > 0) {
                    val addReviewRequest =
                        AddReviewRequest(
                            sheetView.ratecomment.text.toString(),
                            productId!!,
                            sheetView.ratingBar.rating
                        )
                    viewModel.addReview(addReviewRequest, sheetView)
                } else
                    showCustomTopMessage(
                        getText(R.string.add_rate).toString(),
                        DialogUtil.MessageType.ERROR
                    )
            } else
                sheetView.ratecomment.error = getText(R.string.invalid_comment)
        }

        sheetView.close.setSafeOnClickListener {
            mBottomSheetDialog.hide()
        }
        mBottomSheetDialog.setContentView(sheetView)
        mBottomSheetDialog.show()
    }


    override fun navigatedToHomeFragment() {
        bottomNavigation.selectedItemId = R.id.home
    }


    fun navigatedToCartFragment() {
        bottomNavigation.selectedItemId = R.id.cart
    }

    fun navigatedToProfileFragment() {
        MemoryCacheManager.OPEN_WALLET_FLAG = true
        bottomNavigation.selectedItemId = R.id.account
    }

    override fun navigatedToCategoryFragment() {
        bottomNavigation.selectedItemId = R.id.categories
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (query.toString().length > 2) {
            hideKeyboard()
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return false
    }


    fun hideBottomNavigation() {
        bottomNavigation.visibility = View.GONE
    }


    fun showBottomNavigation() {
        bottomNavigation.visibility = View.VISIBLE
    }


    fun showInAppMessage(mInAppMessageModel: InAppMessageModel) {

        mInAppMessageModel?.let {

            inAppMessageParent.visibility = View.VISIBLE

            isInAppMessageShown = true

            if (!it.title.isNullOrEmpty())

                PromoTitleTextView.text = it.title.toString()
            else

                PromoTitleTextView.visibility = View.GONE


            if (!it.desc.isNullOrEmpty())

                PromoDescTextView.text = it.desc.toString()
            else

                PromoDescTextView.visibility = View.GONE

            if (!it.image.isNullOrEmpty()) {
//                Glide.with(this)
//                    .load(
//                        it.image
//                    ).apply(getPlaceholder())
//                    .into(promoImageView)

                try {
                    Picasso.get()
                        .load(it.image)
                        .placeholder(R.drawable.default_image2).into(promoImageView)

                } catch (e: java.lang.Exception) {
                    e.printStackTrace()
                }
            }

            if (it.action != null) {

                it.action?.let {

                    it.title?.let {

                        PromoActionButton.text = it

                    }

                }

            } else {

                PromoActionButton.visibility = View.GONE

                if (PromoDescTextView.visibility == View.GONE && PromoTitleTextView.visibility == View.GONE) {

                    val layoutparams = promoImageView?.layoutParams as RelativeLayout.LayoutParams

                    layoutparams.height = 1200

                }

            }


            PromoActionButton.setOnClickListener {

                mInAppMessageModel.action?.actionName?.let {

                    when (it) {

                        ActionType.register.toString() -> {

                            startActivity(Intent(this, LoginActivity::class.java))

                        }

                        ActionType.home.toString() -> println("......showInAppMessage/action/home")

                        else -> {

                            println("......showInAppMessage/action/else : " + it)

                        }

                    }

                }

                inAppMessageParent.visibility = View.GONE

            }


        }

    }


    enum class ActionType {
        register,
        home
    }


    private fun getCategoryName(deepLink: String): String {
        val url = deepLink.trim()
        val list = url.split("/")
        if (list != null && list.size > 0) {
            categoryName = list.get(list.size - 1)
        }
        return categoryName
    }

    fun handelExtractUrl(type: String?, id: String?) {
        base_progress.visibility = View.GONE
        if (type.isNullOrEmpty() || id.isNullOrEmpty()) {
            return
        }
        if (type.equals(
                DeeplinkEnum.products.toString(), ignoreCase = true
            )
        ) {
            if (id != null) {
                openProductDetails(id)
            }

        } else if (type.equals(DeeplinkEnum.categories.toString(), ignoreCase = true)) {
            val categoryType = "cid"
            openProductList(categoryType, id, categoryName)
        } else if (type.equals(DeeplinkEnum.suppliers.toString(), ignoreCase = true) || type.equals(
                DeeplinkEnum.supplier.toString(),
                ignoreCase = true
            )
        ) {
            val categoryType = "supplier_ids"
            openProductList(categoryType, id, categoryName)
        }
    }

    fun resetLoadAllHomeBlocksAgain() {
        viewModel?.loadAllHomeBlocksAgain()
    }

    fun showRateApp() {
        try {
            var reviewManager = ReviewManagerFactory.create(this)
            val request =
                reviewManager!!.requestReviewFlow()
            request.addOnCompleteListener { task: Task<ReviewInfo?> ->
                if (task.isSuccessful) {
                    val reviewInfo = task.result
                    val flow = reviewManager!!.launchReviewFlow(this, reviewInfo)
                    flow.addOnCompleteListener { task1: Task<Void?>? -> }
                } else {
                    // There was some problem, continue regardless of the result.
                    // show native rate app dialog on error
                    showRateAppFallbackDialog()
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    /**
     * Showing native dialog with three buttons to review the app
     * Redirect user to PlayStore to review the app
     */
    private fun showRateAppFallbackDialog() {
        try {
            MaterialAlertDialogBuilder(this)
                .setTitle(R.string.rate_app_title)
                .setMessage(R.string.rate_app_message)
                .setPositiveButton(
                    R.string.rate_btn_pos,
                    { dialog, which -> redirectToPlayStore() })
                .setNegativeButton(R.string.rate_btn_neg,
                    { dialog, which -> })
                .setNeutralButton(R.string.rate_btn_nut,
                    { dialog, which -> })
                .setOnDismissListener(DialogInterface.OnDismissListener { dialog: DialogInterface? -> })
                .show()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    // redirecting user to PlayStore
    fun redirectToPlayStore() {
        val appPackageName: String = "com.tatayab.tatayab"
        try {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("market://details?id=$appPackageName")
                )
            )
        } catch (exception: java.lang.Exception) {
            startActivity(
                Intent(
                    Intent.ACTION_VIEW,
                    Uri.parse("https://play.google.com/store/apps/details?id=$appPackageName")
                )
            )
        }
    }

    override fun updateEnableGraphQlValue(newGraphValue: Boolean) {
        // get old graph
        var currentValue = mSharedPrefManager?.getBooleanFromSharedPrederances(
            ENABLE_GRAPH_QUERIES_KEY, true
        )
        if (currentValue != newGraphValue) {
            mSharedPrefManager?.addBooleanToSharedPrederances(
                ENABLE_GRAPH_QUERIES_KEY,
                newGraphValue
            )
            ENABLE_GRAPH_QUERIES_CALLS = true
            viewModel?.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS

            removeCurrentUserFromCache()
        }

    }

    private fun removeCurrentUserFromCache() {
        updateCartCount(0)
        viewModel?.logout()
    }

    fun hideBottomBar() {
        bottomNavigation?.visibility = View.GONE
    }

    fun showBottomBar() {
        bottomNavigation?.visibility = View.VISIBLE
    }

    fun isExpiredMessage(
        message: String
    ) {
      if(viewModel?.isExpiredMessage(message)){
          viewModel?.logoutFun()
      }
    }


}


