package com.tatayab.model.base

class ResponseWrapper<out T : Any>{
    val success: T? = null
    val fail:Fail?=null
}