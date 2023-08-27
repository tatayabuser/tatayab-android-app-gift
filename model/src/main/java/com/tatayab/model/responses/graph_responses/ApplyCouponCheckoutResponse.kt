package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class ApplyCouponCheckoutResponse (@SerializedName("data") val dataModel: DataModel):BaseGrapgQlResponse() {

    class DataModel(@SerializedName("applyCouponToCart") val applyCouponToCart: ApplyCouponToCartModel)
    class ApplyCouponToCartModel(@SerializedName("cart") val cartModel: CartModel)
    class CartModel(
        @SerializedName("applied_coupons") val appliedCoupons: ArrayList<ApplyCouponModel?>)

    class ApplyCouponModel(@SerializedName("code") val code: String? = "")
}
/*{"data":{"applyCouponToCart":{"cart":{"applied_coupons":[{"code":"10off"}]}}}}*/