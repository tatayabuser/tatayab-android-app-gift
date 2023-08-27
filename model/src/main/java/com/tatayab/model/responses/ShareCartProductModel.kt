package com.tatayab.model.responses


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ShareCartProductModel(
    @SerializedName("product_id")
    val product_id: String? = "",
    @SerializedName("amount")
    var amount: Int? = 0,
    @SerializedName("options")
    var options: ArrayList<SelectedOptionModel> = ArrayList<SelectedOptionModel>()
) : Parcelable

@Parcelize
class SelectedOptionModel(
    @SerializedName("variantId") val variantId: String,
    @SerializedName("optionId") var optionId: String
) : Parcelable

///*{\"amount\":1,\"product_id\":\"9107\",\"options\":[{\"variantId\":\"1726\",\"optionId\":\"235\"},{\"variantId\":\"1798\",\"optionId\":\"241\"},{\"variantId\":\"1918\",\"optionId\":\"247\"},{\"variantId\":\"1858\",\"optionId\":\"244\"}]}]}*/

/*
 *{"product_id":418,
* "title":"Tatera - 500ml",
* "supplier_id":"19",
* "supplier_name":"Tatera",
* "price":6,"image":"https:\/\/main.tatayab.com\/images\/detailed\/1\/TATERA.jpg",
* "product_options":[],
* "amount":1,
* "inWishlist":false}
* */