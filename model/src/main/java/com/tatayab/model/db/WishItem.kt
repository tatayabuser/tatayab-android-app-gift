package com.tatayab.model.db

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
 class WishItem ( val userId: String,
                 val produectId: String,
                 val countryId: String
                 ) : Parcelable