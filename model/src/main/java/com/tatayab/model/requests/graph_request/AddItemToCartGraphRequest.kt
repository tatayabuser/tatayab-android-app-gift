package com.tatayab.model.requests.graph_request

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.lang.StringBuilder

@Parcelize
class AddItemToCartGraphRequest (
    @SerializedName("CART_ID") var CART_ID : String,
    @SerializedName("quantity") var quantity : Int,
    @SerializedName("productId") var productId : String,
    @SerializedName("source") var source : String,
    var selectedOptions: Map<String, String>?=null
):Parcelable{


    fun getOptionAsString():String{
        var selectedOptionsString = StringBuilder()
        if(selectedOptions?.isNullOrEmpty()!!.not()){
            var optionCount = selectedOptions!!.size
            var currentIndex = 0
            selectedOptionsString.append("[")
            selectedOptions?.map {
                currentIndex ++
                selectedOptionsString.append("{\n" +
                        "            id: ${it.key}\n" +
                        "            quantity: 1\n" +
                        "            value: [\n" +
                        "              \"${it.value}\"\n" +
                        "            ]\n" +
                        "          }")
                if(optionCount - currentIndex != 0){ selectedOptionsString.append(",\n")}

            }
            selectedOptionsString.append("]")
        }
        return selectedOptionsString.toString()
    }
}