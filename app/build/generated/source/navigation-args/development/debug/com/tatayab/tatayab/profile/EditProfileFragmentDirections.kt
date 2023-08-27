package com.tatayab.tatayab.profile

import androidx.navigation.ActionOnlyNavDirections
import androidx.navigation.NavDirections
import com.tatayab.tatayab.R

public class EditProfileFragmentDirections private constructor() {
  public companion object {
    public fun actionChangePassword(): NavDirections =
        ActionOnlyNavDirections(R.id.action_change_password)
  }
}
