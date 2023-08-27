package com.tatayab.presentation

import android.net.Uri

class Utils {
    companion object {
        // Device UID
        var DEVICE_UID = ""
        var DEEP_LINK_URI: Uri? = null
        var isInAppMessageShown = false
        var GUEST_USER_TYPE = "guest"
        var EXPIRE_SESSION_MESSAGE = "The current user cannot perform operation"
        var CUSTOMER_NOT_AUTHORIZED_MESSAGE = "customer isn't authorized"
        var CART_NOT_ACTIVE_ERROR = "cart isn't active"
        var CART_NOT_FIND_ERROR = "Could not find a cart with"
        var CAN_NOT_ASSIGN_CART_ERROR = "Can't assign cart to store"
        var ALLOWED_FOR_LOGIN_ERROR = "request is allowed for logged in"
        /*Can't assign cart to store in different website.
The current user cannot perform operations on cart
The request is allowed for logged in
Could not find a cart with ID*/
    }

    object FormatTime {
        fun formatTime(milliSec: Long): String {
            val seconds: Long = milliSec / 1000
            val minutes = seconds / 60
            val hours = minutes / 60
            val days = hours / 24
            val time = String.format("%02d", days) + ":" + String.format("%02d", hours % 24) + ":" +
                    String.format("%02d", minutes % 60) + ":" + String.format("%02d", seconds % 60)

            return time
        }

    }

    object CheckOutAction {
        var addressID = -1
        var openAddAddress = false
        var openLoginOptions = false
        var dataLoaded = false
        var action : CheckActionType = CheckActionType.UN_LOGIN_USER
    }

    enum class CheckActionType {
        UN_LOGIN_USER,
        LOGIN_USER,
        ADDRESS_UPDATED,
        NEW_LOGIN,
        GUEST_USER,
        RELOAD_DATA
    }

}