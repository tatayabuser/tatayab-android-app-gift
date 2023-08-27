package com.tatayab.tatayab.insiderSDK

 import org.json.JSONArray

interface SendCenterMessageListener {
    fun getAllCenterMessage(messagesJasonArray : JSONArray)
}
/*
* [
    {
        "camp_id": 4402,
        "camp_type": "Single Push",
        "created_at": "2018-12-07T09:39:25Z",
        "deep_links": {
            "direct_to": "settings"
        },
        "image_url": "http://mobile.useinsider.com",
        "message": "Hello user!",
        "title": "Shopbagg",
        "variant_id": 9327
    }
]
* */