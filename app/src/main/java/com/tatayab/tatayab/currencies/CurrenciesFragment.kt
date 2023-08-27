package com.tatayab.tatayab.currencies

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tatayab.model.responses.CurrencyResponse
import com.tatayab.presentation.curriencies.CurrenciesFragmentViewModel
import com.tatayab.presentation.curriencies.CurrenciesFragmentViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment
import com.tatayab.tatayab.listener.OnCurrencyListener
import kotlinx.android.synthetic.main.fragment_currencies_list.*
import javax.inject.Inject

class CurrenciesFragment : BaseFragment(), OnCurrencyListener {

    lateinit var viewModel: CurrenciesFragmentViewModel

    @Inject
    lateinit var viewModelFactoryCountries: CurrenciesFragmentViewModelFactory.Factory

    override fun onCurrencySelected(currencyId: CurrencyResponse) {
        viewModel.saveUserSetting(currencyId)
    }

    override fun layoutId(): Int = R.layout.fragment_currencies_list
    private lateinit var currenciesAdapter: CurrenciesAdapter

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        currenciesAdapter = CurrenciesAdapter(this)
        rv_curriences.adapter = currenciesAdapter
    }

    private fun restartWithCurrentCurrency() {
        val intent = activity?.intent
        activity?.finish()
        activity?.startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel =
            ViewModelProviders.of(this, viewModelFactoryCountries.create(App.getPref().currentLanguage.toString()))
                .get(CurrenciesFragmentViewModel::class.java)

        currenciesAdapter = CurrenciesAdapter(this)

        viewModel.getCurrenciesLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    setProgress(View.GONE)
                    it.data?.let { it1 -> setupViewData(it1) }
                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })
        viewModel.getSaveUserSettingLiveData.observe(this, Observer {
            when (it.status) {
                ResourceState.ERROR -> {
                    setProgress(View.GONE)
                }
                ResourceState.SUCCESS -> {
                    restartWithCurrentCurrency()
                }
                else -> {
                    setProgress(View.VISIBLE)
                }
            }
        })

    }

    private fun setupViewData(data: List<CurrencyResponse>) {
        currenciesAdapter.setData(data)
    }

}
