package com.tatayab.model


import com.google.gson.annotations.SerializedName
import com.tatayab.model.Bonuse
import com.tatayab.model.Conditions

data class PromotionDataOfCoupon(
    @SerializedName("bonuses")
    var bonuses: List<BonuseOfCoupon>? =null,
    @SerializedName("conditions")
    val conditions: Conditions? =null,
    @SerializedName("promo_id")
    val promoId: String? =null,
    @SerializedName("promo_name")
    var promoName: String? =null
)