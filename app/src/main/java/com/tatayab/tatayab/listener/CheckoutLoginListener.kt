package com.tatayab.tatayab.listener

interface CheckoutLoginListener {

     fun loginWithSocial(email: String?,
                         phone: String?,
                         firstname: String?,
                         reg_type: String?,
                         social_id: String?,
                         langCode: String)
    fun loginWithEmail()
    fun continueAsGuest()
 }