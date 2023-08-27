package com.tatayab.model.responses.graph_responses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class CacheWishListItems(val products: List<CacheWishListItem>? = null) : Parcelable
@Parcelize
data class CacheWishListItem(
    val wishListId: Int?=0,
    val productSku: String?="",
    val options: Map<String, String>? = null
) : Parcelable