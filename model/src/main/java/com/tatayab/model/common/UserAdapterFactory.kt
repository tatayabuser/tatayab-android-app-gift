package com.tatayab.model.common

import com.google.gson.Gson
import com.google.gson.TypeAdapter
import com.google.gson.TypeAdapterFactory
import com.google.gson.reflect.TypeToken

class UserAdapterFactory : TypeAdapterFactory {
    override fun <T> create(gson: Gson?, type: TypeToken<T>?): TypeAdapter<T> {
        return UserAdapter(gson) as TypeAdapter<T>
    }
}