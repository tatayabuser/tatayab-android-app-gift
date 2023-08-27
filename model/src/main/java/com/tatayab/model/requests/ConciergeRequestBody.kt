package com.tatayab.model.requests


import com.google.gson.annotations.SerializedName

data class ConciergeRequestBody(

     @SerializedName("perfume_name")
     var perfume_name: String? =null,
     @SerializedName("comment")
     var comment: String? =null,
     @SerializedName("cust_name")
     var cust_name: String? =null,
     @SerializedName("phone")
     var phone: String? =null,
     @SerializedName("country_code")
     var country_code: String? =null,
     @SerializedName("image_data")
     var image_data: String? =null
)