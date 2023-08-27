package com.tatayab.tatayab.insiderSDK

import android.text.TextUtils
import com.tatayab.model.responses.CartOrderResponse
import com.useinsider.insider.Insider
import com.useinsider.insider.InsiderIdentifiers
import com.useinsider.insider.InsiderProduct
import java.util.*
import kotlin.collections.HashMap


open class InsiderManager {

    companion object {

        open var ITEMS_PURCHASED: List<CartOrderResponse>? = null

        open fun addProductToCart(
            productID: String?,
            productName: String?,
            taxonomy: Array<String>?,
            imageURL: String?,
            price: Double?,
            currency: String?
        ) {
            try {
                if (!TextUtils.isEmpty(productID) && !TextUtils.isEmpty(productName)) {
                    var finialtaxonomy = taxonomy
                    if (taxonomy.isNullOrEmpty()) {
                        finialtaxonomy = arrayOf(productName!!)
                    }
                    var insiderExampleProduct = Insider.Instance.createNewProduct(
                        productID,
                        productName,
                        finialtaxonomy,
                        imageURL,
                        price!!,
                        currency
                    )
                    insiderExampleProduct.setVoucherName("Tatayab")
                    Insider.Instance.itemAddedToCart(insiderExampleProduct)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: addProductToCart/ Exception/ " + e.message)

            }
        }


        open fun removeProductFromCar(productID: String?) {
            try {
                 Insider.Instance.itemRemovedFromCart(productID)
            } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: removeProductFromCar/ Exception/ " + e.message)
            }
        }

        open fun addUser(email: String, phone: String, userId: String) {
            try {
                 val identifiers = InsiderIdentifiers()
                identifiers.addEmail(email)
                identifiers.addPhoneNumber(phone)
                identifiers.addUserID(userId)
                Insider.Instance.currentUser.login(identifiers)
            } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: addUser/ Exception/ " + e.message)
            }

        }

        open fun cartCleared() {
            try {
                 Insider.Instance.cartCleared()
            } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: cartCleared/ Exception/ " + e.message)
            }
        }

        open fun visitListingPage(taxonomy: Array<String>?) {
            try {
                 Insider.Instance.visitListingPage(taxonomy)
            } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: visitListingPage/ Exception/ " + e.message)
            }
        }

        open fun visitHomePage() {
            try {
                Insider.Instance.visitHomePage()
                sendCustomEvent(
                    CustomEvent.session_start.toString(),
                    null
                )
              sendCustomEvent(
                    CustomEvent.session_start_from_push.toString(),
                    null
                )
             } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: visitHomePage/ Exception/ " + e.message)
            }
        }

        open fun visitCartPage(insiderProductsList: ArrayList<InsiderProduct>) {
            try {
                 Insider.Instance.visitCartPage(insiderProductsList.toTypedArray())
            } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: visitCartPage/ Exception/ " + e.message)
            }
        }

        open fun sendCustomEvent(eventname: String, parameters: HashMap<String, Any>?) {
            try {
                val insiderExampleEvent = Insider.Instance.tagEvent(eventname)
                if (!parameters .isNullOrEmpty()) {
                    for ((key, value) in parameters) {
                        if (value is String)
                            insiderExampleEvent.addParameterWithString(key, value)
                        else if (value is Int)
                            insiderExampleEvent.addParameterWithInt(
                                key,
                                value
                            ) else if (value is Double)
                            insiderExampleEvent.addParameterWithDouble(
                                key,
                                value
                            ) else if (value is Boolean)
                            insiderExampleEvent.addParameterWithBoolean(key, value)
                    }
                }
                insiderExampleEvent.build()
            } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: sendCustomEvent/ Exception/ " + e.message)
            }
        }

        open fun sendCenterMessage(
            limit: Int,
            startDate: Date,
            endtDate: Date,
            sendCenterMessageListener: SendCenterMessageListener
        ) {
            try {
                Insider.Instance.getMessageCenterData(
                    limit, startDate, endtDate
                ) { messageCenterData ->
                    println("INSIDER SDK: sendCenterMessages/: $messageCenterData")
                    if (sendCenterMessageListener != null && messageCenterData != null) sendCenterMessageListener.getAllCenterMessage(
                        messageCenterData
                    )
                }
            } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: sendCenterMessage/ Exception/ " + e.message)
            }
        }


        open fun openProductDetails(
            productID: String?,
            productName: String?,
            taxonomy: Array<String>?,
            imageURL: String?,
            price: Double?,
            currency: String?
        ) {
            try {
                if (!TextUtils.isEmpty(productID) && !TextUtils.isEmpty(productName)) {
                    var finialtaxonomy = taxonomy
                    if (taxonomy.isNullOrEmpty()) {
                        finialtaxonomy = arrayOf(productName!!)
                    }
                    var insiderProduct = Insider.Instance.createNewProduct(
                        productID,
                        productName,
                        finialtaxonomy,
                        imageURL,
                        price!!,
                        currency
                    )
                    insiderProduct.setVoucherName("Tatayab")
                    Insider.Instance.visitProductDetailPage(insiderProduct)
                }
                visitListingPage(taxonomy)
            } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: openProductDetails/Exception/ " + e.message)
            }
        }


        open fun itemPurchased(
            orderId: String?,
            productID: String?,
            productName: String?,
            taxonomy: Array<String>?,
            imageURL: String?,
            price: Double?,
            currency: String?
        ) {
            try {
                var finialtaxonomy = taxonomy
                if (taxonomy.isNullOrEmpty()) {
                    finialtaxonomy = arrayOf(productName!!)
                }
                if (!TextUtils.isEmpty(productID) && !TextUtils.isEmpty(productName)) {
                    var insiderProduct = Insider.Instance.createNewProduct(
                        productID,
                        productName,
                        finialtaxonomy,
                        imageURL,
                        price!!,
                        currency
                    )
                    insiderProduct.setVoucherName("Tatayab")
                    Insider.Instance.itemPurchased(orderId, insiderProduct)
                }
            } catch (e: Exception) {
                e.printStackTrace()
                println("INSIDER SDK: itemPurchased/Exception/ " + e.message)
            }
        }

        fun changeLanguage(languageValue : String){
            if(languageValue.isNullOrEmpty()) return
            Insider.Instance.currentUser.setCustomAttributeWithString("user_language", languageValue);
        }

        fun changeCountry(countryValue : String){
            if(countryValue.isNullOrEmpty()) return
            Insider.Instance.currentUser.setCustomAttributeWithString("user_country", countryValue);
        }
    }

     enum class CustomEvent {
        category_visited,
        subcategory_visited,
        searched,
        add_to_fav,
        remove_from_fav,
        login,
        register,
        logout,
        coupon_used,
        session_start,
        session_start_from_push
    }
}