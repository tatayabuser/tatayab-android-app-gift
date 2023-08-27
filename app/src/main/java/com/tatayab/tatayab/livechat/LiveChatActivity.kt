package com.tatayab.tatayab.livechat

import android.os.Bundle
import com.tatayab.tatayab.R
import com.tatayab.tatayab.base.BaseActivity




class LiveChatActivity : BaseActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        overridePendingTransition(R.anim.slide_up, R.anim.no_animation);
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_livechat)
    }


    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.no_animation, R.anim.slide_down);
    }
}
