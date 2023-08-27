package com.tatayab.tatayab.deeplink

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.annotation.Nullable
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.gson.Gson
import com.tatayab.model.ShareCartListModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseActivity2
import com.tatayab.tatayab.util.Constants
import java.lang.Exception
import javax.inject.Inject


class DeepLinkActivity : BaseActivity2() {

    private val TAG = DeepLinkActivity::class.java.simpleName

    private var categoryName = ""

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory
    lateinit var mainViewModel: MainActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        setTheme(R.style.NoActionBarMaterialTheme)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deeplink)
        val appLinkIntent = intent
        val uri = appLinkIntent.data.toString()
        checkIntent(intent)

        mainViewModel = run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        }

        mainViewModel.getExtractDeepLinkLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    handelExtractUrl(null, null)
                    finish()
                }
                ResourceState.LOADING -> {
                }
                ResourceState.SUCCESS -> {
                    it?.let {
                        it.data?.let {
                            handelExtractUrl(it.type, it.object_id)
                            println("... Adjust tracking / Deep link URL/DepLinkActi/rsponse /it.type: ${it.type}  , id: ${it.object_id}")

                        }
                    }
                    finish()
                }
            }

        })

    }

    private fun handelCustomDeeplink(uri: String) {
        try{
            //    tatayabdlink://categories/9/Offers
            //    tatayabDlink://supplier/72/French
            //    tatayabDlink://products/5892/chanel-paris-riviera-eau-de-toilette-125ml-unisex
            val url = uri?.trim()
            val bundle = Bundle()
            if (url != null) {
                val list = url.split("/")
                /* Request code */when {
                    url.contains(DeeplinkEnum.products.toString(),true) -> {
                        bundle.putString("productId", list[3])
                    }
                    url.contains(DeeplinkEnum.Categories.toString(),true) || url.contains(DeeplinkEnum.category.toString(),true) -> {
                        bundle.putString("categoryType", "cid")
                        bundle.putString("categoryId", list[3])
                        bundle.putString("categoryName", list[4])
                    }
                    url.contains(DeeplinkEnum.supplier.toString(),true) || url.contains(DeeplinkEnum.suppliers.toString(),true) -> {
                        bundle.putString("categoryType", "supplier_ids")
                        bundle.putString("categoryId", list[3])
                        bundle.putString("categoryName", list[4])
                    }
                    url.contains(DeeplinkEnum.myorder.toString(),true) -> {
                        bundle.putString(DeeplinkConstants.ORDER_ID_HOLDER, list[3])
                        bundle.putString(
                            DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                            DeeplinkConstants.ORDER_TYPE_HOLDER
                        )
                    }
                    url.contains(DeeplinkEnum.myWallet.toString(),true) || url.contains(DeeplinkEnum.credit.toString(), true)-> {
                        bundle.putString(
                            DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                            DeeplinkConstants.WALLET_TYPE_HOLDER
                        )
                    }
                    url.contains(DeeplinkEnum.mycart.toString(),true) -> {
                        bundle.putString(
                            DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                            DeeplinkConstants.CART_TYPE_HOLDER
                        )
                    }
                }
                openMainActivityDeepLink(bundle)
            }
        }catch (e:java.lang.Exception){
            e.printStackTrace()
        }
    }

    private fun checkIntent(intent: Intent?) {
        try {
            intent?.let {
                var uri = it?.data.toString()
                if (!uri.isNullOrEmpty() && !uri.equals("null",true)) {
                    if (uri.contains(Constants.DEEPLINK_SCHEME, true) || isDeeplinkContainsLocalLogic(uri)) {
                        if(!uri.isNullOrEmpty() && uri.contains(Constants.DEEPLINK_SCHEME,true)){
                            handelCustomDeeplink(uri)
                        }else {
                            var deepLink = getDeepLink()
                            println("... Adjust tracking / Deep link URL/DepLinkActi page: $deepLink")

                            // If deep link is null start the MainActivity
                            if (deepLink.isNullOrEmpty()) {
                                startActivity(Intent(this, MainActivity::class.java))
                                finish()
                                return
                            } else {
                                try {
                                    if (isDeeplinkContainsLocalLogic(deepLink)) {
                                        handleDeeplinkLocal(deepLink)
                                    } else {
                                        // Remove the / from the start and End of URL
                                        if (deepLink.get(0).equals('/')) {
                                            deepLink = deepLink.substring(1)
                                        }
                                        if (deepLink.get(deepLink.length - 1).equals('/')) {
                                            deepLink = deepLink.substring(0, deepLink.length - 1)
                                        }
                                        getCategoryName(deepLink)
//                                        mainViewModel.extractDeepLinkUrl(deepLink)
                                    }
                                } catch (e: Exception) {
                                    println("---------------...... deplink/exception/ : " + e.message)
                                }
                            }
                        }

                    } else if(uri.contains("invite",true) || uri.contains("share_cart")) {
                        initDynamicLink(intent?.data!!)
                    }
                }else{
                    startActivity(Intent(this, MainActivity::class.java))
                    finish()
                }
            }

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
    private fun initDynamicLink(deepLinkURI: Uri) {
        try {
            if (deepLinkURI != null) {
                if (deepLinkURI.toString().contains("share_cart", true)) {
                    handleShareCartDeeplink(deepLinkURI)
                } else if (deepLinkURI.toString().contains("invite", true)) {
                    var deepLinkPath = deepLinkURI?.path
                    Log.d("Akl main/deepLinkPath", "onSuccess: $deepLinkPath")
                    if (!deepLinkPath.isNullOrEmpty()) {
                        MemoryCacheManager.addReferFriendUrl(deepLinkPath)
                    }
                }
            }
            openMainActivityDeepLink(Bundle())
            finish()
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
    private fun handleShareCartDeeplink(deepLink: Uri) {
        try {
            var cartQueryParam = deepLink.getQueryParameter("shareCart")
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

    private fun getCategoryName(deepLink: String) {

        val url = deepLink.trim()
        val list = url.split("/")
        if (list != null && list.size > 0) {
            categoryName = list.get(list.size - 1)
        }
    }


    fun handelExtractUrl(type: String?, id: String?) {


        if (type.isNullOrEmpty() || id.isNullOrEmpty()) {
            openMainActivityDeepLink(Bundle())
            finish()
            return
        }
        if (type.equals("products", ignoreCase = true)) {
            val bundle = Bundle()
            bundle.putString("productId", id)

            openMainActivityDeepLink(bundle)
        } else if (type.equals("categories", ignoreCase = true)) {

            val categoryType = "cid"
            val categoryId = id
            val bundle = Bundle()
            bundle.putString("categoryType", categoryType)
            bundle.putString("categoryId", categoryId)
            bundle.putString("categoryName", categoryName)

            openMainActivityDeepLink(bundle)

        } else if (type.equals("suppliers", ignoreCase = true) || type.equals(
                "supplier",
                ignoreCase = true
            )
        ) {

            val categoryType = "supplier_ids"
            val categoryId = id
            val bundle = Bundle()
            bundle.putString("categoryType", categoryType)
            bundle.putString("categoryId", categoryId)
            bundle.putString("categoryName", categoryName)
            openMainActivityDeepLink(bundle)


        }
    }


    private fun handleDeeplinkLocal(deepLink: Uri?) {
        val path: String? = deepLink?.path

        if (path != null && path.contains("/products", ignoreCase = true)
        ) {
            val list = deepLink.pathSegments;

            val productId = list[1]
            val bundle = Bundle()
            bundle.putString("productId", productId)

            openMainActivityDeepLink(bundle)
        } else if (path != null && path.contains("/categories/", ignoreCase = true)) {
            val list = deepLink.pathSegments;

            val categoryType = "cid"
            val categoryId = list[1]
            val categoryName = list[2]
            val bundle = Bundle()
            bundle.putString("categoryType", categoryType)
            bundle.putString("categoryId", categoryId)
            bundle.putString("categoryName", categoryName)

            openMainActivityDeepLink(bundle)

        } else if (path != null && path.contains("/suppliers", ignoreCase = true)) {
            val list = deepLink.pathSegments;

            val categoryType = "supplier_ids"
            val categoryId = list[1]
            val categoryName = list[2]
            val bundle = Bundle()
            bundle.putString("categoryType", categoryType)
            bundle.putString("categoryId", categoryId)
            bundle.putString("categoryName", categoryName)
            openMainActivityDeepLink(bundle)


        }
    }

    private fun handleDeeplinkLocal(url: String) {

        val url = url?.trim()
        val bundle = Bundle()
        if (url != null) {
            val list = url.split("/")
            /* Request code */when {
                url.contains(DeeplinkEnum.products.toString(),true) -> {
                    bundle.putString("productId", list[2])
                }
                url.contains("product-details", true) -> {
                    bundle.putString("productId", list[3])
                }
                url.contains(
                    DeeplinkEnum.Categories.toString(),
                    true
                ) || url.contains(DeeplinkEnum.category.toString(), true) -> {
                    if (url.contains("type", true)) {
                        bundle.putString("categoryId", list[3])
                        bundle.putString("categoryName", getString(R.string.product_list))
                        if (url.contains("type=category", true)) {
                            bundle.putString("categoryType", "cid")
                        } else if (url.contains("type=brand", true)) {
                            bundle.putString("categoryType", "supplier_ids")
                        }
                    } else {
                        bundle.putString("categoryType", "cid")
                        bundle.putString("categoryId", list[2])
                        bundle.putString("categoryName", list[3])
                    }
                }
                url.contains(
                    DeeplinkEnum.supplier.toString(),
                    true
                ) || url.contains(DeeplinkEnum.suppliers.toString(), true) -> {
                    bundle.putString("categoryType", "supplier_ids")
                    bundle.putString("categoryId", list[2])
                    bundle.putString("categoryName", list[3])
                }
                url.contains(DeeplinkEnum.myorder.toString(), true) -> {
                    bundle.putString(DeeplinkConstants.ORDER_ID_HOLDER, list[2])
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.ORDER_TYPE_HOLDER
                    )
                }
                //https://tatayab.com/EG-ar/user/credit
                url.contains(DeeplinkEnum.myWallet.toString(), true) || url.contains(DeeplinkEnum.credit.toString(), true) -> {
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.WALLET_TYPE_HOLDER
                    )
                }
                url.contains(DeeplinkEnum.mycart.toString(),true) -> {
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.CART_TYPE_HOLDER
                    )
                }
            }
            openMainActivityDeepLink(bundle)
        }

    }

    private fun openMainActivityDeepLink(bundle: Bundle) {
        val intent = Intent(this, MainActivity::class.java)
//        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
//        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
//        intent.flags = Intent.FLAG_ACTIVITY_SINGLE_TOP
//        intent.flags = Intent.FLAG_ACTIVITY_NO_HISTORY
        intent.putExtras(bundle)
        startActivity(intent)
        finish()
    }

    @Nullable
    private fun getDeepLink(): String? {
        try {
            val intent = intent
            return if (intent != null && intent.data != null) {
                if (intent.data?.toString()?.contains("type", true)!!) {
                    intent.data?.path + "/" + intent.data?.query
                } else {
                    intent.data?.path
                }
            } else ""
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return ""
    }


    private fun getDeepLinkQueryParameter(key: String): String? {
        val intent = intent
        return if (intent != null && intent.data != null) {
            intent.data!!.getQueryParameter(key)
        } else null
    }


}
