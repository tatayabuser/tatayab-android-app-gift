package com.tatayab.tatayab.splash

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.tatayab.model.responses.CountryResponse
import com.tatayab.presentation.countries.CountriesFragmentViewModel
import com.tatayab.presentation.countries.CountriesFragmentViewModelFactory
import com.tatayab.presentation.main.MainActivityViewModel
import com.tatayab.presentation.main.MainActivityViewModelFactory
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.insiderSDK.InsiderManager
import com.tatayab.tatayab.listener.OnCountryListener
import kotlinx.android.synthetic.main.fragment_country.*
import kotlinx.android.synthetic.main.toolbar_main_splash_country.*
import java.lang.Exception
import javax.inject.Inject

class CountryFragment : BaseFragment(), OnCountryListener {

    private lateinit var adapter: CountriesAdapter
    private var countriesList: Array<CountryResponse>? = null
    lateinit var viewModel: CountriesFragmentViewModel
    lateinit var mainViewModel: MainActivityViewModel
    @Inject
    lateinit var mainViewModelFactory: MainActivityViewModelFactory.Factory
    @Inject
    lateinit var viewModelFactoryCountries: CountriesFragmentViewModelFactory.Factory

    override fun layoutId(): Int {
        return R.layout.fragment_country
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(
                this,
                viewModelFactoryCountries.create(App.getPref().currentLanguage.toString())
            )
                .get(CountriesFragmentViewModel::class.java)
        mainViewModel = activity?.run {
            ViewModelProviders.of(
                this,
                mainViewModelFactory.create(App.getPref().currentLanguage.toString())
            )[MainActivityViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as MainActivity).hideBottomNavigation()
        rv_countries.layoutManager = LinearLayoutManager(requireContext())


        countriesList = arguments?.let {
            CountryFragmentArgs.fromBundle(it).countryList
        }
        countriesList?.let {
            if (currentCountrySelected != null) {
                it.map {
                    it.isChecked = it.code == currentCountrySelected?.code
                }
            }
            adapter = CountriesAdapter((it.toMutableList()), this)
            rv_countries.adapter = adapter

        }

        country_edit_search.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                adapter.search(p0.toString().trim())
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }
        })

        iv_close.setSafeOnClickListener {
            isChooseCountry = true
            val bundle = Bundle()
            bundle.putParcelable("selected_country", null)
            (activity as MainActivity).navigateBackWithResult(bundle)
        }
    }

    override fun onCountrySelected(country: CountryResponse) {
        try {
            countriesList?.let {
                it.map {
                    it.isChecked = false
                }
            }
            isChooseCountry = true
            country.isChecked = true
            viewModel?.clearMemoryCache()
            val bundle = Bundle()
            bundle.putParcelable("selected_country", country)
            (activity as MainActivity).navigateBackWithResult(bundle)
            mainViewModel?.getCountryCurrency()
            InsiderManager.changeCountry(country?.code!!)
            (activity as MainActivity).resetLoadAllHomeBlocksAgain()

        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}