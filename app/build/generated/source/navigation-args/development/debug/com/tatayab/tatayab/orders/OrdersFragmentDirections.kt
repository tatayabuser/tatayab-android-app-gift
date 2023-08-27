package com.tatayab.tatayab.orders

import android.os.Bundle
import androidx.navigation.NavDirections
import com.tatayab.tatayab.R
import kotlin.Int
import kotlin.String

public class OrdersFragmentDirections private constructor() {
  private data class DestinationOrderDetails(
    public val orderId: String?
  ) : NavDirections {
    public override val actionId: Int = R.id.destination_order_details

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("orderId", this.orderId)
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

  public companion object {
    public fun destinationOrderDetails(orderId: String?): NavDirections =
        DestinationOrderDetails(orderId)

    public fun destinationOrderTracking(orderId: String?, orderDate: String?): NavDirections =
        DestinationOrderTracking(orderId, orderDate)
  }
}
