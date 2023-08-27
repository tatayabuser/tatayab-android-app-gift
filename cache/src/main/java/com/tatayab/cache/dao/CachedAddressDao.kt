package com.tatayab.cache.dao

import androidx.room.*
import com.tatayab.cache.constants.AddressConstants.DELETE_ADDRESSES
import com.tatayab.cache.constants.AddressConstants.DELETE_ADDRESSES_FOR_USER
import com.tatayab.cache.constants.AddressConstants.QUERY_EXISTS
import com.tatayab.cache.constants.AddressConstants.QUERY_SET_NOT_PRIMARY_ADDRESSES_FOR_USER
import com.tatayab.cache.constants.AddressConstants.QUERY_SET_PRIMARY_ADDRESSES_FOR_USER
import com.tatayab.cache.constants.AddressConstants.SELECT_ADDRESSES_FOR_USER
import com.tatayab.cache.constants.AddressConstants.SELECT_ADDRESS_BY_ID
import com.tatayab.cache.model.CachedAddress
import io.reactivex.Flowable
import io.reactivex.Single

@Dao
abstract class CachedAddressDao {

    @Query(QUERY_EXISTS)
    abstract fun cachedAddressesExist(): Single<Int>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract fun insertAddresses(addresses: List<CachedAddress>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract fun insertAddress(addresses: CachedAddress)

    @Query(SELECT_ADDRESSES_FOR_USER)
    abstract fun getAllAddressesForUser(userId: String): Flowable<List<CachedAddress>>

    @Query(SELECT_ADDRESS_BY_ID)
    abstract fun getAddressById(addressId: String): Flowable<CachedAddress>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    @JvmSuppressWildcards
    abstract fun updateAddress(cachedAddress: CachedAddress)

    @Query(DELETE_ADDRESSES)
    abstract fun deleteAllAddresses()

    @Query(DELETE_ADDRESSES_FOR_USER)
    abstract fun deleteAddressFromCache(addressId: Long)

    @Query(QUERY_SET_PRIMARY_ADDRESSES_FOR_USER)
    abstract fun setAddressAsPrimaryCache(userId: String, addressId: String)

    @Query(QUERY_SET_NOT_PRIMARY_ADDRESSES_FOR_USER)
    abstract fun setAddressAsNotPrimaryCache(userId: String, addressId: String)


    /*@Query(QUERY_IS_PRIMARY_ADDRESS)
    abstract fun getBookmarkedProjects(): Flowable<List<CachedProject>>
     */

    //@Query(QUERY_UPDATE_PRIMARY_ADDRESS_STATUS)
    //abstract fun setPrimaryAddressStatus(isPrimary: Boolean, userId: String)
}
