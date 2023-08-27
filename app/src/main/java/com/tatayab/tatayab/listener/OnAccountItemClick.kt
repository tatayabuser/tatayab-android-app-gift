package com.tatayab.tatayab.listener

import com.tatayab.model.account.ViewTypeAction


interface OnAccountItemClick {
    fun onSettingItemSelected(actionType : ViewTypeAction)

}