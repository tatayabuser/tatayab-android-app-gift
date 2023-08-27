package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class CheckoutResponse (@SerializedName("data") val dataModel: DataModel):BaseGrapgQlResponse(){

    class DataModel(@SerializedName("cart") val cartModel: CartModel?)
    class CartModel(@SerializedName("id") val id:  String?="",
                    @SerializedName("email") val email: String?="",
                    @SerializedName("credit") val creditModel:CreditModel?,
                    @SerializedName("sources") val sourcesList:List<SourceModel?>,
                    @SerializedName("wrapping_items") val wrappingList:List<WrappingItemModel?>,
                    @SerializedName("selected_payment_method") val mSelectedPaymentMethodModel:PaymentMethodModel?,
                    @SerializedName("applied_coupons") val appliedCoupons:List<ApplyCouponModel?>,
                    @SerializedName("shipping_addresses") var shippingAddressesList:ArrayList<ShippingAddressModel?>,
                    @SerializedName("billing_address") val billingAddress:ShippingAddressModel?,
                    @SerializedName("available_payment_methods") val availablePaymentMethodsList:List<AvailablePaymentMethodModel?>?,
                    @SerializedName("prices") val pricesModel:PricesModel?,
                    @SerializedName("items") val productsList:List<ProductItemModel?>
                    )
    class ApplyCouponModel(@SerializedName("code") val code:  String?="")

    class SourceModel(@SerializedName("code") val code:  String?="" , @SerializedName("description") val description: String?="", @SerializedName("logo") val logo: String?="")
    class quoteItemIDSModel(@SerializedName("id") val id:  Int?=0 , @SerializedName("Qty") val Qty: Int?=0)

    class WrappingItemModel(
        @SerializedName("entity_id") val entity_id: Int?=0,
        @SerializedName("wrap_id") val wrap_id: Int?=0,
        @SerializedName("gift_message") val gift_message: String?="",
        @SerializedName("receiver_name") val receiver_name: String?="",
        @SerializedName("sender_name") val sender_name: String?="",
        @SerializedName("wrap_name") val wrap_name: String?="",
        @SerializedName("base_price") val base_price: Float?=0f,
        @SerializedName("price") val priceModel: PriceModel?=null,
        @SerializedName("quote_item_ids") val quoteItemIDS: List<quoteItemIDSModel?>?=null
    )

    class PriceModel(@SerializedName("value") val value:  Float?=0f ,
                                      @SerializedName("currency") val currency: String?="" )

    class AvailablePaymentMethodModel(@SerializedName("code") val code:  String?="" ,
                                      @SerializedName("title") val title: String?="" ,
                                      @SerializedName("logo") val logo: String?="",
                                      @SerializedName("subtitle") val subtitle: String?="",
                                      @SerializedName("delivery_to") val delivery_to: String?="",
                                      @SerializedName("delivery_to_str") val delivery_to_str: String?="",
                                      @SerializedName("delivery_from") val delivery_from: String?="",
                                      @SerializedName("delivery_from_str") val delivery_from_str: String?="",
                                      @SerializedName("source_code") val source_code: String?=""
    )
    class CreditModel(@SerializedName("is_applied") val isApplied: Boolean ,
                      @SerializedName("amount") val amountCreditModel:AmountCreditModel?)
    class PaymentMethodModel(@SerializedName("code") val code:  String?="" , @SerializedName("title") val title: String?="")
    class ShippingAddressModel(@SerializedName("city") val city:  String?="",
                               @SerializedName("firstname") val firstname:  String?="",
                               @SerializedName("lastname") val lastname:  String?="",
                               @SerializedName("postcode") val postcode:  String?="",
                               @SerializedName("street") val street: Array<String?>,
                               @SerializedName("street_add") val street_add:  String?="",
                               @SerializedName("add_direction") val add_direction:  String?="",
                               @SerializedName("available_shipping_methods") val availableShippingMethodsList: Array<AvailablePaymentMethodModel?>,
                               @SerializedName("selected_shipping_method") val SelectedShippingMethod: SelectedShippingMethodModel?,
                               @SerializedName("addr_type") val addressType:  String?="",
                               @SerializedName("telephone") val telephone:  String?="",
                               @SerializedName("city_id") val cityId:  String?="",
                               @SerializedName("area") val area:  String?="",
                               @SerializedName("country") val countryModel: CountryModel?,
                               @SerializedName("region") val regionModel: CountryModel?
                               )

    class PricesModel(@SerializedName("grand_total") val grandTotal: GrandTotalModel? ,
                      @SerializedName("subtotal_excluding_tax") val subtotalExcludingTax: SubtotalExcludingTaxModel?,
                      @SerializedName("subtotal_including_tax") val subtotalIncludingTax: SubtotalIncludingTaxModel?,
                      @SerializedName("subtotal_with_discount_excluding_tax") val subtotalWithDiscountExcludingTax: SubtotalWithDiscountExcludingTaxModel?,
                      @SerializedName("applied_taxes") val appliedTaxesList: List<ExtraFeesModel>?,
                      @SerializedName("extra_fees") val extraFeesList: List<ExtraFeesModel>?,
                      @SerializedName("discounts") val discountsList: List<DiscountItemModel>?
                      )
    class SelectedShippingMethodModel(@SerializedName("method_code") val methodCode:  String?="", @SerializedName("carrier_code") val carrierCode : String?="", @SerializedName("method_title") val methodTitle : String?=""
                                      , @SerializedName("carrier_title") val carrierTitle : String?="", @SerializedName("base_amount") val baseAmount : String?="",@SerializedName("amount") val amountModel:AmountModel)
    class ShippingMethodItem(@SerializedName("method_code") val method_code:  String?="",
                             @SerializedName("carrier_code") val carrierCode : String?="",
                             @SerializedName("source_code") val sourceCode : String?="")
    class AmountCreditModel(@SerializedName("value") val value: Float, @SerializedName("currency") val currency : String?="")
    class GrandTotalModel(@SerializedName("value") val value: Float, @SerializedName("currency") val currency : String?="")
    class AppliedTaxModel(@SerializedName("title") val title:  String?="",@SerializedName("value") val value: Float, @SerializedName("currency") val currency : String?="")
    class DiscountItemModel(@SerializedName("label") val title:  String?="",@SerializedName("amount") val amount: AmountModel)
    class ExtraFeesModel(@SerializedName("title") val title:  String?="",@SerializedName("amount") val amount: AmountModel)
    class SubtotalExcludingTaxModel(@SerializedName("value") val value: Float, @SerializedName("currency") val currency : String?="")
    class SubtotalIncludingTaxModel(@SerializedName("value") val value: Float, @SerializedName("currency") val currency : String?="")
    class SubtotalWithDiscountExcludingTaxModel(@SerializedName("value") val value: Float, @SerializedName("currency") val currency : String?="",@SerializedName("formatted_price") val formattedPrice : String?="")
    class AmountModel(@SerializedName("value") val value: Float, @SerializedName("currency") val currency : String?="")
    class ProductItemModel (@SerializedName("id") val id:  String?="",
                            @SerializedName("product") val productResponseModel: ProductResponseModel,
                            @SerializedName("quantity") val quantity: Int?=0,
                            @SerializedName("source_code") val source_code: String?=""
    )

    class ProductResponseModel (@SerializedName("sku") val sku:  String?="",
                                 @SerializedName("name") val name:  String?="",
                                @SerializedName("source") val source:  String?="",
                                 @SerializedName("price_range") val priceRangeModel: PriceRangeModel,
                                @SerializedName("small_image") val smallImageModel: SmallImageModel,
                                @SerializedName("shipping_details") val shippingDetailsList: ArrayList<ShippingDetailsModel>?=null

    )
    /*"shipping_details": [
							{
								"delivery_from": "1",
								"delivery_to": "3",
								"shipping_title": "Tatayab Shipments",
								"shipping_method": "flatrate_flatrate"
							}
						]*/

    class ShippingDetailsModel (@SerializedName("delivery_from") val delivery_from:   String?="",
                           @SerializedName("delivery_to") val delivery_to:   String?="",
                           @SerializedName("shipping_title") val shipping_title:   String?="",
                           @SerializedName("shipping_method") val shipping_method:   String?=""
    )

    class SmallImageModel (@SerializedName("url") val url:   String?="",
                           @SerializedName("label") val label:   String?="")
    class CountryModel (@SerializedName("code") val code:   String?="",
                           @SerializedName("label") val label:   String?="")

    class PriceRangeModel (@SerializedName("minimum_price") val minimumPriceModel: MinimumPriceModel
    ,@SerializedName("maximum_price") val maximumPriceModel: MaximumPriceModel)
    class MaximumPriceModel (@SerializedName("discount") val discountModel: DiscountModel,
                             @SerializedName("regular_price") val regularPriceModel: RegularPriceModel)
 class MinimumPriceModel (@SerializedName("final_price") val finalPriceModel: FinalPriceModel,
                             @SerializedName("regular_price") val regularPriceModel: RegularPriceModel)
    class DiscountModel (@SerializedName("amount_off") val amountOff: Float=0f)
    class FinalPriceModel (@SerializedName("value") val value: Float=0f,@SerializedName("currency") val currency:   String?="")
    class RegularPriceModel (@SerializedName("value") val value: Float=0f,@SerializedName("currency") val currency:   String?="")
     class RowTotalIncludingTaxModel (@SerializedName("value") val value: Float=0f)
    class RowTotalModel (@SerializedName("value") val value: Float=0f,@SerializedName("formatted_price") val formattedPrice:   String?="")
    class TotalItemDiscountModel (@SerializedName("value") val value: Float=0f,@SerializedName("currency") val currency:   String?="")

    class ProductPricesModel(@SerializedName("row_total_including_tax") val rowTotalIncludingTaxModel: RowTotalIncludingTaxModel,
                             @SerializedName("row_total") val rowTotalModel :RowTotalModel,
                             @SerializedName("total_item_discount") val totalItemDiscountModel :TotalItemDiscountModel)

}



