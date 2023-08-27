package com.tatayab.tatayab.webview

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import com.tatayab.tatayab.R
import kotlinx.android.synthetic.main.activity_webview.*
import kotlinx.android.synthetic.main.fragment_privacy.*
import kotlinx.android.synthetic.main.toolbar_with_back.*

class WebviewActivity : Activity() {

    companion object {
        val URL_HOLDER = "URL_HOLDER"
    }

    var url: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        intent?.extras?.let {
            if (it.containsKey(URL_HOLDER)){
                url = it.getString(URL_HOLDER,"")
            }
        }
        initComponent()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initComponent() {
        webView.settings.javaScriptEnabled = true
        webView.settings.domStorageEnabled = true
        webView.settings.builtInZoomControls = true
        webView.settings.displayZoomControls = false
        webView.settings.javaScriptCanOpenWindowsAutomatically = true
        webView.settings.allowContentAccess = true
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(webView, true)
        } else {
            CookieManager.getInstance().setAcceptCookie(true)
        }
       if(!url.isNullOrEmpty()) webView.loadUrl(url)
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
            }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}