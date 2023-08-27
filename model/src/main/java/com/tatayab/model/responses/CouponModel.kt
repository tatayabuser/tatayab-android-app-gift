package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName
import com.tatayab.model.PromotionData
import com.tatayab.model.PromotionDataOfCoupon

data class CouponModel(
    @SerializedName("promotion_data")
    val promotionData: PromotionData
)