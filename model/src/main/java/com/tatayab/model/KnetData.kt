package com.tatayab.model


import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class KnetData(
    @SerializedName("knet_status")
    var knetStatus: String?=null,
    @SerializedName("tabby_status")
    var tabby_status: String?=null,
    @SerializedName("payment_id")
    var paymentId: String?=null,
    @SerializedName("ref_no")
    var refNo: String?=null,
    @SerializedName("trans_amt")
    var transAmt: String?=null,
    @SerializedName("trans_date")
    var transDate: String?=null,
    @SerializedName("trans_id")
    var transId: String?=null
):Parcelable


//https://magento-dev.tatayab.com/kw-en/graphqlpaymentsredirects/redirect/success?paymentid=100202217723290700&amount=12.3&
// result=CAPTURED&tranid=202217723318751&auth=B65391&ref=217710000524&trackid=5000000465&postdate=0627/



//{"tabby_status":"Success","payment_id":"5275e0ac-9f8e-493a-ab10-1abfa8db3d08"}