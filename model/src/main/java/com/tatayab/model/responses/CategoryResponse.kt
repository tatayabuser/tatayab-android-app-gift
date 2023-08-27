package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName
import com.tatayab.model.Category
import com.tatayab.model.Params

data class CategoryResponse(
    @SerializedName("categories") val categories: List<Category>,
    @SerializedName("params") val params: Params
)