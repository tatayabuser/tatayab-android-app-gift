package com.tatayab.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CartMap(val cartId: String, val cartValue: MapValueXXX) : Parcelable