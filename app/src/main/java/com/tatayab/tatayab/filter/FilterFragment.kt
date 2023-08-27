package com.tatayab.tatayab.filter


import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.slider.RangeSlider
import com.tatayab.model.filter.ChildData
import com.tatayab.model.filter.ParentData
import com.tatayab.model.filter.Prices
import com.tatayab.presentation.filter.FilterFactory
import com.tatayab.presentation.product.ProductListFragmentViewModel
import com.tatayab.presentation.product.ProductListFragmentViewModelFactory
import com.tatayab.presentation.state.ResourceState
import com.tatayab.tatayab.App
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.filter.adapter.FilterAdapter
import com.tatayab.tatayab.filter.adapter.FilterListener
import com.tatayab.tatayab.util.Constants
import com.tatayab.tatayab.util.NavigationResult
import com.tatayab.tatayab.util.NumbersUtil
import kotlinx.android.synthetic.main.fragment_filter.*
import timber.log.Timber
import javax.inject.Inject


class FilterFragment : BaseFragment2(), FilterListener, NavigationResult {

    lateinit var viewModel: ProductListFragmentViewModel

    @Inject
    lateinit var viewModelFactory: ProductListFragmentViewModelFactory.Factory

    //    private var filterAdapter: MultiCheckFilterAdapter? = null
    private var filterAdapter: FilterAdapter? = FilterAdapter()
    //  private var updatePricesRange: Boolean = true  // to not update  priceRange if user slide it

    private val categoryId by lazy {
        arguments?.let {
            FilterFragmentArgs.fromBundle(
                it
            ).categoryId
        } ?: throw IllegalArgumentException("Expected arguments")
    }

    private val type by lazy {
        arguments?.let {
            FilterFragmentArgs.fromBundle(
                it
            ).categoryType
        } ?: throw IllegalArgumentException("Expected arguments")
    }

    private val graphKey by lazy {
        arguments?.let {
            FilterFragmentArgs.fromBundle(
                it
            ).graphKey
        } ?: throw IllegalArgumentException("Expected arguments")
    }


    override fun layoutId(): Int {
        return R.layout.fragment_filter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel = activity?.run {
            ViewModelProviders.of(
                this,
                viewModelFactory.create(
                    categoryId,
                    type,
                    App.getPref().currentLanguage.toString(),
                    graphKey
                )
            )[ProductListFragmentViewModel::class.java]
        } ?: throw Exception("Invalid Activity")
    }

    private fun setupPriceRangSlider(priceRange: Prices?) {
        try {
            if (priceRange?.max!!.toFloat() > priceRange.min.toFloat()) {
                price_filter.visibility = View.VISIBLE
                priceRange?.min?.let {
                    price_rang.valueFrom = it.toFloat()
                    max_value.text = NumbersUtil.formatNumber(
                        it.toFloat(),
                        viewModel.getDecimalNumbers()
                    ).plus(" ").plus(
                        viewModel.getCurrencyCode()
                    )
                }
                priceRange?.max?.let {
                    price_rang.valueTo = it.toFloat()
                    min_value.text = NumbersUtil.formatNumber(
                        it.toFloat(),
                        viewModel.getDecimalNumbers()
                    ).plus(" ").plus(
                        viewModel.getCurrencyCode()
                    )
                }
            } else
                price_filter.visibility = View.GONE

        } catch (e: Exception) {
            Timber.d(e.toString())
            price_filter.visibility = View.GONE
        }
    }

