package com.tatayab.model.responses.graph_responses

import com.tatayab.model.responses.CartOrderResponse

class CartProductPerCountryModel(var countryCode:String, var productList:ArrayList<CartOrderResponse>)