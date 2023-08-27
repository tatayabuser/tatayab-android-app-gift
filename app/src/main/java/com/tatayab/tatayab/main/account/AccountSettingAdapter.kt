package com.tatayab.tatayab.main.account

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.account.AccountItem
import com.tatayab.tatayab.R
import com.tatayab.tatayab.listener.OnAccountItemClick
import kotlinx.android.synthetic.main.account_item_user_setting.view.*


class AccountSettingAdapter(
    val items: List<AccountItem>?,
    val listener: OnAccountItemClick
) :
    RecyclerView.Adapter<AccountSettingAdapter.ViewHolder>() {

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Timber.d("Binding view holder at position $position")
        val item = items?.get(position)
        holder.bind(item,listener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view: View? =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.account_item_user_setting, parent, false)

        return ViewHolder(view!!)
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    override fun getItemCount(): Int = items?.size ?: 0


    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

        val items = view.rv_setting_items
        val title = view.tv_setting_title
        val context: Context = view.context
        fun bind(
            item: AccountItem?,
            listener: OnAccountItemClick
        ) {
            title.text = item?.itemtitle
            items.adapter = AccountSettingValuesAdapter(item?.values,listener)

        }

    }

}

