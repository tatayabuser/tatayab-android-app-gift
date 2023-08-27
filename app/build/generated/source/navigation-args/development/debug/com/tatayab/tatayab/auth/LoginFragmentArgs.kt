package com.tatayab.tatayab.auth

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.Int
import kotlin.jvm.JvmStatic

public data class LoginFragmentArgs(
  public val loginCode: Int
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putInt("loginCode", this.loginCode)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("loginCode", this.loginCode)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): LoginFragmentArgs {
      bundle.setClassLoader(LoginFragmentArgs::class.java.classLoader)
      val __loginCode : Int
      if (bundle.containsKey("loginCode")) {
        __loginCode = bundle.getInt("loginCode")
      } else {
        throw IllegalArgumentException("Required argument \"loginCode\" is missing and does not have an android:defaultValue")
      }
      return LoginFragmentArgs(__loginCode)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): LoginFragmentArgs {
      val __loginCode : Int?
      if (savedStateHandle.contains("loginCode")) {
        __loginCode = savedStateHandle["loginCode"]
        if (__loginCode == null) {
          throw IllegalArgumentException("Argument \"loginCode\" of type integer does not support null values")
        }
      } else {
        throw IllegalArgumentException("Required argument \"loginCode\" is missing and does not have an android:defaultValue")
      }
      return LoginFragmentArgs(__loginCode)
    }
  }
}
