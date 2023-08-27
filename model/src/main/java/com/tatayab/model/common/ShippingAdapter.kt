package com.tatayab.model.common

import com.google.gson.Gson
import com.google.gson.JsonPrimitive
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import com.tatayab.model.MainPair
import com.tatayab.model.Shipping
import com.tatayab.model.UserData
import java.io.IOException
import java.util.*

class ShippingAdapter(private val gson: Gson?) :
    TypeAdapter<Any?>() {
     override fun write(
        jsonWriter: JsonWriter,
        data: Any?
    ) {
        throw RuntimeException("Not implemented")
    }

     override fun read(jsonReader: JsonReader): Any? {

        return when (jsonReader.peek()) {
            JsonToken.STRING -> JsonPrimitive(jsonReader.nextString());
            JsonToken.BEGIN_ARRAY -> {
                val arrayList: ArrayList<Shipping> = ArrayList()
                jsonReader.beginArray()
                while (jsonReader.hasNext()) {
                    gson?.fromJson<Shipping>(jsonReader, Shipping::class.java)?.let { arrayList.add(it) }
                }
                jsonReader.endArray()
                arrayList
            }
            JsonToken.BEGIN_OBJECT -> {
                val map = gson?.fromJson<Shipping>(jsonReader, Shipping::class.java)
                map

            }
            else -> throw RuntimeException("Expected object or string, not " + jsonReader.peek())
        }
    }

}