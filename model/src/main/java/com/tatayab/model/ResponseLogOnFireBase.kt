package com.tatayab.model

import java.util.*

object ResponseLogOnFireBase {

    var requestUrl :String = ""
    var requestBody :String = ""
    var time : String = Calendar.getInstance().time.toString()
    var error : String = ""
    var requestResponse : String = ""
    var isGuest = true
    var userId = ""
    var apiMethod = ""

}