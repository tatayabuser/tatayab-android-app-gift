package com.tatayab.tatayab.main.account

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.account.ItemValue
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnAccountItemClick
import kotlinx.android.synthetic.main.account_setting_item.view.*
import timber.log.Timber
import java.util.ArrayList


class AccountSettingValuesAdapter(
    private val items: ArrayList<ItemValue>?,
   val  listener: OnAccountItemClick
) : RecyclerView.Adapter<AccountSettingValuesAdapter.ViewHolder>() {


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Timber.d("Binding view holder at position $position")
        val item = items?.get(position)
        holder.bind(item!!,listener,position)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View? =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.account_setting_item, parent, false)

        return ViewHolder(view!!)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = items?.size ?: 0


    inner class ViewHolder(private val view: View ) : RecyclerView.ViewHolder(view) {

        private val settingItem = view.tv_title
        private val settingItemValue = view.tv_value
        private val delimiter = view.view_after_language
        val context = view.context

        fun bind(
            itemValue: ItemValue,
            listener: OnAccountItemClick,
            position: Int
        ) {
            settingItem.text = itemValue.itemtitle
            settingItem.setCompoundDrawablesRelativeWithIntrinsicBounds(itemValue.itemIcon, 0,0, 0);
            settingItemValue.text =itemValue.itemvalue
            if (position == items?.size!!-1)
                delimiter.visibility = View.GONE
            
            itemView.setSafeOnClickListener {
                listener.onSettingItemSelected(itemValue.action!!)
            }
        }

    }

}

