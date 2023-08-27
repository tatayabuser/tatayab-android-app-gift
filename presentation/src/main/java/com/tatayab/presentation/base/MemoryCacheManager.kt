package com.tatayab.presentation.base

import android.os.Bundle
import com.tatayab.model.ShareCartListModel
import com.tatayab.model.responses.AuthenticationResponse
import com.tatayab.model.responses.CityModel
import com.tatayab.model.responses.CountryResponse
import com.tatayab.utiles.CountryMemoryCacheManager
import javax.inject.Singleton

@Singleton
class MemoryCacheManager {
    companion object {
        var COMES_FROM_SHARED_CART = false
        var OPEN_WALLET_FLAG = false
        const val DECIMAL_NUMBERS_KEY = "DECIMAL_NUMBERS_KEY"
        const val COUNTRY_CODE_KEY = "COUNTRY_CODE_KEY"
        const val CURRENCY_CODE_KEY = "CURRENCY_CODE_KEY"
        const val CURRENCY_ID_KEY = "CURRENCY_ID_KEY"
        const val COUNTRY_PHONECODE_KEY = "COUNTRY_PHONECODE_KEY"
        const val COUNTRY_FLAG_KEY = "COUNTRY_FLAG_KEY"
        const val DEEPLINK_KEY = "DEEPLINK_KEY"
        const val REFER_FRIEND_KEY = "REFER_FRIEND_KEY"
        const val SHARE_CART_KEY = "SHARE_CART_KEY"
        const val GIFT_MODEL_KEY = "GIFT_MODEL_KEY"
        const val COUNTRY_INFO = "COUNTRY_INFO"
        const val CITY_INFO = "CITY_INFO"
        const val CURRENT_CART_COUNT_KEY = "CURRENT_CART_COUNT_KEY"
        const val USER_PROFILE_DATA = "USER_PROFILE_DATA"
        const val USER_WISHLIST_IDS = "USER_WISHLIST_IDS"
        const val CART_ID_KEY = "CART_ID_KEY"
        var mGiftModelConstant: GiftModel? = null
        var memoryCashHashMap = HashMap<String, Any>()
        var countriesList: ArrayList<CountryResponse>? = null
        var walletCredit: Float = 0.0f


        fun getCountryNameByCode(code:String):String{
            if(!countriesList.isNullOrEmpty()){
                countriesList?.map {
                    if(it.code.equals(code,true)){
                        return it?.name.toString()
                    }
                }
            }

            return ""
        }
        fun addCartCount(cartCount: Int) {
            try {
                memoryCashHashMap.put(CURRENT_CART_COUNT_KEY, cartCount)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun addGiftModel(giftModel: GiftModel?) {
            try {
                if (giftModel == null) memoryCashHashMap.remove(GIFT_MODEL_KEY)
                else
                    memoryCashHashMap.put(GIFT_MODEL_KEY, giftModel)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun getCartCount(): Int {
            try {
                if (memoryCashHashMap.containsKey(
                        CURRENT_CART_COUNT_KEY
                    )
                ) {
                    return memoryCashHashMap.get(CURRENT_CART_COUNT_KEY) as Int
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return 0
        }

        fun getGiftModel(): GiftModel? {
            try {
                if (memoryCashHashMap.containsKey(
                        GIFT_MODEL_KEY
                    )
                ) {
                    return memoryCashHashMap.get(GIFT_MODEL_KEY) as GiftModel
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }

        fun addMainBundel(bundel: Bundle) {
            try {
                memoryCashHashMap.put(DEEPLINK_KEY, bundel)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun addReferFriendUrl(link: String) {
            try {
                memoryCashHashMap.put(REFER_FRIEND_KEY, link)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun getReferFriendUrl(): String? {
            try {
                if (memoryCashHashMap.containsKey(
                        REFER_FRIEND_KEY
                    )
                ) {
                    return memoryCashHashMap.get(REFER_FRIEND_KEY) as String
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }
        fun setCartId(cartId: String?) {
            try {
                if (cartId != null) {
                    memoryCashHashMap.put(CART_ID_KEY, cartId)
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun getCartId(): String {
            try {
                if (memoryCashHashMap.containsKey(
                        CART_ID_KEY
                    )
                ) {
                    return memoryCashHashMap.get(CART_ID_KEY) as String
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        fun getMainBundel(): Bundle {
            try {
                if (memoryCashHashMap.containsKey(
                        DEEPLINK_KEY
                    )
                ) {
                    return memoryCashHashMap.get(DEEPLINK_KEY) as Bundle
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return Bundle()
        }

        fun getDecimalNumbers(): Int {
            try {
                if (memoryCashHashMap.containsKey(
                        DECIMAL_NUMBERS_KEY
                    )
                ) {
                    return memoryCashHashMap.get(
                        DECIMAL_NUMBERS_KEY
                    ) as Int
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return -1
        }

        fun addDecimalNumbers(decimalNumbers: Int) {
            try {
                memoryCashHashMap.put(
                    DECIMAL_NUMBERS_KEY, decimalNumbers
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun getCurrencyCode(): String {
            try {
                if (memoryCashHashMap.containsKey(
                        CURRENCY_CODE_KEY
                    )
                ) {
                    return memoryCashHashMap.get(
                        CURRENCY_CODE_KEY
                    ) as String
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        fun addCurrencyCode(currencyCode: String) {
            try {
                CountryMemoryCacheManager.addCurrencyCode(currencyCode)
                memoryCashHashMap.put(
                    CURRENCY_CODE_KEY, currencyCode
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun getCountryCode(): String {
            try {
                if (memoryCashHashMap.containsKey(
                        COUNTRY_INFO
                    )
                ) {
                    return (memoryCashHashMap[COUNTRY_INFO] as CountryResponse).code ?: ""
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        fun getCityCode(): String {
            try {
                if (memoryCashHashMap.containsKey(
                        CITY_INFO                    )
                ) {
                    return (memoryCashHashMap[CITY_INFO] as CityModel).code ?: ""
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }


        fun getCountryPhoneKey(): String {
            try {
                if (memoryCashHashMap.containsKey(
                        COUNTRY_PHONECODE_KEY
                    )
                ) {
                    return memoryCashHashMap.get(
                        COUNTRY_PHONECODE_KEY
                    ) as String
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        fun AddCountryCode(countryCode: String) {
            try {
                CountryMemoryCacheManager.AddCountryCode(countryCode)
                memoryCashHashMap.put(
                    COUNTRY_CODE_KEY, countryCode
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }


        fun getCurrencyId(): String {
            try {
                if (memoryCashHashMap.containsKey(
                        CURRENCY_ID_KEY
                    )
                ) {
                    return memoryCashHashMap.get(
                        CURRENCY_ID_KEY
                    ) as String
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        fun addCurrencyId(currencyId: String) {
            try {
                CountryMemoryCacheManager.addCurrencyId(currencyId)
                memoryCashHashMap.put(
                    CURRENCY_ID_KEY, currencyId
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun getCountryPhoneCode(): String {
            try {
                if (memoryCashHashMap.containsKey(
                        COUNTRY_PHONECODE_KEY
                    )
                ) {
                    return memoryCashHashMap.get(
                        COUNTRY_PHONECODE_KEY
                    ) as String
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        fun getCountryFlagUrl(): String {
            try {
                if (memoryCashHashMap.containsKey(
                        COUNTRY_FLAG_KEY
                    )
                ) {
                    return memoryCashHashMap.get(
                        COUNTRY_FLAG_KEY
                    ) as String
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        fun addCountryPhoneCode(currencyId: String) {
            try {
                memoryCashHashMap.put(
                    COUNTRY_PHONECODE_KEY, currencyId
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun addCountryFlag(flagUrl: String) {
            try {
                memoryCashHashMap.put(
                    COUNTRY_FLAG_KEY, flagUrl
                )
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun clearMemoryCache() {
            val refreFriend = getReferFriendUrl()
            val deeplinkBundel = getMainBundel()
            memoryCashHashMap.clear()
            memoryCashHashMap = HashMap<String, Any>()
            if (!refreFriend.isNullOrEmpty())
                addReferFriendUrl(refreFriend)
            if (!deeplinkBundel.isEmpty)
                addMainBundel(deeplinkBundel)
        }

        fun addShareCartModel(mShareCartListModel: ShareCartListModel?) {
            try {
                if (mShareCartListModel == null) memoryCashHashMap.remove(SHARE_CART_KEY)
                else
                    memoryCashHashMap.put(SHARE_CART_KEY, mShareCartListModel)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        fun getShareCartModel(): ShareCartListModel? {
            try {
                if (memoryCashHashMap.containsKey(
                        SHARE_CART_KEY
                    )
                ) {
                    return memoryCashHashMap.get(SHARE_CART_KEY) as ShareCartListModel
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return null
        }

        fun saveUserData(data: AuthenticationResponse?) {
            data ?: return
            memoryCashHashMap[USER_PROFILE_DATA] = data
        }

        fun getUserData(): AuthenticationResponse? =
            if (memoryCashHashMap[USER_PROFILE_DATA] == null)
                AuthenticationResponse()
            else
                memoryCashHashMap[USER_PROFILE_DATA] as AuthenticationResponse

        fun saveCountryInfo(country: CountryResponse?) {
            country ?: return
            memoryCashHashMap[COUNTRY_INFO] = country
        }

        fun getCountryInfo(): CountryResponse =
            if (memoryCashHashMap.containsKey(COUNTRY_INFO)) memoryCashHashMap[COUNTRY_INFO] as CountryResponse
            else CountryResponse()

    }
}