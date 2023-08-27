package com.tatayab.tatayab.addresses

import android.content.Intent
import android.os.Bundle
import android.text.InputFilter
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.CompoundButton
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.tatayab.model.addresses.AddressType
import com.tatayab.model.requests.Address
import com.tatayab.model.requests.AddressRequest
import com.tatayab.model.requests.RegisterRequestBody
import com.tatayab.model.responses.AreaModel
import com.tatayab.model.responses.CityModel
import com.tatayab.model.responses.SelectCityOrAreaModel
import com.tatayab.presentation.Utils
import com.tatayab.presentation.address.AddressFragmentViewModel
import com.tatayab.presentation.address.AddressFragmentViewModelFactory
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants.Companion.ENABLE_GRAPH_QUERIES_CALLS
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.addresses.ChooseCityActivity.Companion.CITIE_HOLDER
import com.tatayab.tatayab.addresses.ChooseCityActivity.Companion.START_FORE_RESULT_ID_HOLDER
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.errorHandling.ExceptionHandler
import com.tatayab.tatayab.ext.*
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.Constants.ADD_NEW_ADDRESS
import com.tatayab.tatayab.util.Constants.ADD_NEW_ADDRESS_REQUEST
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_add_address.*
import kotlinx.android.synthetic.main.toolbar_with_back.*
import timber.log.Timber
import java.util.*
import javax.inject.Inject


class AddAddressFragment : BaseFragment() {

    lateinit var viewModel: AddressFragmentViewModel

    @Inject
    lateinit var viewModelFactoryAddress: AddressFragmentViewModelFactory.Factory

    var citiesList: ArrayList<CityModel>? = null
    var areaList: ArrayList<AreaModel>? = null
    var isCityViewClicked = false
    var selectedCityId = -1
    var selectedAreaId = -1
    var selectedAddressType = "1285"
    var cityName = ""
    var areaName = ""
    var areaCode = ""
    var cityCode = ""
    var langCode = ""
    var countryCode = ""
    var selectedCityAreaCount = 0
    var isAreaOneLevel: Boolean? = false
    var keep_secret:Boolean?=false
    private val address by lazy {
        arguments?.let { AddAddressFragmentArgs.fromBundle(it).address }
    }

    private val AsAGuest by lazy {
        arguments.let { it?.let { it1 -> AddAddressFragmentArgs.fromBundle(it1).isgust } ?: false }
    }

    private val fromCheckOut by lazy {
        arguments.let {
            it?.let { it1 -> AddAddressFragmentArgs.fromBundle(it1).fromcheckout } ?: false
        }
    }

    override fun layoutId(): Int {
        return R.layout.fragment_add_address
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Utils.CheckOutAction.openAddAddress = true
        langCode = App.getPref().currentLanguage.toString()
        viewModel = ViewModelProviders.of(
            this,
            viewModelFactoryAddress.create(App.getPref().currentLanguage.toString())
        ).get(AddressFragmentViewModel::class.java)

        viewModel.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS
        countryCode = viewModel.getCountryCode()
        viewModel.setLangauge(App.getPref().currentLanguage.toString())
        viewModel.getBillingAddressLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    Timber.e("error ${it.message}")
                    animationView.visibility = View.GONE
                    var message =
                        it.throwable?.let { it1 ->
                            ExceptionHandler().getMessage(
                                it1,
                                requireContext()
                            )
                        }
                    if (it?.message.isNullOrBlank().not()) {
                        message = it?.message.toString()
                    }
                    if (message != null)
                        showCustomTopMessage(message, DialogUtil.MessageType.ERROR)
                    else
                        showCustomTopMessage(
                            getText(R.string.error_occure).toString(),
                            DialogUtil.MessageType.ERROR
                        )
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
//                    if (it.data?.user_id != null) {
                    if (fromCheckOut) {
                        Utils.CheckOutAction.action = Utils.CheckActionType.ADDRESS_UPDATED
                        findNavController().popBackStack()
                    } else {
                        Utils.CheckOutAction.action =
                            if (viewModel?.isUserLogin(ENABLE_GRAPH_QUERIES_CALLS)!!) Utils.CheckActionType.LOGIN_USER else Utils.CheckActionType.GUEST_USER
                        if (!findNavController().popBackStack(R.id.signin_options, false))
                            findNavController().popBackStack()
//                    } else
//                        showCustomTopMessage(
//                            getText(R.string.error_occure).toString(),
//                            DialogUtil.MessageType.ERROR
//                        )
                    }
                }
                else -> {
                    animationView.visibility = View.GONE
                }

            }
        })


