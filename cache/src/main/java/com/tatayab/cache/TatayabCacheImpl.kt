package com.tatayab.cache

import com.tatayab.cache.db.TatayabPrefrencesDatabase
import com.tatayab.cache.db.TatayabRoomDatabase
import com.tatayab.cache.mapper.CachedAddressMapper
import com.tatayab.cache.mapper.CachedUserMapper
import com.tatayab.cache.mapper.CachedWishItemMapper
import com.tatayab.data.repository.TatayabCache
import com.tatayab.model.CachProductCart
import com.tatayab.model.SearchModel
import com.tatayab.model.UserAuth
import com.tatayab.model.UserSetting
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.db.WishItem
import com.tatayab.model.requests.Address
import com.tatayab.model.responses.AuthenticationResponse
import com.tatayab.model.responses.CountryResponse
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Observable
import io.reactivex.Single
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList


class TatayabCacheImpl @Inject constructor(
    private val roomDatabase: TatayabRoomDatabase,
    private val sharedPrefDatabase: TatayabPrefrencesDatabase,
    private val addressMapper: CachedAddressMapper,
    private val userMapper: CachedUserMapper,
    private val wishItemMapper: CachedWishItemMapper
) : TatayabCache {
    override fun getAllWishList(): Observable<List<WishItem>> {
        return roomDatabase.cachedWishDao().getAllWishList().toObservable()
            .map { list -> list.map { wishItemMapper.mapFromCached(it) } }
    }

    override fun checkIfExists(productId: String, countryId: String, userId: String): Single<Int> {
        return Single.defer {
            roomDatabase.cachedWishDao().checkifExists(productId, countryId, userId)
        }
    }

    override fun addProductToRecentView(productId: String): Completable {
        return Completable.defer {
            sharedPrefDatabase.addProductIdToRecentViewProducts(productId)
            Completable.complete()
        }
    }

    override fun getRecentViewProducts(): Maybe<String> {
        return Maybe.create { emitter ->
            val recentList = sharedPrefDatabase.getRecentViewProducts()
            emitter.onSuccess(recentList)
        }
    }

    override fun insertWishItem(wishItem: WishItem): Completable {
        return Completable.defer {
            roomDatabase.cachedWishDao()
                .insertWishItem(wishItemMapper.mapToCached(wishItem))
            Completable.complete()
        }
    }

    override fun getAllWishListPerCountryId(countryId: String): Observable<List<WishItem>> {
        return roomDatabase.cachedWishDao().getAllWishListPerCountryId(countryId).toObservable()
            .map { list -> list.map { wishItemMapper.mapFromCached(it) } }
    }

    override fun getWishItemByCountryIdAndProductId(
        countryId: String,
        productId: String
    ): Observable<WishItem> {
        return roomDatabase.cachedWishDao().getWishItemByCountryIdAndProductId(countryId, productId)
            .toObservable()
            .map { wishItemMapper.mapFromCached(it) }
    }

    override fun deleteAllWishList(): Completable {
        return Completable.defer {
            roomDatabase.cachedWishDao().deleteAllWishList()
            Completable.complete()
        }
    }


    override fun deleteWishItemFromCache(productId: String, countryId: String): Completable {
        return Completable.defer {
            roomDatabase.cachedWishDao().deleteWishItemFromCache(productId, countryId)
            Completable.complete()
        }
    }

    override fun deleteAllWishListForCountryFromCache(countryId: String): Completable {
        return Completable.defer {
            roomDatabase.cachedWishDao().deleteAllWishListForCountryFromCache(countryId)
            Completable.complete()
        }
    }

    override fun getUserSettingFromCache(): Maybe<UserSetting> {
        return Maybe.create { emitter ->
            val user = sharedPrefDatabase.getUserSetting() ?: UserSetting(
                CountryResponse()
            )
            emitter.onSuccess(user)
        }
    }

    override fun saveUserSettingToCache(userSetting: UserSetting): Completable {
        return Completable.defer {
            var result = sharedPrefDatabase.saveUserSetting(userSetting)
            if (result == null) Completable.complete()
            else {
                Completable.error(result)
            }
        }
    }

    override fun getGuestAddressFromCache(): Maybe<Address> {
        return Maybe.create { emitter ->
            val address = sharedPrefDatabase.getGuestAddress() ?: Address()
            emitter.onSuccess(address)
        }
    }

    override fun setGuestAddressFromCache(address: Address?): Completable {
        return Completable.defer {
            sharedPrefDatabase.saveGuestAddress(address)
            Completable.complete()
        }
    }

    override fun deleteUserFromCache(): Observable<Boolean> {
        return Observable.just(sharedPrefDatabase.deleteUser())
    }

    override fun saveUserAuthToCache(user: UserAuth): Completable {
        println("saveUserAuthToCache2")
        return Completable.defer {
            sharedPrefDatabase.saveUserAuth(user)
            Completable.complete()
        }
    }

    override fun getUserAuthFromCache(): Maybe<UserAuth> {
        return Maybe.create { emitter ->
            val user = sharedPrefDatabase.getUserAuth() ?: UserAuth("", "", "", "android")
            emitter.onSuccess(user)
        }
    }

    override fun savecurrentLanguageToCache(lang: String): Completable {
        return Completable.defer {
            sharedPrefDatabase.saveCurrentLanguage(lang)
            Completable.complete()
        }
    }

    override fun getcurrentLanguageFromCache(): Maybe<String> {
        return Maybe.create { emitter ->
            var lang = sharedPrefDatabase.getCurrentLanguage() ?: String
            if(lang.equals(null)  || lang.equals("") || lang == null){
                lang = Locale.getDefault().getLanguage()
            }
            emitter.onSuccess(lang.toString())
        }
    }


    override fun saveUserToCache(user: AuthenticationResponse): Completable {
        return Completable.defer {
            sharedPrefDatabase.saveUser(user)
            roomDatabase.cachedUserDao().saveUser(userMapper.mapToCached(user))
            Completable.complete()
        }
    }
    override fun saveUserCartIdToCache(cartId: String): Completable{
        return Completable.defer {
            if(!cartId.isNullOrBlank()&& !cartId.replace(" ","").equals("null"))sharedPrefDatabase.saveUserCartIdToCache(cartId)
            Completable.complete()
        }
    }

    override fun removeUserCartIdToCache(): Completable {
        return Completable.defer {
            sharedPrefDatabase.saveUserCartIdToCache("")
            Completable.complete()
        }
    }

    override fun saveGuestCartIdToCache(cartId: String): Completable {
        return Completable.defer {
            if (!cartId.isNullOrBlank() && !cartId.replace(" ", "")
                    .equals("null")
            ) sharedPrefDatabase.saveGuestUESTCartIdToCache(cartId)
            Completable.complete()
        }
    }

    override fun removeGuestCartIdToCache(): Completable {
        return Completable.defer {
            sharedPrefDatabase.saveGuestUESTCartIdToCache("")
            Completable.complete()
        }
    }

    override fun getUserCartIdFromCache(): Maybe<String> {
        return Maybe.create { emitter ->
            val cartId = sharedPrefDatabase.getUserCartIdFromCache()
            emitter.onSuccess(cartId)
        }
    }

    override fun getGuestCartIdFromCache(): Maybe<String> {
        return Maybe.create { emitter ->
            val cartId = sharedPrefDatabase.getGuestUESTCartIdFromCache()
            emitter.onSuccess(cartId)
        }
    }

    override fun getUserFromCache(): Maybe<AuthenticationResponse> {
        return Maybe.create { emitter ->
            val user = sharedPrefDatabase.getUser() ?: AuthenticationResponse(user_id = 0)
            emitter.onSuccess(user)
        }
    }


    override fun removeItemFromCartCached(
        productId: String,
        options: Map<String, String>
    ): Observable<Int> {
        return sharedPrefDatabase.removeItem(productId, options)
    }

    override fun removeGuestAddressFromCache(): Boolean {
        return sharedPrefDatabase.removeGuestAddress()
    }

    override fun getCartItems(): Observable<MutableList<String>> {
        return sharedPrefDatabase.getItems()
    }

    override fun saveSearchSuggestionToCache(mSearchModel: SearchModel): Int {
        return sharedPrefDatabase.saveSearchSuggestionToCache(mSearchModel)
    }

    override fun saveSearchSuggestionListToCache(suggestionList: List<SearchModel>): Int {
        return sharedPrefDatabase.saveSearchSuggestionListToCache(suggestionList)
    }

    override fun getSearchSuggestionsFromCache(): Observable<MutableList<SearchModel>> {
        return sharedPrefDatabase.getSearchSuggestionListFromCache()
    }


    override fun clearCartCache(): Boolean {
        return sharedPrefDatabase.clearCart()
    }

    override fun clearRcentViewProducts(): Boolean {
        return sharedPrefDatabase.clearRecentViewProduct()
    }

    override fun getCartSize(): Observable<Int> {
        return sharedPrefDatabase.cartSize()
    }

    override fun updateProductAmount(
        productId: String,
        amount: Int,
        options: Map<String, String>
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>> {
        return sharedPrefDatabase.updateProductAmount(productId, amount, options)
    }

    override fun getCachedCartContent(): Observable<ArrayList<CachProductCart>> {
        return Observable.just(sharedPrefDatabase.getItemsInCart())
    }


    override fun updateAddress(cachedCustomerAddress: CustomerAddress): Completable {
        return Completable.defer {
            roomDatabase.cachedAddressesDao()
                .updateAddress(addressMapper.mapToCached(cachedCustomerAddress))
            Completable.complete()
        }
    }

    override fun addAddressToCache(
        cachedCustomerAddress: CustomerAddress
    ): Completable {
        return Completable.defer {
            roomDatabase.cachedAddressesDao()
                .insertAddress(addressMapper.mapToCached(cachedCustomerAddress))
            Completable.complete()
        }
    }


    override fun getUserAddressesFromCache(userId: String): Observable<List<CustomerAddress>> {
        return roomDatabase.cachedAddressesDao().getAllAddressesForUser(userId).toObservable()
            .map { list -> list.map { addressMapper.mapFromCached(it) } }
    }

    override fun deleteAddressFromCache(addressId: Long): Completable {
        return Completable.defer {
            roomDatabase.cachedAddressesDao().deleteAddressFromCache(addressId)
            Completable.complete()
        }
    }

    override fun setAddressAsPrimaryCache(userId: String, addressId: String): Completable {
        return Completable.defer {
            roomDatabase.cachedAddressesDao().setAddressAsPrimaryCache(userId, addressId)
            Completable.complete()
        }
    }

    override fun setAddressAsNotPrimaryCache(userId: String, addressId: String): Completable {
        return Completable.defer {
            roomDatabase.cachedAddressesDao().setAddressAsNotPrimaryCache(userId, addressId)
            Completable.complete()
        }
    }


}
