package com.tatayab.model.responses.graph_responses

import com.google.gson.annotations.SerializedName

class PlaceOrderResponse (@SerializedName("data") val dataModel: DataModel):BaseGrapgQlResponse(){
    class DataModel (@SerializedName("placeOrder") val mPlaceOrderModel: PlaceOrderModel)
    class OrderModelItem (@SerializedName("order_number") val order_number: String)
    class PlaceOrderModel (@SerializedName("order") val orderListIDs: List<OrderModelItem>,
          @SerializedName("payment_redirect_url") val paymentRedirectUrlModel:PaymentRedirectUrlModel)
    class PaymentRedirectUrlModel (@SerializedName("payment_url") val paymentUrl: String,
          @SerializedName("error") val error:String,
          @SerializedName("method") val method:String)
    }


/* {"data":{
        "placeOrder":{
              "order":[{"order_number":"5000000445"}],
              "payment_redirect_url":{
              "payment_url":"https:\/\/www.kpaytest.com.kw\/kpg\/PaymentHTTP.htm?param=paymentInit&trandata=a2f8a9fec30f6883078ee713a6e3fb3802024007118d65d7be00ac67de2cfd41663e7d1bf10cd316cea4fd43daab061a5f79e71f180a6e6d1c19af7ea895feef6ebc6c4fe53781e6ead82bd9902e83c860e577568dd253149e6ef50c69eedd09af48dfeeea74d4ad28a10709b2038ec13c99ae07ce447d87196223aee1f347792b04ab150f4bfdb9d752d100c19b7a1acfd8d70542e942953a832bf6a48bb3dba6f07f87a12095945f2404a82c67b6287c283d8a8a9f97ae78ed4a206e6c5c2f8434d7b5a4a4b10eda241cf7c8f7529e517447374ccb42b985edf5c8b758016480df2f223f8e523a1dcfbe65fbc3cd7c2233190ecc58a0acda85225bcda4a6ec88eaf2a93abeca08c386a1653245bc21&tranportalId=181301&responseURL=https:\/\/magento-dev.tatayab.com\/kw-en\/knet\/payment\/success\/is_graphql\/1\/&errorURL=errorURL=https:\/\/magento-dev.tatayab.com\/kw-en\/knet\/payment\/fail\/is_graphql\/1\/",
              "error":"",
              "method":"knet"
              }
             }
            }
          }
*/