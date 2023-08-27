package com.tatayab.model.common

import java.io.IOException


class NoConnectivityException(
    private val networkExceptions: NetworkExceptions
) : IOException() {


    override fun toString(): String {
        return networkExceptions.ordinal.toString()
    }



}