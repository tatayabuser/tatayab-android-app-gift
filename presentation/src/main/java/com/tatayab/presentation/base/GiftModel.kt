package com.tatayab.presentation.base

class GiftModel(
    var senderName: String = "",
    var receiverName: String = "",
    var message: String = "",
    var giftProductList: ArrayList<String>,
    var productID: String? = ""
    ) {
}