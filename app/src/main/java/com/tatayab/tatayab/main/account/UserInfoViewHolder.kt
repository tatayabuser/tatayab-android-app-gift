package com.tatayab.tatayab.main.account

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.account.ViewTypeAction
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnAccountItemClick
import kotlinx.android.synthetic.main.account_item_user_info.view.*


class UserInfoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val tv_name = view.tv_name
    private val tv_mail = view.tv_mail
    private val tv_login = view.tv_login

    fun bind(
        isLogin: Boolean,
        userName: String?,
        userMail: String?,
        listener: OnAccountItemClick
    ) {
        val context = itemView.context
        tv_login.visibility = if (!isLogin) View.VISIBLE else View.GONE

        tv_login.setSafeOnClickListener {
            listener.onSettingItemSelected(ViewTypeAction.LOGIN)
        }
        if (isLogin) {
            tv_name.text = if(userName.isNullOrBlank()) context.getText(R.string.welcome_to_tatayab) else userName
            tv_mail.text = userMail
        } else {
            tv_name.text = context.getText(R.string.welcome_to_tatayab)
            tv_mail.text = context.getText(R.string.login_description)
        }

    }

}