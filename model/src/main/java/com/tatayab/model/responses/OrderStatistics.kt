package com.tatayab.model.responses

import com.google.gson.annotations.SerializedName

data class OrderStatistics(
    @SerializedName("current_orders_quantity") val current_orders_quantity: String,
    @SerializedName("current_orders_search_string") val current_orders_search_string: String,
    @SerializedName("current_orders_total") val current_orders_total: String,
    @SerializedName("orders_total") val orders_total: String,
    @SerializedName("paid_orders_quantity") val paid_orders_quantity: String,
    @SerializedName("paid_orders_search_string") val paid_orders_search_string: String,
    @SerializedName("paid_orders_total") val paid_orders_total: String,
    @SerializedName("reviews_quantity") val reviews_quantity: String,
    @SerializedName("total_orders") val total_orders: String,
    @SerializedName("total_orders_search_string") val total_orders_search_string: String,
    @SerializedName("user_carts_link") val user_carts_link: String,
    @SerializedName("user_id") val user_id: String
)