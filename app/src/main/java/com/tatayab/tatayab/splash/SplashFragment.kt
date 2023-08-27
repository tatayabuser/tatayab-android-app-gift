package com.tatayab.tatayab.splash

import android.Manifest
import android.annotation.SuppressLint
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.location.Address
import android.location.Location
import android.location.LocationManager
import android.os.Build
import android.os.Bundle
import android.os.CountDownTimer
import android.provider.Settings
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.adjust.sdk.Adjust
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.tatayab.model.responses.CheckVersionResponse
import com.tatayab.model.responses.CityModel
import com.tatayab.model.responses.CountryResponse
import com.tatayab.presentation.address.AddressFragmentViewModel
import com.tatayab.presentation.address.AddressFragmentViewModelFactory
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.splash.SelectedCountry
import com.tatayab.presentation.splash.SplashActivityViewModel
import com.tatayab.presentation.splash.SplashFragmentViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants
import com.tatayab.tatayab.App
import com.tatayab.tatayab.BuildConfig
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.addresses.ChooseCityActivity
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.developerSettings.DeveoperSettingsActivity
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.ext.showSnackbar
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnCityListener
import com.tatayab.tatayab.listener.OnCountryListener
import com.tatayab.tatayab.util.NavigationResult
import com.tatayab.tatayab.util.deskCache.DeskCacheConstants
import com.tatayab.tatayab.util.deskCache.DeskCacheConstants.APP_MIGRATED_BEFORE_KEY
import com.tatayab.tatayab.util.deskCache.SharedPrefManager
import kotlinx.android.synthetic.main.fragment_splash.*
import kotlinx.android.synthetic.main.splash_countries_view.*
import javax.inject.Inject


class SplashFragment : BaseFragment(), NavigationResult, OnCountryListener , OnCityListener {

    companion object {
        private const val ALL_PERMISSIONS_RESULT = 101
        private const val REQUEST_OPEN_GPS = 111
    }

    private var isCountDownDone = false
    private var isShowCountriesView = false
    private var isShowHome = false

    private var locationManager: LocationManager? = null
    private var permissions = mutableListOf(
        Manifest.permission.ACCESS_FINE_LOCATION,
        Manifest.permission.ACCESS_COARSE_LOCATION
    )

    private var isGPS: Boolean = false

    lateinit var countriesAdapter: HorizontalCountriesAdapter

    lateinit var horizontalCitiesAdapter: HorizontalCitiesAdapter

    lateinit var viewModel: SplashActivityViewModel
    lateinit var mainViewModel: MainActivityViewModel

    var countriesItems: ArrayList<CountryResponse> = ArrayList()
    var totalCountriesItems: ArrayList<CountryResponse> = ArrayList()
    var kwCountry: CountryResponse? = null
    var saCountry: CountryResponse? = null
    var qaCountry: CountryResponse? = null

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory

    @Inject
    lateinit var viewModelFactorySplash: SplashFragmentViewModelFactory.Factory

    private lateinit var fusedLocationClient: FusedLocationProviderClient

    lateinit var aviewModel: AddressFragmentViewModel
    @Inject
    lateinit var viewModelFactoryAddress: AddressFragmentViewModelFactory.Factory
    var citiesList: ArrayList<CityModel>? = null
    var mmcitiesList: ArrayList<CityModel>? = null
    var mmmcitiesList= ArrayList<CityModel>()

    override fun layoutId(): Int {
        return R.layout.fragment_splash
    }

    var mSharedPrefManager: SharedPrefManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initStaticCountries()
        initCities()
        handleAdjustData()
        initializeViewModels()
        startCountDown()
        mSharedPrefManager = SharedPrefManager(requireContext())
        viewModel.getCheckUpgrade(packageInfo())
        mSharedPrefManager?.addBooleanToSharedPrederances(
            DeskCacheConstants.ENABLE_GRAPH_QUERIES_KEY,
            true
        )
        viewModel?.getMigrationLiveData()!!.observe(this, Observer {
            if (activity is MainActivity) {
                (activity as MainActivity).apply {
                    this.updateCartCount(0)
                }
            }
        })

        viewModel.getUserTokenLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                }
                ResourceState.SUCCESS -> {
                    it?.let {
                        it.data?.let {
                            it?.mFirstTokenModel?.let {
                                App.getPref().firstUserToken = it?.token!!
                            }
                        }
                    }
                }
                ResourceState.LOADING -> {
                }
            }
        })
        if (viewModel.getUserFirstToken().isNullOrEmpty()) {
            // Set the sessions and device id and osUsed as default
            viewModel.saveUserAuth("")
        }

        viewModel.getCheckVersionLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
