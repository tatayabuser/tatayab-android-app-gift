package com.tatayab.model.common

import com.google.gson.*
import com.tatayab.model.Image
import java.lang.reflect.Type

class ImageSerializer : JsonDeserializer<Image?> {
     override fun deserialize(
        json: JsonElement,
        typeOfT: Type,
        context: JsonDeserializationContext
    ): Image? {
        return try {
            context.deserialize<Image>(json, typeOfT)
        } catch (e: JsonSyntaxException) { // return null to elave null or make whatever kind of a person
            null
        }
    }
}