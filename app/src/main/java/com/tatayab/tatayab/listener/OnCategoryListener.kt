package com.tatayab.tatayab.listener

import com.tatayab.model.Product
import com.tatayab.model.responses.Child


interface OnCategoryListener {
    fun onCategorySelected(categoryId: String,categoryName:String)
    fun onSubCategorySelected(categoryId: String?,categoryName:String?)
    fun onBannerSelected(categoryId: String?,url:String)
    fun onBannerSeeMoreSelected(categoryId: String,bannerList: ArrayList<Child>,bannerTitle:String, bannerType : Int)
}