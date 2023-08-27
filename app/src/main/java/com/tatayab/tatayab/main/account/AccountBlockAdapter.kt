package com.tatayab.tatayab.main.account

import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.account.AccountItem
import com.tatayab.model.account.CompositeAccountItem
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.inflate
import com.tatayab.tatayab.listener.OnAccountItemClick


class AccountBlockAdapter(val accountFragment: OnAccountItemClick) :
    RecyclerView.Adapter<AccountBlocksViewHolder>() {

    private var items: List<AccountItem>? = null
    private var userName: String? = " "
    private var userMail: String? = " "
    private var isLogin: Boolean = false


    fun setUserData(compositeAccountItem: CompositeAccountItem) {
        this.userName = compositeAccountItem.userName
        this.userMail = compositeAccountItem.UserEmail
        this.isLogin = compositeAccountItem.isLogin
        this.items = compositeAccountItem.SettingItems
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: AccountBlocksViewHolder, position: Int) {
        //Timber.d("Binding view holder at position $position")

        when (position) {
            0 -> {
                holder.bindToUserInfo(isLogin, userName, userMail, accountFragment)
            }
            1 -> {
                holder.bindToSetting(items, accountFragment)
            }
            2 -> {
                holder.bindToAppInfo(isLogin, accountFragment)
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AccountBlocksViewHolder {
        return when (viewType) {
            com.tatayab.model.account.ViewTypeLayout.USERSETTING.ordinal -> AccountBlocksViewHolder(
                parent.inflate(R.layout.account_item_user_settings)
            )
            com.tatayab.model.account.ViewTypeLayout.APPINFO.ordinal -> AccountBlocksViewHolder(
                parent.inflate(R.layout.account_item_app_setting)
            )
            com.tatayab.model.account.ViewTypeLayout.USERINFO.ordinal -> AccountBlocksViewHolder(
                parent.inflate(R.layout.account_item_user_info)
            )
            else -> throw IllegalArgumentException("Illegal value for viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> {
                com.tatayab.model.account.ViewTypeLayout.USERINFO.ordinal
            }
            1 -> {
                com.tatayab.model.account.ViewTypeLayout.USERSETTING.ordinal
            }
            else -> {
                com.tatayab.model.account.ViewTypeLayout.APPINFO.ordinal
            }
        }
    }


    override fun getItemCount(): Int = 3

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {

    }

}

