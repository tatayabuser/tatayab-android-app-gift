package com.tatayab.remote.util

import com.google.gson.*
import com.tatayab.model.base.BaseResponseModel
import com.tatayab.model.base.Fail
import java.lang.reflect.Type


class ResponseDeserializer : JsonDeserializer<BaseResponseModel<Any>> {
    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): BaseResponseModel<Any> {

        val jsonObject: JsonObject? = json!!.asJsonObject
// Read simple String values.
        val message: String? = jsonObject?.get("message")?.asString
        val status: Int? = jsonObject?.get("status")?.asInt;


        if (message != null && status != null) {
            val fail = Fail(message, status)
            return BaseResponseModel<Any>(data = null, message = message, status = status)
            //return Gson().fromJson(json, response::class.java)
        } else {
            val success = jsonObject
            return BaseResponseModel<Any>(success as Any, null, null)
            //return Gson().fromJson(json, response::class.java)
        }
    }


}