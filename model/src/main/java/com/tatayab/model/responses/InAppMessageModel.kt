package com.tatayab.model.responses


class InAppMessageModel(

    val in_app_message: Boolean? = false,

    var title : String? = null,

    var desc : String? = null,

    var image : String? = null,

    var action:InAppMessageActionModel? = null

)


/*

*  {

  "in_app_message": true,

 “title”: “text”,

 “desc”: “text”,

“Image”: “http:// images.png”,

“action”:{

 “title”: “button text”,

 “actionName”:”register or home or cart”

}

}



* */