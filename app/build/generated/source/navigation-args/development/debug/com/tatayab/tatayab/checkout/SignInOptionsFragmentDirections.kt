package com.tatayab.tatayab.checkout

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.tatayab.model.requests.AddressRequest
import com.tatayab.tatayab.R
import java.io.Serializable
import kotlin.Boolean
import kotlin.Int
import kotlin.Suppress

public class SignInOptionsFragmentDirections private constructor() {
  private data class ActionAddAddress(
    public val address: AddressRequest? = null,
    public val isgust: Boolean = false,
    public val fromcheckout: Boolean = false
  ) : NavDirections {
    public override val actionId: Int = R.id.action_add_Address

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

  public companion object {
    public fun actionAddAddress(
      address: AddressRequest? = null,
      isgust: Boolean = false,
      fromcheckout: Boolean = false
    ): NavDirections = ActionAddAddress(address, isgust, fromcheckout)

    public fun updateProfileAction(): NavDirections =
        ActionOnlyNavDirections(R.id.update_profile_action)
  }
}
