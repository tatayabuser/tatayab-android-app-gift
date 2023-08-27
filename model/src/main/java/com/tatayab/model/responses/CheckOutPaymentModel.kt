package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

class CheckOutPaymentModel(

    @SerializedName("name")
    val name: String? = null,
    @SerializedName("code")
    val code: String? = null,
    @SerializedName("id")
    val id: Int? = 0,
    @SerializedName("fees")
    val fees: String? = null,
    @SerializedName("is_selected")
    val is_selected: Int? = 0,
    @SerializedName("image")
    val image: String? = null

    )

//
//{"name":" K-net",
// "id":12,
// "fees":"",
// "is_selected":1
// ,"image":"https:\/\/tatayab.com\/images\/payment\/3\/lopp.png"
// }