//        viewModel.getCurrentUserLiveData.observe(this, Observer {
//            when (it.status) {
//                ResourceState.LOADING -> {
//                    animationView.visibility = View.VISIBLE
//                }
//                ResourceState.ERROR -> {
//                    Timber.e("error ${it.message}")
//                    animationView.visibility = View.GONE
//                }
//                ResourceState.SUCCESS -> {
//                    animationView.visibility = View.GONE
//                    if (address == null)
//                        tv_phone_value.setText(it.data?.phone?.toLowerCase(Locale.ENGLISH)?:"")
//                }
//                else -> {
//                    animationView.visibility = View.VISIBLE
//                }
//            }
//        })


        viewModel.getGuestLastAddressLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    Timber.e("error ${it.message}")
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    if (address == null)
                        setupGuestAddress(it.data)
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })



        viewModel.getUpdateAddressesLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    Timber.e("error ${it.message}")
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    Timber.e("Succes")
                    hideKeyboard()
                    animationView.visibility = View.GONE
                    if (fromCheckOut) {
                        Utils.CheckOutAction.action = Utils.CheckActionType.ADDRESS_UPDATED
                        Utils.CheckOutAction.addressID = it.data?.o_address_id!!
                            findNavController().popBackStack()
                    } else if (it.data?.o_address_id!! > 0) {
                        showCustomTopMessage(
                            getString(R.string.editaddress_success),
                            DialogUtil.MessageType.SUCCESS
                        )

                        (activity as MainActivity).navigateBackWithResult(Bundle())
                    }
                }

            }
        })

        viewModel.getAddressLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    Timber.e("error ${it.message}")
                    animationView.visibility = View.GONE
                    showCustomTopMessage(
                        it.message ?: getString(R.string.completedata),
                        DialogUtil.MessageType.ERROR
                    )
                }
                ResourceState.SUCCESS -> {
                    Timber.e("Succes")
                    hideKeyboard()
                    animationView.visibility = View.GONE
                    if (fromCheckOut) {
                        val addressID = it?.data?.o_address_id
                        Utils.CheckOutAction.addressID =
                            if (addressID != null && addressID > 0) addressID else 0
                        //Set shipping address and billing address
                        viewModel.updateAddress(
                            isGraphEnable = ENABLE_GRAPH_QUERIES_CALLS,
                            fromCheckout = fromCheckOut,
                            addressRequest = setAddressModel(
                                addressID.toString(),
                                true,
                                "Y"
                            )
                        )
                    } else {
                        if (it.data?.o_address_id!! > 0) {
                            showCustomTopMessage(
                                getString(R.string.addaddress_success),
                                DialogUtil.MessageType.SUCCESS
                            )
                            if (fromCheckOut) {
                                Utils.CheckOutAction.action = Utils.CheckActionType.ADDRESS_UPDATED
                                Utils.CheckOutAction.addressID = it.data?.o_address_id!!
                                if(AsAGuest){

                                }else {
                                    findNavController().popBackStack()
                                }
                            } else {
                                val returnIntent = Bundle()
                                returnIntent.putInt(ADD_NEW_ADDRESS, ADD_NEW_ADDRESS_REQUEST)
                                returnIntent.putString(
                                    Constants.ADD_NEW_ADDRESS_VALUE,
                                    it.data?.o_address_id.toString()
                                )
                                (activity as MainActivity).navigateBackWithResult(returnIntent)
                            }
                        }
                    }

                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })


        viewModel.getCitiesLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                    initCityView()

                }
                ResourceState.SUCCESS -> {
                    citiesList = it.data as ArrayList<CityModel>
                    //getAreaCount()
                    initCityView()
                    updateCityInfo()
                    animationView.visibility = View.GONE
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getAreaLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.LOADING -> {
                    animationView.visibility = View.VISIBLE
                }
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    hideKeyboard()
                    animationView.visibility = View.GONE
                    var areaListLocal = it.data as ArrayList<AreaModel>
                    if (areaListLocal.isNullOrEmpty() || (areaListLocal.isNullOrEmpty()
                            .not() && areaListLocal?.size == 1 && areaListLocal?.get(0)!!.isOneLevel == true)
                    ) {
                        areaListLocal?.let {
                            areaListLocal?.map {
                                areaCode = it?.code.toString()
                                selectedAreaId = it?.area_id!!
                                areaName = it?.code.toString()
                                isAreaOneLevel = true
                            }
                        }
                        area_components.visibility = View.GONE
                        showOrHideAreaView(false)
                    } else {
                        areaList = areaListLocal
                        isAreaOneLevel = false
                        area_components.visibility = View.VISIBLE
                        showOrHideAreaView(true)
                        selectedCityAreaCount = areaList?.size ?: 0
                        tv_area_value.visibility = View.VISIBLE
                        tv_area_title.visibility = View.VISIBLE
                        areaValueEditText.visibility = View.GONE
                        if (selectedAreaId > 0) {
                            tv_area_value.text = areaName
//                            viewModel.getAreaNameById(areaList!!, selectedAreaId)
//                            areaName = tv_area_value.text.toString()
//                            areaValueEditText.setText( areaName)
                        }
                    }

                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })
        viewModel.getBlockLiveData.observe(this, Observer {
            setBlockVisibility(it)
        })


    }

    private fun setupAddressTypes(type: String?) {
        if (!ENABLE_GRAPH_QUERIES_CALLS) {
            spinner_address_types.visibility = View.GONE
            tv_name_title.visibility = View.GONE
            return
        }
        val adapter: ArrayAdapter<AddressType> = ArrayAdapter(
            requireContext(),
            R.layout.item_spinner,
            getAddressTypes()
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_address_types.adapter = adapter
        if (type?.isNullOrBlank()!!.not() && type?.toInt() ?: 0 > 0) {
            setAddressTypeSelected(type)
        }
    }

    private fun getAddressTypeSelected() = if (ENABLE_GRAPH_QUERIES_CALLS) {
        selectedAddressType
//        (spinner_address_types?.selectedItem as AddressType).id
    } else ""

    private fun setAddressTypeSelected(typeId: String?) {
        if (typeId.isNullOrBlank()) return
        selectedAddressType = typeId
        val index = getAddressTypes().indexOfFirst { type -> type.id == typeId }
        spinner_address_types?.setSelection(index)

    }

    private fun setupGuestAddress(data: Address?) {

        if(data?.o_city == "send as recipient" && data?.o_area == "send as recipient"){
            switchaskaddress.isChecked=true
            tv_recipeint_name.setText(data?.user_name)
            tv_phone_number.setText(data?.o_phone?.toLowerCase(Locale.ENGLISH))
            ll.visibility=View.GONE
            if(data?.keep_secret == true){
                switchkeepidentity.isChecked=true
                keep_secret=true
            }else{
                switchkeepidentity.isChecked=false
                keep_secret=false
            }
        }else {

            tv_address_name_value.setText(data?.o_name)
            setupAddressTypes(data?.o_address_type)
            tv_mail_value.setText(data?.o_email)
            tv_block_value.setText(if (!data?.o_neighborhood.isNullOrBlank()) data?.o_neighborhood else data?.o_block)
            tv_address_value.setText(data?.o_address)
            tv_phone_value.setText(data?.o_phone?.toLowerCase(Locale.ENGLISH))
            tv_zip_value.setText(data?.o_zipcode)
            tv_user_name_value.setText(data?.user_name)
            tv_street_value.setText(data?.o_street)
            tv_additional_direction_value.setText(data?.o_extra)
            if (data?.o_city!!.isNotEmpty()) {
                if (data.city_name.isNotEmpty()) {
                    tv_city_value.text = data.city_name
                    cityValueEditText.setText(data.city_name)
                }
                if (viewModel.isANumber(data.o_city_id)) {
                    selectedCityId = viewModel.convertStringToInt(data.o_city_id)
                    cityName = data.city_name
                    cityCode = data.city_code
                    tv_city_value.text = data.city_name
                    areaCode = data?.o_area_code
                    areaName = data?.o_area

                    if (data?.o_area_id.isNullOrBlank()
                            .not() && !data?.o_area_id.equals("0") && !data?.o_area_id.equals("-1") && data?.o_area_code.isNullOrBlank()
                            .not() && !data?.o_area_code.equals(viewModel?.getCountryCode(), true)
                    ) {
                        viewModel.getAreas(selectedCityId, cityCode)
                    }
                }
            }

            try {
                if (data.o_area.isNotEmpty() || data.o_area_id.isNotEmpty()) {
                    if (viewModel.isANumber(data.o_area_id)) {
                        selectedAreaId = viewModel.convertStringToInt(data.o_area_id)
                    } else {
                        if (areaList.isNullOrEmpty().not()) {
                            areaValueEditText.setText(areaList?.filter { it.area_id.toString() == data.o_area_id }
                                ?.get(0)?.name_en)
                        }
                    }
                } else
                    areaValueEditText.setText(data.o_state)
            } catch (e: java.lang.Exception) {
                e.printStackTrace()
            }

            if(data?.keep_secret == true){
                switchkeepidentity.isChecked=true
                keep_secret=true
            }else{
                switchkeepidentity.isChecked=false
                keep_secret=false
            }
        }
    }

    private fun getAreaCount() {
        if (ENABLE_GRAPH_QUERIES_CALLS)
            citiesList.let {
                selectedCityAreaCount =
                    viewModel.getSelectedAreaCountFromList(citiesList!!, selectedCityId)
            }
        else if (address != null && address?.getCityId()!! > 0 && citiesList != null) {
            citiesList.let {
                selectedCityAreaCount =
                    viewModel.getSelectedAreaCountFromList(citiesList!!, selectedCityId)
            }
        }
    }

    private fun updateCityInfo() {

        if (address != null) {

            if (!address?.o_city.isNullOrBlank()) {
                tv_city_value.text = address?.o_city
                cityName = address?.o_city.toString()
                cityValueEditText.setText(cityName)
            }
            selectedCityId = address!!.cityId!!.toInt()
            if (selectedCityId > 0) {
                selectedAreaId = address?.areaId?.toInt() ?: 0
                viewModel.getAreas(selectedCityId, cityCode)
            }
        }
    }

    private fun showSelectedCityIdbasedOnLangauge() {

        try {
            if (citiesList.isNullOrEmpty().not()) {
                citiesList?.map {
                    if (it?.city_id == selectedCityId) {
                        val title: String? =
                            if (App.getPref().currentLanguage.toString().equals("ar", true)) {
                                it.name_ar
                            } else {
                                it.name_en
                            }
                        tv_city_value.text = title
                    }
                }
            }

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }


    private fun updateAreaInfo() {
        if (address?.areaId?.toInt() ?: 0 > 0 || !address?.o_area.isNullOrBlank()) {
            if (address?.o_area_code.isNullOrBlank()
                    .not() && address?.o_area_code.equals(viewModel?.getCountryCode(), true)
            ) {
                areaName = address?.o_area.toString()
                areaCode = address?.o_area_code.toString()
                Log.d("TAG", "updateAreaInfo: ${areaCode.toString()}")
                selectedAreaId = address?.areaId!!.toInt()
                area_components.visibility = View.INVISIBLE
                showOrHideAreaView(false)
            } else {
                area_components.visibility = View.VISIBLE
                showOrHideAreaView(true)
                areaName = address?.o_area.toString()
                areaCode = address?.o_area_code.toString()
                Log.d("TAG", "updateAreaInfo: ${areaCode.toString()}")
                selectedAreaId = address?.areaId!!.toInt()
                tv_area_value.text = areaName
                if (selectedAreaId == 0) {
                    areaValueEditText.visibility = View.VISIBLE
                    area_components.visibility = View.VISIBLE
                    showOrHideAreaView(true)
                    tv_area_title.visibility = View.VISIBLE
                    tv_area_value.visibility = View.GONE
                    areaValueEditText.setText(areaName)
                } else {
                    areaValueEditText.visibility = View.GONE
                    tv_area_value.visibility = View.VISIBLE
                    tv_area_title.visibility = View.VISIBLE
                    area_components.visibility = View.VISIBLE
                    showOrHideAreaView(true)
                }
            }

        } else {
            area_components.visibility = View.INVISIBLE
            showOrHideAreaView(false)
        }

    }

    private fun setupWithData(address: AddressRequest?) {
        try {
            tv_address_name_value.setText(address?.o_address_name)
            if (viewModel?.isAnewCountry()!!)
                tv_zip_value.setText(address?.o_zipcode)
            tv_address_value.setText(address?.o_address)
            tv_paci_value.setText(address?.o_paci)
            if (!address?.o_neighborhood.isNullOrBlank()) {
                tv_block_value.setText(address?.o_neighborhood)
            } else if (!address?.o_block.isNullOrBlank()) {
                tv_block_value.setText(address?.o_block)
            }
            tv_street_value.setText(address?.o_street)
            tv_additional_direction_value.setText(address?.o_extra)
            tv_user_name_value.setText(address?.first_name + " " + address?.last_name)
            tv_phone_value.setText(
                address?.o_phone?.toLowerCase(Locale.ENGLISH)?.replace("+", "")
                    ?.removePrefix(viewModel.getCountryPhoneCode().replace("+", ""))
            )
            btn_add.text = getString(R.string.continue_str)
//        isprimary.visibility = View.VISIBLE
//            isprimary.isChecked = address?.is_primary == "Y"
            updateCityInfo()
            updateAreaInfo()
            setupAddressTypes(address?.addr_type)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        context?.showKeyboard()

        initComponent()
        viewModel.checkBlockStatusBasedOnCountry()
        setBlockTitleBasedOnCountry()

        if (!viewModel?.isCountryGCC()!!) {
            tv_zip_value.visibility = View.VISIBLE
            tv_zip_title.visibility = View.VISIBLE
        } else {
            tv_zip_value.visibility = View.GONE
            tv_zip_title.visibility = View.GONE
        }
        if (AsAGuest) {
            initGuestViews()
            viewModel.getGuestLastAddress()
        }

//        if (address == null && !AsAGuest)
//            viewModel.getCurrentUser()

        if (address != null) {
            tv_title.text = getString(R.string.edit_address)
        } else {
            tv_phone_value.setText(MemoryCacheManager.getUserData()?.phone ?: "")
            tv_title.text = getString(R.string.fragment_add_address_title)
        }
        initAction()
    }

    private fun initAction() {
        setAddressTypeSelected("1285")

        partmentButton?.setOnClickListener {
            partmentButton.setBackgroundDrawable(resources.getDrawable(R.drawable.selected_button_bg))
            homeButton.setBackgroundDrawable(resources.getDrawable(R.drawable.unselected_button_bg))
            setAddressTypeSelected("1286")
         }
        homeButton?.setOnClickListener {
            homeButton.setBackgroundDrawable(resources.getDrawable(R.drawable.selected_button_bg))
            partmentButton.setBackgroundDrawable(resources.getDrawable(R.drawable.unselected_button_bg))
            setAddressTypeSelected("1285")
         }

        switchaskaddress.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                ll.visibility=View.GONE
            } else {
                ll.visibility=View.VISIBLE
            }
        })

        switchkeepidentity.setOnCheckedChangeListener(CompoundButton.OnCheckedChangeListener { buttonView, isChecked ->
            if (isChecked) {
                keep_secret=true
            } else {
                keep_secret=false
            }
        })

        /* switchaskaddress.setOnCheckedChangeListener { buttonView, isChecked ->
             if(isChecked)
                 ll.visibility=View.GONE
             else
                 ll.visibility=View.VISIBLE
         }*/
    }

    private fun setBlockVisibility(state: Boolean) {
        if (state) {
            //tv_block_title,tv_block_value
            block_components.visibility = View.VISIBLE
            tv_block_title.visibility = View.VISIBLE
            tv_block_value.visibility = View.VISIBLE
        } else {
            block_components.visibility = View.GONE
            tv_block_title.visibility = View.GONE
            tv_block_value.visibility = View.GONE
        }
    }

    private fun setBlockTitleBasedOnCountry() {
        when (countryCode) {
            "SA", "sa" -> {
                tv_block_value.hint = getString(R.string.enter_hint_Neighborhood)
                tv_block_title.text = getString(R.string.hint_Neighborhood)
            }
        }
    }

    fun scrollToSpecificView(view: View) {
        try {
            val scrollTo: Int = ((view.getParent().getParent() as View).top + view.getTop()) - 200
            scrollView1.smoothScrollTo(0, scrollTo)

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun checkValuesBasedOnCountry(): Boolean {
        if (countryCode.equals("KW", true) || countryCode.equals("BH", true)) {
            // check on block
            if (tv_block_value.text.toString().isNullOrBlank()) {
                showCustomTopMessage(
                    getString(R.string.hint_block),
                    DialogUtil.MessageType.ERROR
                )
                tv_block_value.error = getString(R.string.hint_block)
                showCustomTopMessage(
                    getText(R.string.hint_block).toString(),
                    DialogUtil.MessageType.ERROR
                )
                scrollToSpecificView(tv_block_value)
                return false
            }
        } else if (countryCode.equals("SA", true)) {
            // check on block
            if (tv_block_value.text.toString().isNullOrBlank()) {
                showCustomTopMessage(
                    getString(R.string.enter_hint_Neighborhood),
                    DialogUtil.MessageType.ERROR
                )
                tv_block_value.error = getString(R.string.enter_hint_Neighborhood)
                showCustomTopMessage(
                    getText(R.string.enter_hint_Neighborhood).toString(),
                    DialogUtil.MessageType.ERROR
                )
                scrollToSpecificView(tv_block_value)
                return false
            }
        } else if (!countryCode.equals("KW", true) && !countryCode.equals(
                "BH",
                true
            ) && !countryCode.equals("SA", true) &&
            !countryCode.equals("OM", true) && !countryCode.equals(
                "QA",
                true
            ) && !countryCode.equals("AE", true)
        ) {

            if (tv_zip_value.text.toString().isNullOrBlank() && !viewModel?.isCountryGCC()!!) {
                showCustomTopMessage(
                    getString(R.string.hint_add_zipcode),
                    DialogUtil.MessageType.ERROR
                )
                tv_zip_value.setError(getString(R.string.hint_add_zipcode))
                showCustomTopMessage(
                    getText(R.string.hint_add_zipcode).toString(),
                    DialogUtil.MessageType.ERROR
                )
                scrollToSpecificView(tv_zip_value)
                return false
            }
        }

        return true
    }

    private fun initGuestViews() {
        //tv_user_name_title,tv_user_name_value,tv_mail_title,tv_mail_value
        guest_group.visibility = View.VISIBLE
        tv_user_name_title.visibility = View.VISIBLE
        tv_user_name_value.visibility = View.VISIBLE
        tv_mail_title.visibility = View.VISIBLE
        tv_mail_value.visibility = View.VISIBLE
        tv_name_value.clearFocus()
        tv_user_name_value.requestFocus()
    }

    private fun initCityView() {
        if (cityValueEditText != null) {
            if (citiesList.isNullOrEmpty().not() && citiesList!!.size > 0) {
                cityValueEditText.visibility = View.GONE
                tv_city_value.visibility = View.VISIBLE
//                areaValueEditText.visibility = View.GONE
                area_components.visibility = View.GONE
                showOrHideAreaView(false)
                tv_area_title.text = getString(R.string.hint_area)
                showSelectedCityIdbasedOnLangauge()
            } else {
                cityValueEditText.visibility = View.VISIBLE
                tv_city_value.visibility = View.GONE
                //Area view
                area_components.visibility = View.GONE
                showOrHideAreaView(false)
                tv_area_title.visibility = View.VISIBLE
//                tv_area_value.visibility = View.GONE
                areaValueEditText.visibility = View.VISIBLE
                tv_area_title.text = getString(R.string.state)
            }
        }
    }
    fun showOrHideAreaView(isShow:Boolean){
        println("Akl/area status : "+isShow)
        tv_area_title.visibility =if(isShow) View.VISIBLE else View.GONE
        areaView.visibility =if(isShow) View.VISIBLE else View.GONE
    }

    private fun initComponent() {
        setupAddressTypes("0")

        tv_country_value?.setText(viewModel?.getCountryName())
        if(viewModel?.getPhoneLenght().isNullOrBlank().not()) {
            tv_phone_value.filters = arrayOf(InputFilter.LengthFilter(viewModel?.getPhoneLenght().toInt()))
        }

        if (!AsAGuest) {
            tv_user_name_value.clearFocus()
            tv_name_value.requestFocus()
        }
        address?.let {
            replaceCityWithAreaInfo()
            setupWithData(it)
        }
        initCityView()

        if (ENABLE_GRAPH_QUERIES_CALLS) {
            street_group.visibility = View.GONE
            tv_street_value.visibility = View.GONE
            tv_street_title.visibility = View.GONE
            //tv_street_title,tv_street_value"
        }


        tv_city_value.setSafeOnClickListener {
            hideKeyboard()
            isCityViewClicked = true
            if (citiesList != null && citiesList!!.size > 0) {
                startActivityForResult(
                    ChooseCityActivity.getInstance(requireActivity(), citiesList, null),
                    START_FORE_RESULT_ID_HOLDER
                )
            } else {
                // show error messgae
                showCustomTopMessage(getString(R.string.not_cities), DialogUtil.MessageType.ERROR)
            }
        }

        tv_area_value.setSafeOnClickListener {
            hideKeyboard()
            isCityViewClicked = false
            if (areaList != null && areaList!!.size > 0) {
                startActivityForResult(
                    ChooseCityActivity.getInstance(requireActivity(), null, areaList),
                    START_FORE_RESULT_ID_HOLDER
                )
            } else {
                if (selectedCityId > 0) {
                    showCustomTopMessage(
                        getString(R.string.there_no_area_in_city),
                        DialogUtil.MessageType.ERROR
                    )
                } else {
                    showCustomTopMessage(
                        getString(R.string.choose_city_first),
                        DialogUtil.MessageType.ERROR
                    )
                }
            }
        }

        phone_code.text = viewModel.getCountryPhoneCode()
        tv_country_code.text = viewModel.getCountryPhoneCode()
        btn_add.setSafeOnClickListener {
            if(switchaskaddress.isChecked){
                if (validInputsForUser2()) {
                    if (address == null) {
                        if (AsAGuest) {
                            val request = RegisterRequestBody(
                                o_address = "send as recipient",
                                o_address_name = "send as recipient",
                                o_area = "send as recipient",
                                //o_area=if(viewModel?.getCountryCode() == "Sa") "Abha" else "0",
                                o_area_code = "0",
                               // o_area_code = if(viewModel?.getCountryCode() == "Sa") "Abha" else "0",
                                o_city = "send as recipient",
                                /* o_city_id = if (selectedAreaId > 0 && areaCode.isNullOrBlank()
                                    .not() && areaCode.equals(
                                    viewModel?.getCountryCode(),
                                    true
                                ).not()
                            ) selectedCityId.toString() else selectedAreaId.toString(),*/
                                //o_city_id = "0",
                               // o_city_id=if(viewModel?.getCountryCode() == "SA") com.tatayab.tatayab.utils.Constants.getCityID(requireContext())!! else "0",
                                o_city_id=if(viewModel?.getCountryCode() == "SA") "1394" else "0",
                                //o_city_id=if(viewModel?.getCountryCode() == "SA") "Riyadh" else "0",
                                phone = tv_phone_number.text.toString(),
                                email = "send@recipient.com",
                                o_block = "send as recipient",
                                o_neighborhood = "send as recipient",
                                o_zipcode = "send as recipient",
                                firstname = tv_recipeint_name.text.toString(),
                                lang_code = langCode,
                                //cityName = if (selectedCityId > 0) cityName else cityValueEditText.text.toString(),
                                cityName = "send as recipient",
                                o_street = "send as recipient",
                                o_extra = "send as recipient",
                                /*o_areaId = if (selectedAreaId > 0 && areaCode.isNullOrBlank()
                                    .not() && areaCode.equals(
                                    viewModel?.getCountryCode(),
                                    true
                                ).not()
                            ) selectedCityId.toString() else selectedAreaId.toString(),*/
                                //o_areaId = "0",
                                //o_areaId=if(viewModel?.getCountryCode() == "SA") com.tatayab.tatayab.utils.Constants.getCityID(requireContext())!! else "0",
                                o_areaId=if(viewModel?.getCountryCode() == "SA") "1394" else "0",
                                //o_areaId=if(viewModel?.getCountryCode() == "SA") "Riyadh" else "0",
                               // addr_type = selectedAddressType//,
                                addr_type ="1286"
                                //keep_secret = keep_secret!!
                            )
                            request.isAreaOneLevel = isAreaOneLevel
                            viewModel.selectUserAddress(
                                request, App.getPref().firstUserToken,
                                ENABLE_GRAPH_QUERIES_CALLS
                            )
                        } else {
                            viewModel.addAddress(
                                setAddressModel("", false, ""),
                                isFromCheckOut = fromCheckOut
                            )
                        }
                    } else {
                        viewModel.updateAddress(
                            isGraphEnable = ENABLE_GRAPH_QUERIES_CALLS,
                            addressRequest = setAddressModel(
                                address?.o_address_id!!,
                                false,
                                "Y"
                            )
                        )
                    }
                }
            }else {
                if (isInputsValid()) {
                    if (isValidCityAndArea()) {
                        if (checkValuesBasedOnCountry()) {
                            if (address == null) {
                                if (AsAGuest) {
                                    val request = RegisterRequestBody(
                                        o_address = tv_address_value.text.toString(),
                                        o_address_name = tv_address_name_value.text.toString(),
                                        o_area = areaName,
                                        o_area_code = areaCode,
                                        o_city = cityName,
                                        o_city_id = if (selectedAreaId > 0 && areaCode.isNullOrBlank()
                                                .not() && areaCode.equals(
                                                viewModel?.getCountryCode(),
                                                true
                                            ).not()
                                        ) selectedCityId.toString() else selectedAreaId.toString(),
                                        phone = tv_phone_value.text.toString(),
                                        email = tv_mail_value.text.toString(),
                                        o_block = tv_block_value.text.toString(),
                                        o_neighborhood = tv_block_value.text.toString(),
                                        o_zipcode = tv_zip_value.text.toString(),
                                        firstname = tv_user_name_value.text.toString(),
                                        lang_code = langCode,
                                        cityName = if (selectedCityId > 0) cityName else cityValueEditText.text.toString(),
                                        o_street = tv_street_value.text.toString(),
                                        o_extra = tv_additional_direction_value.text.toString(),
                                        o_areaId = if (selectedAreaId > 0 && areaCode.isNullOrBlank()
                                                .not() && areaCode.equals(
                                                viewModel?.getCountryCode(),
                                                true
                                            ).not()
                                        ) selectedCityId.toString() else selectedAreaId.toString(),
                                        addr_type = getAddressTypeSelected()//,
                                       // keep_secret = keep_secret!!
                                    )
                                    request.isAreaOneLevel = isAreaOneLevel
                                    viewModel.selectUserAddress(
                                        request, App.getPref().firstUserToken,
                                        ENABLE_GRAPH_QUERIES_CALLS
                                    )

                                } else
                                    viewModel.addAddress(
                                        setAddressModel("", false, ""),
                                        isFromCheckOut = fromCheckOut
                                    )
                            } else {
                                viewModel.updateAddress(
                                    isGraphEnable = ENABLE_GRAPH_QUERIES_CALLS,
                                    addressRequest = setAddressModel(
                                        address?.o_address_id!!,
                                        false,
                                        "Y"
                                    )
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun replaceCityWithAreaInfo() {
        address?.let {
            if (it?.areaId.isNullOrBlank()
                    .not() && !it?.areaId.equals("0") && !it?.areaId.equals("-1") && it?.o_area_code.isNullOrBlank()
                    .not() && !it?.o_area_code.equals(viewModel?.getCountryCode(), true)
            ) {
                var newCityIdValue = it?.areaId
                var newCityNameValue = it?.o_area
                var newAreaIdValue = it?.cityId
                var newAreaNameValue = it?.o_city

                it?.cityId = newCityIdValue
                it?.o_city = newCityNameValue
                it?.areaId = newAreaIdValue
                it?.o_area = newAreaNameValue
            }
        }
    }

    private fun isValidCityAndArea(): Boolean {

        if (citiesList != null && citiesList!!.size > 0) {
            if (selectedCityId > -1 || address?.cityId != null) {
                if (selectedAreaId > -1 || selectedCityAreaCount == 0 || (!address?.areaId.isNullOrBlank() && !address?.areaId.equals(
                        "0",
                        true
                    ))
                ) {
                    return true
                } else {
                    showCustomTopMessage(
                        getString(R.string.choose_area_first),
                        DialogUtil.MessageType.ERROR
                    )
                    return false
                }
            } else {
                showCustomTopMessage(
                    getString(R.string.choose_city_first),
                    DialogUtil.MessageType.ERROR
                )
                return false
            }
        } else {
            if (!cityValueEditText.text.toString().isNullOrBlank()) {
                cityName = cityValueEditText.text.toString()
                if (!areaValueEditText.text.toString().isNullOrBlank()) {
                    areaName = areaValueEditText.text.toString()
                    return true
                } else {
                    showCustomTopMessage(
                        getString(R.string.state_empty),
                        DialogUtil.MessageType.ERROR
                    )
                    return false
                }
            } else {
                showCustomTopMessage(
                    getString(R.string.enter_city_first),
                    DialogUtil.MessageType.ERROR
                )
                return false
            }
        }


    }

    private fun isInputsValid(): Boolean {
        return if (AsAGuest) {
            if (!tv_user_name_value.isValid(requireContext())) {
                showCustomTopMessage(
                    getText(R.string.enter_user_name).toString(),
                    DialogUtil.MessageType.ERROR
                )
                return false

            } else if (!tv_address_name_value.isValid(requireContext())) {
                showCustomTopMessage(
                    getText(R.string.add_address_title).toString(),
                    DialogUtil.MessageType.ERROR
                )
                return false

            } else if (!tv_mail_value.isValidEmail()) {
                showCustomTopMessage(
                    getText(R.string.hint_add_email).toString(),
                    DialogUtil.MessageType.ERROR
                )
                return false

            } else if (!validInputsForUser()) {
                return false
            } else if (!validAddressType()) {
                return false
            }

            return true
        } else {
            if (!tv_address_name_value.isValid(requireContext())) {
                showCustomTopMessage(
                    getText(R.string.add_address_title).toString(),
                    DialogUtil.MessageType.ERROR
                )
                return false

            } else if (!validInputsForUser()) {
                return false
            } else if (!validAddressType()) {
                return false
            }
            return true
        }
    }

    private fun validAddressType(): Boolean {
        return if (spinner_address_types.selectedItemPosition > 0) {
            return true
        } else {
            showCustomTopMessage(
                getString(R.string.select_address_type),
                DialogUtil.MessageType.ERROR
            )
            scrollToSpecificView(spinner_address_types)
            false
        }
    }

    private fun validInputsForUser(): Boolean {
        if (!validatePhoneNumber(tv_phone_value.text.toString())) {
            scrollToSpecificView(tv_phone_value)
            return false
        } else if (!tv_address_name_value.isValidEmpty(getText(R.string.filed_required).toString())) {
            showCustomTopMessage(
                getText(R.string.add_address_title).toString(),
                DialogUtil.MessageType.ERROR
            )
            scrollToSpecificView(tv_address_name_value)
            return false
        } else if (!tv_address_value.isValidEmpty(getText(R.string.filed_required).toString())) {
            showCustomTopMessage(
                getText(R.string.address_name_hint).toString(),
                DialogUtil.MessageType.ERROR
            )
            scrollToSpecificView(tv_address_value)
            return false
        } else if (!ENABLE_GRAPH_QUERIES_CALLS && !tv_street_value.isValidEmpty(getText(R.string.filed_required).toString())) {
            showCustomTopMessage(
                getText(R.string.hint_enter_street).toString(),
                DialogUtil.MessageType.ERROR
            )
            scrollToSpecificView(tv_street_value)
            return false
        } else {
            return true
        }


        //        return (validatePhoneNumber(tv_phone_value.text.toString()) && tv_address_name_value.isValidEmpty(
//            getText(R.string.filed_required).toString()
//        ) && tv_address_value.isValidEmpty(getText(R.string.filed_required).toString())
//                && if (!ENABLE_GRAPH_QUERIES_CALLS) tv_street_value.isValidEmpty(getText(R.string.filed_required).toString()) else true
//                )
    }

    private fun validInputsForUser2(): Boolean {
        if (!validatePhoneNumber2(tv_phone_number.text.toString())) {
            scrollToSpecificView(tv_phone_number)
            return false
        }else if(tv_recipeint_name.text.isEmpty()){
            showCustomTopMessage(
                getText(R.string.filed_required).toString(),
                DialogUtil.MessageType.ERROR
            )
            tv_recipeint_name.error = getString(R.string.filed_required)
            scrollToSpecificView(tv_recipeint_name)
            return false
        }else{
            return true
        }
    }

    private fun validatePhoneNumber(phone: String): Boolean {

        if (phone.isEmpty()) {
            showCustomTopMessage(
                getText(R.string.filed_required).toString(),
                DialogUtil.MessageType.ERROR
            )
            tv_phone_value.error = getString(R.string.filed_required)
            return false
        }

        val validateMessage = viewModel.validatePhone(phone)
        return if (validateMessage != "1") {
            showCustomTopMessage(
                formatePhoneErrorMessage(validateMessage),
                DialogUtil.MessageType.ERROR
            )
            tv_phone_value.error = formatePhoneErrorMessage(validateMessage)
            false
        } else
            true
    }

    private fun validatePhoneNumber2(phone: String): Boolean {

        if (phone.isEmpty()) {
            showCustomTopMessage(
                getText(R.string.filed_required).toString(),
                DialogUtil.MessageType.ERROR
            )
            tv_phone_number.error = getString(R.string.filed_required)
            return false
        }

        val validateMessage = viewModel.validatePhone(phone)
        return if (validateMessage != "1") {
            showCustomTopMessage(
                formatePhoneErrorMessage(validateMessage),
                DialogUtil.MessageType.ERROR
            )
            tv_phone_number.error = formatePhoneErrorMessage(validateMessage)
            false
        } else
            true
    }


    private fun setAddressModel(
        oAddressId: String,
        isPrimary: Boolean,
        update: String
    ): AddressRequest {
        var fName = ""
        var lName = ""

        if(switchaskaddress.isChecked){
            fName=tv_recipeint_name.text.toString()
            lName="recipient"
        }else {
            if (update.equals("Y")) {

                val userName = tv_user_name_value.text.toString()

                if (userName?.isBlank()!!.not()) {
                    val fullNameArray = userName.split(" ")
                    if (fullNameArray.isNullOrEmpty().not()) {
                        fName = fullNameArray[0]
                        if (fullNameArray.size > 1) {
                            lName = fullNameArray[1]
                        }
                    }
                }
            } else {
                val userName = viewModel.getUserName().toString()

                if (userName?.isBlank()!!.not()) {
                    val fullNameArray = userName.split(" ")
                    if (fullNameArray.isNullOrEmpty().not()) {
                        fName = fullNameArray[0]
                        if (fullNameArray.size > 1) {
                            lName = fullNameArray[1]
                        }
                    }
                }
            }
        }
        if(switchaskaddress.isChecked){

                var request = AddressRequest(
                    o_address_id = "send as recipient",
                    o_address_name = "send as recipient",
                    addr_type = "1286",
                    o_address = "send as recipient",
                    o_area = "send as recipient",
                    //o_area=if(viewModel?.getCountryCode() == "Sa") "Abha" else "0",
                    o_area_code = "0",
                    //o_area_code = if(viewModel?.getCountryCode() == "SA") "Abha" else "0",
                    o_city = "send as recipient",
                    o_zipcode = "send as recipient",
                    o_block = "send as recipient",
                    o_neighborhood = "send as recipient",
                    o_paci = "send as recipient",
                    o_phone = tv_phone_number.text.toString(),
                    o_province = "",
                    //cityId = "0",
                   // cityId = if(viewModel?.getCountryCode() == "SA") com.tatayab.tatayab.utils.Constants.getCityID(requireContext())!! else "0",
                    cityId = if(viewModel?.getCountryCode() == "SA") "1394" else "0",
                    //cityId = if(viewModel?.getCountryCode() == "SA") "Riyadh" else "0",
                    //cityId=if(viewModel?.getCountryCode() == "Sa") "13017" else "0",
                    //areaId = if(viewModel?.getCountryCode() == "SA") com.tatayab.tatayab.utils.Constants.getCityID(requireContext())!! else "0",
                   areaId = if(viewModel?.getCountryCode() == "SA") "1394" else "0",
                    //areaId = if(viewModel?.getCountryCode() == "SA") "Riyadh" else "0",
                    //areaId="0",
                    user_id = "",
                    o_country_code = viewModel.getCountryCode(),
                    is_primary = if (isPrimary) "Y" else "N",
                    update = update,
                    o_street = "send as recipient",
                    o_extra = "send as recipient",
                    first_name = fName,
                    last_name = lName//,
                    //keep_secret = keep_secret,
                )
                request.isAreaOneLevel = isAreaOneLevel
                return request

        }else {
            Log.d("TAG", "setAddressModel: ${getAddressTypeSelected()}")
            var request = AddressRequest(
                o_address_id = oAddressId,
                o_address_name = tv_address_name_value.text.toString(),
                addr_type = getAddressTypeSelected(),
                o_address = tv_address_value.text.toString(),
                o_area = areaName,
                o_area_code = areaCode,
                o_city = cityName,
                o_zipcode = tv_zip_value.text.toString(),
                o_block = tv_block_value.text.toString(),
                o_neighborhood = tv_block_value.text.toString(),
                o_paci = tv_paci_value.text.toString(),
                o_phone = tv_phone_value.text.toString(),
                o_province = "",
                cityId = selectedCityId.toString(),
                areaId = selectedAreaId.toString(),
                user_id = "",
                o_country_code = viewModel.getCountryCode(),
                is_primary = if (isPrimary) "Y" else "N",
                update = update,
                o_street = tv_street_value.text.toString(),
                o_extra = tv_additional_direction_value.text.toString(),
                first_name = fName,
                last_name = lName//,
                //keep_secret = keep_secret,
            )
            request.isAreaOneLevel = isAreaOneLevel
            return request
        }
        /*request.isAreaOneLevel = isAreaOneLevel
        return request*/
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == START_FORE_RESULT_ID_HOLDER) {
            if (data != null && data.extras != null && data.extras!!.containsKey(CITIE_HOLDER)) {
                val selectCity: SelectCityOrAreaModel =
                    data.extras!!.getParcelable<SelectCityOrAreaModel>(CITIE_HOLDER) as SelectCityOrAreaModel
                selectCity.let {
                    if (it.id!! > -1 && isCityViewClicked) {
                        viewModel.getAreas(it.id!!.toInt(), it?.code.toString())
                        selectedCityId = it.id!!.toInt()
                        cityCode = it?.code.toString()
                        //selectedCityAreaCount = it.areaCount!!
                    } else if (it.id!! > -1) {
                        selectedAreaId = it.id!!
                        areaCode = it?.code.toString()
                        areaName = it?.name_ar.toString()
                    }

                    val title: String? =
                        if (App.getPref().currentLanguage.toString().equals("ar", true)) {
                            it.name_ar
                        } else {
                            it.name_en
                        }

                    if (isCityViewClicked) {
                        tv_city_value.text = title
                        cityName = title.toString()
                        areaName = ""
                        areaCode = ""
                        tv_area_value.text = getString(R.string.choose_area)
                        area_components.visibility = View.GONE
                        showOrHideAreaView(false)
                        selectedAreaId = -1
                        address?.areaId = "0"
                    } else {
                        tv_area_value.text = title
                        areaName = title.toString()
                    }
                }
            }
        }
    }

    override fun onStart() {
        try {
            if (activity is MainActivity) {
                (activity as MainActivity).apply {
                    this.hideBottomBar()
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        super.onStart()
    }

    override fun onDestroy() {
        try {
            if (activity is MainActivity) {
                (activity as MainActivity).apply {
                    this.showBottomBar()
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        super.onDestroy()
    }
}
