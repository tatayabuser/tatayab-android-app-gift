package com.tatayab.model.common

import com.google.gson.Gson
import com.google.gson.JsonPrimitive
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import java.io.IOException
import java.util.*

class TaxIdsAdapter(private val gson: Gson?) :
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
                val arrayList: ArrayList<Any> = ArrayList()
                jsonReader.beginArray()
                while (jsonReader.hasNext()) {
                    arrayList.add(jsonReader.nextString())
                }
                jsonReader.endArray()
                arrayList
            }
            else -> throw RuntimeException("Expected object or string, not " + jsonReader.peek())
        }
    }

}