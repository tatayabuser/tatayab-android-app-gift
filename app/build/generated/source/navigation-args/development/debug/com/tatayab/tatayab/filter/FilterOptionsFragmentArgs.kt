package com.tatayab.tatayab.filter

import android.os.Bundle
import android.os.Parcelable
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import com.tatayab.model.filter.ChildData
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.jvm.JvmStatic

public data class FilterOptionsFragmentArgs(
  public val categoryType: String? = null,
  public val parentIndex: String? = null,
  public val categoryId: String? = null,
  public val optionItems: Array<ChildData>? = null,
  public val parentTitle: String? = null
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("categoryType", this.categoryType)
    result.putString("parentIndex", this.parentIndex)
    result.putString("categoryId", this.categoryId)
    result.putParcelableArray("optionItems", this.optionItems)
    result.putString("parentTitle", this.parentTitle)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("categoryType", this.categoryType)
    result.set("parentIndex", this.parentIndex)
    result.set("categoryId", this.categoryId)
    result.set("optionItems", this.optionItems)
    result.set("parentTitle", this.parentTitle)
    return result
  }

  public companion object {
    @JvmStatic
    @Suppress("UNCHECKED_CAST","DEPRECATION")
    public fun fromBundle(bundle: Bundle): FilterOptionsFragmentArgs {
      bundle.setClassLoader(FilterOptionsFragmentArgs::class.java.classLoader)
      val __categoryType : String?
      if (bundle.containsKey("categoryType")) {
        __categoryType = bundle.getString("categoryType")
      } else {
        __categoryType = null
      }
      val __parentIndex : String?
      if (bundle.containsKey("parentIndex")) {
        __parentIndex = bundle.getString("parentIndex")
      } else {
        __parentIndex = null
      }
      val __categoryId : String?
      if (bundle.containsKey("categoryId")) {
        __categoryId = bundle.getString("categoryId")
      } else {
        __categoryId = null
      }
      val __optionItems : Array<ChildData>?
      if (bundle.containsKey("optionItems")) {
        __optionItems = bundle.getParcelableArray("optionItems")?.map { it as ChildData
            }?.toTypedArray()
      } else {
        __optionItems = null
      }
      val __parentTitle : String?
      if (bundle.containsKey("parentTitle")) {
        __parentTitle = bundle.getString("parentTitle")
      } else {
        __parentTitle = null
      }
      return FilterOptionsFragmentArgs(__categoryType, __parentIndex, __categoryId, __optionItems,
          __parentTitle)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle): FilterOptionsFragmentArgs {
      val __categoryType : String?
      if (savedStateHandle.contains("categoryType")) {
        __categoryType = savedStateHandle["categoryType"]
      } else {
        __categoryType = null
      }
      val __parentIndex : String?
      if (savedStateHandle.contains("parentIndex")) {
        __parentIndex = savedStateHandle["parentIndex"]
      } else {
        __parentIndex = null
      }
      val __categoryId : String?
      if (savedStateHandle.contains("categoryId")) {
        __categoryId = savedStateHandle["categoryId"]
      } else {
        __categoryId = null
      }
      val __optionItems : Array<ChildData>?
      if (savedStateHandle.contains("optionItems")) {
        __optionItems = savedStateHandle.get<Array<Parcelable>>("optionItems")?.map { it as
            ChildData }?.toTypedArray()
      } else {
        __optionItems = null
      }
      val __parentTitle : String?
      if (savedStateHandle.contains("parentTitle")) {
        __parentTitle = savedStateHandle["parentTitle"]
      } else {
        __parentTitle = null
      }
      return FilterOptionsFragmentArgs(__categoryType, __parentIndex, __categoryId, __optionItems,
          __parentTitle)
    }
  }
}
