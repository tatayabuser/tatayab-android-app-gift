package com.tatayab.tatayab.refer

import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.firebase.dynamiclinks.ktx.*
import com.google.firebase.ktx.Firebase
import com.tatayab.model.responses.InviteFriendResponse
import com.tatayab.presentation.referFriend.ReferFriendSuccessViewModel
import com.tatayab.presentation.referFriend.ReferFriendSuccessViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_refer.*
import java.net.URLDecoder
import javax.inject.Inject


class ReferFriendFragment : BaseFragment2() {

    private lateinit var viewModel: ReferFriendSuccessViewModel

    @Inject
    lateinit var viewModelFactory: ReferFriendSuccessViewModelFactory.Factory
    var totalCreditText: String = ""

    var currency: String? = null
    override fun layoutId(): Int {
        return R.layout.fragment_refer
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactory.create(App.getPref().currentLanguage.toString())
            ).get(ReferFriendSuccessViewModel::class.java)

        viewModel.getCheckEarnLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    base_loading?.visibility = View.GONE
                    showCustomTopMessage(
                        it?.message + "",
                        DialogUtil.MessageType.ERROR
                    )
                    inviteFriendButton.isEnabled = false
                }
                ResourceState.SUCCESS -> {
                    base_loading?.visibility = View.GONE
                    it.data?.let {
                        updateUI(it)
                        inviteFriendButton.isEnabled = true
                    }
                }
                else -> {
                    base_loading?.visibility = View.VISIBLE
                }
            }
        })

    }

    private fun updateUI(it: InviteFriendResponse) {
        try {
            it?.let {
                it?.mInviteFriendModel?.let {
                    var currency = " ".plus(it?.currancy)
                    var credit = it?.credit
                    var miniCredit = it?.min_order_subtotal
                    totalCreditText = credit.toString().plus(currency)
                    var totalMiniCreditText = miniCredit.toString().plus(currency)

                    tv_description.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Html.fromHtml(String.format(
                            resources.getString(R.string.refer_a_friend_amp_earn_5_kd),
                            totalCreditText
                        ), Html.FROM_HTML_MODE_COMPACT)
                    } else {
                        Html.fromHtml(String.format(
                            resources.getString(R.string.refer_a_friend_amp_earn_5_kd),
                            totalCreditText
                        ))
                    }
                    tv_title2.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Html.fromHtml(String.format(
                            resources.getString(R.string.earn_5_kd_to_use_on_your_next_orders),
                            totalCreditText
                        ), Html.FROM_HTML_MODE_COMPACT)
                    } else {
                        Html.fromHtml(String.format(
                            resources.getString(R.string.earn_5_kd_to_use_on_your_next_orders),
                            totalCreditText
                        ))
                    }
                    friends_gift.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Html.fromHtml( String.format(
                            resources.getString(R.string.friends_get_5_kd_off_when_they_register_and_place_first_order),
                            totalCreditText
                        ), Html.FROM_HTML_MODE_COMPACT)
                    } else {
                        Html.fromHtml( String.format(
                            resources.getString(R.string.friends_get_5_kd_off_when_they_register_and_place_first_order),
                            totalCreditText
                        ))
                    }
                     your_gift.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Html.fromHtml(String.format(
                            resources.getString(R.string.you_get_5_kwd_credit_when_they_order),
                            totalCreditText
                        ), Html.FROM_HTML_MODE_COMPACT)
                    } else {
                        Html.fromHtml(String.format(
                            resources.getString(R.string.you_get_5_kwd_credit_when_they_order),
                            totalCreditText
                        ))
                    }
                     refer_full_desc.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                        Html.fromHtml(String.format(
                            resources.getString(R.string.refer_friend_description),
                            totalCreditText,
                            totalMiniCreditText,
                            totalCreditText
                        ), Html.FROM_HTML_MODE_COMPACT)
                    } else {
                        Html.fromHtml(String.format(
                            resources.getString(R.string.refer_friend_description),
                            totalCreditText,
                            totalMiniCreditText,
                            totalCreditText
                        ))
                    }
                 }
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intComponent()
        viewModel?.checkEarn(viewModel.getUserId().toInt())
    }

    private fun intComponent() {
        inviteFriendButton.setSafeOnClickListener {
            if (!totalCreditText.isNullOrEmpty()) invitFriend(
                viewModel.getUserId(),
                viewModel.getUserName()
            )
        }

        var currency = " ".plus(viewModel?.getCurrencyCode())
        var credit = 0
        var miniCredit = 0
        totalCreditText = credit.toString().plus(currency)
        var totalMiniCreditText = miniCredit.toString().plus(currency)

        tv_description.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(String.format(
                resources.getString(R.string.refer_a_friend_amp_earn_5_kd),
                totalCreditText
            ), Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(String.format(
                resources.getString(R.string.refer_a_friend_amp_earn_5_kd),
                totalCreditText
            ))
        }
        tv_title2.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(String.format(
                resources.getString(R.string.earn_5_kd_to_use_on_your_next_orders),
                totalCreditText
            ), Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(String.format(
                resources.getString(R.string.earn_5_kd_to_use_on_your_next_orders),
                totalCreditText
            ))
        }
        friends_gift.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml( String.format(
                resources.getString(R.string.friends_get_5_kd_off_when_they_register_and_place_first_order),
                totalCreditText
            ), Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml( String.format(
                resources.getString(R.string.friends_get_5_kd_off_when_they_register_and_place_first_order),
                totalCreditText
            ))
        }
        your_gift.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(String.format(
                resources.getString(R.string.you_get_5_kwd_credit_when_they_order),
                totalCreditText
            ), Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(String.format(
                resources.getString(R.string.you_get_5_kwd_credit_when_they_order),
                totalCreditText
            ))
        }
        refer_full_desc.text = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            Html.fromHtml(String.format(
                resources.getString(R.string.refer_friend_description),
                totalCreditText,
                totalMiniCreditText,
                totalCreditText
            ), Html.FROM_HTML_MODE_COMPACT)
        } else {
            Html.fromHtml(String.format(
                resources.getString(R.string.refer_friend_description),
                totalCreditText,
                totalMiniCreditText,
                totalCreditText
            ))
        }
    }

    fun invitFriend(userId: String, userName: String) {
        try {

            val shortLinkTask = Firebase.dynamicLinks.shortLinkAsync {
                var encodeUserInfo = userId.trim().plus("/") .plus(Uri.encode(userName, "UTF-8")).plus("/").plus(viewModel.getCountryCode())
                 link = Uri.parse("https://tatayab.com/invite/$encodeUserInfo")
                domainUriPrefix = "https://tatayab.page.link"
//                var newQuery = link.query
//                if (newQuery == null) {
//                    newQuery = "efr=1"
//                } else {
//                    newQuery += "&" + "efr=1"
//                }
                // Open links with this app on Android
                androidParameters("com.tatayab.tatayab") {
                }
                // Open links with com.example.ios on iOS
                iosParameters("com.tatayab.tatayab") {
                    appStoreId = "1394093760"
                }
            }.addOnSuccessListener { (shortLink, flowchartLink) ->
                println("Akl: shortLink: " + shortLink)
                if (!shortLink.toString().isNullOrEmpty())
                    shareApp(shortLink.toString(), userName)
            }.addOnFailureListener {
                println("Akl: shortLink/error: " + it.localizedMessage)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun shareApp(shortLink: String, userName: String) {
        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        //wail Izz Al Mohammad  invited you to use Tatayab App, and you will git 5KD as a gift in your first order
        val shareBody = userName.plus(
            "\n" + String.format(
                resources.getString(R.string.invite_friend_message),
                totalCreditText
            ).plus(" $shortLink\n")
        )
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, getText(R.string.app_name))
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, getString(R.string.share_using)))
    }

}
