package com.tatayab.tatayab.filter.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.filter.SortItem
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnSortListener
import kotlinx.android.synthetic.main.list_item_sort.view.*


class SortAdapter(
    private val listener: OnSortListener
) : RecyclerView.Adapter<SortAdapter.SortViewHolder>() {

    private var sortList: List<SortItem>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SortViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_sort, parent, false)
        return SortViewHolder(view)
    }


    override fun onBindViewHolder(holder: SortViewHolder, position: Int) {
        val sortItem = sortList?.get(position)

        with(holder) {
            holder.bind(sortItem, position)
            sortItem?.let { item ->
                itemView.setSafeOnClickListener {
                    listener.onSortOptionChecked(item)
                }
            }
        }
    }


    override fun getItemCount(): Int {
        return sortList?.size ?: 0
    }

    fun setSortList(list: List<SortItem>) {
        this.sortList = list
        notifyDataSetChanged()
    }

    inner class SortViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val itemName = itemView.tv_sort_by
        private var item: SortItem? = null
        private val context = itemView.tv_sort_by.context
        fun bind(
            item: SortItem?,
            position: Int
        ) {
            this.item = item
            itemName.text = item!!.itemName
            itemName.isChecked = item.checked

        }

    }

}