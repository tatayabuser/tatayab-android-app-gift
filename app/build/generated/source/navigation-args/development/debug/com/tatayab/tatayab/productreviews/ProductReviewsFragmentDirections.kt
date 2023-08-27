package com.tatayab.tatayab.productreviews

import android.os.Bundle
import androidx.navigation.NavDirections
import com.tatayab.tatayab.R
import kotlin.Int
import kotlin.String

public class ProductReviewsFragmentDirections private constructor() {
  private data class NextAddReviewAction(
    public val productId: String? = null,
    public val productName: String? = null,
    public val productImage: String? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.next_add_review_action

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("productId", this.productId)
        result.putString("productName", this.productName)
        result.putString("productImage", this.productImage)
        return result
      }
  }

  public companion object {
    public fun nextAddReviewAction(
      productId: String? = null,
      productName: String? = null,
      productImage: String? = null
    ): NavDirections = NextAddReviewAction(productId, productName, productImage)
  }
}
