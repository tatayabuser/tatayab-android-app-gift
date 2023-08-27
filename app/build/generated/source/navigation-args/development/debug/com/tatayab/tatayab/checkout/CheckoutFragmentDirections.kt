package com.tatayab.tatayab.checkout

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.tatayab.model.requests.AddressRequest
import com.tatayab.model.responses.CreateOrderResponse
import com.tatayab.tatayab.R
import java.io.Serializable
import java.lang.UnsupportedOperationException
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress

public class CheckoutFragmentDirections private constructor() {
  private data class NextLoginOptions(
    public val fromCheckout: Boolean = false
  ) : NavDirections {
    public override val actionId: Int = R.id.next_login_options

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putBoolean("fromCheckout", this.fromCheckout)
        return result
      }
  }

  private data class NextChangeAdress(
    public val fromCheckOut: Boolean = true
  ) : NavDirections {
    public override val actionId: Int = R.id.next_change_Adress

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putBoolean("fromCheckOut", this.fromCheckOut)
        return result
      }
  }

  private data class NextAction(
    public val address: AddressRequest? = null,
    public val isgust: Boolean = false,
    public val fromcheckout: Boolean = false
  ) : NavDirections {
    public override val actionId: Int = R.id.next_action

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(AddressRequest::class.java)) {
          result.putParcelable("address", this.address as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(AddressRequest::class.java)) {
          result.putSerializable("address", this.address as Serializable?)
        }
        result.putBoolean("isgust", this.isgust)
        result.putBoolean("fromcheckout", this.fromcheckout)
        return result
      }
  }

  private data class OrderSuccessAction(
    public val orderId: String?,
    public val deliveryTime: String? = null,
    public val amount: String? = null,
    public val totalUserOrders: String? = "0",
    public val paymentStatus: Boolean = false
  ) : NavDirections {
    public override val actionId: Int = R.id.order_success_action

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("orderId", this.orderId)
        result.putString("deliveryTime", this.deliveryTime)
        result.putString("amount", this.amount)
        result.putString("totalUserOrders", this.totalUserOrders)
        result.putBoolean("paymentStatus", this.paymentStatus)
        return result
      }
  }

  private data class OrderPayment(
    public val orderData: CreateOrderResponse
  ) : NavDirections {
    public override val actionId: Int = R.id.order_payment

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        if (Parcelable::class.java.isAssignableFrom(CreateOrderResponse::class.java)) {
          result.putParcelable("orderData", this.orderData as Parcelable)
        } else if (Serializable::class.java.isAssignableFrom(CreateOrderResponse::class.java)) {
          result.putSerializable("orderData", this.orderData as Serializable)
        } else {
          throw UnsupportedOperationException(CreateOrderResponse::class.java.name +
              " must implement Parcelable or Serializable or must be an Enum.")
        }
        return result
      }
  }

  public companion object {
    public fun nextLoginOptions(fromCheckout: Boolean = false): NavDirections =
        NextLoginOptions(fromCheckout)

    public fun nextChangeAdress(fromCheckOut: Boolean = true): NavDirections =
        NextChangeAdress(fromCheckOut)

    public fun nextAction(
      address: AddressRequest? = null,
      isgust: Boolean = false,
      fromcheckout: Boolean = false
    ): NavDirections = NextAction(address, isgust, fromcheckout)

    public fun orderSuccessAction(
      orderId: String?,
      deliveryTime: String? = null,
      amount: String? = null,
      totalUserOrders: String? = "0",
      paymentStatus: Boolean = false
    ): NavDirections = OrderSuccessAction(orderId, deliveryTime, amount, totalUserOrders,
        paymentStatus)

    public fun orderPayment(orderData: CreateOrderResponse): NavDirections = OrderPayment(orderData)
  }
}
