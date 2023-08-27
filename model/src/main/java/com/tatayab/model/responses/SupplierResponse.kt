package com.tatayab.model.responses

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.lang.Exception

@Parcelize
data class SupplierResponse(
    @SerializedName("name") var name: String,
    @SerializedName("supplier_id") val supplierId: String,
    @SerializedName("image") val image: String?=""
):Parcelable {

    companion object {

        var titleNameComparator: Comparator<SupplierResponse> =
            object : Comparator<SupplierResponse> {

                override fun compare(data1: SupplierResponse, data2: SupplierResponse): Int {
                    try {
                        val d1 = data1?.name?.toUpperCase()
                        val d2 = data2?.name?.toUpperCase()

                        //ascending order
                        return d2?.let { d1?.compareTo(it) } ?:0

                    } catch (e: Exception) {
                        return -1
                    }

                    //descending order
                   // return d2.compareTo(d1);
                }

            }
    }
}


//{
//    "name": "114 أماتوري",
//    "supplier_id": "375",
//    "image":"http:clmlmk.png"
//},