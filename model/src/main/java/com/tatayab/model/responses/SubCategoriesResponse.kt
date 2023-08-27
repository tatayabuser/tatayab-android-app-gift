package com.tatayab.model.responses

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

data class SubCategoriesResponse(
    val category_id: String?=null,
    val category_uid: String?=null,
    var childs: ArrayList<Child>? = null,
    var mainCategoriesList: ArrayList<CategoryModel>?=null,
    val image_path: String? = null,
    var name: String,
    var hasSubCat: Boolean = false,
    var isBanner : Boolean = false,
    var  mCategoryBannerResponse: SliderBannersModel? = null
) {
    var categoryType : BannerType? = BannerType.sub_category
}

@Parcelize
data class Child(
    val category_id: String?,
    val image_path: String?,
    val name: String?,
    val category_uid: String?=""
    ) : Parcelable {
    var url: String? = null

}
@Parcelize
data class CategoryModel(
    val category_id: String?=null,
    val category_uid: String?=null,
      val image_path: String? = null,
    var name: String,
     var isBanner : Boolean = false,
    var  mCategoryBannerResponse: SliderBannersModel? = null
    ) : Parcelable

enum class BannerType {
    slider_banners,
    best_sellers_banners,
    top_selling_banners,
    editor_choice_banners,
    shop_by_brand,
    sub_category
}