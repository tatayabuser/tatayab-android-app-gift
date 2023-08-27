package com.tatayab.tatayab.filter

import android.os.Bundle
import androidx.navigation.NavDirections
import com.tatayab.model.filter.ChildData
import com.tatayab.tatayab.R
import kotlin.Array
import kotlin.Int
import kotlin.String

public class FilterFragmentDirections private constructor() {
  private data class ActionToFilterOptions(
    public val categoryType: String?,
    public val categoryId: String?,
    public val parentIndex: String?,
    public val parentTitle: String?,
    public val optionItems: Array<ChildData>? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_to_filterOptions

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("categoryType", this.categoryType)
        result.putString("categoryId", this.categoryId)
        result.putString("parentIndex", this.parentIndex)
        result.putParcelableArray("optionItems", this.optionItems)
        result.putString("parentTitle", this.parentTitle)
        return result
      }
  }

  public companion object {
    public fun actionToFilterOptions(
      categoryType: String?,
      categoryId: String?,
      parentIndex: String?,
      parentTitle: String?,
      optionItems: Array<ChildData>? = null
    ): NavDirections = ActionToFilterOptions(categoryType, categoryId, parentIndex, parentTitle,
        optionItems)
  }
}
