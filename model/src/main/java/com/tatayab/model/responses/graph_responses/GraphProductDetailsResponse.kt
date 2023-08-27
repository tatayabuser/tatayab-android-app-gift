package com.tatayab.model.responses.graph_responses

import android.os.Parcelable
import com.google.gson.Gson
import com.google.gson.annotations.SerializedName
import com.tatayab.model.Icon
import com.tatayab.model.ImagePair
import com.tatayab.model.Variant
import com.tatayab.model.responses.ProductOptions
import com.tatayab.model.responses.ProductSpecific
import kotlinx.android.parcel.Parcelize
@Parcelize
class GraphProductDetailsResponse(@SerializedName("data") val productData: GraphProductDetailsDataResponse) :
    Parcelable

@Parcelize
class GraphProductDetailsDataResponse(@SerializedName("products") val products: GraphProductListDataResponse) :
    Parcelable

@Parcelize
class GraphProductListDataResponse(@SerializedName("items") val items: List<ProductData>) :
    Parcelable

@Parcelize
class ProductData(
    val uid: String,
    val source: String,
    val name: String,
    val sku: String,
    val id: String,
    val url_key: String,
    val url_suffix: String,
    val manufacturer: String,
    val review_count: Float,
    val reviews: ProductReviews,
    @SerializedName("items") val options: List<GraphProductOption>?,
    val dynamicAttributes: String,
    val image: GraphCategoryProductsResponse.Image,
    val small_image: GraphCategoryProductsResponse.Image,
    val media_gallery: List<GraphCategoryProductsResponse.Image>,
    val shipping_details: List<GraphProductShipping>,
    val description: ProductDescription,
    val stock_status: String,
    val price_range: ProductPriceRange,
    val top_notes: String
) : Parcelable {


    fun getSpecifications(dynamicAttributes: String): ArrayList<ProductSpecific> {
        val gson = Gson()
        val specific = ArrayList<ProductSpecific>()
        val gsonObject =
            gson.fromJson<ProductDynamicAttributes>(
                dynamicAttributes,
                ProductDynamicAttributes::class.java
            )
        if (gsonObject.color != null)
            specific.add(
                ProductSpecific(
                    productSpecificType = GraphProductSpecificationsEnum.PRODUCT_COLOR,
                    value = gsonObject.color_label
                )
            )
        if (gsonObject.gender != null)
            specific.add(
                ProductSpecific(
                    productSpecificType = GraphProductSpecificationsEnum.PRODUCT_GENDER,
                    value = gsonObject.gender_label
                )
            )
        if (gsonObject.size != null)
            specific.add(
                ProductSpecific(
                    productSpecificType = GraphProductSpecificationsEnum.PRODUCT_SIZE,
                    value = gsonObject.size_label
                )
            )
        if (gsonObject.manufacturer != null)
            specific.add(
                ProductSpecific(
                    productSpecificType = GraphProductSpecificationsEnum.PRODUCT_SUPPLIER,
                    value = gsonObject.manufacturer_label
                )
            )
        if (gsonObject.type != null)
            specific.add(
                ProductSpecific(
                    productSpecificType = GraphProductSpecificationsEnum.PRODUCT_TYPE,
                    value = gsonObject.type_label
                )
            )

        return specific
    }

    fun getProductOptions(options: List<GraphProductOption>?): ArrayList<ProductOptions> {
        val productOptionsResponse = ArrayList<ProductOptions>()
        options?.forEach {
            productOptionsResponse.add(
                ProductOptions(option_name = it.title, variants = it.options.map {
                    Variant(
                        variant_name = it.label,
                        variant_image = it.product.image.url,
                        variant_id = it.id.toString(),
                        image_pair = ImagePair(icon = Icon(imagePath = it.product.image.url))
                    )
                } as ArrayList<Variant>, option_id = it.option_id.toString()
                )
            )
        }
        return productOptionsResponse
    }

    fun getProductSource(product: ProductData): String? {
        product?.options?.forEach {
            it?.options?.map {
                return it?.product?.source.toString()
            }
        }
        return product?.source
    }

    @Parcelize
    class GraphProductShipping(
        val shipping_title: String,
        val delivery_from: String,
        val delivery_from_str: String,
        val delivery_to: String,
        val delivery_to_str: String,
        val source_code: String
    ) : Parcelable

    @Parcelize
    class ProductReviews(
        val items: List<ReviewsItem>
    ) : Parcelable

    @Parcelize
    class ReviewsItem(
        val nickname: String,
        val summary: String,
        val average_rating: Float
    ) : Parcelable

    @Parcelize
    class ProductPriceRange(
        val minimum_price: ProductPriceInfo
    ) : Parcelable

    @Parcelize
    class ProductPriceInfo(
        var discount: ProductDiscount,
        var final_price: ProductPrice,
        var regular_price: ProductPrice
    ) : Parcelable

    @Parcelize
    class ProductPrice(
        var value: Float,
        var currency: String
    ) : Parcelable

    @Parcelize
    class ProductDiscount(
        val amount_off: Float?=0f,
        val percent_off: Float?=0f
    ) : Parcelable

    @Parcelize
    class ProductDescription(
        val html: String
    ) : Parcelable

    class DynamicAttributes(
        val manufacturer_label: String
    )

    @Parcelize
    data class GraphProductOption(
        val option_id: Int,
        val title: String,
        val options: List<GraphProductOptionVariant>
    ) : Parcelable


    @Parcelize
    data class GraphProductOptionVariant(
        val id: Int,
        val image: String,
        val product: VariantProduct,
        val label: String
    ) : Parcelable

    @Parcelize
    class VariantProduct(
        val sku: String,
        val source: String,
        val image: GraphCategoryProductsResponse.Image
    ) : Parcelable

    @Parcelize
    class ProductDynamicAttributes(
        val manufacturer_label: String?,
        val manufacturer: String?,
        val gender: String?,
        val gender_label: String?,
        val size: String?,
        val size_label: String,
        val color: String?,
        val color_label: String?,
        val type: String?,
        val type_label: String?
    ) : Parcelable
}