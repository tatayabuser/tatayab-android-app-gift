package com.tatayab.tatayab.adjust_tracking

import com.adjust.sdk.Adjust
import com.adjust.sdk.AdjustEvent
import com.tatayab.presentation.Utils.Companion.DEVICE_UID


class AdjustTracker {


    companion object {

        val VIEW_PRODUCT_EVENT = "e4y91j"
        val ADD_TO_CART_EVENT = "3k0s6l"
        val VIEW_CART_EVENT = "dg1tw4"
        val CHECK_OUT_EVENT = "wiouwu"
        val PURCHASE_EVENT = "zey0to"
        val FIRST_ORDER_EVENT = "aj10gi"
        val SIGNUP_EVENT = "vgmz0a"

        //        PARAMATERS
        const val product_ID = "product_id"
        const val Product_Price = "product_price"
        const val Currency = "currency"
        const val Total_Paid_Amount = "Total Paid Amount"
        const val OrderId = "OrderId"
        var userId = ""
        var userEmail = ""
        var mAdjustAttributionModel: AdjustAttributionModel? = null


        fun trackEvent(
            eventId: String,
            parameters: HashMap<String, String>,
            currency: String = " "
        ) {
            var orderTotal = ""
            val adjustEvent = AdjustEvent(eventId)
            if (!parameters.isNullOrEmpty()) {
                orderTotal = parameters[Total_Paid_Amount].toString()
                for ((key, value) in parameters) {
                    adjustEvent.addPartnerParameter(key, value)
                }
                if (eventId == PURCHASE_EVENT) {
                    adjustEvent.setRevenue(
                        parameters[Total_Paid_Amount]?.replace(currency, "", true)!!.toDouble(),
                        currency
                    )
                    adjustEvent.setOrderId(parameters[OrderId])
                }
            }

            //CallBacks
            if (eventId.equals(FIRST_ORDER_EVENT)) {
                adjustEvent.addCallbackParameter("dispatch", "ttmobadjust.first_order")
                addGeneralCallbackParameter(adjustEvent, orderTotal)
            }
            if (eventId.equals(SIGNUP_EVENT)) {
                adjustEvent.addCallbackParameter("dispatch", "ttmobadjust.sign_up")
                addGeneralCallbackParameter(adjustEvent, orderTotal)
            }


            Adjust.trackEvent(adjustEvent)
            println("... Adjust tracking / eventId: " + eventId + " ==> size of params : " + parameters.size)
            if (parameters.isNotEmpty()) {
                for ((key, value) in parameters) {
                    println("... Adjust tracking / params : $key = $value")
                }
            }
        }

        private fun addGeneralCallbackParameter(adjustEvent: AdjustEvent, orderTotal: String?) {
            adjustEvent?.addCallbackParameter("device_type", "android")
            adjustEvent?.addCallbackParameter("device_id", DEVICE_UID)
            adjustEvent?.addCallbackParameter("campaign_code", mAdjustAttributionModel?.campaign)
            adjustEvent?.addCallbackParameter("user_id", userId)
            adjustEvent?.addCallbackParameter("user_email", userEmail)
            adjustEvent?.addCallbackParameter("ad_group", mAdjustAttributionModel?.adgroup)
            adjustEvent?.addCallbackParameter("ad_id", mAdjustAttributionModel?.adid)
            adjustEvent?.addCallbackParameter("click_label", mAdjustAttributionModel?.clickLabel)
            adjustEvent?.addCallbackParameter("creative", mAdjustAttributionModel?.creative)
            adjustEvent?.addCallbackParameter("network", mAdjustAttributionModel?.network)
            adjustEvent?.addCallbackParameter("tracker_name", mAdjustAttributionModel?.trackerName)
            adjustEvent?.addCallbackParameter(
                "tracker_token",
                mAdjustAttributionModel?.trackerToken
            )
            adjustEvent?.addCallbackParameter("first_order_total", orderTotal)
            adjustEvent?.addCallbackParameter("store_access_key", "private")
        }
    }

//        view_product=
//
//        1- View Product:    Done
//        Token: e4y91j
//        Parameters: product ID
//
//        2- Add to cart:   Done
//        Token: 3k0s6l
//
//        3- View Cart:     Done
//        Token: dg1tw4
//
//        4- Checkout:      Done
//        Token: wiouwu
//
//        5- Purchase:      Done
//        Token: zey0to
//        Parameter: Total Paid Amount
//
//        4- First time order:
//        Token: aj10gi
//        Parameter: Total Paid Amount.
//        Note: same Purchase event but we will add it just for the first order for each user
//
//        4- Sign up:      Done
//        Token: vgmz0a
//
    // call back
//    https://main.tatayab.com/?
//    dispatch=ttmobadjust.first_order&
// device_type=ios&
// device_id=925886A6-CB6B-4A42-99B2-893B5A312C08&
// campaign_code=ssssssss&
// user_id=50961&
// user_email=sss@aaa.ccc&
// ad_group=aaaaa&
// ad_id=3456766665t&
// click_label=placeorder&
// creative=yes&
// network=Vodafone&
// tracker_name=aaaaaaaaa&
// tracker_token=MyToken$seddf&
// store_access_key=private
}