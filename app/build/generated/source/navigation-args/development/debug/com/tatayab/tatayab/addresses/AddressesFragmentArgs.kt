package com.tatayab.tatayab.addresses

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Boolean
import kotlin.jvm.JvmStatic

public data class AddressesFragmentArgs(
  public val fromCheckOut: Boolean = false
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putBoolean("fromCheckOut", this.fromCheckOut)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("fromCheckOut", this.fromCheckOut)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): AddressesFragmentArgs {
      bundle.setClassLoader(AddressesFragmentArgs::class.java.classLoader)
      val __fromCheckOut : Boolean
      if (bundle.containsKey("fromCheckOut")) {
        __fromCheckOut = bundle.getBoolean("fromCheckOut")
      } else {
        __fromCheckOut = false
      }
      return AddressesFragmentArgs(__fromCheckOut)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): AddressesFragmentArgs {
      val __fromCheckOut : Boolean?
      if (savedStateHandle.contains("fromCheckOut")) {
        __fromCheckOut = savedStateHandle["fromCheckOut"]
        if (__fromCheckOut == null) {
          throw IllegalArgumentException("Argument \"fromCheckOut\" of type boolean does not support null values")
        }
      } else {
        __fromCheckOut = false
      }
      return AddressesFragmentArgs(__fromCheckOut)
    }
  }
}
