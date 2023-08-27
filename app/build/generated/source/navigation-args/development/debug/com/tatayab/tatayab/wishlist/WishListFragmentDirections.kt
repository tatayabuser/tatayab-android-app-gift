package com.tatayab.tatayab.wishlist

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.tatayab.model.OptionsMap
import com.tatayab.tatayab.R
import kotlin.Array
import kotlin.Int
import kotlin.String

public class WishListFragmentDirections private constructor() {
  private data class NextProductDetails(
    public val productId: String? = null,
    public val optionItems: Array<OptionsMap>? = null,
    public val cartId: String? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.next_product_details

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("productId", this.productId)
        result.putParcelableArray("optionItems", this.optionItems)
        result.putString("cartId", this.cartId)
        return result
      }
  }

  private data class NextProductList(
    public val categoryType: String?,
    public val categoryId: String?,
    public val categoryName: String?
  ) : NavDirections {
    public override val actionId: Int = R.id.next_product_list

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("categoryType", this.categoryType)
        result.putString("categoryId", this.categoryId)
        result.putString("categoryName", this.categoryName)
        return result
      }
  }

  public companion object {
    public fun nextProductDetails(
      productId: String? = null,
      optionItems: Array<OptionsMap>? = null,
      cartId: String? = null
    ): NavDirections = NextProductDetails(productId, optionItems, cartId)

    public fun nextProductList(
      categoryType: String?,
      categoryId: String?,
      categoryName: String?
    ): NavDirections = NextProductList(categoryType, categoryId, categoryName)

    public fun nextCategry(): NavDirections = ActionOnlyNavDirections(R.id.next_categry)
  }
}
