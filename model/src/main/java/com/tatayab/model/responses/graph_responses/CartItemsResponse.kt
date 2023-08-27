package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class CartItemsResponse (@SerializedName("data") val dataModel: DataModel):BaseGrapgQlResponse(){
    class DataModel (@SerializedName("cart") val cartModel: CartModel)
    /*"prices": {
				"grand_total": {
					"value": 25.5,
					"currency": "KWD"
				},
				"subtotal_excluding_tax": {
					"value": 12,
					"currency": "KWD"
				},
				"subtotal_including_tax": {
					"value": 12,
					"currency": "KWD"
				}
			}*/
    class CartModel (
        @SerializedName("items") val itemsModelList: List<ItemsModel>?,
        @SerializedName("wrapping_items") val wrappingItemsModel: List<WrapItemModel>?,
        @SerializedName("prices") val finialPricesModel: FinialPricesModel?
        )
    class GrandTotalModel(@SerializedName("value") val value: Float, @SerializedName("currency") val currency : String?="")

    class FinialPricesModel (@SerializedName("grand_total") val grandTotalModel: GrandTotalModel
                      )

    class ItemsModel (@SerializedName("id") val id: String="",
                      @SerializedName("uid") val uid: String="",
                      @SerializedName("quantity") val quantity: Int=0,
                      @SerializedName("product") val productModel: ProductModel,
                      @SerializedName("prices") val pricesModel: PricesModel
                      )

    class ProductModel (@SerializedName("name") val name: String="",
                      @SerializedName("sku") val sku: String="",
                      @SerializedName("stock_status") val stock_status: String="",
                      @SerializedName("dynamicAttributes") val dynamicAttributesModel: String,
                      @SerializedName("source") val source: String,
                       @SerializedName("small_image") val smallImageModel: SmallImageModel,
                      @SerializedName("price_range") val priceRangeModel: PriceRangeModel,
                        @SerializedName("shipping_details") val shippingDetailsModel: java.util.ArrayList<ShippingDetailsModel>
                      )
    class ShippingDetailsModel (
        @SerializedName("delivery_from") val delivery_from:   String?="",
        @SerializedName("delivery_from_str" ) val delivery_from_str:   String?="",
                                @SerializedName("delivery_to") val delivery_to:   String?="",
                                @SerializedName("delivery_to_str") val delivery_to_str:   String?="",
                                @SerializedName("shipping_title") val shipping_title:   String?="",
                                @SerializedName("shipping_method") val shipping_method:   String?=""
    )

    class DynamicAttributesModel (@SerializedName("manufacturer_label") val manufacturer_label: Boolean=false,
                      @SerializedName("manufacturer") val manufacturer: String)
    class SmallImageModel (@SerializedName("url") val url: String="",
                      @SerializedName("label") val label: String="")


    class MinimumPriceModel (@SerializedName("final_price") val finalPriceModel: FinalPriceModel, @SerializedName("regular_price") val regularPriceModel: RegularPriceModel,
                             @SerializedName("discount") val discountModel: DiscountModel)

    class PriceRangeModel (@SerializedName("minimum_price") val minimumPriceModel: MinimumPriceModel)


    class FinalPriceModel (@SerializedName("value") val value: Float=0f,@SerializedName("currency") val currency: String="")
    class RegularPriceModel (@SerializedName("value") val value: Float=0f,@SerializedName("currency") val currency: String="")
    class DiscountModel (@SerializedName("amount_off") val amount_off: Float=0f,@SerializedName("percent_off") val percent_off: Float=0f)
    class PricesModel (@SerializedName("row_total") val rowTotalModel: RowTotalModel,
                       @SerializedName("total_item_discount") val totalItemDiscountModel: TotalItemDiscountModel)
    class RowTotalModel (@SerializedName("value") val value: Float=0f,@SerializedName("formatted_price") val formattedPrice: String="")
    class TotalItemDiscountModel (@SerializedName("value") val value: Float=0f,@SerializedName("currency") val currency: String="")
    class WrapItemModel (@SerializedName("entity_id") val entity_id: Int?=0,
                         @SerializedName("wrap_id") val wrap_id: Int?=0,
                         @SerializedName("gift_message") val gift_message: String?="",
                         @SerializedName("receiver_name") val receiver_name: String?="",
                         @SerializedName("sender_name") val sender_name: String?="",
                         @SerializedName("wrap_name") val wrap_name: String?=""
     )
}

/*{"data":{"cart":{"wrapping_items":[{"entity_id":206,"wrap_id":2,"gift_message":"rrrrrrrrrr","receiver_name":"Ahmed Akl3","sender_name":"Ahmed Akl","wrap_name":"Pink flowers","quote_item_ids":[{"id":2929,"Qty":1}]}],"items":[{"id":"2929","uid":"MjkyOQ==","quantity":1,"product":{"name":"Pure Musk - 100ml","sku":"MUB-002-F085","stock_status":"IN_STOCK","dynamicAttributes":"{\"manufacturer_label\":false,\"manufacturer\":null}","small_image":{"url":"https:\/\/magento-dev.tatayab.com\/media\/catalog\/product\/cache\/62805fc4aa5180b882f7417bdb96913f\/M\/U\/MUB-002-F085.jpg","label":"Pure Musk - 100ml"},"price_range":{"minimum_price":{"final_price":{"value":12,"currency":"KWD"},"regular_price":{"value":12,"currency":"KWD"},"discount":{"amount_off":0,"percent_off":0}}}},"prices":{"row_total":{"value":12,"formatted_price":"KWD12.00"},"total_item_discount":{"value":0,"currency":"KWD"}}}]}}}
*/