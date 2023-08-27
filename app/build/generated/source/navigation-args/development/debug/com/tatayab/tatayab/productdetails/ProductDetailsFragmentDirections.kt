package com.tatayab.tatayab.productdetails

import android.os.Bundle
import android.os.Parcelable
import androidx.navigation.NavDirections
import com.tatayab.model.OptionsMap
import com.tatayab.model.Product
import com.tatayab.tatayab.R
import java.io.Serializable
import kotlin.Array
import kotlin.Boolean
import kotlin.Int
import kotlin.String
import kotlin.Suppress

public class ProductDetailsFragmentDirections private constructor() {
  private data class NextReviewslistAction(
    public val productId: String? = null,
    public val productName: String? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.next_reviewslist_action

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("productId", this.productId)
        result.putString("productName", this.productName)
        return result
      }
  }

  private data class NextAddReviewAction(
    public val productId: String? = null,
    public val productName: String? = null,
    public val productImage: String? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.next_add_review_action

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("productId", this.productId)
        result.putString("productName", this.productName)
        result.putString("productImage", this.productImage)
        return result
      }
  }

  private data class ActionDestinationProductdetailsToProductsList(
    public val categoryType: String?,
    public val categoryId: String?,
    public val categoryName: String? = " ",
    public val graphKey: String? = ""
  ) : NavDirections {
    public override val actionId: Int = R.id.action_destination_productdetails_to_products_list

    public override val arguments: Bundle
      get() {
        val result = Bundle()
        result.putString("categoryType", this.categoryType)
        result.putString("categoryId", this.categoryId)
        result.putString("categoryName", this.categoryName)
        result.putString("graphKey", this.graphKey)
        return result
      }
  }

  private data class ActionDestinationProductdetailsSelf(
    public val productId: String?,
    public val productUID: String? = "",
    public val optionItems: Array<OptionsMap>? = null,
    public val isComeFromSearch: Boolean = false,
    public val productObject: Product? = null
  ) : NavDirections {
    public override val actionId: Int = R.id.action_destination_productdetails_self

    public override val arguments: Bundle
      @Suppress("CAST_NEVER_SUCCEEDS")
      get() {
        val result = Bundle()
        result.putString("productId", this.productId)
        result.putString("productUID", this.productUID)
        result.putParcelableArray("optionItems", this.optionItems)
        result.putBoolean("isComeFromSearch", this.isComeFromSearch)
        if (Parcelable::class.java.isAssignableFrom(Product::class.java)) {
          result.putParcelable("productObject", this.productObject as Parcelable?)
        } else if (Serializable::class.java.isAssignableFrom(Product::class.java)) {
          result.putSerializable("productObject", this.productObject as Serializable?)
        }
        return result
      }
  }

  public companion object {
    public fun nextReviewslistAction(productId: String? = null, productName: String? = null):
        NavDirections = NextReviewslistAction(productId, productName)

    public fun nextAddReviewAction(
      productId: String? = null,
      productName: String? = null,
      productImage: String? = null
    ): NavDirections = NextAddReviewAction(productId, productName, productImage)

    public fun actionDestinationProductdetailsToProductsList(
      categoryType: String?,
      categoryId: String?,
      categoryName: String? = " ",
      graphKey: String? = ""
    ): NavDirections = ActionDestinationProductdetailsToProductsList(categoryType, categoryId,
        categoryName, graphKey)

    public fun actionDestinationProductdetailsSelf(
      productId: String?,
      productUID: String? = "",
      optionItems: Array<OptionsMap>? = null,
      isComeFromSearch: Boolean = false,
      productObject: Product? = null
    ): NavDirections = ActionDestinationProductdetailsSelf(productId, productUID, optionItems,
        isComeFromSearch, productObject)
  }
}
