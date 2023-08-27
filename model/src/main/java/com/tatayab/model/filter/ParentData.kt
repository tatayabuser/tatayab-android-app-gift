package com.tatayab.model.filter

import android.annotation.SuppressLint
import java.util.*

@SuppressLint("ParcelCreator")
data  class ParentData(
    val title: String,
    val id: String,
    var items: ArrayList<ChildData>?,
    var selectedItemsCount: Int = 0
)