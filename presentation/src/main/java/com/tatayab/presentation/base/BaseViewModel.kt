package com.tatayab.presentation.base

import androidx.lifecycle.ViewModel
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.responses.AuthenticationResponse
import java.math.BigDecimal
import javax.inject.Inject

open class BaseViewModel @Inject constructor(private val repository: TatayabRepository) :
    ViewModel() {

    fun getCurrencyId(): String {
        if (!MemoryCacheManager.getCurrencyId().isNullOrEmpty()) {
            return MemoryCacheManager.getCurrencyId()
        } else {
            var currencyId =
                repository.getUserSettingFromCache().blockingGet().country!!.currency_id.toString()
            MemoryCacheManager.addCurrencyId(currencyId)
            return currencyId
        }
    }


    fun getCurrencyCode(): String {
        if (!MemoryCacheManager.getCurrencyCode().isNullOrEmpty()) {
            return MemoryCacheManager.getCurrencyCode()
        } else {
            var currencyCode =
                repository.getUserSettingFromCache().blockingGet().country?.currency_code.toString()

            MemoryCacheManager.addCurrencyCode(currencyCode)
            return currencyCode
        }
    }

    fun isShouldShowShippingMethod(): Boolean {
        try {
            return repository.getUserSettingFromCache()
                .blockingGet().country?.show_custom_message == true
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        return false
    }

    fun setCurrencyCode(currencyCode: String?) {
        MemoryCacheManager.addCurrencyCode(currencyCode ?: "")
    }

    fun getCountryCode(): String {
        if (!MemoryCacheManager.getCountryCode().isNullOrEmpty()) {
            return MemoryCacheManager.getCountryCode()
        } else {
            var countryCode =
                repository.getUserSettingFromCache().blockingGet().country!!.code.toString()

            MemoryCacheManager.AddCountryCode(countryCode)
            return countryCode
        }
    }

    fun getCityCode(): String {
        if (!MemoryCacheManager.getCityCode().isNullOrEmpty()) {
            return MemoryCacheManager.getCityCode()
        } else {
            /*var countryCode =
                repository.getUserSettingFromCache().blockingGet().country!!.code.toString()*/
            var citycode=""

           // MemoryCacheManager.AddCountryCode(countryCode)
            return citycode
        }
    }

    fun getCountryName(): String {
        var countryName = ""
        try {
            countryName = repository.getUserSettingFromCache().blockingGet().country!!.name.toString()

        }catch (e:Exception){
            e.printStackTrace()
        }
        return countryName
    }
    fun getPhoneLenght(): String {
        var phoneLenght = ""
        try {
            phoneLenght = repository.getUserSettingFromCache().blockingGet().country!!.phone_lenght

        }catch (e:Exception){
            e.printStackTrace()
        }
        return phoneLenght
    }

    fun isCountryGCC(): Boolean {
        var location = repository.getUserSettingFromCache().blockingGet().country?.location
        return location.isNullOrBlank().not() && location.equals("gcc")
    }


    fun getDecimalNumbers(): Int {
        if (MemoryCacheManager.getDecimalNumbers() > 0) {
            return MemoryCacheManager.getDecimalNumbers()
        } else {
            var decimalNumbers =
                repository.getUserSettingFromCache().blockingGet()?.country?.decimals!!.toInt()
            MemoryCacheManager.addDecimalNumbers(decimalNumbers)
            return decimalNumbers
        }
    }

    fun isUserLogin(isGraphEnable: Boolean): Boolean {
        if (isGraphEnable) {
            val token =
                repository.getUserFromCache().toObservable().map { t -> t.token }.blockingSingle()
            return !token.isNullOrBlank()
        } else {
            val id =
                repository.getUserFromCache().toObservable().map { t -> t.user_id }.blockingSingle()
            return id > 0
        }

    }

    fun getUserId(): String {
        val userId =
            repository.getUserFromCache().toObservable().map { t -> t.user_id }.blockingSingle()
        return userId.toString()
    }

    fun getUserInfo(): AuthenticationResponse {
        return repository.getUserFromCache().toObservable().blockingSingle()
    }

    fun getCurrentUserToken(): String {
        val userToken =
            repository.getUserFromCache().toObservable().map { t -> t.token }.blockingSingle()
        return userToken.toString()
    }

    fun getUserEmail(): String {
        val email =
            repository.getUserFromCache().toObservable().map { t -> t.email }.blockingSingle()
        return email.toString()
    }

    fun getUserName(): String {
        val name =
            repository.getUserFromCache().toObservable().map { t -> t.firstname }.blockingSingle()
        return name.toString()
    }

    fun getUserFirstToken(): String {
        val token =
            repository.getUserAuthFromCache().toObservable().map { t -> t.token }.blockingSingle()
        return token.toString()
    }

    fun getUserIdOrGuestUserID(): String {
        val user =
            repository.getUserFromCache().toObservable().blockingSingle()
        return if (user.user_id > 0) user.user_id.toString()
        else
            user.guestuser_id.toString()
    }

    fun getUserTokenFromCache(): String {
        val user =
            repository.getUserFromCache().toObservable().blockingSingle()
        return if (user.token.isNullOrBlank().not()) user.token
        else
            ""
    }

    fun validatePhone(phone: String): String {
        try {
            if (phone.isNullOrEmpty()) return ""
            val newPhone = BigDecimal(phone).toString()
            val countryINfo = repository.getUserSettingFromCache().blockingGet()
            val phoneLengths = countryINfo.country?.phone_lenght?.split(",")
            if (countryINfo?.country?.phone_lenght.isNullOrEmpty() || countryINfo?.country?.phone_code.isNullOrEmpty()) return "1"
            if (isLengthCorrect(phoneLengths, newPhone)) {
                val startWithNumbers = countryINfo.country?.phone_start?.split(",")
                return if (startWithNumbers?.contains(newPhone.first().toString())!!)
                    "1"
                else
                    return countryINfo.country?.phone_lenght + "&" + countryINfo.country?.phone_start
            } else
                return countryINfo?.country?.phone_lenght + "&" + countryINfo.country?.phone_start
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return ""
    }

    private fun isLengthCorrect(phoneLengths: List<String>?, phone: String): Boolean {
        return (phoneLengths.isNullOrEmpty() || phoneLengths.get(0)
            .isNullOrEmpty()) || (phone.isNotEmpty() && (phoneLengths?.contains(phone.length.toString())!!))
    }


    fun getCountryPhoneCode(): String {
        if (!MemoryCacheManager.getCountryPhoneCode().isNullOrEmpty()) {
            println("MEMORY_MANAGER :/getCountryPhoneCode if: " + MemoryCacheManager.getCountryPhoneCode())
            return MemoryCacheManager.getCountryInfo().phone_code
        } else {
            var countryPhoneCode =
                repository.getUserSettingFromCache().blockingGet().country?.phone_code!!
            MemoryCacheManager.addCountryPhoneCode(countryPhoneCode)
            println("MEMORY_MANAGER :/getCountryPhoneCode else " + countryPhoneCode)
            return countryPhoneCode
        }
    }

    fun getCountryFlagUrl(): String {
        if (!MemoryCacheManager.getCountryFlagUrl().isNullOrEmpty()) {
            return MemoryCacheManager.getCountryFlagUrl()
        } else {
            var countryFlagUrl =
                repository.getUserSettingFromCache().blockingGet().country?.flag!!
            MemoryCacheManager.addCountryFlag(countryFlagUrl)
            return countryFlagUrl
        }
    }

    fun clearMemoryCache() {
        MemoryCacheManager.clearMemoryCache()
        println("MEMORY_MANAGER :/clearMemoryCache  ")
    }

}