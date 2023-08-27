package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName
import com.tatayab.model.ProductX

data class HomeProductResponse(
    @SerializedName("products") val products: List<ProductX>
)