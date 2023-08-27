package com.tatayab.tatayab.checkout

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.tatayab.model.responses.CreateOrderResponse
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class PaymentFragmentArgs(
  public val orderData: CreateOrderResponse
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(CreateOrderResponse::class.java)) {
      result.putParcelable("orderData", this.orderData as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(CreateOrderResponse::class.java)) {
      result.putSerializable("orderData", this.orderData as Serializable)
    } else {
      throw UnsupportedOperationException(CreateOrderResponse::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(CreateOrderResponse::class.java)) {
      result.set("orderData", this.orderData as Parcelable)
    } else if (Serializable::class.java.isAssignableFrom(CreateOrderResponse::class.java)) {
      result.set("orderData", this.orderData as Serializable)
    } else {
      throw UnsupportedOperationException(CreateOrderResponse::class.java.name +
          " must implement Parcelable or Serializable or must be an Enum.")
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): PaymentFragmentArgs {
      bundle.setClassLoader(PaymentFragmentArgs::class.java.classLoader)
      val __orderData : CreateOrderResponse?
      if (bundle.containsKey("orderData")) {
        if (Parcelable::class.java.isAssignableFrom(CreateOrderResponse::class.java) ||
            Serializable::class.java.isAssignableFrom(CreateOrderResponse::class.java)) {
          __orderData = bundle.get("orderData") as CreateOrderResponse?
        } else {
          throw UnsupportedOperationException(CreateOrderResponse::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__orderData == null) {
          throw IllegalArgumentException("Argument \"orderData\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"orderData\" is missing and does not have an android:defaultValue")
      }
      return PaymentFragmentArgs(__orderData)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): PaymentFragmentArgs {
      val __orderData : CreateOrderResponse?
      if (savedStateHandle.contains("orderData")) {
        if (Parcelable::class.java.isAssignableFrom(CreateOrderResponse::class.java) ||
            Serializable::class.java.isAssignableFrom(CreateOrderResponse::class.java)) {
          __orderData = savedStateHandle.get<CreateOrderResponse?>("orderData")
        } else {
          throw UnsupportedOperationException(CreateOrderResponse::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        if (__orderData == null) {
          throw IllegalArgumentException("Argument \"orderData\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"orderData\" is missing and does not have an android:defaultValue")
      }
      return PaymentFragmentArgs(__orderData)
    }
  }
}
