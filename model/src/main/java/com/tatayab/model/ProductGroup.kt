package com.tatayab.model


import com.google.gson.annotations.SerializedName
import com.tatayab.model.responses.MapValueX
import com.tatayab.model.responses.MapValueXX

data class ProductGroup(
    @SerializedName("all_edp_free_shipping")
    val allEdpFreeShipping: Boolean,
    @SerializedName("all_free_shipping")
    val allFreeShipping: Boolean,
    @SerializedName("company_id")
    val companyId: Int,
    @SerializedName("free_shipping")
    val freeShipping: Boolean,
    @SerializedName("name")
    val name: String,
    @SerializedName("products")
    val products: Map<String, MapValueX>,
    @SerializedName("shipping_no_required")
    val shippingNoRequired: Boolean,
    @SerializedName("shippings")
    val shippings: Map<String, MapValueXX>,
    @SerializedName("supplier_id")
    val supplierId: Int
)