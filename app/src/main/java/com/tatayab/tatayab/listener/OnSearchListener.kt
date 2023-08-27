package com.tatayab.tatayab.listener

import com.tatayab.model.requests.AddressRequest


interface OnSearchListener {

    fun onSearchSelected(productId:String,type:String="product",name:String="")
    fun onSearchSuggestionSelected(searchText:String)
    fun onRemovedSuggestionClicked(position:Int)

}