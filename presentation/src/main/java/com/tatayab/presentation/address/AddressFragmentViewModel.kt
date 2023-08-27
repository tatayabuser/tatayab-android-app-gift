package com.tatayab.presentation.address

import android.text.TextUtils
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.tatayab.domain.interactor.address.*
import com.tatayab.domain.interactor.auth.Register
import com.tatayab.domain.interactor.cart.AddBillingAddressToCartExecution
import com.tatayab.domain.interactor.cart.AddGuestEmailToCartExecution
import com.tatayab.domain.interactor.cart.AddShippingAddressToCartExecution
import com.tatayab.domain.repository.TatayabRepository
import com.tatayab.model.requests.Address
import com.tatayab.model.requests.AddressRequest
import com.tatayab.model.requests.RegisterRequestBody
import com.tatayab.model.responses.AddressResponse
import com.tatayab.model.responses.AreaModel
import com.tatayab.model.responses.AuthenticationResponse
import com.tatayab.model.responses.CityModel
import com.tatayab.model.responses.graph_responses.AddGuestEmailToCartResponse
import com.tatayab.model.responses.graph_responses.ShippingAddressRequest
import com.tatayab.model.responses.graph_responses.ShippingAddressResponse
import com.tatayab.presentation.SingleLiveEvent
import com.tatayab.presentation.Utils
import com.tatayab.presentation.Utils.Companion.GUEST_USER_TYPE
import com.tatayab.presentation.base.BaseViewModel
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.state.Resource
import com.tatayab.presentation.state.ResourceState
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableObserver

