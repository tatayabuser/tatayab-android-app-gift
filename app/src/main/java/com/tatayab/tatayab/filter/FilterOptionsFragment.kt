package com.tatayab.tatayab.filter


import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.filter.ChildData
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseFragment2
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.filter.adapter.FilterOptionsAdapter
import com.tatayab.tatayab.filter.adapter.OptionListener
import com.tatayab.tatayab.util.Constants
import kotlinx.android.synthetic.main.fragment_filter_options.*
import kotlinx.android.synthetic.main.toolbar_with_back.*


class FilterOptionsFragment() : BaseFragment2(), OptionListener {


    private lateinit var mFilterOptionsAdapter: FilterOptionsAdapter
    private var filterOptionList: ArrayList<ChildData> = ArrayList()
    private var searchFilterOptionList: ArrayList<ChildData> = ArrayList()
    private var selectAll = false


    private val type by lazy {
        arguments?.let {
            FilterOptionsFragmentArgs.fromBundle(
                it
            ).categoryType
        } ?: throw IllegalArgumentException("Expected arguments")
    }

    private val parentTitle by lazy {
        arguments?.let {
            FilterOptionsFragmentArgs.fromBundle(
                it
            ).parentTitle
        } ?: throw IllegalArgumentException("Expected arguments")
    }

    private val parentIndex by lazy {
        arguments?.let {
            FilterOptionsFragmentArgs.fromBundle(
                it
            ).parentIndex
        } ?: throw IllegalArgumentException("Expected arguments")
    }

    private val optionItems by lazy {
        arguments?.let {
            FilterOptionsFragmentArgs.fromBundle(
                it
            ).optionItems
        } ?: throw IllegalArgumentException("Expected arguments")
    }


    override fun layoutId(): Int {
        return R.layout.fragment_filter_options
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        intComponent()
    }


    private fun intComponent() {
        mFilterOptionsAdapter = FilterOptionsAdapter()
        rv_filter_options.layoutManager =
            LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
        rv_filter_options.adapter = mFilterOptionsAdapter
        select_all.visibility = View.VISIBLE
        tv_title.text = parentTitle
        filterOptionList.clear()
        if (!optionItems.isNullOrEmpty()) {
            filterOptionList = optionItems.toCollection(ArrayList())
            mFilterOptionsAdapter.setOptionListener(this)
            mFilterOptionsAdapter.setfilterOptionList(optionItems.toList())
        }
        (activity as MainActivity).apply {
            this.hideBottomNavigation()
        }

        clearSearchText.setSafeOnClickListener {
            edSearch.setText("")
            clearSearchText.visibility = View.GONE
        }

        select_all.setSafeOnClickListener {
            if (!selectAll) {
                mFilterOptionsAdapter.getfilterOptionList()?.map {
                    it.isChecked = true
                    this.selectOption(it)
                    select_all.text = getText(R.string.un_select_all)
                }
                selectAll = true
            } else {
                mFilterOptionsAdapter.getfilterOptionList()?.map {
                    it.isChecked = false
                    this.unSelectOption(it)
                    select_all.text = getText(R.string.select_all)
                }
                selectAll = false
            }

            mFilterOptionsAdapter.notifyDataSetChanged()
        }

        edSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable) {
                filterOptions(s.toString())
            }
        })

        iv_apply.setSafeOnClickListener {
            val bundle = Bundle().apply {
                putInt(Constants.FILTER_PARENT_INDEX, parentIndex.toInt())
                putParcelableArray(Constants.FILTER_OPTIONS_VALUES, optionItems)
            }
            (activity as MainActivity).navigateBackWithResult(bundle)
        }

    }

    private fun filterOptions(filterText: String) {
        searchFilterOptionList.clear()
        for (option in filterOptionList) {
            if (option.name?.toLowerCase()?.startsWith(filterText.toLowerCase()!!)!!) {
                searchFilterOptionList.add(option)
            }
        }
        if (searchFilterOptionList.size == 0)
            mFilterOptionsAdapter.setfilterOptionList(filterOptionList)
        else
            mFilterOptionsAdapter.setfilterOptionList(searchFilterOptionList)
    }

    override fun selectOption(mChildData: ChildData) {
        changeItemState(mChildData, true)
    }

    private fun changeItemState(mChildData: ChildData, state: Boolean) {
        for (child in mFilterOptionsAdapter.getfilterOptionList()!!) {
            if (child.id.equals(mChildData.id, true)) {
                child.isChecked = state
                return
            }
        }
    }

    override fun unSelectOption(mChildData: ChildData) {
        changeItemState(mChildData, false)
    }
}





