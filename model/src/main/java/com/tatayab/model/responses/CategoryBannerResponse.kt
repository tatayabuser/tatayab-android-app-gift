package com.tatayab.model.responses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class CategoryBannerResponse(val status: Int, val data: BannerData)

data class BannerData(
    val slider_banners: SliderBannersModel,
    val best_sellers_banners: SliderBannersModel,
    val top_selling_banners: SliderBannersModel,
    val editor_choice_banners: SliderBannersModel,
    val shop_by_brand: ShopBrandModel ){
    var catId:String = ""
}
@Parcelize
data class SliderBannersModel(val title: String, val content: ArrayList<ContentModel>): Parcelable {
    var catId:String = ""
}
data class ShopBrandModel(val title: String, val content: ArrayList<ShopContentModel>){
    var catId:String = ""
}
@Parcelize
data class ContentModel(
    val banner_id: String?=null,
    val banner: String?=null,
    val image: String?=null,
    val url: String?=null
):Parcelable

data class ShopContentModel(
    val id: String,
    val title: String,
    val url: String
)
