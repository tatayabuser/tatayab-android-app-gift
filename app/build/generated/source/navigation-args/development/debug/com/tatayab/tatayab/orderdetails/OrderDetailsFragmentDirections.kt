package com.tatayab.tatayab.orderdetails

import android.os.Bundle
import androidx.navigation.NavDirections
import com.tatayab.tatayab.R
import kotlin.Int
import kotlin.String

public class OrderDetailsFragmentDirections private constructor() {
  private data class ActionProductsList(
    public val categoryId: String?,
    public val categoryName: String?,
    public val categoryType: String? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_products_list

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("categoryType", this.categoryType)
        result.putString("categoryId", this.categoryId)
        result.putString("categoryName", this.categoryName)
        return result
      }
  }

  private data class NextProductDetails(
    public val productId: String? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.next_product_details

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("productId", this.productId)
        return result
      }
  }

  private data class DestinationOrderTracking(
    public val orderId: String?,
    public val orderDate: String?
  ) : NavDirections {
    public override val actionId: Int = R.id.destination_order_tracking

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("orderId", this.orderId)
        result.putString("orderDate", this.orderDate)
        return result
      }
  }

  private data class DestinationTrackExtOrder(
    public val url: String?
  ) : NavDirections {
    public override val actionId: Int = R.id.destination_track_ext_order

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("url", this.url)
        return result
      }
  }

  public companion object {
    public fun actionProductsList(
      categoryId: String?,
      categoryName: String?,
      categoryType: String? = null
    ): NavDirections = ActionProductsList(categoryId, categoryName, categoryType)

    public fun nextProductDetails(productId: String? = null): NavDirections =
        NextProductDetails(productId)

    public fun destinationOrderTracking(orderId: String?, orderDate: String?): NavDirections =
        DestinationOrderTracking(orderId, orderDate)

    public fun destinationTrackExtOrder(url: String?): NavDirections = DestinationTrackExtOrder(url)
  }
}
