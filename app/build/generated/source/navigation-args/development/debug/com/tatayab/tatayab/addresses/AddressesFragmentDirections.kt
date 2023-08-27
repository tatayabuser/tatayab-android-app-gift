package com.tatayab.tatayab.addresses

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.tatayab.model.requests.AddressRequest
import com.tatayab.tatayab.R
import java.io.Serializable
import kotlin.Int
import kotlin.Suppress

public class AddressesFragmentDirections private constructor() {
  private data class NextAction(
    public val address: AddressRequest? = null
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
        return result
      }
  }

  public companion object {
    public fun nextAction(address: AddressRequest? = null): NavDirections = NextAction(address)

    public fun actionDestinationAddressesToGiftOptionsFragment(): NavDirections =
        ActionOnlyNavDirections(R.id.action_destination_addresses_to_giftOptionsFragment)
  }
}
