package com.tatayab.model

 import com.tatayab.model.responses.ShareCartProductModel

class ShareCartListModel(
    var countryCode: String? = null,
    var senderName: String? = null,
    var senderId: String? = null,
    var products: List<ShareCartProductModel>
) {
}
