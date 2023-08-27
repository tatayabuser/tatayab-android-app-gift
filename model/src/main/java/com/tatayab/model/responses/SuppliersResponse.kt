package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName
import com.tatayab.model.Supplier
import com.tatayab.model.SuppliersParams

data class SuppliersResponse(
    @SerializedName("params") val params: SuppliersParams?,
    @SerializedName("suppliers") val suppliers: List<Supplier>?
)