/*{
    "data": {
        "cart": {
        "email": "aaz@aaz.com",
        "credit": {
        "is_applied": true,
        "amount": {
        "value": 0,
        "currency": null
    }
    },
        "sources": [
        {
            "code": "KW-WH",
            "description": "Kuwait Source",
            "logo": "https:\/\/magento-dev.tatayab.com\/media\/wysiwyg\/warehouse\/KW-WH.png"
        },
        {
            "code": "SA-WH",
            "description": "Saudi Arab Source",
            "logo": "https:\/\/magento-dev.tatayab.com\/media\/wysiwyg\/warehouse\/SA-WH.png"
        }
        ],
        "wrapping_items": [],
        "billing_address": {
        "city": "Los Angeles",
        "country": {
        "code": "KW",
        "label": "KW"
    },
        "firstname": "address Optional(244)",
        "lastname": "-",
        "postcode": "90210",
        "region": {
        "code": "Kuwait",
        "label": "Kuwait"
    },
        "street": [
        "sss"
        ],
        "addr_type": "0",
        "telephone": "+96550633124",
        "city_id": null,
        "area": null
    },
        "shipping_addresses": [
        {
            "firstname": "address Optional(244)",
            "lastname": "-",
            "street": [
            "sss"
            ],
            "city": "Los Angeles",
            "addr_type": "0",
            "region": {
            "code": "Kuwait",
            "label": "Kuwait"
        },
            "country": {
            "code": "KW",
            "label": "KW"
        },
            "telephone": "+96550633124",
            "available_shipping_methods": [
            {
                "method_code": "flatrate",
                "carrier_code": "flatrate",
                "source_code": "KW-WH"
            }
            ],
            "selected_shipping_method": {
            "amount": {
            "value": 1.5,
            "currency": "KWD"
        },
            "base_amount": null,
            "carrier_code": "KW-WH:flatrate",
            "carrier_title": "KW-WH:Tatayab Shipments",
            "method_code": "KW-WH:flatrate",
            "method_title": "KW-WH:Tatayab Shipments"
        },
            "city_id": null
        }
        ],
        "items": [
        {
            "id": "1464",
            "product": {
            "name": "Taifi Rose - 100ml",
            "source": "KW-WH",
            "sku": "MUB-002-F084",
            "price_range": {
            "maximum_price": {
            "discount": {
            "amount_off": 1.2
        },
            "regular_price": {
            "value": 12,
            "currency": "KWD"
        }
        },
            "minimum_price": {
            "final_price": {
            "value": 10.8,
            "currency": "KWD"
        },
            "regular_price": {
            "value": 12,
            "currency": "KWD"
        }
        }
        }
        },
            "quantity": 1
        },
        {
            "id": "1472",
            "product": {
            "name": "Pure Musk - 100ml",
            "source": "KW-WH",
            "sku": "MUB-002-F085",
            "price_range": {
            "maximum_price": {
            "discount": {
            "amount_off": 1.2
        },
            "regular_price": {
            "value": 12,
            "currency": "KWD"
        }
        },
            "minimum_price": {
            "final_price": {
            "value": 10.8,
            "currency": "KWD"
        },
            "regular_price": {
            "value": 12,
            "currency": "KWD"
        }
        }
        }
        },
            "quantity": 2
        }
        ],
        "available_payment_methods": [
        {
            "code": "mpgs_hostedcheckout",
            "title": "MPGS Payment (Hosted Checkout Payment)",
            "logo": "https:\/\/magento-dev.tatayab.com\/media\/paymentmethods\/mpgs_hostedcheckout_logo.png",
            "subtitle": null
        },
        {
            "code": "cashondelivery",
            "title": "Cash On Delivery",
            "logo": "https:\/\/magento-dev.tatayab.com\/media\/paymentmethods\/cashondelivery_logo.png",
            "subtitle": null
        },
        {
            "code": "knet",
            "title": "Knet",
            "logo": "https:\/\/magento-dev.tatayab.com\/media\/paymentmethods\/knet_logo.png",
            "subtitle": "Test Subtitle"
        },
        {
            "code": "tabby_checkout",
            "title": "Pay in 14 days",
            "logo": "https:\/\/magento-dev.tatayab.com\/media\/paymentmethods\/tabby_checkout_logo.png",
            "subtitle": null
        },
        {
            "code": "tabby_installments",
            "title": "4 interest-free payments",
            "logo": "https:\/\/magento-dev.tatayab.com\/media\/paymentmethods\/tabby_installments_logo.png",
            "subtitle": null
        }
        ],
        "selected_payment_method": {
        "code": "cashondelivery",
        "title": "Cash On Delivery"
    },
        "applied_coupons": null,
        "prices": {
        "subtotal_excluding_tax": {
        "value": 32.4,
        "currency": "KWD"
    },
        "subtotal_including_tax": {
        "value": 32.4,
        "currency": "KWD"
    },
        "applied_taxes": [],
        "subtotal_with_discount_excluding_tax": {
        "value": 32.4,
        "currency": "KWD"
    },
        "extra_fees": [
        {
            "title": "Cash On Delivery Fee",
            "amount": {
            "value": 5,
            "currency": "KWD"
        }
        }
        ],
        "discounts": null,
        "grand_total": {
        "value": 38.9,
        "currency": "KWD"
    }
    }
    }
    }
}*/
