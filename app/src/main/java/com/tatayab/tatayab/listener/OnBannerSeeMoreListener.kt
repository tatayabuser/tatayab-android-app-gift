package com.tatayab.tatayab.listener

import com.tatayab.model.Product
import com.tatayab.model.responses.Child


interface OnBannerSeeMoreListener {
     fun onBannerSelected(categoryId: String?,url:String)
 }