    private fun setupPriceWithData(it: Prices) {
        try {
            if (it?.max != null && it.max.toFloat() >= it.min.toFloat() && price_rang.valueTo >= it?.max!!.toFloat() && price_rang.valueFrom <= it?.min!!.toFloat()) {
                price_filter.visibility = View.VISIBLE
                price_rang.setValues(it.min.toFloat(), it.max.toFloat())
                input_min_price.setText(
                    NumbersUtil.formatNumber(
                        it.min.toFloat(),
                        viewModel.getDecimalNumbers()
                    ).plus(" ").plus(
                        viewModel.getCurrencyCode()
                    )
                )
                input_max_price.setText(
                    NumbersUtil.formatNumber(
                        it.max.toFloat(),
                        viewModel.getDecimalNumbers()
                    ).plus(" ").plus(
                        viewModel.getCurrencyCode()
                    )
                )

            } else
                price_filter.visibility = View.GONE
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupViewsWithData(filter: Pair<List<ParentData>, Prices>) {
        rv_filter.adapter = filterAdapter
        rv_filter.layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        viewModel.selectedParntFilterList = filter.first as ArrayList<ParentData>

        val filtersList = filter.first as ArrayList<ParentData>

        if (type == "supplier_ids")
           filtersList.removeIf { it.id == "manufacturer" }

        filterAdapter!!.setFilterList(filtersList)

       //viewModel.setSelectedFilterOption(filtersList)
        setupPriceRangSlider(FilterFactory.getPriceRange())
        setupPriceWithData(filter.second)
        if (viewModel.getFreeDelivery() != null)
            filterFreeDeliverySwitch.isChecked = viewModel.getFreeDelivery()!!

        if (viewModel.getDiscount() != null)
            filterDiscountsSwitch.isChecked = viewModel.getDiscount()!!
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intComponent()

        if (graphKey.isNotEmpty())
            viewModel.getFilterOptions(mapOf(graphKey to categoryId))
        else
            viewModel.getFilterOptions(mapOf(type to categoryId))

        filterAdapter!!.setListener(this)
        viewModel.getFilterLiveData.observe(viewLifecycleOwner, Observer { list ->
            when (list.status) {
                ResourceState.ERROR -> {
                    progress.visibility = View.GONE
                }
                ResourceState.SUCCESS -> {
                    progress.visibility = View.GONE
                    if (!list.data?.first.isNullOrEmpty()) {
                        setupViewsWithData(list.data!!)
                    }
                }
                else ->
                    progress.visibility = View.VISIBLE
            }
        })

    }


    private fun intComponent() {

        (activity as MainActivity).apply {
            this.hideBottomNavigation()
        }

        price_rang.addOnSliderTouchListener(object : RangeSlider.OnSliderTouchListener {
            override fun onStartTrackingTouch(slider: RangeSlider) {
                // Responds to when slider's touch event is being started
            }

            override fun onStopTrackingTouch(slider: RangeSlider) {
                /// reloadFilterList()
                setupPriceWithData(
                    Prices(
                        if (slider?.values?.size!! > 0) slider.values[0].toFloat().toString() else "",
                        if (slider?.values?.size!! > 1) slider.values[1].toFloat().toString() else ""
                    )
                )
                viewModel.setPrice(
                    Prices(
                        if (slider?.values?.size!! > 0) slider.values[0].toFloat().toString() else "",
                        if (slider?.values?.size!! > 1) slider.values[1].toFloat().toString() else ""
                    )
                )
            }
        })

        price_rang.setLabelFormatter { value: Float ->
            val format = NumbersUtil.formatNumber(value, viewModel.getDecimalNumbers())
                .plus(viewModel.getCurrencyCode())
            format.format()
        }

        iv_reset.setSafeOnClickListener {
                 resetPrice()
                resetFreeDeliveryAndDiscount()
                viewModel.resetFilter()
                //    updatePricesRange = true
                reloadFilterList()

        }

        iv_apply.setSafeOnClickListener {
            viewModel.isReseted = false
            if (viewModel.selectedParntFilterList.size > 0) {
                viewModel.setSelectedFilterOption(viewModel.selectedParntFilterList.toMutableList())
                viewModel.setFiltersMapValues(setSelectionOptionsToMap())
                val bundle = Bundle().apply {
                    putInt(Constants.FILTER_FRAGMENT, Constants.REQUEST_CODE_FILTER)
                }
                (activity as MainActivity).navigateBackWithResult(bundle)

            } else
                showErrorDialog(iv_apply, getText(R.string.not_filter_empty_list).toString())
        }

        filterFreeDeliverySwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            viewModel.setFreeDelivery(isChecked)
            //   updatePricesRange = true
            reloadFilterList()
        }

        filterDiscountsSwitch.setOnCheckedChangeListener { buttonView, isChecked ->
            viewModel.setDiscount(isChecked)
            //    updatePricesRange = true
            reloadFilterList()
        }
    }


    private fun setSelectionOptionsToMap(): LinkedHashMap<String, String> {
        val filterSelectedList: MutableList<String> = mutableListOf()
        viewModel.selectedParntFilterList.forEach {
            //                    val selectedList = (it as CheckedExpandableGroup)
            val childSelectedList: MutableList<String> = mutableListOf()
            for (child in it.items!!) {
                if (child.isChecked) {
                    childSelectedList.add(child.id!!)
                }
            }
            if (childSelectedList.size > 0) {
                filterSelectedList.add(
                    "${it.id}-${
                        childSelectedList.joinToString(
                            separator = "-"
                        )
                    }"
                )
            }
        }

        val map: LinkedHashMap<String, String> = LinkedHashMap()
        if (price_rang.values.size > 0 && price_filter.visibility == View.VISIBLE && price_rang.values[0] >= price_rang.valueFrom) {
            map["price_from"] = NumbersUtil.formatNumber(
                price_rang.values[0].toString().toFloat(),
                viewModel.getDecimalNumbers()
            ).toString()
        }

        if (price_rang.values.size > 1 && price_filter.visibility == View.VISIBLE && price_rang.values[1] <= price_rang.valueTo) {
            map["price_to"] = NumbersUtil.formatNumber(
                price_rang.values[1].toString().toFloat(),
                viewModel.getDecimalNumbers()
            ).toString()
        }
        if (filterSelectedList.size > 0) map["features_hash"] =
            if (com.tatayab.remote.util.Constants.ENABLE_GRAPH_QUERIES_CALLS) filterSelectedList.joinToString(
                separator = "#"
            )
            else filterSelectedList.joinToString(separator = "_")


        if (filterFreeDeliverySwitch.isChecked)
            map["free_delivery"] = "1"
        if (filterDiscountsSwitch.isChecked)
            map["discount"] = "1"

        return map

    }

