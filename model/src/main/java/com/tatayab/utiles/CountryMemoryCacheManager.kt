package com.tatayab.utiles

class CountryMemoryCacheManager {
    companion object {
        var COMES_FROM_SHARED_CART = false
        var OPEN_WALLET_FLAG = false
        const val COUNTRY_CODE_KEY = "COUNTRY_CODE_KEY"
        const val CURRENCY_CODE_KEY = "CURRENCY_CODE_KEY"
        const val CURRENCY_ID_KEY = "CURRENCY_ID_KEY"

        var memoryCashHashMap = HashMap<String, Any>()

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
                        COUNTRY_CODE_KEY
                    )
                ) {
                    return memoryCashHashMap.get(
                        COUNTRY_CODE_KEY
                    ) as String
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
            return ""
        }

        fun AddCountryCode(currencyCode: String) {
            try {
                memoryCashHashMap.put(
                    COUNTRY_CODE_KEY, currencyCode
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
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
            return ""
        }

        fun addCurrencyId(currencyId: String) {
            try {
                memoryCashHashMap.put(
                    CURRENCY_ID_KEY, currencyId
                )
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }
        }


    }
}