class AddressFragmentViewModel constructor(
    private val addAddress: AddAddress,
    private val mGetCities: GetCities,
    private val mGetArea: GetArea,
    private val getAddresses: GetCustomerAddresses,
    private val deleteAddress: DeleteAddress,
    private val repository: TatayabRepository,
    private val register: Register,
    private val getGuestLastAddress: GetGuestLastAddress,
    private val saveGuestAddress: SaveGuestAddress,
    private val nAddShippingAddressToCartExecution: AddShippingAddressToCartExecution,
    private val mAddBillingAddressToCartExecution: AddBillingAddressToCartExecution,
    private val mAddGuestEmailToCartExecution: AddGuestEmailToCartExecution,
    private val languageCod: String
) : BaseViewModel(repository) {

    var ENABLE_GRAPH_QUERIES_CALLS = false

    private val addAddressLiveData = SingleLiveEvent<Resource<AddressResponse>>()

    private val currentUserLiveData = MutableLiveData<Resource<AuthenticationResponse>>()

    private val guestLastAddressLiveData = SingleLiveEvent<Resource<Address>>()

    private val deleteAddressLiveData = MutableLiveData<Resource<AddressResponse>>()

    private val addressesLiveData = MutableLiveData<Resource<List<AddressRequest>>>()

    private val updateAddressLiveData = SingleLiveEvent<Resource<AddressResponse>>()

    private val citiesLiveData = MutableLiveData<Resource<List<CityModel>>>()

    private val areaLiveData = MutableLiveData<Resource<List<AreaModel>>>()
    private val blockLiveData = MutableLiveData<Boolean>()
    val getAddressLiveData: SingleLiveEvent<Resource<AddressResponse>>
        get() = addAddressLiveData

    val getBlockLiveData: LiveData<Boolean>
        get() = blockLiveData

    val getAddressesLiveData: LiveData<Resource<List<AddressRequest>>>
        get() = addressesLiveData

    val getDeleteAddressesLiveData: LiveData<Resource<AddressResponse>>
        get() = deleteAddressLiveData

    val getUpdateAddressesLiveData: SingleLiveEvent<Resource<AddressResponse>>
        get() = updateAddressLiveData

    val getCitiesLiveData: LiveData<Resource<List<CityModel>>>
        get() = citiesLiveData

    val getAreaLiveData: LiveData<Resource<List<AreaModel>>>
        get() = areaLiveData

    val getCurrentUserLiveData: LiveData<Resource<AuthenticationResponse>>
        get() = currentUserLiveData

    val getGuestLastAddressLiveData: SingleLiveEvent<Resource<Address>>
        get() = guestLastAddressLiveData


    private val selectAddressLiveData = SingleLiveEvent<Resource<AuthenticationResponse>>()
    private val setBillingAddressLiveData = SingleLiveEvent<Resource<Boolean>>()

    val getSelectAddressLiveData: SingleLiveEvent<Resource<AuthenticationResponse>>
        get() = selectAddressLiveData
    val getBillingAddressLiveData: SingleLiveEvent<Resource<Boolean>>
        get() = setBillingAddressLiveData

    private val selectedAddressChangeLiveData = SingleLiveEvent<Boolean>()

    val getSelectedAddressChangeLiveData: SingleLiveEvent<Boolean>
        get() = selectedAddressChangeLiveData


    init {
        getCities()
    }

    fun changeCheckoutWithNewAddress() {
        selectedAddressChangeLiveData.postValue(true)
    }

    fun getCurrentUser() {
        currentUserLiveData.postValue(
            Resource(
                data = repository.getUserFromCache().blockingGet(),
                status = ResourceState.SUCCESS
            )
        )
    }

    fun getGuestLastAddress() {
        guestLastAddressLiveData.postValue(
            Resource(
                data = getGuestAddress(),
                status = ResourceState.SUCCESS
            )
        )
    }


    fun addAddress(
        addressRequest: AddressRequest,
        index: Int = 0,
        isGraphEnable: Boolean = false,
        isFromCheckOut: Boolean = false
    ) {
        addressRequest.user_id = getUserId()
        getUserName().split(" ").also {
            addressRequest.first_name = if (it.isNotEmpty()) it[0] else ""
            addressRequest.last_name = if (it.size > 1) it[1] else ""
        }
        addressRequest.o_country_code = getCountryCode()
        addAddressLiveData.postValue(Resource(ResourceState.LOADING))
        addAddress.execute(
            AddAddressSubscriber(
                addAddressLiveData,
                index,
                isGraphEnable,
                addressRequest,
                isFromCheckOut
            ),
            AddAddress.Params.forAddress(
                addressRequest
            )
        )
    }

    lateinit var languageCode: String

    fun setLangauge(languageCod: String) {
        languageCode = languageCod
    }


    private fun getGuestAddress(): Address {
        return repository.getGuestAddressFromCache().toObservable().blockingFirst()
    }

    fun setGuestAddress(address: RegisterRequestBody?) {
        val guestAddress = Address(
            o_phone = address?.phone?:"",
            o_block = address?.o_block?:"",
            o_zipcode = address?.o_zipcode?:"",
            o_address = address?.o_address?:"",
            user_name = address?.firstname?:"",
            o_email = address?.email?:"",
            o_name = address?.o_address_name?:"",
            o_address_type = address?.addr_type?:"",
            o_city = address?.o_city?:"",
            o_area = address?.o_area?:"",
            o_area_code = address?.o_area_code?:"",
            city_name = address?.o_city?:"",
            o_street = address?.o_street?:"",
            o_state = address?.o_state?:"",
            o_extra = address?.o_extra?:"",
            o_area_id = address?.o_areaId ?:"",
            o_city_id = address?.o_city_id?:""
        )
        saveGuestAddress.execute(
            SaveGuestAddressSubscriber(),
            SaveGuestAddress.Params.forGuest(guestAddress)
        )
    }


    fun getCities() {
        citiesLiveData.postValue(Resource(ResourceState.LOADING))
        mGetCities.execute(
            CitiesSubscriber(citiesLiveData),
            GetCities.Params.forAddress(
                languageCod, getCountryCode()
            )
        )
    }

    fun getAreas(cityId: Int, cityCode:String) {
        areaLiveData.postValue(Resource(ResourceState.LOADING))
        mGetArea.execute(
            AreaSubscriber(areaLiveData),
            GetArea.Params.forAddress(
                languageCode, getCountryCode(), cityId,cityCode
            )
        )
    }

    fun updateAddress(
        addressRequest: AddressRequest,
        index: Int = 0,
        isGraphEnable: Boolean? = false,
        fromCheckout: Boolean? = false) {
        addressRequest.user_id = getUserId()
        addressRequest.o_country_code = getCountryCode()

        if (fromCheckout == true) {
            if (isGraphEnable == true) {
                setBillingAddressLiveData.postValue(Resource(ResourceState.LOADING))

                val request = RegisterRequestBody(
                    o_address = addressRequest.o_address.toString(),
                    o_address_name = addressRequest.o_address_name.toString(),
                    o_area = addressRequest.o_area.toString(),
                    o_area_code = addressRequest.o_area_code.toString(),
                    o_city = addressRequest.o_city.toString(),
                    o_city_id = addressRequest?.cityId.toString(),
                    phone = addressRequest?.o_phone.toString(),
                    o_block = addressRequest.o_block.toString(),
                    o_neighborhood = addressRequest?.o_neighborhood.toString(),
                    o_zipcode = addressRequest.o_zipcode.toString(),
                    firstname = addressRequest.first_name.toString(),
                    lastname = addressRequest.last_name.toString(),
                    lang_code = languageCod,
                    cityName = addressRequest?.o_city.toString(),
                    o_street = addressRequest.o_street.toString(),
                    o_extra = addressRequest.o_extra.toString(),
                    email = getUserEmail(),
                    o_areaId = addressRequest.areaId.toString(),
                    addr_type = addressRequest.addr_type//,
                    //keep_secret = addressRequest.keep_secret!!
                )
                selectUserAddress(
                    isGraphEnable = isGraphEnable,
                    token = "",
                    selectedGuestAddressRequest = request
                )
            }else{
                updateAddressLiveData.postValue(Resource(ResourceState.LOADING))
                addAddress.execute(
                    AddAddressSubscriber(updateAddressLiveData, index, isGraphEnable!!, addressRequest),
                    AddAddress.Params.forAddress(
                        addressRequest
                    )
                )
            }
        } else {
            updateAddressLiveData.postValue(Resource(ResourceState.LOADING))
            addAddress.execute(
                AddAddressSubscriber(updateAddressLiveData, index, isGraphEnable!!, addressRequest),
                AddAddress.Params.forAddress(
                    addressRequest
                )
            )

        }
    }

//              }else{
//                //Edit the address but for Graoh
//                addAddress.execute(
//                    AddAddressSubscriber(
//                        updateAddressLiveData,
//                        index,
//                        isGraphEnable,
//                        addressRequest
//                    ),
//                    AddAddress.Params.forAddress(
//                        addressRequest
//                    )
//                )
//            }
//        } else {
//            addressRequest.user_id = getUserId()
//            addressRequest.o_country_code = getCountryCode()
//            addAddress.execute(
//                AddAddressSubscriber(updateAddressLiveData, index,
//                    isGraphEnable == true, addressRequest),
//                AddAddress.Params.forAddress(
//                    addressRequest
//                )
//            )
//        }

    fun getAddresses() {
        addressesLiveData.postValue(Resource(ResourceState.LOADING))
        getAddresses.execute(
            GetAddAddressesSubscriber(),
            GetCustomerAddresses.Params.forUser(
                getUserId(),
                getCountryCode(),
                languageCod
            )
        )
    }

    fun deleteAddress(addressId: String, index: Int) {
        deleteAddressLiveData.postValue(Resource(ResourceState.LOADING))
        deleteAddress.execute(
            DeleteAddressesSubscriber(index),
            DeleteAddress.Params.forAddress(
                addressId = addressId,
                userId = getUserId()
            )
        )
    }


    inner class SaveGuestAddressSubscriber() : DisposableCompletableObserver() {
        override fun onComplete() {
            Log.d("onComplete save address","complete success")
            //saveUserSettingLiveData.postValue(Resource(status = ResourceState.SUCCESS, data = true))
        }

        override fun onError(e: Throwable) {
            Log.d("onComplete save address",e.toString())
        }
    }


    inner class AddAddressSubscriber(
        val addressLiveData: MutableLiveData<Resource<AddressResponse>>,
        val index: Int = 0,
        val isGraphEnable: Boolean,
        val addressRequest: AddressRequest,
        val isFromCheckOut: Boolean = false
    ) : DisposableObserver<AddressResponse>() {
        override fun onError(e: Throwable) {
            addressLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }

        override fun onComplete() {
        }

        override fun onNext(t: AddressResponse) {
            t.itemIndex = index
            if(t?.message.isNullOrBlank()){
            if (isFromCheckOut) {
                val request = RegisterRequestBody(
                    o_address = addressRequest.o_address.toString(),
                    o_address_name = addressRequest.o_address_name.toString(),
                    o_area = addressRequest.o_area.toString(),
                    o_city = addressRequest.o_city.toString(),
                    o_city_id =if(addressRequest?.areaId.isNullOrBlank().not() && addressRequest?.areaId.equals("-1").not()) addressRequest?.areaId.toString() else addressRequest?.cityId.toString(),
                    phone = addressRequest?.o_phone.toString(),
                    o_block = addressRequest.o_block.toString(),
                    o_neighborhood = addressRequest?.o_neighborhood.toString(),
                    o_zipcode = addressRequest.o_zipcode.toString(),
                    firstname = addressRequest.first_name.toString(),
                    lastname = addressRequest.last_name.toString(),
                    lang_code = languageCode,
                    cityName = addressRequest?.o_city.toString(),
                    o_street = addressRequest.o_street.toString(),
                    o_extra = addressRequest.o_extra.toString(),
                    o_areaId =  if(addressRequest?.areaId.isNullOrBlank()  || addressRequest?.areaId.equals("-1")) "" else  addressRequest.cityId.toString(),
                    addr_type = addressRequest.addr_type,
                    email = ""
                    )
                request.isAreaOneLevel = addressRequest.isAreaOneLevel
                selectUserAddress(
                    isGraphEnable = isGraphEnable,
                    token = "",
                    selectedGuestAddressRequest = request
                )
            } else {
                addressLiveData.postValue(Resource(ResourceState.SUCCESS, t))
            }
        }else{
                addressLiveData.postValue(Resource(ResourceState.ERROR,message =  t?.message.toString()))
            }
        }
    }

    inner class CitiesSubscriber(
        val citiesLiveData: MutableLiveData<Resource<List<CityModel>>>
    ) : DisposableObserver<List<CityModel>>() {
        override fun onError(e: Throwable) {
            citiesLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }

        override fun onComplete() {
        }

        override fun onNext(t: List<CityModel>) {
            citiesLiveData.postValue(Resource(ResourceState.SUCCESS, t))
        }
    }

    inner class AreaSubscriber(
        val areaLiveData: MutableLiveData<Resource<List<AreaModel>>>
    ) : DisposableObserver<List<AreaModel>>() {
        override fun onError(e: Throwable) {
            areaLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }

        override fun onComplete() {
        }


        override fun onNext(t: List<AreaModel>) {
            areaLiveData.postValue(Resource(ResourceState.SUCCESS, t))
        }
    }


    inner class GetAddAddressesSubscriber : DisposableObserver<ArrayList<AddressRequest>>() {
        override fun onNext(t: ArrayList<AddressRequest>) {
            t.let {
                addressesLiveData.postValue(
                    Resource(
                        ResourceState.SUCCESS,
                        data = t.filter { it.o_country_code == getCountryCode() }
                    )
                )
            }
        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            addressesLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }
    }

    override fun onCleared() {
        getAddresses.dispose()
        addAddress.dispose()
        super.onCleared()
    }


    fun getSelectedAreaCountFromList(
        citiesList: java.util.ArrayList<CityModel>,
        cityId: Int
    ): Int {
        if (cityId > 0) {
            citiesList.let {
                it.forEach {
                    if (it.city_id == cityId) {
                        return it.area_count!!
                    }
                }
            }
        }
        return 0
    }


    inner class DeleteAddressesSubscriber(val index: Int) : DisposableObserver<AddressResponse>() {
        override fun onNext(t: AddressResponse) {
            t.itemIndex = index
            deleteAddressLiveData.postValue(Resource(data = t, status = ResourceState.SUCCESS))
        }

        override fun onComplete() {
        }

        override fun onError(e: Throwable) {
            deleteAddressLiveData.postValue(
                Resource(
                    ResourceState.ERROR,
                    message = e.localizedMessage
                )
            )
        }
    }

    fun selectUserAddress(
        selectedGuestAddressRequest: RegisterRequestBody,
        token: String,
        isGraphEnable: Boolean) {
        selectedGuestAddressRequest.country_code = getCountryCode()
        selectedGuestAddressRequest.device_id = Utils.DEVICE_UID
        selectedGuestAddressRequest.reg_type = if (isUserLogin(isGraphEnable)) "" else GUEST_USER_TYPE
        setBillingAddressLiveData.postValue(Resource(status = ResourceState.LOADING))
//        if (isGraphEnable) {
            val mShippingAddressRequest = ShippingAddressRequest(
                firstname = selectedGuestAddressRequest.firstname,
                lastname = selectedGuestAddressRequest.lastname.toString(),
                street = selectedGuestAddressRequest.o_street,
                city = selectedGuestAddressRequest.o_city,
                region = if (selectedGuestAddressRequest.o_area_code.isNullOrBlank()) " " else selectedGuestAddressRequest.o_area_code,
                postcode = selectedGuestAddressRequest.o_zipcode,
                country_code = selectedGuestAddressRequest.country_code,
                telephone = selectedGuestAddressRequest.phone,
                address_name = selectedGuestAddressRequest.o_address_name,
                address = selectedGuestAddressRequest.o_address,
                extra = selectedGuestAddressRequest.o_extra,
                city_id = selectedGuestAddressRequest.o_city_id.toString(),
                region_id = selectedGuestAddressRequest.o_areaId,
                addr_type = selectedGuestAddressRequest.addr_type,
                isAreaOneLevel=selectedGuestAddressRequest?.isAreaOneLevel
            )
            if(MemoryCacheManager.getCartId().isNullOrBlank()){
                val cartId : String? =  if (isUserLogin(isGraphEnable))
                    repository?.getUserCartIdFromCache()?.toObservable()?.map { t: String ->
                        t
                    }?.blockingSingle()

                else  repository?.getGuestCartIdFromCache()?.toObservable()?.map { t: String ->
                    t }?.blockingSingle()
                MemoryCacheManager.setCartId(cartId)
                if (cartId != null) {
                    mShippingAddressRequest.cartId = cartId
                }
                        addBillingAddressToCart(selectedGuestAddressRequest, mShippingAddressRequest)
            }else{
                mShippingAddressRequest.cartId = MemoryCacheManager.getCartId()
                addBillingAddressToCart(selectedGuestAddressRequest, mShippingAddressRequest)
            }




//        }
//    else {
//            register.execute(
//                SelectAddressubscriber(selectedGuestAddressRequest),
//                Register.Params.forUser(selectedGuestAddressRequest, languageCode)
//            )
//        }

    }

    private fun addShippingAddressToCart(
        selectedGuestAddressRequest: RegisterRequestBody,
        mShippingAddressRequest: ShippingAddressRequest
    ) {
        nAddShippingAddressToCartExecution.execute(
            AddShippingAddressToCartSubscriber(
                selectedGuestAddressRequest,
                mShippingAddressRequest
            ),
            AddShippingAddressToCartExecution.Params.execute(mShippingAddressRequest)
        )
    }

    private fun addBillingAddressToCart(
        selectedGuestAddressRequest: RegisterRequestBody,
        mShippingAddressRequest: ShippingAddressRequest
    ) {
        mAddBillingAddressToCartExecution.execute(
            AddBillingAddressToCartSubscriber(
                selectedGuestAddressRequest,
                mShippingAddressRequest
            ),
            AddBillingAddressToCartExecution.Params.execute(mShippingAddressRequest)
        )
    }


    inner class SelectAddressubscriber(val address: RegisterRequestBody?) :
        DisposableObserver<AuthenticationResponse>() {
        override fun onError(e: Throwable) {
            setBillingAddressLiveData.postValue(
                Resource(
                    status = ResourceState.ERROR,
                    message = e.localizedMessage,
                    throwable = e
                )
            )

            setGuestAddress(
                address
            )
        }

        override fun onNext(t: AuthenticationResponse) {
            setBillingAddressLiveData.postValue(Resource(status = ResourceState.SUCCESS))
            setGuestAddress(address)
        }

        override fun onComplete() {
        }

    }

    inner class AddBillingAddressToCartSubscriber(
        val address: RegisterRequestBody,
        val mShippingAddressRequest: ShippingAddressRequest
    ) :
        DisposableObserver<ShippingAddressResponse>() {
        override fun onError(e: Throwable) {
            setBillingAddressLiveData.postValue(
                Resource(
                    status = ResourceState.ERROR,
                    message = e.localizedMessage,
                    throwable = e
                )
            )
            setGuestAddress(
                address
            )
        }

        override fun onNext(t: ShippingAddressResponse) {
            if (t?.errorsListModel.isNullOrEmpty()) {
                addShippingAddressToCart(address, mShippingAddressRequest)
            } else {
                setBillingAddressLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR,
                        message = t?.errorsListModel?.get(0)?.message.toString()
                    )
                )
            }
        }

        override fun onComplete() {
        }

    }

    inner class AddShippingAddressToCartSubscriber(
        val address: RegisterRequestBody,
        val cartId: ShippingAddressRequest
    ) :
        DisposableObserver<ShippingAddressResponse>() {
        override fun onError(e: Throwable) {
            setBillingAddressLiveData.postValue(
                Resource(
                    status = ResourceState.ERROR,
                    message = e.localizedMessage,
                    throwable = e
                )
            )
            setGuestAddress(
                address
            )
        }

        override fun onNext(t: ShippingAddressResponse) {
            if (t?.errorsListModel.isNullOrEmpty()) {
                if (isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)) {
                    setBillingAddressLiveData.postValue(Resource(status = ResourceState.SUCCESS))
                } else {
                    // call set guest email to cart
                    setGuestAddress(address)
                    if (address?.email?.isNullOrBlank()!!.not() && cartId.cartId.isNullOrBlank()
                            .not() && !isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)
                    ) {
                        mAddGuestEmailToCartExecution.execute(
                            AddGuestEmailToCartSubscriber(),
                            AddGuestEmailToCartExecution.Params.execute(
                                cartId = cartId.cartId,
                                email = address?.email!!
                            )
                        )
                    }
                }
            } else {
                setBillingAddressLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR,
                        message = t?.errorsListModel?.get(0)?.message.toString()
                    )
                )
            }
        }

        override fun onComplete() {
        }

    }

    inner class AddGuestEmailToCartSubscriber(
    ) :
        DisposableObserver<AddGuestEmailToCartResponse>() {
        override fun onError(e: Throwable) {
            setBillingAddressLiveData.postValue(
                Resource(
                    status = ResourceState.ERROR,
                    message = e.localizedMessage,
                    throwable = e
                )
            )
        }

        override fun onNext(t: AddGuestEmailToCartResponse) {
            if (t?.errorsListModel.isNullOrEmpty()) {
                setBillingAddressLiveData.postValue(Resource(status = ResourceState.SUCCESS))
            } else {
                setBillingAddressLiveData.postValue(
                    Resource(
                        status = ResourceState.ERROR,
                        message = t?.errorsListModel?.get(0)?.message.toString()
                    )
                )
            }
        }

        override fun onComplete() {
        }

    }

    fun checkBlockStatusBasedOnCountry() {
        when (getCountryCode()) {
            "SA", "sa", "KW", "kw", "BH", "bh", "OM", "om" -> {
                blockLiveData.value = true
            }
            else -> {
                blockLiveData.value = false
            }
        }
    }

    fun isAnewCountry(): Boolean {
        when (getCountryCode()) {
            "SA", "sa", "KW", "kw", "BH", "bh", "OM", "om" -> {
                return false
            }
            else -> {
                return true
            }
        }
    }

    fun convertStringToInt(value: String): Int {
        return if (!value.isNullOrEmpty() && TextUtils.isDigitsOnly(value)) value.toInt() else 0
    }

    fun isANumber(value: String): Boolean {
        return (!value.isNullOrEmpty() && TextUtils.isDigitsOnly(value))
    }

    fun getAreaNameById(areaList: ArrayList<AreaModel>, selectedAreaId: Int): String? {
        if (!areaList.isNullOrEmpty()) {
            for (areaModel in areaList) {
                if (areaModel.area_id == selectedAreaId) {
                    return if (languageCod.equals(
                            "ar",
                            true
                        )
                    ) areaModel?.name_ar else areaModel?.name_en
                }
            }
        } else {
            return ""
        }
        return ""
    }


}
