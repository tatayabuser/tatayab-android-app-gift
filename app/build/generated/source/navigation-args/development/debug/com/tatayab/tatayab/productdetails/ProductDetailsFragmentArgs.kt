package com.tatayab.tatayab.productdetails

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.tatayab.model.OptionsMap
import com.tatayab.model.Product
import java.io.Serializable
import java.lang.IllegalArgumentException
import java.lang.UnsupportedOperationException
import kotlin.Array
import kotlin.Boolean
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class ProductDetailsFragmentArgs(
  public val productId: String?,
  public val productUID: String? = "",
  public val optionItems: Array<OptionsMap>? = null,
  public val isComeFromSearch: Boolean = false,
  public val productObject: Product? = null
) : NavArgs {
  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("productId", this.productId)
    result.putString("productUID", this.productUID)
    result.putParcelableArray("optionItems", this.optionItems)
    result.putBoolean("isComeFromSearch", this.isComeFromSearch)
    if (Parcelable::class.java.isAssignableFrom(Product::class.java)) {
      result.putParcelable("productObject", this.productObject as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Product::class.java)) {
      result.putSerializable("productObject", this.productObject as Serializable?)
    }
    return result
  }

  @Suppress("CAST_NEVER_SUCCEEDS")
  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("productId", this.productId)
    result.set("productUID", this.productUID)
    result.set("optionItems", this.optionItems)
    result.set("isComeFromSearch", this.isComeFromSearch)
    if (Parcelable::class.java.isAssignableFrom(Product::class.java)) {
      result.set("productObject", this.productObject as Parcelable?)
    } else if (Serializable::class.java.isAssignableFrom(Product::class.java)) {
      result.set("productObject", this.productObject as Serializable?)
    }
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("UNCHECKED_CAST","DEPRECATION")
    public fun fromBundle(bundle: Bundle): ProductDetailsFragmentArgs {
      bundle.setClassLoader(ProductDetailsFragmentArgs::class.java.classLoader)
      val __productId : String?
      if (bundle.containsKey("productId")) {
        __productId = bundle.getString("productId")
      } else {
        throw IllegalArgumentException("Required argument \"productId\" is missing and does not have an android:defaultValue")
      }
      val __productUID : String?
      if (bundle.containsKey("productUID")) {
        __productUID = bundle.getString("productUID")
      } else {
        __productUID = ""
      }
      val __optionItems : Array<OptionsMap>?
      if (bundle.containsKey("optionItems")) {
        __optionItems = bundle.getParcelableArray("optionItems")?.map { it as OptionsMap
            }?.toTypedArray()
      } else {
        __optionItems = null
      }
      val __isComeFromSearch : Boolean
      if (bundle.containsKey("isComeFromSearch")) {
        __isComeFromSearch = bundle.getBoolean("isComeFromSearch")
      } else {
        __isComeFromSearch = false
      }
      val __productObject : Product?
      if (bundle.containsKey("productObject")) {
        if (Parcelable::class.java.isAssignableFrom(Product::class.java) ||
            Serializable::class.java.isAssignableFrom(Product::class.java)) {
          __productObject = bundle.get("productObject") as Product?
        } else {
          throw UnsupportedOperationException(Product::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __productObject = null
      }
      return ProductDetailsFragmentArgs(__productId, __productUID, __optionItems,
          __isComeFromSearch, __productObject)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        ProductDetailsFragmentArgs {
      val __productId : String?
      if (savedStateHandle.contains("productId")) {
        __productId = savedStateHandle["productId"]
      } else {
        throw IllegalArgumentException("Required argument \"productId\" is missing and does not have an android:defaultValue")
      }
      val __productUID : String?
      if (savedStateHandle.contains("productUID")) {
        __productUID = savedStateHandle["productUID"]
      } else {
        __productUID = ""
      }
      val __optionItems : Array<OptionsMap>?
      if (savedStateHandle.contains("optionItems")) {
        __optionItems = savedStateHandle.get<Array<Parcelable>>("optionItems")?.map { it as
            OptionsMap }?.toTypedArray()
      } else {
        __optionItems = null
      }
      val __isComeFromSearch : Boolean?
      if (savedStateHandle.contains("isComeFromSearch")) {
        __isComeFromSearch = savedStateHandle["isComeFromSearch"]
        if (__isComeFromSearch == null) {
          throw IllegalArgumentException("Argument \"isComeFromSearch\" of type boolean does not support null values")
        }
      } else {
        __isComeFromSearch = false
      }
      val __productObject : Product?
      if (savedStateHandle.contains("productObject")) {
        if (Parcelable::class.java.isAssignableFrom(Product::class.java) ||
            Serializable::class.java.isAssignableFrom(Product::class.java)) {
          __productObject = savedStateHandle.get<Product?>("productObject")
        } else {
          throw UnsupportedOperationException(Product::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
      } else {
        __productObject = null
      }
      return ProductDetailsFragmentArgs(__productId, __productUID, __optionItems,
          __isComeFromSearch, __productObject)
    }
  }
}
