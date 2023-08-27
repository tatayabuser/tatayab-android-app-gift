package com.tatayab.model.common

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonToken
import com.google.gson.stream.JsonWriter
import com.tatayab.model.UserData
import java.io.IOException
import java.util.*
import kotlin.collections.ArrayList

class UserAdapter(private val gson: Gson?) :
    TypeAdapter<Any?>() {
     override fun write(
        jsonWriter: JsonWriter,
        data: Any?
    ) {
        throw RuntimeException("Not implemented")
    }

     override fun read(jsonReader: JsonReader): Any? {
        return when (jsonReader.peek()) {
            JsonToken.STRING -> ""
            JsonToken.BEGIN_OBJECT -> gson?.fromJson<Any>(jsonReader, UserData::class.java)
            JsonToken.BEGIN_ARRAY ->  mutableListOf(gson?.fromJson<Collection<UserData>>(jsonReader, UserData::class.java))
            else -> throw RuntimeException("Expected object or string, not " + jsonReader.peek())
        }
    }

}