package com.tatayab.tatayab.main.account

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.account.AccountItem
import com.tatayab.tatayab.listener.OnAccountItemClick
import kotlinx.android.synthetic.main.account_item_user_settings.view.*


class UserSettingViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val rv_setting_items = view.rv_setting_items
    fun bind(
        items: List<AccountItem>?,
        listener: OnAccountItemClick
    ) {
        val context = itemView.context
        val settingAdapter = AccountSettingAdapter(items,listener)
        rv_setting_items.adapter = settingAdapter
    }

}