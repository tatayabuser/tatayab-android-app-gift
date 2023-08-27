package com.tatayab.tatayab.filter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.filter.ChildData
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import kotlinx.android.synthetic.main.list_item_child_filter.view.*


class FilterOptionsAdapter() : RecyclerView.Adapter<FilterOptionsAdapter.FilterOptionViewHolder>() {

    private var filterOptionList: List<ChildData>? = null
    lateinit var mOptionListener: OptionListener
    lateinit var parentId: String


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterOptionViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_child_filter, parent, false)
        return FilterOptionViewHolder(view)
    }


    override fun onBindViewHolder(holder: FilterOptionViewHolder, position: Int) {
        val filterItem = filterOptionList?.get(position)

        with(holder) {
            holder.bind(filterItem)
        }
    }


    override fun getItemCount(): Int {
        return filterOptionList?.size ?: 0
    }

    fun setfilterOptionList(list: List<ChildData>) {
        this.filterOptionList = list
        // this.parentId = parentId
        notifyDataSetChanged()
    }


    fun getfilterOptionList(): List<ChildData>? = this.filterOptionList

    fun setOptionListener(listener: OptionListener) {
        this.mOptionListener = listener
    }

    inner class FilterOptionViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val filterValueCheckedTextView = itemView.tv_filter_value
        private val filtercheckBox = itemView.tv_filter_checkBox
        private val item_container = itemView.option_item_container
        private var item: ChildData? = null
        fun bind(item: ChildData?) {
            this.item = item
            item?.let {
                filterValueCheckedTextView.text = item.name
                filtercheckBox.isChecked = item.isChecked
                item_container.setSafeOnClickListener {
                    if (!filtercheckBox.isChecked) {
                        mOptionListener.selectOption(item)
                        filtercheckBox.isChecked = true
                        item.isChecked = true
                    } else {
                        mOptionListener.unSelectOption(item)
                        filtercheckBox.isChecked = false
                        item.isChecked = false
                    }
                }

                filtercheckBox.setOnCheckedChangeListener { buttonView, isChecked ->
                    if (isChecked) {
                        mOptionListener.selectOption(item)
                        filtercheckBox.isChecked = true
                        item.isChecked = true
                    } else {
                        mOptionListener.unSelectOption(item)
                        filtercheckBox.isChecked = false

                    }
                }
            }
        }
    }
}