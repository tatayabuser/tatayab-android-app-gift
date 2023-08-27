package com.tatayab.tatayab.splash

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.tatayab.model.responses.CountryResponse
import java.lang.IllegalArgumentException
import kotlin.Array
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class CountryFragmentArgs(
  public val countryList: Array<CountryResponse>
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putParcelableArray("countryList", this.countryList)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("countryList", this.countryList)
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("UNCHECKED_CAST","DEPRECATION")
    public fun fromBundle(bundle: Bundle): CountryFragmentArgs {
      bundle.setClassLoader(CountryFragmentArgs::class.java.classLoader)
      val __countryList : Array<CountryResponse>?
      if (bundle.containsKey("countryList")) {
        __countryList = bundle.getParcelableArray("countryList")?.map { it as CountryResponse
            }?.toTypedArray()
        if (__countryList == null) {
          throw IllegalArgumentException("Argument \"countryList\" is marked as non-null but was passed a null value.")
        }
      } else {
        throw IllegalArgumentException("Required argument \"countryList\" is missing and does not have an android:defaultValue")
      }
      return CountryFragmentArgs(__countryList)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): CountryFragmentArgs {
      val __countryList : Array<CountryResponse>?
      if (savedStateHandle.contains("countryList")) {
        __countryList = savedStateHandle.get<Array<Parcelable>>("countryList")?.map { it as
            CountryResponse }?.toTypedArray()
        if (__countryList == null) {
          throw IllegalArgumentException("Argument \"countryList\" is marked as non-null but was passed a null value")
        }
      } else {
        throw IllegalArgumentException("Required argument \"countryList\" is missing and does not have an android:defaultValue")
      }
      return CountryFragmentArgs(__countryList)
    }
  }
}
