package com.tatayab.tatayab.checkout

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Boolean
import kotlin.jvm.JvmStatic

public data class SignInOptionsFragmentArgs(
  public val fromCheckout: Boolean = false
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putBoolean("fromCheckout", this.fromCheckout)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("fromCheckout", this.fromCheckout)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): SignInOptionsFragmentArgs {
      bundle.setClassLoader(SignInOptionsFragmentArgs::class.java.classLoader)
      val __fromCheckout : Boolean
      if (bundle.containsKey("fromCheckout")) {
        __fromCheckout = bundle.getBoolean("fromCheckout")
      } else {
        __fromCheckout = false
      }
      return SignInOptionsFragmentArgs(__fromCheckout)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): SignInOptionsFragmentArgs {
      val __fromCheckout : Boolean?
      if (savedStateHandle.contains("fromCheckout")) {
        __fromCheckout = savedStateHandle["fromCheckout"]
        if (__fromCheckout == null) {
          throw IllegalArgumentException("Argument \"fromCheckout\" of type boolean does not support null values")
        }
      } else {
        __fromCheckout = false
      }
      return SignInOptionsFragmentArgs(__fromCheckout)
    }
  }
}
