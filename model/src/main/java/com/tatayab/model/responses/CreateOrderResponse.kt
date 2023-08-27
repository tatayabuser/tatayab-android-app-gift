package com.tatayab.model.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CreateOrderResponse(
    @SerializedName("order_id")
    val orderId: String?=null,
    @SerializedName("total_user_orders")
    val totalUserOrders: Int?=null,
    @SerializedName("redirect_url")
    val redirectUrl: String?=null,
    var errorMessage:String? = ""
):Parcelable{
}