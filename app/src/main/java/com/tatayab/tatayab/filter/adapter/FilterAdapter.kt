package com.tatayab.tatayab.filter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.filter.ParentData
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import kotlinx.android.synthetic.main.list_item_parent_filter.view.*


class FilterAdapter() : RecyclerView.Adapter<FilterAdapter.FilterViewHolder>() {

    private var filterList: List<ParentData>? = null
    private lateinit var mFilterListener: FilterListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FilterViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_parent_filter, parent, false)
        return FilterViewHolder(view)
    }


    override fun onBindViewHolder(holder: FilterViewHolder, position: Int) {
        val filterItem = filterList?.get(position)

        with(holder) {
         //   if (filterItem?.selected == false)
            holder.bind(filterItem)
        }
    }

    fun setListener(mListener: FilterListener) {
        this.mFilterListener = mListener
    }

    override fun getItemCount(): Int {
        return filterList?.size ?: 0
    }

    open fun setFilterList(list: List<ParentData>) {
        var newList = ArrayList<ParentData>()
        list.map {
            if(it?.id.equals("price",true).not()){
                newList.add(it)
            }
        }
        this.filterList = newList
        notifyDataSetChanged()
    }

    inner class FilterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val filterTitleTextView = itemView.filterTitleTextView
        private val filterValueTextView = itemView.filterValueTextView
        private val vItem = itemView.item
        private var item: ParentData? = null
        private val context = itemView.item.context
        fun bind(
            item: ParentData?
        ) {
            this.item = item
            item?.let {
                filterTitleTextView.text = item!!.title
                vItem.setSafeOnClickListener {
                    if (mFilterListener != null) {
                        mFilterListener.openOtionList(item)
                    }
                }
                var selectedOptiosCount = 0
                for (option in it.items!!) {
                    if (option.isChecked)
                        selectedOptiosCount++
                }
                if (selectedOptiosCount > 0) {
                    filterValueTextView.text = selectedOptiosCount.toString()
                }else{
                    filterValueTextView.text = context.resources.getString(R.string.all_options)
                }
            }


        }

    }

}