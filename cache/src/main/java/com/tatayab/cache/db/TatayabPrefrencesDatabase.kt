package com.tatayab.cache.db


import android.content.Context
import android.content.SharedPreferences
import android.util.Log
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tatayab.cache.constants.PrefrencesConstants.KEY_USER
import com.tatayab.cache.SingletonHolder
import com.tatayab.cache.constants.PrefrencesConstants.GUEST_CART_ID_KEY
import com.tatayab.cache.constants.PrefrencesConstants.KEY_CART
import com.tatayab.cache.constants.PrefrencesConstants.KEY_GUEST_ADDRESS
import com.tatayab.cache.constants.PrefrencesConstants.KEY_LANGUAGE
import com.tatayab.cache.constants.PrefrencesConstants.KEY_RECENT_VIEW
import com.tatayab.cache.constants.PrefrencesConstants.KEY_SEARCH_SUGGESTIONS
import com.tatayab.cache.constants.PrefrencesConstants.KEY_USER_AUTH
import com.tatayab.cache.constants.PrefrencesConstants.KEY_USER_SETTING
import com.tatayab.cache.constants.PrefrencesConstants.RECENT_MAX_ITEMS
import com.tatayab.cache.constants.PrefrencesConstants.USER_CART_ID_KEY
import com.tatayab.model.*
import com.tatayab.model.requests.Address
import com.tatayab.model.responses.AuthenticationResponse
import devliving.online.securedpreferencestore.DefaultRecoveryHandler
import devliving.online.securedpreferencestore.SecuredPreferenceStore
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import java.security.KeyStore
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class TatayabPrefrencesDatabase @Inject constructor() {


    private var itemIds: ArrayList<CachProductCart>? = null
    private val gson = Gson()

    companion object : SingletonHolder<Context, TatayabPrefrencesDatabase>({
        try {
            //not mandatory, can be null too
            val storeFileName = "securedStore"
            //not mandatory, can be null too
            val keyPrefix = "vss"
            //it's better to provide one, and you need to provide the same key each time after the first time
            val seedKey = "seed".toByteArray()
            SecuredPreferenceStore.init(
                it,
                storeFileName,
                keyPrefix,
                seedKey,
                DefaultRecoveryHandler()
            )

            SecuredPreferenceStore.setRecoveryHandler(object : DefaultRecoveryHandler() {
                override fun recover(
                    e: Exception,
                    keyStore: KeyStore,
                    keyAliases: List<String>,
                    preferences: SharedPreferences
                ): Boolean {
                    return super.recover(e, keyStore, keyAliases, preferences)
                }
            })


        } catch (e: Exception) {
            // Handle error.
            e.printStackTrace()
        }
        TatayabPrefrencesDatabase()
    })

    private fun getSecure(): SecuredPreferenceStore {
        return SecuredPreferenceStore.getSharedInstance()
    }

    fun saveUser(user: AuthenticationResponse) {
        val gson = Gson()
        val json = gson.toJson(user)
        getSecure().edit().putString(KEY_USER, json).commit()
    }

    fun saveUserCartIdToCache(cartId: String) {
        getSecure().edit().putString(USER_CART_ID_KEY, cartId).commit()
    }

    fun saveGuestUESTCartIdToCache(cartId: String) {
        getSecure().edit().putString(GUEST_CART_ID_KEY, cartId).commit()
    }

    fun getUserCartIdFromCache():String {
        return getSecure().getString(USER_CART_ID_KEY, "").toString()
    }

    fun getGuestUESTCartIdFromCache():String {
        return getSecure().getString(GUEST_CART_ID_KEY, "").toString()
    }

    fun getUser(): AuthenticationResponse? {
        val gson = Gson()
        //val default = gson.toJson(UserDataObject("", NameModel("", ""), "", "", "", "")).toString()
        val json = getSecure().getString(KEY_USER, null)
        var user: AuthenticationResponse? = null
        try {
            user = gson.fromJson(json, AuthenticationResponse::class.java)

        } catch (e: Exception) {
            println("Error")
        }

        return user
    }

    fun saveUserSetting(userSetting: UserSetting):Throwable? {
        try {
        val gson = Gson()
        val json = gson.toJson(userSetting)
        getSecure().edit().putString(KEY_USER_SETTING, json).commit()
            return null
        } catch (e: Exception) {
             return e.cause
        }
    }

     fun saveUserAuth(userAuth: UserAuth) {
        try {
            val gson = Gson()
            val json = gson.toJson(userAuth)
            getSecure().edit().putString(KEY_USER_AUTH, json).commit()
            println("saveUserAuthToCache3")
        } catch (e: Exception) {
            println("saveUserAuthToCache3 /error : " + e.message)
            println("saveUserAuthToCache3 /error : " + e.localizedMessage)
        }


    }

    fun getUserAuth(): UserAuth? {
        val gson = Gson()
        val json = getSecure().getString(KEY_USER_AUTH, null)
        var userAuth: UserAuth? = null
        try {
            userAuth = gson.fromJson(json, UserAuth::class.java)
        } catch (e: Exception) {
            println("Error")
        }

        return userAuth
    }
    fun getCurrentLanguage(): String? {
         return getSecure().getString(KEY_LANGUAGE, "")
    }
    fun saveCurrentLanguage(lang: String) {
        try {
             getSecure().edit().putString(KEY_LANGUAGE, lang).commit()
         } catch (e: Exception) {
            println("savecurrentLanguage /error : " + e.message)
            println("savecurrentLanguage /error : " + e.localizedMessage)
        }
    }


    fun saveGuestAddress(address: Address?) {
        val gson = Gson()
        val json = gson.toJson(address)
        getSecure().edit().putString(KEY_GUEST_ADDRESS, json).commit()
    }


    fun removeGuestAddress(): Boolean {
        return getSecure().edit().remove(KEY_GUEST_ADDRESS).commit()
    }

    fun getUserSetting(): UserSetting? {

        val gson = Gson()
        val json = getSecure().getString(KEY_USER_SETTING, null)
        var userSetting: UserSetting? = null
        try {
            userSetting = gson.fromJson(json, UserSetting::class.java)
        } catch (e: Exception) {
            println("Error")
        }

        return userSetting

    }


    fun getGuestAddress(): Address? {

        val gson = Gson()
        val json = getSecure().getString(KEY_GUEST_ADDRESS, null)
        var address: Address? = null
        try {
            address = gson.fromJson(json, Address::class.java)
        } catch (e: Exception) {
            println("Error")
        }
        return address

    }


    fun deleteUser(): Boolean {
        return getSecure().edit().remove(KEY_USER).commit()
    }

    fun getItemsInCart(): ArrayList<CachProductCart> {
        try {
            val json = getSecure().getString(KEY_CART, "")
            val type = object : TypeToken<ArrayList<CachProductCart>>() {}.type
            itemIds = gson.fromJson<ArrayList<CachProductCart>>(json, type)
                ?: return ArrayList<CachProductCart>()

            return itemIds as ArrayList<CachProductCart>
        } catch (e: Exception) {
            Log.e("TatayabPrefrencesDB", e.toString())
        }

        return ArrayList<CachProductCart>()
    }

    fun getSearchSuggestionsFromCache(): ArrayList<SearchModel> {
        try {
            val json = getSecure().getString(KEY_SEARCH_SUGGESTIONS, "")
            val type = object : TypeToken<ArrayList<SearchModel>>() {}.type
            var searchSuggestionList = gson.fromJson<ArrayList<SearchModel>>(json, type)
                ?: return ArrayList<SearchModel>()

            return searchSuggestionList as ArrayList<SearchModel>
        } catch (e: Exception) {
            Log.e("TatayabPrefrencesDB", e.toString())
        }
        return ArrayList<SearchModel>()
    }


    fun getRecentViewProducts(): String {
        try {
            val json = getSecure().getString(KEY_RECENT_VIEW, "")
            val type = object : TypeToken<ArrayList<String>>() {}.type
            val itemIds = gson.fromJson<ArrayList<String>>(json, type)
                ?: ArrayList<String>()

            if (!itemIds.isNullOrEmpty()) {
                return itemIds.joinToString(",")
            }
        } catch (e: Exception) {
            Log.e("TatayabPrefrencesDB", e.toString())
        }
        return ""
    }


    fun addProductIdToRecentViewProducts(productId: String) {
        //  val max_items = 5
        try {
            var json = getSecure().getString(KEY_RECENT_VIEW, "")
            val type = object : TypeToken<ArrayList<String>>() {}.type
            val itemIds = gson.fromJson<ArrayList<String>>(json, type) ?: ArrayList<String>()

            itemIds.map {
                if (it == productId)
                    itemIds.remove(it)
            }
            itemIds.add(0, productId)
            if (itemIds.size > RECENT_MAX_ITEMS)
                itemIds.removeAt(RECENT_MAX_ITEMS)

            json = gson.toJson(itemIds)
            getSecure().edit().putString(KEY_RECENT_VIEW, json).commit()
            Log.d("Recent List", itemIds.toString())
        } catch (e: Exception) {
            Log.e("TatayabPrefrencesDB", e.toString())
        }

    }

    fun getItemIndexWithOptions(
        prductList: ArrayList<CachProductCart>,
        productId: String,
        options: Map<String, String>
    ): Int {
        var index = -1
        prductList.map {
            index += 1
            if (productId == it.productID) {
                if (options.isNotEmpty()) {
                    options.forEach { option ->
                        if (it.productOptions?.containsKey(option.key)!!) {
                            if (it.productOptions?.values?.first()?.variants?.get(option.key.toInt())?.variant_id == option.value)
                                return index
                        }
                    }
                } else
                    return index
            }
        }
        return -1
    }


    private fun saveCart(key: String, listOfProduct: ArrayList<CachProductCart>?): Int {
        val json = gson.toJson(listOfProduct)
        getSecure().edit().putString(key, json).apply()
        return listOfProduct?.size!!
    }

    fun removeItem(productId: String, options: Map<String, String>): Observable<Int> {
        val itemIds = getItemsInCart()
        var productToRemoved: CachProductCart? = null
        itemIds.forEach { product ->
            if (product.productID == productId) {
                if (product.productOptions?.keys == null && options.isEmpty()) {
                    productToRemoved = product
                    return@forEach
                } else if ((product.productOptions?.keys == options.keys) && (product.productOptions?.values?.map {
                        it.variants?.values?.first()?.variant_id
                    } == options.values.toList())) {
                    productToRemoved = product
                    return@forEach
                }
            }
        }
        productToRemoved?.let {
            itemIds.remove(it)
        }

        return Observable.just(saveCart(KEY_CART, itemIds))
    }

    fun updateProductAmount(
        productId: String,
        newAmount: Int,
        options: Map<String, String>
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>> {
        //return Observable.just(Pair(1, mapOf()))
        val itemIds = getItemsInCart()
        itemIds.let {
            itemIds.forEach { product ->
                val index = getItemIndexWithOptions(
                    itemIds,
                    productId,
                    options
                )  /// to compare with id and options only , amount may be different
                if (index > -1)
                    itemIds.get(index).amount = newAmount
            }
        }

        return Observable.just(Pair(saveCart(KEY_CART, itemIds), itemIds))

    }


    fun cartSize(): Observable<Int> {
        val itemIds = getItemsInCart()
        return Observable.just(itemIds.size)
    }

    fun clearCart(): Boolean {
        itemIds = null
        return getSecure().edit().remove(KEY_CART).commit()
    }


    fun clearRecentViewProduct(): Boolean {
        itemIds = null
        return getSecure().edit().remove(KEY_RECENT_VIEW).commit()
    }


    fun getItems(): Observable<MutableList<String>> {
        val itemIds = getItemsInCart()
        val items = mutableListOf<String>()
        itemIds.let { it ->
            it.forEach {
                it.let {
                    items.add(it.productID!!)
                }
            }
        }
        return Observable.just(items)
    }

    fun getSearchSuggestionListFromCache(): Observable<MutableList<SearchModel>> {
        val seguesstionList = getSearchSuggestionsFromCache()
        val seguesstionListitems = mutableListOf<SearchModel>()
        seguesstionList.let { it ->
            it.forEach {
                it.let {
                    seguesstionListitems.add(it)
                }
            }
        }
        return Observable.just(seguesstionListitems)
    }

    fun saveSearchSuggestionToCache(searchModel: SearchModel): Int {
        val seguesstionList = getSearchSuggestionsFromCache()
        val seguesstionListitems = mutableListOf<SearchModel>()
        seguesstionListitems.add(searchModel)
        seguesstionList.let { it ->
            it.forEach {
                it.let {
                    seguesstionListitems.add(it)
                }
            }
        }
        val json = gson.toJson(seguesstionListitems)
        getSecure().edit().putString(KEY_SEARCH_SUGGESTIONS, json).apply()
        return seguesstionListitems?.size!!
    }

    fun saveSearchSuggestionListToCache(suggestionList: List<SearchModel>): Int {
         val seguesstionListitems = mutableListOf<SearchModel>()
        suggestionList.let { it ->
            it.forEach {
                it.let {
                    seguesstionListitems.add(it)
                }
            }
        }
        val json = gson.toJson(seguesstionListitems)
        getSecure().edit().putString(KEY_SEARCH_SUGGESTIONS, json).apply()
        return seguesstionListitems?.size!!
    }


}