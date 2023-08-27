package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class AddGiftItemToCartResponse (@SerializedName("data") val data: DataModel):BaseGrapgQlResponse(){
    class DataModel (@SerializedName("addGiftWrapToCart") val addGiftWrapToCartModel: AddGiftWrapToCartModel?)
    class AddGiftWrapToCartModel (@SerializedName("cart") val cartModel: CartModel?)
    class CartModel (@SerializedName("wrapping_items") val cartModel: ArrayList<WrapGiftModel>?,
    @SerializedName("prices") val mPriceModel:PriceModel?)


    class PriceModel (
        @SerializedName("grand_total") val grandTotalModel: GrandTotalModel?
     )
    class GrandTotalModel (
        @SerializedName("currency") val currency: String?="",
        @SerializedName("value") val value: Float?=0f
     )
    class WrapGiftModel (
        @SerializedName("entity_id") val entityId: Int?=0,
        @SerializedName("wrap_id") val wrap_id: Int?=0,
        @SerializedName("card_id") val card_id: Int?=0,
        @SerializedName("gift_message") val gift_message: String?="",
        @SerializedName("receiver_name") val receiver_name: String?="",
        @SerializedName("sender_name") val sender_name: String?="",
        @SerializedName("wrap_name") val wrap_name: String?=""
     )
}
/*{
	"data": {
		"addGiftWrapToCart": {
			"cart": {
				"wrapping_items": [
					{
						"entity_id": 194,
						"wrap_id": 1,
						"gift_message": "Test gift Message",
						"receiver_name": "Test Rec",
						"sender_name": "Test Sender",
						"wrap_name": "Red flowers",
						"quote_item_ids": [
							{
								"id": 2276,
								"Qty": 1
							}
						]
					}
				],
				"items": [
					{
						"id": "2276",
						"product": {
							"name": "Daal Eau De Parfum - 100ML - Unisex",
							"sku": "ABJ-001-A019"
						},
						"quantity": 28
					},
					{
						"id": "2836",
						"product": {
							"name": "Pure Musk - 100ml",
							"sku": "MUB-002-F085"
						},
						"quantity": 2
					},
					{
						"id": "2837",
						"product": {
							"name": "Sultanie Eau De Parfum - 100ML - Unisex",
							"sku": "ABJ-001-A028"
						},
						"quantity": 2
					},
					{
						"id": "2838",
						"product": {
							"name": "Athnen - 250ml",
							"sku": "ABJ-002-A002"
						},
						"quantity": 2
					},
					{
						"id": "2865",
						"product": {
							"name": "Wahd Air Freshener - 250ML",
							"sku": "ABJ-002-A001"
						},
						"quantity": 1
					}
				],
				"prices": {
					"grand_total": {
						"value": 672,
						"currency": "KWD"
					}
				}
			}
		}
	}
}*/