package com.tatayab.model


import com.google.gson.annotations.SerializedName

data class Properties(
    @SerializedName("hide_add_to_cart_button")
    val hideAddToCartButton: String,
    @SerializedName("template")
    val template: String,
    @SerializedName("navigation")
    val navigation: String,
    @SerializedName("delay")
    val delay: String,
    @SerializedName("item_number")
    val item_number: String,
    @SerializedName("number_of_columns")
    val number_of_columns: String,
    @SerializedName("not_scroll_automatically")
    val not_scroll_automatically: String,
    @SerializedName("scroll_per_page")
    val scroll_per_page: String,
    @SerializedName("speed")
    val speed: String,
    @SerializedName("pause_delay")
    val pause_delay: String,
    @SerializedName("item_quantity")
    val item_quantity: String


)