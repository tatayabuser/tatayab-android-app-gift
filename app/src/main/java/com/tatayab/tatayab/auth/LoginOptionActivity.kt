
package com.tatayab.tatayab.auth

import android.content.Intent
import android.os.Bundle
import com.tatayab.tatayab.MainActivity
import com.tatayab.tatayab.R
import com.tatayab.tatayab.ext.setSafeOnClickListener
import com.tatayab.tatayab.refer.ReferFriendSuccessActivity
import kotlinx.android.synthetic.main.toolbar_with_back.*


class LoginOptionActivity : MainActivity() {

    open var invitationUrl:String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_options)
        intent?.extras?.let {
            invitationUrl = it.getString(ReferFriendSuccessActivity.INVITATION_URL_HOLDER, "")
        }

    }

    override fun onBackPressed() {
            this.finish()
    }

    open fun closeScreen(){
        this.finish()
    }

    fun openReferFriendSuccess() {
        if (!this.invitationUrl.isNullOrEmpty()) {
            var deepLinkIntent =
                Intent(this, ReferFriendSuccessActivity::class.java)
            deepLinkIntent?.putExtra(
                ReferFriendSuccessActivity.INVITATION_URL_HOLDER,
                this.invitationUrl
            )
            deepLinkIntent?.let {
                startActivity(it)
            }
        }
        finish()
    }
}
