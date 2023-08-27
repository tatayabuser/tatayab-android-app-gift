package com.tatayab.model

import com.google.gson.annotations.SerializedName

data class Supplier(
    @SerializedName("logo") val logo: Logo?=null,
    @SerializedName("name") val name: String,
    @SerializedName("supplier_id") val supplier_id: String)