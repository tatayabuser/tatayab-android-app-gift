package com.tatayab.model.filter

import android.os.Parcel
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ChildData (
    var name: String? ,
    var id: String? ,
    var parentId: String? ,
    var isChecked: Boolean = false
) : Parcelable