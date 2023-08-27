package com.tatayab.tatayab.privacy


import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_privacy.*
import kotlinx.android.synthetic.main.toolbar_with_back.*


class PrivacyFragment : BaseFragment() {

    private val privacyUrl by lazy {
        arguments?.let {
            PrivacyFragmentArgs.fromBundle(
                it
            ).url
        } ?: throw IllegalArgumentException("Expected arguments")
    }
    private val screenTitle by lazy {
        arguments?.let {
            PrivacyFragmentArgs.fromBundle(
                it
            ).title
        } ?: throw IllegalArgumentException("Expected arguments")
    }

    override fun layoutId(): Int {
        return R.layout.fragment_privacy
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()

        refresh.setOnRefreshListener {
            initComponent()
        }
    }


    @SuppressLint("SetJavaScriptEnabled")
    private fun initComponent() {
        if (!TextUtils.isEmpty(screenTitle)) tv_title.text = screenTitle
        privacy_web.settings.javaScriptEnabled = true
        privacy_web.settings.domStorageEnabled = true
        privacy_web.settings.builtInZoomControls = true
        privacy_web.settings.displayZoomControls = false
        privacy_web.settings.javaScriptCanOpenWindowsAutomatically = true
        privacy_web.settings.allowContentAccess = true
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(privacy_web, true)
        } else {
            CookieManager.getInstance().setAcceptCookie(true)
        }
        privacy_web.loadUrl(privacyUrl)
        privacy_web.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                setProgress(View.GONE)
                refresh?.isRefreshing
            }
        }
    }

}
