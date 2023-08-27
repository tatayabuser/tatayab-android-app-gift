package com.tatayab.model

import com.google.gson.annotations.SerializedName

data class TrendAction(
    @SerializedName("actionid")var actionid: TrendStateActionModel? =null,
    @SerializedName("action_sender_id")var actionSenderId:String="",
    @SerializedName("action_sender_name")var actionSenderName:String=""

)