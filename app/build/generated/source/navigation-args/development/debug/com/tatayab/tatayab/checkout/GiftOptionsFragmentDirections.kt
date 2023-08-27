package com.tatayab.tatayab.checkout

import android.os.Bundle
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.tatayab.tatayab.R
import kotlin.Boolean
import kotlin.Int

public class GiftOptionsFragmentDirections private constructor() {
  private data class ActionGiftOptionsFragmentToDestinationAddresses(
    public val fromCheckOut: Boolean = false
  ) : NavDirections {
    public override val actionId: Int = R.id.action_giftOptionsFragment_to_destination_addresses

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putBoolean("fromCheckOut", this.fromCheckOut)
        return result
      }
  }

  public companion object {
    public fun actionGiftOptionsFragmentToCheckoutFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_giftOptionsFragment_to_checkoutFragment)

    public fun actionGiftOptionsFragmentToDestinationAddresses(fromCheckOut: Boolean = false):
        NavDirections = ActionGiftOptionsFragmentToDestinationAddresses(fromCheckOut)

    public fun actionGiftOptionsFragmentToAddAddresses(): NavDirections =
        ActionOnlyNavDirections(R.id.action_giftOptionsFragment_to_add_addresses)

    public fun actionGiftOptionsFragmentToAddAddresses2(): NavDirections =
        ActionOnlyNavDirections(R.id.action_giftOptionsFragment_to_add_addresses2)

    public fun actionGiftOptionsFragmentToAddAddresses3(): NavDirections =
        ActionOnlyNavDirections(R.id.action_giftOptionsFragment_to_add_addresses3)

    public fun actionGiftOptionsFragmentToCheckout(): NavDirections =
        ActionOnlyNavDirections(R.id.action_giftOptionsFragment_to_checkout)
  }
}
