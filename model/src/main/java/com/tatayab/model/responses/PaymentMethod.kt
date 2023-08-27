package com.tatayab.model.responses

import android.os.Parcel
import android.os.Parcelable
import com.tatayab.model.Image
import com.google.gson.annotations.SerializedName

data class PaymentMethod(
    @SerializedName("a_surcharge") val a_surcharge: String,
    @SerializedName("company_id") val company_id: String,
    @SerializedName("description") val description: String,
    @SerializedName("image") val image: Image,
    @SerializedName("instructions") val instructions: String,
    @SerializedName("lang_code") val lang_code: String,
    @SerializedName("localization") val localization: String,
    @SerializedName("p_surcharge") val p_surcharge: String,
    @SerializedName("payment") val payment: String,
    @SerializedName("payment_category") val payment_category: String,
    @SerializedName("payment_id") val payment_id: String,
    @SerializedName("position") val position: String,
    @SerializedName("processor") val processor: String,
    @SerializedName("processor_id") val processor_id: String,
    @SerializedName("processor_status") val processor_status: String,
    @SerializedName("processor_type") val processor_type: String,
    @SerializedName("status") val status: String,
    @SerializedName("surcharge_title") val surcharge_title: String,
    @SerializedName("tax_ids") val tax_ids: List<Any>,
    @SerializedName("template") val template: String,
    @SerializedName("usergroup_ids") val usergroup_ids: String
) {

}
