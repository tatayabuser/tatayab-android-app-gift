package com.tatayab.tatayab.productlist

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.tatayab.tatayab.R
import kotlin.Int
import kotlin.String

public class ProductListFragmentDirections private constructor() {
  private data class NextAction(
    public val productId: String? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.next_action

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("productId", this.productId)
        return result
      }
  }

  private data class ActionFilter(
    public val categoryType: String?,
    public val categoryId: String?,
    public val graphKey: String? = ""
  ) : NavDirections {
    public override val actionId: Int = R.id.action_filter

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("categoryType", this.categoryType)
        result.putString("categoryId", this.categoryId)
        result.putString("graphKey", this.graphKey)
        return result
      }
  }

  public companion object {
    public fun nextAction(productId: String? = null): NavDirections = NextAction(productId)

    public fun actionSort(): NavDirections = ActionOnlyNavDirections(R.id.action_sort)

    public fun actionFilter(
      categoryType: String?,
      categoryId: String?,
      graphKey: String? = ""
    ): NavDirections = ActionFilter(categoryType, categoryId, graphKey)
  }
}
