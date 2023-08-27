package com.tatayab.tatayab.livechat

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.CookieManager
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tatayab.presentation.profile.ProfileFragmentViewModel
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnKeyboardListener
import kotlinx.android.synthetic.main.fragment_livechat.*
import kotlinx.android.synthetic.main.toolbar_livechat.*
import javax.inject.Inject


class LivechatFragment : BaseFragment() {


    @Inject
    lateinit var viewModel: ProfileFragmentViewModel

    override fun layoutId(): Int = R.layout.fragment_livechat


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel =
            ViewModelProviders.of(this, viewModelFactory).get(ProfileFragmentViewModel::class.java)
        viewModel.getUserProfileLiveData.observe(viewLifecycleOwner, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    tv_welcome.text = resources.getString(
                        R.string.welcome_chat,
                        it.data?.userProfile?.firstName ?: ""
                    )
                }
                else -> {
                }
            }
        })
        initComponent()
    }


    @SuppressLint("SetJavaScriptEnabled")
    private fun initComponent() {
        web_view_livechat.settings.javaScriptEnabled = true;
        web_view_livechat.settings.domStorageEnabled = true;
        web_view_livechat.settings.builtInZoomControls = true;
        web_view_livechat.settings.displayZoomControls = false;
        web_view_livechat.settings.javaScriptCanOpenWindowsAutomatically = true;
        web_view_livechat.settings.allowContentAccess = true;
        if (Build.VERSION.SDK_INT >= 21) {
            CookieManager.getInstance().setAcceptThirdPartyCookies(web_view_livechat, true);
        } else {
            CookieManager.getInstance().setAcceptCookie(true);
        }
        web_view_livechat.loadUrl(resources.getString(R.string.live_chat_url))
        web_view_livechat.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                setProgress(View.GONE)
            }

        }
        web_view_livechat.setKeyboardListener(object : OnKeyboardListener {
            override fun onEnter() {
                web_view_livechat.scrollTo(0, web_view_livechat.contentHeight)
            }
        })


        iv_back.setSafeOnClickListener {
            activity?.onBackPressed()
        }

    }

}
