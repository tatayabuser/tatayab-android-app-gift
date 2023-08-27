package com.tatayab.tatayab.refer

import android.content.Intent
import android.graphics.Paint
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tatayab.model.responses.InviteFriendResponse
import com.tatayab.presentation.referFriend.ReferFriendSuccessViewModel
import com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.auth.LoginOptionActivity
import com.tatayab.tatayab.base.BaseActivity2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import kotlinx.android.synthetic.main.activity_refer_friend_success.*
import javax.inject.Inject

open class ReferFriendSuccessActivity : BaseActivity2() {

    var invitationOwnerName: String = ""
    var invitationOwnerId: String = ""
    var invitationUrl: String = ""
    var senderCountry: String = ""
    private lateinit var viewModel: ReferFriendSuccessViewModel

    @Inject
    lateinit var viewModelFactory: ReferFriendSuccessViewModelFactory.Factory

    companion object {
        var INVITATION_URL_HOLDER = "INVITATION_URL_HOLDER"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
        super.onCreate(savedInstanceState)
        intent?.extras?.let {
            invitationUrl = it.getString(INVITATION_URL_HOLDER, "")
        }
        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactory.create(App.getPref().currentLanguage.toString())
            ).get(ReferFriendSuccessViewModel::class.java)

        if (!viewModel.isUserLogin(Constants.ENABLE_GRAPH_QUERIES_CALLS)) {
            var deepLinkIntent = Intent(this, LoginOptionActivity::class.java)
            deepLinkIntent?.putExtra(
                INVITATION_URL_HOLDER,
                invitationUrl
            )
            startActivity(deepLinkIntent)
            finish()
        }

        setContentView(R.layout.activity_refer_friend_success)
        if (!invitationUrl.isNullOrEmpty() && invitationUrl.contains("invite")) {
            extractUrl()
        }
        initView()
        viewModel.getInvitationFriendLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    showDialog(
                        it?.message + ""
                     )
                    base_loading.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    base_loading.visibility = View.GONE
                    it.data?.let {
                        updateUI(it)
                    }
                }
                else -> {
                    base_loading.visibility = View.VISIBLE
                }
            }
        })


        initAction()
    }

    private fun updateUI(mInviteFriendResponse: InviteFriendResponse) {
        mInviteFriendResponse?.let {
            if (it.status == 1) {
                it.mInviteFriendModel?.let {
                    //String text = String.format(res.getString(R.string.welcome_messages), username, mailCount);
                    var messgaeText = String.format(
                        resources.getString(R.string.refer_friend_message),
                        it?.credit.toString() + " " + it?.currancy,
                        it?.min_order_subtotal.toString() + " " + it?.currancy
                    )
                    var messageDate =
                        String.format(resources.getString(R.string.refer_friend_data), "")
                    giftTextView.text = messgaeText
                    expireDateTextView.text = messageDate
                }
            } else {
                showDialog(
                    it.errorMessage)
            }
        }
    }


    private fun extractUrl() {
        ///invite/294023/akl/uk
        var decodeURI = Uri.decode(invitationUrl)
        var urlSplitList = decodeURI.split("/")
        if (urlSplitList.size == 4) {
            invitationOwnerName = urlSplitList[3].replace("&efr=1", "")
            invitationOwnerId = urlSplitList[2]
            invitationOwnerTextView.text = invitationOwnerName
            if (!invitationOwnerId.isNullOrEmpty()) {
                viewModel.getInvitationData(invitationOwnerId.toInt(), "")
            }
        } else if (urlSplitList.size == 5) {
            invitationOwnerName = urlSplitList[3]
            senderCountry = urlSplitList[4].replace("&efr=1", "")
            invitationOwnerId = urlSplitList[2]
            invitationOwnerTextView.text = invitationOwnerName
            if (!invitationOwnerId.isNullOrEmpty()) {
                viewModel.getInvitationData(invitationOwnerId.toInt(), senderCountry)
            }
        }
    }

    private fun initAction() {
        InvitationSuccessContinueButton.setSafeOnClickListener {
            finish()
        }
        InvitationSuccessCloseButton.setSafeOnClickListener {
            finish()
        }
        var termsLink = String.format(
            resources.getString(R.string.terms_url),
            viewModel.getCountryCode(),
            App.getPref().currentLanguage.toString()
        )
        copyRightTextView.setPaintFlags(copyRightTextView.getPaintFlags() or Paint.UNDERLINE_TEXT_FLAG)

        copyRightTextView.setSafeOnClickListener {
            val browserIntent =
                Intent(Intent.ACTION_VIEW, Uri.parse(termsLink))
            startActivity(browserIntent)
        }

    }

    private fun initView() {
        // Hide tool bar
        val actionBar = supportActionBar
        actionBar?.hide()
        invitationOwnerTextView.text = invitationOwnerName
    }


}