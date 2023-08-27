package com.tatayab.tatayab.ordertracking


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
import kotlinx.android.synthetic.main.fragment_privacy.privacy_web
import kotlinx.android.synthetic.main.fragment_track_external_order.*
import kotlinx.android.synthetic.main.toolbar_with_back.*


class TrackExternalOrderFragment : BaseFragment() {

    private val url by lazy {
        arguments?.let {
            TrackExternalOrderFragmentArgs.fromBundle(
                it
            ).url
        } ?:""
    }

    override fun layoutId(): Int {
        return R.layout.fragment_track_external_order
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initComponent()

    }


    @SuppressLint("SetJavaScriptEnabled")
    private fun initComponent() {
        tv_title.text = getText(R.string.trck_external_order)
        web_view_track.settings.javaScriptEnabled = true
        web_view_track.settings.domStorageEnabled = true
        web_view_track.settings.builtInZoomControls = true
        web_view_track.settings.displayZoomControls = false
        web_view_track.settings.javaScriptCanOpenWindowsAutomatically = true
        web_view_track.settings.allowContentAccess = true
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(web_view_track, true)
        } else {
            CookieManager.getInstance().setAcceptCookie(true)
        }
        web_view_track.loadUrl(url)
        web_view_track.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                setProgress(View.GONE)
                refresh?.isRefreshing
            }
        }
    }

}
