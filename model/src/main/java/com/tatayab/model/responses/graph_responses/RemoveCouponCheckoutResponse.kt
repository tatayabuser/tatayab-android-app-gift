package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class RemoveCouponCheckoutResponse (@SerializedName("data") val dataModel: DataModel):BaseGrapgQlResponse() {

    class DataModel(@SerializedName("removeCouponFromCart") val removeCouponCheckoutResponse: RemoveCouponFromCartModel)
    class RemoveCouponFromCartModel(@SerializedName("cart") val cartModel: CartModel)
    class CartModel()
}