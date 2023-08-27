package com.tatayab.cache.dao

import androidx.room.*
import com.tatayab.cache.constants.WishItemConstants.CHECK_IF_EXISTS
import com.tatayab.cache.constants.WishItemConstants.DELETE_ALL_WISH_LIST_BY_COUNTRY_ID
import com.tatayab.cache.constants.WishItemConstants.DELETE_WISH_ITEM_BY_PRODUCT_ID_AND_COUNTRY_ID
import com.tatayab.cache.constants.WishItemConstants.DELETE_WISH_LIST_TABLE
import com.tatayab.cache.constants.WishItemConstants.QUERY_ALL_WISH_LIST
import com.tatayab.cache.constants.WishItemConstants.QUERY_ALL_WISH_LIST_PER_COUNTRY
import com.tatayab.cache.constants.WishItemConstants.QUERY_EXISTS
import com.tatayab.cache.constants.WishItemConstants.QUERY_GET_WISH_ITEM_PER_PRODUCT_ID_AND_COUNRY_ID
import com.tatayab.cache.model.CachedAddress
import com.tatayab.cache.model.CachedWishItem
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
abstract class CachedWishDao {

    @Query(QUERY_EXISTS)
    abstract fun cachedWishItemExist(): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWishList(  wishItem: List<CachedWishItem>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    abstract fun insertWishItem(wishItem: CachedWishItem)

    @Query(QUERY_ALL_WISH_LIST_PER_COUNTRY)
    abstract fun getAllWishListPerCountryId(countryId: String): Flowable<List<CachedWishItem>>

    @Query(QUERY_ALL_WISH_LIST)
    abstract fun getAllWishList(): Flowable<List<CachedWishItem>>

    @Query(QUERY_GET_WISH_ITEM_PER_PRODUCT_ID_AND_COUNRY_ID)
    abstract fun getWishItemByCountryIdAndProductId(
        countryId: String,
        productId: String
    ): Flowable<CachedWishItem>

    @Query(DELETE_WISH_LIST_TABLE)
    abstract fun deleteAllWishList()

    @Query(DELETE_WISH_ITEM_BY_PRODUCT_ID_AND_COUNTRY_ID)
    abstract fun deleteWishItemFromCache(productId: String , countryId: String)

    @Query(DELETE_ALL_WISH_LIST_BY_COUNTRY_ID)
    abstract fun deleteAllWishListForCountryFromCache(countryId: String)


    @Query(CHECK_IF_EXISTS)
    abstract fun checkifExists(productID: String,countryId: String,userId:String):Single<Int>

}
