package com.tatayab.tatayab.addresses

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.text.TextWatcher
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.tatayab.model.responses.AreaModel
import com.tatayab.model.responses.CityModel
import com.tatayab.model.responses.SelectCityOrAreaModel
import com.tatayab.presentation.address.ChooseCityActivityViewModel
import com.tatayab.tatayab.App
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseActivity
import com.tatayab.tatayab.listener.CityListener
import kotlinx.android.synthetic.main.activity_choose_city.*
import kotlinx.android.synthetic.main.toolbar_choose_city.*


class ChooseCityActivity : BaseActivity(), CityListener {
    var citiesList: List<CityModel>? = null
    var areaList: List<AreaModel>? = null
    var items: ArrayList<SelectCityOrAreaModel> = ArrayList<SelectCityOrAreaModel>()
    var isForArea = false

    var adapter: CityAdapter? = null
    private lateinit var viewModel: ChooseCityActivityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_up, R.anim.no_animation)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_choose_city)
        // Hide tool bar
        val actionBar = supportActionBar
        actionBar?.hide()

        viewModel =
            ViewModelProviders.of(
                this
            ).get(ChooseCityActivityViewModel::class.java)

        if (intent.extras != null) {
            if (intent!!.extras!!.containsKey(CITIES_LIST_HOLDER)) {
                citiesList = intent!!.extras!!.getParcelableArrayList<CityModel>(CITIES_LIST_HOLDER)
            }
            if (intent!!.extras!!.containsKey(AREA_LIST_HOLDER)) {
                areaList = intent!!.extras!!.getParcelableArrayList<AreaModel>(AREA_LIST_HOLDER)
            }
            if (areaList != null) isForArea = true
        }


        initSubscribtions()
        initView()
        initEventAction()
    }

    private fun initSubscribtions() {
        viewModel.getItemsFilterLiveData.observe(this, Observer {
            if (adapter != null)
                adapter!!.setData(it)
        })
        viewModel.getItemsLiveData.observe(this, Observer {
            items = it
            if (it.size > 0) {
                // update adapter
                adapter!!.setData(it)
            }
        })
    }

    private fun initEventAction() {
        ed_search.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(txt: Editable) {
                if (!TextUtils.isEmpty(txt.toString()))
                    viewModel.getListAfterFilteration(items, txt.toString())
                else {
                    if (adapter != null)
                        adapter!!.setData(items)
                }
            }
        })

    }

    private fun initView() {
        if (isForArea) {
            ed_search.hint = getString(R.string.search_on_area)
        } else {
            ed_search.hint = getString(R.string.search_on_city)
        }
        adapter = CityAdapter(this, App.getPref().currentLanguage.toString(),this)
        citiesRecyclerView.adapter = adapter
        viewModel.getItems(citiesList, areaList)
    }


    override fun onCitySelected(city: SelectCityOrAreaModel) {
        val returnIntent = Intent()
        returnIntent.putExtra(CITIE_HOLDER, city)
        setResult(RESULT_OK, returnIntent)
        finish()
    }

    companion object {
        val CITIES_LIST_HOLDER = "CITIES_LIST_HOLDER"
        val CITIE_HOLDER = "CITIE_HOLDER"
        val AREA_LIST_HOLDER = "AREA_LIST_HOLDER"
        val START_FORE_RESULT_ID_HOLDER = 33456


        fun getInstance(
            activity: Context, citiesList: ArrayList<CityModel>?,
            areaList: ArrayList<AreaModel>?
        ): Intent {
            var intent = Intent(activity, ChooseCityActivity::class.java)
            if (citiesList != null) {
                intent.putParcelableArrayListExtra(CITIES_LIST_HOLDER, citiesList!!)
            }
            if (areaList != null) {
                intent.putParcelableArrayListExtra(AREA_LIST_HOLDER, areaList!!)
            }

            return intent;
        }
    }
}
