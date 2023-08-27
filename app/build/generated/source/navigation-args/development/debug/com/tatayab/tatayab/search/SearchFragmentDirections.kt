package com.tatayab.tatayab.search

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.tatayab.tatayab.R
import kotlin.Boolean
import kotlin.Int
import kotlin.String

public class SearchFragmentDirections private constructor() {
  private data class NextActionDetails(
    public val productId: String? = null,
    public val isComeFromSearch: Boolean = false
  ) : NavDirections {
    public override val actionId: Int = R.id.next_action_details

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("productId", this.productId)
        result.putBoolean("isComeFromSearch", this.isComeFromSearch)
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
    public fun nextActionDetails(productId: String? = null, isComeFromSearch: Boolean = false):
        NavDirections = NextActionDetails(productId, isComeFromSearch)

    public fun nextProductList(
      categoryType: String?,
      categoryId: String?,
      categoryName: String?
    ): NavDirections = NextProductList(categoryType, categoryId, categoryName)

    public fun openConcierge(): NavDirections = ActionOnlyNavDirections(R.id.open_concierge)
  }
}
