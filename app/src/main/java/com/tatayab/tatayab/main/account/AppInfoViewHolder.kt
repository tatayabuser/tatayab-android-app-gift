package com.tatayab.tatayab.main.account

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.tatayab.model.account.ViewTypeAction
import com.tatayab.tatayab.BuildConfig
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.listener.OnAccountItemClick
import kotlinx.android.synthetic.main.account_item_app_setting.view.*


class AppInfoViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
    private val tvAppVersion = view.app_version
    private val signout = view.sign_out
    private val signoutGroup = view.sign_out_group
    private val share = view.share
    private val rate = view.rate_app
    fun bind(
        isLogin: Boolean,
        listener: OnAccountItemClick
    ) {
        val context = itemView.context
        signoutGroup.visibility = if (isLogin) View.VISIBLE else View.GONE
        tvAppVersion.text = (context.getText(R.string.app_version)).toString().plus(
            " ".plus(BuildConfig.VERSION_NAME).plus(" (")
                .plus(BuildConfig.VERSION_CODE).plus(")")
        )

        signout.setSafeOnClickListener {
            listener.onSettingItemSelected(ViewTypeAction.LOGOUT)
        }
        share.setSafeOnClickListener {
            listener.onSettingItemSelected(ViewTypeAction.SHARE)
        }
        rate.setSafeOnClickListener {
            listener.onSettingItemSelected(ViewTypeAction.RATEAPP)
        }
    }

}