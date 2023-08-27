package com.tatayab.tatayab.productreviews

import android.os.Bundle
import androidx.lifecycle.SavedStateHandle
import androidx.navigation.NavArgs
import kotlin.String
import kotlin.jvm.JvmStatic

public data class ProductReviewsFragmentArgs(
  public val productId: String? = null,
  public val productName: String? = null
) : NavArgs {
  public fun toBundle(): Bundle {
    val result = Bundle()
    result.putString("productId", this.productId)
    result.putString("productName", this.productName)
    return result
  }

  public fun toSavedStateHandle(): SavedStateHandle {
    val result = SavedStateHandle()
    result.set("productId", this.productId)
    result.set("productName", this.productName)
    return result
  }

  public companion object {
    @JvmStatic
    public fun fromBundle(bundle: Bundle): ProductReviewsFragmentArgs {
      bundle.setClassLoader(ProductReviewsFragmentArgs::class.java.classLoader)
      val __productId : String?
      if (bundle.containsKey("productId")) {
        __productId = bundle.getString("productId")
      } else {
        __productId = null
      }
      val __productName : String?
      if (bundle.containsKey("productName")) {
        __productName = bundle.getString("productName")
      } else {
        __productName = null
      }
      return ProductReviewsFragmentArgs(__productId, __productName)
    }

    @JvmStatic
    public fun fromSavedStateHandle(savedStateHandle: SavedStateHandle):
        ProductReviewsFragmentArgs {
      val __productId : String?
      if (savedStateHandle.contains("productId")) {
        __productId = savedStateHandle["productId"]
      } else {
        __productId = null
      }
      val __productName : String?
      if (savedStateHandle.contains("productName")) {
        __productName = savedStateHandle["productName"]
      } else {
        __productName = null
      }
      return ProductReviewsFragmentArgs(__productId, __productName)
    }
  }
}
