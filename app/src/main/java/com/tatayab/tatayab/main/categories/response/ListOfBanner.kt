package com.tatayab.tatayab.main.categories.response

 import android.os.Parcelable
 import com.tatayab.model.responses.Child
import kotlinx.android.parcel.Parcelize


@Parcelize
data class ListOfBanner( val bannerList : ArrayList<Child>) : Parcelable