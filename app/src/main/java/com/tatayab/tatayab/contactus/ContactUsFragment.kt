package com.tatayab.tatayab.contactus

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProviders
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.remote.util.Constants.Companion.SUPPORT_EMAIL
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.util.FirebaseConfigUtil
import kotlinx.android.synthetic.main.fragment_contact_us.*
import zendesk.chat.Chat
import zendesk.chat.ChatConfiguration
import zendesk.chat.ChatEngine
import zendesk.messaging.MessagingActivity
import java.lang.Exception
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class ContactUsFragment : BaseFragment() {

    lateinit var mainViewModel: MainActivityViewModel
    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory

    override fun layoutId(): Int {
        return R.layout.fragment_contact_us
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intComponent()
    }

    private fun intComponent() {


        whatsappTextView.setSafeOnClickListener {
            openWhatsAppChat()
        }

        callUsTextView.setSafeOnClickListener {
            openDialer()
        }

        sendMailTextView.setSafeOnClickListener {
            sendEmail()
        }

        liveChatTextView.setSafeOnClickListener {
            openLiveChat()
        }
    }

    /**
     * Get Random whatsApp number and open whatsApp chat on this
     * number
     */
    private fun openWhatsAppChat() {
        var whatsAppNumber = FirebaseConfigUtil().getRandomWhatsAppNumber()
        if (!whatsAppNumber.isNullOrEmpty()) {
            val url = "https://api.whatsapp.com/send?phone=$whatsAppNumber"
            val i = Intent(Intent.ACTION_VIEW)
            i.data = Uri.parse(url)
            startActivity(i)
        }
    }

    private fun openLiveChat() {
//        val intent = Intent(activity, LiveChatActivity::class.java)
//        startActivity(intent)

        Chat.INSTANCE.init(
            requireActivity(),
            "7jOWKyvNtIEZIVThx7R9YXLSkkeE3na2",
            "3fd95bf85347ab077952069b6c7739a360335644af93ce19"
        )


        val chatConfiguration = ChatConfiguration.builder()
            .withAgentAvailabilityEnabled(false)
            .build()

        MessagingActivity.builder()
            .withEngines(ChatEngine.engine())
            .withToolbarTitle(getString(R.string.chat_activity_title))
            .withBotLabelString(getString(R.string.app_name))
            .show(requireActivity(), chatConfiguration)
    }

    private fun openDialer() {
        var phoneNumber = getRandomContactUsFromConfig()
        if(phoneNumber.isNullOrEmpty()) return
        val intent = Intent(Intent.ACTION_DIAL)
        intent.data = Uri.parse("tel:$phoneNumber")
        startActivity(intent)
    }

    private fun getRandomContactUsFromConfig(): String {
        var  contactUsList = getContactUsPerCountry(mainViewModel.getCountryCode())
        if(!contactUsList.isNullOrEmpty()){
            val randomIndex = Random().nextInt(contactUsList.size)
            if (randomIndex >= 0 && randomIndex < contactUsList.size)
                return contactUsList[randomIndex]
        }else{
            var  contactUsListForKW = getContactUsPerCountry("KW")
            if(!contactUsListForKW.isNullOrEmpty()){
                val randomIndex = Random().nextInt(contactUsListForKW.size)
                if (randomIndex >= 0 && randomIndex < contactUsListForKW.size)
                    return contactUsListForKW[randomIndex]
            }
        }

        return ""
    }

    private fun getContactUsPerCountry(countryCode: String): ArrayList<String> {
        var list = FirebaseConfigUtil.mContactNumberPerCountryList
        var returningList = ArrayList<String>()
       if(!list.isNullOrEmpty()){
           list.map {
               if(it.country.equals(countryCode,true)){
                   returningList = it.phoneNumbers!!
               }
           }
       }
        return returningList
    }

    private fun sendEmail() {
        try {
            val intent =
                Intent(Intent.ACTION_VIEW, Uri.parse("mailto:" + SUPPORT_EMAIL))
            startActivity(intent)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


}

