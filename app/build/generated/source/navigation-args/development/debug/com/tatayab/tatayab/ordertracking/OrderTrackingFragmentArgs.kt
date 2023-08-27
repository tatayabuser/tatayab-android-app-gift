package com.tatayab.tatayab.ordertracking

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class OrderTrackingFragmentArgs(
  public val orderId: String?,
  public val orderDate: String?
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("orderId", this.orderId)
    result.putString("orderDate", this.orderDate)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("orderId", this.orderId)
    result.set("orderDate", this.orderDate)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): OrderTrackingFragmentArgs {
      bundle.setClassLoader(OrderTrackingFragmentArgs::class.java.classLoader)
      val __orderId : String?
      if (bundle.containsKey("orderId")) {
        __orderId = bundle.getString("orderId")
      } else {
        throw IllegalArgumentException("Required argument \"orderId\" is missing and does not have an android:defaultValue")
      }
      val __orderDate : String?
      if (bundle.containsKey("orderDate")) {
        __orderDate = bundle.getString("orderDate")
      } else {
        throw IllegalArgumentException("Required argument \"orderDate\" is missing and does not have an android:defaultValue")
      }
      return OrderTrackingFragmentArgs(__orderId, __orderDate)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): OrderTrackingFragmentArgs {
      val __orderId : String?
      if (savedStateHandle.contains("orderId")) {
        __orderId = savedStateHandle["orderId"]
      } else {
        throw IllegalArgumentException("Required argument \"orderId\" is missing and does not have an android:defaultValue")
      }
      val __orderDate : String?
      if (savedStateHandle.contains("orderDate")) {
        __orderDate = savedStateHandle["orderDate"]
      } else {
        throw IllegalArgumentException("Required argument \"orderDate\" is missing and does not have an android:defaultValue")
      }
      return OrderTrackingFragmentArgs(__orderId, __orderDate)
    }
  }
}
