package com.tatayab.tatayab.productlist

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class ProductListFragmentArgs(
  public val categoryType: String?,
  public val categoryId: String?,
  public val categoryName: String?,
  public val graphKey: String? = ""
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("categoryType", this.categoryType)
    result.putString("categoryId", this.categoryId)
    result.putString("categoryName", this.categoryName)
    result.putString("graphKey", this.graphKey)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("categoryType", this.categoryType)
    result.set("categoryId", this.categoryId)
    result.set("categoryName", this.categoryName)
    result.set("graphKey", this.graphKey)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ProductListFragmentArgs {
      bundle.setClassLoader(ProductListFragmentArgs::class.java.classLoader)
      val __categoryType : String?
      if (bundle.containsKey("categoryType")) {
        __categoryType = bundle.getString("categoryType")
      } else {
        throw IllegalArgumentException("Required argument \"categoryType\" is missing and does not have an android:defaultValue")
      }
      val __categoryId : String?
      if (bundle.containsKey("categoryId")) {
        __categoryId = bundle.getString("categoryId")
      } else {
        throw IllegalArgumentException("Required argument \"categoryId\" is missing and does not have an android:defaultValue")
      }
      val __categoryName : String?
      if (bundle.containsKey("categoryName")) {
        __categoryName = bundle.getString("categoryName")
      } else {
        throw IllegalArgumentException("Required argument \"categoryName\" is missing and does not have an android:defaultValue")
      }
      val __graphKey : String?
      if (bundle.containsKey("graphKey")) {
        __graphKey = bundle.getString("graphKey")
      } else {
        __graphKey = ""
      }
      return ProductListFragmentArgs(__categoryType, __categoryId, __categoryName, __graphKey)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): ProductListFragmentArgs {
      val __categoryType : String?
      if (savedStateHandle.contains("categoryType")) {
        __categoryType = savedStateHandle["categoryType"]
      } else {
        throw IllegalArgumentException("Required argument \"categoryType\" is missing and does not have an android:defaultValue")
      }
      val __categoryId : String?
      if (savedStateHandle.contains("categoryId")) {
        __categoryId = savedStateHandle["categoryId"]
      } else {
        throw IllegalArgumentException("Required argument \"categoryId\" is missing and does not have an android:defaultValue")
      }
      val __categoryName : String?
      if (savedStateHandle.contains("categoryName")) {
        __categoryName = savedStateHandle["categoryName"]
      } else {
        throw IllegalArgumentException("Required argument \"categoryName\" is missing and does not have an android:defaultValue")
      }
      val __graphKey : String?
      if (savedStateHandle.contains("graphKey")) {
        __graphKey = savedStateHandle["graphKey"]
      } else {
        __graphKey = ""
      }
      return ProductListFragmentArgs(__categoryType, __categoryId, __categoryName, __graphKey)
    }
  }
}
