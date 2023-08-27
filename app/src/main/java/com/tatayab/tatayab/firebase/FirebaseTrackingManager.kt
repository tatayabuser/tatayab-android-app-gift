package com.tatayab.tatayab.firebase

import android.content.Context
import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import com.tatayab.presentation.Utils.CheckOutAction.action
import java.lang.Exception

class FirebaseTrackingManager {


    companion object {
        val add_to_cart = "add_to_cart"
        val add_to_wishlist = "add_to_wishlist"
        val share_product = "share_product"
        val shop_by_brand = "shop_by_brand"
        val SEARCH_ACTION_EVENT = "search_actions"

        //new
        val SEARCH_PAGE_EVENT = "search_page"
        val REMOVE_FROM_CART_EVENT = "remove_from_cart"


        fun trackProductDetailsFromSearch(context: Context, productId: String, action: String?) {
           try{ val parameters = Bundle()
            productId?.let {
                parameters.putString("productId", it)
            }
            action?.let {
                parameters.putString("action", it)
            }
            FirebaseAnalytics.getInstance(context).logEvent(
                SEARCH_ACTION_EVENT,
                parameters
            )
        }catch (e:Exception){
            e.printStackTrace()
        }
        }

        fun removeProductFromCar(context: Context, productId: String?="") {
            try {
                val parameters = Bundle()
                productId?.let {
                    parameters.putString("productId", it)
                }
                action?.let {
                    parameters.putString("action", REMOVE_FROM_CART_EVENT)
                }
                FirebaseAnalytics.getInstance(context).logEvent(
                    REMOVE_FROM_CART_EVENT,
                    parameters
                )
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
        fun addProductToCar(context: Context, productId: String?="") {
            try{
            val parameters = Bundle()
            productId?.let {
                parameters.putString("productId", it)
            }
            action?.let {
                parameters.putString("action", add_to_cart)
            }
            FirebaseAnalytics.getInstance(context).logEvent(
                add_to_cart,
                parameters
            )
            }catch (e:Exception){
                e.printStackTrace()
            }
        }

        fun visitSearchScreen(context: Context) {
            try{
            val parameters = Bundle()
            action?.let {
                parameters.putString("action", SEARCH_ACTION_EVENT)
            }
            FirebaseAnalytics.getInstance(context).logEvent(
                SEARCH_PAGE_EVENT,
                parameters
            )
            }catch (e:Exception){
                e.printStackTrace()
            }
        }
    }


}