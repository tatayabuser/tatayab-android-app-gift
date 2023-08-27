package com.tatayab.tatayab.splash

import android.os.Bundle
import androidx.navigation.NavDirections
import com.tatayab.model.home.CompositeBlockItem
import com.tatayab.model.responses.CountryResponse
import com.tatayab.tatayab.R
import kotlin.Array
import kotlin.Int
import kotlin.String

public class SplashFragmentDirections private constructor() {
  private data class ActionToHomeFragment(
    public val blocksList: Array<CompositeBlockItem>?
  ) : NavDirections {
    public override val actionId: Int = R.id.action_to_home_fragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putParcelableArray("blocksList", this.blocksList)
        return result
      }
  }

  private data class ActionToHomeFragmentWithArgList(
    public val categoryId: String?,
    public val categoryName: String?,
    public val blocksList: Array<CompositeBlockItem>?,
    public val categoryType: String? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_to_home_fragment_with_arg_list

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("categoryType", this.categoryType)
        result.putString("categoryId", this.categoryId)
        result.putString("categoryName", this.categoryName)
        result.putParcelableArray("blocksList", this.blocksList)
        return result
      }
  }

  private data class ActionToHomeFragmentWithArgProduct(
    public val blocksList: Array<CompositeBlockItem>?,
    public val productId: String? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_to_home_fragment_with_arg_product

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("productId", this.productId)
        result.putParcelableArray("blocksList", this.blocksList)
        return result
      }
  }

  private data class ActionDestinationSplashToCountryFragment(
    public val countryList: Array<CountryResponse>
  ) : NavDirections {
    public override val actionId: Int = R.id.action_destination_splash_to_countryFragment

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putParcelableArray("countryList", this.countryList)
        return result
      }
  }

  public companion object {
    public fun actionToHomeFragment(blocksList: Array<CompositeBlockItem>?): NavDirections =
        ActionToHomeFragment(blocksList)

    public fun actionToHomeFragmentWithArgList(
      categoryId: String?,
      categoryName: String?,
      blocksList: Array<CompositeBlockItem>?,
      categoryType: String? = null
    ): NavDirections = ActionToHomeFragmentWithArgList(categoryId, categoryName, blocksList,
        categoryType)

    public fun actionToHomeFragmentWithArgProduct(blocksList: Array<CompositeBlockItem>?,
        productId: String? = null): NavDirections = ActionToHomeFragmentWithArgProduct(blocksList,
        productId)

    public fun actionDestinationSplashToCountryFragment(countryList: Array<CountryResponse>):
        NavDirections = ActionDestinationSplashToCountryFragment(countryList)
  }
}
