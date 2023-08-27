package com.tatayab.model.account

import android.content.Context
import android.os.Parcelable
import com.tatayab.model.R
import kotlinx.android.parcel.Parcelize
import java.util.ArrayList

@Parcelize
data class CompositeAccountItem  (
    var userName :String?,
    var UserEmail : String?,
    var isLogin :Boolean,
    var countryName :String?,
    val SettingItems : List<AccountItem>
) : Parcelable

@Parcelize
data class AccountItem(
    var itemtitle: String = " ",
    var values:  ArrayList<ItemValue>? = null
): Parcelable


@Parcelize
data class ItemValue(
    var itemtitle: String = " ",
    var itemvalue: String = " ",
    var  itemIcon : Int ,
    var action: ViewTypeAction? = null
):Parcelable

