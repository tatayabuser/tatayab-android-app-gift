package com.tatayab.tatayab.addresses

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.tatayab.model.requests.AddressRequest
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Boolean
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class AddAddressFragmentArgs(
  public val address: AddressRequest? = null,
  public val isgust: Boolean = false,
  public val fromcheckout: Boolean = false
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    if (Parcelable::class.java.isAssignableFrom(AddressRequest::class.java)) {
      result.putParcelable("address", this.address as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(AddressRequest::class.java)) {
      result.putSerializable("address", this.address as Serializable?)
    }
    result.putBoolean("isgust", this.isgust)
    result.putBoolean("fromcheckout", this.fromcheckout)
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    if (Parcelable::class.java.isAssignableFrom(AddressRequest::class.java)) {
      result.set("address", this.address as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(AddressRequest::class.java)) {
      result.set("address", this.address as Serializable?)
    }
    result.set("isgust", this.isgust)
    result.set("fromcheckout", this.fromcheckout)
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("DEPRECATION")
    public fun fromBundle(bundle: Bundle): AddAddressFragmentArgs {
      bundle.setClassLoader(AddAddressFragmentArgs::class.java.classLoader)
      val __address : AddressRequest?
      if (bundle.containsKey("address")) {
        if (Parcelable::class.java.isAssignableFrom(AddressRequest::class.java) ||
            Serializable::class.java.isAssignableFrom(AddressRequest::class.java)) {
          __address = bundle.get("address") as AddressRequest?
        } else {
          throw UnsupportedOperationException(AddressRequest::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __address = null
      }
      val __isgust : Boolean
      if (bundle.containsKey("isgust")) {
        __isgust = bundle.getBoolean("isgust")
      } else {
        __isgust = false
      }
      val __fromcheckout : Boolean
      if (bundle.containsKey("fromcheckout")) {
        __fromcheckout = bundle.getBoolean("fromcheckout")
      } else {
        __fromcheckout = false
      }
      return AddAddressFragmentArgs(__address, __isgust, __fromcheckout)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): AddAddressFragmentArgs {
      val __address : AddressRequest?
      if (savedStateHandle.contains("address")) {
        if (Parcelable::class.java.isAssignableFrom(AddressRequest::class.java) ||
            Serializable::class.java.isAssignableFrom(AddressRequest::class.java)) {
          __address = savedStateHandle.get<AddressRequest?>("address")
        } else {
          throw UnsupportedOperationException(AddressRequest::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __address = null
      }
      val __isgust : Boolean?
      if (savedStateHandle.contains("isgust")) {
        __isgust = savedStateHandle["isgust"]
        if (__isgust == null) {
          throw IllegalArgumentException("Argument \"isgust\" of type boolean does not support null values")
        }
      } else {
        __isgust = false
      }
      val __fromcheckout : Boolean?
      if (savedStateHandle.contains("fromcheckout")) {
        __fromcheckout = savedStateHandle["fromcheckout"]
        if (__fromcheckout == null) {
          throw IllegalArgumentException("Argument \"fromcheckout\" of type boolean does not support null values")
        }
      } else {
        __fromcheckout = false
      }
      return AddAddressFragmentArgs(__address, __isgust, __fromcheckout)
    }
  }
}
