package com.tatayab.model.responses.graph_responses

class GetGraphNotifyMeActionResponse(val data: NotifyMeGraphData) : BaseGrapgQlResponse()
data class NotifyMeGraphData(val AmxnotifStockSubscribe: MotifStockSubscribe)
data class MotifStockSubscribe(val response_message: String)

class GetWishListResponse(val data: WishListData) : BaseGrapgQlResponse()
data class WishListData(val customer: WishListDataCustomer)
data class WishListDataCustomer(val wishlists: List<GetWishListDataItem>)
data class GetWishListDataItem(val id: Int,val items_count : Int, val items_v2: WishListDataItem)
data class WishListDataItem(val items: List<WishListItem>)
data class WishListItem(val id: String, val product: ProductData)

/*{"data":{"customer":{"wishlists":[
{"id":"541","items_count":1,
"items_v2":
{"items":[
{"id":"3258",
"product":{"sku":"GVC-001-R364","url_key":"gentlemen-only-eau-de-toilette-100ml-men",
"source":"KW-WH",
"top_notes":null,
"name":"Gentlemen Only Eau De Toilette - 100ML - Men","id":2713,
"small_image":{"url":"https:\/\/tatayab.com\/media\/catalog\/product\/cache\/62805fc4aa5180b882f7417bdb96913f\/G\/e\/Gentlemen_Only_by_Givenchy.jpg"},
"image":{"url":"https:\/\/tatayab.com\/media\/catalog\/product\/cache\/62805fc4aa5180b882f7417bdb96913f\/G\/e\/Gentlemen_Only_by_Givenchy.jpg"},
"manufacturer":4310,
"base_notes":null,
"review_count":0,"reviews":{"items":[]},
"dynamicAttributes":"{\"manufacturer_label\":\"Givenchy\",\"manufacturer\":\"4310\",\"gender_label\":\"Male\",\"gender\":\"3964\",\"color_label\":false,\"color\":null,\"size_label\":\"100ml\",\"size\":\"4045\"}",
"description":{"html":"<p>Givenchy - Gentlemen Only Eau De Toilette - 100 ML - Men<\/p>\r\n<p> <\/p>\r\n<p><span data-sheets-value=\"{&quot;1&quot;:2,&quot;2&quot;:&quot;Givenchy Gentleman Only (Men) - EDT - 100 ML - Consists of :Mandarin, Nutmeg, Pink Pepper, Cedar, Patchouli, Vetiver&quot;}\" data-sheets-userformat=\"{&quot;2&quot;:31651,&quot;3&quot;:{&quot;1&quot;:0},&quot;4&quot;:{&quot;1&quot;:2,&quot;2&quot;:16777215},&quot;8&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:0}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;10&quot;:0,&quot;11&quot;:4,&quot;12&quot;:0,&quot;14&quot;:{&quot;1&quot;:2,&quot;2&quot;:0},&quot;15&quot;:&quot;Calibri, sans-serif&quot;,&quot;16&quot;:12,&quot;17&quot;:1}\">Fragrance Notes:<\/span><\/p>\r\n<p> <\/p>\r\n<p><span data-sheets-value=\"{&quot;1&quot;:2,&quot;2&quot;:&quot;Givenchy Gentleman Only (Men) - EDT - 100 ML - Consists of :Mandarin, Nutmeg, Pink Pepper, Cedar, Patchouli, Vetiver&quot;}\" data-sheets-userformat=\"{&quot;2&quot;:31651,&quot;3&quot;:{&quot;1&quot;:0},&quot;4&quot;:{&quot;1&quot;:2,&quot;2&quot;:16777215},&quot;8&quot;:{&quot;1&quot;:[{&quot;1&quot;:2,&quot;2&quot;:0,&quot;5&quot;:{&quot;1&quot;:2,&quot;2&quot;:0}},{&quot;1&quot;:0,&quot;2&quot;:0,&quot;3&quot;:3},{&quot;1&quot;:1,&quot;2&quot;:0,&quot;4&quot;:1}]},&quot;10&quot;:0,&quot;11&quot;:4,&quot;12&quot;:0,&quot;14&quot;:{&quot;1&quot;:2,&quot;2&quot;:0},&quot;15&quot;:&quot;Calibri, sans-serif&quot;,&quot;16&quot;:12,&quot;17&quot;:1}\">- A Combination of mandarin, nutmeg, pink pepper, cedar, patchouli and vetiver.<\/span><\/p>"},"stock_status":"IN_STOCK","price_range":{"minimum_price":{"discount":{"amount_off":34.75,"percent_off":30},"final_price":{"value":81.1,"currency":"USD"},"regular_price":{"value":115.85,"currency":"USD"}}}}}]}}]}}}
*/