package com.tatayab.model.common

import java.io.IOException


class ErrorResponseException(
    private val networkExceptions: NetworkExceptions,
    private val responseError: ResponseError
) : IOException() {


    override fun toString(): String {
        return networkExceptions.ordinal.toString()
    }

    fun getErrorMessage(): String? =responseError.message


}