//                    main_progress?.visibility = View.GONE
                    viewModel.getCurrentUser()
//                    handleError(getString(R.string.update_version_error)+it?.throwable?.localizedMessage)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
//                    main_progress?.visibility = View.GONE
                    handleCheckVersionResult(it.data)
                }
                else -> {
//                    main_progress?.visibility = View.VISIBLE
                    setProgress(View.VISIBLE)
                }
            }
        })

        viewModel.getSaveUserSettingLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    view?.showSnackbar(getString(R.string.country_not_supported), 1000)
                }
                ResourceState.SUCCESS -> {
                    loadHomePageBlocks()
                }
                else -> {
                }
            }
        })

        viewModel.getCountriesLiveData().observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
//                    main_progress.visibility = View.GONE
                    countries_progress.visibility = View.GONE
                    handleError(getString(R.string.countires_response_error) + it?.message)
                }
                ResourceState.SUCCESS -> {
                    Log.d("dd", SelectedCountry.country.toString())
                    countries_progress.visibility = View.GONE
//                    main_progress.visibility = View.GONE
                    if (it?.data.isNullOrEmpty().not()) {
                        totalCountriesItems = (it?.data as ArrayList<CountryResponse>?)!!
                        setupCountriesList(it.data)
                    }
                }
                else -> {
                    countries_progress.visibility = View.VISIBLE
//                    main_progress.visibility = View.VISIBLE

                }
            }
        })

        // get user data
        viewModel.getUserLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {

                }
                ResourceState.SUCCESS -> {
                    addCustomLogToCrashlytics(
                        viewModel.getCountryCode(),
                        App.getPref().currentLanguage.toString(),
                        it.data?.user_id.toString(),
                        it.data?.email.toString(),
                        it.data?.firstname.toString()
                    )
                }
                else -> {

                }
            }
        })

        viewModel.getUserSettingLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setDefaultContentVisibility(View.GONE)
                    isShowCountriesView = true
                    showCountriesView()
                    detectLanguage()
//                    if (SelectedCountry.country == null)
//                        detectLocation()
                }
                ResourceState.SUCCESS -> {
                    it.data?.country?.let { it1 -> saveCountryInfoInMemoryCache(it1) }
                    loadHomePageBlocks()
                }
                else -> {
                }
            }
        })

        mainViewModel.getBlocksItemsLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
//                    main_progress.visibility = View.GONE
                    handleError(getString(R.string.home_blocks_error) + it?.message)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
