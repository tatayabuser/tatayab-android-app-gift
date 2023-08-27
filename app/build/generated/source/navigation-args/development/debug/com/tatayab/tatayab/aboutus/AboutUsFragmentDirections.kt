package com.tatayab.tatayab.aboutus

import android.os.Bundle
import androidx.navigation.NavDirections
import com.tatayab.tatayab.R
import kotlin.Int
import kotlin.String

public class AboutUsFragmentDirections private constructor() {
  private data class NextActionPrivacy(
    public val url: String,
    public val title: String
  ) : NavDirections {
    public override val actionId: Int = R.id.next_action_privacy

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("url", this.url)
        result.putString("title", this.title)
        return result
      }
  }

  public companion object {
    public fun nextActionPrivacy(url: String, title: String): NavDirections = NextActionPrivacy(url,
        title)
  }
}
