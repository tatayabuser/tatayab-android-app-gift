package com.tatayab.tatayab.orderdetails

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import kotlin.String
import kotlin.jvm.JvmStatic

public data class OrderDetailsFragmentArgs(
  public val orderId: String? = null
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("orderId", this.orderId)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("orderId", this.orderId)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): OrderDetailsFragmentArgs {
      bundle.setClassLoader(OrderDetailsFragmentArgs::class.java.classLoader)
      val __orderId : String?
      if (bundle.containsKey("orderId")) {
        __orderId = bundle.getString("orderId")
      } else {
        __orderId = null
      }
      return OrderDetailsFragmentArgs(__orderId)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): OrderDetailsFragmentArgs {
      val __orderId : String?
      if (savedStateHandle.contains("orderId")) {
        __orderId = savedStateHandle["orderId"]
      } else {
        __orderId = null
      }
      return OrderDetailsFragmentArgs(__orderId)
    }
  }
}
