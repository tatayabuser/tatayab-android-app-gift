package com.tatayab.tatayab.errorHandling

import android.content.Context
import android.util.Log
import com.google.gson.Gson
import com.tatayab.model.common.ResponseError
import com.tatayab.tatayab.R
import retrofit2.HttpException

open class ExceptionHandler {
    private val TAG = ExceptionHandler::class.java.simpleName

    fun getMessage(throwable: Throwable, context: Context): String? {
        var message: String? = context.getString(R.string.something_went_wrong)
        if (throwable is HttpException) {
            val body = throwable.response().errorBody()
            val gson = Gson()
            try {
                    val responseError =
                        gson.fromJson<Any>(body!!.string(), ResponseError::class.java) as ResponseError
                    message = responseError.message

            } catch (e: Exception) {
                Log.e(TAG, "getMessage: " + e.message)
            }

        } else {
            message = throwable.message
        }
        return message
    }
}