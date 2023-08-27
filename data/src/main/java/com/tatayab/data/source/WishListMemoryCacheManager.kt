package com.tatayab.data.source

import android.os.Build
import androidx.annotation.RequiresApi
import com.tatayab.model.responses.graph_responses.CacheWishListItem
import com.tatayab.model.responses.graph_responses.CacheWishListItems
import java.lang.Exception
import javax.inject.Singleton

@Singleton
object WishListMemoryCacheManager {

    private const val USER_WISHLIST_PRODUCTS_IDS = "USER_WISHLIST_PRODUCTS_IDS"
    private const val USER_WISHLIST_ID = "USER_WISHLIST_ID"
    var wishListMemoryCashHashMap = HashMap<String, Any>()

    fun saveWishListItems(items: CacheWishListItems) {
        items ?: return
        wishListMemoryCashHashMap[USER_WISHLIST_PRODUCTS_IDS] = items
    }

    fun saveUserWishListId(id: String) {
        wishListMemoryCashHashMap[USER_WISHLIST_ID] = id
    }

    fun getUserWishListId(): String? {
        if (wishListMemoryCashHashMap.isNullOrEmpty()
                .not() && wishListMemoryCashHashMap.containsKey(USER_WISHLIST_ID)
        ) {
            return wishListMemoryCashHashMap[USER_WISHLIST_ID] as String
        }
        return ""
    }

    private fun getWishListItems(): CacheWishListItems? {
        return try {
            if (wishListMemoryCashHashMap.size > 0 && wishListMemoryCashHashMap?.containsKey(
                    USER_WISHLIST_PRODUCTS_IDS
                ) == true
            ) wishListMemoryCashHashMap[USER_WISHLIST_PRODUCTS_IDS] as CacheWishListItems
            else CacheWishListItems(products = emptyList())
        } catch (e: Exception) {
            CacheWishListItems(products = emptyList())
        }

    }

    fun clearWishListItems() {
        wishListMemoryCashHashMap[USER_WISHLIST_PRODUCTS_IDS] = ""
    }

    fun isProductInWishList(sku: String): Boolean? {
        val wishListMap = getWishListItems()
        if (sku.isNullOrBlank()
                .not() && wishListMap != null && wishListMap?.products.isNullOrEmpty().not()
        ) {
            wishListMap?.products?.let {
                return it?.any { it.productSku == sku }
            }
        }
        return false
    }

    fun addToWishListItems(item: Pair<String, String>) {
        try {
            val wishListMap = getWishListItems() as CacheWishListItems
            (wishListMap?.products as ArrayList<CacheWishListItem>).add(
                CacheWishListItem(
                    item.first.toInt(),
                    item.second
                )
            )
            saveWishListItems(wishListMap)
        }catch (e:Exception){
            e.printStackTrace()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    fun removeFromWishList(sku: String) {
        try{
        val wishListMap = getWishListItems()
        if (wishListMap?.products.isNullOrEmpty().not()) {
            (wishListMap?.products as ArrayList<CacheWishListItem>).removeIf { it.productSku == sku }
            saveWishListItems(wishListMap)
        }}
        catch (e:Exception){
            e.printStackTrace()
        }
    }

    fun getWishListItemId(sku:String):Int {
        return try {
            val wishListMap = getWishListItems() as CacheWishListItems
            wishListMap?.products?.filter { it.productSku == sku }?.get(0)?.wishListId ?: 0
        }catch (e:Exception){
            e.printStackTrace()
            0
        }
    }

}