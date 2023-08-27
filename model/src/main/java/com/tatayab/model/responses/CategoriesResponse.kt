package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName
import com.tatayab.model.Category
import com.tatayab.model.Params

data class CategoriesResponse(
    val categories: List<CategoryItem>
)