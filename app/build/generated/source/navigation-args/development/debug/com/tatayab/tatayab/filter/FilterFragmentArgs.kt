package com.tatayab.tatayab.filter

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import java.lang.IllegalArgumentException
import kotlin.String
import kotlin.jvm.JvmStatic

public data class FilterFragmentArgs(
  public val categoryType: String?,
  public val categoryId: String?,
  public val graphKey: String? = ""
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("categoryType", this.categoryType)
    result.putString("categoryId", this.categoryId)
    result.putString("graphKey", this.graphKey)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("categoryType", this.categoryType)
    result.set("categoryId", this.categoryId)
    result.set("graphKey", this.graphKey)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): FilterFragmentArgs {
      bundle.setClassLoader(FilterFragmentArgs::class.java.classLoader)
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
      val __graphKey : String?
      if (bundle.containsKey("graphKey")) {
        __graphKey = bundle.getString("graphKey")
      } else {
        __graphKey = ""
      }
      return FilterFragmentArgs(__categoryType, __categoryId, __graphKey)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): FilterFragmentArgs {
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
      val __graphKey : String?
      if (savedStateHandle.contains("graphKey")) {
        __graphKey = savedStateHandle["graphKey"]
      } else {
        __graphKey = ""
      }
      return FilterFragmentArgs(__categoryType, __categoryId, __graphKey)
    }
  }
}