    private fun resetPrice() {
        input_min_price.setText("")
        input_max_price.setText("")
    }

    private fun resetFreeDeliveryAndDiscount() {
        filterDiscountsSwitch.isChecked = false
        filterFreeDeliverySwitch.isChecked = false
    }

    override fun openOtionList(mParentData: ParentData) {
        val nextAction = FilterFragmentDirections.actionToFilterOptions(
            type,
            categoryId,
            viewModel.selectedParntFilterList.indexOf(mParentData).toString(),
            mParentData.title,
            mParentData.items?.map { childData -> childData.copy() }?.toTypedArray()
        )
        view?.let {
            findNavController().navigate(nextAction)
        }
    }


    private fun reloadFilterList() {
//        val featureMap = LinkedHashMap<String, String>()
//
//        if (!viewModel.isReseted) // not add new options if user want reset
//            featureMap.putAll(setSelectionOptionsToMap())
//
//        featureMap[type] = categoryId
//        if (graphKey.isNotEmpty())
//            featureMap[graphKey] = categoryId

        if (graphKey.isNotEmpty())
            viewModel.getFilterOptions(mapOf(graphKey to categoryId))
        else
            viewModel.getFilterOptions(mapOf(type to categoryId))

     }

    override fun onNavigationResult(result: Bundle) {
        try {
            val index = result.getInt(Constants.FILTER_PARENT_INDEX, 0)
            val filterOptions =
                result.getParcelableArray(Constants.FILTER_OPTIONS_VALUES)
                    ?.toCollection(ArrayList())

            if (!filterOptions.isNullOrEmpty()) {
                if (viewModel.selectedParntFilterList.get(index).items != filterOptions) {
                    viewModel.selectedParntFilterList.get(index).selectedItemsCount =
                        (filterOptions as java.util.ArrayList<ChildData>?)?.map { it.isChecked }?.size!!
                    viewModel.selectedParntFilterList.get(index).items?.clear()
                    viewModel.selectedParntFilterList.get(index).items = filterOptions
//                    reloadFilterList()
                    filterAdapter?.setFilterList(viewModel.selectedParntFilterList)
                    //  updatePricesRange = true
                    viewModel.isReseted = false
                }
            }
        } catch (c: Exception) {
            Log.d("exc", c.toString())
        }
    }

}