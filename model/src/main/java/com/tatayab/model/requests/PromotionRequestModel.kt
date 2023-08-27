package com.tatayab.model.requests

import com.google.gson.annotations.SerializedName



data class PromotionRequestModel(

    @SerializedName("user_id")

    val user_id: Int? = null,

    @SerializedName("device_id")

    val device_id: String? = null,

    @SerializedName("lang_code")

    val lang_code: String? = null

)


//{

//    Request : {

//    "user_id":15235,

//    "device_id" : "c1234"،

//    "lang_code":""

//}

//}
