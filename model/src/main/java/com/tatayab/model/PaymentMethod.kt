package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class PaymentMethod(
    @SerializedName("description")
    val description: String,
    @SerializedName("f_surcharge")
    val fSurcharge: String,
    @SerializedName("image")
    val image: Image,
    @SerializedName("p_surcharge")
    val pSurcharge: String,
    @SerializedName("payment")
    var payment: String,
    @SerializedName("payment_id")
    val paymentId: String,
    @SerializedName("surcharge_title")
    val surchargeTitle: String,
    var isChecked: Boolean = false
)