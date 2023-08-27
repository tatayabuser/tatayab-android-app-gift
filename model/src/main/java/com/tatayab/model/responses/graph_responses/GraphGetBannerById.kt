package com.tatayab.model.responses.graph_responses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class GraphGetBannerById(val data: DataPromoBannerById)
data class DataPromoBannerById(val mpPromoBannerById: PromoBannerById)
data class PromoBannerById(val items: List<GraphBannerItem>)
@Parcelize data class GraphBannerItem(val banner_image: String?, val slider_images: String?,val url : String?, val banner:String?="") : Parcelable
@Parcelize
data class SliderImageItem(val image: String?="", val url: String?= "") : Parcelable