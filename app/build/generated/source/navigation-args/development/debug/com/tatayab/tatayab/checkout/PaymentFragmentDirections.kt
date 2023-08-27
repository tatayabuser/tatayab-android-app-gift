package com.tatayab.tatayab.checkout

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.tatayab.model.KnetData
import com.tatayab.tatayab.R
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress

public class PaymentFragmentDirections private constructor() {
  private data class OrderSuccessAction(
    public val orderId: String?,
    public val knetData: KnetData?,
    public val amount: String? = null,
    public val paymentStatus: Boolean = false
  ) : NavDirections {
    public override val actionId: Int = R.id.order_success_action

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        result.putString("orderId", this.orderId)
        if (Parcelable::class.java.isAssignableFrom(KnetData::class.java)) {
          result.putParcelable("knetData", this.knetData as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(KnetData::class.java)) {
          result.putSerializable("knetData", this.knetData as Serializable?)
        } else {
          throw UnsupportedOperationException(KnetData::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        result.putString("amount", this.amount)
        result.putBoolean("paymentStatus", this.paymentStatus)
        return result
      }
  }

  public companion object {
    public fun orderSuccessAction(
      orderId: String?,
      knetData: KnetData?,
      amount: String? = null,
      paymentStatus: Boolean = false
    ): NavDirections = OrderSuccessAction(orderId, knetData, amount, paymentStatus)
  }
}
