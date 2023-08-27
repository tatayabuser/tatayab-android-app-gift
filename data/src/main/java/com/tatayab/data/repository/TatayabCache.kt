package com.tatayab.data.repository

import com.tatayab.model.*
import com.tatayab.model.db.CustomerAddress
import com.tatayab.model.db.WishItem
import com.tatayab.model.requests.Address
import com.tatayab.model.requests.CategoryRequest
import com.tatayab.model.responses.AuthenticationResponse
import com.tatayab.model.responses.OrdersResponse
import com.tatayab.model.responses.SubCategoriesResponse
import io.reactivex.*


interface TatayabCache {
    fun deleteUserFromCache(): Observable<Boolean>
    fun saveUserToCache(user: AuthenticationResponse): Completable
    fun saveUserCartIdToCache(cartId: String): Completable
    fun removeUserCartIdToCache(): Completable
    fun saveGuestCartIdToCache(cartId: String): Completable
    fun removeGuestCartIdToCache(): Completable
    fun getUserCartIdFromCache(): Maybe<String>
    fun getGuestCartIdFromCache(): Maybe<String>
    fun saveUserAuthToCache(user: UserAuth): Completable
    fun getUserAuthFromCache(): Maybe<UserAuth>
    fun getUserFromCache(): Maybe<AuthenticationResponse>
    fun saveUserSettingToCache(userSetting: UserSetting): Completable
    fun getUserSettingFromCache(): Maybe<UserSetting>
    fun getcurrentLanguageFromCache(): Maybe<String>
    fun savecurrentLanguageToCache(lang: String): Completable
    fun saveSearchSuggestionToCache(mSearchModel: SearchModel): Int
    fun saveSearchSuggestionListToCache(suggestionList: List<SearchModel>): Int
    fun getSearchSuggestionsFromCache(): Observable<MutableList<SearchModel>>
    fun getGuestAddressFromCache(): Maybe<Address>
    fun setGuestAddressFromCache(address: Address?): Completable
    fun removeItemFromCartCached(productId: String, options: Map<String, String>): Observable<Int>
    fun removeGuestAddressFromCache(): Boolean
    fun getCartItems(): Observable<MutableList<String>>
    fun clearCartCache(): Boolean
    fun clearRcentViewProducts(): Boolean
    fun getCartSize(): Observable<Int>
    fun updateProductAmount(
        productId: String,
        amount: Int,
        options: Map<String, String>
    ): Observable<Pair<Int, ArrayList<CachProductCart>?>>

    fun getCachedCartContent(): Observable<ArrayList<CachProductCart>>

    fun updateAddress(cachedCustomerAddress: CustomerAddress): Completable
    fun addAddressToCache(cachedCustomerAddress: CustomerAddress): Completable
    fun getUserAddressesFromCache(userId: String): Observable<List<CustomerAddress>>
    fun deleteAddressFromCache(addressId: Long): Completable
    fun setAddressAsPrimaryCache(userId: String, addressId: String): Completable
    fun setAddressAsNotPrimaryCache(userId: String, addressId: String): Completable
    fun insertWishItem(wishItem: WishItem): Completable
    fun getAllWishListPerCountryId(countryId: String): Observable<List<WishItem>>
    fun getWishItemByCountryIdAndProductId(
        countryId: String,
        productId: String
    ): Observable<WishItem>

    fun deleteAllWishList(): Completable
    fun deleteWishItemFromCache(countryId: String, productId: String): Completable
    fun deleteAllWishListForCountryFromCache(countryId: String): Completable
    fun getAllWishList(): Observable<List<WishItem>>
    fun checkIfExists(productId: String, countryId: String, userId: String): Single<Int>
    fun addProductToRecentView(productId: String): Completable
    fun getRecentViewProducts(): Maybe<String>
}
