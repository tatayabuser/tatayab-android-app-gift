package com.tatayab.tatayab.supplier

import android.os.Bundle
import androidx.navigation.NavDirections
import com.tatayab.tatayab.R
import kotlin.Int
import kotlin.String

public class SupplierFragmentDirections private constructor() {
  private data class NextProductsInSupplier(
    public val categoryType: String?,
    public val categoryId: String?,
    public val categoryName: String?,
    public val graphKey: String? = ""
  ) : NavDirections {
    public override val actionId: Int = R.id.next_products_in_Supplier

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("categoryType", this.categoryType)
        result.putString("categoryId", this.categoryId)
        result.putString("categoryName", this.categoryName)
        result.putString("graphKey", this.graphKey)
        return result
      }
  }

  public companion object {
    public fun nextProductsInSupplier(
      categoryType: String?,
      categoryId: String?,
      categoryName: String?,
      graphKey: String? = ""
    ): NavDirections = NextProductsInSupplier(categoryType, categoryId, categoryName, graphKey)
  }
}
