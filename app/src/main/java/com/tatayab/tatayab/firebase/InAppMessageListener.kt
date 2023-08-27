package com.tatayab.tatayab.firebase

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.google.firebase.inappmessaging.*
import com.google.firebase.inappmessaging.model.Action
import com.google.firebase.inappmessaging.model.InAppMessage
import com.tatayab.tatayab.deeplink.DeeplinkEnum
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.deeplink.DeeplinkConstants

class InAppMessageListener(context: Context) : FirebaseInAppMessagingClickListener,
    FirebaseInAppMessagingImpressionListener, FirebaseInAppMessagingDisplayErrorListener,
    FirebaseInAppMessagingDisplay {
    override fun displayMessage(inAppMessage: InAppMessage, p1: FirebaseInAppMessagingDisplayCallbacks) {
        val metadata = inAppMessage.getCampaignMetadata()

        val stringHashMap = inAppMessage.data
        for (name in stringHashMap!!.keys) {
            val key = name.toString()
            val value = stringHashMap!!.get(name)!!.toString()
         }
    }

    lateinit var contxt : Context
    init {
        contxt = context

    }
    override fun messageClicked(inAppMessage: InAppMessage, action: Action) {

        /*
        * messageClicked
  url : http://tatayab.com/Categories/50/Mubkhars
  metadata /getCampaignId : 13150444941224181760
  metadata /getCampaignName : Draft campaign
  metadata /getIsTestMessage: false
  inAppMessage /toString : com.google.firebase.inappmessaging.model.CardMessage@3bd61a18
  inAppMessage /getImageUrl : null
  inAppMessage /getCampaignName : Draft campaign
  inAppMessage /getMessageType : CARD
  inAppMessage /getBody : com.google.firebase.inappmessaging.model.Text@903d59a5
  inAppMessage /getData :
 url http://tatayab.com/products/5349/hags
        * */
        // Determine which URL the user clicked

        val url = action.getActionUrl()

//        Real Code
        // Handel URL in button bundle
        handelButtonAction(url!!)
         // Get general information about the campaign
        val metadata = inAppMessage.getCampaignMetadata()
        val stringHashMap = inAppMessage.data
        for (name in stringHashMap!!.keys) {
            val key = name.toString()
            val value = stringHashMap!!.get(name)!!.toString()
            Log.d("messageClicked" , "$key : $value")
         }


    }

    private fun handelButtonAction(url: String) {

        val url = url?.trim()
        val bundle = Bundle()
        if (url != null) {
            val intentMain = Intent(contxt, MainActivity::class.java)
            val list = url.split("/")
            /* Request code */when {
                url.contains(DeeplinkEnum.products.toString(),true) -> {
                    bundle.putString("productId", list[4])
                }
                url.contains("product-details", true) -> {
                    bundle.putString("productId", list[5])
                }
                url.contains(DeeplinkEnum.Categories.toString(),true)|| url.contains(DeeplinkEnum.category.toString(),true) -> {
                    if (url.contains("type", true)) {
                        bundle.putString("categoryId", list[5])
                        bundle.putString("categoryName", contxt.getString(R.string.product_list))
                        if (url.contains("type=category", true)) {
                            bundle.putString("categoryType", "cid")
                        } else if (url.contains("type=brand", true)) {
                            bundle.putString("categoryType", "supplier_ids")
                        }
                    } else {
                        bundle.putString("categoryType", "cid")
                        bundle.putString("categoryId", list[4])
                        bundle.putString("categoryName", list[5])
                    }
                }
                url.contains(DeeplinkEnum.supplier.toString(),true) || url.contains(DeeplinkEnum.suppliers.toString(),true) -> {
                    bundle.putString("categoryType", "supplier_ids")
                    bundle.putString("categoryId", list[4])
                    bundle.putString("categoryName", list[5])
                }
                url.contains(DeeplinkEnum.myorder.toString(),true) -> {
                     bundle.putString(DeeplinkConstants.ORDER_ID_HOLDER, list[4])
                    bundle.putString(DeeplinkConstants.DEEPLINK_TYPE_HOLDER,DeeplinkConstants.ORDER_TYPE_HOLDER )
                 }
                url.contains(DeeplinkEnum.myWallet.toString(),true) || url.contains(DeeplinkEnum.credit.toString(), true)-> {
                      bundle.putString(DeeplinkConstants.DEEPLINK_TYPE_HOLDER,DeeplinkConstants.WALLET_TYPE_HOLDER )
                 }
                url.contains(DeeplinkEnum.mycart.toString(),true) -> {
                    bundle.putString(
                        DeeplinkConstants.DEEPLINK_TYPE_HOLDER,
                        DeeplinkConstants.CART_TYPE_HOLDER
                    )
                }
            }
            if(bundle != null){
                intentMain.putExtras(bundle)
                contxt.startActivity(intentMain)
            }
        }

    }

    override fun impressionDetected(inAppMessage: InAppMessage) {
        val metadata = inAppMessage.getCampaignMetadata()
        val stringHashMap = inAppMessage.getData()
        for (name in stringHashMap!!.keys) {
            val key = name.toString()
            val value = stringHashMap!!.get(name)!!.toString()
            Log.d("impressionDetected" , "$key : $value")
        }
    }

    override fun displayErrorEncountered(
        inAppMessage: InAppMessage,
        inAppMessagingErrorReason: FirebaseInAppMessagingDisplayCallbacks.InAppMessagingErrorReason
    ) {
         Log.d("displayErrorEncountered" , inAppMessagingErrorReason.toString())
    }

}