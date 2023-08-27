package com.tatayab.tatayab.countries

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tatayab.model.responses.CountryResponse
import com.tatayab.presentation.base.MemoryCacheManager
import com.tatayab.presentation.countries.CountriesFragmentViewModel
import com.tatayab.presentation.countries.CountriesFragmentViewModelFactory
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.remote.util.Constants.Companion.ENABLE_GRAPH_QUERIES_CALLS
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnCountryListener
import com.tatayab.tatayab.util.DialogUtil
import kotlinx.android.synthetic.main.fragment_countries_list.*
import javax.inject.Inject

class CountriesFragment : BaseFragment(), OnCountryListener {

    override fun layoutId(): Int = R.layout.fragment_countries_list
    private lateinit var countryAdapter: CountriesAdapter
    private var countriesList: List<CountryResponse>? = null

    lateinit var viewModel: CountriesFragmentViewModel

    @Inject
    lateinit var viewModelFactoryCountries: CountriesFragmentViewModelFactory.Factory

    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory

    lateinit var mainViewModel: MainActivityViewModel
    private var selectedCountry: CountryResponse? = null


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        countryAdapter = CountriesAdapter(this)
        rv_countries.adapter = countryAdapter
    }

    override fun onCountrySelected(country: CountryResponse) {
        isChooseCountry = true
        selectedCountry = country
        viewModel?.clearMemoryCache()
        try {
//            mainViewModel?.updateUserTokenWithLangaugAndCountry(
//                App.getPref().firstUserToken,
//                country?.code,
//                App.getPref().currentLanguage.toString()
//            )
            mainViewModel?.removeCartIDsFromCache()
            mainViewModel?.loadAllHomeBlocksAgain()
            InsiderManager.changeCountry(country?.code!!)
            MemoryCacheManager.AddCountryCode(country?.code!!)
            MemoryCacheManager.addCurrencyCode(country?.currency_code!!)
            MemoryCacheManager.addCountryPhoneCode(country?.phone_start!!)
            if (selectedCountry != null) viewModel.saveUserSetting(selectedCountry!!)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun restartWithCurrentCountry() {
        val intent = activity?.intent
        activity?.finish()
        activity?.startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactoryCountries.create(App.getPref().currentLanguage.toString())
            )
                .get(CountriesFragmentViewModel::class.java)

        viewModel?.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
        mainViewModel?.ENABLE_GRAPH_QUERIES_CALLS = ENABLE_GRAPH_QUERIES_CALLS

        mainViewModel.getUpdateTokenLiveData.observe(this, Observer {
            try {
                when (it.status) {
                    ResourceState.ERROR -> {
                        animationView.visibility = View.GONE
                        if (selectedCountry != null) viewModel.saveUserSetting(selectedCountry!!)
                    }
                    ResourceState.SUCCESS -> {
                        animationView.visibility = View.GONE
                        if (selectedCountry != null) viewModel.saveUserSetting(selectedCountry!!)
                    }
                    ResourceState.LOADING -> {
                        animationView.visibility = View.VISIBLE
                    }

                }
            } catch (e: Exception) {
                e.printStackTrace()
            }
        })
        viewModel.getCountriesLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    animationView.visibility = View.GONE
                    it.data?.let { it1 -> setupViewData(it1) }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getMergeCartLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    restartWithCurrentCountry()
                }
                ResourceState.SUCCESS -> {
                    restartWithCurrentCountry()
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

        viewModel.getSaveUserSettingLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    animationView.visibility = View.GONE
                    if (!it.message.isNullOrEmpty())
                        showCustomTopMessage(it.message!!, DialogUtil.MessageType.ERROR)
                    else
                        showCustomTopMessage(
                            getText(R.string.error_occure).toString(),
                            DialogUtil.MessageType.ERROR
                        )
                }
                ResourceState.SUCCESS -> {
                    // merge cart if there are an items in cart
                    var cartID = viewModel?.getCartID()
                    if (cartID.isNullOrBlank()) {
                        restartWithCurrentCountry()
                    } else {
                        viewModel?.mergeCarts(cartID)
                    }
                }
                else -> {
                    animationView.visibility = View.VISIBLE
                }
            }
        })

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        country_edit_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                countryAdapter.setData(
                    viewModel.searchOnCountryList(
                        p0.toString().trim(),
                        countriesList
                    )
                )
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })
//        viewModel.getCountries()
//        viewModel.getCurrencies()
    }

    private fun setupViewData(data: List<CountryResponse>) {
        var countryList =
            viewModel.sortTheCountriesBasedOnLocation(data as ArrayList<CountryResponse>)
        this.countriesList = countryList
        countryAdapter.setData(countryList)
    }
}
