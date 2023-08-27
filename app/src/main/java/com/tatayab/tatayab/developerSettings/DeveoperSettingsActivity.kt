package com.tatayab.tatayab.developerSettings

import android.app.Activity
import android.content.Intent
import android.os.Bundle
 import android.view.View
import android.widget.AdapterView
import com.tatayab.remote.util.Constants.Companion.CURRENT_SEARCH_URL
import com.tatayab.remote.util.Constants.Companion.CURRENT_SERVER_PASS
import com.tatayab.remote.util.Constants.Companion.CURRENT_SERVER_URL
import com.tatayab.remote.util.Constants.Companion.CURRENT_SERVER_USER
import com.tatayab.remote.util.Constants.Companion.CURRENT_USER_SERVER_URL
import com.tatayab.remote.util.Constants.Companion.CURRENT_WALLET_SERVER_URL
import com.tatayab.remote.util.Constants.Companion.SEARCH_URL
import com.tatayab.remote.util.Constants.Companion.SEARCH_URL_DEV
import com.tatayab.remote.util.Constants.Companion.USER_SERVER_URL
import com.tatayab.remote.util.Constants.Companion.USER_SERVER_URL_DEV
import com.tatayab.remote.util.Constants.Companion.WALLET_SERVER_URL
import com.tatayab.remote.util.Constants.Companion.WALLET_SERVER_URL_DEV
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.util.AnimationUtil
import com.tatayab.tatayab.util.DialogUtil
 import kotlinx.android.synthetic.main.activity_developer_settings.*

class DeveoperSettingsActivity : Activity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_developer_settings)
        initServer()
    }

    private fun initServer() {
        progress_bar_view.visibility = View.GONE
        customUrlView.visibility = View.GONE
        urlEditText.setText(CURRENT_SERVER_URL)
        userNameEditText.setText(CURRENT_SERVER_USER)
        restartButton.setOnClickListener {
            progress_bar_view.visibility = View.VISIBLE
            if (customUrlView.visibility == View.VISIBLE) {
                var serverUrl = urlEditText.text.toString()
                var serverUserName = userNameEditText.text.toString()
                var serverPassword = passwordEditText.text.toString()
                if (!serverUrl.isNullOrEmpty() && !serverUserName.isNullOrEmpty() && !serverPassword.isNullOrEmpty()) {
                    saveServerInCache(ServerModel("", serverUrl, serverUserName, serverPassword))
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    DialogUtil().showCustomDialog(
                        this,
                        false,
                        "Add All Fields Data.!",
                        DialogUtil.MessageType.SUCCESS
                    )
                }
            } else {
                startActivity(Intent(this, MainActivity::class.java))
            }
        }
        var serverList = getServersList()
        val res = resources

        var serverAdapter = ServerSpinnerAdapter(this, R.layout.item_server, serverList, res)
        serverSpinner.adapter = serverAdapter
        serverSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>,
                view: View?,
                position: Int,
                id: Long
            ) {
                if (position == 4) {
                    customUrlView.visibility = View.VISIBLE
                    AnimationUtil.springAnimateAddToCart(customUrlView)

                } else {
                    customUrlView.visibility = View.GONE
                    saveServerInCache(serverList.get(position))
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>) {

            }
        }
        serverSpinner.setSelection(getCurrentServerPoisition(serverList))
    }

    private fun getCurrentServerPoisition(serverList: java.util.ArrayList<ServerModel>): Int {
        for ((i, item) in serverList.withIndex()) {
            if (item.url.equals(CURRENT_SERVER_URL, true))
                return i
        }
        return 0
    }

    private fun saveServerInCache(serverModel: ServerModel) {
        CURRENT_SERVER_URL = serverModel.url
        CURRENT_SERVER_USER = serverModel.userName
        CURRENT_SERVER_PASS = serverModel.password
        CURRENT_WALLET_SERVER_URL = serverModel.walletUrl
        CURRENT_SEARCH_URL = serverModel.searchUrl
        CURRENT_USER_SERVER_URL = serverModel.userTokenUrl
    }

    data class ServerModel(
        val name: String = "",
        val url: String = "",
        val userName: String = "",
        val password: String = "",
        val searchUrl: String = "",
        val userTokenUrl: String = "",
        val walletUrl: String = ""
        )

    private fun getServersList(): ArrayList<ServerModel> {
        var serverList = ArrayList<ServerModel>()

        var productioServer = ServerModel(
            "Live Server",
            "https://tatayab.com/",
            "android@tatayab.com",
            "5r53d11lJ594w0V1418z3J3JH71ow38T",
            SEARCH_URL,USER_SERVER_URL,WALLET_SERVER_URL
        )
        var QAServer = ServerModel(
            "QA Server",
            "https://qa.tatayab.com/",
            "android@tatayab.com",
            "5r53d11lJ594w0V1418z3J3JH71ow38T",
            SEARCH_URL_DEV,USER_SERVER_URL_DEV,WALLET_SERVER_URL_DEV
        )
        var mainServer = ServerModel(
            "Main Server",
            "https://main.tatayab.com/",
            "d.abdulmonsif@tatayab.com",
            "435xbt2GdE5909547n41603u1l4gMpY9",
            SEARCH_URL_DEV,USER_SERVER_URL_DEV,WALLET_SERVER_URL_DEV
        )
        var alphaServer = ServerModel(
            "Alpha Server",
            "https://alpha.tatayab.com/",
            "android@tatayab.com",
            "5r53d11lJ594w0V1418z3J3JH71ow38T",
            SEARCH_URL_DEV,USER_SERVER_URL_DEV,WALLET_SERVER_URL_DEV
        )
        serverList.add(productioServer)
        serverList.add(QAServer)
        serverList.add(mainServer)
        serverList.add(alphaServer)
        serverList.add(ServerModel("Custom Url"))

        return serverList
    }
}