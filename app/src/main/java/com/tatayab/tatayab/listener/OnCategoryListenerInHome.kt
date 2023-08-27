package com.tatayab.tatayab.listener

import com.tatayab.model.Product


interface OnCategoryListenerInHome {
    fun onCategorySelected(categoryId: String,categoryName:String)
}