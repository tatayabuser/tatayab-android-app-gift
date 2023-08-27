package com.tatayab.model.db

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize


@Parcelize
data class CustomerAddress(
    var addressId:Long,
    var userId: String,
    var title: String,
    var shippingAddress: String,
    var billingAddress: String,
    var city: String,
    var country: String,
    var zipCode: String,
    var isPrimary: Boolean
):Parcelable