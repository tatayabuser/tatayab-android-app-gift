package com.tatayab.model.responses


import com.google.gson.annotations.SerializedName
import com.tatayab.model.*


import kotlinx.serialization.*

//@Serializable
data class ProductDetailsResponse(

    @SerializedName("amount")
    var amount: Int? =null,
    @SerializedName("full_description")
    var fullDescription: String? =null,
    @SerializedName("is_free_delivery")
    var isFreeDelivery: String? =null,
    @SerializedName("list_price")
    var listPrice: String? =null,
    @SerializedName("main_pair")
    var mainPair: MainPair? =null,
    @SerializedName("max_qty")
    var maxQty: Int = 0,
    @SerializedName("product_specs")
    var product_specs: ArrayList<ProductSpecific>,
    @SerializedName("min_qty")
    var minQty: Int = 0,
    @SerializedName("out_of_stock_actions")
    var outOfStockActions: String,
    @SerializedName("price")
    var price: String? =null,
    var currency: String? =null,
    @SerializedName("product")
    var product: String? =null,
    @SerializedName("product_id")
    var productId: String? =null,
    var productSku: String? =null,
    @SerializedName("product_options")
    @Contextual var productOptions: ArrayList<ProductOptions>? = null,
    @SerializedName("has_options")
    var hasOptions: Boolean,
    @SerializedName("images")
    var images: List<String>,
    @SerializedName("supplier_id")
    var supplierId: String? =null,
    @SerializedName("supplier_name")
    var supplierName: String? =null,
    @SerializedName("is_In_WishList")
    var is_In_WishList: Boolean = false,
    @SerializedName("product_link")
    var productLink: String? =null,
    @SerializedName("notes")
    var notes: String? = null,
    @SerializedName("warehouse")
    var warehouse: WareHouseModel? =null,
    var source: String? ="",
    var percent_off: Float?= 0f


/*"warehouse": {
        "country_code": "KW",
        "deli_from": "السبت 12 فبراير",
        "deli_to": "الإثنين 14 فبراير",
        "country": "الكويت",
        "amount": "10",
        "warehouse_id": "1",
        "image": "/flags/KW.png"
    },*/
){
    class WareHouseModel(
        @SerializedName("country_code")
        var country_code: String = " ",
        @SerializedName("deli_from")
        var deli_from: String = " ",
        @SerializedName("deli_to")
        var deli_to: String = " ",
        @SerializedName("country")
        var country: String = " ",
        @SerializedName("amount")
        var amount: String = " ",
        @SerializedName("warehouse_id")
        var warehouse_id: String = " ",
        @SerializedName("image")
        var image: String = " "
    )
}