package com.tatayab.tatayab.main.account

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.account.AccountItem
import com.tatayab.tatayab.listener.OnAccountItemClick

class AccountBlocksViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    lateinit var viewHolder: RecyclerView.ViewHolder
    fun bindToSetting(
        items: List<AccountItem>?,
        listener: OnAccountItemClick
    ) {
        viewHolder = UserSettingViewHolder(view)
        (viewHolder as UserSettingViewHolder).bind(items,listener)
    }

    fun bindToAppInfo(
        isLogin: Boolean,
        listener: OnAccountItemClick
    ) {
        viewHolder = AppInfoViewHolder(view)
        (viewHolder as AppInfoViewHolder).bind(isLogin,listener)
    }

    fun bindToUserInfo(
        isLogin: Boolean,
        userName: String?,
        userMail: String?,
        listener: OnAccountItemClick
    ) {
        viewHolder = UserInfoViewHolder(view)
        (viewHolder as UserInfoViewHolder).bind(isLogin,userName,userMail,listener)
    }


}
