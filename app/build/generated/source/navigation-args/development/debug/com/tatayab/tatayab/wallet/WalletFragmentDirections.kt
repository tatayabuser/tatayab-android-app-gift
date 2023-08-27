package com.tatayab.tatayab.wallet

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.tatayab.tatayab.R

public class WalletFragmentDirections private constructor() {
  public companion object {
    public fun nextActionTransaction(): NavDirections =
        ActionOnlyNavDirections(R.id.next_action_transaction)
  }
}
