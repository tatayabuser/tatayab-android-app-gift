package com.tatayab.model


data class UserAuth(
    val token: String? = "",
    val session: String? = "",
    val devid: String? = "",
    val osused: String? = "android"
)