//                    main_progress.visibility = View.GONE
                    if (it.data!!) {
                        isShowHome = true
                        navigateToHome()
                    }

                }
                else -> {
                    setProgress(View.VISIBLE)
//                    main_progress.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun showCountriesView() {
        if (isShowCountriesView && isCountDownDone)
            content.visibility = View.VISIBLE
    }

    private fun initStaticCountries() {
        /*	{
                        "id": "KW",
                        "two_letter_abbreviation": "KW",
                        "three_letter_abbreviation": "KWT",
                        "full_name_english": "Kuwait",
                        "phone_code": "965",
                        "phone_length": "8",
                        "phone_start_nums": "5,6,9",
                        "flag": "https:\/\/tatayab.com\/media\/flags\/KW.png",
                        "location": "gcc",
                        "show_custom_message": "1"
                    },*/
        kwCountry = CountryResponse(
            code = "KW",
            name = getString(R.string.kuwait),
            phone_code = "965",
            phone_lenght = "8",
            phone_start = "5,6,9",
            flag = "https:\\/\\/tatayab.com\\/media\\/flags\\/KW.png",
            show_custom_message = true
        )
        /*{
                 "id": "SA",
                 "two_letter_abbreviation": "SA",
                 "three_letter_abbreviation": "SAU",
                 "full_name_english": "Saudi Arabia",
                 "phone_code": "966",
                 "phone_length": "9",
                 "phone_start_nums": "5",
                 "flag": "https:\/\/tatayab.com\/media\/flags\/SA.png",
                 "location": "gcc",
                 "show_custom_message": "1"
             },*/
        saCountry = CountryResponse(
            code = "SA",
            name = getString(R.string.saudi_arabia),
            phone_code = "966",
            phone_lenght = "9",
            phone_start = "5",
            flag = "https:\\/\\/tatayab.com\\/media\\/flags\\/SA.png",
            show_custom_message = true
        )
        /*	{
                 "id": "QA",
                 "two_letter_abbreviation": "QA",
                 "three_letter_abbreviation": "QAT",
                 "full_name_english": "Qatar",
                 "phone_code": "974",
                 "phone_length": "8",
                 "phone_start_nums": "3,5,6,7",
                 "flag": "https:\/\/tatayab.com\/media\/flags\/QA.png",
                 "location": "gcc",
                 "show_custom_message": "1"
             },*/
        qaCountry = CountryResponse(
            code = "QA",
            name = getString(R.string.qatar),
            phone_code = "974",
            phone_lenght = "8",
            phone_start = "3,5,6,7",
            flag = "https:\\/\\/tatayab.com\\/media\\/flags\\/QA.png"
        )
    }

    fun initCities(){
        if(mmmcitiesList.isNullOrEmpty()) {
            mmmcitiesList.add(CityModel(1394,1,"Riyadh","الرياض","Riyadh",false))
            mmmcitiesList.add(CityModel(1379,2,"Jeddah","جده","Jeddah",false))
            mmmcitiesList.add(CityModel(1387,3,"Madinah","المدينه","Madinah",false))
            mmmcitiesList.add(CityModel(1374,4,"Dammam","الدمام","Dammam",false))
            mmmcitiesList.add(CityModel(1383,5,"Khobar","الخبر","Khobar",false))
            mmmcitiesList.add(CityModel(1386,6,"Makkah","مكه","Makkah",false))
            mmmcitiesList.add(CityModel(1427,7,"Al Hassa","الاحساء","Al Hassa",false))
            mmmcitiesList.add(CityModel(0,0,"Other","اخرى","0",false))
        }
    }


    private fun initializeViewModels() {
        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactorySplash.create(App.getPref().currentLanguage.toString())
            ).get(SplashActivityViewModel::class.java)
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        viewModel?.ENABLE_GRAPH_QUERIES_CALLS = Constants.ENABLE_GRAPH_QUERIES_CALLS
        viewModel?.getCountriesNeededData()

        checkMigration()
    }

    private fun checkMigration() {
        try {
            var sharedPreferencesManager = SharedPrefManager(activity)
            if (!sharedPreferencesManager.getBooleanFromSharedPrederances(APP_MIGRATED_BEFORE_KEY)) {
                viewModel.logout()
                if (activity is MainActivity) {
                    (activity as MainActivity).apply {
                        this.updateCartCount(0)
                    }
                }
                sharedPreferencesManager.addBooleanToSharedPrederances(
                    APP_MIGRATED_BEFORE_KEY,
                    true
                )
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun handleCheckVersionResult(data: CheckVersionResponse?) {
        if (data?.status != null) {
            if (data.status!!.equals("success", true))
                viewModel.getCurrentUser()
            else {
                setDefaultContentVisibility(View.GONE)
                upgrade_content.visibility = View.VISIBLE
            }
        } else {
            viewModel.getCurrentUser()
//            showErrorDialog(
//                upgrade_content,
//                data?.error ?: getString(R.string.update_version_error)+"/error 2"
//            )
        }
    }

    private fun handleError(message: String) {
        try {
            setProgress(View.GONE)
            Snackbar.make(
                main_container,
                message + " ",
                Snackbar.LENGTH_LONG
            ).show()
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun handleAdjustData() {
        val intent = Intent()
        val data = intent.data
        Adjust.appWillOpenUrl(data, context)
    }

    private fun setupCountriesList(countriesList: List<CountryResponse>?) {
        try {
            initNewCountireView()

            return
//            countriesList?.toMutableList()?.subList(0,3)?.let { countriesItems.addAll(it) }
            if (countriesList.isNullOrEmpty()) {
                if (countriesItems.isNullOrEmpty().not()) {
                    countriesAdapter.setItems(countriesItems)
                }
                return
            } else {
                countriesItems.clear()
                countriesList?.map {
                    println("Akl//countries//: " + it?.code)
                    if (it.code.isNullOrBlank().not() && it.code!!.equals("KW", true)) {
                        countriesItems.add(it)
                        println("Akl//countries//KW Done: ")
                    }
                }
                countriesList?.map {
                    if (it.code.isNullOrBlank().not() && it.code!!.equals("SA", true)) {
                        countriesItems.add(it)
                        println("Akl//countries//SA Done: ")
                    }
                }
                countriesList?.map {
                    if (it.code.isNullOrBlank().not() && it.code!!.equals("QA", true)) {
                        countriesItems.add(it)
                        println("Akl//countries//QA Done: ")
                    }
                }
//            countriesItems.add(
//                countriesList?.toMutableList()?.filter { it.code!! .equals("KW",true) }?.get(0)
//                    ?: CountryResponse()
//            )
//            countriesItems.add(
//                countriesList?.toMutableList()?.filter { it.code!!.equals("SA",true) }?.get(0)
//                    ?: CountryResponse()
//            )
//            countriesItems.add(
//                countriesList?.toMutableList()?.filter { it.code!! .equals("QA",true) }?.get(0)
//                    ?: CountryResponse()
//            )
                countriesItems.add(CountryResponse(name = getText(R.string.other).toString()))
                countriesAdapter.setItems(countriesItems)
                if (!countriesItems.isNullOrEmpty()) {
                    setSelectedCountry()
                }
            }

        } catch (e: java.lang.Exception) {
            Toast.makeText(requireContext(), "Error:// ${e.message}", Toast.LENGTH_LONG)
        }
    }

    private fun initNewCountireView() {
        try {
            if (totalCountriesItems.isNullOrEmpty()) {
                totalCountriesItems?.map {
                    println("Akl//countries//: " + it?.code)
                    if (it.code.isNullOrBlank().not() && it.code!!.equals("KW", true)) {
                        kwCountry = it
                    }
                }
                totalCountriesItems?.map {
                    if (it.code.isNullOrBlank().not() && it.code!!.equals("SA", true)) {
                        saCountry = it
                    }
                }
                totalCountriesItems?.map {
                    if (it.code.isNullOrBlank().not() && it.code!!.equals("QA", true)) {
                        qaCountry = it
                    }
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
        try {
            splashCountriesView.visibility = View.VISIBLE
            rv_countries.visibility = View.GONE
            checkOldSelectedCountry()

        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun checkOldSelectedCountry() {
        try {
            if (SelectedCountry?.country != null) {
                SelectedCountry.country?.let {
                    if (it?.code.equals(kwCountry?.code)) {
                        selectKwCountry()
                    } else if (it?.code.equals(saCountry?.code)) {
                        selectSACountry()
                    } else if (it?.code.equals(qaCountry?.code)) {
                        selectQACountry()
                    } else {
                        selectOtherChoose()
                    }
                }
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun setSelectedCountry() {
        if (SelectedCountry.country != null)
            countriesItems.filter { it.code == SelectedCountry.country?.code }
                .takeIf { it.isNotEmpty() }?.apply { get(0).isChecked = true } ?: run {
                countriesItems[3].isChecked =
                    true /// if not country selected , select the last item
            }
    }


    private fun packageInfo(): String {
        val manager = requireActivity().packageManager
        val info =
            manager.getPackageInfo(requireActivity().packageName, PackageManager.GET_ACTIVITIES)
        return info.versionName
    }


    private fun setDefaultContentVisibility(visibility: Int) {
        default_content.visibility = visibility
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getUser()
        initViews()

    }

    private fun loadHomePageBlocks() {
        mainViewModel.getHomeBlocks()
    }

    private fun navigateToHome() {
        if (isShowHome && isCountDownDone) {
            findNavController()
                .navigate(
                    R.id.action_to_home_fragment, null, NavOptions.Builder()
                        .setPopUpTo(R.id.destination_splash, true).build()
                )
        }
    }

    private fun initViews() {

        countriesAdapter = HorizontalCountriesAdapter(this)
        rv_countries.layoutManager =
            LinearLayoutManager(requireActivity(), RecyclerView.HORIZONTAL, false)
        rv_countries.adapter = countriesAdapter

        detectLanguage()
        refresh.setOnRefreshListener {
            viewModel.getCheckUpgrade(packageInfo())
            refresh.isRefreshing = false
        }

        btn_start.setSafeOnClickListener {
            try {
                when {
                    SelectedCountry.country == null -> {
                        view?.showSnackbar(getString(R.string.please_select_country), 1000)
                    }
                    SelectedCountry.country!!.isChecked -> {
                        viewModel.saveUserSetting()
//                        updateUserToken()
//                        MemoryCacheManager.clearMemoryCache()
                        mainViewModel?.removeCartIDsFromCache()
                        saveCountryInfoInMemoryCache(SelectedCountry.country!!)
                        InsiderManager.changeLanguage(App.getPref().currentLanguage.toString())
                    }
                    else -> {
                        view?.showSnackbar(
                            getString(R.string.please_select_supported_country),
                            1000
                        )
                    }
                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

        go_now.setSafeOnClickListener {
            goToStore()
        }

        splashLogoImageView.setSafeOnClickListener {
            if (BuildConfig.DEBUG) {
                startActivity(Intent(activity, DeveoperSettingsActivity::class.java))
            }
        }
    }

    private fun startCountDown() {
        object : CountDownTimer(5000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                isCountDownDone = true
                showCountriesView()
                navigateToHome()
            }
        }.start()
    }

    private fun saveCountryInfoInMemoryCache(country: CountryResponse) {
        try {
            country?.let {
                if (!it?.decimals.isNullOrEmpty() && isInteger(it?.decimals))
                    MemoryCacheManager.addDecimalNumbers(it?.decimals?.toInt()!!)
                if (it?.currency_code.isNullOrEmpty().not())
                    MemoryCacheManager.addCurrencyCode(it?.currency_code!!)
                MemoryCacheManager.addCountryPhoneCode(it?.phone_code ?: "")
                MemoryCacheManager.saveCountryInfo(it)
            }
        } catch (e: java.lang.Exception) {
            e.printStackTrace()
        }
    }

    private fun updateUserToken() {
        try {
            mainViewModel.updateUserTokenWithLangaugAndCountry(
                App.getPref().firstUserToken,
                mainViewModel.getCountryCode(),
                App.getPref().currentLanguage.toString()
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun detectLanguage() {
        if (App.getPref().isArabic()) {
            tv_arabic.setBackgroundResource(R.drawable.circle_selected)
            tv_eng.setBackgroundResource(R.drawable.circle_unselected)
        } else {
            tv_arabic.setBackgroundResource(R.drawable.circle_unselected)
            tv_eng.setBackgroundResource(R.drawable.circle_selected)
        }

        tv_eng.setSafeOnClickListener {
            if (App.getPref().isArabic()) {
                App.getPref().changeLanguage(requireActivity(), "en")
              //  selectKwCountry()
            }
        }

        tv_arabic.setSafeOnClickListener {
            if (!App.getPref().isArabic()) {
                App.getPref().changeLanguage(requireActivity(), "ar")
               // selectKwCountry()
            }
        }
        otherItem?.setSafeOnClickListener {
            selectOtherChoose()
            goToCountriesListScreen()
        }
        kwItem?.setSafeOnClickListener {
            selectKwCountry()
        }

        qaItem?.setSafeOnClickListener {
            selectQACountry()
        }

        saItem?.setSafeOnClickListener {
            selectSACountry()
        }

    }

    private fun selectOtherChoose() {
        kwCountry?.isChecked = false
        saCountry?.isChecked = false
        qaCountry?.isChecked = false
        rv_cities.visibility=View.GONE
        //KW
        country_name_kw.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_kw.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_kw.setImageResource(R.drawable.ic_kuwait)
        country_name_kw.textSize = 11f
        //SA
        country_name_sa.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_sa.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_sa.setImageResource(R.drawable.saudi_arabia)
        country_name_sa.textSize = 11f
        //qa
        country_name_qa.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_qa.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_qa.setImageResource(R.drawable.ic_qatar)
        country_name_qa.textSize = 11f

        //other
        country_name_other.setTextColor(resources.getColor(R.color.black))
        img_logo_other.setBackgroundResource(R.drawable.circle_selected)
        img_logo_other.setImageResource(R.drawable.ic_world)
        country_name_other.textSize = 14f


    }

    private fun selectSACountry() {
        kwCountry?.isChecked = false
        saCountry?.isChecked = true
        qaCountry?.isChecked = false
        SelectedCountry.country = saCountry
        InsiderManager.changeCountry(saCountry?.code.toString())
        rv_cities.visibility=View.VISIBLE





        //sa
        country_name_sa.setTextColor(resources.getColor(R.color.black))
        img_logo_sa.setBackgroundResource(R.drawable.circle_selected)
        img_logo_sa.setImageResource(R.drawable.saudi_arabia)
        country_name_sa.textSize = 14f
        //qa
        country_name_qa.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_qa.setImageResource(R.drawable.ic_qatar)
        img_logo_qa.setBackgroundResource(R.drawable.circle_unselected)
        country_name_qa.textSize = 11f
        //kw
        country_name_kw.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_kw.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_kw.setImageResource(R.drawable.ic_kuwait)
        country_name_kw.textSize = 11f

        //other
        country_name_other.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_other.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_other.setImageResource(R.drawable.ic_world)
        country_name_other.textSize = 11f

        //Log.d("TAG", "onCountrySelected: ${country.code}")
        //goToCitiesListScreen(country?.code!!)
        saveCountryInfoInMemoryCache(saCountry!!)
        //InsiderManager.changeLanguage(App.getPref().currentLanguage.toString())
        Log.d("TAG", "selectSACountry: ${App.getPref().currentLanguage.toString()}")
       // goToCitiesListScreen(App.getPref().currentLanguage.toString(),saCountry?.code.toString())
        setupCitiesAdapter()
    }

    private fun selectQACountry() {
        kwCountry?.isChecked = false
        saCountry?.isChecked = false
        qaCountry?.isChecked = true
        SelectedCountry.country = qaCountry
        InsiderManager.changeCountry(qaCountry?.code.toString())
        rv_cities.visibility=View.GONE


        //qa
        country_name_qa.setTextColor(resources.getColor(R.color.black))
        img_logo_qa.setBackgroundResource(R.drawable.circle_selected)
        img_logo_qa.setImageResource(R.drawable.ic_qatar)
        country_name_qa.textSize = 14f
        //SA
        country_name_sa.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_sa.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_sa.setImageResource(R.drawable.saudi_arabia)
        country_name_sa.textSize = 11f
        //kw
        country_name_kw.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_kw.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_kw.setImageResource(R.drawable.ic_kuwait)
        country_name_kw.textSize = 11f
        //other
        country_name_other.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_other.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_other.setImageResource(R.drawable.ic_world)
        country_name_other.textSize = 11f

        //Log.d("TAG", "onCountrySelected: ${country.code}")
        //goToCitiesListScreen(country?.code!!)

        saveCountryInfoInMemoryCache(qaCountry!!)
        //InsiderManager.changeLanguage(App.getPref().currentLanguage.toString())
        /*goToCitiesListScreen(qaCountry?.code.toString())*/
    }

    private fun selectKwCountry() {
        kwCountry?.isChecked = true
        saCountry?.isChecked = false
        qaCountry?.isChecked = false
        SelectedCountry.country = kwCountry
        rv_cities.visibility=View.GONE


        //KW
        country_name_kw.setTextColor(resources.getColor(R.color.black))
        img_logo_kw.setBackgroundResource(R.drawable.circle_selected)
        img_logo_kw.setImageResource(R.drawable.ic_kuwait)
        country_name_kw.textSize = 14f
        //SA
        country_name_sa.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_sa.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_sa.setImageResource(R.drawable.saudi_arabia)
        country_name_sa.textSize = 11f
        //qa
        country_name_qa.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_qa.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_qa.setImageResource(R.drawable.ic_qatar)
        country_name_qa.textSize = 11f
        //other
        country_name_other.setTextColor(resources.getColor(R.color.dark_blue))
        img_logo_other.setBackgroundResource(R.drawable.circle_unselected)
        img_logo_other.setImageResource(R.drawable.ic_world)
        country_name_other.textSize = 11f

        //Log.d("TAG", "onCountrySelected: ${country.code}")
        //goToCitiesListScreen(country?.code!!)

        saveCountryInfoInMemoryCache(kwCountry!!)
        //InsiderManager.changeLanguage(App.getPref().currentLanguage.toString())
        /*goToCitiesListScreen(kwCountry?.code.toString())*/

    }

    @SuppressLint("MissingPermission")
    private fun detectLocation() {
        setProgress(View.VISIBLE)
        try {
            locationManager =
                activity?.getSystemService(Service.LOCATION_SERVICE) as LocationManager
            isGPS = locationManager?.isProviderEnabled(LocationManager.GPS_PROVIDER) ?: false

            if (!isGPS) {
                setProgress(View.GONE)
//                showSettingsAlert()
            } else {
                setProgress(View.VISIBLE)
                fusedLocationClient =
                    LocationServices.getFusedLocationProviderClient(requireActivity())
                if (!checkLocationPermissionGranted()) {
//                    askForLocationPermission()
                    setProgress(View.GONE)
                    return
                }

                fusedLocationClient.lastLocation
                    .addOnSuccessListener { location: Location? ->
                        if (location == null)
//                            detectLocation()
                        else {
//                            updateUI(location)
                            setProgress(View.GONE)
                        }
                    }
                    .addOnFailureListener {
                        setProgress(View.GONE)
                        view?.showSnackbar(getString(R.string.cant_access_location), 1000)
                    }
            }
        } catch (e: Exception) {
            view?.showSnackbar(getString(R.string.cant_access_location), 1000)
        }
    }


    private fun checkLocationPermissionGranted(): Boolean {
        if (canAskPermission()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                for (params in permissions.toTypedArray())
                    return (activity?.checkSelfPermission(params) == PackageManager.PERMISSION_GRANTED)
            }
        }
        return true
    }

    private fun canAskPermission(): Boolean {
        return (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP_MR1);
    }

    private fun askForLocationPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                permissions.toTypedArray(),
                ALL_PERMISSIONS_RESULT
            )

        }

    }

    private fun updateUI(location: Location?) {
        setProgress(View.GONE)
        val address = getAddressFromLocation(location)
        if (address != null && address?.countryName != null && SelectedCountry.country == null)
            updateCountriesAdapter(address)
        else
            view?.showSnackbar(getString(R.string.cant_access_location), 1000)
    }

    private fun updateCountriesAdapter(address: Address) {
        try {
            if (!countriesItems.isNullOrEmpty()) {
                countriesItems.takeIf { !it.isNullOrEmpty() }
                    ?.filter { it.code == address.countryCode }?.takeIf { it.isNotEmpty() }?.apply {
                        this[0].isChecked = true
                        SelectedCountry.country = this[0]
                    } ?: run {
                    countriesItems.toMutableList()[countriesItems.size - 1].isChecked = true
                }
                setupCountriesList(totalCountriesItems)
//                countriesAdapter.setItems(countriesItems)
            }
        } catch (e: Exception) {
            FirebaseCrashlytics.getInstance().log(e.toString())
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == ALL_PERMISSIONS_RESULT) {
            setProgress(View.GONE)
            if (checkLocationPermissionGranted()) {
//                detectLocation()
            }
        }
    }

    private fun showSettingsAlert() {
        try {
            val alertDialog = AlertDialog.Builder(requireActivity());
            alertDialog.setTitle(R.string.gps_not_enabled);
            alertDialog.setMessage(R.string.do_you_want_to_trun_on_gps);
            alertDialog.setPositiveButton(
                R.string.yes
            ) { dialog, which ->
                val intent = Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS)
                startActivityForResult(intent, REQUEST_OPEN_GPS)
            }

            alertDialog.setNegativeButton(R.string.no)
            { dialog, which ->
                dialog.dismiss()
            }

            alertDialog.show()
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_OPEN_GPS) {
//            detectLocation()
        }

    }

    override fun onNavigationResult(result: Bundle) {
        val country: CountryResponse? = result.getParcelable("selected_country")
        isShowCountriesView = true
        showCountriesView()
        default_content.visibility = View.GONE
        setupCountriesList(totalCountriesItems)
//        countriesAdapter.setItems(countriesItems)
        country?.let { onCountrySelected(it) }
    }

    override fun onCountrySelected(country: CountryResponse) {
        try {
            if (country.name != getText(R.string.other)) {
                SelectedCountry.country = country
                checkOldSelectedCountry()
                countriesItems.filter { it.isChecked }.takeIf { it.isNotEmpty() }
                    ?.map { it.isChecked = false }
                if (countriesItems.contains(country))
                    if (countriesItems.contains(country))
                        countriesItems[countriesItems.indexOf(country)].isChecked = true
                    else
                        countriesItems[countriesItems.size - 1].isChecked = true
                countriesAdapter.setItems(countriesItems)
                InsiderManager.changeCountry(country?.code!!)
            } else {
                goToCountriesListScreen()
            }
        } catch (e: Exception) {
            e.printStackTrace()
            setupCountriesList(totalCountriesItems)
        }
    }

    private fun goToCountriesListScreen() {
        viewModel.countriesList?.let {
            findNavController().navigate(
                SplashFragmentDirections.actionDestinationSplashToCountryFragment(
                    it.toTypedArray()
                )
            )
        }
    }


    private fun goToCitiesListScreen(langcode:String,countrycode:String) {
        /* viewModel.countriesList?.let {
             findNavController().navigate(
                 SplashFragmentDirections.actionDestinationSplashToCountryFragment(
                     it.toTypedArray()
                 )
             )
         }*/

        Log.d("TAG", "onCountrySelected: ${countrycode}")

        //InsiderManager.changeCountry(s)

        aviewModel = ViewModelProviders.of(
            this,
            viewModelFactoryAddress.create(App.getPref().currentLanguage.toString())
        ).get(AddressFragmentViewModel::class.java)


        viewModel.getCities(langcode,countrycode)



        viewModel.getCitiesLiveData.observe(this, Observer {



            when (it.status) {
                ResourceState.LOADING -> {
                    //    animationView.visibility = View.VISIBLE
                    //countries_progress.visibility= View.VISIBLE
                }
                ResourceState.ERROR -> {
                    //      animationView.visibility = View.GONE
                    // countries_progress.visibility= View.GONE
                    Log.e("TAG", "goToCitiesListScreen: ${it.message}")
                    //initCityView()

                }
                ResourceState.SUCCESS -> {
                    citiesList = it.data as java.util.ArrayList<CityModel>
                    //getAreaCount()
                    //initCityView()
                    //updateCityInfo()
                    Log.d("TAG", "goToCitiesListScreen: ${citiesList}")
                    //   animationView.visibility = View.GONE
                    //countries_progress.visibility= View.GONE
                    citiesList?.let {
                        /* findNavController().navigate(
                             SplashFragmentDirections.actionDestinationSplashToCitiesFragment(
                                 citiesList!!.toTypedArray()
                             )
                         )*/
                        /*goToCitiesListScreen(s)
                        goToCities(citiesList!!)*/

                        Log.d("TAG", "Cities : ${citiesList.toString()}")

                        //setupCitiesAdapter()

                        /* val intent = Intent (requireActivity(), ChooseCityActivity::class.java)
                         intent.putParcelableArrayListExtra(ChooseCityActivity.CITIES_LIST_HOLDER, citiesList!!)
                         intent.putParcelableArrayListExtra(ChooseCityActivity.AREA_LIST_HOLDER, null)
                         requireActivity().startActivity(intent)*/


                        citiesList?.let {
                            val intent = Intent(requireActivity(), ChooseCityActivity::class.java)
                            intent.putParcelableArrayListExtra(
                                ChooseCityActivity.CITIES_LIST_HOLDER,
                                citiesList!!
                            )
                            intent.putParcelableArrayListExtra(ChooseCityActivity.AREA_LIST_HOLDER, null)
                            requireActivity().startActivity(intent)
                        }
                    }

                }
                else -> {
                    //  animationView.visibility = View.VISIBLE
                }
            }
        })
    }

    private fun setupCitiesAdapter() {

        /* citiesList?.let {
             mmcitiesList= citiesList?.take(8) as ArrayList<CityModel>?
             mmcitiesList?.add(CityModel(0,0,"Other","أخرى","0"))
             horizontalCitiesAdapter= HorizontalCitiesAdapter(this,App.getPref().currentLanguage.toString())
             horizontalCitiesAdapter.setItems(mmcitiesList!!)
             rv_cities.apply {
                 adapter=horizontalCitiesAdapter
                 hasFixedSize()
                 layoutManager=LinearLayoutManager(requireContext(),LinearLayoutManager.HORIZONTAL,false)
                 visibility=View.VISIBLE
             }
             }
         */

        mmmcitiesList.let {
            horizontalCitiesAdapter= HorizontalCitiesAdapter(this,App.getPref().currentLanguage.toString(),requireContext())
            horizontalCitiesAdapter.setItems(mmmcitiesList!!)
            rv_cities.apply {
                adapter = horizontalCitiesAdapter
                hasFixedSize()
                layoutManager =
                    LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
                //visibility = View.VISIBLE
            }
        }
    }

    private fun goToCities(citiesList: ArrayList<CityModel>) {
        citiesList?.let {
            val intent = Intent (requireActivity(), ChooseCityActivity::class.java)
            intent.putParcelableArrayListExtra(ChooseCityActivity.CITIES_LIST_HOLDER, citiesList!!)
            intent.putParcelableArrayListExtra(ChooseCityActivity.AREA_LIST_HOLDER, null)
            requireActivity().startActivity(intent)
        }

    }

    override fun onCitySelected(city: CityModel) {
        if(city.code == "0"){
            goToCitiesListScreen(App.getPref().currentLanguage.toString(),saCountry?.code.toString())
           /* citiesList?.let {
                val intent = Intent(requireActivity(), ChooseCityActivity::class.java)
                intent.putParcelableArrayListExtra(
                    ChooseCityActivity.CITIES_LIST_HOLDER,
                    citiesList!!
                )
                intent.putParcelableArrayListExtra(ChooseCityActivity.AREA_LIST_HOLDER, null)
                requireActivity().startActivity(intent)
            }*/
        }else{

        }
    }







}
